package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fairy;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ParalysisEffect;

/**
 * Created by Gregory on 10/22/2017.
 */

public class DazzlingGleam extends DamageSkill {
    /**
     * - Name: Dazzling Gleam
     * - Type: Fairy
     * - Base Damage: 80
     * - PP: 10
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public DazzlingGleam() {
        super(SkillFactory.DAZZLING_GLEAM, "Dazzling Gleam", 10, Pokemon.Type.FAIRY,
                SkillCategory.SPECIAL, 100, 80, 1);
    }

    /**
     * Return Dazzling Gleam's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Dazzling Gleam's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
