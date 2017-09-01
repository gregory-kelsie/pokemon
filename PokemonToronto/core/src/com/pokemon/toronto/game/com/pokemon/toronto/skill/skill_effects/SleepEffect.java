package com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;

import java.util.List;

/**
 * Created by Gregory on 8/31/2017.
 */

public class SleepEffect extends SecondaryEffect {
    public SleepEffect(double chance, SecondaryEffect.Target target) {
        super(chance, target);
    }

    /**
     * Use the sleep effect.
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
        if (!effectReceiver.isStatused() && effectReceiver.getAbility() != Pokemon.Ability.INSOMNIA) {
            double rand = Math.random(); //Roll the sleep die
            boolean sleep = false;
            if (rand <= chance) {
                sleep = true;
            }
            if (sleep) { //Inflict sleep.
                effectReceiver.induceSleep();
                results.add(effectReceiver.getName() + " fell asleep!");
            }
        }
    }
}
