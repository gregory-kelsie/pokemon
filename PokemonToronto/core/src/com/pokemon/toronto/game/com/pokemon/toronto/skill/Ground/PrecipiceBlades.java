package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ground;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by gregorykelsie on 2018-07-16.
 */

public class PrecipiceBlades extends DamageSkill {
    /**
     * - Name: Precipice Blades
     * - Type: Ground
     * - Base Damage: 120
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 85
     */
    public PrecipiceBlades() {
        super(SkillFactory.PRECIPICE_BLADES, "Precipice Blades", SkillDescription.PRECIPICE_BLADES, 10,
                Pokemon.Type.GROUND, Skill.SkillCategory.PHYSICAL, 85, 120, 1);
    }

    /**
     * Return Precipice Blades's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Precipice Blades's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
    
}
