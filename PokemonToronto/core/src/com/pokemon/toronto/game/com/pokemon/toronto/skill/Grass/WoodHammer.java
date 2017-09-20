package com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/19/2017.
 */

public class WoodHammer extends DamageSkill {
    /**
     * - Name: Wood Hammer
     * - Type: Normal
     * - Base Damage: 90
     * - PP: 20
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 85
     * - Recoil: 1/3 of damage dealt denoted by the last parameter of 2
     */
    public WoodHammer() {
        //1/3 RECOIL
        super(SkillFactory.WOOD_HAMMER, "Wood Hammer", 15, Pokemon.Type.GRASS, Skill.SkillCategory.PHYSICAL, 100, 120, 1, 2);
        makesPhysicalContact = true;
    }

    /**
     * Return Wood Hammer's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Wood Hammer's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
