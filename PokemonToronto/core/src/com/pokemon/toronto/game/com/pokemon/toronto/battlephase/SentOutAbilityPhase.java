package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;

/**
 * Created by Gregory on 8/15/2017.
 */

public class SentOutAbilityPhase extends BattlePhase {

    private String text;
    private double counter;
    private int textPosition;

    private int currentState;
    private final int INIT = 0;
    private final int DISPLAY_ABILITY = 1;
    private final int GO_TO_NEXT_PHASE = 2;

    private Pokemon abilityUser;
    private Pokemon otherPokemon;
    private Field field;
    private boolean justStartedBattle;
    private boolean fainted;

    private boolean checkedOtherPokemonAbility;

    /**
     * Called when a Pokemon switches in after they faint.
     * @param pui Reference to the BattleUpdater
     * @param sentOutPokemon The pokemon joining the battle.
     * @param enemyPokemon The pokemon waiting on the other side.
     * @param fainted Whether or not the previous pokemon fainted
     */
    public SentOutAbilityPhase(PhaseUpdaterInterface pui, Pokemon sentOutPokemon, Pokemon enemyPokemon, boolean fainted) {
        super(pui);
        this.abilityUser = sentOutPokemon;
        this.otherPokemon = enemyPokemon;
        field = pui.getField();
        checkedOtherPokemonAbility = true;
        justStartedBattle = false;
        currentState = INIT;
        this.fainted = fainted;
    }

    /**
     * Called at the beginning of a battle. Uses the abilities of both pokemon.
     * @param pui Reference to the BattleUpdater
     */
    public SentOutAbilityPhase(PhaseUpdaterInterface pui) {
        super(pui);
        field = pui.getField();
        this.justStartedBattle = true;
        checkedOtherPokemonAbility = false;
        initFirstAbilityUser();
        fainted = false;
    }
    
    private void initFirstAbilityUser() {
        if (justStartedBattle) {
            //Speed Clash
            double userSpeed = pui.getUserPokemon().getSpeedStat();
            int stage = pui.getUserPokemon().getSpeedStage();
            if (stage > 0) {
                userSpeed *= ((2 + stage) / 2);
            } else if (stage < 0) {
                userSpeed *= (2 / (Math.abs(stage) + 2));
            }
            if (pui.getUserPokemon().isParalyzed()) {
                userSpeed *= 0.5;
            }
            if (pui.getUserPokemon().getAbility() == Pokemon.Ability.SAND_RUSH &&
                    pui.getField().getWeatherType() == WeatherType.SAND) {
                userSpeed *= 2;
            } else if (pui.getUserPokemon().getAbility() == Pokemon.Ability.SWIFT_SWIM &&
                    (pui.getField().getWeatherType() == WeatherType.RAIN ||
                            pui.getField().getWeatherType() == WeatherType.HEAVY_RAIN)) {
                userSpeed *= 2;
            } else if (pui.getUserPokemon().getAbility() == Pokemon.Ability.CHLOROPHYLL &&
                    (pui.getField().getWeatherType() == WeatherType.SUN ||
                            pui.getField().getWeatherType() == WeatherType.HARSH_SUNSHINE)) {
                userSpeed *= 2;
            }
            double enemySpeed = pui.getEnemyPokemon().getSpeedStat();
            stage = pui.getEnemyPokemon().getSpeedStage();
            if (stage > 0) {
                enemySpeed *= ((2 + stage) / 2);
            } else if (stage < 0) {
                enemySpeed *= (2.0 / (Math.abs(stage) + 2));
            }
            if (pui.getEnemyPokemon().isParalyzed()) {
                enemySpeed *= 0.5;
            }
            if (pui.getEnemyPokemon().getAbility() == Pokemon.Ability.SAND_RUSH &&
                    pui.getField().getWeatherType() == WeatherType.SAND) {
                enemySpeed *= 2;
            } else if (pui.getEnemyPokemon().getAbility() == Pokemon.Ability.SWIFT_SWIM &&
                    (pui.getField().getWeatherType() == WeatherType.RAIN ||
                            pui.getField().getWeatherType() == WeatherType.HEAVY_RAIN)) {
                enemySpeed *= 2;
            } else if (pui.getEnemyPokemon().getAbility() == Pokemon.Ability.CHLOROPHYLL &&
                    (pui.getField().getWeatherType() == WeatherType.SUN ||
                            pui.getField().getWeatherType() == WeatherType.HARSH_SUNSHINE)) {
                enemySpeed *= 2;
            }
            if (userSpeed >= enemySpeed) {
                abilityUser = pui.getUserPokemon();
                otherPokemon = pui.getEnemyPokemon();
            } else {
               abilityUser = pui.getEnemyPokemon();
                otherPokemon = pui.getUserPokemon();
            }
        }
        currentState = INIT;
    }

