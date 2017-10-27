package com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ParalysisEffect;

/**
 * Created by Gregory on 10/22/2017.
 */

public class Discharge extends SecondaryEffectSkill {
    /**
     * - Name: Discharge
     * - Type: Electric
     * - Base Damage: 80
     * - PP: 15
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Discharge() {
        super(SkillFactory.DISCHARGE, "Discharge", 15, Pokemon.Type.ELECTRIC, SkillCategory.SPECIAL, 100, 80, 1, .3);
        secondaryEffects.add(new ParalysisEffect(SecondaryEffect.Target.ENEMY));
    }

    /**
     * Return Discharge's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Discharge's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
