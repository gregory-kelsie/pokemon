package com.pokemon.toronto.game.com.pokemon.toronto.skill.Dark;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.List;

/**
 * Created by Gregory on 10/21/2017.
 */

public class FeintAttack extends DamageSkill {
    /**
     * - Name: Feint Attack
     * - Type: Dark
     * - Base Damage: 60
     * - PP: 20
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: -1 Never misses
     */
    public FeintAttack() {
        super(SkillFactory.FEINT_ATTACK, "Feint Attack", 20, Pokemon.Type.DARK, Skill.SkillCategory.PHYSICAL, -1, 60, 1);
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
