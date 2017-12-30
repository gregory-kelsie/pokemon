package com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.List;

/**
 * Created by Gregory on 10/23/2017.
 */

public class PsychoCut extends DamageSkill {
    /**
     * - Name: Psycho Cut
     * - Type: Psychic
     * - Base Damage: 70
     * - PP: 20
     * - Cat: Physical
     * - Crit Stage: 2
     * - Accuracy: 100
     */
    public PsychoCut() {
        super(SkillFactory.PSYCHO_CUT, "Psycho Cut", SkillDescription.PSYCHO_CUT, 20,
                Pokemon.Type.PSYCHIC, Skill.SkillCategory.PHYSICAL, 100, 70, 2);
    }

    /**
     * Return Psycho Cut's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Psycho Cut's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
