package com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.FlinchEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;

/**
 * Created by Gregory on 9/19/2017.
 */

public class SeedFlare extends SecondaryEffectSkill {
    /**
     * - Name: Seed Flare
     * - Type: Grass
     * - Base Damage: 120
     * - PP: 5
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 85
     */
    public SeedFlare() {
        super(SkillFactory.SEED_FLARE, "Seed Flare", SkillDescription.SEED_FLARE, 5,
                Pokemon.Type.GRASS, SkillCategory.SPECIAL, 85, 120, 1, .4);
        secondaryEffects.add(new SpecialDefenseEffect(SecondaryEffect.Target.ENEMY, 2,
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
