package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;

/**
 * Created by Gregory on 10/22/2017.
 */

public class SpiritShackle extends DamageSkill {
    /**
     * - Name: Spirit Shackle
     * - Type: Ghost
     * - Base Damage: 80
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public SpiritShackle() {
        super(SkillFactory.SPIRIT_SHACKLE, "Spirit Shackle", 10, Pokemon.Type.GHOST,
                SkillCategory.PHYSICAL, 100, 80, 1);
        //tODO: Implement trapping opponent.

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
