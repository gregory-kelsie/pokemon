package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/26/2017.
 */

public class Struggle extends DamageSkill {
    /**
     * - Name: Struggle
     * - Type: Normal
     * - Base Damage: 50
     * - PP: 1
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: -1
     * - Recoil: 1/4 of damage dealt denoted by the last parameter of 1
     */
    public Struggle() {
        //1/4 RECOIL
        super(SkillFactory.STRUGGLE, "Struggle", SkillDescription.STRUGGLE, 1, Pokemon.Type.NORMAL,
                Skill.SkillCategory.PHYSICAL, -1, 50, 1, 1);
        makesPhysicalContact = true;
    }

    /**
     * Return Struggle's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Struggle's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
