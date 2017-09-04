package com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;

import java.util.List;

/**
 * Created by Gregory on 8/31/2017.
 */

public class SpecialAttackEffect extends StatEffect {
    public SpecialAttackEffect(double chance, SecondaryEffect.Target target, int amount,
                         StatDirection statDirection) {
        super(chance, target, amount, statDirection);
    }

    /**
     * Use the special attack effect.
     * @param results The results String list after using the effect.
     * @param skillUser The Pokemon using the skill that causes this effect.
     * @param enemyPokemon The Pokemon not using the skill.
     * @param isFirstAttack Whether or not the effect is a result of the first attack.
     */
    @Override
    public void use(List<String> results, Pokemon skillUser, Pokemon enemyPokemon, boolean isFirstAttack) {
        Pokemon effectReceiver;
        if (target == SecondaryEffect.Target.SELF) {
            effectReceiver = skillUser;
        } else {
            effectReceiver = enemyPokemon;
        }
        if (statDirection == SecondaryEffect.StatDirection.DECREASE) {
            //Attempt to lower the special attack stage.
            if (effectReceiver.getSpecialAttackStage() == -6) {
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