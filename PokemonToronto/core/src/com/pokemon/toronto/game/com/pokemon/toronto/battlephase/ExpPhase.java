package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.List;

/**
 * Created by Gregory on 8/10/2017.
 */

public class ExpPhase extends BattlePhase {

    private double expGain;
    private long fullBarofExp;
    private double expGainRate;

    private int currentState;

    //Level Up Variables
    private List<Integer> newSkillsForLevelUp;
    private Skill newMove;

    //Text Variables
    private double counter = 0;
    private int textPosition = 0;
    private String text;

    private final int DISPLAY_EXP_GAIN = 0;
    private final int PAUSE_AFTER_DISPLAY_EXP_GAIN = 1;
    private final int ADD_EXP = 2;
    private final int LEVEL_UP_STATE = 3;
    private final int AUTOMATIC_NEW_MOVE = 4;
    private final int ASKING_TO_MAKE_ROOM = 5;
    private final int DELAY_AFTER_EXP_GAIN = 6;
    private final int WAIT_FOR_YES_NO_RESULT = 7;
    private final int WAIT_FOR_MOVE_DELETION = 8;
    private final int LEARNED_NEW_MOVE = 9;

    public ExpPhase(PhaseUpdaterInterface pui) {
        super(pui);
        expGain = pui.getEnemyPokemon().calculateExp(1);
        fullBarofExp = pui.getUserPokemon().getNextLevelExp();
        expGainRate = fullBarofExp / 1.5;
        if (!pui.getUserPokemon().hasMaxEvs()) {
            pui.getUserPokemon().addEvs(pui.getEnemyPokemon().getEvYield());
        }
        text = pui.getUserPokemon().getName() + " gained " +
                pui.getEnemyPokemon().calculateExp(1) + " Exp. Points.";
        currentState = DISPLAY_EXP_GAIN;

    }

    @Override
    public void update(double dt) {
        if (currentState == DISPLAY_EXP_GAIN) {
            updateDisplayExpGain(dt);
        } else if (currentState == PAUSE_AFTER_DISPLAY_EXP_GAIN) {
            updateDisplayExpGainPause(dt);
        } else if (currentState == ADD_EXP) {
            updateExpGraphics(dt);
        } else if (currentState == LEVEL_UP_STATE) {
            updateLevelUp(dt);
        } else if (currentState == DELAY_AFTER_EXP_GAIN) {
            updateDelayAfterExpGain(dt);
        } else if (currentState == AUTOMATIC_NEW_MOVE) {
            updateAutomaticNewMove(dt);
        } else if (currentState == WAIT_FOR_YES_NO_RESULT) {
            updateWaitForYesNoResult(dt);
        } else if (currentState == WAIT_FOR_MOVE_DELETION) {
            waitForMoveDeletion(dt);
        } else if (currentState == ASKING_TO_MAKE_ROOM) {
            updateAskingToMakeRoom(dt);
        } else if (currentState == LEARNED_NEW_MOVE) {
            updateLearningNewMoveText(dt);
        }
    }

