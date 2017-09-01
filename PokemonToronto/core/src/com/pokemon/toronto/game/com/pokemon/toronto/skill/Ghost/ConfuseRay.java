package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ConfusionEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/13/2017.
 */

public class ConfuseRay extends EffectSkill {

    /**
     * - Name: Confuse Ray
     * - Type: Ghost
     * - PP: 10
     * - Cat: Misc
     * - Accuracy: 100
     */
    public ConfuseRay() {
        super(14, "Confuse Ray", 10, Pokemon.Type.GHOST, 100);
        effects.add(new ConfusionEffect(1, SecondaryEffect.Target.ENEMY));
    }

    /**
     * Return Confuse Ray's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return ConfuseRay's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon,
                            Field field, SubField userField, SubField enemyField,
                               boolean isFirstAttack) {
        if (enemyPokemon.isConfused()){
            return new FailResult(enemyPokemon.getName() + " is already confused.");
        } else if (enemyPokemon.getAbility() == Pokemon.Ability.OWN_TEMPO) {
            return new FailResult(enemyPokemon.getName() + " cannot be confused\nbecause it has it's Own Tempo");
        }
        return new FailResult(false);
    }
}
