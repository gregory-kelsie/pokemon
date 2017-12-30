package com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/20/2017.
 */

public class AirCutter extends DamageSkill {
    /**
     * - Name: Air Cutter
     * - Type: Flying
     * - Base Damage: 60
     * - PP: 25
     * - Cat: Special
     * - Crit Stage: 2
     * - Accuracy: 95
     */
    public AirCutter() {
        //1/3 RECOIL
        super(SkillFactory.AIR_CUTTER, "Air Cutter", SkillDescription.AIR_CUTTER, 25,
                Pokemon.Type.FLYING, SkillCategory.SPECIAL, 95, 60, 2);
    }

    /**
     * Return Air Cutter's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Air Cutter's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
