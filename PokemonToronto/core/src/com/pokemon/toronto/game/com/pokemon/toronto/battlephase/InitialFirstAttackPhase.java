package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

/**
 * Created by Gregory on 7/30/2017.
 */

public class InitialFirstAttackPhase extends TextPhase {
    public InitialFirstAttackPhase(PhaseUpdaterInterface pui) {
        super(pui);
        phaseName = "InitialFirstAttack";
        init();
    }

    private void init() {
        if (pui.isUserPokemonFirstAttacker()) {
            text = pui.getUserPokemon().getName() + " used\n" +
                    pui.getUserSkill().getName() + "!";
        } else {
            text = pui.getEnemyPokemon().getName() + " used\n" +
                    pui.getEnemySkill().getName() + "!";
        }
        nextPhase = new UseFirstAttackPhase(pui);
    }

}
