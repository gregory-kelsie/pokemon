package com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/12/2017.
 */

public class Megahorn extends DamageSkill {
    /**
     * - Name: Megahorn
     * - Type: Bug
     * - Base Damage: 120
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 85
     */
    public Megahorn() {
        super(SkillFactory.MEGAHORN, "Megahorn", 10, Pokemon.Type.BUG, Skill.SkillCategory.PHYSICAL, 85, 120, 1);

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
