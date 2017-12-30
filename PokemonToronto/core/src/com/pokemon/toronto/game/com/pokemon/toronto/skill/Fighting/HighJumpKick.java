package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/1/2017.
 */

public class HighJumpKick extends DamageSkill {
    /**
     * - Name: High Jump Kick
     * - Type: Fighting
     * - Base Damage: 130
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 90
     */
    public HighJumpKick() {
        super(SkillFactory.HIGH_JUMP_KICK, "High Jump Kick", SkillDescription.HIGH_JUMP_KICK, 10,
                Pokemon.Type.FIGHTING, SkillCategory.PHYSICAL, 90, 130, 1);
        makesPhysicalContact = true;
        missRecoil = 1; //Take half hp.
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
