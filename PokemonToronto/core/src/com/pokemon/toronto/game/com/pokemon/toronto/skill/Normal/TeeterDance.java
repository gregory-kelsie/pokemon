package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ConfusionEffect;

/**
 * Created by Gregory on 10/26/2017.
 */

public class TeeterDance extends EffectSkill {
    /**
     * - Name: Teeter Dance
     * - Type: Normal
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: 100
     */
    public TeeterDance() {
        super(SkillFactory.TEETER_DANCE, "Teeter Dance", 20, Pokemon.Type.NORMAL, 100);
        effects.add(new ConfusionEffect(SecondaryEffect.Target.ENEMY));
    }

    /**
     * Return Teeter Dance's move animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Teeter Dance's move animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
