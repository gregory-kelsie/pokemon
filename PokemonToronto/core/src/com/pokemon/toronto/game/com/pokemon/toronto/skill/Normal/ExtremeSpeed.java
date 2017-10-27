package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/25/2017.
 */

public class ExtremeSpeed extends DamageSkill {
    /**
     * - Name: Extreme Speed
     * - Type: Normal
     * - Base Damage: 80
     * - PP: 5
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public ExtremeSpeed() {
        super(SkillFactory.EXTREME_SPEED, "Extreme Speed", 5, Pokemon.Type.NORMAL,
                SkillCategory.PHYSICAL, 100, 80, 1);
        makesPhysicalContact = true;
        setPriority(1);
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
