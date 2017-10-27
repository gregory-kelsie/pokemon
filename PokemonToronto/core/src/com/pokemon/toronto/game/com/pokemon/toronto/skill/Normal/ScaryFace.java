package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpeedEffect;

/**
 * Created by Gregory on 10/25/2017.
 */

public class ScaryFace extends EffectSkill {
    /**
     * - Name: Scary Face
     * - Type: Normal
     * - PP: 10
     * - Cat: Misc
     * - Crit Stage: 1
     * - Accuracy: 100
     * - Lower enemy speed by 2 stages.
     */
    public ScaryFace() {
        super(SkillFactory.SCARY_FACE, "Scary Face", 10, Pokemon.Type.NORMAL, 100);
        effects.add(new SpeedEffect(SecondaryEffect.Target.ENEMY, 2,
                SecondaryEffect.StatDirection.DECREASE));
    }

    /**
     * Return Scary Face's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Scary Face's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
