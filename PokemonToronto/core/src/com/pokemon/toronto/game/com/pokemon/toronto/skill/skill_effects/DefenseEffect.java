package com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;

import java.util.List;

/**
 * Created by Gregory on 8/31/2017.
 */

public class DefenseEffect extends StatEffect {
    public DefenseEffect(SecondaryEffect.Target target, int amount,
                        StatDirection statDirection) {
        super(target, amount, statDirection);
    }

    /**
     * Use the defense effect.
     * @param results The results String list after using the effect.
     * @param skillUser The Pokemon using the skill that causes this effect.
     * @param enemyPokemon The Pokemon not using the skill.
     * @param field
     * @param userField
     * @param enemyField
     * @param isFirstAttack Whether or not the effect is a result of the first attack.
     */
    @Override
    public void use(List<String> results, Pokemon skillUser, Pokemon enemyPokemon, Field field,
                    SubField userField, SubField enemyField, boolean isFirstAttack) {
        Pokemon effectReceiver;
        if (target == SecondaryEffect.Target.SELF) {
            effectReceiver = skillUser;
        } else {
            effectReceiver = enemyPokemon;
        }
        if (statDirection == SecondaryEffect.StatDirection.DECREASE &&
                !effectReceiver.isProtectedByDefenseLoweringEffects()) {
            //Attempt to lower the defense stage.
            if (effectReceiver.isProtectedByDefenseLoweringEffects()) {
                results.add(effectReceiver.getName() + "'s defense can't be lowered\n" +
                        "Due to the ability " + effectReceiver.getAbilityString());
            } else if (effectReceiver.getDefenseStage() == -6) {
                results.add(effectReceiver.getName() + "'s defense can't be lowered.");
            } else {
                effectReceiver.decreaseDefenseStage(amount);
                results.add(effectReceiver.getName() + "'s defense" + getFallText());
            }
        } else {
            //Attempt to increase the defense stage.
            if (effectReceiver.getDefenseStage() == 6) {
                results.add(effectReceiver.getName() + "'s defense can't get higher.");
            } else {
                effectReceiver.increaseDefenseStage(amount);
                results.add(effectReceiver.getName() + "'s defense" + getRoseText());
            }
        }
    }
}
