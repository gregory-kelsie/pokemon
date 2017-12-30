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

/**
 * Created by Gregory on 10/22/2017.
 */

public class Coil extends EffectSkill {
    /**
     * - Name: Coil
     * - Type: Poison
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: -1
     * - Increase atk def and accuracy by one stages.
     */
    public Coil() {
        super(SkillFactory.COIL, "Coil", SkillDescription.COIL, 20, Pokemon.Type.POISON, -1);
        effects.add(new AttackEffect(SecondaryEffect.Target.SELF,
                1, SecondaryEffect.StatDirection.INCREASE));
        effects.add(new DefenseEffect(SecondaryEffect.Target.SELF,
                1, SecondaryEffect.StatDirection.INCREASE));
        effects.add(new AccuracyEffect(SecondaryEffect.Target.SELF,
                1, SecondaryEffect.StatDirection.INCREASE));
        targetsEnemy = false;
    }

    /**
     * Return Coil's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Coil's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
