package com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;

import java.util.List;

/**
 * Created by Gregory on 8/31/2017.
 */

public class SpecialDefenseEffect extends StatEffect {
    public SpecialDefenseEffect(SecondaryEffect.Target target, int amount,
                               StatDirection statDirection) {
        super(target, amount, statDirection);
    }

    /**
     * Use the special defense effect.
     * @param results The results String list after using the effect.
     * @param skillUser The Pokemon using the skill that causes this effect.
     * @param enemyPokemon The Pokemon not using the skill.
     * @param field
     * @param userField
     * @param enemyField
     * @param isFirstAttack Whether or not the effect is a result of the first attack.
     */
    @Override
    public void use(List<String> results, Pokemon skillUser, Pokemon enemyPokemon,
                    Field field, SubField userField, SubField enemyField, boolean isFirstAttack) {
        Pokemon effectReceiver;
        if (target == SecondaryEffect.Target.SELF) {
            effectReceiver = skillUser;
        } else {
            effectReceiver = enemyPokemon;
        }
        if (statDirection == SecondaryEffect.StatDirection.DECREASE) {
            //Attempt to lower the special defense stage.
            if (effectReceiver.getSpecialDefenseStage() == -6) {
                results.add(effectReceiver.getName() + "'s special defense can't be lowered.");
            } else {
                effectReceiver.decreaseSpDefenseStage(amount);
                results.add(effectReceiver.getName() + "'s special defense" + getFallText());
            }
        } else {
            //Attempt to increase the special defense stage.
            if (effectReceiver.getSpecialDefenseStage() == 6) {
                results.add(effectReceiver.getName() + "'s special defense can't get higher.");
            } else {
                effectReceiver.increaseSpDefenseStage(amount);
                results.add(effectReceiver.getName() + "'s special defense" + getRoseText());
            }
        }
    }
}
