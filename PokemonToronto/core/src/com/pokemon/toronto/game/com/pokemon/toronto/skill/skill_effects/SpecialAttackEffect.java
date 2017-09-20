package com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;

import java.util.List;

/**
 * Created by Gregory on 8/31/2017.
 */

public class SpecialAttackEffect extends StatEffect {
    public SpecialAttackEffect(SecondaryEffect.Target target, int amount,
                         StatDirection statDirection) {
        super(target, amount, statDirection);
    }

    /**
     * Use the special attack effect.
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
        SubField receiverField;
        if (target == SecondaryEffect.Target.SELF) {
            effectReceiver = skillUser;
            receiverField = userField;
        } else {
            effectReceiver = enemyPokemon;
            receiverField = enemyField;
        }
        if (statDirection == SecondaryEffect.StatDirection.DECREASE) {
            //Attempt to lower the special attack stage.
            if (receiverField.hasMist()) {
                results.add("Mist prevents " + effectReceiver.getName() + "\nfrom losing Special Attack!");
            } else if (effectReceiver.getSpecialAttackStage() == -6) {
                results.add(effectReceiver.getName() + "'s special attack can't be lowered.");
            } else {
                effectReceiver.decreaseSpAttackStage(amount);
                results.add(effectReceiver.getName() + "'s special attack" + getFallText());
            }
        } else {
            //Attempt to increase the special attack stage.
            if (effectReceiver.getSpecialAttackStage() == 6) {
                results.add(effectReceiver.getName() + "'s special attack can't get higher.");
            } else {
                effectReceiver.increaseSpAttackStage(amount);
                results.add(effectReceiver.getName() + "'s special attack" + getRoseText());
            }
        }
    }
}
