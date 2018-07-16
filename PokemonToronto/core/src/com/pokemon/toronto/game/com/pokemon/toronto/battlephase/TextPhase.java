package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Gregory on 7/30/2017.
 */

public class TextPhase extends BattlePhase {
    protected String text;
    protected double textCounter;
    protected int textPosition;
    protected BattlePhase nextPhase;
    public TextPhase(PhaseUpdaterInterface pui, String text) {
        super(pui);
        textCounter = 0;
        textPosition = 0;
        this.text = text;

    }
    public TextPhase(PhaseUpdaterInterface pui) {
        super(pui);
        textCounter = 0;
        textPosition = 0;
        this.text = "";
    }

    @Override
    public void update(double dt) {

        textCounter += dt;
        if (textCounter >= 0.03) {
            if (textPosition < text.length()) {
                textPosition += 1;
                textCounter = 0;
            }
        }
        //1 Second delay after writing the name.
        //No delay if there is no text.
        if (text == "" || textCounter >= 1.5) {
            pui.setPhase(nextPhase);
        }
    }

    public String getText() {
        return text;
    }

    public void renderText(SpriteBatch batch) {
        pui.getFont().draw(batch, text.substring(0, textPosition), 54, 1143);
    }

}
