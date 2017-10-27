package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ParalysisEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;

/**
 * Created by Gregory on 10/22/2017.
 */

public class ShadowBall extends SecondaryEffectSkill {
    /**
     * - Name: Shadow Ball
     * - Type: Ghost
     * - Base Damage: 80
     * - PP: 15
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public ShadowBall() {
        super(SkillFactory.SHADOW_BALL, "Shadow Ball", 15, Pokemon.Type.GHOST,
                SkillCategory.SPECIAL, 100, 80, 1, .2);
        secondaryEffects.add(new SpecialDefenseEffect(SecondaryEffect.Target.ENEMY, 1,
                SecondaryEffect.StatDirection.DECREASE));
    }

    /**
     * Return the skill's animation, player side or enemy side.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return The skill's animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
