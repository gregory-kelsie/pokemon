package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fairy;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/22/2017.
 */

public class FairyWind extends DamageSkill {
    /**
     * - Name: Fairy Wind
     * - Type: Fairy
     * - Base Damage: 40
     * - PP: 30
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public FairyWind() {
        super(SkillFactory.FAIRY_WIND, "Fairy Wind", 30, Pokemon.Type.FAIRY,
                SkillCategory.SPECIAL, 100, 40, 1);
    }

    /**
     * Return Fairy Wind's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Fairy Wind's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
