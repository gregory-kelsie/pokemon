package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability.AbilityId;
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
    protected List<String> battleResults;
    protected List<String> recoilResults;

    protected boolean firstAttack;
    protected Pokemon attacker;
    protected int attackerPartyPosition;
    protected SubField attackerSubField;
    protected SubField receiverSubField;
    protected Pokemon receiver;
    protected int receiverPartyPosition;
    protected boolean enemyFainted;
    protected boolean userFainted;
    protected boolean attackerIsUser;

    protected Skill usedSkill;
    //For moves like Sucker Punch the usedSkill needs to know what the target used.
    protected Skill targetsSkill;

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

    private boolean isGain;
    protected boolean powdered;

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
        isGain = false;
        powdered = false;
    }

    /**
     * Check the attacker and receiver's health after using the first move.
     * Set faint flags if there was a faint on either side.
     * This method is called when the attacker is the user's Pokemon.
     */
    protected void checkPokemonHealthAfterUserAttack() {
        if (receiver.getCurrentHealth() == 0) {
            battleResults.add(receiver.getName() + " fainted.");
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
            battleResults.add(receiver.getName() + " fainted.");
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
            schoolingCheck(receiver, !attackerIsUser);
            updatingHealth = false;
            if (usedSkill.makesPhysicalContact() && usedSkill.targetsEnemy(attacker, pui.getField())) {
                state = ABILITY_CONTACT;
            } else {
                goToNextPhase();
            }

        }
    }

    protected void updateAttackerHealth(double dt) {
        if (!attacker.matchingAnimationHealth()) {
            attacker.adjustAnimationHealth(1);
        } else {
            if (usedSkill.hasRecoil()) {
                if (!isGain) {
                    recoilResults.add(attacker.getName() + " was hit by recoil.");
                } else {
                    recoilResults.add(attacker.getName() + " drained health.");
                }
            } else if (powdered) {
                recoilResults.add("When the flame touched the powder on the Pokemon,\nit exploded!");
            }
            if (attacker.getCurrentHealth() == 0) {
                recoilResults.add(attacker.getName() + " fainted.");
            } else {
                schoolingCheck(attacker, attackerIsUser);
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
            if (textPosition < battleResults.get(resultsPosition).length()) {
                textPosition++;
                textCounter = 0;
            }
        }
        if (textPosition == battleResults.get(resultsPosition).length()) {
            //Update result timer if the text has finished rendering
            resultsCounter += dt;
        }
        if (resultsCounter >= 1.5) {
            //When the last character of the text is finished rendering, have a 1.5 second delay
            //and then move onto the next result
            if (resultsPosition < battleResults.size() - 1) {
                //There are still more results so go to the next one.
                resultsPosition++;
                resetTextBox();
            } else {
                //There are no more results
                transferPreStatus();
                //No results so go right into the recoil phase
                if (hasRecoil()) {
                    //There is recoil, so update the health of the attacker.
                    if (attacker.getCurrentHealth() < attacker.getAnimationHealth()) {
                        isGain = false;
                    } else {
                        isGain = true;
                    }
                    displayingResults = false;
                    if (attackerIsUser) {
                        if (enemyFainted) {
                            displayEnemyFaintAnimation = true;
                            pui.playFaintSound();
                        } else {
                            updateAttackerHealth = true;
                        }
                    } else {
                         if (userFainted) {
                            displayUserFaintAnimation = true;
                             pui.playFaintSound();
                        } else {
                             updateAttackerHealth = true;
                         }
                    }
                    //updateAttackerHealth = true;
                } else {
                    //No recoil so end the attack accordingly
                    if (pui.isUserPokemonFirstAttacker()) {
                        if (enemyFainted) {
                            displayingResults = false;
                            displayEnemyFaintAnimation = true;
                            pui.playFaintSound();
                        } else if (userFainted) {
                            displayingResults = false;
                            displayUserFaintAnimation = true;
                            pui.playFaintSound();
                        }
                        else {
                            displayingResults = false;
                            finishedDepletion = true;

                        }
                    } else {
                        if (userFainted) {
                            displayingResults = false;
                            displayUserFaintAnimation = true;
                            pui.playFaintSound();
                        } else if (enemyFainted) {
                            displayingResults = false;
                            displayEnemyFaintAnimation = true;
                            pui.playFaintSound();
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
        if (recoilResults.size() > 0) {
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
                        pui.playFaintSound();
                    } else if (enemyRecoilFaint) {
                        displayRecoilResults = false;
                        displayEnemyFaintAnimation = true;
                        pui.playFaintSound();
                    } else {
                        displayRecoilResults = false;
                        finishedDepletion = true;
                    }
                }
            }
        } else {
            if (userRecoilFaint) {
                displayRecoilResults = false;
                displayUserFaintAnimation = true;
                pui.playFaintSound();
            } else if (enemyRecoilFaint) {
                displayRecoilResults = false;
                displayEnemyFaintAnimation = true;
                pui.playFaintSound();
            } else {
                displayRecoilResults = false;
                finishedDepletion = true;
            }
        }
    }

    protected void updateEnemyFaintAnimation(double dt) {
        pui.getEnemyPokemon().setEnemyY((int)(pui.getEnemyPokemon().getEnemyY() - 10));
        if (pui.getEnemyPokemon().getEnemyY() <= pui.getEnemyPokemon().getFaintedEnemyY()) {
            //Make the pokemon faint when it went down to the right faint position
            pui.getEnemyPokemon().setEnemyY(pui.getEnemyPokemon().getFaintedEnemyY());
            pui.getEnemyPokemon().setFaint(true);
            pui.getUserPokemon().freeFromBinds();
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
            pui.getEnemyPokemon().freeFromBinds();
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
                if (battleResults.size() > 0) {
                    pui.getFont().draw(batch, battleResults.get(resultsPosition).substring(0, textPosition), 54, 1143);
                }
            } else if (displayRecoilResults) {
                if (recoilResults.size() > 0) {
                    pui.getFont().draw(batch, recoilResults.get(resultsPosition).substring(0, textPosition), 54, 1143);
                }
            } else if (missed) {
                pui.getFont().draw(batch, missText.substring(0, textPosition), 54, 1143);
            }
        }
    }

    protected boolean willDealDamage(Skill skill, Pokemon receivingPokemon) {
        if (skill.doesDamageToEnemy()) {
            if (receivingPokemon.getResistances().get(skill.getType()) != 0) {
                //Check if the receiving pokemon has wonder guard
                if (receivingPokemon.getResistances().get(skill.getType()) <= 1 &&
                        receivingPokemon.getBattleAbility().getId() == AbilityId.WONDER_GUARD) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * *************************************************************************************************************************
     * *************************************************************************************************************************
     *                                  MAKING CONTACT WITH THE RECEIVING POKEMON METHODS
     * *************************************************************************************************************************
     * *************************************************************************************************************************
     */


    protected void checkAbilityContact(double dt) {
        //TODO: Implement rough skin and make sure to do schooling checks for that.
        if (receiver.getBattleAbility().getId() == AbilityId.STATIC) {
            useStatic();
        } else if (receiver.getBattleAbility().getId() == AbilityId.POISON_POINT) {
            usePoisonPoint();
        } else if (attacker.getBattleAbility().getId() == AbilityId.POISON_TOUCH) {
            usePoisonTouch();
        } else if (receiver.getBattleAbility().getId() == AbilityId.FLAME_BODY) {
            useFlameBody();
        } else if (receiver.getBattleAbility().getId() == AbilityId.EFFECT_SPORE) {
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
            if (attackerIsUser) {
                attackerSubField = pui.getField().getPlayerField();
                receiverSubField = pui.getField().getOpponentField();
            } else {
                attackerSubField = pui.getField().getOpponentField();
                receiverSubField = pui.getField().getPlayerField();
            }
            if (attackerIsUser) {
                calcSchoolingBeforeDamageOrHeal(receiver, false);
                battleResults = usedSkill.use(attacker, receiver, pui.getUserPokemonPosition(),
                        pui.getEnemyPokemonPosition(), pui.getField(), attackerSubField,
                        receiverSubField, firstAttack, targetsSkill, pui.getPlayerParty(),
                        new ArrayList<Pokemon>()); //Override
                calcSchoolingAfterDamageOrHeal(receiver, false);
            } else {
                calcSchoolingBeforeDamageOrHeal(receiver, true);
                battleResults = usedSkill.use(attacker, receiver, pui.getEnemyPokemonPosition(),
                        pui.getUserPokemonPosition(), pui.getField(), attackerSubField,
                        receiverSubField, firstAttack, targetsSkill, new ArrayList<Pokemon>(),
                        pui.getPlayerParty()); //Override
                calcSchoolingAfterDamageOrHeal(receiver, true);
            }
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
            if (battleResults.size() > 0) {
                displayingResults = true;
            } else {
                noResults();
            }
        }
    }

    private void noResults() {
        if (pui.isUserPokemonFirstAttacker()) {
            if (enemyFainted) {
                displayEnemyFaintAnimation = true;
                pui.playFaintSound();
            } else if (userFainted) {
                displayUserFaintAnimation = true;
                pui.playFaintSound();
            }
            else {
                finishedDepletion = true;

            }
        } else {
            if (userFainted) {
                displayUserFaintAnimation = true;
                pui.playFaintSound();
            } else if (enemyFainted) {
                displayEnemyFaintAnimation = true;
                pui.playFaintSound();
            }
            else {
                finishedDepletion = true;
            }
        }
    }

    private void useStatic() {
        if (attacker.isParalyzable()) {
            double rand = Math.random();
            if (rand <= .3) {
                contactResults = attacker.getName() + " was paralyzed\nfrom " +
                        receiver.getName() + "s Static.";
                attacker.setPreStatus(Pokemon.Status.PARALYSIS);
            }
        }
    }

    private void usePoisonPoint() {
        if (attacker.isPoisonable()) {
            double rand = Math.random();
            if (rand <= .30) {
                contactResults = attacker.getName() + " was poisoned\nfrom " +
                        receiver.getName() + "s Poison Point.";
                attacker.setPreStatus(Pokemon.Status.POISON);
            }
        }
    }

    private void usePoisonTouch() {
        if (receiver.isPoisonable()) {
            double rand = Math.random();
            if (rand <= .30) {
                contactResults = receiver.getName() + " was poisoned\nfrom " +
                        attacker.getName() + "s Poison Touch.";
                receiver.setPreStatus(Pokemon.Status.POISON);
            }
        }
    }

    private void useFlameBody() {
        if (attacker.isBurnable()) {
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
            if (rand <= .09) {
                if (attacker.isPoisonable()) {
                    contactResults = attacker.getName() + " was poisoned\nfrom " +
                            receiver.getName() + "s Effect Spore.";
                    attacker.setPreStatus(Pokemon.Status.POISON);
                }
            } else if (rand > .09 && rand <= .19) {
                if (attacker.isParalyzable()) {
                    contactResults = attacker.getName() + " was paralyzed\nfrom " +
                            receiver.getName() + "s Effect Spore.";
                    attacker.setPreStatus(Pokemon.Status.PARALYSIS);
                }
            } else if (rand > .19 && rand <= .3) {
                if (attacker.isSleepable()) {
                    contactResults = attacker.getName() + " was put to sleep\nfrom " +
                            receiver.getName() + "s Effect Spore.";
                    attacker.induceSleep();
                }
            }
        }
    }
}
