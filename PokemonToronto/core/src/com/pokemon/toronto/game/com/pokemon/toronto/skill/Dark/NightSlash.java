package com.pokemon.toronto.game.com.pokemon.toronto.skill.Dark;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/21/2017.
 */

public class NightSlash extends DamageSkill {
    /**
     * - Name: Night Slash
     * - Type: Dark
     * - Base Damage: 70
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 2
     * - Accuracy: 100
     */
    public NightSlash() {
        super(SkillFactory.NIGHT_SLASH, "Night Slash", SkillDescription.NIGHT_SLASH ,15,
                Pokemon.Type.DARK, Skill.SkillCategory.PHYSICAL, 100, 70, 2);
        makesPhysicalContact = true;
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
