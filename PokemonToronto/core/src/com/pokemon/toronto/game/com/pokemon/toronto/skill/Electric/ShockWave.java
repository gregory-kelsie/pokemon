package com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/22/2017.
 */

public class ShockWave extends DamageSkill {
    /**
     * - Name: Shock Wave
     * - Type: Electric
     * - Base Damage: 60
     * - PP: 20
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: -1 Never misses
     */
    public ShockWave() {
        super(SkillFactory.SHOCK_WAVE, "Shock Wave", 20, Pokemon.Type.ELECTRIC,
                SkillCategory.SPECIAL, -1, 60, 1);
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
