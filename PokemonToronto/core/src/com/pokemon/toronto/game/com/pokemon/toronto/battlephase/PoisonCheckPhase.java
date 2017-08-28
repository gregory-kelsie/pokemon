package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Gregory on 7/31/2017.
 */

public class PoisonCheckPhase extends BattlePhase {

    private final int INIT = -1;
    private final int DISPLAY_ENEMY_HURT_BY_POISON = 0;
    private final int DEPLETING_ENEMY = 1;
    private final int DISPLAY_PLAYER_HURT_BY_POISON = 2;
    private final int DEPLETING_PLAYER = 3;
    private final int FAINT_ENEMY = 4;
    private final int FAINT_PLAYER = 5;
    private final int DISPLAY_ENEMY_FAINT_TEXT = 6;
    private final int DISPLAY_PLAYER_FAINT_TEXT = 7;

    private int poisonCheckState;
    private String text;
    private int textPosition;
    private double counter;

    public PoisonCheckPhase(PhaseUpdaterInterface pui) {
        super(pui);
        phaseName = "PoisonCheck";
        textPosition = 0;
        counter = 0;
        poisonCheckState = INIT;
    }

    private void checkPlayerForPoison() {
        if (pui.getUserPokemon().isPoisoned()) {
            poisonCheckState = DISPLAY_PLAYER_HURT_BY_POISON;
            text = pui.getUserPokemon().getName() + " was hurt by poison.";
            damagePlayerFromPoison();
        } else if (pui.getUserPokemon().isBurned()) {
            poisonCheckState = DISPLAY_PLAYER_HURT_BY_POISON;
            text = pui.getUserPokemon().getName() + " was hurt by burn.";
            damagePlayerFromBurn();
        }
        else {
            if (pui.getUserPokemon().isFainted()) {
                if (pui.playerHasMorePokemon() && !pui.waitingForNextPokemon()) {
                    pui.setPhase(new PlayerPokemonFaintPhase(pui));
                } else if (!pui.playerHasMorePokemon()) {
                    pui.setPhase(new BlackedOutPhase(pui));
                }
            } else {
                pui.endBattle();
            }
        }
    }

    private void damagePlayerFromPoison() {
        int damage = (int)Math.round(pui.getUserPokemon().getHealthStat() / 8.0);
        pui.getUserPokemon().subtractHealth(damage);
    }

    private void damagePlayerFromBurn() {
        int damage = (int)Math.round(pui.getUserPokemon().getHealthStat() / 16.0);
        pui.getUserPokemon().subtractHealth(damage);
    }

