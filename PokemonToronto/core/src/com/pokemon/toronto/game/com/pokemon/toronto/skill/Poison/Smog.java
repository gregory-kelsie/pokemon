package com.pokemon.toronto.game.com.pokemon.toronto.skill.Poison;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.PoisonEffect;

/**
 * Created by Gregory on 10/22/2017.
 */

public class Smog extends SecondaryEffectSkill {
    /**
     * - Name: Smog
     * - Type: Poison
     * - Base Damage: 30
     * - PP: 20
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 70
     */
    public Smog() {
        super(SkillFactory.SMOG, "Smog", SkillDescription.SMOG, 20, Pokemon.Type.POISON,
                SkillCategory.SPECIAL, 70, 30, 1, .4);
        secondaryEffects.add(new PoisonEffect(SecondaryEffect.Target.ENEMY));
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
