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

public class FlareBlitz extends SecondaryEffectSkill {
    /**
     * - Name: Flare Blitz
     * - Type: Fire
     * - Base Damage: 120
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public FlareBlitz() {
        super(SkillFactory.FLARE_BLITZ, "Flare Blitz", 15, Pokemon.Type.FIRE, SkillCategory.PHYSICAL, 100, 120, 1, 2, .1);
        secondaryEffects.add(new BurnEffect(SecondaryEffect.Target.ENEMY));
        makesPhysicalContact = true;
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
