package com.pokemon.toronto.game.com.pokemon.toronto.animation;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Gregory on 6/5/2017.
 */
public class Frame {
    private Texture frameTexture;
    private int x;
    private int y;
    public Frame(Texture texture, int x, int y) {
        frameTexture = texture;
        this.x = x;
        this.y = y;
    }

    public Texture getTexture() {
        return frameTexture;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int newX) { this.x = newX; }
    public void setY(int newY) { this.y = newY; }


}
