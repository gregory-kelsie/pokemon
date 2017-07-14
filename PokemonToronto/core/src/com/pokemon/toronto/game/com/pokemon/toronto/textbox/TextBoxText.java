package com.pokemon.toronto.game.com.pokemon.toronto.textbox;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by Gregory on 6/5/2017.
 */
public class TextBoxText {
    private ArrayList<Line> text;
    private BitmapFont font;
    private BitmapFont headerFont;
    private String header;
    public TextBoxText(BitmapFont headerFont, BitmapFont font) {
        text = new ArrayList<Line>();
        this.font = font;
        this.headerFont = headerFont;
    }

    public void addLine(String l) {
        text.add(new Line(l, font));
    }
    public void setHeader(String header) { this.header = header; }

    public void update(double dt) {
        for (int i = 0; i < text.size(); i++) {
            text.get(i).update(dt);
            if (i + 1 != text.size()) {
                //Don't update the rest of the lines while the current one
                //is not finished updating.
                if (!text.get(i).finishedUpdating()) {
                    break;
                }
            }
        }
    }

    public void quickUpdate() {
        for (int i = 0; i < text.size(); i++) {
            text.get(i).quickUpdate();
        }
    }

    public void resetLines() {
        for (int i = 0; i < text.size(); i++) {
            text.get(i).reset();
        }
    }

    public void render(SpriteBatch batch) {
        headerFont.draw(batch, header, 30, 730);
        for (int i = 0; i < text.size(); i++) {
            text.get(i).render(batch, i);
        }
    }

    public void dispose() {
        font.dispose();
        headerFont.dispose();
    }

    public boolean finishedUpdating() {
        //The text box is finished updating if the last line is finished.
        if (text.get(text.size() - 1).finishedUpdating()) {
            return true;
        }
        return false;
    }


}
