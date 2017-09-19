package com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;

import java.util.List;

/**
 * Created by Gregory on 8/31/2017.
 */

public class BurnEffect extends SecondaryEffect {
    public BurnEffect(SecondaryEffect.Target target) {
        super(target);
    }

    /**
     * Use the burn effect.
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
        //Check if the user is able to receive burn.
        if (!effectReceiver.isStatused() && effectReceiver.getCurrentHealth() != 0 &&
                effectReceiver.getAbility() != Pokemon.Ability.SHIELD_DUST) {
            effectReceiver.setPreStatus(Pokemon.Status.BURN);
            results.add(effectReceiver.getName() + " was burned.");
        }
    }
}
