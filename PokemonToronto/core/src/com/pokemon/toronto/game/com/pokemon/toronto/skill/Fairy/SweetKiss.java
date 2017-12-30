package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fairy;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ConfusionEffect;

/**
 * Created by Gregory on 10/22/2017.
 */

public class SweetKiss extends EffectSkill {
    /**
     * - Name: Sweet Kiss
     * - Type: Fairy
     * - PP: 10
     * - Cat: Misc
     * - Accuracy: 75
     */
    public SweetKiss() {
        super(SkillFactory.SWEET_KISS, "Sweet Kiss", SkillDescription.SWEET_KISS, 10,
                Pokemon.Type.FAIRY, 75);
        effects.add(new ConfusionEffect(SecondaryEffect.Target.ENEMY));
    }

    /**
     * Return Sweet Kiss's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Sweet Kiss's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
