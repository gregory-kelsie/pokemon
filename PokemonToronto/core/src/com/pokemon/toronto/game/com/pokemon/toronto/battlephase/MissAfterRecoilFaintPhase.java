package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;

/**
 * Created by Gregory on 8/12/2017.
 */

public class MissAfterRecoilFaintPhase extends BattlePhase {

    private String text;
    private String secondText;
    private double counter;
    private int textPosition;

    private int state;

    private final int FIRST_TEXT = 0;
    private final int SECOND_TEXT = 1;

    public MissAfterRecoilFaintPhase(PhaseUpdaterInterface pui) {
        super(pui);
        String attackerName;
        String attackerSkill;
        if (pui.isUserPokemonFirstAttacker()) {
            attackerName = pui.getEnemyPokemon().getName();
            attackerSkill = pui.getEnemySkill().getName();
        } else {
            attackerName = pui.getUserPokemon().getName();
            attackerSkill = pui.getUserSkill().getName();
        }
        text = attackerName + " used\n" + attackerSkill + "!";
        secondText = "But no one was there...";
        state = FIRST_TEXT;
        counter = 0;
        textPosition = 0;
    }

    @Override
    public void update(double dt) {
        if (state == FIRST_TEXT) {
            updateFirstText(dt);
        } else if (state == SECOND_TEXT) {
            updateSecondText(dt);
        }
    }

    private void updateFirstText(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textPosition < text.length()) {
                textPosition++;
                counter = 0;
            }
        }
        if (counter >= 1.5) {
            counter = 0;
            textPosition = 0;
            state = SECOND_TEXT;
        }
    }

    private void updateSecondText(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textPosition < secondText.length()) {
                textPosition++;
                counter = 0;
            }
        }
        if (counter >= 1.5) {
            if (pui.isUserPokemonFirstAttacker()) {
                if (pui.playerHasMorePokemon() && !pui.waitingForNextPokemon()) {
                    pui.setPhase(new PlayerPokemonFaintPhase(pui));
                } else if (!pui.playerHasMorePokemon()) {
                    pui.setPhase(new BlackedOutPhase(pui));
                }
            } else {
                //TODO: Implement player miss after enemy recoil kills themself when there is another pokemon in the enemy party.
            }
        }
    }

    @Override
    public void renderText(SpriteBatch batch) {
        if (state == FIRST_TEXT) {
            pui.getFont().draw(batch, text.substring(0, textPosition), 54, 1143);
        } else if (state == SECOND_TEXT) {
            pui.getFont().draw(batch, secondText.substring(0, textPosition), 54, 1143);
        }
    }

    @Override
    public SkillAnimation getSkillAnimation() {
        return super.getSkillAnimation();
    }
}
