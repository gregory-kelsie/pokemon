package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Gregory on 9/8/2017.
 */

public class TrainerSendOutPhase extends BattlePhase {
    private double counter;
    private int textIndex;
    private String sendOutText;
    private String sentOutPokemonName;
    public TrainerSendOutPhase(PhaseUpdaterInterface pui) {
        super(pui);
        sentOutPokemonName = pui.getNextPokemonName();
        sendOutText = pui.getTrainer().getTitle() + " " +
                pui.getTrainer().getName() + " sent out\n" + sentOutPokemonName + "!!";
        counter = 0;
        textIndex = 0;
        Gdx.app.log("trainersendout", sendOutText);
    }

    @Override
    public void update(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textIndex < sendOutText.length()) {
                textIndex = textIndex + 1;
                counter = 0;
            }
        }
        if (counter >= 1.5) {
            pui.setNextEnemyPokemon();
            pui.endBattle();

        }
    }

    @Override
    public void renderText(SpriteBatch batch) {
        pui.getFont().draw(batch, sendOutText.substring(0, textIndex), 54, 1143);
    }
}
