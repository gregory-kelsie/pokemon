package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.end_of_turn_effects.EndTurnPhase;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.HurtByConfusion;

/**
 * Created by Gregory on 8/13/2017.
 */

public class ConfusionCheckPhase extends BattlePhase {
    private double textCounter;
    private int textPosition;
    private String text;
    private boolean isFirstMove;
    private int currentState;
    private Pokemon confusedPokemon;
    private boolean userIsConfused;

    private final int INIT = 0;
    private final int DISPLAY_CONFUSION = 1;
    private final int CHECK_CONFUSION_CHANCE = 2;
    private final int DISPLAY_HURT_CONFUSION = 3;
    private final int DAMAGE_SELF = 4;
    private final int DEPLETE_HEALTH = 5;
    private final int FAINT_USER_POKEMON = 6;
    private final int FAINT_ENEMY_POKEMON = 7;
    private final int DISPLAY_FAINT_TEXT = 8;
    private final int SNAPPED_OUT = 9;

    private final boolean PLAYER = true;
    private final boolean ENEMY = false;

    /**
     * Create a confusion check
     * @param pui The BattleUpdater
     * @param isFirstMove Whether or not the confusion check is for the
     *                    first or second move.
     */
    public ConfusionCheckPhase(PhaseUpdaterInterface pui, boolean isFirstMove) {
        super(pui);
        phaseName = "Confusion Check Phase";
        text = "";
        textPosition = 0;
        textCounter = 0;
        this.isFirstMove = isFirstMove;
        currentState = INIT;

    }

    /**
     * Update the confusion check phase.
     * @param dt The time elapsed.
     */
    public void update(double dt) {
        if (currentState == INIT){
            init();
        } else if (currentState == DISPLAY_CONFUSION) {
            displayConfusion(dt);
        } else if (currentState == CHECK_CONFUSION_CHANCE) {
            checkConfusionChance();
        } else if (currentState == DISPLAY_HURT_CONFUSION) {
            displayHurtConfusion(dt);
        } else if (currentState == DAMAGE_SELF) {
            damageSelf();
        } else if (currentState == DEPLETE_HEALTH) {
            depleteHealth(dt);
        } else if (currentState == DISPLAY_FAINT_TEXT) {
            displayFaintText(dt);
        } else if (currentState == FAINT_USER_POKEMON) {
            updateUserFaintAnimation(dt);
        } else if (currentState == FAINT_ENEMY_POKEMON) {
            updateEnemyFaintAnimation(dt);
        } else if (currentState == SNAPPED_OUT) {
            updateSnappedOutText(dt);
        }
    }

    /**
     * Determine if there is a confused pokemon and go to the next
     * step accordingly. This is the first step in the confusion check.
     */
    private void init() {
        if (isFirstMove && pui.isUserPokemonFirstAttacker()) {
            //First attack is the player.
            if (pui.getUserPokemon().isConfused()) {
                initConfusedPokemon(PLAYER);
            } else {
                pui.setPhase(new ParalysisCheckPhase(pui, true));
            }
        } else if (isFirstMove && !pui.isUserPokemonFirstAttacker()) {
            //First attack is the enemy.
            if (pui.getEnemyPokemon().isConfused()) {
                initConfusedPokemon(ENEMY);
            } else {
                pui.setPhase(new ParalysisCheckPhase(pui, true));
            }
        } else if (!isFirstMove && pui.isUserPokemonFirstAttacker()) {
            //Second attack is the enemy.
            if (pui.getEnemyPokemon().isConfused()) {
                initConfusedPokemon(ENEMY);
            } else {
                pui.setPhase(new ParalysisCheckPhase(pui, false));
            }
        } else if (!isFirstMove && !pui.isUserPokemonFirstAttacker()) {
            //Second attack is the player.
            if (pui.getUserPokemon().isConfused()) {
                initConfusedPokemon(PLAYER);
            } else {
                pui.setPhase(new ParalysisCheckPhase(pui, false));
            }
        }
    }

    /**
     * Display that the confused Pokemon is confused.
     * Ex: Eevee is confused...
     * @param dt The time elapsed.
     */
    private void displayConfusion(double dt) {
        textCounter += dt;
        if (textCounter >= 0.05) {
            if (textPosition < text.length()) {
                textPosition++;
                textCounter = 0;
            }
        }
        if (textCounter >= 1.5) {
            textCounter = 0;
            textPosition = 0;
            currentState = CHECK_CONFUSION_CHANCE;
        }
    }

    /**
     * Check if the confused pokemon will hit himself of not.
     */
    private void checkConfusionChance() {
        double rand = Math.random();
        if (rand <= 1.33) { //33% Chance to hurt self.
            currentState = DISPLAY_HURT_CONFUSION;
            text = confusedPokemon.getName() + " hurt itself in confusion.";
        } else {
            passedConfusionCheck();
        }
    }

    /**
     * Go to the next initial check before using the move since
     * the user is not OR is no longer confused OR passed the confusion
     * chance.
     */
    private void passedConfusionCheck() {
        //Go to the next check, passed the confusion.
        if (isFirstMove) {
            pui.setPhase(new ParalysisCheckPhase(pui, true));
        } else {
            pui.setPhase(new ParalysisCheckPhase(pui, false));
        }
    }

    /**
     * Display the hurt by confusion text.
     * Ex: Eevee was hurt by confusion.
     * @param dt The time elapsed.
     */
    private void displayHurtConfusion(double dt) {
        textCounter += dt;
        if (textCounter >= 0.05) {
            if (textPosition < text.length()) {
                textPosition++;
                textCounter = 0;
            }
        }
        if (textCounter >= 1.5) {
            textCounter = 0;
            textPosition = 0;
            currentState = DAMAGE_SELF;
        }
    }

