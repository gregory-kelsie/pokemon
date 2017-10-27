package com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpeedEffect;

/**
 * Created by Gregory on 10/23/2017.
 */

public class CosmicPower extends EffectSkill {
    /**
     * - Name: Cosmic Power
     * - Type: Psychic
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: -1
     */
    public CosmicPower() {
        super(SkillFactory.COSMIC_POWER, "Cosmic Power", 20, Pokemon.Type.PSYCHIC, -1);
        effects.add(new DefenseEffect(SecondaryEffect.Target.SELF,
                1, SecondaryEffect.StatDirection.INCREASE));
        effects.add(new SpecialDefenseEffect(SecondaryEffect.Target.SELF,
                1, SecondaryEffect.StatDirection.INCREASE));
        targetsEnemy = false;
    }

    /**
     * Return Cosmic Power's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Cosmic Power's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
