package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.FreezeEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpeedEffect;

import javax.print.DocFlavor;

/**
 * Created by Gregory on 9/19/2017.
 */

public class IceHammer extends SecondaryEffectSkill {
    /**
     * - Name: Ice Hammer
     * - Type: Ice
     * - Base Damage: 100
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 90
     */
    public IceHammer() {
        super(SkillFactory.ICE_HAMMER, "Ice Hammer", 10, Pokemon.Type.ICE, SkillCategory.PHYSICAL, 90, 100, 1, 1.0);
        secondaryEffects.add(new SpeedEffect(SecondaryEffect.Target.SELF, 1, SecondaryEffect.StatDirection.DECREASE));
        makesPhysicalContact = true;
        punchSkill = true;
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
