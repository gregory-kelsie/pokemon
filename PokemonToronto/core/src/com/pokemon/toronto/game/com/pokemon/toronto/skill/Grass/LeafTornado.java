package com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AccuracyEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;

/**
 * Created by Gregory on 9/19/2017.
 */

public class LeafTornado extends SecondaryEffectSkill {
    /**
     * - Name: Leaf Tornado
     * - Type: Grass
     * - Base Damage: 65
     * - PP: 10
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 90
     */
    public LeafTornado() {
        super(SkillFactory.LEAF_TORNADO, "Leaf Tornado", SkillDescription.LEAF_TORNADO, 10,
                Pokemon.Type.GRASS, SkillCategory.SPECIAL, 90, 65, 1, .5);
        secondaryEffects.add(new AccuracyEffect(SecondaryEffect.Target.ENEMY, 1,
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
