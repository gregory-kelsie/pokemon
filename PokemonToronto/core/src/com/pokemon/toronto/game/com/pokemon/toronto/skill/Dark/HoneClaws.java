package com.pokemon.toronto.game.com.pokemon.toronto.skill.Dark;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AccuracyEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;

/**
 * Created by Gregory on 10/21/2017.
 */

public class HoneClaws extends EffectSkill {
    /**
     * - Name: Hone Claws
     * - Type: Dark
     * - PP: 15
     * - Cat: Misc
     * - Accuracy: -1
     */
    public HoneClaws() {
        super(SkillFactory.HONE_CLAWS, "Hone Claws", 15, Pokemon.Type.DARK, -1);
        effects.add(new AttackEffect(SecondaryEffect.Target.SELF, 1, SecondaryEffect.StatDirection.INCREASE));
        effects.add(new AccuracyEffect(SecondaryEffect.Target.SELF, 1, SecondaryEffect.StatDirection.INCREASE));
        targetsEnemy = false;
    }

    /**
     * Return Hone Claws's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Hone Claws's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
