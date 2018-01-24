package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability.AbilityId;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/15/2017.
 */

public class SentOutAbilityPhase extends BattlePhase {

    private String text;
    private double counter;
    private int textPosition;

    private int currentState;
    private int afterDepletionState;
    private int afterTextState;
    private final int INIT = 0;
    private final int DISPLAY_ABILITY = 1;
    private final int GO_TO_NEXT_PHASE = 2;
    private final int CHECK_ENTRY_HAZZARDS = 3;
    private final int SPIKES = 4;
    private final int STEALTH_ROCKS = 5;
    private final int TOXIC_SPIKES = 6;
    private final int STICKY_WEB = 7;
    private final int DEPLETE_HEALTH = 8;
    private final int HAZZARD_TEXT = 10;
    private final int FINISHED = 11;

    private Pokemon abilityUser;
    private Pokemon otherPokemon;
    private SubField subfield;
    private Field field;
    private boolean justStartedBattle;
    private boolean fainted;

    private List<String> hazzardText;
    private int hazzardTextIndex;

    private boolean abilityUserIsPlayerPokemon;

    private boolean checkedOtherPokemonAbility;
    private boolean trainerFainted; //For when the trainer's pokemon faints and they switch in the next one.

    /**
     * Called when a Pokemon switches in after they faint.
     * @param pui Reference to the BattleUpdater
     * @param sentOutPokemon The pokemon joining the battle.
     * @param enemyPokemon The pokemon waiting on the other side.
     * @param fainted Whether or not the previous pokemon fainted
     */
    public SentOutAbilityPhase(PhaseUpdaterInterface pui, Pokemon sentOutPokemon,
                               Pokemon enemyPokemon, boolean fainted) {
        super(pui);
        this.abilityUser = sentOutPokemon;
        this.otherPokemon = enemyPokemon;
        field = pui.getField();
        checkedOtherPokemonAbility = true;
        justStartedBattle = false;
        currentState = INIT;
        this.fainted = fainted;
        abilityUserIsPlayerPokemon = true;
        hazzardText = new ArrayList<String>();
        hazzardTextIndex = 0;
        trainerFainted = false;
    }

    /**
     * Called when a trainer sends in their next pokemon after their previous one fainted.
     * @param pui Reference to the BattleUpdater
     * @param sentOutPokemon The pokemon joining the battle.
     * @param enemyPokemon The pokemon waiting on the other side.
     */
    public SentOutAbilityPhase(PhaseUpdaterInterface pui, Pokemon sentOutPokemon,
                               Pokemon enemyPokemon) {
        super(pui);
        this.abilityUser = sentOutPokemon;
        this.otherPokemon = enemyPokemon;
        field = pui.getField();
        checkedOtherPokemonAbility = true;
        justStartedBattle = false;
        trainerFainted = true;
        currentState = INIT;
        fainted = false;
        trainerFainted = true;
        abilityUserIsPlayerPokemon = false;
        hazzardText = new ArrayList<String>();
        hazzardTextIndex = 0;
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
        hazzardText = new ArrayList<String>();
        hazzardTextIndex = 0;
        trainerFainted = false;
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
            if (pui.getUserPokemon().getBattleAbility().getId() == AbilityId.SAND_RUSH &&
                    pui.getField().getWeatherType() == WeatherType.SAND) {
                userSpeed *= 2;
            } else if (pui.getUserPokemon().getBattleAbility().getId() == AbilityId.SWIFT_SWIM &&
                    (pui.getField().getWeatherType() == WeatherType.RAIN ||
                            pui.getField().getWeatherType() == WeatherType.HEAVY_RAIN)) {
                userSpeed *= 2;
            } else if (pui.getUserPokemon().getBattleAbility().getId() == AbilityId.CHLOROPHYLL &&
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
            if (pui.getEnemyPokemon().getBattleAbility().getId() == AbilityId.SAND_RUSH &&
                    pui.getField().getWeatherType() == WeatherType.SAND) {
                enemySpeed *= 2;
            } else if (pui.getEnemyPokemon().getBattleAbility().getId() == AbilityId.SWIFT_SWIM &&
                    (pui.getField().getWeatherType() == WeatherType.RAIN ||
                            pui.getField().getWeatherType() == WeatherType.HEAVY_RAIN)) {
                enemySpeed *= 2;
            } else if (pui.getEnemyPokemon().getBattleAbility().getId() == AbilityId.CHLOROPHYLL &&
                    (pui.getField().getWeatherType() == WeatherType.SUN ||
                            pui.getField().getWeatherType() == WeatherType.HARSH_SUNSHINE)) {
                enemySpeed *= 2;
            }
            if (userSpeed >= enemySpeed) {
                abilityUser = pui.getUserPokemon();
                otherPokemon = pui.getEnemyPokemon();
                abilityUserIsPlayerPokemon = true;
            } else {
               abilityUser = pui.getEnemyPokemon();
                otherPokemon = pui.getUserPokemon();
                abilityUserIsPlayerPokemon = false;
            }
        }
        currentState = INIT;
    }

