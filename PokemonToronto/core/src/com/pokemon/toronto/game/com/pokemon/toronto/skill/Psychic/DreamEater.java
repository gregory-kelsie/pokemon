package com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 10/23/2017.
 */

public class DreamEater extends DamageSkill {
    /**
     * - Name: Dream Eater
     * - Type: Psychic
     * - Base Damage: 100
     * - PP: 15
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     * - 4 = Gain Half
     */
    public DreamEater() {
        super(SkillFactory.DREAM_EATER, "Dream Eater", 15, Pokemon.Type.PSYCHIC,
                Skill.SkillCategory.SPECIAL, 100, 100, 1, 4);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                               SubField userField, SubField enemyField, boolean isFirstAttack, Skill targetsSkill) {
        if (!enemyPokemon.isSleeping()) {
            return new FailResult(skillUser.getName() + " is not asleep!");
        }
        return new FailResult(false);
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
