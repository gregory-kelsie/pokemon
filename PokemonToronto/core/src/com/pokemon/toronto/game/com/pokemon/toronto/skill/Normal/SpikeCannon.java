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

public class SpikeCannon extends MultiHitMove {
    /**
     * - Name: Spike Cannon
     * - Type: Normal
     * - Base Damage: 20
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 15
     * - Number of Hits: 2-5
     */
    public SpikeCannon() {
        super(SkillFactory.SPIKE_CANNON, "Spike Cannon", SkillDescription.SPIKE_CANNON, 15,
                Pokemon.Type.NORMAL, Skill.SkillCategory.PHYSICAL, 100, 20, 1, 0);
    }

    /**
     * Return Spike Cannon's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Spike Cannon's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new RegularDamageAnimation(userAnimation);
    }
}
