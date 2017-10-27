package com.pokemon.toronto.game.com.pokemon.toronto.skill.Dragon;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/19/2017.
 */

public class DragonPulse extends DamageSkill {
    /**
     * - Name: Dragon Pulse
     * - Type: Dragon
     * - Base Damage: 85
     * - PP: 10
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public DragonPulse() {
        super(SkillFactory.DRAGON_PULSE, "Dragon Pulse", 10, Pokemon.Type.DRAGON, Skill.SkillCategory.SPECIAL, 100, 85, 1);
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
