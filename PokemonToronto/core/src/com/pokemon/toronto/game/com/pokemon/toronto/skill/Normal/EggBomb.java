package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/25/2017.
 */

public class EggBomb extends DamageSkill {
    /**
     * - Name: Egg Bomb
     * - Type: Normal
     * - Base Damage: 75
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public EggBomb() {
        super(SkillFactory.EGG_BOMB, "Egg Bomb", 10, Pokemon.Type.NORMAL,
                SkillCategory.PHYSICAL, 100, 75, 1);
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
