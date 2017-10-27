package com.pokemon.toronto.game.com.pokemon.toronto.skill.Poison;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.PoisonEffect;

/**
 * Created by Gregory on 10/22/2017.
 */

public class PoisonJab extends SecondaryEffectSkill {
    /**
     * - Name: Poison Jab
     * - Type: Poison
     * - Base Damage: 80
     * - PP: 20
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public PoisonJab() {
        super(SkillFactory.POISON_JAB, "Poison Jab", 20, Pokemon.Type.POISON,
                SkillCategory.PHYSICAL, 100, 80, 1, .3);
        secondaryEffects.add(new PoisonEffect(SecondaryEffect.Target.ENEMY));
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
