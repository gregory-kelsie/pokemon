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
 * Created by Gregory on 10/25/2017.
 */

public class Minimize extends EffectSkill {

    /**
     * - Name: Minimize
     * - Type: Normal
     * - PP: 10
     * - Cat: Misc
     * - Accuracy: 100
     * - increase user evasion by 2 stages.
     */
    public Minimize() {
        super(SkillFactory.MINIMIZE, "Minimize", SkillDescription.MINIMIZE, 30,
                Pokemon.Type.NORMAL, -1);
        effects.add(new EvasionEffect(SecondaryEffect.Target.SELF, 2,
                SecondaryEffect.StatDirection.INCREASE));
        targetsEnemy = false;
    }

    /**
     * Return Minimize's move animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Minimize's move animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
