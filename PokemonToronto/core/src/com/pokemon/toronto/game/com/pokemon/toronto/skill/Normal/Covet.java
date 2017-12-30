package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;

/**
 * Created by Gregory on 6/15/2017.
 */
public class Covet extends DamageSkill {

    /**
     * - Name: Covet
     * - Type: Normal
     * - Base Damage: 40
     * - PP: 25
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Covet() {
        super(10, "Covet", SkillDescription.COVET,25, Pokemon.Type.NORMAL, SkillCategory.PHYSICAL,
                100, 40 ,1);
        makesPhysicalContact = true;
    }

    /**
     * Return Covet's animation
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Covet's animation
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
