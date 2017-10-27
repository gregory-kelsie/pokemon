package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/25/2017.
 */

public class MegaPunch extends DamageSkill {
    /**
     * - Name: Mega Punch
     * - Type: Normal
     * - Base Damage: 80
     * - PP: 20
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 85
     */
    public MegaPunch() {
        super(SkillFactory.MEGA_PUNCH, "Mega Punch", 20, Pokemon.Type.NORMAL,
                SkillCategory.PHYSICAL, 85, 80, 1);
        makesPhysicalContact = true;
        punchSkill = true;
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
