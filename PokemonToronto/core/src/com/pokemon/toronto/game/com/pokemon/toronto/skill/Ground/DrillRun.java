package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ground;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/22/2017.
 */

public class DrillRun extends DamageSkill {
    /**
     * - Name: Drill Run
     * - Type: Ground
     * - Base Damage: 80
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 2
     * - Accuracy: 95
     */
    public DrillRun() {
        super(SkillFactory.DRILL_RUN, "Drill Run", 10, Pokemon.Type.GROUND,
                Skill.SkillCategory.PHYSICAL, 95, 80, 2);
        makesPhysicalContact = true;
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
