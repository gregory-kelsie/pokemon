package com.pokemon.toronto.game.com.pokemon.toronto.animation.playertraineranimation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.Animation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.AnimationFactory;

/**
 * Created by Gregory on 6/25/2017.
 */
public class PlayerTrainerAnimation {
    private Animation trainerAnimation;
    private Texture pokeball;
    private int pokeballX;
    private int pokeballY;
    private int state;
    private final int START = 0;
    private final int PAUSE = 1;
    private final int TO_OFFSCREEN = 2;
    private final int THROWING_BALL = 3;
    private boolean finished;

    private BitmapFont font;
    private int fontIndex;
    private double counter;
    private String encounterText;
    private String sendOutText;
    private boolean finishedPauseText;
    private boolean startedPokeballToss;



    public PlayerTrainerAnimation(AssetManager loader, String sentOutPokemonName, String enemyPokemonName) {
        trainerAnimation = AnimationFactory.getPlayerTrainerAnimation();
        trainerAnimation.setLooping(false);
        pokeball = new Texture("battle/trainer/pokeball.png");
        pokeballX = 0;
        pokeballY = 1446;
        state = START;
        finished = false;
        counter = 0;
        font =  new BitmapFont(Gdx.files.internal("battle/font/regularFont.fnt"));
        fontIndex = 0;
        encounterText = "A wild " + enemyPokemonName + " appeared!";
        sendOutText = "Go " + sentOutPokemonName + "!!";
        finishedPauseText = false;
        startedPokeballToss = false;
    }

    public boolean isFinished() {
        return finished;
    }

    public boolean isPaused() {
        if (state == PAUSE) {
            return true;
        }
        return false;
    }

    public boolean finishedPauseText() {
        return finishedPauseText;
    }

    public void unPause() {
        if (state == PAUSE && finishedPauseText) {
            state = TO_OFFSCREEN;
            counter = 0;
        }
    }

    public void render(SpriteBatch batch) {
        trainerAnimation.render(batch);
        if (state == TO_OFFSCREEN) {
            if (startedPokeballToss) {
                batch.draw(pokeball, pokeballX + 123, pokeballY);
            }
        }
    }

    public void renderText(SpriteBatch batch) {
        if (isPaused()) {
            font.draw(batch, encounterText.substring(0, fontIndex), 54, 1143);
        } else if (state == TO_OFFSCREEN) {
            font.draw(batch, sendOutText, 54, 1143);
        }
    }

    public void update(double dt) {
        if (state == START) {
            updateStart(dt);
        } else if (state == TO_OFFSCREEN) {
            updateToOffscreen(dt);
        } else if (state == THROWING_BALL) {
            updateThrowingBall(dt);
        } else if (state == PAUSE) {
            updatePause(dt);
        }
    }

    private void updateStart(double dt) {
        counter += dt;
        if (counter >= 0.0166667) {
            trainerAnimation.setNewCoords(trainerAnimation.getX() - 15, trainerAnimation.getY());
            counter = 0;
            if (trainerAnimation.getX() <= 66) {
                state = PAUSE;
            }
        }

    }

    private void updatePause(double dt) {
        counter += dt;
        if (counter >= 0.02) {
            if (fontIndex < encounterText.length() - 1) {
                fontIndex++;
                counter = 0;
            } else {
                finishedPauseText = true;
            }
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
                finished = true;
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

    private void updateThrowingBall(double dt) {

    }
}
