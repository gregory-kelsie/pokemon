package com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;

import java.util.List;

/**
 * Created by Gregory on 8/31/2017.
 */

public class AccuracyEffect extends StatEffect {
    public AccuracyEffect(SecondaryEffect.Target target, int amount,
                       StatDirection statDirection) {
        super(target, amount, statDirection);
    }

    /**
     * Use the accuracy effect.
     * @param results The results String list after using the effect.
     * @param skillUser The Pokemon using the skill that causes this effect.
     * @param enemyPokemon The Pokemon not using the skill.
     * @param field
     * @param userField
     * @param enemyField
     * @param isFirstAttack Whether or not the effect is a result of the first attack.
     */
    @Override
    public void use(List<String> results, Pokemon skillUser, Pokemon enemyPokemon, Field field, SubField userField, SubField enemyField, boolean isFirstAttack) {
        Pokemon effectReceiver;
        if (target == SecondaryEffect.Target.SELF) {
            effectReceiver = skillUser;
        } else {
            effectReceiver = enemyPokemon;
        }
        if (statDirection == SecondaryEffect.StatDirection.DECREASE
                && !effectReceiver.isProtectedByAccuracyLoweringEffects()) {
            //Attempt to lower the accuracy stage.
            if (effectReceiver.isProtectedByAccuracyLoweringEffects()) {
                results.add(effectReceiver.getName() + "'s accuracy cannot be\nlowered due to " +
                        effectReceiver.getAbilityString() + ".");
            } else if (effectReceiver.getSpeedStage() == -6) {
                results.add(effectReceiver.getName() + "'s accuracy can't be lowered.");
            } else {
                effectReceiver.decreaseAccuracyStage(amount);
                results.add(effectReceiver.getName() + "'s accuracy" + getFallText());
            }
        } else {
            //Attempt to increase the accuracy stage.
            if (effectReceiver.getAccuracyStage() == 6) {
                results.add(effectReceiver.getName() + "'s accuracy can't get higher.");
            } else {
                effectReceiver.increaseAccuracyStage(amount);
                results.add(effectReceiver.getName() + "'s accuracy" + getRoseText());
            }
        }
    }
}
