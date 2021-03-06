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
public class QuickAttack extends DamageSkill {

    /**
     * - Name: Quick Attack
     * - Type: Normal
     * - Base Damage: 40
     * - PP: 30
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public QuickAttack() {
        super(2, "Quick Attack", SkillDescription.QUICK_ATTACK, 30, Pokemon.Type.NORMAL,
                SkillCategory.PHYSICAL, 100, 40, 1);
        makesPhysicalContact = true;
        setPriority(1); //Has a priority of +1
    }

    /**
     * Return Quick Attack's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Quick Attack's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
