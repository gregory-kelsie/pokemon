package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/1/2017.
 */

public class CrossChop extends DamageSkill {
    /**
     * - Name: Cross Chop
     * - Type: Fighting
     * - Base Damage: 100
     * - PP: 5
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 80
     */
    public CrossChop() {
        super(SkillFactory.CROSS_CHOP, "Cross Chop", 5, Pokemon.Type.FIGHTING, SkillCategory.PHYSICAL, 80, 100, 2);
        makesPhysicalContact = true;

    }

    /**
     * Return Cross Chop's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Cross Chop's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
