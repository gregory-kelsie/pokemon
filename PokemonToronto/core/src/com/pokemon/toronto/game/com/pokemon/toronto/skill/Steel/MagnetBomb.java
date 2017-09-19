package com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/19/2017.
 */

public class MagnetBomb extends DamageSkill {
    /**
     * - Name: Magnet Bomb
     * - Type: Steel
     * - Base Damage: 60
     * - PP: 20
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: Never Misses
     */
    public MagnetBomb() {
        super(SkillFactory.MAGNET_BOMB, "Magnet Bomb", 20, Pokemon.Type.STEEL, Skill.SkillCategory.PHYSICAL, -1, 60, 1);
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
