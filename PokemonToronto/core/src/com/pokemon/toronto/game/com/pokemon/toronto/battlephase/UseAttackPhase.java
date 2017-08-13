package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/1/2017.
 */

public class UseAttackPhase extends BattlePhase {
    protected final boolean PLAYER_SIDE_ANIMATION = true;
    protected final boolean ENEMY_SIDE_ANIMATION = false;
    protected final boolean CHECK_SECOND_ATTACKER_PARALYSIS = false;
    protected boolean updatingAnimation;
    protected boolean updatingHealth;
    protected boolean displayingResults;
    protected boolean displayEnemyFaintAnimation;
    protected boolean displayUserFaintAnimation;
    protected boolean updateAttackerHealth;
    protected boolean displayRecoilResults;
    protected boolean finishedDepletion;
    protected boolean missed;

    protected SkillAnimation animation;
    protected List<List<String>> battleListText;
    protected List<String> recoilResults;

    protected boolean firstAttack;
    protected Pokemon attacker;
    protected Pokemon receiver;
    protected boolean enemyFainted;
    protected boolean userFainted;
    protected boolean attackerIsUser;

    protected Skill usedSkill;

    protected int textPosition;
    protected int resultsPosition;
    protected double textCounter;
    protected double resultsCounter;
    protected String missText;

    private boolean userRecoilFaint;
    private boolean enemyRecoilFaint;

    //Contact Variables
    private boolean madePhysicalContact;
    protected int state;
    protected final int ABILITY_CONTACT = 0;
    protected final int ITEM_CONTACT = 1;
    protected final int DISPLAY_ABILITY_CONTACT_RESULTS = 2;
    protected final int NO_CONTACT = 3;
    private String contactResults;
    private boolean enemyKilledUser;
    private boolean userKilledEnemy;

    public UseAttackPhase(PhaseUpdaterInterface pui) {
        super(pui);
        updatingAnimation = true;
        updatingHealth = false;
        displayingResults = false;
        displayEnemyFaintAnimation = false;
        updateAttackerHealth = false;
        displayRecoilResults = false;
        displayUserFaintAnimation = false;
        finishedDepletion = false;

        textPosition = 0;
        resultsPosition = 0;
        textCounter = 0;
        resultsCounter = 0;
        missed = false;
        recoilResults = new ArrayList<String>();
        madePhysicalContact = false;
        userRecoilFaint = false;
        enemyRecoilFaint = false;
        state = -1;
        contactResults = "";
    }

    /**
     * Check the attacker and receiver's health after using the first move.
     * Set faint flags if there was a faint on either side.
     * This method is called when the attacker is the user's Pokemon.
     */
    protected void checkPokemonHealthAfterUserAttack() {
        if (receiver.getCurrentHealth() == 0) {
            battleListText.get(1).add(receiver.getName() + " fainted.");
            enemyFainted = true;
        } else {
            enemyFainted = false;
        }
        if (attacker.getCurrentHealth() == 0) {
            userFainted = true;
            userRecoilFaint = true;
        } else {
            userFainted = false;
        }
    }

    /**
     * Check the attacker and receiver's health after using the first move.
     * Set faint flags if there was a faint on either side.
     * This method is called when the attacker is the enemy's Pokemon.
     */
    protected void checkPokemonHealthAfterEnemyAttack() {
        if (receiver.getCurrentHealth() == 0) {
            battleListText.get(1).add(receiver.getName() + " fainted.");
            userFainted = true;
        } else {
            userFainted = false;
        }
        if (attacker.getCurrentHealth() == 0) {
            enemyFainted = true;
            enemyRecoilFaint = true;
        } else {
            enemyFainted = false;
        }
    }

    protected void updateAnimation(double dt) {
        animation.update(dt);
        pui.getUserPokemon().setPlayerX(animation.getPlayerX());
        pui.getUserPokemon().setPlayerY(animation.getPlayerY());
        pui.getEnemyPokemon().setEnemyX(animation.getEnemyX());
        pui.getEnemyPokemon().setEnemyY(animation.getEnemyY());
        if (animation.isFinished()) {
            animation.dispose();
            updatingAnimation = false;
            updatingHealth = true;
        }
    }

    protected void updateReceiverHealth(double dt) {
        if (!receiver.matchingAnimationHealth()) {
            receiver.adjustAnimationHealth(1);
        } else {
            //Display the second skill name after depleting health.
            updatingHealth = false;
            if (usedSkill.makesPhysicalContact()) {
                state = ABILITY_CONTACT;
            } else {
                displayingResults = true;
            }

        }
    }

    protected void updateAttackerHealth(double dt) {
        if (!attacker.matchingAnimationHealth()) {
            attacker.adjustAnimationHealth(1);
        } else {
            recoilResults.add(attacker.getName() + " was hit by recoil.");
            if (attacker.getCurrentHealth() == 0) {
                recoilResults.add(attacker.getName() + " fainted.");
            }
            displayRecoilResults = true;
            resetTextBoxAndResults();
            updateAttackerHealth = false;
        }
    }

    protected boolean hasRecoil() {
        if (attacker.getCurrentHealth() != attacker.getAnimationHealth()) {
            return true;
        }
        return false;
    }