    private void init() {
        currentState = DISPLAY_ABILITY;
        SubField receiverField;
        if (abilityUser.getBattleAbility().getId() == AbilityId.INTIMIDATE) {
            if (abilityUserIsPlayerPokemon) {
                receiverField = field.getOpponentField();
            } else {
                receiverField = field.getPlayerField();
            }
            if (receiverField.hasMist()) {
                text = abilityUser.getName() + "'s Intimidate!\n" +
                        "Mist prevents the Attack from decreasing!";
            }
            else if (otherPokemon.getAttackStage() > -6) {
                otherPokemon.decreaseAttackStage(1);
                text = abilityUser.getName() + "'s Intimidate!\n" +
                        otherPokemon.getName() + "'s attack fell!";

            } else {
                text = abilityUser.getName() + "'s Intimidate!\n" +
                        otherPokemon.getName() + "'s attack cannot be lowered.";
            }

        } else if (abilityUser.getBattleAbility().getId() == AbilityId.DRIZZLE) {
            if (field.getWeatherType() == WeatherType.HEAVY_RAIN ||
                    field.getWeatherType() == WeatherType.HARSH_SUNSHINE ||
                    field.getWeatherType() == WeatherType.RAIN) {
                text = abilityUser.getName() + "'s Drizzle!\n" +
                        "It had no effect...";
            } else if (otherPokemon.getBattleAbility().getId() == AbilityId.CLOUD_NINE) {
                text = otherPokemon.getName() + " prevents " + abilityUser.getName() +"'s\n" +
                        "Drizzle with the ability Cloud Nine!";
            }  else {
                field.setWeather(WeatherType.RAIN, 5);
                text = abilityUser.getName() + "'s Drizzle!\n" +
                        "It started to rain!";
            }
        } else if (abilityUser.getBattleAbility().getId() == AbilityId.DROUGHT) {
            if (field.getWeatherType() == WeatherType.HEAVY_RAIN ||
                    field.getWeatherType() == WeatherType.HARSH_SUNSHINE ||
                    field.getWeatherType() == WeatherType.SUN) {
                text = abilityUser.getName() + "'s Drought!\n" +
                        "It had no effect...";
            } else if (otherPokemon.getBattleAbility().getId() == AbilityId.CLOUD_NINE) {
                text = otherPokemon.getName() + " prevents " + abilityUser.getName() +"'s\n" +
                        "Drought with the ability Cloud Nine!";
            }  else {
                field.setWeather(WeatherType.SUN, 5);
                text = abilityUser.getName() + "'s Drought!\n" +
                        "The sunlight turned harsh!";
            }
        } else if (abilityUser.getBattleAbility().getId() == AbilityId.SAND_STREAM) {
            if (field.getWeatherType() == WeatherType.HEAVY_RAIN ||
                    field.getWeatherType() == WeatherType.HARSH_SUNSHINE ||
                    field.getWeatherType() == WeatherType.SAND) {
                text = abilityUser.getName() + "'s Sand Stream!\n" +
                        "It had no effect...";
            } else if (otherPokemon.getBattleAbility().getId() == AbilityId.CLOUD_NINE) {
                text = otherPokemon.getName() + " prevents " + abilityUser.getName() +"'s\n" +
                        "Sand Stream with the ability Cloud Nine!";
            }  else {
                field.setWeather(WeatherType.SAND, 5);
                text = abilityUser.getName() + "'s Sand Stream!\n" +
                        "A sandstorm kicked up!";
            }
        } else if (abilityUser.getBattleAbility().getId() == AbilityId.SNOW_WARNING) {
            if (field.getWeatherType() == WeatherType.HEAVY_RAIN ||
                    field.getWeatherType() == WeatherType.HARSH_SUNSHINE ||
                    field.getWeatherType() == WeatherType.HAIL) {
                text = abilityUser.getName() + "'s Snow Warning!\n" +
                        "It had no effect...";
            } else if (otherPokemon.getBattleAbility().getId() == AbilityId.CLOUD_NINE) {
                text = otherPokemon.getName() + " prevents " + abilityUser.getName() +"'s\n" +
                        "Snow Warning with the ability Cloud Nine!";
            } else {
                field.setWeather(WeatherType.HAIL, 5);
                text = abilityUser.getName() + "'s Snow Warning!\n" +
                        "It started to hail!";
            }
        } else if (abilityUser.getBattleAbility().getId() == AbilityId.PRESSURE) {
            text = abilityUser.getName() + " is exerting its Pressure!";
        } else if (abilityUser.getBattleAbility().getId() == AbilityId.UNNERVE) {
            text = abilityUser.getName() + "'s Unnerve!\n" +
                    "Enemies cannot eat berries in their presence!";
        } else if (abilityUser.getBattleAbility().getId() == AbilityId.MOLD_BREAKER) {
            text = abilityUser.getName() + " breaks the mold!";
        } else if (abilityUser.getBattleAbility().getId() == AbilityId.CLOUD_NINE) {
            if (field.getWeatherType() != WeatherType.NORMAL) {
                text = abilityUser.getName() + "'s Cloud Nine!\n" +
                        "The effects of weather disappeared.";
                pui.getField().clearWeather();
            } else {
                //TODO: go to next phase.
                currentState = CHECK_ENTRY_HAZZARDS;
                //finishedCheckingAbility();
            }
        } else {
            currentState = CHECK_ENTRY_HAZZARDS;
            //finishedCheckingAbility();
        }
    }

