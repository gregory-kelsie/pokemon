package com.pokemon.toronto.game.com.pokemon.toronto.skill.Water;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by gregorykelsie on 2018-07-16.
 */

public class OriginPulse extends DamageSkill {
    /**
     * - Name: Origin Pulse
     * - Type: Water
     * - Base Damage: 110
     * - PP: 10
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 85
     */
    public OriginPulse() {
        super(SkillFactory.ORIGIN_PULSE, "Origin Pulse", SkillDescription.ORIGIN_PULSE, 10,
                Pokemon.Type.WATER, Skill.SkillCategory.SPECIAL, 85, 110, 1);
    }

    /**
     * Return Origin Pulse's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Origin Pulse's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
