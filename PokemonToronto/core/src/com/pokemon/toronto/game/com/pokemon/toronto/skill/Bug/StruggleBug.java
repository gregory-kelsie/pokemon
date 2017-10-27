package com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ConfusionEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialAttackEffect;

/**
 * Created by Gregory on 10/19/2017.
 */

public class StruggleBug extends SecondaryEffectSkill {
    /**
     * - Name: Struggle Bug
     * - Type: Bug
     * - Base Damage: 50
     * - PP: 20
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public StruggleBug() {
        super(SkillFactory.STRUGGLE_BUG, "Struggle Bug", 20, Pokemon.Type.BUG, SkillCategory.SPECIAL, 100, 50, 1, 1.0);
        secondaryEffects.add(new SpecialAttackEffect(SecondaryEffect.Target.ENEMY, 1, SecondaryEffect.StatDirection.DECREASE));
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
