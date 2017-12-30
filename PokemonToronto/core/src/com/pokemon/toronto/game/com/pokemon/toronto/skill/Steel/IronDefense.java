package com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpeedEffect;

/**
 * Created by Gregory on 9/19/2017.
 */

public class IronDefense extends EffectSkill {
    /**
     * - Name: IronDefense
     * - Type: Steel
     * - PP: 15
     * - Cat: Misc
     * - Accuracy: 100
     * - Increase defense by 2 stages.
     */
    public IronDefense() {
        super(SkillFactory.IRON_DEFENSE, "Iron Defense", SkillDescription.IRON_DEFENSE, 15,
                Pokemon.Type.STEEL, 100);
        effects.add(new DefenseEffect(SecondaryEffect.Target.SELF,
                2, SecondaryEffect.StatDirection.INCREASE));
        targetsEnemy = false;
    }

    /**
     * Return Iron Defense's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Iron Defense's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
