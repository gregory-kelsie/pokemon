package com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/15/2017.
 */

public class StealthRock extends Skill {
    /**
     * - Name: Stealth Rock
     * - Type: Rock
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: 100
     */
    public StealthRock() {
        super("Stealth Rock", 20, Pokemon.Type.ROCK, SkillCategory.MISC, 100);
    }

    /**
     * Set up stealth rocks on the opponent's field.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param field The field of the battle.
     * @return Stealth Rock's move results.
     */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack) {
        List<String> results = new ArrayList<String>();
        enemyField.addStealthRocks();
        results.add(skillUser.getName() + " set up Stealth Rocks!");
        return results;
    }

    /**
     * Return Stealth Rock's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Stealth Rock's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon,
                               Field field, SubField userField, SubField enemyField,
                               boolean isFirstAttack) {
        if (enemyField.hasStealthRocks()) {
            return new FailResult("It failed...");
        }
        return new FailResult(false);
    }
}
