package com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/11/2017.
 */

public class AttackOrder extends DamageSkill {
    /**
     * - Name: Attack Order
     * - Type: Bug
     * - Base Damage: 90
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 2
     * - Accuracy: 100
     */
    public AttackOrder() {
        super(SkillFactory.ATTACK_ORDER, "Attack Order", 15, Pokemon.Type.BUG, Skill.SkillCategory.PHYSICAL, 100, 90, 2);

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
