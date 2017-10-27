package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/2/2017.
 */

public class VacuumWave extends DamageSkill {
    /**
     * - Name: Vacuum Wave
     * - Type: Fighting
     * - Base Damage: 40
     * - PP: 30
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public VacuumWave() {
        super(SkillFactory.VACUUM_WAVE, "Vacuum Wave", 30, Pokemon.Type.FIGHTING, SkillCategory.SPECIAL, 100, 40, 1);
        setPriority(1);
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
