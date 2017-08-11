package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;

/**
 * Created by Gregory on 8/10/2017.
 */

public class BlackedOutPhase extends BattlePhase {

    private double counter;
    private int textPosition;
    private String blackedOutText;
    private int currentState;

    private int UPDATE_TEXT = 0;
    private int DELAY = 1;
    private int BLACK_OUT = 2;

    public BlackedOutPhase(PhaseUpdaterInterface pui) {
        super(pui);
        counter = 0;
        textPosition = 0;
        blackedOutText = "You have blacked out...";
        currentState = UPDATE_TEXT;
    }

    @Override
    public void update(double dt) {
        if (currentState == UPDATE_TEXT) {
            updateText(dt);
        } else if (currentState == DELAY) {
            delay(dt);
        } else if (currentState == BLACK_OUT) {
            pui.blackOut();
        }
    }

    private void updateText(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            counter = 0;
            if (textPosition < blackedOutText.length()) {
                textPosition++;
            } else {
                currentState = DELAY;
            }
        }
    }

    private void delay(double dt) {
        counter += dt;
        if (counter >= 2) {
            counter = 0;
            currentState = BLACK_OUT;
        }
    }

    @Override
    public void renderText(SpriteBatch batch) {
        pui.getFont().draw(batch, blackedOutText.substring(0, textPosition), 54, 1143);
    }


    @Override
    public SkillAnimation getSkillAnimation() {
        return super.getSkillAnimation();
    }
}
