package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

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
 * Created by Gregory on 10/25/2017.
 */

public class Screech extends EffectSkill {
    /**
     * - Name: Screech
     * - Type: Normal
     * - PP: 40
     * - Cat: Misc
     * - Crit Stage: 1
     * - Accuracy: 85
     * - Lower enemy defense by 2 stages.
     */
    public Screech() {
        super(SkillFactory.SCREECH, "Screech", SkillDescription.SCREECH, 40, Pokemon.Type.NORMAL,
                85);
        effects.add(new DefenseEffect(SecondaryEffect.Target.ENEMY, 2,
                SecondaryEffect.StatDirection.DECREASE));
    }

    /**
     * Return Screech's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Screech's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
