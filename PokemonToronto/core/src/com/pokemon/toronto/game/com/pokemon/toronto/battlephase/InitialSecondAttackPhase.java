package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

/**
 * Created by Gregory on 7/31/2017.
 */

public class InitialSecondAttackPhase extends TextPhase {
    private Skill secondSkill;
    public InitialSecondAttackPhase(PhaseUpdaterInterface pui) {
        super(pui);
        phaseName = "InitialSecondAttack";
        init();
    }

    private void init() {
        if (pui.isUserPokemonFirstAttacker()) {
            text = pui.getEnemyPokemon().getName() + " used\n" +
                    pui.getEnemySkill().getName() + "!";
            secondSkill = pui.getEnemySkill();
        } else {
            text = pui.getUserPokemon().getName() + " used\n" +
                    pui.getUserSkill().getName() + "!";
            secondSkill = pui.getUserSkill();
        }
        nextPhase = new UseSecondAttackPhase(pui);
    }
}
