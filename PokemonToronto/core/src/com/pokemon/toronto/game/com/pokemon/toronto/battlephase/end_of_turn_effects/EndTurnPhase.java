package com.pokemon.toronto.game.com.pokemon.toronto.battlephase.end_of_turn_effects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.BattlePhase;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.BlackedOutPhase;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.ExpPhase;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.PhaseUpdaterInterface;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.PlayerPokemonFaintPhase;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.PoisonCheckPhase;

/**
 * Created by Gregory on 8/14/2017.
 */

public class EndTurnPhase extends BattlePhase {
    //States
    private final int WEATHER = 0;
    private final int DISPLAY_TEXT = 1;
    private final int CHECK_BLACK_OUT = 2;
    private final int USE_WEATHER_DAMAGE = 3;
    private final int USE_HAIL = 4;
    private final int CHECK_FUTURE_SIGHT = 5;
    private final int ADJUST_ENEMY_HEALTH = 6;
    private final int ADJUST_PLAYER_HEALTH = 7;
    private final int FAINT_ENEMY_POKEMON = 8;
    private final int FAINT_PLAYER_POKEMON = 9;
    private final int DISPLAY_ENEMY_FAINT_TEXT = 10;
    private final int DISPLAY_PLAYER_FAINT_TEXT = 11;


    //End turn weather results
    private final boolean THE_WEATHER_CLEARED = true;
    private final boolean THE_WEATHER_REMAINS = false;

    private int currentState;
    private int stateAfterText;
    private int stateAfterHealthAdjustment;
    private int stateAfterNotBlackingOut;
    private int stateAfterFaint; //which state to go to after a faint occurs

    //Whether or not we're using something on the enemy.
    //It is used to keep track of which Pokemon is being effected so it can make a judgement
    //on where to go next in the end turn phase.
    private boolean usingOnEnemy;

    private String text;
    private String playerFaintText;
    private String enemyFaintText;
    private double counter;
    private int textPosition;
    public EndTurnPhase(PhaseUpdaterInterface pui) {
        super(pui);
        phaseName = "End Turn Phase";
        textPosition = 0;
        counter = 0;
        currentState = WEATHER;
        usingOnEnemy = true;
        playerFaintText = pui.getUserPokemon().getName() + " fainted.";
        enemyFaintText = pui.getEnemyPokemon().getName() + " fainted.";
    }

    @Override
    public void update(double dt) {
        if (currentState == WEATHER) {
            updateWeather();
        } else if (currentState == DISPLAY_TEXT) {
            displayText(dt);
        } else if (currentState == USE_WEATHER_DAMAGE) {
            useWeatherDamage();
        } else if (currentState == USE_HAIL) {
            useHail();
        } else if (currentState == ADJUST_ENEMY_HEALTH) {
            adjustEnemyHealth(dt);
        } else if (currentState == ADJUST_PLAYER_HEALTH) {
            adjustPlayerHealth(dt);
        } else if (currentState == DISPLAY_ENEMY_FAINT_TEXT) {
            displayEnemyFaintText(dt);
        } else if (currentState == DISPLAY_PLAYER_FAINT_TEXT) {
            displayPlayerFaintText(dt);
        } else if (currentState == FAINT_ENEMY_POKEMON) {
            updateEnemyFaintAnimation(dt);
        } else if (currentState == CHECK_BLACK_OUT) {
            checkBlackout();
        } else if (currentState == CHECK_FUTURE_SIGHT) {
            pui.setPhase(new PoisonCheckPhase(pui));
        } else if (currentState == FAINT_PLAYER_POKEMON) {
            updateUserFaintAnimation(dt);
        }
    }

