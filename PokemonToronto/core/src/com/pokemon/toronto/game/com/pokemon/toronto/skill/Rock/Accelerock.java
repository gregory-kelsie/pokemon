package com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/18/2017.
 */

public class Accelerock extends DamageSkill {

    /**
     * - Name: Accelerock
     * - Type: Rock
     * - Base Damage: 40
     * - PP: 20
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Accelerock() {
        super(SkillFactory.ACCELEROCK, "Accelerock", 20, Pokemon.Type.ROCK, SkillCategory.PHYSICAL, 100, 40, 1);
        makesPhysicalContact = true;
        setPriority(1); //Has a priority of +1
    }

    /**
     * Return Accelerock's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Accelerock's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
