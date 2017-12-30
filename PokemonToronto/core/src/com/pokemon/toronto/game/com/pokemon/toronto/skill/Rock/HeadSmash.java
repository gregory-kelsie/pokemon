package com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/18/2017.
 */

public class HeadSmash extends DamageSkill {

    /**
     * - Name: Head Smash
     * - Type: Rock
     * - Base Damage: 150
     * - PP: 5
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 80
     * - Recoil: 1/2 of damage dealt denoted by the last parameter of 3
     */
    public HeadSmash() {
        //1/2 RECOIL = 3
        super(SkillFactory.HEAD_SMASH, "Head Smash", SkillDescription.HEAD_SMASH, 5,
                Pokemon.Type.ROCK, Skill.SkillCategory.PHYSICAL, 80, 150, 1, 3);
        makesPhysicalContact = true;
    }

    /**
     * Return Head Smash's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Head Smash's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