    private void updateHurtByPoisonText(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textPosition != text.length()) {
                textPosition++;
                counter = 0;
            }
        }
        if (counter >= 1.5) {
            pui.playPoisonSound();
            if (poisonCheckState == DISPLAY_ENEMY_HURT_BY_POISON) {
                poisonCheckState = DEPLETING_ENEMY;
                textPosition = 0;
                counter = 0;
            } else if (poisonCheckState == DISPLAY_PLAYER_HURT_BY_POISON) {
                poisonCheckState = DEPLETING_PLAYER;
                textPosition = 0;
                counter = 0;
            }
        }
    }
    @Override
    public void update(double dt) {
        if (poisonCheckState == DISPLAY_PLAYER_HURT_BY_POISON ||
                poisonCheckState == DISPLAY_ENEMY_HURT_BY_POISON) {
            updateHurtByPoisonText(dt);
        } else if (poisonCheckState == DEPLETING_ENEMY) {
            if (!pui.getEnemyPokemon().matchingAnimationHealth()) {
                pui.getEnemyPokemon().adjustAnimationHealth(1);
            } else {
                if (pui.getEnemyPokemon().getCurrentHealth() != 0) {
                    checkPlayerForPoison();
                } else {
                    text = pui.getEnemyPokemon().getName() + " fainted.";
                    textPosition = 0;
                    counter = 0;
                    poisonCheckState = DISPLAY_ENEMY_FAINT_TEXT;
                }
            }
        } else if (poisonCheckState == DEPLETING_PLAYER) {
            if (!pui.getUserPokemon().matchingAnimationHealth()) {
                pui.getUserPokemon().adjustAnimationHealth(1);
            } else {
                if (pui.getUserPokemon().getCurrentHealth() != 0) {
                    pui.endBattle();
                } else {
                    text = pui.getUserPokemon().getName() + " fainted.";
                    textPosition = 0;
                    counter = 0;
                    poisonCheckState = DISPLAY_PLAYER_FAINT_TEXT;
                }
            }
        } else if (poisonCheckState == FAINT_ENEMY) {
            updateEnemyFaintAnimation(dt);
        } else if (poisonCheckState == FAINT_PLAYER) {
            updateUserFaintAnimation(dt);
        } else if (poisonCheckState == DISPLAY_ENEMY_FAINT_TEXT) {
            updateFaintText(dt, false);
        } else if (poisonCheckState == DISPLAY_PLAYER_FAINT_TEXT) {
            updateFaintText(dt, true);
        } else if (poisonCheckState == INIT) {
            if (pui.getEnemyPokemon().isFainted()) {
                if (pui.getUserPokemon().isFainted()) {
                    pui.finishedBattle();
                } else {
                    //TODO: probably should use poison on the player as well as it would help when trainers are implemented.
                    pui.setPhase(new ExpPhase(pui));
                }
            } else {
                checkEnemyForPoison();
            }
        }

    }

    private void checkEnemyForPoison() {
        if (pui.getEnemyPokemon().isPoisoned()) {
            poisonCheckState = DISPLAY_ENEMY_HURT_BY_POISON;
            text = pui.getEnemyPokemon().getName() + " was hurt by poison.";
            int damage = (int)Math.round(pui.getEnemyPokemon().getHealthStat() / 8.0);
            pui.getEnemyPokemon().subtractHealth(damage);
        } else if (pui.getEnemyPokemon().isBurned()) {
            poisonCheckState = DISPLAY_ENEMY_HURT_BY_POISON;
            text = pui.getEnemyPokemon().getName() + " was hurt by burn.";
            int damage = (int)Math.round(pui.getEnemyPokemon().getHealthStat() / 16.0);
            pui.getEnemyPokemon().subtractHealth(damage);
        } else {
            if (pui.getUserPokemon().isFainted()) {
                if (pui.playerHasMorePokemon() && !pui.waitingForNextPokemon()) {
                    pui.setPhase(new PlayerPokemonFaintPhase(pui));
                } else if (!pui.playerHasMorePokemon()) {
                    pui.setPhase(new BlackedOutPhase(pui));
                }
            } else {
                checkPlayerForPoison();
            }
        }
    }

    private void updateFaintText(double dt, boolean playerFainted) {
        counter += dt;
        if (counter >= 0.05) {
            if (textPosition < text.length()) {
                textPosition++;
                counter = 0;
            }
        }
        if (counter >= 1.5) {
            if (playerFainted) {
                poisonCheckState = FAINT_PLAYER;
                pui.playFaintSound();
            } else {
                poisonCheckState = FAINT_ENEMY;
                pui.playFaintSound();
            }
        }
    }

    protected void updateUserFaintAnimation(double dt) {
        pui.getUserPokemon().setPlayerY((int)(pui.getUserPokemon().getPlayerY() - 10));
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

    protected void updateEnemyFaintAnimation(double dt) {
        pui.getEnemyPokemon().setEnemyY((int)(pui.getEnemyPokemon().getEnemyY() - 10));
        if (pui.getEnemyPokemon().getEnemyY() <= pui.getEnemyPokemon().getFaintedEnemyY()) {
            //Make the pokemon faint when it went down to the right faint position
            pui.getEnemyPokemon().setEnemyY(pui.getEnemyPokemon().getFaintedEnemyY());
            pui.getEnemyPokemon().setFaint(true);
            //Go to exp state.
            if (!pui.getUserPokemon().isFainted()) {
                pui.setPhase(new ExpPhase(pui));
            } else {
                pui.finishedBattle();
            }

        }
    }

    @Override
    public void renderText(SpriteBatch batch) {
        if (poisonCheckState != FAINT_ENEMY && poisonCheckState != FAINT_PLAYER && poisonCheckState != INIT) {
            pui.getFont().draw(batch, text.substring(0, textPosition), 54, 1143);
        }
    }
}
