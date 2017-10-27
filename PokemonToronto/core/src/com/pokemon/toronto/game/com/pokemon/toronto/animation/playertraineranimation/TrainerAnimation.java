package com.pokemon.toronto.game.com.pokemon.toronto.animation.playertraineranimation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.Animation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.AnimationFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.gamestate.BattleInterface;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer;

/**
 * Created by Gregory on 9/6/2017.
 */

public class TrainerAnimation {
    private final int START = 0;
    private final int TRAINER_ENCOUNTER_TEXT = 1;
    private final int TRAINER_SEND_OUT_TEXT = 2;
    private final int ENEMY_POKEBALL = 3;
    private final int TO_OFFSCREEN = 4;
    private final int THROWING_BALL = 5;
    private final int PLAYER_SEND_OUT_TEXT = 6;
    private int currentState;

    private Texture trainerTexture;
    private Texture trainerPokeballBar;
    private Texture trainerPokeball;
    private Texture trainerEmptyPokeball;

    private int numPokemon;

    private String encounterText;
    private String sendOutText;
    private String playerText;

    private Animation trainerAnimation;
    private BitmapFont font;

    private double counter;
    private int textIndex;

    private boolean startedPokeballToss;
    private int pokeballX;
    private int pokeballY;
    private Texture pokeball;

    private BattleInterface battleInterface;
    private boolean finished;
    public TrainerAnimation(BattleInterface battleInterface, String sentOutPokemonName, Trainer trainer, Texture trainerTexture, int numPokemon) {
        trainerAnimation = AnimationFactory.getPlayerTrainerAnimation();
        trainerAnimation.setLooping(false);

        this.trainerTexture = trainerTexture;
        this.numPokemon = numPokemon;
        encounterText = "You are challenged\nby " + trainer.getTitle() + " " + trainer.getName() + "!";
        sendOutText = trainer.getTitle() + " " + trainer.getName() + " sent out\n" + trainer.getParty().get(0).getName() + "!";
        playerText = "Go " + sentOutPokemonName + "!";
        currentState = START;
        counter = 0;
        textIndex = 0;
        font =  new BitmapFont(Gdx.files.internal("battle/font/regularFont.fnt"));
        pokeballX = 0;
        pokeballY = 1446;
        startedPokeballToss = false;
        finished = false;
        this.battleInterface = battleInterface;
        pokeball = new Texture("battle/trainer/pokeball.png");
        trainerPokeballBar = new Texture("battle/trainerpokeballbar.png");
        trainerEmptyPokeball = new Texture("battle/traineremptypokeball.png");
        trainerPokeball = new Texture("battle/trainerpokeball.png");
    }

    public void update(double dt) {
        if (currentState == START) {
            updateStart(dt);
        } else if (currentState == TRAINER_SEND_OUT_TEXT) {
            updateTrainerSendOutText(dt);
        } else if (currentState == TRAINER_ENCOUNTER_TEXT) {
            updateTrainerEncounterText(dt);
        } else if (currentState == PLAYER_SEND_OUT_TEXT) {
            updatePlayerSendOutText(dt);
        } else if (currentState == TO_OFFSCREEN) {
            updateToOffscreen(dt);
        }
    }

    private void updateStart(double dt) {
        counter += dt;
        if (counter >= 0.0166667) {
            trainerAnimation.setNewCoords(trainerAnimation.getX() - 15, trainerAnimation.getY());
            counter = 0;
            if (trainerAnimation.getX() <= 66) {
                currentState = TRAINER_ENCOUNTER_TEXT;
            }
        }
    }

    private void updateTrainerEncounterText(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textIndex < encounterText.length()) {
                counter = 0;
                textIndex++;
            }
        }
        if (counter >= 1.5) {
            currentState = TRAINER_SEND_OUT_TEXT;
            counter = 0;
            textIndex = 0;
        }
    }

    private void updateTrainerSendOutText(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textIndex < sendOutText.length()) {
                counter = 0;
                textIndex++;
            }
        }
        if (counter >= 1.5) {
            battleInterface.playTrainerEnemyCry();
            currentState = PLAYER_SEND_OUT_TEXT;
            counter = 0;
            textIndex = 0;
        }
    }

    private void updatePlayerSendOutText(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textIndex < playerText.length()) {
                counter = 0;
                textIndex++;
            }
        }
        if (counter >= 1.5) {
            currentState = TO_OFFSCREEN;
            counter = 0;
        }
    }

    private void updateToOffscreen(double dt) {
        counter += dt;
        trainerAnimation.update(dt);
        if (startedPokeballToss) {
            if (pokeballX + 123 < 375) {
                pokeballX += 7;
                pokeballY = (int) Math.round(-0.00069372181 * (Math.pow(pokeballX, 2)) + 1446);
            } else {
                if (!finished) {
                    finished = true;
                    battleInterface.playUserPokemonCry();
                }
            }
        }
        if (counter >= 0.0166667) {
            trainerAnimation.setNewCoords(trainerAnimation.getX() - 4, trainerAnimation.getY());
            if (trainerAnimation.finishedAnimation()) {
                startedPokeballToss = true;
            }
            counter = 0;
        }
    }

    public void render(SpriteBatch batch) {
        trainerAnimation.render(batch);
        if (currentState == TO_OFFSCREEN) {
            if (startedPokeballToss) {
                batch.draw(pokeball, pokeballX + 123, pokeballY);
            }
        }
        if (currentState == START || currentState == TRAINER_ENCOUNTER_TEXT || currentState == TRAINER_SEND_OUT_TEXT) {
            batch.draw(trainerTexture,610, 1560,340,340);
            renderPokeballs(batch);
            //Draw pokeball amount as well.
        }

    }

    private void renderPokeballs(SpriteBatch batch) {
        batch.draw(trainerPokeballBar, 0, 1767, 473, 13);
        for (int i = 0; i < 6; i++) {
            if (i < numPokemon) {
                batch.draw(trainerPokeball, 395 - (68 * i), 1785, 62, 62);
            } else {
                batch.draw(trainerEmptyPokeball, 395 - (68 * i), 1785, 62, 62);
            }
        }
    }

    public void renderText(SpriteBatch batch) {
        if (currentState == TRAINER_ENCOUNTER_TEXT) {
            font.draw(batch, encounterText.substring(0, textIndex), 54, 1143);
        } else if (currentState == TRAINER_SEND_OUT_TEXT) {
            font.draw(batch, sendOutText.substring(0, textIndex), 54, 1143);
        } else if (currentState == TO_OFFSCREEN || currentState == PLAYER_SEND_OUT_TEXT) {
            font.draw(batch, playerText.substring(0, textIndex), 54, 1143);
        }
    }

    public boolean isDisplayingTrainerPokemon() {
        if (currentState == PLAYER_SEND_OUT_TEXT || currentState == TO_OFFSCREEN || currentState == THROWING_BALL) {
            return true;
        }
        return false;
    }

    public boolean isFinished() {
        return finished;
    }

    public void dispose() {
        trainerAnimation.dispose();
        pokeball.dispose();
        trainerPokeballBar.dispose();
        trainerEmptyPokeball.dispose();
        trainerPokeball.dispose();
        font.dispose();

    }
}
