package com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/20/2017.
 */

public class Acrobatics extends DamageSkill {
    /**
     * - Name: Acrobatics
     * - Type: Flying
     * - Base Damage: 55
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Acrobatics() {
        super(SkillFactory.ACROBATICS, "Acrobatics", SkillDescription.ACROBATICS, 15,
                Pokemon.Type.FLYING, Skill.SkillCategory.PHYSICAL, 100, 55, 1);
        makesPhysicalContact = true;
        //TODO: Override use method and check if the user is holding an item
    }

    /**
     * Return Acrobatics's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Acrobatics's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
