package com.pokemon.toronto.game.com.pokemon.toronto.skill.Water;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/18/2017.
 */

public class SparklingAria extends DamageSkill {
    /**
     * - Name: Sparkling Aria
     * - Type: Water
     * - Base Damage: 90
     * - PP: 10
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public SparklingAria() {
        super(SkillFactory.SPARKLING_ARIA, "Sparkling Aria", SkillDescription.SPARKLING_ARIA, 10,
                Pokemon.Type.WATER, Skill.SkillCategory.SPECIAL, 100, 90, 1);
        //makes sound = true
        //TODO: Add a Heal Burn effect.
    }

    /**
     * Return Sparkling Aria's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Sparkling Aria's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
