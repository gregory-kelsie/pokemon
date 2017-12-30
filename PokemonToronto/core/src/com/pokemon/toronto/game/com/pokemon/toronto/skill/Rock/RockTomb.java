package com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpeedEffect;

/**
 * Created by Gregory on 9/18/2017.
 */

public class RockTomb extends SecondaryEffectSkill {
    /**
     * - Name: Rock Tomb
     * - Type: Rock
     * - Base Damage: 60
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 95
     */
    public RockTomb() {
        super(SkillFactory.ROCK_TOMB, "Rock Tomb", SkillDescription.ROCK_TOMB, 15,
                Pokemon.Type.ROCK, SkillCategory.PHYSICAL, 95, 60, 1, 1.0);
        secondaryEffects.add(new SpeedEffect(SecondaryEffect.Target.ENEMY, 1,
                SecondaryEffect.StatDirection.DECREASE));
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
