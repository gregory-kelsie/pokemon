package com.pokemon.toronto.game.com.pokemon.toronto.skill.Poison;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AccuracyEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialAttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpeedEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/22/2017.
 */

public class VenomDrench extends EffectSkill {
    /**
     * - Name: Venom Drench
     * - Type: Poison
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: 100
     * - Increase atk def and accuracy by one stages.
     */
    public VenomDrench() {
        super(SkillFactory.VENOM_DRENCH, "Venom Drench", SkillDescription.VENOM_DRENCH, 20,
                Pokemon.Type.POISON, 100);
        effects.add(new AttackEffect(SecondaryEffect.Target.ENEMY,
                1, SecondaryEffect.StatDirection.DECREASE));
        effects.add(new SpecialAttackEffect(SecondaryEffect.Target.ENEMY,
                1, SecondaryEffect.StatDirection.DECREASE));
        effects.add(new SpeedEffect(SecondaryEffect.Target.ENEMY,
                1, SecondaryEffect.StatDirection.DECREASE));
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                               SubField userField, SubField enemyField, boolean isFirstAttack,
                               Skill targetsSkill) {
        if (!enemyPokemon.isPoisoned()) {
            return new FailResult("It failed...");
        }
        return new FailResult(false);
    }

    /**
     * Return Venom Drench's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Venom Drench's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
