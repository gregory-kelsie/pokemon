package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.RegularDamageAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.MultiHitMove;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/1/2017.
 */

public class DoubleKick extends MultiHitMove {
    /**
     * - Name: Double Kick
     * - Type: Fighting
     * - Base Damage: 30
     * - PP: 30
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     * - Number of Hits: 2 denoted by last parameter of 1
     */
    public DoubleKick() {
        super(SkillFactory.DOUBLE_KICK, "Double Kick", 30, Pokemon.Type.FIGHTING, Skill.SkillCategory.PHYSICAL, 100, 30, 1, 1);
        makesPhysicalContact = true;
    }

    /**
     * Return Double Kick's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Double Kick's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new RegularDamageAnimation(userAnimation);
    }
}
