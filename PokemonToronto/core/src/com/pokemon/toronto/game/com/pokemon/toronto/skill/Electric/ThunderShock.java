package com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ParalysisEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/15/2017.
 */
public class ThunderShock extends SecondaryEffectSkill {

    /**
     * - Name: Thunder Shock
     * - Type: Electric
     * - Base Damage: 40
     * - PP: 30
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public ThunderShock() {
        super(11, "Thunder Shock", SkillDescription.THUNDER_SHOCK,30, Pokemon.Type.ELECTRIC,
                SkillCategory.SPECIAL, 100, 40, 1, .15);
        secondaryEffects.add(new ParalysisEffect(SecondaryEffect.Target.ENEMY));
    }

    /**
     * Return Thunder Shock's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Thunder Shock's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

}
