package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/2/2017.
 */

public class VitalThrow extends DamageSkill {
    /**
     * - Name: Vital Throw
     * - Type: Fighting
     * - Base Damage: 70
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: -1 Never misses
     */
    public VitalThrow() {
        super(SkillFactory.VITAL_THROW, "Vital Throw", SkillDescription.VITAL_THROW, 10,
                Pokemon.Type.FIGHTING, Skill.SkillCategory.PHYSICAL, -1, 70, 1);
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
