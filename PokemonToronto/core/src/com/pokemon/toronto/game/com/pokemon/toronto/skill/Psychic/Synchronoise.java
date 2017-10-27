package com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ConfusionEffect;

/**
 * Created by Gregory on 10/23/2017.
 */

public class Synchronoise extends DamageSkill {
    /**
     * - Name: Synchronoise
     * - Type: Psychic
     * - Base Damage: 120
     * - PP: 10
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Synchronoise() {
        super(SkillFactory.SYNCHRONOISE, "Synchronoise", 10, Pokemon.Type.PSYCHIC,
                SkillCategory.SPECIAL, 100, 120, 1);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                               SubField userField, SubField enemyField, boolean isFirstAttack,
                               Skill targetsSkill) {
        //Fail when the target doesn't share a same type as the user.
        if (skillUser.getTypeOne() != Pokemon.Type.NONE) {
            if (skillUser.getTypeOne() == enemyPokemon.getTypeOne() ||
                    ((skillUser.getTypeOne() == enemyPokemon.getTypeTwo()) &&
                            enemyPokemon.getTypeTwo() != Pokemon.Type.NONE)) {
                return new FailResult(false);
            }
        }
        else if (skillUser.getTypeTwo() != Pokemon.Type.NONE) {
            if (skillUser.getTypeTwo() == enemyPokemon.getTypeOne() ||
                    skillUser.getTypeTwo() == enemyPokemon.getTypeTwo()) {
                return new FailResult(false);
            }
        }
        return new FailResult("It failed...");

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
