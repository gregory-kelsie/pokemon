package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;

/**
 * Created by Gregory on 9/19/2017.
 */

public class FrostBreath extends DamageSkill {
    /**
     * - Name: Frost Breath
     * - Type: Ice
     * - Base Damage: 60
     * - PP: 10
     * - Cat: Special
     * - Crit Stage: Always Crits
     * - Accuracy: 90
     */
    public FrostBreath() {
        super(SkillFactory.FROST_BREATH, "Frost Breath", SkillDescription.FROST_BREATH, 10,
                Pokemon.Type.ICE, Skill.SkillCategory.SPECIAL, 90, 60, -1);
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
