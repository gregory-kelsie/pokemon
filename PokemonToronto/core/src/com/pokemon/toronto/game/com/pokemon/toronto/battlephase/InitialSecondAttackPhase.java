package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
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
                pui.getEnemyPokemon().cancelFlinchSkills();
                text = pui.getEnemyPokemon().getName() + " flinched.";
                pui.getEnemyPokemon().removeFlinch();
                nextPhase = new EndTurnPhase(pui);
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
                nextPhase = new UseSecondAttackPhase(pui);
            }
        } else {
            if (pui.getUserPokemon().hasFlinched()) {
                pui.getUserPokemon().cancelFlinchSkills();
                text = pui.getUserPokemon().getName() + " flinched.";
                pui.getUserPokemon().removeFlinch();
                nextPhase = new EndTurnPhase(pui);
            } else {
                if (pui.getUserPokemon().getBattleAbility().getId() ==
                        Ability.AbilityId.STANCE_CHANGE) {
                    if (!pui.getUserPokemon().isInBladeForm() && pui.getUserSkill().doesDamageToEnemy()) {
                        pui.getUserPokemon().changeToBladeForm();
                        pui.updatePlayerSprite();
                    }
                }
                text = pui.getUserPokemon().getName() + " used\n" +
                        pui.getUserSkill().getName() + "!";
                nextPhase = new UseSecondAttackPhase(pui);
            }
        }

    }
}
