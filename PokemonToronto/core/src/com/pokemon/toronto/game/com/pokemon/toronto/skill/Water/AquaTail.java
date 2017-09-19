package com.pokemon.toronto.game.com.pokemon.toronto.skill.Water;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/16/2017.
 */

public class AquaTail extends DamageSkill {
    /**
     * - Name: Aqua Tail
     * - Type: Water
     * - Base Damage: 80
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public AquaTail() {
        super(SkillFactory.AQUA_TAIL, "Aqua Tail", 10, Pokemon.Type.WATER, SkillCategory.PHYSICAL, 90, 90, 1);
        makesPhysicalContact = true;
    }

    /**
     * Return Aqua Tail's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Aqua Tail's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
