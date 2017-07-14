package com.pokemon.toronto.game.com.pokemon.toronto.animation;

import java.util.List;

/**
 * Created by Gregory on 6/5/2017.
 */
public class RotatingAnimation extends Animation {
    private double secondFrameDuration;

    public RotatingAnimation(List<Frame> frames, double frameDuration, double secondFrameDuration) {
        super(frames, frameDuration);
        this.secondFrameDuration = secondFrameDuration;

    }

    public void update(double dt) {
        elapsedFrameTime += dt;
        if (elapsedFrameTime >= frameDuration && currentFrame < frames.size() / 2) {
            elapsedFrameTime = 0;
            currentFrame++;
        } else if (elapsedFrameTime >= secondFrameDuration && currentFrame >= frames.size() / 2) {
            elapsedFrameTime = 0;
            if (currentFrame == frames.size() - 1) {
                if (looped) { currentFrame = 0; }
            } else {
                currentFrame++;
            }
        }
    }
}
