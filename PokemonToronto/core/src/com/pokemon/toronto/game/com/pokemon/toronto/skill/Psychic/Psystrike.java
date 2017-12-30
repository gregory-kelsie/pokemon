package com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/23/2017.
 */

public class Psystrike extends DamageSkill {
    /**
     * - Name: Psystrike
     * - Type: Psychic
     * - Base Damage: 80
     * - PP: 10
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     * Deals physical damage shown by reverseCategory
     */
    public Psystrike() {
        super(SkillFactory.PSYSTRIKE, "Psystrike", SkillDescription.PSYSTRIKE, 10,
                Pokemon.Type.PSYCHIC, SkillCategory.SPECIAL, 100, 100, 1);
        reverseCategory = true;
    }

    /**
     * Return Psystrike's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Psystrike's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
