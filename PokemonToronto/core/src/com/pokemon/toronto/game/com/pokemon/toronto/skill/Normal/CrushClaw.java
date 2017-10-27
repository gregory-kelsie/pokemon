package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;

/**
 * Created by Gregory on 10/25/2017.
 */

public class CrushClaw extends SecondaryEffectSkill {
    /**
     * - Name: Crush Claw
     * - Type: Normal
     * - Base Damage: 75
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 95
     */
    public CrushClaw() {
        super(SkillFactory.CRUSH_CLAW, "Crush Claw", 35, Pokemon.Type.NORMAL,
                SkillCategory.PHYSICAL, 95, 75, 1, .5);
        secondaryEffects.add(new DefenseEffect(SecondaryEffect.Target.ENEMY, 1,
                SecondaryEffect.StatDirection.DECREASE));
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
