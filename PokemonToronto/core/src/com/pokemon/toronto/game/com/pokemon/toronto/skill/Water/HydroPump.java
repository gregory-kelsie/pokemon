package com.pokemon.toronto.game.com.pokemon.toronto.skill.Water;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/18/2017.
 */

public class HydroPump  extends DamageSkill {
    /**
     * - Name: Hydro Pump
     * - Type: Water
     * - Base Damage: 110
     * - PP: 10
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 80
     */
    public HydroPump() {
        super(SkillFactory.HYDRO_PUMP, "Hydro Pump", SkillDescription.HYDRO_PUMP, 5,
                Pokemon.Type.WATER, SkillCategory.SPECIAL, 80, 110, 1);
    }

    /**
     * Return Hydro Pump's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Hydro Pump's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
