package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;

/**
 * Created by Gregory on 9/1/2017.
 */

public class Harden extends EffectSkill {
    /**
     * - Name: Harden
     * - Type: Normal
     * - PP: 30
     * - Cat: Misc
     * - Accuracy: 100
     * - Increase user defense by 1 stage.
     */
    public Harden() {
        super(28, "Harden", 30, Pokemon.Type.NORMAL, 100);
        effects.add(new DefenseEffect(SecondaryEffect.Target.SELF, 1,
                SecondaryEffect.StatDirection.INCREASE));
        targetsEnemy = false;
    }

    /**
     * Return Harden's move animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Harden's move animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
