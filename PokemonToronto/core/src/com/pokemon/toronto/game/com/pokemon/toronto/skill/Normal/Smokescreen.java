package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AccuracyEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;

/**
 * Created by Gregory on 10/26/2017.
 */

public class Smokescreen extends EffectSkill {
    /**
     * - Name: Smokescreen
     * - Type: Normal
     * - PP: 20
     * - Cat: Misc
     * - Crit Stage: 1
     * - Accuracy: 100
     * - Lower enemy accuracy by 1 stage.
     */
    public Smokescreen() {
        super(SkillFactory.SMOKESCREEN, "Smokescreen", 20, Pokemon.Type.NORMAL, 100);
        effects.add(new AccuracyEffect(SecondaryEffect.Target.ENEMY, 1,
                SecondaryEffect.StatDirection.DECREASE));
    }

    /**
     * Return Smokescreen's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Smokescreen's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
