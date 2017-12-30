package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/26/2017.
 */

public class Swift extends DamageSkill {

    /**
     * - Name: Swift
     * - Type: Normal
     * - Base Damage: 60
     * - PP: 20
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: n/a should always hit
     */
    public Swift() {
        super(SkillFactory.SWIFT, "Swift", SkillDescription.SWIFT, 20, Pokemon.Type.NORMAL,
                SkillCategory.SPECIAL, -1, 60, 1);
    }

    /**
     * Return Swift's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Swift's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