    protected void resetTextBoxAndResults() {
        resetTextBox();
        resultsPosition = 0;
    }

    protected void resetTextBox() {
        textPosition = 0;
        textCounter = 0;
        resultsCounter = 0;
    }

    @Override
    public void update(double dt) {

    }

    protected void displayResults(double dt) {
        textCounter += dt;
        if (textCounter >= 0.05) {
            if (textPosition < battleListText.get(1).get(resultsPosition).length() - 1) {
                textPosition++;
                textCounter = 0;
            }
        }
        if (textPosition == battleListText.get(1).get(resultsPosition).length() - 1) {
            //Update result timer if the text has finished rendering
            resultsCounter += dt;
        }
        if (resultsCounter >= 1.5) {
            //When the last character of the text is finished rendering, have a 1.5 second delay
            //and then move onto the next result
            if (resultsPosition < battleListText.get(1).size() - 1) {
                //There are still more results so go to the next one.
                resultsPosition++;
                resetTextBox();
            } else {
                //There are no more results
                transferPreStatus();
                //No results so go right into the recoil phase
                if (hasRecoil()) {
                    //There is recoil, so update the health of the attacker.
                    displayingResults = false;
                    if (attackerIsUser) {
                        if (enemyFainted) {
                            displayEnemyFaintAnimation = true;
                        }
                    }
                    updateAttackerHealth = true;
                } else {
                    //No recoil so end the attack accordingly
                    if (pui.isUserPokemonFirstAttacker()) {
                        if (enemyFainted) {
                            displayingResults = false;
                            displayEnemyFaintAnimation = true;
                        } else if (userFainted) {
                            displayingResults = false;
                            displayUserFaintAnimation = true;
                        }
                        else {
                            displayingResults = false;
                            finishedDepletion = true;

                        }
                    } else {
                        if (userFainted) {
                            displayingResults = false;
                            displayUserFaintAnimation = true;
                        } else if (enemyFainted) {
                            displayingResults = false;
                            displayEnemyFaintAnimation = true;
                        }
                        else {
                            displayingResults = false;
                            finishedDepletion = true;
                        }
                    }
                }


            }
        }
    }

    protected void displayRecoilResults(double dt) {
        textCounter += dt;
        if (textCounter >= 0.05) {
            if (textPosition < recoilResults.get(resultsPosition).length() - 1) {
                textPosition++;
                textCounter = 0;
            }
        }
        if (textPosition == recoilResults.get(resultsPosition).length() - 1) {
            //Update result timer if the text has finished rendering
            resultsCounter += dt;
        }
        if (resultsCounter >= 1.5) {
            if (resultsPosition < recoilResults.size() - 1) {
                //There are still more results so go to the next one.
                resultsPosition++;
                resetTextBox();
            } else {
                if (userRecoilFaint) {
                    displayRecoilResults = false;
                    displayUserFaintAnimation = true;
                } else if (enemyRecoilFaint) {
                    displayRecoilResults = false;
                    displayEnemyFaintAnimation = true;
                }
                else {
                    displayRecoilResults = false;
                    finishedDepletion = true;
                }
            }
        }
    }

    protected void updateEnemyFaintAnimation(double dt) {
        pui.getEnemyPokemon().setEnemyY((int)(pui.getEnemyPokemon().getEnemyY() - 10));
        if (pui.getEnemyPokemon().getEnemyY() <= pui.getEnemyPokemon().getFaintedEnemyY()) {
            //Make the pokemon faint when it went down to the right faint position
            pui.getEnemyPokemon().setEnemyY(pui.getEnemyPokemon().getFaintedEnemyY());
            pui.getEnemyPokemon().setFaint(true);
            displayEnemyFaintAnimation = false;
            //Check if the skill has recoil
            if (hasRecoil()) {
                //If the attacker is the user, we haven't done recoil damage yet.
                if (attackerIsUser) {
                    updateAttackerHealth = true;
                } else {
                    //If the attacker is the enemy, this is a result of the recoil damage
                    //so end the turn.
                    finishedDepletion = true;
                }
            } else {
                finishedDepletion = true;
            }
        }
    }

    protected void updateUserFaintAnimation(double dt) {
        pui.getUserPokemon().setPlayerY((int)(pui.getUserPokemon().getPlayerY() - 10));
        if (pui.getUserPokemon().getPlayerY() <= pui.getUserPokemon().getFaintedPlayerY()) {
            //Make the pokemon faint when it went down to the right faint position
            pui.getUserPokemon().setPlayerY(pui.getUserPokemon().getFaintedPlayerY());
            pui.getUserPokemon().setFaint(true);
            displayUserFaintAnimation = false;
            if (hasRecoil()) {
                if (attackerIsUser) {
                    //If the attacker is the user, this is a result of the recoil damage.
                    finishedDepletion = true;
                } else {
                    //If the attacker is the enemy, we haven't done recoil damage yet.
                    updateAttackerHealth = true;
                }
            } else {
                finishedDepletion = true;
            }
        }
    }

    private void transferPreStatus() {
        pui.getUserPokemon().transferPreStatus();
        pui.getEnemyPokemon().transferPreStatus();
    }

