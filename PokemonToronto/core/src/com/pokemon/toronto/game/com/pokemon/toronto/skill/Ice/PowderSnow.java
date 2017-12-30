package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.FreezeEffect;

/**
 * Created by Gregory on 9/19/2017.
 */

public class PowderSnow extends SecondaryEffectSkill {
    /**
     * - Name: Powder Snow
     * - Type: Ice
     * - Base Damage: 40
     * - PP: 25
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public PowderSnow() {
        super(SkillFactory.POWDER_SNOW, "Powder Snow", SkillDescription.POWDER_SNOW, 25,
                Pokemon.Type.ICE, SkillCategory.SPECIAL, 100, 40, 1, .1);
        secondaryEffects.add(new FreezeEffect(SecondaryEffect.Target.ENEMY));
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
