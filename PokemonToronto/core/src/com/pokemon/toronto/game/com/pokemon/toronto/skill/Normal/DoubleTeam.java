package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.EvasionEffect;

/**
 * Created by Gregory on 10/25/2017.
 */

public class DoubleTeam extends EffectSkill {
    /**
     * - Name: Double Team
     * - Type: Normal
     * - PP: 15
     * - Cat: Misc
     * - Accuracy: N/A
     * - Increase EVASION by 1 stage
     */
    public DoubleTeam() {
        super(SkillFactory.DOUBLE_TEAM, "Double Team", 15, Pokemon.Type.NORMAL, -1);
        effects.add(new EvasionEffect(SecondaryEffect.Target.SELF, 1,
                SecondaryEffect.StatDirection.INCREASE));
        targetsEnemy = false;
    }

    /**
     * Return Double Team's move animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Double Team's move animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
