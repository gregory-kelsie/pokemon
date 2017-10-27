package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/2/2017.
 */

public class SacredSword extends DamageSkill {
    /**
     * - Name: Sacred Sword
     * - Type: Fighting
     * - Base Damage: 90
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public SacredSword() {
        super(SkillFactory.SACRED_SWORD, "Sacred Sword", 15, Pokemon.Type.FIGHTING, SkillCategory.PHYSICAL, 100, 90, 1);
        makesPhysicalContact = true;
        ignoreTargetStatChanges = true;
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
