package com.pokemon.toronto.game.com.pokemon.toronto.skill.Water;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/18/2017.
 */

public class WaterGun extends DamageSkill {
    /**
     * - Name: Water Gun
     * - Type: Water
     * - Base Damage: 40
     * - PP: 25
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public WaterGun() {
        super(SkillFactory.WATER_GUN, "Water Gun", 25, Pokemon.Type.WATER, Skill.SkillCategory.SPECIAL, 100, 40, 1);

    }

    /**
     * Return Water Gun's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Water Gun's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
