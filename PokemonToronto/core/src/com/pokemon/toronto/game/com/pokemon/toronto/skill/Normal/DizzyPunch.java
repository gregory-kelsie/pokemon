package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ConfusionEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ParalysisEffect;

/**
 * Created by Gregory on 10/25/2017.
 */

public class DizzyPunch extends SecondaryEffectSkill {
    /**
     * - Name: Dizzy Punch
     * - Type: Normal
     * - Base Damage: 70
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public DizzyPunch() {
        super(SkillFactory.DIZZY_PUNCH, "Dizzy Punch", 10, Pokemon.Type.NORMAL,
                SkillCategory.PHYSICAL, 100, 70, 1, .2);
        secondaryEffects.add(new ConfusionEffect(SecondaryEffect.Target.ENEMY));
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
