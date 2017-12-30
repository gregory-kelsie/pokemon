package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.EvasionEffect;

/**
 * Created by Gregory on 10/26/2017.
 */

public class SweetScent extends EffectSkill {
    /**
     * - Name: Sweet Scent
     * - Type: Normal
     * - PP: 20
     * - Cat: Misc
     * - Crit Stage: 1
     * - Accuracy: 100
     * - Lower enemy evasion by 2 stages.
     */
    public SweetScent() {
        super(SkillFactory.SWEET_SCENT, "Sweet Scent", SkillDescription.SWEET_SCENT, 20,
                Pokemon.Type.NORMAL, 100);
        effects.add(new EvasionEffect(SecondaryEffect.Target.ENEMY, 2,
                SecondaryEffect.StatDirection.DECREASE));
    }

    /**
     * Return Sweet Scent's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Sweet Scent's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
