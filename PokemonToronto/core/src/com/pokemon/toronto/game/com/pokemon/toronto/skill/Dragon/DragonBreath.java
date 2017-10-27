package com.pokemon.toronto.game.com.pokemon.toronto.skill.Dragon;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ParalysisEffect;

/**
 * Created by Gregory on 10/19/2017.
 */

public class DragonBreath extends SecondaryEffectSkill {
    /**
     * - Name: Dragon Breath
     * - Type: Dragon
     * - Base Damage: 60
     * - PP: 20
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public DragonBreath() {
        super(SkillFactory.DRAGON_BREATH, "Dragon Breath", 20, Pokemon.Type.DRAGON, SkillCategory.SPECIAL, 100, 60, 1, .3);
        secondaryEffects.add(new ParalysisEffect(SecondaryEffect.Target.ENEMY));
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
