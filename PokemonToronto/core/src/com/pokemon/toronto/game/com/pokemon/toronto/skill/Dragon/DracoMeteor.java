package com.pokemon.toronto.game.com.pokemon.toronto.skill.Dragon;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialAttackEffect;

/**
 * Created by Gregory on 10/19/2017.
 */

public class DracoMeteor extends SecondaryEffectSkill {
    /**
     * - Name: Draco Meteor
     * - Type: Dragon
     * - Base Damage: 130
     * - PP: 5
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 90
     */
    public DracoMeteor() {
        super(SkillFactory.DRACO_METEOR, "Draco Meteor", 5, Pokemon.Type.DRAGON, SkillCategory.SPECIAL, 90, 130, 1, 1.0);
        secondaryEffects.add(new SpecialAttackEffect(SecondaryEffect.Target.SELF, 2, SecondaryEffect.StatDirection.DECREASE));
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
