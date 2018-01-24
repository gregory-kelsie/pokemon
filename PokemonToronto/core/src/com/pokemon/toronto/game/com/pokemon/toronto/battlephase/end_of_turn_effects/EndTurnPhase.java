package com.pokemon.toronto.game.com.pokemon.toronto.battlephase.end_of_turn_effects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability.AbilityId;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.BattlePhase;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.BlackedOutPhase;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.EndTrainerBattle;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.ExpPhase;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.PhaseUpdaterInterface;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.PlayerPokemonFaintPhase;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug.Infestation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.PerishSong;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic.HurtByFutureSight;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.HurtByDoomDesire;

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
    private final int USE_SAND = 12;
    private final int USE_RAIN = 13;
    private final int USE_SUN = 14;
    private final int DOUBLE_KNOCKOUT = 15;
    private final int END_GAME = 16;
    private final int WISH_STATE = 17;
    private final int HEALING_ABILITIES = 18;
    private final int AQUA_RING_STATE = 19;
    private final int INGRAIN_STATE = 20;
    private final int LEECH_SEED = 21;
    private final int RECEIVE_LEECH_SEED_DRAIN = 22;
    private final int NEGATIVE_STATUS = 23;
    private final int NIGHTMARES = 24;
    private final int CURSE = 25;
    private final int BIND_STATE = 26;
    private final int CLAMP_STATE = 27;
    private final int WHIRLPOOL_STATE = 28;
    private final int MIST_STATE = 29;
    private final int TAILWIND = 30;
    private final int FIRE_SPIN = 31;
    private final int INFESTATION = 32;
    private final int SAND_TOMB = 33;
    private final int REFLECT = 34;
    private final int LIGHT_SCREEN = 35;
    private final int TRICK_ROOM = 36;
    private final int PERISH_SONG = 37;
    private final int YAWN = 38;
    private final int WRAP = 39;


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

    private boolean skipUser;
    private boolean skipEnemy;

    //Keep track of how much health was drained when
    //leech seed was used.
    private int leechSeedDrain;

    public EndTurnPhase(PhaseUpdaterInterface pui) {
        super(pui);
        phaseName = "End Turn Phase";
        textPosition = 0;
        counter = 0;
        currentState = WEATHER;
        usingOnEnemy = true;
        playerFaintText = pui.getUserPokemon().getName() + " fainted.";
        enemyFaintText = pui.getEnemyPokemon().getName() + " fainted.";
        skipUser = false;
        skipEnemy = false;
        adjustEndTurnEffects();
    }

    public EndTurnPhase(PhaseUpdaterInterface pui, boolean skipUser, boolean skipEnemy) {
        super(pui);
        phaseName = "End Turn Phase";
        textPosition = 0;
        counter = 0;
        currentState = WEATHER;
        usingOnEnemy = true;
        playerFaintText = pui.getUserPokemon().getName() + " fainted.";
        enemyFaintText = pui.getEnemyPokemon().getName() + " fainted.";
        this.skipUser = skipUser;
        this.skipEnemy = skipEnemy;
        adjustEndTurnEffects();
    }

    private void adjustEndTurnEffects() {
        removePowder();
        pui.getUserPokemon().adjustCharge();
        pui.getUserPokemon().setFirstTurn(false);
        pui.getEnemyPokemon().setFirstTurn(false);
        pui.getUserPokemon().adjustLaserFocus();
        pui.getEnemyPokemon().adjustLaserFocus();
        pui.getEnemyPokemon().adjustCharge();
        resetDamageTakenThisTurn();
    }

    /**
     * Remove the powder effect from the battling Pokemon since
     * it lasts only 1 turn.
     */
    private void removePowder() {
        pui.getUserPokemon().removePowder();
        pui.getEnemyPokemon().removePowder();
    }

    /**
     * Reset the Pokemon knowing how much damage they've taken for the
     * turn because it is the End Turn phase where this doesn't have
     * to be remembered anymore.
     */
    private void resetDamageTakenThisTurn() {
        pui.getUserPokemon().resetDamageTakenThisTurn();
        pui.getEnemyPokemon().resetDamageTakenThisTurn();
    }

    @Override
    public void update(double dt) {
        Gdx.app.log("endphase", "" + currentState);
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
            checkFutureSight();
        } else if (currentState == FAINT_PLAYER_POKEMON) {
            updateUserFaintAnimation(dt);
        } else if (currentState == USE_SAND) {
            useSandstorm();
        } else if (currentState == USE_RAIN) {
            useRain();
        } else if (currentState == USE_SUN) {
            useSunlight();
        } else if (currentState == DOUBLE_KNOCKOUT) {
            if (pui.isWildBattle()) {
                pui.finishedBattle();
            } else {
                if (pui.hasWipedOutTrainer()) {
                    pui.setPhase(new EndTrainerBattle(pui));
                } else {
                    pui.setTrainerDoubleFaint();
                    pui.setPhase(new PlayerPokemonFaintPhase(pui));
                }
            }
        } else if (currentState == END_GAME) {
            if (pui.getEnemyPokemon().getCurrentHealth() == 0 &&
                    pui.getUserPokemon().getCurrentHealth() > 0) {
                pui.setPhase(new ExpPhase(pui));
            } else if (pui.getEnemyPokemon().getCurrentHealth() > 0 &&
                    pui.getUserPokemon().getCurrentHealth() > 0) {
                pui.endBattle();
            } else {
                if (pui.playerHasMorePokemon() && !pui.waitingForNextPokemon()) {
                    pui.setPhase(new PlayerPokemonFaintPhase(pui));
                } else if (!pui.playerHasMorePokemon()) {
                    pui.setPhase(new BlackedOutPhase(pui));
                }
            }
        } else if (currentState == WISH_STATE) {
            checkWish();
        } else if (currentState == HEALING_ABILITIES) {
            checkHealingAbilities();
        } else if (currentState == AQUA_RING_STATE) {
            checkAquaRing();
        } else if (currentState == INGRAIN_STATE) {
            checkIngrain();
        } else if (currentState == LEECH_SEED) {
            checkLeechSeed();
        } else if (currentState == RECEIVE_LEECH_SEED_DRAIN) {
            receiveLeechSeedDrain();
        } else if (currentState == NEGATIVE_STATUS) {
            checkNegativeStatus();
        } else if (currentState == NIGHTMARES) {
            checkNightmares();
        } else if (currentState == CURSE) {
            checkCurse();
        } else if (currentState == BIND_STATE) {
            checkBind();
        } else if (currentState == CLAMP_STATE) {
            checkClamp();
        } else if (currentState == WHIRLPOOL_STATE) {
            checkWhirlpool();
        } else if (currentState == MIST_STATE) {
            adjustMist();
        } else if (currentState == TAILWIND) {
            adjustTailwind();
        } else if (currentState == FIRE_SPIN) {
            checkFireSpin();
        } else if (currentState == INFESTATION) {
            checkInfestation();
        } else if (currentState == SAND_TOMB) {
            checkSandTomb();
        } else if (currentState == TRICK_ROOM) {
            adjustTrickRoom();
        } else if (currentState == PERISH_SONG) {
            adjustPerishSong();
        } else if (currentState == YAWN) {
            adjustYawn();
        } else if (currentState == WRAP) {
            adjustWrap();
        } else if (currentState == LIGHT_SCREEN) {
            adjustLightScreen();
        } else if (currentState == REFLECT) {
            adjustReflect();
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
            pui.getEnemyPokemon().transferPreStatus();
            pui.getUserPokemon().transferPreStatus();
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
            pui.playFaintSound();
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
            pui.playFaintSound();
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

    private void adjustMist() {
        if (usingOnEnemy) {
            if (pui.getField().getOpponentField().hasMist()) {
                pui.getField().getOpponentField().adjustMist();
                if (!pui.getField().getOpponentField().hasMist()) {
                    currentState = DISPLAY_TEXT;
                    stateAfterText = MIST_STATE;
                    text = "The mist has faded...";
                }
            }
            usingOnEnemy = false;
        } else {
            if (pui.getField().getPlayerField().hasMist()) {
                pui.getField().getPlayerField().adjustMist();
                if (!pui.getField().getPlayerField().hasMist()) {
                    currentState = DISPLAY_TEXT;
                    text = "The mist has faded...";
                    stateAfterText = TAILWIND;
                } else {
                    currentState = TAILWIND;
                }
            } else {
                currentState = TAILWIND;
            }
            usingOnEnemy = true;
        }
    }

    private void adjustYawn() {
        Pokemon currentPokemon = getCurrentPokemon();
        if (usingOnEnemy) {
            if (currentPokemon.justReceivedYawn()) {
                currentPokemon.passFirstYawnTurn();
            } else if (currentPokemon.isYawned() && currentPokemon.isSleepable() &&
                    !pui.getUserPokemon().isUproaring()) {
                text = currentPokemon.getName() + " fell asleep!";
                currentPokemon.induceSleep();
                currentState = DISPLAY_TEXT;
                stateAfterText = YAWN;
            }
            usingOnEnemy = false;
        } else {
            if (currentPokemon.justReceivedYawn()) {
                currentPokemon.passFirstYawnTurn();
                currentState = END_GAME;
            } else if (currentPokemon.isYawned() && currentPokemon.isSleepable() &&
                    !pui.getEnemyPokemon().isUproaring()) {
                text = currentPokemon.getName() + " fell asleep!";
                currentPokemon.induceSleep();
                currentState = DISPLAY_TEXT;
                stateAfterText = END_GAME;
            } else {
                currentState = END_GAME;
            }
            usingOnEnemy = true;
        }
    }

    private void adjustTrickRoom() {
        if (pui.getField().hasTrickRoom()) {
            pui.getField().adjustTrickRoom();
            if (!pui.getField().hasTrickRoom()) {
                currentState = DISPLAY_TEXT;
                stateAfterText = YAWN;
                text = "Trick Room has ended...";
            } else {
                currentState = YAWN;
            }
        } else {
            currentState = YAWN;
        }
    }

    private void adjustTailwind() {
        if (usingOnEnemy) {
            if (pui.getField().getOpponentField().hasTailwind()) {
                pui.getField().getOpponentField().adjustTailwind();
                if (!pui.getField().getOpponentField().hasTailwind()) {
                    currentState = DISPLAY_TEXT;
                    stateAfterText = TAILWIND;
                    text = "The Tailwind has faded...";
                }
            }
            usingOnEnemy = false;
        } else {
            if (pui.getField().getPlayerField().hasTailwind()) {
                pui.getField().getPlayerField().adjustTailwind();
                if (!pui.getField().getPlayerField().hasTailwind()) {
                    currentState = DISPLAY_TEXT;
                    text = "The Tailwind has faded...";
                    stateAfterText = TRICK_ROOM;
                } else {
                    currentState = TRICK_ROOM;
                }
            } else {
                currentState = TRICK_ROOM;
            }
            usingOnEnemy = true;

        }
    }

    private void adjustPerishSong() {
        Pokemon currentPokemon = getCurrentPokemon();
        if (currentPokemon.getCurrentHealth() != 0) {
            if (currentPokemon.getPerishSongTime() == 1 && currentPokemon.heardPerishSong()) {
                currentPokemon.removePerishSong();
                text = currentPokemon.getName() + "'s Perish Count fell to 0!";
                if (usingOnEnemy) {
                    currentState = DISPLAY_TEXT;
                    stateAfterHealthAdjustment = DISPLAY_ENEMY_FAINT_TEXT;
                    stateAfterText = ADJUST_ENEMY_HEALTH;
                    stateAfterFaint = PERISH_SONG;
                    usingOnEnemy = false;
                } else {
                    currentState = DISPLAY_TEXT;
                    stateAfterHealthAdjustment = DISPLAY_PLAYER_FAINT_TEXT;
                    stateAfterText = ADJUST_PLAYER_HEALTH;
                    stateAfterNotBlackingOut = REFLECT;
                    usingOnEnemy = true;
                }
            } else if (currentPokemon.heardPerishSong()) {
                text = currentPokemon.getName() + "'s Perish Count fell to" +
                        currentPokemon.getPerishSongTime() + "!";
                currentPokemon.adjustPerishSongDuration();
                adjustStates(currentPokemon, PERISH_SONG, REFLECT);
            } else {
                noStateUse(REFLECT);
            }
        } else {
            noStateUse(REFLECT);
        }
    }

    private void adjustLightScreen() {
        if (usingOnEnemy) {
            if (pui.getField().getOpponentField().hasLightScreen()) {
                pui.getField().getOpponentField().adjustLightScreen();
                if (!pui.getField().getOpponentField().hasLightScreen()) {
                    currentState = DISPLAY_TEXT;
                    stateAfterText = LIGHT_SCREEN;
                    text = "The Light Screen has faded...";
                }
            }
            usingOnEnemy = false;
        } else {
            if (pui.getField().getPlayerField().hasLightScreen()) {
                pui.getField().getPlayerField().adjustLightScreen();
                if (!pui.getField().getPlayerField().hasLightScreen()) {
                    currentState = DISPLAY_TEXT;
                    text = "The Light Screen has faded...";
                    stateAfterText = MIST_STATE;
                } else {
                    currentState = MIST_STATE;
                }
            } else {
                currentState = MIST_STATE;
            }
            usingOnEnemy = true;

        }
    }

    private void adjustReflect() {
        if (usingOnEnemy) {
            if (pui.getField().getOpponentField().hasReflect()) {
                pui.getField().getOpponentField().adjustReflect();
                if (!pui.getField().getOpponentField().hasReflect()) {
                    currentState = DISPLAY_TEXT;
                    stateAfterText = REFLECT;
                    text = "The Reflect has faded...";
                }
            }
            usingOnEnemy = false;
        } else {
            if (pui.getField().getPlayerField().hasReflect()) {
                pui.getField().getPlayerField().adjustReflect();
                if (!pui.getField().getPlayerField().hasReflect()) {
                    currentState = DISPLAY_TEXT;
                    text = "The Light Screen has faded...";
                    stateAfterText = LIGHT_SCREEN;
                } else {
                    currentState = LIGHT_SCREEN;
                }
            } else {
                currentState = LIGHT_SCREEN;
            }
            usingOnEnemy = true;
        }
    }

    private void checkInfestation() {
        Pokemon currentPokemon = getCurrentPokemon();
        if (currentPokemon.getCurrentHealth() != 0) {
            if (currentPokemon.getInfestationTurns() == 0 && currentPokemon.isInfested()) {
                currentPokemon.removeInfestation();
                text = currentPokemon.getName() + " was freed from Infestation!";
                currentState = DISPLAY_TEXT;
                if (usingOnEnemy) {
                    usingOnEnemy = false;
                    stateAfterText = INFESTATION;
                } else {
                    usingOnEnemy = true;
                    stateAfterText = WHIRLPOOL_STATE;
                }
            } else if (currentPokemon.isInfested()) {
                text = currentPokemon.getName() + " was hurt by Infestation.";
                int damage = (int)Math.round(currentPokemon.getHealthStat() / 8.0);
                currentPokemon.subtractHealth(damage);
                currentPokemon.adjustInfestationTurns();
                adjustStates(currentPokemon, INFESTATION, WHIRLPOOL_STATE);
            } else {
                noStateUse(WHIRLPOOL_STATE);
            }
        } else {
            noStateUse(WHIRLPOOL_STATE);
        }
    }

    private void adjustWrap() {
        Pokemon currentPokemon = getCurrentPokemon();
        if (currentPokemon.getCurrentHealth() != 0) {
            if (currentPokemon.getWrapTurns() == 0 && currentPokemon.isWrapped()) {
                currentPokemon.removeWrap();
                text = currentPokemon.getName() + " was freed from Wrap!";
                currentState = DISPLAY_TEXT;
                if (usingOnEnemy) {
                    usingOnEnemy = false;
                    stateAfterText = WRAP;
                } else {
                    usingOnEnemy = true;
                    stateAfterText = REFLECT;
                }
            } else if (currentPokemon.isWrapped()) {
                text = currentPokemon.getName() + " was hurt by Wrap.";
                int damage = (int)Math.round(currentPokemon.getHealthStat() / 8.0);
                currentPokemon.subtractHealth(damage);
                currentPokemon.adjustWrapTurns();
                adjustStates(currentPokemon, WRAP, REFLECT);
            } else {
                noStateUse(REFLECT);
            }
        } else {
            noStateUse(REFLECT);
        }
    }

    private void checkFireSpin() {
        Pokemon currentPokemon = getCurrentPokemon();
        if (currentPokemon.getCurrentHealth() != 0) {
            if (currentPokemon.getFireSpinTurns() == 0 && currentPokemon.inFireSpin()) {
                currentPokemon.removeFireSpin();
                text = currentPokemon.getName() + " was freed from Fire Spin!";
                currentState = DISPLAY_TEXT;
                if (usingOnEnemy) {
                    usingOnEnemy = false;
                    stateAfterText = FIRE_SPIN;
                } else {
                    usingOnEnemy = true;
                    stateAfterText = SAND_TOMB;
                }
            } else if (currentPokemon.inFireSpin()) {
                text = currentPokemon.getName() + " was hurt by Fire Spin.";
                int damage = (int)Math.round(currentPokemon.getHealthStat() / 16.0);
                currentPokemon.subtractHealth(damage);
                currentPokemon.adjustFireSpinTurns();
                adjustStates(currentPokemon, FIRE_SPIN, SAND_TOMB);
            } else {
                noStateUse(SAND_TOMB);
            }
        } else {
            noStateUse(SAND_TOMB);
        }
    }

    private void checkSandTomb() {
        Pokemon currentPokemon = getCurrentPokemon();
        if (currentPokemon.getCurrentHealth() != 0) {
            if (currentPokemon.getSandTombTurns() == 0 && currentPokemon.inSandTomb()) {
                currentPokemon.removeSandTomb();
                text = currentPokemon.getName() + " was freed from the Sand Tomb!";
                currentState = DISPLAY_TEXT;
                if (usingOnEnemy) {
                    usingOnEnemy = false;
                    stateAfterText = SAND_TOMB;
                } else {
                    usingOnEnemy = true;
                    stateAfterText = INFESTATION;
                }
            } else if (currentPokemon.inSandTomb()) {
                text = currentPokemon.getName() + " was hurt by Sand Tomb.";
                int damage = (int)Math.round(currentPokemon.getHealthStat() / 8.0);
                currentPokemon.subtractHealth(damage);
                currentPokemon.adjustSandTombTurns();
                adjustStates(currentPokemon, SAND_TOMB, INFESTATION);
            } else {
                noStateUse(INFESTATION);
            }
        } else {
            noStateUse(INFESTATION);
        }
    }

    private void checkWhirlpool() {
        Pokemon currentPokemon = getCurrentPokemon();
        if (currentPokemon.getCurrentHealth() != 0) {
            if (currentPokemon.getWhirlpoolTurns() == 0 && currentPokemon.inWhirlpool()) {
                currentPokemon.removeWhirlpool();
                text = currentPokemon.getName() + " was freed from Whirlpool!";
                currentState = DISPLAY_TEXT;
                if (usingOnEnemy) {
                    usingOnEnemy = false;
                    stateAfterText = WHIRLPOOL_STATE;
                } else {
                    usingOnEnemy = true;
                    stateAfterText = WRAP;
                }
            } else if (currentPokemon.inWhirlpool()) {
                text = currentPokemon.getName() + " was hurt by Whirlpool.";
                int damage = (int)Math.round(currentPokemon.getHealthStat() / 16.0);
                currentPokemon.subtractHealth(damage);
                currentPokemon.adjustWhirlpoolTurns();
                adjustStates(currentPokemon, WHIRLPOOL_STATE, WRAP);
            } else {
                noStateUse(WRAP);
            }
        } else {
            noStateUse(WRAP);
        }
    }

    private void checkClamp() {
        Pokemon currentPokemon = getCurrentPokemon();
        if (currentPokemon.getCurrentHealth() != 0) {
            if (currentPokemon.getClampTurns() == 0 && currentPokemon.isClamped()) {
                currentPokemon.removeClamp();
                text = currentPokemon.getName() + " was freed from Clamp!";
                currentState = DISPLAY_TEXT;
                if (usingOnEnemy) {
                    usingOnEnemy = false;
                    stateAfterText = CLAMP_STATE;
                } else {
                    usingOnEnemy = true;
                    stateAfterText = FIRE_SPIN;
                }
            } else if (currentPokemon.isClamped()) {
                text = currentPokemon.getName() + " was hurt by Clamp.";
                int damage = (int)Math.round(currentPokemon.getHealthStat() / 16.0);
                currentPokemon.subtractHealth(damage);
                currentPokemon.adjustClampTurns();
                adjustStates(currentPokemon, CLAMP_STATE, FIRE_SPIN);
            } else {
                noStateUse(FIRE_SPIN);
            }
        } else {
            noStateUse(FIRE_SPIN);
        }
    }
    private void checkBind() {
        Pokemon currentPokemon = getCurrentPokemon();
        if (currentPokemon.getCurrentHealth() != 0) {
            if (currentPokemon.getBindTurns() == 0 && currentPokemon.isBinded()) {
                currentPokemon.removeBind();
                text = currentPokemon.getName() + " was freed from Bind!";
                currentState = DISPLAY_TEXT;
                if (usingOnEnemy) {
                    usingOnEnemy = false;
                    stateAfterText = BIND_STATE;
                } else {
                    usingOnEnemy = true;
                    stateAfterText = CLAMP_STATE;
                }
            } else if (currentPokemon.isBinded()) {
                text = currentPokemon.getName() + " was hurt by Bind.";
                int damage = (int)Math.round(currentPokemon.getHealthStat() / 6.0);
                currentPokemon.subtractHealth(damage);
                currentPokemon.adjustBindTurns();
                adjustStates(currentPokemon, BIND_STATE, CLAMP_STATE);
            } else {
                noStateUse(CLAMP_STATE);
            }
        } else {
            noStateUse(CLAMP_STATE);
        }
    }

    /**
     * Adjust the current damage dealing state
     * @param currentPokemon The Pokemon we are using the state on.
     * @param nextStateEnemy The next state if using on the enemy, usually the current state we're already on.
     * @param nextStateUser The next state if using on the enemy, the actual next state.
     */
    private void adjustStates(Pokemon currentPokemon, int nextStateEnemy, int nextStateUser) {
        if (currentPokemon.getCurrentHealth() == 0) {
            //Fainted.
            if (usingOnEnemy) {
                currentState = ADJUST_ENEMY_HEALTH;
                stateAfterHealthAdjustment = DISPLAY_TEXT;
                stateAfterText = DISPLAY_ENEMY_FAINT_TEXT;
                stateAfterFaint = nextStateEnemy;
                usingOnEnemy = false;
            } else {
                currentState = ADJUST_PLAYER_HEALTH;
                stateAfterHealthAdjustment = DISPLAY_TEXT;
                stateAfterText = DISPLAY_PLAYER_FAINT_TEXT;
                stateAfterNotBlackingOut = nextStateUser;
                usingOnEnemy = true;
            }
        } else {
            //Didn't faint.
            if (usingOnEnemy) {
                currentState = ADJUST_ENEMY_HEALTH;
                stateAfterHealthAdjustment = DISPLAY_TEXT;
                stateAfterText = nextStateEnemy;
                usingOnEnemy = false;
            } else {
                currentState = ADJUST_PLAYER_HEALTH;
                stateAfterHealthAdjustment = DISPLAY_TEXT;
                stateAfterText = nextStateUser;
                usingOnEnemy = true;
            }
        }
    }


    /**
     * Determine what state to go to if there is no effect on the current pokemon
     * at the current state. If using on the enemy, the next state is always the
     * current state being used on the user's pokemon. Go to the next state if
     * it has no effect on the user pokemon.
     * @param nextState
     */
    private void noStateUse(int nextState) {
        if (usingOnEnemy) {
            usingOnEnemy = false;
        } else {
            usingOnEnemy = true;
            currentState = nextState;
        }
    }

    private void checkCurse() {
        Pokemon currentPokemon = getCurrentPokemon();
        if (currentPokemon.getCurrentHealth() != 0) {
            if (currentPokemon.isCursed()) {
                int damage = (int)Math.round(currentPokemon.getHealthStat() / 4.0);
                currentPokemon.subtractHealth(damage);
                text = currentPokemon.getName() + " is afflicted by Curse!";
                adjustStates(currentPokemon, CURSE, BIND_STATE);
            } else {
                noStateUse(BIND_STATE);
            }
        } else {
            noStateUse(BIND_STATE);
        }
    }



    private void checkNightmares() {
        Pokemon currentPokemon = getCurrentPokemon();
        if (currentPokemon.getCurrentHealth() != 0) {
            if (currentPokemon.hasNightmares()) {
                int damage = (int)Math.round(currentPokemon.getHealthStat() / 4.0);
                currentPokemon.subtractHealth(damage);
                text = currentPokemon.getName() + " is locked in a nightmare!";
                adjustStates(currentPokemon, NIGHTMARES, CURSE);
            } else {
                noStateUse(CURSE);
            }
        } else {
            noStateUse(CURSE);
        }
    }


    private void checkNegativeStatus() {
        Pokemon currentPokemon = getCurrentPokemon();
        if (currentPokemon.getCurrentHealth() != 0) {
            //TODO: Implement Poison Heal
            if (currentPokemon.getStatus() == Pokemon.Status.POISON) {
                int damage = (int)Math.round(currentPokemon.getHealthStat() / 8.0);
                currentPokemon.subtractHealth(damage);
                text = currentPokemon.getName() + " was hurt by poison.";
                adjustStates(currentPokemon, NEGATIVE_STATUS, NIGHTMARES);
            } else if (currentPokemon.getStatus() == Pokemon.Status.BURN) {
                int damage = (int)Math.round(currentPokemon.getHealthStat() / 16.0);
                currentPokemon.subtractHealth(damage);
                pui.playPoisonSound();
                text = currentPokemon.getName() + " was hurt by burn.";
                adjustStates(currentPokemon, NEGATIVE_STATUS, NIGHTMARES);
            } else {
                noStateUse(NIGHTMARES);
            }
        } else {
            noStateUse(NIGHTMARES);
        }
    }


    private void checkLeechSeed() {
        Gdx.app.log("seedcheck", "check");
        Pokemon currentPokemon = getCurrentPokemon();
        if (currentPokemon.getCurrentHealth() != 0 && currentPokemon.isSeeded()) {
            currentState = DISPLAY_TEXT;
            text = currentPokemon.getName() + " lost health\nfrom Leech Seed.";
            leechSeedDrain = (int)Math.round(currentPokemon.getHealthStat() / 8.0);
            if (leechSeedDrain > currentPokemon.getCurrentHealth()) {
                leechSeedDrain = currentPokemon.getCurrentHealth();
            }
            currentPokemon.subtractHealth(leechSeedDrain);
            if (usingOnEnemy) {
                stateAfterText = ADJUST_ENEMY_HEALTH;
            } else {
                stateAfterText = ADJUST_PLAYER_HEALTH;
            }
            if (currentPokemon.getCurrentHealth() == 0) {
                if (usingOnEnemy) {
                    stateAfterHealthAdjustment = DISPLAY_ENEMY_FAINT_TEXT;
                    stateAfterFaint = RECEIVE_LEECH_SEED_DRAIN;
                } else {
                    stateAfterHealthAdjustment = DISPLAY_PLAYER_FAINT_TEXT;
                    stateAfterNotBlackingOut = RECEIVE_LEECH_SEED_DRAIN;
                }
            } else {
                stateAfterHealthAdjustment = RECEIVE_LEECH_SEED_DRAIN;
            }
        } else {
            if (usingOnEnemy) {
                //No Leech seed on enemy so check it on the Player.
                usingOnEnemy = false;
            } else {
                //No leech seed on player so go to next check.
                usingOnEnemy = true;
                currentState = NEGATIVE_STATUS;
            }
        }
    }

    private void receiveLeechSeedDrain() {
        Pokemon drainer;
        if (usingOnEnemy) {
            drainer = pui.getUserPokemon();
        } else {
            drainer = pui.getEnemyPokemon();
        }

        if (!drainer.hasFullHealth()) {
            drainer.addHealth(leechSeedDrain);
            currentState = DISPLAY_TEXT;
            text = drainer.getName() + " recovered some health\nfrom Leech Seed.";
            //Note that here usingOnEnemy means that the enemy takes damage from leech seed
            if (usingOnEnemy) {
                stateAfterText = ADJUST_PLAYER_HEALTH;
                stateAfterHealthAdjustment = LEECH_SEED;
                usingOnEnemy = false;
            } else {
                stateAfterText = ADJUST_ENEMY_HEALTH;
                stateAfterHealthAdjustment = NEGATIVE_STATUS;
                usingOnEnemy = true;
            }
        } else {
            //No drain is required so move to the next check.
            if (usingOnEnemy) { //Check the other Pokemon
                usingOnEnemy = false;
                currentState = LEECH_SEED;
            } else { //Go to the next check
                usingOnEnemy = true;
                currentState = NEGATIVE_STATUS;
            }
        }

    }

    private void checkAquaRing() {
        Pokemon currentPokemon = getCurrentPokemon();
        if (currentPokemon.getCurrentHealth() != 0 &&
                !currentPokemon.hasFullHealth() &&
                currentPokemon.isEnvelopedInAquaRing()) {
            text = currentPokemon.getName() + " recovered health\nfrom Aqua Ring.";
            currentPokemon.addHealth((int)Math.ceil(currentPokemon.getHealthStat() / 16.0));
            currentState = DISPLAY_TEXT;
            if (usingOnEnemy) {
                stateAfterText = ADJUST_ENEMY_HEALTH;
                stateAfterHealthAdjustment = AQUA_RING_STATE;
                usingOnEnemy = false;
            } else {
                stateAfterText = ADJUST_PLAYER_HEALTH;
                stateAfterHealthAdjustment = INGRAIN_STATE;
                usingOnEnemy = true;
            }
        } else {
            if (usingOnEnemy) {
                usingOnEnemy = false;
            } else {
                usingOnEnemy = true;
                currentState = INGRAIN_STATE;
            }
        }
    }

    private void checkIngrain() {
        Pokemon currentPokemon = getCurrentPokemon();
        if (currentPokemon.getCurrentHealth() != 0 &&
                !currentPokemon.hasFullHealth() &&
                currentPokemon.isIngrained()) {
            text = currentPokemon.getName() + " recovered health\nfrom Ingrain.";
            currentPokemon.addHealth((int)Math.ceil(currentPokemon.getHealthStat() / 16.0));
            currentState = DISPLAY_TEXT;
            if (usingOnEnemy) {
                stateAfterText = ADJUST_ENEMY_HEALTH;
                stateAfterHealthAdjustment = INGRAIN_STATE;
                usingOnEnemy = false;
            } else {
                stateAfterText = ADJUST_PLAYER_HEALTH;
                stateAfterHealthAdjustment = LEECH_SEED;
                usingOnEnemy = true;
            }
        } else {
            if (usingOnEnemy) {
                usingOnEnemy = false;
            } else {
                usingOnEnemy = true;
                currentState = LEECH_SEED;
            }
        }
    }

    private void checkHealingAbilities() {
        Pokemon currentPokemon = getCurrentPokemon();
        if (currentPokemon.getStatus() != Pokemon.Status.STATUS_FREE &&
                currentPokemon.getBattleAbility().getId() == AbilityId.SHED_SKIN) {
            double rand = Math.random();
            if (rand <= .3) {
                text = currentPokemon.getName() + " shed its skin\nand removed all status problems!";
                currentPokemon.setPreStatus(Pokemon.Status.RECOVER);
                setNextStateAfterHealingAbilityUse();
            } else {
              goToNextStateFromHealingAbilities();
            }
        } else if (currentPokemon.getStatus() != Pokemon.Status.STATUS_FREE &&
                currentPokemon.getBattleAbility().getId() == AbilityId.HYDRATION &&
                pui.getField().getWeatherType() == WeatherType.RAIN) {
            text = currentPokemon.getName() + " removed its status problem\nusing the ability Hydration!";
            currentPokemon.setPreStatus(Pokemon.Status.RECOVER);
            setNextStateAfterHealingAbilityUse();
        } else {
            goToNextStateFromHealingAbilities();
        }
    }

    private void setNextStateAfterHealingAbilityUse() {
        currentState = DISPLAY_TEXT;
        if (usingOnEnemy) {
            stateAfterText = HEALING_ABILITIES;
            usingOnEnemy = false;
        } else {
            stateAfterText = AQUA_RING_STATE;
            usingOnEnemy = true;
        }
    }

    private void goToNextStateFromHealingAbilities() {
        if (usingOnEnemy) {
            usingOnEnemy = false;
        } else {
            usingOnEnemy = true;
            currentState = AQUA_RING_STATE;
        }
    }

    private void checkWish() {
        Pokemon currentPokemon = getCurrentPokemon();
        if (currentPokemon.getCurrentHealth() != 0 && currentPokemon.isReceivingWish()) {
            if (currentPokemon.getWishTurns() == 0) {
                currentPokemon.addHealth(currentPokemon.getHealthStat() / 2);
                text = currentPokemon.getWishUser() + "'s Wish\ncame true!";
                currentPokemon.removeWish();
                currentState = DISPLAY_TEXT;
                if (usingOnEnemy) {
                    stateAfterText = ADJUST_ENEMY_HEALTH;
                    stateAfterHealthAdjustment = WISH_STATE;
                    usingOnEnemy = false;

                } else {
                    stateAfterText = ADJUST_PLAYER_HEALTH;
                    stateAfterHealthAdjustment = HEALING_ABILITIES;
                    usingOnEnemy = true;
                }

            } else {
                currentPokemon.adjustWishTurns();
                noStateUse(HEALING_ABILITIES);
            }
        } else {
            noStateUse(HEALING_ABILITIES);
        }
    }


    private void checkFutureSight() {
        Pokemon currentPokemon = getCurrentPokemon();
        if (currentPokemon.getCurrentHealth() != 0 &&
                (currentPokemon.witnessedFutureSight() ||
                        currentPokemon.witnessedDoomDesire())) {
            if (currentPokemon.witnessedFutureSight()) {
                useFutureSight(currentPokemon);
            } else { //they witnessed doom desire.
                //use doom desire
                useDoomDesire(currentPokemon);
            }
        } else {
            noStateUse(WISH_STATE);
        }
    }

    private void useFutureSight(Pokemon currentPokemon) {
        if (currentPokemon.getFutureSightTime() == 0) {
            HurtByFutureSight futureSight = new HurtByFutureSight();
            if (futureSight.willHitEnemy(currentPokemon.getFutureSightUser(),
                    currentPokemon, pui.getField(), null, null, false)) {
                futureSight.use(currentPokemon.getFutureSightUser(), currentPokemon, pui.getField());
                text = currentPokemon.getName() + " took the\nFuture Sight attack!";
            } else {
                text = currentPokemon.getFutureSightUser().getName()+ "'s future Sight failed.";
            }
            currentPokemon.removeFutureSight();
            adjustStates(currentPokemon, CHECK_FUTURE_SIGHT, WISH_STATE);
        } else {
            currentPokemon.adjustFutureSightTime();
            noStateUse(WISH_STATE);
        }
    }

    private void useDoomDesire(Pokemon currentPokemon) {
        if (currentPokemon.getDoomDesireTime() == 0) {
            HurtByDoomDesire doomDesire = new HurtByDoomDesire();
            if (doomDesire.willHitEnemy(currentPokemon.getFutureSightUser(),
                    currentPokemon, pui.getField(), null, null, false)) {
                doomDesire.use(currentPokemon.getFutureSightUser(), currentPokemon, pui.getField());
                text = currentPokemon.getName() + " took the\nDoom Desire attack!";
            } else {
                text = currentPokemon.getFutureSightUser().getName()+ "'s Doom Desire failed.";
            }
            currentPokemon.removeDoomDesire();
            adjustStates(currentPokemon, CHECK_FUTURE_SIGHT, WISH_STATE);
        } else {
            currentPokemon.adjustDoomDesireTime();
            noStateUse(WISH_STATE);
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
            pui.getEnemyPokemon().freeFromBinds();
            currentState = CHECK_BLACK_OUT;
        }
    }

    private void updateEnemyFaintAnimation(double dt) {
        pui.getEnemyPokemon().setEnemyY((int)(pui.getEnemyPokemon().getEnemyY() - 10));
        if (pui.getEnemyPokemon().getEnemyY() <= pui.getEnemyPokemon().getFaintedEnemyY()) {
            //Make the pokemon faint when it went down to the right faint position
            pui.getEnemyPokemon().setEnemyY(pui.getEnemyPokemon().getFaintedEnemyY());
            pui.getEnemyPokemon().setFaint(true);
            pui.getUserPokemon().freeFromBinds();
            currentState = stateAfterFaint;

        }
    }

    private Pokemon getCurrentPokemon() {
        Pokemon pokemon;
        if (usingOnEnemy) {
            pokemon = pui.getEnemyPokemon();
        } else {
            pokemon = pui.getUserPokemon();
        }
        return pokemon;
    }

    /**
     * Switch the user getting hit by the weather if it's
     * the enemy pokemon since the enemy gets hit first.
     * Otherwise, go to the next end phase hit.
     */
    private void weatherDoesNothing() {
        if (usingOnEnemy) {
            usingOnEnemy = false;
        } else {
            currentState = CHECK_FUTURE_SIGHT;
        }
    }

    private void useSandstorm() {
        Pokemon pokemon = getCurrentPokemon();
        if (pokemon.getBattleAbility().getId() == AbilityId.SAND_FORCE ||
                pokemon.getBattleAbility().getId() == AbilityId.SAND_RUSH ||
                pokemon.getBattleAbility().getId() == AbilityId.SAND_VEIL ||
                pokemon.getBattleAbility().getId() == AbilityId.MAGIC_GUARD ||
                pokemon.getBattleAbility().getId() == AbilityId.OVERCOAT ||
                pokemon.getBattleTypeOne() == Pokemon.Type.ROCK ||
                pokemon.getBattleTypeOne() == Pokemon.Type.GROUND ||
                pokemon.getBattleTypeOne() == Pokemon.Type.STEEL ||
                pokemon.getBattleTypeTwo() == Pokemon.Type.ROCK ||
                pokemon.getBattleTypeTwo() == Pokemon.Type.GROUND ||
                pokemon.getBattleTypeTwo() == Pokemon.Type.STEEL) { //TODO: Check for holding safety goggles
            //Nothing happens -- Switch to use on next pokemon or go to next state.
            weatherDoesNothing();
        } else {
            //Get hit
            damagePokemonFromSandstorm(pokemon);
        }
    }

    private void useRain() {
        Pokemon pokemon = getCurrentPokemon();
        if (pokemon.getBattleAbility().getId() == AbilityId.RAIN_DISH
                && !pokemon.hasFullHealth()) {
            recoverPokemonFromRain(pokemon, 16.0);
        } else if (pokemon.getBattleAbility().getId() == AbilityId.DRY_SKIN
                && !pokemon.hasFullHealth()) {
            recoverPokemonFromRain(pokemon, 8.0);
        } else {
            weatherDoesNothing();
        }
    }

    private void useSunlight() {
        Pokemon pokemon = getCurrentPokemon();
        if (pokemon.getBattleAbility().getId() == AbilityId.DRY_SKIN ||
                pokemon.getBattleAbility().getId() == AbilityId.SOLAR_POWER) {
            damagePokemonFromSunlight(pokemon);
        } else {
            weatherDoesNothing();
        }
    }

    private void useHail() {
        Pokemon pokemon = getCurrentPokemon();
        if (pokemon.getBattleAbility().getId() == AbilityId.ICE_BODY ||
                pokemon.getBattleAbility().getId() == AbilityId.SNOW_CLOAK ||
                pokemon.getBattleAbility().getId() == AbilityId.MAGIC_GUARD ||
                pokemon.getBattleAbility().getId() == AbilityId.OVERCOAT ||
                pokemon.getBattleTypeOne() == Pokemon.Type.ICE ||
                pokemon.getBattleTypeTwo() == Pokemon.Type.ICE) { //TODO: Check for holding safety goggles
            if (pokemon.getBattleAbility().getId() == AbilityId.ICE_BODY && !pokemon.hasFullHealth()){
                //Recover
                recoverPokemonFromHail(pokemon);
            } else {
                //Nothing happens -- Switch to use on next pokemon or go to next state.
                weatherDoesNothing();
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
            if (skipUser) {
                stateAfterHealthAdjustment = CHECK_FUTURE_SIGHT;
            } else {
                stateAfterHealthAdjustment = USE_HAIL;
                usingOnEnemy = false;
            }
        } else {
            stateAfterText = ADJUST_PLAYER_HEALTH;
            stateAfterHealthAdjustment = CHECK_FUTURE_SIGHT;
            usingOnEnemy = true;
        }
    }

    private void recoverPokemonFromRain(Pokemon pokemon, double denominator) {
        int recoverAmount = (int)Math.round(pokemon.getHealthStat() / denominator);
        pokemon.addHealth(recoverAmount);
        text = pokemon.getName() + " recovered health in the rain\nwith the ability Rain Dish.";
        currentState = DISPLAY_TEXT;
        if (usingOnEnemy) {
            stateAfterText = ADJUST_ENEMY_HEALTH;
            if (skipUser) {
                stateAfterHealthAdjustment = CHECK_FUTURE_SIGHT;
            } else {
                stateAfterHealthAdjustment = USE_RAIN;
                usingOnEnemy = false;
            }
        } else {
            stateAfterText = ADJUST_PLAYER_HEALTH;
            stateAfterHealthAdjustment = CHECK_FUTURE_SIGHT;
            usingOnEnemy = true;
        }
    }

    private void damagePokemonFromSandstorm(Pokemon pokemon) {
        int damage = (int)Math.round(pokemon.getHealthStat() / 16.0);
        pokemon.subtractHealth(damage);
        text = pokemon.getName() + " is buffeted by the sandstorm!";
        currentState = DISPLAY_TEXT;
        if (usingOnEnemy) {
            stateAfterText = ADJUST_ENEMY_HEALTH;
            if (pokemon.getCurrentHealth() != 0) {
                if (skipUser) {
                    stateAfterHealthAdjustment = CHECK_FUTURE_SIGHT;
                } else {
                    stateAfterHealthAdjustment = USE_SAND;
                    usingOnEnemy = false;
                }
            } else {
                stateAfterHealthAdjustment = DISPLAY_ENEMY_FAINT_TEXT;
                if (skipUser) {
                    //TODO: End the battle.
                    stateAfterFaint = DOUBLE_KNOCKOUT;
                } else {
                    stateAfterFaint = USE_SAND;
                    usingOnEnemy = false;
                }
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

    private void damagePokemonFromSunlight(Pokemon pokemon) {
        int damage = (int)Math.round(pokemon.getHealthStat() / 8.0);
        pokemon.subtractHealth(damage);
        if (pokemon.getBattleAbility().getId() == AbilityId.SOLAR_POWER) {
            text = pokemon.getName() + " is hurt \nfrom drawing in solar power.";
        } else { //Having Dry skin is the only other way to get here.
            text = pokemon.getName() + " is hurt by having\n Dry Skin in the sunlight";
        }
        currentState = DISPLAY_TEXT;
        if (usingOnEnemy) {
            stateAfterText = ADJUST_ENEMY_HEALTH;
            if (pokemon.getCurrentHealth() != 0) {
                if (skipUser) {
                    stateAfterHealthAdjustment = CHECK_FUTURE_SIGHT;
                } else {
                    stateAfterHealthAdjustment = USE_SUN;
                    usingOnEnemy = false;
                }
            } else {
                stateAfterHealthAdjustment = DISPLAY_ENEMY_FAINT_TEXT;
                if (skipUser) {
                    //Todo: end the battle
                    stateAfterFaint = DOUBLE_KNOCKOUT;
                } else {
                    stateAfterFaint = USE_SUN;
                    usingOnEnemy = false;
                }
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

    /**
     * Damage a Pokemon that gets hit by hail.
     * @param pokemon The Pokemon getting buffetted by hail.
     */
    private void damagePokemonFromHail(Pokemon pokemon) {
        int damage = (int)Math.round(pokemon.getHealthStat() / 16.0);
        pokemon.subtractHealth(damage);
        text = pokemon.getName() + " is buffeted by hail.";

        currentState = DISPLAY_TEXT;
        if (usingOnEnemy) {
            stateAfterText = ADJUST_ENEMY_HEALTH;
            if (pokemon.getCurrentHealth() != 0) {
                if (skipUser) {
                    stateAfterHealthAdjustment = CHECK_FUTURE_SIGHT;
                } else {
                    stateAfterHealthAdjustment = USE_HAIL;
                    usingOnEnemy = false;
                }
            } else {
                stateAfterHealthAdjustment = DISPLAY_ENEMY_FAINT_TEXT;
                if (skipUser) {
                    //TODO: end battle.
                    stateAfterFaint = DOUBLE_KNOCKOUT;
                } else {
                    stateAfterFaint = USE_HAIL;
                    usingOnEnemy = false;
                }
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
        } else if (pui.getField().getWeatherType() == WeatherType.SAND) {
            usingOnEnemy = true;
            currentState = USE_SAND;
        } else if (pui.getField().getWeatherType() == WeatherType.RAIN ||
                pui.getField().getWeatherType() == WeatherType.HEAVY_RAIN) {
            usingOnEnemy = true;
            currentState = USE_RAIN;
        } else if (pui.getField().getWeatherType() == WeatherType.SUN ||
                pui.getField().getWeatherType() == WeatherType.HARSH_SUNSHINE) {
            usingOnEnemy = true;
            currentState = USE_SUN;
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
