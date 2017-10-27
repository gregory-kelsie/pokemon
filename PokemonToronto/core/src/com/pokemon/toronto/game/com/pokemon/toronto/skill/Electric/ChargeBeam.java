package com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ParalysisEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialAttackEffect;

/**
 * Created by Gregory on 10/27/2017.
 */

public class ChargeBeam extends SecondaryEffectSkill {
    /**
     * - Name: Charge Beam
     * - Type: Electric
     * - Base Damage: 50
     * - PP: 10
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 90
     */
    public ChargeBeam() {
        super(SkillFactory.CHARGE_BEAM, "Charge Beam", 10, Pokemon.Type.ELECTRIC,
                SkillCategory.SPECIAL, 90, 50, 1,
                .7);
        secondaryEffects.add(new SpecialAttackEffect(SecondaryEffect.Target.SELF, 1,
                SecondaryEffect.StatDirection.INCREASE));
    }

    /**
     * Return Charge Beam's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Charge Beam's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
