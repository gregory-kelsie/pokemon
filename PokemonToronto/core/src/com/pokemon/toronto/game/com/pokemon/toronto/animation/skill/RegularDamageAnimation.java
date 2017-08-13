package com.pokemon.toronto.game.com.pokemon.toronto.animation.skill;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;

/**
 * Created by Gregory on 8/13/2017.
 */

public class RegularDamageAnimation extends SkillAnimation {
    private Texture hitTexture;
    private int state;
    private final int DISPLAY_HIT = 0;
    private final int DELAY_AFTER_HIT = 1;
    private final int FINISHED = 2;
    private double counter;
    public RegularDamageAnimation(boolean playerUser) {
        super(playerUser);
        hitTexture = new Texture("battle/skillAnimations/hit.png");
        state = DISPLAY_HIT;
        counter = 0;
    }

    @Override
    public void update(double dt) {
        if (state == DISPLAY_HIT) {
            counter += dt;
            if (counter >= 0.5) {
                counter = 0;
                state = DELAY_AFTER_HIT;
            }
        } else if (state == DELAY_AFTER_HIT) {
            counter += dt;
            if (counter >= 0.8) {
                counter = 0;
                finished = true;
                state = FINISHED;
            }
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        hitTexture.dispose();
    }

    @Override
    public void drawAnimation(SpriteBatch batch) {
        if (state == DISPLAY_HIT) {
            if (playerUser) {
                batch.draw(hitTexture, 730, 1680);
            } else {
                batch.draw(hitTexture, 210, 1470);
            }
        }
    }

    @Override
    public void drawAnimationBackground(SpriteBatch batch) {

    }

    @Override
    public void render(SpriteBatch batch) {
    }
}
