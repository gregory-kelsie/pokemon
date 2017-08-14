package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.end_of_turn_effects.EndTurnPhase;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

/**
 * Created by Gregory on 8/13/2017.
 */

public class SleepCheckPhase extends BattlePhase {

    private String text;
    private int textPosition;
    private double textCounter;
    private boolean isFirstMove;
    private Skill skill; //The skill attempt of the pokemon.
    private Pokemon sleepingPokemon;
    private int currentState;
    private final int INIT = 0;
    private final int WOKE_UP = 1;
    private final int SLEEPING = 2;

    /**
     * Create a sleep check
     * @param pui The BattleUpdater
     * @param isFirstMove Whether or not the sleep check is for the
     *                    first or second move.
     */
    public SleepCheckPhase(PhaseUpdaterInterface pui, boolean isFirstMove) {
        super(pui);
        phaseName = "Sleep Check Phase";
        text = "";
        textPosition = 0;
        textCounter = 0;
        this.isFirstMove = isFirstMove;
        currentState = INIT;

    }

    /**
     * Initialize the sleep phase by determining who the sleeping pokemon is
     * (if they are even sleeping) and which skill they are potentially using.
     * Also determine if they fell asleep or woke up.
     */
    private void init() {
        initUserAndSkill();
        if (sleepingPokemon.getStatus() == Pokemon.Status.SLEEP &&
                sleepingPokemon.getSleepTime() == 0) {
            currentState = WOKE_UP;
            text = sleepingPokemon.getName() + " woke up!";
        } else if (sleepingPokemon.getStatus() == Pokemon.Status.SLEEP &&
                sleepingPokemon.getSleepTime() > 0) {
            currentState = SLEEPING;
            text = sleepingPokemon.getName() + " is fast asleep.";
        } else {
            goToConfusionCheck();
        }
    }

    /**
     * Passed the sleep check so go to the next check, the confusion
     * check.
     */
    private void goToConfusionCheck() {
        if (isFirstMove) {
            pui.setPhase(new ConfusionCheckPhase(pui, true));
        } else {
            pui.setPhase(new ConfusionCheckPhase(pui, false));
        }
    }

    /**
     * Initialize the sleep phase by determining who the sleeping pokemon is
     * (if they are even sleeping) and which skill they are potentially using.
     */
    private void initUserAndSkill() {
        if (isFirstMove && pui.isUserPokemonFirstAttacker()) {
            skill = pui.getUserSkill();
            sleepingPokemon = pui.getUserPokemon();
        } else if (isFirstMove && !pui.isUserPokemonFirstAttacker()) {
            skill = pui.getEnemySkill();
            sleepingPokemon = pui.getEnemyPokemon();
        } else if (!isFirstMove && pui.isUserPokemonFirstAttacker()) {
            skill = pui.getEnemySkill();
            sleepingPokemon = pui.getEnemyPokemon();
        } else if (!isFirstMove && !pui.isUserPokemonFirstAttacker()) {
            skill = pui.getUserSkill();
            sleepingPokemon = pui.getUserPokemon();
        }
    }

    /**
     * Return whether or not the skill the sleeping pokemon is using
     * can be used while they are asleep.
     * @return Whether or not the sleeping pokemon's skill is usable
     * in their sleep.
     */
    private boolean skillIsUsableInSleep() {
        if (skill.getName().equals("Snore") || skill.getName().equals("Sleep Talk")) {
            return true;
        }
        return false;
    }

    /**
     * Update the confusion check phase.
     * @param dt The time elapsed.
     */
    public void update(double dt) {
        if (currentState == INIT) {
            init();
        } else if (currentState == SLEEPING) {
            updateSleepingText(dt);
        } else if (currentState == WOKE_UP) {
            updateWakingUpText(dt);
        }
    }

    /**
     * Update the sleeping text.
     * Ex: Eevee is fast asleep...
     * @param dt The time elapsed.
     */
    private void updateSleepingText(double dt) {
        textCounter += dt;
        if (textCounter >= 0.05) {
            if (textPosition < text.length()) {
                textPosition++;
                textCounter = 0;
            }
        }
        if (textCounter >= 1.5) {
            sleepingPokemon.reduceSleepTime();
            if (skillIsUsableInSleep()) {
                //Use the skill through sleep.
                goToConfusionCheck();
            } else {
                if (isFirstMove) {
                    //Go to next turn
                    pui.setPhase(new SleepCheckPhase(pui, false));
                } else { //End the turn
                    pui.setPhase(new EndTurnPhase(pui));
                }
            }
        }
    }

    /**
     * Update the waking up text.
     * @param dt The time elapsed.
     */
    private void updateWakingUpText(double dt) {
        textCounter += dt;
        if (textCounter >= 0.05) {
            if (textPosition < text.length()) {
                textPosition++;
                textCounter = 0;
            }
        }
        if (textCounter >= 1.5) {
            sleepingPokemon.wakeUp();
            goToConfusionCheck();
        }
    }

    /**
     * Render the text for the phase.
     * @param batch The SpriteBatch the text gets rendered to.
     */
    @Override
    public void renderText(SpriteBatch batch) {
        if (currentState == SLEEPING || currentState == WOKE_UP) {
            pui.getFont().draw(batch, text.substring(0, textPosition), 54, 1143);
        }

    }
}
