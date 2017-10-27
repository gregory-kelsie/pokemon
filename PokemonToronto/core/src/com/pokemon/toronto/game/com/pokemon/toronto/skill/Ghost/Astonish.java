package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.FlinchEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialAttackEffect;

/**
 * Created by Gregory on 10/22/2017.
 */

public class Astonish extends SecondaryEffectSkill {
    /**
     * - Name: Astonish
     * - Type: Ghost
     * - Base Damage: 30
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Astonish() {
        super(SkillFactory.ASTONISH, "Astonish", 15, Pokemon.Type.GHOST, SkillCategory.PHYSICAL,
                100, 30, 1, .3);
        secondaryEffects.add(new FlinchEffect(SecondaryEffect.Target.ENEMY));
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
