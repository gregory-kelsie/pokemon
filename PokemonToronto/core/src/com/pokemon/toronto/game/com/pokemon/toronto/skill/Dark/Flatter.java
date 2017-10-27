package com.pokemon.toronto.game.com.pokemon.toronto.skill.Dark;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ConfusionEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialAttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;

/**
 * Created by Gregory on 10/21/2017.
 */

public class Flatter extends EffectSkill {
    /**
     * - Name: Flatter
     * - Type: Dark
     * - PP: 15
     * - Cat: Misc
     * - Accuracy: 100
     */
    public Flatter() {
        super(SkillFactory.FLATTER, "Flatter", 15, Pokemon.Type.DARK, 100);
        effects.add(new SpecialAttackEffect(SecondaryEffect.Target.ENEMY, 1, SecondaryEffect.StatDirection.INCREASE));
        effects.add(new ConfusionEffect((SecondaryEffect.Target.ENEMY)));
    }

    /**
     * Return Flatter's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Flatter's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
