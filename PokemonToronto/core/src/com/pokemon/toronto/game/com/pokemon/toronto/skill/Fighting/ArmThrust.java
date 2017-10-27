package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.RegularDamageAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.MultiHitMove;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/1/2017.
 */

public class ArmThrust extends MultiHitMove {

    /**
     * - Name: Arm Thrust
     * - Type: Fighting
     * - Base Damage: 20
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     * - Number of Hits: 2-5
     */
    public ArmThrust() {
        super(SkillFactory.ARM_THRUST, "Arm Thrust", 15, Pokemon.Type.FIGHTING, Skill.SkillCategory.PHYSICAL, 100, 20, 1, 0);
        makesPhysicalContact = true;
    }

    /**
     * Return Arm Thrust's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Arm Thrust's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new RegularDamageAnimation(userAnimation);
    }
}
