package com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/19/2017.
 */

public class RazorLeaf extends DamageSkill {
    /**
     * - Name: Razor Leaf
     * - Type: Grass
     * - Base Damage: 55
     * - PP: 25
     * - Cat: Physical
     * - Crit Stage: 2
     * - Accuracy: 95
     */
    public RazorLeaf() {
        super(SkillFactory.RAZOR_LEAF, "Razor Leaf", 25, Pokemon.Type.GRASS, Skill.SkillCategory.PHYSICAL, 95, 55, 2);
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
