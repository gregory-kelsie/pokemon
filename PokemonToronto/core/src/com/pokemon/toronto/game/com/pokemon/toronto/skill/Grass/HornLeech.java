package com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/19/2017.
 */

public class HornLeech extends DamageSkill {
    /**
     * - Name: Horn Leech
     * - Type: Grass
     * - Base Damage: 75
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     * - 4 = Gain Half
     */
    public HornLeech() {
        super(SkillFactory.HORN_LEECH, "Horn Leech", SkillDescription.HORN_LEECH, 10,
                Pokemon.Type.GRASS, SkillCategory.PHYSICAL, 100, 75, 1, 4);
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
