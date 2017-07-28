package com.pokemon.toronto.game.com.pokemon.toronto.animation.skill;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;

/**
 * Created by Gregory on 7/27/2017.
 */

public class StringShotAnimation extends SkillAnimation {
    private final int SHOOTING_STRING = 0;
    private final int BINDING = 1;
    private final int DECREASING_STAT = 2;
    private final int FINISHED = 3;

    private Texture string;
    private int state;

    private double stringX;
    private double stringY;

    public StringShotAnimation(boolean playerUser) {
        super(playerUser);
        state = SHOOTING_STRING;
        stringX = 318;
        stringY = 1461;
        string = new Texture("battle/skillAnimations/string.png");
    }

    @Override
    public void update(double dt) {
        if (state == SHOOTING_STRING) {
            updateShootingString(dt);
        }
    }

    private void updateShootingString(double dt) {
        stringX += dt * 500;
        stringY += dt * 150;
        if (stringX >= 1020) {
            state = FINISHED;
            finished = true;
        }
    }

    @Override
    public void render(SpriteBatch batch) {

    }

    @Override
    public void drawAnimationBackground(SpriteBatch batch) {

    }

    @Override
    public void drawAnimation(SpriteBatch batch) {
        if (state == SHOOTING_STRING) {
            Gdx.app.log("Drawing", "kappa");
            batch.draw(string, Math.round(stringX), Math.round(stringY));
        }
    }
}
