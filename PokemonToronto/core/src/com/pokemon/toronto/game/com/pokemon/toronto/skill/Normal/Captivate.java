package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialAttackEffect;

/**
 * Created by Gregory on 10/25/2017.
 */

public class Captivate extends EffectSkill {
    /**
     * - Name: Captivate
     * - Type: Normal
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: 100
     * - Lower enemy defense by 1 stage.
     */
    public Captivate() {
        super(SkillFactory.CAPTIVATE, "Captivate", SkillDescription.CAPTIVATE, 20,
                Pokemon.Type.NORMAL, 100);
        effects.add(new SpecialAttackEffect(SecondaryEffect.Target.ENEMY, 2,
                SecondaryEffect.StatDirection.DECREASE));
    }


    /**
     * todo: Implement it to only work on opposite genders when gender is implemented.
     * @param skillUser The skill's user.
     * @param enemyPokemon The Pokemon on the receiving end.
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @param isFirstAttack Whether or not the skill was used first in the clash
     * @param targetsSkill
     * @return
     */
    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon,
                               Field field, SubField userField, SubField enemyField,
                               boolean isFirstAttack, Skill targetsSkill) {
        return new FailResult(false);
    }

    /**
     * Return Captivate's move animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Captivate's move animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
