package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.FlinchEffect;

/**
 * Created by Gregory on 10/26/2017.
 */

public class Snore extends SecondaryEffectSkill {

    /**
     * - Name: Snore
     * - Type: Normal
     * - Base Damage: 50
     * - PP: 15
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Snore() {
        super(SkillFactory.SNORE, "Snore", 15, Pokemon.Type.NORMAL, SkillCategory.SPECIAL,
                100, 50, 1, .3);
        secondaryEffects.add(new FlinchEffect(SecondaryEffect.Target.ENEMY));
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                               SubField userField, SubField enemyField, boolean isFirstAttack, Skill targetsSkill) {
        if (skillUser.isSleeping()) {
            return new FailResult(false);
        }
        return new FailResult("It failed...");
    }

    /**
     * Return Snore's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Snore's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
