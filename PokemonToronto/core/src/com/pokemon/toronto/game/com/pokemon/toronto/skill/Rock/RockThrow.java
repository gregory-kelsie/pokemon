package com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/18/2017.
 */

public class RockThrow extends DamageSkill {
    /**
     * - Name: Rock Throw
     * - Type: Rock
     * - Base Damage: 50
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 90
     */
    public RockThrow() {
        super(SkillFactory.ROCK_THROW, "Rock Throw", 15, Pokemon.Type.ROCK, Skill.SkillCategory.PHYSICAL, 90, 50, 1);
    }

    /**
     * Return Rock Throw's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Rock Throw's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
