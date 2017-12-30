package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/2/2017.
 */

public class JumpKick extends DamageSkill {
    /**
     * - Name: Jump Kick
     * - Type: Fighting
     * - Base Damage: 100
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 95
     */
    public JumpKick() {
        super(SkillFactory.JUMP_KICK, "Jump Kick", SkillDescription.JUMP_KICK, 10,
                Pokemon.Type.FIGHTING, SkillCategory.PHYSICAL, 95, 100, 1);
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
