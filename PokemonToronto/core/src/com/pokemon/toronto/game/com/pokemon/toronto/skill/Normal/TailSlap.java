package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.RegularDamageAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.MultiHitMove;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/26/2017.
 */

public class TailSlap extends MultiHitMove {
    /**
     * - Name: Tail Slap
     * - Type: Normal
     * - Base Damage: 25
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 85
     * - Number of Hits: 2-5
     */
    public TailSlap() {
        super(SkillFactory.TAIL_SLAP, "Tail Slap", SkillDescription.TAIL_SLAP, 10,
                Pokemon.Type.NORMAL, Skill.SkillCategory.PHYSICAL, 85, 25, 1, 0);
        makesPhysicalContact = true;
    }

    /**
     * Return Tail Slap's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Quick Attack's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new RegularDamageAnimation(userAnimation);
    }
}
