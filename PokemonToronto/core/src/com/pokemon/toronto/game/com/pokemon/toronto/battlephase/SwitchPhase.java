package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;

/**
 * Created by Gregory on 8/11/2017.
 */

public class SwitchPhase extends BattlePhase {

    private final int COME_BACK = 0;
    private final int NEW_POKEMON_NAME = 1;
    private final int DELAY_AFTER_NEW_POKEMON = 2;
    private int currentState;
    private String text;
    private double counter;
    private int textPosition;
    private Pokemon sentOutPokemon;

    public SwitchPhase(PhaseUpdaterInterface pui, Pokemon sentOutPokemon) {
        super(pui);
        currentState = COME_BACK;
        pui.getUserPokemon().resetBattleVariables();
        text = "Come back " + pui.getUserPokemon().getName();
        counter = 0;
        textPosition = 0;
        this.sentOutPokemon = sentOutPokemon;

    }

    @Override
    public void update(double dt) {
        if (currentState == COME_BACK) {
            updateComeBack(dt);
        } else if (currentState == NEW_POKEMON_NAME) {
            updateNewPokemonName(dt);
        } else if (currentState == DELAY_AFTER_NEW_POKEMON) {
            updateDelayAfterNewPokemon(dt);
        }
    }

    private void updateComeBack(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textPosition < text.length()) {
                textPosition++;
                counter = 0;
            }
        }
        if (counter >= 1.5) {
            currentState = NEW_POKEMON_NAME;
            counter = 0;
            textPosition = 0;
            text = "Go " + sentOutPokemon.getName() + "!!";
        }
    }

    private void updateNewPokemonName(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textPosition < text.length()) {
                textPosition++;
                counter = 0;
            }
        }
        if (counter >= 1.5) {
            currentState = DELAY_AFTER_NEW_POKEMON;
            counter = 0;
            pui.swapPokemon(sentOutPokemon);
        }
    }

    private void updateDelayAfterNewPokemon(double dt) {
        counter += dt;
        if (counter >= 1.5) {
            pui.setPhase(new SentOutAbilityPhase(pui, sentOutPokemon, pui.getEnemyPokemon(), false));
        }
    }

    @Override
    public void renderText(SpriteBatch batch) {
        if (currentState != DELAY_AFTER_NEW_POKEMON) {
            pui.getFont().draw(batch, text.substring(0, textPosition), 54, 1143);
        }
    }

    @Override
    public boolean isHidingUserPokemon() {
        if (currentState == NEW_POKEMON_NAME) {
            return true;
        }
        return false;
    }
}
