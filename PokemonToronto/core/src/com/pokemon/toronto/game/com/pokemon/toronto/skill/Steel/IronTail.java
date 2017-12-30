package com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;

/**
 * Created by Gregory on 9/19/2017.
 */

public class IronTail extends SecondaryEffectSkill {
    /**
     * - Name: Iron Tail
     * - Type: Steel
     * - Base Damage: 100
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 75
     */
    public IronTail() {
        super(SkillFactory.IRON_TAIL, "Iron Tail", SkillDescription.IRON_TAIL, 15,
                Pokemon.Type.STEEL, SkillCategory.PHYSICAL, 75, 100, 1, .1);
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
