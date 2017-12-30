package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ground;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/22/2017.
 */

public class HighHorsepower extends DamageSkill {
    /**
     * - Name: High Horsepower
     * - Type: Ground
     * - Base Damage: 95
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 95
     */
    public HighHorsepower() {
        super(SkillFactory.HIGH_HORSEPOWER, "High Horsepower", SkillDescription.HIGH_HORSEPOWER, 10,
                Pokemon.Type.GROUND, Skill.SkillCategory.PHYSICAL, 95, 95, 1);
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
