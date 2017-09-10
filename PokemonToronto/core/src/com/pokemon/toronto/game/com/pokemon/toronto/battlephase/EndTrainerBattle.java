package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Gregory on 9/8/2017.
 */

public class EndTrainerBattle extends BattlePhase {
    private final int DEFEAT = 0;
    private final int VICTORY = 1;
    private final int MONEY = 2;
    private int currentState;
    private double counter;
    private int textIndex;
    private String defeatText;
    private String victoryText;
    private String moneyText;
    private Texture trainerTexture;
    private Music victoryBgm;
    public EndTrainerBattle(PhaseUpdaterInterface pui) {
        super(pui);
        defeatText = "You defeated\n" + pui.getTrainer().getTitle() + " " + pui.getTrainer().getName() + "!!";
        victoryText = pui.getTrainer().getVictoryText();
        moneyText = "You got 1000 PokeDollars\nfor winning.";
        currentState = DEFEAT;
        counter = 0;
        textIndex = 0;
        trainerTexture = new Texture(pui.getTrainer().getIconPath());
        pui.disposeBgm();
        victoryBgm = Gdx.audio.newMusic(Gdx.files.internal("bgm/trainervictory.mp3"));
        victoryBgm.play();
    }

    private void goToNextState() {
        counter = 0;
        textIndex = 0;
        if (currentState == 2) {
            pui.finishedBattle();
            dispose();
        } else {
            currentState++;
        }
    }

    private String getCurrentText() {
        if (currentState == DEFEAT) {
            return defeatText;
        } else if (currentState == VICTORY) {
            return victoryText;
        } else {
            return moneyText;
        }
    }

    @Override
    public void update(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textIndex < getCurrentText().length()) {
                textIndex = textIndex + 1;
                counter = 0;
            }
        }
        if (counter >= 1.5) {
            goToNextState();
        }
    }

    public void dispose() {
        victoryBgm.stop();
        victoryBgm.dispose();
        trainerTexture.dispose();
    }

    public void render(SpriteBatch batch) {
        if (currentState > 0) {
            batch.draw(trainerTexture, 610, 1560, 340, 340);
        }
    }

    @Override
    public void renderText(SpriteBatch batch) {
        pui.getFont().draw(batch, getCurrentText().substring(0, textIndex), 54, 1143);
    }
}
