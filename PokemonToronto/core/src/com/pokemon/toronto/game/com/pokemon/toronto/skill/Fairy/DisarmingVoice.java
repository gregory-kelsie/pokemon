package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fairy;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/22/2017.
 */

public class DisarmingVoice extends DamageSkill {
    /**
     * - Name: Disarming Voice
     * - Type: Fairy
     * - Base Damage: 40
     * - PP: 15
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: -1 Never misses
     */
    public DisarmingVoice() {
        super(SkillFactory.DISARMING_VOICE, "Disarming Voice", 15, Pokemon.Type.FAIRY,
                SkillCategory.SPECIAL, -1, 40, 1);
    }

    /**
     * Return Disarming Voice's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Disarming Voice's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
