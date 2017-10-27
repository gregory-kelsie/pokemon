package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/26/2017.
 */

public class Slam extends DamageSkill {

    /**
     * - Name: Slam
     * - Type: Normal
     * - Base Damage: 80
     * - PP: 20
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 75
     */
    public Slam() {
        super(SkillFactory.SLAM, "Slam", 20, Pokemon.Type.NORMAL, Skill.SkillCategory.PHYSICAL, 75, 80, 1);
        makesPhysicalContact = true;
    }

    /**
     * Return Slam's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Slam's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
