package com.pokemon.toronto.game.com.pokemon.toronto.textbox;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by Gregory on 6/5/2017.
 */
public class TextBoxText {

    //Instance Variables
    private ArrayList<Line> text;
    private BitmapFont font;
    private BitmapFont headerFont;
    private String header;

    /**
     * A Text Box for the visual novel style screens.
     * @param headerFont The font for the header of the text box
     *                   where the name of the speaker is.
     * @param font The font for the speech text.
     */
    public TextBoxText(BitmapFont headerFont, BitmapFont font) {
        text = new ArrayList<Line>();
        this.font = font;
        this.headerFont = headerFont;
    }

    /**
     * Append a line to the text box
     * @param lineText The text for the added line.
     */
    public void addLine(String lineText) {
        text.add(new Line(lineText, font));
    }

    /**
     * Set the header for the text box.
     * @param header The text for the newly set header.
     */
    public void setHeader(String header) { this.header = header; }


    /**
     * Update the text box by updating each of the lines in the text box.
     * Only update the next line if the current one is finished updating.
     * @param dt The time passed.
     */
    public void update(double dt) {
        for (int i = 0; i < text.size(); i++) {
            text.get(i).update(dt);
            if (i + 1 != text.size()) { //Check if there is another line.
                //Don't update the rest of the lines while the current one
                //is not finished updating.
                if (!text.get(i).finishedUpdating()) {
                    break;
                }
            }
        }
    }

    /**
     * Set all lines in the text box to be completely visible.
     * Ignores the update counter to complete the visibility.
     */
    public void quickUpdate() {
        for (int i = 0; i < text.size(); i++) {
            text.get(i).quickUpdate();
        }
    }

    /**
     * Reset all lines in the text box so that it can be used over again
     * from the start.
     */
    public void resetLines() {
        for (int i = 0; i < text.size(); i++) {
            text.get(i).reset();
        }
    }

    /**
     * Render the text box
     * @param batch The SpriteBatch the text box is being rendered to.
     */
    public void render(SpriteBatch batch) {
        headerFont.draw(batch, header, 30, 730);
        for (int i = 0; i < text.size(); i++) {
            text.get(i).render(batch, i);
        }
    }

    /**
     * Dispose the font and header BitmapFonts.
     */
    public void dispose() {
        font.dispose();
        headerFont.dispose();
    }

    /**
     * Return whether or not the entire text box is now displayable.
     * @return Whether or not the text box is entirely displayable.
     */
    public boolean finishedUpdating() {
        //The text box is finished updating if the last line is finished.
        if (text.get(text.size() - 1).finishedUpdating()) {
            return true;
        }
        return false;
    }


}
