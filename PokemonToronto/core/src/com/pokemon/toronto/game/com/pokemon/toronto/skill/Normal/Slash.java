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

public class Slash extends DamageSkill {

    /**
     * - Name: Slash
     * - Type: Normal
     * - Base Damage: 70
     * - PP: 20
     * - Cat: Physical
     * - Crit Stage: 2
     * - Accuracy: 100
     */
    public Slash() {
        super(SkillFactory.SLASH, "Slash", SkillDescription.SLASH, 20, Pokemon.Type.NORMAL,
                Skill.SkillCategory.PHYSICAL, 100, 70, 2);
        makesPhysicalContact = true;
    }

    /**
     * Return Slash's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Slash's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
