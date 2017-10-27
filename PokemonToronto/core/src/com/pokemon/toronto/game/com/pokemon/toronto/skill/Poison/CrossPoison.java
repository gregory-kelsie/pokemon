package com.pokemon.toronto.game.com.pokemon.toronto.skill.Poison;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/22/2017.
 */

public class CrossPoison extends DamageSkill {
    /**
     * - Name: Cross Poison
     * - Type: Poison
     * - Base Damage: 70
     * - PP: 20
     * - Cat: Physical
     * - Crit Stage: 2
     * - Accuracy: 100
     */
    public CrossPoison() {
        super(SkillFactory.CROSS_POISON, "Cross Poison", 20, Pokemon.Type.POISON,
                Skill.SkillCategory.PHYSICAL, 100, 70, 2);
        makesPhysicalContact = true;
    }

    /**
     * Return the skill's animation, player side or enemy side.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return The skill's animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
