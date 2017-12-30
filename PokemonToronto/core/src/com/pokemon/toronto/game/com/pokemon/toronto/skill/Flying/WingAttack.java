package com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/29/2017.
 */

public class WingAttack extends DamageSkill {
    /**
     * - Name: Wing Attack
     * - Type: Flying
     * - Base Damage: 60
     * - PP: 35
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public WingAttack() {
        super(SkillFactory.WING_ATTACK, "Wing Attack", SkillDescription.WING_ATTACK,35,
                Pokemon.Type.FLYING, Skill.SkillCategory.PHYSICAL, 100, 60, 1);
        makesPhysicalContact = true;
    }

    /**
     * Return Wing Attack's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Wing Attack's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
