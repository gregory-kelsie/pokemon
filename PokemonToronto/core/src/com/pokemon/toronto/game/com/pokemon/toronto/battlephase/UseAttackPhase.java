package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;

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

    protected SkillAnimation animation;
    protected List<List<String>> battleListText;
    protected List<String> recoilResults;

    protected Pokemon attacker;
    protected Pokemon receiver;
    protected boolean enemyFainted;
    protected boolean userFainted;

    protected int textPosition;
    protected int resultsPosition;
    protected double textCounter;
    protected double resultsCounter;

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

        recoilResults = new ArrayList<String>();
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
            if (battleListText.get(1).size() > 0) {
                //There are results to be displayed
                displayingResults = true;
            } else {
                //No results so go right into the recoil phase
                if (hasRecoil()) {
                    //There is recoil, so update the health of the attacker.
                    updateAttackerHealth = true;
                } else {
                    //No recoil so end the attack
                    finishedDepletion = true;
                }
            }
        }
    }



    protected void updateAttackerHealth(double dt) {
        if (!attacker.matchingAnimationHealth()) {
            attacker.adjustAnimationHealth(1);
        } else {
            recoilResults.add(attacker + " was hit by recoil.");
            if (attacker.getCurrentHealth() == 0) {
                recoilResults.add(attacker + " fainted.");
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
    public void renderText(SpriteBatch batch) {
        if (displayingResults) {
            pui.getFont().draw(batch, battleListText.get(1).get(resultsPosition).substring(0, textPosition), 54, 1143);
        } else if (displayRecoilResults) {
            pui.getFont().draw(batch, recoilResults.get(resultsPosition).substring(0, textPosition), 54, 1143);
        }
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
                        if (hasRecoil()) {
                            updateAttackerHealth = true;
                        } else {
                            finishedDepletion = true;
                        }
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
                        if (hasRecoil()) {
                            updateAttackerHealth = true;
                        } else {
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
                if (pui.isUserPokemonFirstAttacker() && userFainted) {
                    displayRecoilResults = false;
                    displayUserFaintAnimation = true;
                } else if (!pui.isUserPokemonFirstAttacker() && enemyFainted) {
                    displayRecoilResults = false;
                    displayEnemyFaintAnimation = true;
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

            if (pui.isUserPokemonFirstAttacker()) {
                //Enemy fainted after the player attacked first
                if (hasRecoil()) {
                    updateAttackerHealth = true;
                } else {
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
            if (pui.isUserPokemonFirstAttacker()) {
                //Enemy fainted after the player attacked first
                finishedDepletion = true;
            } else {
                if (hasRecoil()) {
                    updateAttackerHealth = true;
                } else {
                    finishedDepletion = true;
                }
            }
        }
    }

    private void transferPreStatus() {
        pui.getUserPokemon().transferPreStatus();
        pui.getEnemyPokemon().transferPreStatus();
    }
}
