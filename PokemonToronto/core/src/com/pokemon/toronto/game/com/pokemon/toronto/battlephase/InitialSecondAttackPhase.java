package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.end_of_turn_effects.EndTurnPhase;
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
            if (pui.getEnemyPokemon().hasFlinched()) {
                text = pui.getEnemyPokemon().getName() + " flinched.";
                pui.getEnemyPokemon().removeFlinch();
                nextPhase = new EndTurnPhase(pui);
            } else {
                text = pui.getEnemyPokemon().getName() + " used\n" +
                        pui.getEnemySkill().getName() + "!";
                nextPhase = new UseSecondAttackPhase(pui);
            }
        } else {
            if (pui.getUserPokemon().hasFlinched()) {
                text = pui.getUserPokemon().getName() + " flinched.";
                pui.getUserPokemon().removeFlinch();
                nextPhase = new EndTurnPhase(pui);
            } else {
                text = pui.getUserPokemon().getName() + " used\n" +
                        pui.getUserSkill().getName() + "!";
                nextPhase = new UseSecondAttackPhase(pui);
            }
        }

    }
}
