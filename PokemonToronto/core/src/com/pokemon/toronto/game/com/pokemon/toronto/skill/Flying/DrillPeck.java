package com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/20/2017.
 */

public class DrillPeck extends DamageSkill {
    /**
     * - Name: Drill Peck
     * - Type: Flying
     * - Base Damage: 80
     * - PP: 20
     * - Accuracy: 100
     * - Cat: Physical
     * - Crit Stage: 1
     */
    public DrillPeck() {
        super(SkillFactory.DRILL_PECK, "Drill Peck", 20, Pokemon.Type.FLYING, Skill.SkillCategory.PHYSICAL, 100, 80, 1);
        makesPhysicalContact = true;
    }

    /**
     * Return Drill Peck's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Drill Peck's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
