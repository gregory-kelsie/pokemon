package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fire;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.BurnEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;

/**
 * Created by Gregory on 9/29/2017.
 */

public class FireLash extends SecondaryEffectSkill {
    /**
     * - Name: Fire Lash
     * - Type: Fire
     * - Base Damage: 80
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public FireLash() {
        super(SkillFactory.FIRE_LASH, "Fire Lash", 15, Pokemon.Type.FIRE, SkillCategory.PHYSICAL, 100, 80, 1, 1.0);
        secondaryEffects.add(new DefenseEffect(SecondaryEffect.Target.ENEMY, 1, SecondaryEffect.StatDirection.DECREASE));
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