    private void finishedCheckingAbilityAndHazzards() {
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
        abilityUserIsPlayerPokemon = !abilityUserIsPlayerPokemon;
    }

    private void checkEntryHazzards() {
        if (abilityUserIsPlayerPokemon) {
            subfield = field.getPlayerField();
        } else {
            subfield = field.getOpponentField();
        }
        if (subfield.hasEntryHazzards()) {
            if (subfield.hasSpikes()) {
                currentState = SPIKES;
            } else if (subfield.hasStealthRocks()) {
                currentState = STEALTH_ROCKS;
            } else if (subfield.hasToxicSpikes()) {
                currentState = TOXIC_SPIKES;
            } else if (subfield.hasStickyWeb()) {
                currentState = STICKY_WEB;
            } else {
                finishedCheckingAbilityAndHazzards();
            }
        } else {
            finishedCheckingAbilityAndHazzards();
        }
    }

    protected void updateHealth(double dt) {
        if (!abilityUser.matchingAnimationHealth()) {
            abilityUser.adjustAnimationHealth(1);
        } else {
            if (abilityUser.getCurrentHealth() == 0) {
                hazzardText.add(abilityUser.getName() + " fainted.");
            }
            currentState = HAZZARD_TEXT;
        }
    }


    private void checkStealthRocks() {
        if (subfield.hasStealthRocks()) {
            afterTextState = TOXIC_SPIKES;
            if (abilityUser.getBattleAbility().getId() == AbilityId.MAGIC_GUARD) {
                hazzardText.add(abilityUser.getName() + " is immune to Stealth Rocks" +
                        "\n" + "due to the ability Magic Guard.");
                currentState = HAZZARD_TEXT;
            } else {
                //Take Damage.
                int damage;
                if (abilityUser.getResistances().get(Pokemon.Type.ROCK) == 0.25) {
                    damage = (int)Math.ceil(abilityUser.getHealthStat() * .03125);
                } else if (abilityUser.getResistances().get(Pokemon.Type.ROCK) == 0.5) {
                    damage = (int)Math.ceil(abilityUser.getHealthStat() * .0625);
                } else if (abilityUser.getResistances().get(Pokemon.Type.ROCK) == 1) {
                    damage = (int)Math.ceil(abilityUser.getHealthStat() * .125);
                } else if (abilityUser.getResistances().get(Pokemon.Type.ROCK) == 2) {
                    damage = (int)Math.ceil(abilityUser.getHealthStat() * .25);
                } else {
                    damage = (int)Math.ceil(abilityUser.getHealthStat() * .5);
                }
                abilityUser.subtractHealth(damage);
                hazzardText.add(abilityUser.getName() + " was hurt by Stealth Rocks.");
                currentState = DEPLETE_HEALTH;
            }
        } else {
            currentState = TOXIC_SPIKES;
        }
    }

