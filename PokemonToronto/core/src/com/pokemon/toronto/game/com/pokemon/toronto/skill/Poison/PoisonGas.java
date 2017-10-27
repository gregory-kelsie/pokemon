package com.pokemon.toronto.game.com.pokemon.toronto.skill.Poison;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AccuracyEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.PoisonEffect;

/**
 * Created by Gregory on 10/22/2017.
 */

public class PoisonGas extends EffectSkill {
    /**
     * - Name: Poison Gas
     * - Type: Poison
     * - PP: 40
     * - Cat: Misc
     * - Accuracy: 90
     */
    public PoisonGas() {
        super(SkillFactory.POISON_GAS, "Poison Gas", 40, Pokemon.Type.POISON, 90);
        effects.add(new PoisonEffect(SecondaryEffect.Target.ENEMY));
    }

    /**
     * Return Poison Gas's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Poison Gas's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
