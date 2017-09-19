package com.pokemon.toronto.game.com.pokemon.toronto.skill.Water;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/16/2017.
 */

public class AquaJet extends DamageSkill {
    /**
     * - Name: Aqua Jet
     * - Type: Water
     * - Base Damage: 40
     * - PP: 20
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public AquaJet() {
        super(SkillFactory.AQUA_JET, "Aqua Jet", 20, Pokemon.Type.WATER, SkillCategory.PHYSICAL, 100, 40, 1);
        makesPhysicalContact = true;
        setPriority(1); //Has a priority of +1
    }

    /**
     * Return Aqua Jet's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Aqua Jet's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
