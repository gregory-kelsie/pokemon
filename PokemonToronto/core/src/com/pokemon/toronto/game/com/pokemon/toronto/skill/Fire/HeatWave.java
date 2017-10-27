package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fire;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.BurnEffect;

/**
 * Created by Gregory on 9/30/2017.
 */

public class HeatWave extends SecondaryEffectSkill {
    /**
     * - Name: Heat Wave
     * - Type: Fire
     * - Base Damage: 95
     * - PP: 10
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 90
     */
    public HeatWave() {
        super(SkillFactory.HEAT_WAVE, "Heat Wave", 10, Pokemon.Type.FIRE, SkillCategory.SPECIAL, 90, 95, 1, .1);
        secondaryEffects.add(new BurnEffect(SecondaryEffect.Target.ENEMY));
    }

    /**
     * Return the skill's animation, player side or enemy side.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return The skill's animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
