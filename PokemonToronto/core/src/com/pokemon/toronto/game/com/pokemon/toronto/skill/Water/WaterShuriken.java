package com.pokemon.toronto.game.com.pokemon.toronto.skill.Water;

import com.badlogic.gdx.Gdx;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.RegularDamageAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.MultiHitMove;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.List;

/**
 * Created by Gregory on 9/18/2017.
 */

public class WaterShuriken extends MultiHitMove {

    /**
     * - Name: Water Shuriken
     * - Type: Water
     * - Base Damage: 15
     * - PP: 20
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     * - Number of Hits: 2-5 (As denoted by the last parameter of 0)
     */
    public WaterShuriken() {
        super(SkillFactory.WATER_SHURIKEN, "Water Shuriken", SkillDescription.WATER_SHURIKEN, 20,
                Pokemon.Type.WATER, SkillCategory.SPECIAL, 100, 15, 1, 0);
        setPriority(1);
    }

    /**
     * Return Water Shuriken's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Quick Attack's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new RegularDamageAnimation(userAnimation);
    }
}
