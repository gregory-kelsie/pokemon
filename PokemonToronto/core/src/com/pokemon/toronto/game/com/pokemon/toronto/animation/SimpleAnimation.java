package com.pokemon.toronto.game.com.pokemon.toronto.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.List;

/**
 * Created by Gregory on 6/5/2017.
 */
public class SimpleAnimation {
    private double frameDuration;
    private boolean looped;
    private double elapsedFrameTime;
    private List<Frame> frames;
    private int currentFrame;

    public SimpleAnimation(List<Frame> frames, double frameDuration) {
        this.frameDuration = frameDuration;
        looped = true;
        elapsedFrameTime = 0;
        currentFrame = 0;
        this.frames = frames;
    }

    public void update(double dt) {
        elapsedFrameTime += dt;
        if (elapsedFrameTime >= frameDuration) {
            elapsedFrameTime = 0;
            //Get next frame.
            if (currentFrame == frames.size() - 1) {
                if (looped) {
                    currentFrame = 0;
                }
            } else {
                currentFrame++;
            }

        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(frames.get(currentFrame).getTexture(),
                frames.get(currentFrame).getX(), frames.get(currentFrame).getY());
    }




}
