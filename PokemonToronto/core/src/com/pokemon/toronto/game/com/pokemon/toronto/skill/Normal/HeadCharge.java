package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/25/2017.
 */

public class HeadCharge extends DamageSkill {
    /**
     * - Name: Head Charge
     * - Type: Normal
     * - Base Damage: 120
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     * - Recoil: 1/4 of damage dealt denoted by the last parameter of 1
     */
    public HeadCharge() {
        //1/4 RECOIL
        super(SkillFactory.HEAD_CHARGE, "Head Charge", SkillDescription.HEAD_CHARGE,15,
                Pokemon.Type.NORMAL, Skill.SkillCategory.PHYSICAL, 100, 120, 1, 1);
        makesPhysicalContact = true;
    }

    /**
     * Return Head Charge's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Head Charge's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
