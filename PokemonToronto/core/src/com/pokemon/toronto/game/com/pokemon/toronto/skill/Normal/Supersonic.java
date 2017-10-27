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
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ConfusionEffect;

/**
 * Created by Gregory on 10/26/2017.
 */

public class Supersonic extends EffectSkill {
    /**
     * - Name: Supersonic
     * - Type: Normal
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: 55
     */
    public Supersonic() {
        super(SkillFactory.SUPERSONIC, "Supersonic", 20, Pokemon.Type.NORMAL, 55);
        effects.add(new ConfusionEffect(SecondaryEffect.Target.ENEMY));
    }

    /**
     * Return Supersonic's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Supersonic's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon,
                               Field field, SubField userField, SubField enemyField,
                               boolean isFirstAttack, Skill targetsSkill) {
        if (enemyPokemon.isConfused()){
            return new FailResult(enemyPokemon.getName() + " is already confused.");
        } else if (enemyPokemon.getBattleAbility() == Pokemon.Ability.OWN_TEMPO) {
            return new FailResult(enemyPokemon.getName() + " cannot be confused\n" +
                    "because it has it's Own Tempo");
        }
        return new FailResult(false);
    }
}
