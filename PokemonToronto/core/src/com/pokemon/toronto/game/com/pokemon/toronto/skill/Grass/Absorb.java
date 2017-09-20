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

public class Absorb extends DamageSkill {
    /**
     * - Name: Absorb
     * - Type: Grass
     * - Base Damage: 20
     * - PP: 25
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     * - 4 = Gain Half
     */
    public Absorb() {
        super(SkillFactory.ABSORB, "Absorb", 25, Pokemon.Type.GRASS, Skill.SkillCategory.SPECIAL, 100, 20, 1, 4);
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
