package com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AccuracyEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpeedEffect;

/**
 * Created by Gregory on 10/23/2017.
 */

public class Kinesis extends EffectSkill {
    /**
     * - Name: Kinesis
     * - Type: Psychic
     * - PP: 15
     * - Cat: Misc
     * - Accuracy: 80
     */
    public Kinesis() {
        super(SkillFactory.KINESIS, "Kinesis", SkillDescription.KINESIS,15, Pokemon.Type.PSYCHIC,
                80);
        effects.add(new AccuracyEffect(SecondaryEffect.Target.ENEMY,
                1, SecondaryEffect.StatDirection.DECREASE));
    }

    /**
     * Return Kinesis's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Kinesis's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
