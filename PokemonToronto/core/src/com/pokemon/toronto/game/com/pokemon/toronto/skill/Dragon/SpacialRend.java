package com.pokemon.toronto.game.com.pokemon.toronto.skill.Dragon;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by gregorykelsie on 2018-08-15.
 */

public class SpacialRend extends DamageSkill {
    /**
     * - Name: Spacial Rend
     * - Type: Dragon
     * - Base Damage: 100
     * - PP: 5
     * - Cat: Special
     * - Crit Stage: 2
     * - Accuracy: 95
     */
    public SpacialRend() {
        super(SkillFactory.SPACIAL_REND, "Spacial Rend", SkillDescription.SPACIAL_REND ,5,
                Pokemon.Type.DARK, SkillCategory.SPECIAL, 95, 100, 2);
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
