package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

/**
 * Created by Gregory on 6/15/2017.
 */
public class Scratch extends DamageSkill {

    /**
     * - Name: Scratch
     * - Type: Normal
     * - Base Damage: 40
     * - PP: 35
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Scratch() {
        super("Scratch", 35, Pokemon.Type.NORMAL, Skill.SkillCategory.PHYSICAL, 100, 40, 1);
        makesPhysicalContact = true;
    }

    /**
     * Return Scratch's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Scratch's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
