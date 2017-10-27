package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.RegularDamageAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.MultiHitMove;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/25/2017.
 */

public class DoubleHit extends MultiHitMove {
    /**
     * - Name: Double Hit
     * - Type: Normal
     * - Base Damage: 35
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 90
     * - Number of Hits: 2
     */
    public DoubleHit() {
        super(SkillFactory.DOUBLE_HIT, "Double Hit", 10, Pokemon.Type.NORMAL,
                Skill.SkillCategory.PHYSICAL, 90, 35, 1, 1);
        makesPhysicalContact = true;
    }

    /**
     * Return Double Hit's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Double Hit's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new RegularDamageAnimation(userAnimation);
    }
}
