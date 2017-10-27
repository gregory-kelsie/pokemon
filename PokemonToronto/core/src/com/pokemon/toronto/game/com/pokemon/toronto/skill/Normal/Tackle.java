package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.StringShotAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.List;

/**
 * Created by Gregory on 6/15/2017.
 */
public class Tackle extends DamageSkill {

    /**
     * - Name: Tackle
     * - Type: Normal
     * - Base Damage: 40
     * - PP: 35
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Tackle() {
        super(1, "Tackle", 35, Pokemon.Type.NORMAL, Skill.SkillCategory.PHYSICAL, 100, 40, 1);
        makesPhysicalContact = true;

    }

    /**
     * Return Tackle's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Tackle's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

}
