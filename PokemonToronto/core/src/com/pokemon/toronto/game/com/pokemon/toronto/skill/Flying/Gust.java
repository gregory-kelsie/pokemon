package com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/20/2017.
 */

public class Gust extends DamageSkill {
    /**
     * - Name: Gust
     * - Type: Flying
     * - Base Damage: 40
     * - PP: 35
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Gust() {
        super(SkillFactory.GUST, "Gust", 35, Pokemon.Type.FLYING, SkillCategory.SPECIAL, 100, 40, 1);
    }

    /**
     * Return Gust's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Gust's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
