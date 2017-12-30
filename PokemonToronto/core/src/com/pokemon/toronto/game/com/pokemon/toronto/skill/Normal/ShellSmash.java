package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialAttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpeedEffect;

/**
 * Created by Gregory on 10/25/2017.
 */

public class ShellSmash extends EffectSkill {
    /**
     * - Name: Shell Smash
     * - Type: Normal
     * - PP: 15
     * - Cat: Misc
     * - Crit Stage: 1
     * - Accuracy: 100
     * - Lower def and sp def by 1 stage but sharply raise atk special atk and speed.
     */
    public ShellSmash() {
        super(SkillFactory.SHELL_SMASH, "Shell Smash", SkillDescription.SHELL_SMASH, 15,
                Pokemon.Type.NORMAL, -1);
        effects.add(new DefenseEffect(SecondaryEffect.Target.SELF, 1,
                SecondaryEffect.StatDirection.DECREASE));
        effects.add(new SpecialDefenseEffect(SecondaryEffect.Target.SELF, 1,
                SecondaryEffect.StatDirection.DECREASE));
        effects.add(new AttackEffect(SecondaryEffect.Target.SELF, 2,
                SecondaryEffect.StatDirection.INCREASE));
        effects.add(new SpecialAttackEffect(SecondaryEffect.Target.SELF, 2,
                SecondaryEffect.StatDirection.INCREASE));
        effects.add(new SpeedEffect(SecondaryEffect.Target.SELF, 2,
                SecondaryEffect.StatDirection.INCREASE));
        targetsEnemy = false;
    }

    /**
     * Return Shell Smash's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Shell Smash's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
