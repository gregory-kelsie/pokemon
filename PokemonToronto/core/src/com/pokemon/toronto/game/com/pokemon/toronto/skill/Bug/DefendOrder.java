package com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;

/**
 * Created by Gregory on 10/11/2017.
 */

public class DefendOrder extends EffectSkill {
    /**
     * - Name: Defend Order
     * - Type: Bug
     * - PP: 10
     * - Cat: Misc
     * - Accuracy: -1 (Should never miss)
     */
    public DefendOrder() {
        super(SkillFactory.DEFEND_ORDER, "Defend Order", 10, Pokemon.Type.BUG, -1);
        effects.add(new DefenseEffect(SecondaryEffect.Target.SELF, 1, SecondaryEffect.StatDirection.INCREASE));
        effects.add(new SpecialDefenseEffect(SecondaryEffect.Target.SELF, 1, SecondaryEffect.StatDirection.INCREASE));
        targetsEnemy = false;
    }

    /**
     * Return Defend Order's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Defend Order's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
