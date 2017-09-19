package com.pokemon.toronto.game.com.pokemon.toronto.skill.Water;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/16/2017.
 */

public class Crabhammer extends DamageSkill {
    /**
     * - Name: Crabhammer
     * - Type: Water
     * - Base Damage: 100
     * - PP: 20
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 90
     */
    public Crabhammer() {
        super(SkillFactory.CRABHAMMER, "Crabhammer", 10, Pokemon.Type.WATER, Skill.SkillCategory.PHYSICAL, 90, 100, 2);
        makesPhysicalContact = true;
    }

    /**
     * Return Crabhammer's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Crabhammer's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
