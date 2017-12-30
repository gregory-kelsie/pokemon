package com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialAttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpeedEffect;

/**
 * Created by Gregory on 10/23/2017.
 */

public class CalmMind extends EffectSkill {
    /**
     * - Name: Calm Mind
     * - Type: Psychic
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: -1
     */
    public CalmMind() {
        super(SkillFactory.CALM_MIND, "Calm Mind", SkillDescription.CALM_MIND, 20,
                Pokemon.Type.PSYCHIC, -1);
        effects.add(new SpecialAttackEffect(SecondaryEffect.Target.SELF,
                1, SecondaryEffect.StatDirection.INCREASE));
        effects.add(new SpecialDefenseEffect(SecondaryEffect.Target.SELF,
                1, SecondaryEffect.StatDirection.INCREASE));
        targetsEnemy = false;
    }

    /**
     * Return Calm Mind's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Calm Mind's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
