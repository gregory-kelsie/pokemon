package com.pokemon.toronto.game.com.pokemon.toronto.animation;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.List;

/**
 * Created by Gregory on 6/5/2017.
 */
public class Animation {
    protected double frameDuration;
    protected boolean looped;
    protected double elapsedFrameTime;
    protected List<Frame> frames;
    protected int currentFrame;
    protected boolean paused;
    private int newX;
    private int newY;

    public Animation(List<Frame> frames, double frameDuration) {
        this.frameDuration = frameDuration;
        looped = true;
        elapsedFrameTime = 0;
        currentFrame = 0;
        this.frames = frames;
        paused = false;
        newX = -1;
        newY = -1;
    }

    public Animation(List<Frame> frames, double frameDuration, int newX, int newY) {
        this.frameDuration = frameDuration;
        looped = true;
        elapsedFrameTime = 0;
        currentFrame = 0;
        this.frames = frames;
        paused = false;
        this.newX = newX;
        this.newY = newY;
    }

    public void setLooping(boolean looped) {
        this.looped = looped;
    }

    public void pause() {
        paused = true;
    }

    public void play() {
        paused = false;
    }

    public void reset() {
        currentFrame = 0;
        elapsedFrameTime = 0;
    }

    public boolean finishedAnimation() {
        if (currentFrame == frames.size() - 1) {
            return true;
        }
        return false;
    }

    public int getX() {
        return frames.get(currentFrame).getX();
    }

    public int getY() {
        return frames.get(currentFrame).getY();
    }

    public void update(double dt) {
        if (!paused) {
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
    }

    public void dispose() {
        for (int i = 0; i < frames.size(); i++) {
            frames.get(i).getTexture().dispose();
        }
    }

    public void render(SpriteBatch batch) {
        if (newX == -1) {
            batch.draw(frames.get(currentFrame).getTexture(),
                    frames.get(currentFrame).getX(), frames.get(currentFrame).getY());
        } else {
            batch.draw(frames.get(currentFrame).getTexture(),
                    frames.get(currentFrame).getX(), frames.get(currentFrame).getY(), newX, newY);
        }
    }

    public void setNewCoords(int newX, int newY) {
        for (int i = 0; i < frames.size(); i++) {
            frames.get(i).setX(newX);
            frames.get(i).setY(newY);
        }
    }
}
