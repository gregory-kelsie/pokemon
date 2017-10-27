package com.pokemon.toronto.game.com.pokemon.toronto.skill.Dragon;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;

/**
 * Created by Gregory on 10/19/2017.
 */

public class DragonClaw extends DamageSkill {
    /**
     * - Name: Dragon Claw
     * - Type: Dragon
     * - Base Damage: 80
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public DragonClaw() {
        super(SkillFactory.DRAGON_CLAW, "Dragon Claw", 15, Pokemon.Type.DRAGON, SkillCategory.PHYSICAL, 100, 80, 1);
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
