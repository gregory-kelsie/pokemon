package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;

/**
 * Created by Gregory on 10/2/2017.
 */

public class Superpower extends SecondaryEffectSkill {
    /**
     * - Name: Superpower
     * - Type: Fighting
     * - Base Damage: 120
     * - PP: 5
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Superpower() {
        super(SkillFactory.SUPERPOWER, "Superpower", SkillDescription.SUPERPOWER, 5,
                Pokemon.Type.FIGHTING, SkillCategory.PHYSICAL, 100, 120, 1, 1.0);
        secondaryEffects.add(new AttackEffect(SecondaryEffect.Target.SELF, 1 ,
                SecondaryEffect.StatDirection.DECREASE));
        secondaryEffects.add(new DefenseEffect(SecondaryEffect.Target.SELF, 1 ,
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
