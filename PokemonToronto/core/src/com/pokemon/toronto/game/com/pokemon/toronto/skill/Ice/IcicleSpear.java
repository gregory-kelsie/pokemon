package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.RegularDamageAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.MultiHitMove;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/19/2017.
 */

public class IcicleSpear extends MultiHitMove {
    /**
     * - Name: Icicle Spear
     * - Type: Ice
     * - Base Damage: 25
     * - PP: 30
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     * - Number of Hits: 2-5 (As denoted by the last parameter of 0)
     */
    public IcicleSpear() {
        super(SkillFactory.ICICLE_SPEAR, "Icicle Spear", SkillDescription.ICICLE_SPEAR, 30,
                Pokemon.Type.ICE, SkillCategory.PHYSICAL, 100, 25, 1, 0);
    }

    /**
     * Return Icicle Spear's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Icicle Spear's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new RegularDamageAnimation(userAnimation);
    }
}
