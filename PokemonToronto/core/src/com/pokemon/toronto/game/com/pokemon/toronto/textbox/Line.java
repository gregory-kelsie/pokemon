package com.pokemon.toronto.game.com.pokemon.toronto.textbox;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Gregory on 6/5/2017.
 */
public class Line {
    private String text;
    private double counter;
    private int textPosition;
    private BitmapFont font;

    public Line(String text, BitmapFont font) {
        this.text = text;
        counter = 0;
        textPosition = 0;
        this.font = font;
    }

    public void reset() {
        textPosition = 0;
        counter = 0;
    }
    public void update(double dt) {

        counter += dt;
        if (counter >= 0.05) {
            textPosition = Math.min(textPosition + 1, text.length());
            counter = 0;
        }
    }

    public boolean finishedUpdating() {
        if (textPosition == text.length()) {
            return true;
        }
        return false;
    }

    public void quickUpdate() {
        textPosition = text.length();
    }

    public void render(SpriteBatch batch, int lineNumber) {
        font.draw(batch, text.substring(0, textPosition), 30, 600 - lineNumber * 90);
    }
}
