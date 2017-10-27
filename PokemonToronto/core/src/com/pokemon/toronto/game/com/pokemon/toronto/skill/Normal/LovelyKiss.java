package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SleepEffect;

/**
 * Created by Gregory on 10/25/2017.
 */

public class LovelyKiss extends EffectSkill {
    /**
     * - Name: Lovely Kiss
     * - Type: Normal
     * - PP: 10
     * - Cat: Misc
     * - Crit Stage: 1
     * - Accuracy: 75
     * - Make enemy sleep
     */
    public LovelyKiss() {
        super(SkillFactory.LOVELY_KISS, "Lovely Kiss", 10, Pokemon.Type.NORMAL, 75);
        effects.add(new SleepEffect(SecondaryEffect.Target.ENEMY));
    }

    /**
     * Return Lovely Kiss's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Lovely Kiss's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
