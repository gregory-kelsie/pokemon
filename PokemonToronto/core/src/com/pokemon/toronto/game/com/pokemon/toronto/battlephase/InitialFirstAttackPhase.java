package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
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
        //TODO: Change the text into an array so that the text can display that the form changed
        //TODO: before the beginning of the move.
        if (pui.isUserPokemonFirstAttacker()) {
            if (pui.getUserPokemon().getBattleAbility().getId() ==
                    Ability.AbilityId.STANCE_CHANGE) {
                if (!pui.getUserPokemon().isInBladeForm() && pui.getUserSkill().doesDamageToEnemy()) {
                    pui.getUserPokemon().changeToBladeForm();
                    pui.updatePlayerSprite();
                }
            }

            text = pui.getUserPokemon().getName() + " used\n" +
                    pui.getUserSkill().getName() + "!";
        } else {
            if (pui.getEnemyPokemon().getBattleAbility().getId() ==
                    Ability.AbilityId.STANCE_CHANGE) {
                if (!pui.getEnemyPokemon().isInBladeForm() && pui.getEnemySkill().doesDamageToEnemy()) {
                    pui.getEnemyPokemon().changeToBladeForm();
                    pui.updateEnemySprite();
                }
            }
            text = pui.getEnemyPokemon().getName() + " used\n" +
                    pui.getEnemySkill().getName() + "!";
        }
        nextPhase = new UseFirstAttackPhase(pui);
    }

}
