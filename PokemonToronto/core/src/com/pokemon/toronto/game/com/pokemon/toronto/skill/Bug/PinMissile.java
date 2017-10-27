package com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.RegularDamageAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.MultiHitMove;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/12/2017.
 */

public class PinMissile extends MultiHitMove {
    /**
     * - Name: Pin Missile
     * - Type: Normal
     * - Base Damage: 25
     * - PP: 20
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 95
     * - Number of Hits: 2-5
     */
    public PinMissile() {
        super(SkillFactory.PIN_MISSILE, "Pin Missile", 20, Pokemon.Type.BUG, Skill.SkillCategory.PHYSICAL, 95, 25, 1, 0);
    }

    /**
     * Return Pin Missile's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Quick Attack's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new RegularDamageAnimation(userAnimation);
    }
}
