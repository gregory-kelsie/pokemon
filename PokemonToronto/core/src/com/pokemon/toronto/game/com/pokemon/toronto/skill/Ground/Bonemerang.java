package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ground;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.RegularDamageAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.MultiHitMove;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/22/2017.
 */

public class Bonemerang extends MultiHitMove {
    /**
     * - Name: Bonemerang
     * - Type: Ground
     * - Base Damage: 50
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 90
     * - Number of Hits: 2
     */
    public Bonemerang() {
        super(SkillFactory.BONEMERANG, "Bonemerang", 10, Pokemon.Type.GROUND,
                Skill.SkillCategory.PHYSICAL, 90, 50, 1, 1);
    }

    /**
     * Return Bonemerang's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Quick Attack's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new RegularDamageAnimation(userAnimation);
    }
}
