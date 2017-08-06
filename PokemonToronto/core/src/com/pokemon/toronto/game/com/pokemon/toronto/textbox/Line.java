package com.pokemon.toronto.game.com.pokemon.toronto.textbox;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Gregory on 6/5/2017.
 */
public class Line {
    //Instance Variables
    private String text;
    private double counter;
    private int textPosition;
    private BitmapFont font;

    /**
     * A line of text in the visual novel format screen.
     * @param text The String of text
     * @param font The BitmapFont font style
     */
    public Line(String text, BitmapFont font) {
        this.text = text;
        this.font = font;
        reset();
    }

    /**
     * Set the text position to the first index in the line.
     * Reset the counter.
     */
    public void reset() {
        textPosition = 0;
        counter = 0;
    }

    /**
     * Update the line of text over a period of time.
     * Updates what is shown of the line over passed time.
     * @param dt The time passed.
     */
    public void update(double dt) {
        counter += dt;
        if (counter >= 0.05) { //Every 0.05s show the next character.
            textPosition = Math.min(textPosition + 1, text.length());
            counter = 0; //Reset the time counter
        }
    }

    /**
     * Return whether or not the entire line is shown.
     * ie the text position is at the final index.
     * @return Whether or not the entire line is displayed.
     */
    public boolean finishedUpdating() {
        if (textPosition == text.length()) {
            return true;
        }
        return false;
    }

    /**
     * Instantly make the text position the final index.
     * This is used when the user taps the textbox to make all
     * of the text display instead of waiting.
     */
    public void quickUpdate() {
        textPosition = text.length();
    }

    /**
     * Render the line of text.
     * @param batch The SpriteBatch that the line is rendered to.
     * @param lineNumber The line number in the textbox to determine how high
     *                   the line will be displayed.
     */
    public void render(SpriteBatch batch, int lineNumber) {
        font.draw(batch, text.substring(0, textPosition), 30, 600 - lineNumber * 90);
    }
}