    private void updateLearningNewMoveText(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textPosition < text.length()) {
                counter = 0;
                textPosition++;
            }
        }
        if (counter >= 1.5) {
            currentState = AUTOMATIC_NEW_MOVE;
        }
    }
    private void waitForMoveDeletion(double dt) {
        if (pui.deletingFirstMove()) {
            text = "1, 2 and... Poof! " + pui.getUserPokemon().getName() + " forgot "
                    + pui.getUserPokemon().getSkills().get(0).getName() +
                    "\n and... " + pui.getUserPokemon().getName() + " learned " + newMove.getName();
            pui.getUserPokemon().getSkills().set(0, newMove);
            currentState = LEARNED_NEW_MOVE;
            resetAllTextVariables();
        } else if (pui.deletingSecondMove()) {
            text = "1, 2 and... Poof! " + pui.getUserPokemon().getName() + " forgot "
                    + pui.getUserPokemon().getSkills().get(1).getName() +
                    "\n and... " + pui.getUserPokemon().getName() + " learned " + newMove.getName();
            pui.getUserPokemon().getSkills().set(1, newMove);
            currentState = LEARNED_NEW_MOVE;
            resetAllTextVariables();
        } else if (pui.deletingThirdMove()) {
            text = "1, 2 and... Poof! " + pui.getUserPokemon().getName() + " forgot "
                    + pui.getUserPokemon().getSkills().get(2).getName() +
                    "\n and... " + pui.getUserPokemon().getName() + " learned " + newMove.getName();
            pui.getUserPokemon().getSkills().set(2, newMove);
            currentState = LEARNED_NEW_MOVE;
            resetAllTextVariables();
        } else if (pui.deletingFourthMove()) {
            text = "1, 2 and... Poof! " + pui.getUserPokemon().getName() + " forgot "
                    + pui.getUserPokemon().getSkills().get(3).getName() +
                    "\n and... " + pui.getUserPokemon().getName() + " learned " + newMove.getName();
            pui.getUserPokemon().getSkills().set(3, newMove);
            currentState = LEARNED_NEW_MOVE;
            resetAllTextVariables();
        } else if (pui.stoppedDeletingMove()) {

        }
    }

    private void updateAutomaticNewMove(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textPosition < text.length()) {
                textPosition++;
                counter = 0;
            }
        }
        if (counter >= 1.5) {
            if (newSkillsForLevelUp.size() == 0) {
                currentState = ADD_EXP;
            } else {
                if (pui.getUserPokemon().getSkills().size() < 4) {
                    SkillFactory sf = new SkillFactory();
                    newMove = sf.createSkill(newSkillsForLevelUp.get(0));
                    newSkillsForLevelUp.remove(0);
                    pui.getUserPokemon().addMove(newMove);
                    currentState = AUTOMATIC_NEW_MOVE;
                    text = pui.getUserPokemon().getName() + " learned " + newMove.getName() + "!";
                    resetAllTextVariables();
                } else {
                    //GO TO QUESTIONING FOR NEW MOVE STATE
                    currentState = ASKING_TO_MAKE_ROOM;
                    text = "Should a move be deleted for\n" + newMove.getName() + "?";
                    resetAllTextVariables();
                }
            }
        }
    }

    private void updateDelayAfterExpGain(double dt) {
        counter += dt;
        if (counter >= 2) {
            pui.finishedBattle();
        }
    }
    private void updateDisplayExpGain(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            counter = 0;
            if (textPosition < text.length()) {
                textPosition++;
            } else {
                currentState = PAUSE_AFTER_DISPLAY_EXP_GAIN;
            }
        }
    }

    private void updateDisplayExpGainPause(double dt) {
        counter += dt;
        if (counter >= 2) {
            counter = 0;
            currentState = ADD_EXP;
        }
    }

    private void updateExpGraphics(double dt) {
        //expGain is the total amount of exp being given
        Gdx.app.log("EXPGAIN", "" + expGain);
        if (expGain < dt * expGainRate) {
            pui.getUserPokemon().addExp(expGain);
            if (pui.getUserPokemon().getDisplayedExp() >= pui.getUserPokemon().getNextLevelExp()) {
                //Overflown so add back to expGain
                expGain = pui.getUserPokemon().getDisplayedExp() - pui.getUserPokemon().getNextLevelExp();
                //Go to level up state
                currentState = LEVEL_UP_STATE;
                text = pui.getUserPokemon().getName() + " has leveled up!";
                resetAllTextVariables();
                pui.getUserPokemon().levelUp();
                fullBarofExp = pui.getUserPokemon().getNextLevelExp();
                expGainRate = fullBarofExp / 1.5;
            } else {
                expGain = 0;
                //End the battle phase.
                counter = 0;
                currentState = DELAY_AFTER_EXP_GAIN;
            }
        }
        else {
            pui.getUserPokemon().addExp(dt * expGainRate);
            expGain -= dt * expGainRate;
            if (pui.getUserPokemon().getDisplayedExp() >= pui.getUserPokemon().getNextLevelExp()) {
                //Overflown
                expGain += pui.getUserPokemon().getDisplayedExp() - pui.getUserPokemon().getNextLevelExp();
                //Go to level up state
                text = pui.getUserPokemon().getName() + " has leveled up!";
                resetAllTextVariables();
                pui.getUserPokemon().levelUp();
                fullBarofExp = pui.getUserPokemon().getNextLevelExp();
                expGainRate = fullBarofExp / 1.5;
                currentState = LEVEL_UP_STATE;
            }

        }

    }

    private void updateLevelUp(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textPosition < text.length()) {
                textPosition += 1;
                counter = 0;
            }
        }
        if (counter >= 1.5) {
            //Get the skills the Pokemon learns at this level.
            newSkillsForLevelUp = pui.getUserPokemon().getCurrentLevelUpSkills();
            if (newSkillsForLevelUp == null) {
                currentState = ADD_EXP;
            } else {
                Gdx.app.log("NEWSKILLS", "" + pui.getUserPokemon().getSkills().size());
                SkillFactory sf = new SkillFactory();
                //Add the first new skill it learns at this level.
                newMove = sf.createSkill(newSkillsForLevelUp.get(0));
                newSkillsForLevelUp.remove(0);
                if (pui.getUserPokemon().getSkills().size() < 4) {
                    pui.getUserPokemon().addMove(newMove);
                    currentState = AUTOMATIC_NEW_MOVE;
                    text = pui.getUserPokemon().getName() + " learned " + newMove.getName() + "!";
                    resetAllTextVariables();
                } else {
                    //GO TO QUESTIONING FOR NEW MOVE
                    currentState = ASKING_TO_MAKE_ROOM;
                    text = "Should a move be deleted for\n" + newMove.getName() + "?";
                    resetAllTextVariables();
                }
            }
        }
    }

    private void updateAskingToMakeRoom(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textPosition < text.length()) {
                textPosition += 1;
                counter = 0;
            } else {
                pui.setDisplayYesNo();
                currentState = WAIT_FOR_YES_NO_RESULT;
            }
        }
    }

    private void updateWaitForYesNoResult(double dt) {
        if (pui.hasAcceptedNewMove()) {
            currentState = WAIT_FOR_MOVE_DELETION;
            pui.setWaitingForMoveDeletion();
        } else if (pui.hasDeclinedNewMove()) {
            currentState = AUTOMATIC_NEW_MOVE;
            text = ""; //remove the text.
            textPosition = 0;
            counter = 2; //skip the text saying learned new move.
        }
    }

    private void resetAllTextVariables() {
        counter = 0;
        textPosition = 0;
    }

    @Override
    public void renderText(SpriteBatch batch) {
        if (currentState == DISPLAY_EXP_GAIN ||
                currentState == PAUSE_AFTER_DISPLAY_EXP_GAIN ||
                currentState == LEVEL_UP_STATE || currentState == AUTOMATIC_NEW_MOVE ||
                currentState == WAIT_FOR_YES_NO_RESULT || currentState == ASKING_TO_MAKE_ROOM || currentState == LEARNED_NEW_MOVE) {
            pui.getFont().draw(batch, text.substring(0, textPosition), 54, 1143);
        }
    }


}
