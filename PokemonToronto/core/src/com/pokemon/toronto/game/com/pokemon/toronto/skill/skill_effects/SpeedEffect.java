package com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;

import java.util.List;

/**
 * Created by Gregory on 8/31/2017.
 */

public class SpeedEffect extends StatEffect {
    public SpeedEffect(SecondaryEffect.Target target, int amount,
                                StatDirection statDirection) {
        super(target, amount, statDirection);
    }

    /**
     * Use the speed effect.
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
        super.use(results, skillUser, enemyPokemon, field, userField, enemyField, isFirstAttack);
        if (statDirection == SecondaryEffect.StatDirection.DECREASE) {
            //Attempt to lower the speed stage.
            if (receiverField.hasMist()) {
                results.add("Mist prevents " + effectReceiver.getName() + "\nfrom losing Speed!");
            }
            else if (effectReceiver.getSpeedStage() == -6) {
                results.add(effectReceiver.getName() + "'s speed can't be lowered.");
            } else {
                effectReceiver.decreaseSpeedStage(finalAmount);
                results.add(effectReceiver.getName() + "'s speed" + getFallText());
            }
        } else {
            //Attempt to increase the speed stage.
            if (effectReceiver.getSpeedStage() == 6) {
                results.add(effectReceiver.getName() + "'s speed can't get higher.");
            } else {
                effectReceiver.increaseSpeedStage(finalAmount);
                results.add(effectReceiver.getName() + "'s speed" + getRoseText());
            }
        }
    }
}