    private void init() {
        currentState = DISPLAY_ABILITY;
        if (abilityUser.getAbility() == Pokemon.Ability.INTIMIDATE) {
            if (otherPokemon.getAttackStage() > -6) {
                otherPokemon.decreaseAttackStage(1);
                text = abilityUser.getName() + "'s Intimidate!\n" +
                        otherPokemon.getName() + "'s attack fell!";

            } else {
                text = abilityUser.getName() + "'s Intimidate!\n" +
                        otherPokemon.getName() + "'s attack cannot be lowered.";
            }

        } else if (abilityUser.getAbility() == Pokemon.Ability.DRIZZLE) {
            if (field.getWeatherType() == WeatherType.HEAVY_RAIN ||
                    field.getWeatherType() == WeatherType.HARSH_SUNSHINE ||
                    field.getWeatherType() == WeatherType.RAIN) {
                text = abilityUser.getName() + "'s Drizzle!\n" +
                        "It had no effect...";
            } else if (otherPokemon.getAbility() == Pokemon.Ability.CLOUD_NINE) {
                text = otherPokemon.getName() + " prevents " + abilityUser.getName() +"'s\n" +
                        "Drizzle with the ability Cloud Nine!";
            }  else {
                field.setWeather(WeatherType.RAIN, 5);
                text = abilityUser.getName() + "'s Drizzle!\n" +
                        "It started to rain!";
            }
        } else if (abilityUser.getAbility() == Pokemon.Ability.DROUGHT) {
            if (field.getWeatherType() == WeatherType.HEAVY_RAIN ||
                    field.getWeatherType() == WeatherType.HARSH_SUNSHINE ||
                    field.getWeatherType() == WeatherType.SUN) {
                text = abilityUser.getName() + "'s Drought!\n" +
                        "It had no effect...";
            } else if (otherPokemon.getAbility() == Pokemon.Ability.CLOUD_NINE) {
                text = otherPokemon.getName() + " prevents " + abilityUser.getName() +"'s\n" +
                        "Drought with the ability Cloud Nine!";
            }  else {
                field.setWeather(WeatherType.SUN, 5);
                text = abilityUser.getName() + "'s Drought!\n" +
                        "The sunlight turned harsh!";
            }
        } else if (abilityUser.getAbility() == Pokemon.Ability.SAND_STREAM) {
            if (field.getWeatherType() == WeatherType.HEAVY_RAIN ||
                    field.getWeatherType() == WeatherType.HARSH_SUNSHINE ||
                    field.getWeatherType() == WeatherType.SAND) {
                text = abilityUser.getName() + "'s Sand Stream!\n" +
                        "It had no effect...";
            } else if (otherPokemon.getAbility() == Pokemon.Ability.CLOUD_NINE) {
                text = otherPokemon.getName() + " prevents " + abilityUser.getName() +"'s\n" +
                        "Sand Stream with the ability Cloud Nine!";
            }  else {
                field.setWeather(WeatherType.SAND, 5);
                text = abilityUser.getName() + "'s Sand Stream!\n" +
                        "A sandstorm kicked up!";
            }
        } else if (abilityUser.getAbility() == Pokemon.Ability.SNOW_WARNING) {
            if (field.getWeatherType() == WeatherType.HEAVY_RAIN ||
                    field.getWeatherType() == WeatherType.HARSH_SUNSHINE ||
                    field.getWeatherType() == WeatherType.HAIL) {
                text = abilityUser.getName() + "'s Snow Warning!\n" +
                        "It had no effect...";
            } else if (otherPokemon.getAbility() == Pokemon.Ability.CLOUD_NINE) {
                text = otherPokemon.getName() + " prevents " + abilityUser.getName() +"'s\n" +
                        "Snow Warning with the ability Cloud Nine!";
            } else {
                field.setWeather(WeatherType.HAIL, 5);
                text = abilityUser.getName() + "'s Snow Warning!\n" +
                        "It started to hail!";
            }
        } else if (abilityUser.getAbility() == Pokemon.Ability.PRESSURE) {
            text = abilityUser.getName() + " is exerting its Pressure!";
        } else if (abilityUser.getAbility() == Pokemon.Ability.UNNERVE) {
            text = abilityUser.getName() + "'s Unnerve!\n" +
                    "Enemies cannot eat berries in their presence!";
        } else if (abilityUser.getAbility() == Pokemon.Ability.MOLD_BREAKER) {
            text = abilityUser.getName() + " breaks the mold!";
        } else if (abilityUser.getAbility() == Pokemon.Ability.CLOUD_NINE) {
            if (field.getWeatherType() != WeatherType.NORMAL) {
                text = abilityUser.getName() + "'s Cloud Nine!\n" +
                        "The effects of weather disappeared.";
                pui.getField().clearWeather();
            } else {
                //TODO: go to next phase.
                finishedCheckingAbility();
            }
        } else {
            finishedCheckingAbility();
        }
    }

    private void finishedCheckingAbility() {
        if (checkedOtherPokemonAbility) {
            currentState = GO_TO_NEXT_PHASE;
        } else {
            swapPokemon();
        }
    }

    private void swapPokemon() {
        Pokemon temp;
        temp = abilityUser;
        abilityUser = otherPokemon;
        otherPokemon = temp;
        checkedOtherPokemonAbility = true;
        currentState = INIT;
    }

    @Override
    public void renderText(SpriteBatch batch) {
        if (currentState == DISPLAY_ABILITY) {
            pui.getFont().draw(batch, text.substring(0, textPosition), 54, 1143);
        }

    }

    @Override
    public void update(double dt) {
        if (currentState == INIT) {
            init();
        } else if (currentState == DISPLAY_ABILITY) {
            displayAbility(dt);
        } else if (currentState == GO_TO_NEXT_PHASE) {
            if (justStartedBattle) {
                pui.endBattle();
            } else {
                if (fainted) {
                    pui.endBattle();
                } else {
                    //The pokemon switched in the middle of the battle
                    //so the other pokemon does their attack now.
                    pui.setPhase(new SleepCheckPhase(pui, false));
                }
            }
        }
    }

    private void displayAbility(double dt) {
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
            finishedCheckingAbility();
        }
    }
}
