package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/25/2017.
 */

public class HornAttack extends DamageSkill {
    /**
     * - Name: Horn Attack
     * - Type: Normal
     * - Base Damage: 65
     * - PP: 25
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public HornAttack() {
        super(SkillFactory.HORN_ATTACK, "Horn Attack", SkillDescription.HORN_ATTACK, 25,
                Pokemon.Type.NORMAL, SkillCategory.PHYSICAL, 100, 65, 1);
    }

    /**
     * Return Horn Attack's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Horn Attack's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
