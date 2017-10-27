package com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ConfusionEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.FlinchEffect;

/**
 * Created by Gregory on 10/19/2017.
 */

public class Steamroller extends SecondaryEffectSkill {
    /**
     * - Name: Steamroller
     * - Type: Bug
     * - Base Damage: 65
     * - PP: 20
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Steamroller() {
        super(SkillFactory.STEAMROLLER, "Steamroller", 20, Pokemon.Type.BUG, SkillCategory.PHYSICAL, 100, 65, 1, .3);
        secondaryEffects.add(new FlinchEffect(SecondaryEffect.Target.ENEMY));
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
