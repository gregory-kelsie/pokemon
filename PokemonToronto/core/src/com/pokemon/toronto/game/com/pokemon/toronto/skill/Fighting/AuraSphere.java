package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/1/2017.
 */

public class AuraSphere extends DamageSkill {
    /**
     * - Name: Aura Sphere
     * - Type: Fighting
     * - Base Damage: 80
     * - PP: 20
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: -1 (Never misses)
     */
    public AuraSphere() {
        super(SkillFactory.AURA_SPHERE, "Aura Sphere", SkillDescription.AURA_SPHERE, 20,
                Pokemon.Type.FIGHTING, Skill.SkillCategory.SPECIAL, 100, 80, -1);
    }

    /**
     * Return Aqua Tail's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Aqua Tail's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