    private void checkToxicSpikes() {
        if (subfield.hasToxicSpikes()) {
            afterTextState = STICKY_WEB;
            if (absorbsToxicSpikes()) {
                hazzardText.add(abilityUser.getName() + " used its poison to absorb\n" +
                        "the Toxic Spikes!");
                subfield.removeToxicSpikes();
                currentState = HAZZARD_TEXT;
            } else if (immuneToToxicSpikes()) {
                currentState = STICKY_WEB;
            } else {
                //TODO: Implement badly poison
                abilityUser.setPreStatus(Pokemon.Status.POISON);
                hazzardText.add(abilityUser.getName() + " was poisoned by\nthe Toxic Spikes!");
                currentState = HAZZARD_TEXT;
            }
        } else {
            currentState = STICKY_WEB;
        }
    }

    private void checkStickyWeb() {
        if (subfield.hasStickyWeb()) {
            if (!immuneToStickyWeb()) {
                if (abilityUser.getSpeedStage() > -6) {
                    abilityUser.decreaseSpeedStage(1);
                    hazzardText.add(abilityUser.getName() + " was caught in Sticky Web.\n" +
                            abilityUser.getName() + "'s Speed fell!");
                    currentState = HAZZARD_TEXT;
                    afterTextState = FINISHED;
                }
            } else {
                finishedCheckingAbilityAndHazzards();
            }
        } else {
            finishedCheckingAbilityAndHazzards();
        }
    }

    private void checkSpikes() {
        int layers = subfield.getNumberOfSpikeLayers();
        boolean hasLayers = true;
        int damage = 0;
        if (layers == 1) {
            damage = (int)Math.ceil(abilityUser.getHealthStat() / 8.0);
        } else if (layers == 2) {
            damage = (int)Math.ceil(abilityUser.getHealthStat() / 6.0);
        } else if (layers == 3) {
            damage = (int)Math.ceil(abilityUser.getHealthStat() / 4.0);
        } else {
            hasLayers = false;
        }
        if (!hasLayers) {
            currentState = STEALTH_ROCKS;
        } else {
            afterTextState = STEALTH_ROCKS;
            if (!immuneToSpikes()) {
                abilityUser.subtractHealth(damage);
                currentState = DEPLETE_HEALTH;
                hazzardText.add(abilityUser.getName() + " took damage from spikes.");
            } else {
                currentState = HAZZARD_TEXT;
                hazzardText.add(abilityUser.getName() + " is immune to spikes.");
            }

        }
    }

    private boolean immuneToStickyWeb() {
        if (abilityUser.getBattleTypeOne() == Pokemon.Type.FLYING ||
                abilityUser.getBattleTypeTwo() == Pokemon.Type.FLYING ||
                abilityUser.getBattleAbility().getId() == AbilityId.LEVITATE) {
            return true;
        }
        return false;
    }

    private boolean immuneToSpikes() {
        if (abilityUser.getBattleAbility().getId() == AbilityId.MAGIC_GUARD) {
            //IMMUNE
            return true;
        } else if (abilityUser.getBattleAbility().getId() == AbilityId.LEVITATE ||
                abilityUser.getBattleTypeOne() == Pokemon.Type.FLYING ||
                abilityUser.getBattleTypeTwo() == Pokemon.Type.FLYING ||
                abilityUser.isMagnetRisen()) {
            if (abilityUser.isIngrained() || field.hasGravity()) {
                //TAKES DAMAGE ANYWAYS
                return false;
            } else {
                //IMMUNE
                return true;
            }
        }
        return false;
    }