    // GENERAL METHODS
    private void displayText(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textPosition < text.length()) {
                textPosition++;
                counter = 0;
            }
        }
        if (counter >= 1.5) {
            counter = 0;
            textPosition = 0;
            currentState = stateAfterText;
        }
    }

    private void displayEnemyFaintText(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textPosition < enemyFaintText.length()) {
                textPosition++;
                counter = 0;
            }
        }
        if (counter >= 1.5) {
            counter = 0;
            textPosition = 0;
            currentState = FAINT_ENEMY_POKEMON;
        }
    }

    private void displayPlayerFaintText(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textPosition < playerFaintText.length()) {
                textPosition++;
                counter = 0;
            }
        }
        if (counter >= 1.5) {
            counter = 0;
            textPosition = 0;
            currentState = FAINT_PLAYER_POKEMON;
        }
    }

    private void adjustEnemyHealth(double dt) {
        if (!pui.getEnemyPokemon().matchingAnimationHealth()) {
            pui.getEnemyPokemon().adjustAnimationHealth(1);
        } else {
            currentState = stateAfterHealthAdjustment;
        }
    }

    private void adjustPlayerHealth(double dt) {
        if (!pui.getUserPokemon().matchingAnimationHealth()) {
            pui.getUserPokemon().adjustAnimationHealth(1);
        } else {
            currentState = stateAfterHealthAdjustment;
        }
    }

    private void checkBlackout() {
        if (pui.playerHasMorePokemon() && !pui.waitingForNextPokemon()) {
            currentState = stateAfterNotBlackingOut;
        } else if (!pui.playerHasMorePokemon()) {
            pui.setPhase(new BlackedOutPhase(pui));
        }
    }

    private void updateUserFaintAnimation(double dt) {
        pui.getUserPokemon().setPlayerY((int)(pui.getUserPokemon().getPlayerY() - 10));
        if (pui.getUserPokemon().getPlayerY() <= pui.getUserPokemon().getFaintedPlayerY()) {
            //Make the pokemon faint when it went down to the right faint position
            pui.getUserPokemon().setPlayerY(pui.getUserPokemon().getFaintedPlayerY());
            pui.getUserPokemon().setFaint(true);
            currentState = CHECK_BLACK_OUT;
        }
    }

    private void updateEnemyFaintAnimation(double dt) {
        pui.getEnemyPokemon().setEnemyY((int)(pui.getEnemyPokemon().getEnemyY() - 10));
        if (pui.getEnemyPokemon().getEnemyY() <= pui.getEnemyPokemon().getFaintedEnemyY()) {
            //Make the pokemon faint when it went down to the right faint position
            pui.getEnemyPokemon().setEnemyY(pui.getEnemyPokemon().getFaintedEnemyY());
            pui.getEnemyPokemon().setFaint(true);
            currentState = stateAfterFaint;

        }
    }

    private void useHail() {
        Pokemon pokemon;
        if (usingOnEnemy) {
            pokemon = pui.getEnemyPokemon();
        } else {
            pokemon = pui.getUserPokemon();
        }
        //Enemy
        if (pokemon.getAbility() == Pokemon.Ability.ICE_BODY ||
                pokemon.getAbility() == Pokemon.Ability.SNOW_CLOAK ||
                pokemon.getAbility() == Pokemon.Ability.MAGIC_GUARD ||
                pokemon.getAbility() == Pokemon.Ability.OVERCOAT ||
                pokemon.getTypeOne() == Pokemon.Type.ICE ||
                pokemon.getTypeTwo() == Pokemon.Type.ICE) { //TODO: Check for holding safety goggles
            if (pokemon.getAbility() == Pokemon.Ability.ICE_BODY && !pokemon.hasFullHealth()){
                //Recover
                recoverPokemonFromHail(pokemon);
            } else {
                //Nothing happens -- Switch to use on next pokemon or go to next state.
                if (usingOnEnemy) {
                    usingOnEnemy = false;
                } else {
                    currentState = CHECK_FUTURE_SIGHT;
                }
            }
        } else {
            //Gets hit
            damagePokemonFromHail(pokemon);
        }
    }

    private void recoverPokemonFromHail(Pokemon pokemon) {
        int recoverAmount = (int)Math.round(pokemon.getHealthStat() / 16.0);
        pokemon.addHealth(recoverAmount);
        text = pokemon.getName() + " recovered health in hail\nwith the ability Ice Body.";
        currentState = DISPLAY_TEXT;
        if (usingOnEnemy) {
            stateAfterText = ADJUST_ENEMY_HEALTH;
            stateAfterHealthAdjustment = USE_HAIL;
            usingOnEnemy = false;
        } else {
            stateAfterText = ADJUST_PLAYER_HEALTH;
            stateAfterHealthAdjustment = CHECK_FUTURE_SIGHT;
            usingOnEnemy = true;
        }
    }

    /**
     * Damage a Pokemon that gets hit by hail.
     * @param pokemon The Pokemon getting buffetted by hail.
     */
    private void damagePokemonFromHail(Pokemon pokemon) {
        int damage = (int)Math.round(pokemon.getHealthStat() / 16.0);
        pokemon.subtractHealth(damage);
        text = pokemon.getName() + " was buffeted by hail.";

        currentState = DISPLAY_TEXT;
        if (usingOnEnemy) {
            stateAfterText = ADJUST_ENEMY_HEALTH;
            if (pokemon.getCurrentHealth() != 0) {
                stateAfterHealthAdjustment = USE_HAIL;
                usingOnEnemy = false;
            } else {
                stateAfterHealthAdjustment = DISPLAY_ENEMY_FAINT_TEXT;
                stateAfterFaint = USE_HAIL;
                usingOnEnemy = false;
            }
        } else {
            stateAfterText = ADJUST_PLAYER_HEALTH;
            if (pokemon.getCurrentHealth() != 0) {
                stateAfterHealthAdjustment = CHECK_FUTURE_SIGHT;
                usingOnEnemy = true;
            } else {
                stateAfterHealthAdjustment = DISPLAY_PLAYER_FAINT_TEXT;
                stateAfterNotBlackingOut = CHECK_FUTURE_SIGHT;
                usingOnEnemy = true;
            }
        }
    }



    private void useWeatherDamage() {
        if (pui.getField().getWeatherType() == WeatherType.HAIL) {
            usingOnEnemy = true;
            currentState = USE_HAIL;
        }
    }

    private void updateWeather() {
        if (pui.getField().getWeatherType() != WeatherType.NORMAL) {
            if (pui.getField().onLastWeatherTurn()) {
                currentState = DISPLAY_TEXT;
                setWeatherResultText(THE_WEATHER_CLEARED);
                pui.getField().clearWeather();
                stateAfterText = CHECK_FUTURE_SIGHT;
            } else {
                currentState = DISPLAY_TEXT;
                setWeatherResultText(THE_WEATHER_REMAINS);
                if (pui.getField().hasDamagingWeatherConditions()) {
                    stateAfterText = USE_WEATHER_DAMAGE;
                } else {
                    stateAfterText = CHECK_FUTURE_SIGHT;
                }
                pui.getField().adjustWeather();
            }

        } else {
            currentState = CHECK_FUTURE_SIGHT;
        }
    }

    private void setWeatherResultText(boolean cleared) {
        if (pui.getField().getWeatherType() == WeatherType.HAIL) {
            if (cleared) {
                text = "The hail stopped.";
            } else {
                text = "Hail continues to fall.";
            }
        } else if (pui.getField().getWeatherType() == WeatherType.SAND) {
            if (cleared) {
                text = "The sandstorm subsided.";
            } else {
                text = "The sandstorm rages.";
            }
        } else if (pui.getField().getWeatherType() == WeatherType.RAIN ||
                pui.getField().getWeatherType() == WeatherType.HEAVY_RAIN) {
            if (cleared) {
                text = "The rain stopped.";
            } else {
                text = "Rain continues to fall.";
            }
        } else if (pui.getField().getWeatherType() == WeatherType.SUN ||
                pui.getField().getWeatherType() == WeatherType.HARSH_SUNSHINE) {
            if (cleared) {
                text = "The sunlight faded.";
            } else {
                text = "The sunlight is strong.";
            }
        } else if (pui.getField().getWeatherType() == WeatherType.STRONG_WINDS) {
            if (cleared) {
                text = "The mysterious air current has dissipated!";
            } else {
                text = "The mysterious air current blows on regardless!";
            }
        }
    }

    @Override
    public void renderText(SpriteBatch batch) {
        if (currentState == DISPLAY_TEXT) {
            pui.getFont().draw(batch, text.substring(0, textPosition), 54, 1143);
        } else if (currentState == DISPLAY_ENEMY_FAINT_TEXT) {
            pui.getFont().draw(batch, enemyFaintText.substring(0, textPosition), 54, 1143);
        } else if (currentState == DISPLAY_PLAYER_FAINT_TEXT) {
            pui.getFont().draw(batch, playerFaintText.substring(0, textPosition), 54, 1143);
        }
    }
}
