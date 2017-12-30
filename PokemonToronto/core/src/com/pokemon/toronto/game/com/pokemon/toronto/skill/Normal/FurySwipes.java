package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.RegularDamageAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.MultiHitMove;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/25/2017.
 */

public class FurySwipes extends MultiHitMove {
    /**
     * - Name: Fury Swipes
     * - Type: Normal
     * - Base Damage: 18
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 80
     * - Number of Hits: 2-5
     */
    public FurySwipes() {
        super(SkillFactory.FURY_SWIPES, "Fury Swipes", SkillDescription.FURY_SWIPES, 15,
                Pokemon.Type.NORMAL, Skill.SkillCategory.PHYSICAL, 80, 18, 1, 0);
        makesPhysicalContact = true;
    }

    /**
     * Return Fury Swipes's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Quick Attack's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new RegularDamageAnimation(userAnimation);
    }
}
