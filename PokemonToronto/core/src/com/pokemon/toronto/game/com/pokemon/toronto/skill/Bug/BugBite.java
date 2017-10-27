package com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/11/2017.
 */

public class BugBite extends DamageSkill {
    /**
     * - Name: Bug Bite
     * - Type: Bug
     * - Base Damage: 60
     * - PP: 20
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public BugBite() {
        super(SkillFactory.BUG_BITE, "Bug Bite", 20, Pokemon.Type.BUG, Skill.SkillCategory.PHYSICAL, 100, 60, 1);
        makesPhysicalContact = true;
        //TODO: Implement taking berry effect from enemy after use.

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
