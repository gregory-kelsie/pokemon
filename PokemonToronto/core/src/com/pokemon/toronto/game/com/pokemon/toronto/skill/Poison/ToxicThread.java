package com.pokemon.toronto.game.com.pokemon.toronto.skill.Poison;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AccuracyEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.PoisonEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpeedEffect;

/**
 * Created by Gregory on 10/22/2017.
 */

public class ToxicThread extends EffectSkill {
    /**
     * - Name: Toxic Thread
     * - Type: Poison
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: 100
     */
    public ToxicThread() {
        super(SkillFactory.TOXIC_THREAD, "Toxic Thread", SkillDescription.TOXIC_THREAD, 20,
                Pokemon.Type.POISON, 100);
        effects.add(new PoisonEffect(SecondaryEffect.Target.ENEMY));
        effects.add(new SpeedEffect(SecondaryEffect.Target.ENEMY,
                1, SecondaryEffect.StatDirection.DECREASE));
    }

    /**
     * Return Toxic Thread's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Toxic Thread's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
