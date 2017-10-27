package com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.FlinchEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ParalysisEffect;

/**
 * Created by Gregory on 10/22/2017.
 */

public class ZingZap extends SecondaryEffectSkill {
    /**
     * - Name: Zing Zap
     * - Type: Electric
     * - Base Damage: 80
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public ZingZap() {
        super(SkillFactory.ZING_ZAP, "Zing Zap", 10, Pokemon.Type.ELECTRIC,
                SkillCategory.PHYSICAL, 100, 80, 1, .3);
        secondaryEffects.add(new FlinchEffect(SecondaryEffect.Target.ENEMY));
        makesPhysicalContact = true;
    }

    /**
     * Return Zing Zap's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Zing Zap's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
