package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/2/2017.
 */

public class KarateChop extends DamageSkill {
    /**
     * - Name: Karate Chop
     * - Type: Fighting
     * - Base Damage: 50
     * - PP: 25
     * - Cat: Physical
     * - Crit Stage: 2
     * - Accuracy: 100
     */
    public KarateChop() {
        super(SkillFactory.KARATE_CHOP, "Karate Chop", SkillDescription.KARATE_CHOP, 25,
                Pokemon.Type.FIGHTING, SkillCategory.PHYSICAL, 100, 50, 2);
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