    public void renderText(SpriteBatch batch) {
        if (state == DISPLAY_ABILITY_CONTACT_RESULTS) {
            pui.getFont().draw(batch, contactResults.substring(0, textPosition), 54, 1143);
        } else {
            if (displayingResults) {
                pui.getFont().draw(batch, battleListText.get(1).get(resultsPosition).substring(0, textPosition), 54, 1143);
            } else if (displayRecoilResults) {
                pui.getFont().draw(batch, recoilResults.get(resultsPosition).substring(0, textPosition), 54, 1143);
            } else if (missed) {
                pui.getFont().draw(batch, missText.substring(0, textPosition), 54, 1143);
            }
        }
    }

    /**
     * *************************************************************************************************************************
     * *************************************************************************************************************************
     *                                  MAKING CONTACT WITH THE RECEIVING POKEMON METHODS
     * *************************************************************************************************************************
     * *************************************************************************************************************************
     */


    protected void checkAbilityContact(double dt) {
        if (receiver.getAbility() == Pokemon.Ability.STATIC) {
            useStatic();
        } else if (receiver.getAbility() == Pokemon.Ability.POISON_POINT) {
            usePoisonPoint();
        } else if (receiver.getAbility() == Pokemon.Ability.POISON_TOUCH) {
            usePoisonTouch();
        } else if (receiver.getAbility() == Pokemon.Ability.FLAME_BODY) {
            useFlameBody();
        } else if (receiver.getAbility() == Pokemon.Ability.EFFECT_SPORE) {
            useEffectSpore();
        }

        if (!contactResults.equals("")) {
            state = DISPLAY_ABILITY_CONTACT_RESULTS;
        } else {
            //go to next phase
            goToNextPhase();
        }
    }

    protected void updateAbilityContactResults(double dt) {
        textCounter += dt;
        if (textCounter >= 0.05) {
            if (textPosition < contactResults.length()) {
                textCounter = 0;
                textPosition++;
            }
        }
        if (textCounter >= 1.5) {
            textCounter = 0;
            textPosition = 0;
            //go to next phase
            attacker.transferPreStatus();
            receiver.transferPreStatus();
            goToNextPhase();
        }
    }

    private void goToNextPhase() {
        contactResults = "";
        if (usedSkill.getStrikesLeft() > 0) {
            battleListText = usedSkill.use(attacker, receiver, pui.getField()); //Override
            updatingAnimation = true;
            state = -1; //reset state.
            if (attackerIsUser) {
                animation = usedSkill.getAnimation(PLAYER_SIDE_ANIMATION);
                checkPokemonHealthAfterUserAttack();
            } else {
                animation = usedSkill.getAnimation(ENEMY_SIDE_ANIMATION);
                checkPokemonHealthAfterEnemyAttack();
            }
        } else {
            state = -1;
            //There are results to be displayed
            displayingResults = true;
        }
    }

    private void useStatic() {
        if (!attacker.isStatused()) {
            double rand = Math.random();
            if (rand <= .3) {
                contactResults = attacker.getName() + " was paralyzed\nfrom " +
                        receiver.getName() + "s Static.";
                attacker.setPreStatus(Pokemon.Status.PARALYSIS);
            }
        }
    }

    private void usePoisonPoint() {
        if (!attacker.isStatused()) {
            double rand = Math.random();
            if (rand <= .30) {
                contactResults = attacker.getName() + " was poisoned\nfrom " +
                        receiver.getName() + "s Poison Point.";
                attacker.setPreStatus(Pokemon.Status.POISON);
            }
        }
    }

    private void usePoisonTouch() {
        if (!receiver.isStatused()) {
            double rand = Math.random();
            if (rand <= .30) {
                contactResults = receiver.getName() + " was poisoned\nfrom " +
                        attacker.getName() + "s Poison Touch.";
                receiver.setPreStatus(Pokemon.Status.POISON);
            }
        }
    }

    private void useFlameBody() {
        if (!attacker.isStatused()) {
            double rand = Math.random();
            if (rand <= .30) {
                contactResults = attacker.getName() + " was burned\nfrom " +
                        receiver.getName() + "s Flame Body.";
                attacker.setPreStatus(Pokemon.Status.BURN);
            }
        }
    }

    private void useEffectSpore() {
        if (!attacker.isStatused()) {
            double rand = Math.random();
            if (rand <= .9) {
                contactResults = receiver.getName() + " was poisoned\nfrom " +
                        attacker.getName() + "s Effect Spore.";
                attacker.setPreStatus(Pokemon.Status.POISON);
            } else if (rand > .9 && rand <= .19) {
                contactResults = receiver.getName() + " was paralyzed\nfrom " +
                        attacker.getName() + "s Effect Spore.";
                attacker.setPreStatus(Pokemon.Status.PARALYSIS);
            } else if (rand > .19 && rand <= .3) {
                contactResults = receiver.getName() + " was put to sleep\nfrom " +
                        attacker.getName() + "s Effect Spore.";
                attacker.setPreStatus(Pokemon.Status.SLEEP);
            }
        }
    }
}
