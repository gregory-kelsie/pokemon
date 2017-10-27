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

public class ZapCannon extends SecondaryEffectSkill {
    /**
     * - Name: Zap Cannon
     * - Type: Electric
     * - Base Damage: 120
     * - PP: 5
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 50
     */
    public ZapCannon() {
        super(SkillFactory.ZAP_CANNON, "Zap Cannon", 5, Pokemon.Type.ELECTRIC,
                SkillCategory.SPECIAL, 50, 120, 1, 1.0);
        secondaryEffects.add(new ParalysisEffect(SecondaryEffect.Target.ENEMY));
    }

    /**
     * Return Zap Cannon's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Zap Cannon's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
