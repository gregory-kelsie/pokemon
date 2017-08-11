package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;

/**
 * Created by Gregory on 8/10/2017.
 */

public class PlayerPokemonFaintPhase extends BattlePhase {

    private double counter;
    private int textPosition;
    private String switchText;

    private int UPDATE_TEXT = 0;
    private int DISPLAY_ROSTER = 1;
    private int WAITING = 2;

    private int currentState;
    public PlayerPokemonFaintPhase(PhaseUpdaterInterface pui) {
        super(pui);
        textPosition = 0;
        counter = 0;
        switchText = "Select a Pokemon to send out.";
        currentState = 0;
    }

    @Override
    public void update(double dt) {
        if (currentState == UPDATE_TEXT) {
            updateText(dt);
        } else if (currentState == DISPLAY_ROSTER) {
            pui.setWaitingForNextPokemon();
            currentState = WAITING;
        }

    }

    private void updateText(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            counter = 0;
            if (textPosition < switchText.length()) {
                textPosition++;
            } else {
                currentState = DISPLAY_ROSTER;
            }
        }
    }

    @Override
    public void renderText(SpriteBatch batch) {
        pui.getFont().draw(batch, switchText.substring(0, textPosition), 54, 1143);
    }

    @Override
    public SkillAnimation getSkillAnimation() {
        return super.getSkillAnimation();
    }
}
