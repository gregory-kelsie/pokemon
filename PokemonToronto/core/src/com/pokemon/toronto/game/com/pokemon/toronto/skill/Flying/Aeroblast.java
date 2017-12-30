package com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/20/2017.
 */

public class Aeroblast extends DamageSkill {
    /**
     * - Name: Aeroblast
     * - Type: Flying
     * - Base Damage: 100
     * - PP: 20
     * - Cat: Physical
     * - Crit Stage: 2
     * - Accuracy: 95
     */
    public Aeroblast() {
        super(SkillFactory.AEROBLAST, "Aeroblast", SkillDescription.AEROBLAST, 5,
                Pokemon.Type.FLYING, SkillCategory.SPECIAL, 95, 100, 2);
    }

    /**
     * Return Aeroblast's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Aeroblast's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
