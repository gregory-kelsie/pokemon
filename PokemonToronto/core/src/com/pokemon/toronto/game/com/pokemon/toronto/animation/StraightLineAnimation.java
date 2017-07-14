package com.pokemon.toronto.game.com.pokemon.toronto.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.List;

/**
 * Created by Gregory on 6/6/2017.
 */
public class StraightLineAnimation {
    protected Texture texture;
    protected Texture endingTexture;
    protected double x;
    protected double y;
    protected double speed;
    protected int direction;
    protected double startingX;
    protected double startingY;
    protected int endingX;
    protected int endingY;
    protected boolean ended;
    public static final int DIRECTION_DOWN = 1;
    protected boolean setInitialFrame;
    public StraightLineAnimation(Texture texture, Texture endingTexture, double speed,
                                 int direction, double startingX, double startingY,
                                 int endingX, int endingY) {
        this.texture = texture;
        this.endingTexture = endingTexture;
        this.startingX = startingX;
        this.startingY = startingY;
        this.x = startingX;
        this.y = startingY;
        this.direction = direction;
        this.endingX = endingX;
        this.endingY = endingY;
        ended = false;
        setInitialFrame = false;
    }


    public void update(double dt) {
        if (!ended) {
            if (direction == DIRECTION_DOWN && y <= endingY) {
                if (!ended) {
                    ended = true;
                }
                //Finished updating.
                y = endingY;
            } else {
                //keep updtaing.
                if (direction == DIRECTION_DOWN) {
                    y -= (dt * 1500); //dt * pixels per second
                }
            }
        }
    }

    public boolean ended() {
        return ended;
    }

    public void reset() {
        x = startingX;
        y = startingY;
        ended = false;
        setInitialFrame = false;
    }

    public void setInitialFrame() {
        setInitialFrame = true;
    }


    public void dispose() {
       texture.dispose();
        endingTexture.dispose();
    }

    public void render(SpriteBatch batch) {
        if (!ended || setInitialFrame) {
            batch.draw(texture, Math.round(x), Math.round(y));
        } else {
            batch.draw(endingTexture, Math.round(x), Math.round(y));
        }
    }
}
