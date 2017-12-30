package com.pokemon.toronto.game.com.pokemon.toronto.skill.Dragon;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.RegularDamageAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.MultiHitMove;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/19/2017.
 */

public class DualChop extends MultiHitMove {
    /**
     * - Name: Dual Chop
     * - Type: Dragon
     * - Base Damage: 40
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 90
     * - Number of Hits: 2
     */
    public DualChop() {
        super(SkillFactory.DUAL_CHOP, "Dual Chop", SkillDescription.DUAL_CHOP, 15,
                Pokemon.Type.DRAGON, Skill.SkillCategory.PHYSICAL, 90, 40, 1, 1);
        makesPhysicalContact = true;
    }

    /**
     * Return Dual Chop's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Dual Chop's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new RegularDamageAnimation(userAnimation);
    }
}
