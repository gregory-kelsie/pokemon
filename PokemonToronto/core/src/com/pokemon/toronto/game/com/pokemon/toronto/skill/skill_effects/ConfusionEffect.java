package com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;

import java.util.List;

/**
 * Created by Gregory on 8/31/2017.
 */

public class ConfusionEffect extends SecondaryEffect {
    public ConfusionEffect(double chance, SecondaryEffect.Target target) {
        super(chance, target);
    }

    /**
     * Use the confusion effect.
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
        //Check if the user is able to receive confusion.
        if (!effectReceiver.isConfused() && effectReceiver.getAbility() != Pokemon.Ability.OWN_TEMPO) {
            double rand = Math.random(); //Roll the confusion die
            boolean confused = false;
            if (rand <= chance) {
                confused = true;
            }
            if (confused) { //Inflict confusion.
                effectReceiver.induceConfusion();
                results.add(effectReceiver.getName() + " was confused!");
            }
        }
    }
}
