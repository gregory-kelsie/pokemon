package com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;

/**
 * Created by Gregory on 9/19/2017.
 */

public class MeteorMash extends SecondaryEffectSkill {
    /**
     * - Name: Meteor Mash
     * - Type: Steel
     * - Base Damage: 90
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 90
     */
    public MeteorMash() {
        super(SkillFactory.METEOR_MASH, "Meteor Mash", 10, Pokemon.Type.STEEL, SkillCategory.PHYSICAL, 90, 90, 1, .2);
        secondaryEffects.add(new AttackEffect(SecondaryEffect.Target.SELF, 1, SecondaryEffect.StatDirection.INCREASE));
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
