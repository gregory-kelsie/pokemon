package com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ParalysisEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SleepEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 9/19/2017.
 */

public class StunSpore extends EffectSkill {

    /**
     * - Name: Stun Spore
     * - Type: Grass
     * - PP: 30
     * - Cat: Misc
     * - Accuracy: 75
     */
    public StunSpore() {
        super(SkillFactory.STUN_SPORE, "Stun Spore", 15, Pokemon.Type.GRASS, 75);
        effects.add(new ParalysisEffect(SecondaryEffect.Target.ENEMY));
    }

    /**
     * Return Stun Spore's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Stun Spore's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                               SubField userField, SubField enemyField, boolean isFirstAttacker) {
        if (enemyPokemon.isStatused() || enemyPokemon.getAbility() == Pokemon.Ability.LIMBER ||
                (enemyPokemon.getTypeOne() == Pokemon.Type.ELECTRIC ||
                        enemyPokemon.getTypeTwo() == Pokemon.Type.ELECTRIC ||
                enemyPokemon.getTypeOne() == Pokemon.Type.GRASS ||
                enemyPokemon.getTypeTwo() == Pokemon.Type.GRASS)) {
            return new FailResult("It failed...");
        }
        return new FailResult(false);
    }
}
