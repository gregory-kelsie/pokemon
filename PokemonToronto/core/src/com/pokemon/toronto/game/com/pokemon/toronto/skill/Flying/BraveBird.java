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

public class BraveBird extends DamageSkill {
    /**
     * - Name: Brave Bird
     * - Type: Flying
     * - Base Damage: 120
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     * - Recoil: 1/3 of damage dealt denoted by the last parameter of 2
     */
    public BraveBird() {
        //1/3 RECOIL
        super(SkillFactory.BRAVE_BIRD, "Brave Bird", 15, Pokemon.Type.FLYING, Skill.SkillCategory.PHYSICAL, 100, 120, 1, 2);
        makesPhysicalContact = true;
    }

    /**
     * Return Brave Bird's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Brave Bird's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
