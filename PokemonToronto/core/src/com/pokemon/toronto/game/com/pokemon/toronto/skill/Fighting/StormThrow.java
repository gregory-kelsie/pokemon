package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/2/2017.
 */

public class StormThrow extends DamageSkill {
    /**
     * - Name: Storm Throw
     * - Type: Fighting
     * - Base Damage: 60
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: Always Crits
     * - Accuracy: 100
     */
    public StormThrow() {
        super(SkillFactory.STORM_THROW, "Storm Throw", 10, Pokemon.Type.FIGHTING, SkillCategory.PHYSICAL, 100, 60, -1);
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