    private boolean immuneToPoison() {
        if (abilityUser.getBattleTypeOne() == Pokemon.Type.POISON ||
                abilityUser.getBattleTypeTwo() == Pokemon.Type.POISON ||
                abilityUser.getBattleTypeOne() == Pokemon.Type.STEEL ||
                abilityUser.getBattleTypeTwo() == Pokemon.Type.STEEL) {
            return true;
        } else if (abilityUser.getBattleAbility().getId() == AbilityId.IMMUNITY ||
                (abilityUser.getBattleAbility().getId() == AbilityId.LEAF_GUARD &&
                pui.getField().getWeatherType() == WeatherType.SUN)) {
            return true;
        }
        return false;
    }

    private boolean immuneToToxicSpikes() {
        if (abilityUser.isStatused()) {
            return true;
        }
        else if (immuneToSpikes()) {
            return true;
        } else if (immuneToPoison()) {
            return true;
        }
        return false;
    }

    private boolean absorbsToxicSpikes() {
        if ((abilityUser.getBattleTypeOne() == Pokemon.Type.POISON ||
                abilityUser.getBattleTypeTwo() == Pokemon.Type.POISON) &&
                (abilityUser.getBattleTypeOne() != Pokemon.Type.FLYING ||
                abilityUser.getBattleTypeTwo() != Pokemon.Type.FLYING ||
                abilityUser.getBattleAbility().getId() != AbilityId.LEVITATE)) {
            return true;
        }
        return false;
    }

    @Override
    public void renderText(SpriteBatch batch) {
        if (currentState == DISPLAY_ABILITY) {
            pui.getFont().draw(batch, text.substring(0, textPosition), 54, 1143);
        } else if (currentState == HAZZARD_TEXT) {
            pui.getFont().draw(batch, hazzardText
                    .get(hazzardTextIndex).substring(0, textPosition), 54, 1143);
        }

    }

    @Override
    public void update(double dt) {
        if (currentState == INIT) {
            init();
        } else if (currentState == DISPLAY_ABILITY) {
            displayAbility(dt);
        } else if (currentState == GO_TO_NEXT_PHASE) {
            if (justStartedBattle || trainerFainted) {
                pui.endBattle();
            } else {
                //currentState = CHECK_ENTRY_HAZZARDS;
                if (fainted) {
                    pui.endBattle();
                } else {
                    //The pokemon switched in the middle of the battle
                    //so the other pokemon does their attack now.
                    pui.setPhase(new SleepCheckPhase(pui, false));
                }
            }
        } else if (currentState == HAZZARD_TEXT) {
            updateHazzardText(dt);
        } else if (currentState == DEPLETE_HEALTH) {
            updateHealth(dt);
        } else if (currentState == CHECK_ENTRY_HAZZARDS) {
            checkEntryHazzards();
        } else if (currentState == SPIKES) {
            checkSpikes();
        } else if (currentState == STEALTH_ROCKS) {
            checkStealthRocks();
        } else if (currentState == TOXIC_SPIKES) {
            checkToxicSpikes();
        } else if (currentState == STICKY_WEB) {
            checkStickyWeb();
        } else if (currentState == FINISHED) {
            finishedCheckingAbilityAndHazzards();
        }
    }

    private void updateHazzardText(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textPosition < hazzardText.get(hazzardTextIndex).length()) {
                textPosition++;
                counter = 0;
            }
        }
        if (counter >= 1.5) {
            counter = 0;
            textPosition = 0;
            if (hazzardTextIndex < hazzardText.size() - 1) {
                hazzardTextIndex++;
            } else {
                hazzardTextIndex = 0;
                hazzardText.clear();
                if (abilityUser.getCurrentHealth() == 0) {
                    //TODO: FAINT THEM AND FIND OUT IF PLAYER OR NOT.
                } else {
                    abilityUser.transferPreStatus();
                    currentState = afterTextState;
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
            currentState = CHECK_ENTRY_HAZZARDS;
        }
    }
}
