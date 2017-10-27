package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.FlinchEffect;

/**
 * Created by Gregory on 10/25/2017.
 */

public class Round extends DamageSkill {
    /**
     * - Name: Round
     * - Type: Normal
     * - Base Damage: 60
     * - PP: 15
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Round() {
        super(SkillFactory.ROUND, "Round", 15, Pokemon.Type.NORMAL,
                SkillCategory.SPECIAL, 100, 60, 1);
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
