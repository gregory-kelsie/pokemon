package com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialAttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpeedEffect;

/**
 * Created by Gregory on 10/19/2017.
 */

public class SilverWind extends SecondaryEffectSkill {
    /**
     * - Name: Silver Wind
     * - Type: Bug
     * - Base Damage: 60
     * - PP: 5
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public SilverWind() {
        super(SkillFactory.SILVER_WIND, "Silver Wind", SkillDescription.silverWind, 5,
                Pokemon.Type.BUG, Skill.SkillCategory.SPECIAL, 100, 60, 1, .1);
        secondaryEffects.add(new AttackEffect(SecondaryEffect.Target.SELF, 1, SecondaryEffect.StatDirection.INCREASE));
        secondaryEffects.add(new DefenseEffect(SecondaryEffect.Target.SELF, 1, SecondaryEffect.StatDirection.INCREASE));
        secondaryEffects.add(new SpecialAttackEffect(SecondaryEffect.Target.SELF, 1, SecondaryEffect.StatDirection.INCREASE));
        secondaryEffects.add(new SpecialDefenseEffect(SecondaryEffect.Target.SELF, 1, SecondaryEffect.StatDirection.INCREASE));
        secondaryEffects.add(new SpeedEffect(SecondaryEffect.Target.SELF, 1, SecondaryEffect.StatDirection.INCREASE));
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