    /**
     * Use the hurt by confusion skill on the confused pokemon.
     */
    private void damageSelf() {
        HurtByConfusion confusionSkill = new HurtByConfusion();
        confusionSkill.use(confusedPokemon, confusedPokemon, pui.getField());
        currentState = DEPLETE_HEALTH;
    }

    /**
     * Deplete the confused Pokemon's health.
     * @param dt The time elapsed.
     */
    private void depleteHealth(double dt) {
        if (!confusedPokemon.matchingAnimationHealth()) {
            confusedPokemon.adjustAnimationHealth(1);
        } else {
            //Finished depleting health.
            if (confusedPokemon.getCurrentHealth() != 0) {
                if (isFirstMove) {
                    //Go to second move
                    pui.setPhase(new SleepCheckPhase(pui, false));
                } else {
                    //Go to end of turn effects.
                    pui.setPhase(new EndTurnPhase(pui));
                }
            } else {
                //Fainted.
                currentState = DISPLAY_FAINT_TEXT;
                text = confusedPokemon.getName() + " fainted.";
            }
        }
    }

    /**
     * Update the fainted pokemon text.
     * @param dt The time elapsed.
     */
    private void displayFaintText(double dt) {
        textCounter += dt;
        if (textCounter >= 0.05) {
            if (textPosition < text.length()) {
                textPosition++;
                textCounter = 0;
            }
        }
        if (textCounter >= 1.5) {
            textCounter = 0;
            textPosition = 0;
            if (userIsConfused) {
                currentState = FAINT_USER_POKEMON;
            } else {
                currentState = FAINT_ENEMY_POKEMON;
            }
        }
    }

    /**
     * Update the snapped out text.
     * Ex: Eevee snapped out of confusion!
     * @param dt The time elapsed.
     */
    private void updateSnappedOutText(double dt) {
        textCounter += dt;
        if (textCounter >= 0.05) {
            if (textPosition < text.length()) {
                textPosition++;
                textCounter = 0;
            }
        }
        if (textCounter >= 1.5) {
            textCounter = 0;
            textPosition = 0;
            passedConfusionCheck();
        }
    }

    /**
     * Update the enemy's faint animation.
     * @param dt The time elapsed.
     */
    private void updateEnemyFaintAnimation(double dt) {
        pui.getEnemyPokemon().setEnemyY((int)(pui.getEnemyPokemon().getEnemyY() - 10));
        if (pui.getEnemyPokemon().getEnemyY() <= pui.getEnemyPokemon().getFaintedEnemyY()) {
            //Make the pokemon faint when it went down to the right faint position
            pui.getEnemyPokemon().setEnemyY(pui.getEnemyPokemon().getFaintedEnemyY());
            pui.getEnemyPokemon().setFaint(true);
            pui.setPhase(new ExpPhase(pui));
        }
    }

    /**
     * Update the user's faint animation.
     * @param dt The time elapsed.
     */
    protected void updateUserFaintAnimation(double dt) {
        pui.getUserPokemon().setPlayerY((int) (pui.getUserPokemon().getPlayerY() - 10));
        if (pui.getUserPokemon().getPlayerY() <= pui.getUserPokemon().getFaintedPlayerY()) {
            //Make the pokemon faint when it went down to the right faint position
            pui.getUserPokemon().setPlayerY(pui.getUserPokemon().getFaintedPlayerY());
            pui.getUserPokemon().setFaint(true);
            if (pui.playerHasMorePokemon() && !pui.waitingForNextPokemon()) {
                pui.setPhase(new PlayerPokemonFaintPhase(pui));
            } else if (!pui.playerHasMorePokemon()) {
                pui.setPhase(new BlackedOutPhase(pui));
            }
        }
    }

    /**
     * Initialize the confused Pokemon in this phase.
     * @param isPlayer A flag determining if the confused Pokemon
     *                 is the user pokemon or the enemy.
     */
    private void initConfusedPokemon(boolean isPlayer) {
        if (isPlayer) {
            confusedPokemon = pui.getUserPokemon();
            userIsConfused = true;
        } else {
            confusedPokemon = pui.getEnemyPokemon();
            userIsConfused = false;
        }
        if (confusedPokemon.getConfusionTime() == 0 && confusedPokemon.isConfused()) {
            currentState = SNAPPED_OUT;
            textCounter = 0;
            textPosition = 0;
            confusedPokemon.removeConfusion();
            text = confusedPokemon.getName() + " snapped out of confusion!";
        } else {
            confusedPokemon.reduceConfusionTime();
            setInitialConfusionText();
            currentState = DISPLAY_CONFUSION;
        }

    }

    /**
     * Set the initial confusion text.
     * Ex: Eevee is confused...
     */
    private void setInitialConfusionText() {
        text = confusedPokemon.getName() + " is confused...";
    }

    /**
     * Render the text for the phase.
     * @param batch The SpriteBatch the text gets rendered to.
     */
    @Override
    public void renderText(SpriteBatch batch) {
        if (currentState == DISPLAY_CONFUSION ||
                currentState == DISPLAY_HURT_CONFUSION ||
                currentState == DISPLAY_FAINT_TEXT || currentState == SNAPPED_OUT) {
            pui.getFont().draw(batch, text.substring(0, textPosition), 54, 1143);
        }
    }
}
