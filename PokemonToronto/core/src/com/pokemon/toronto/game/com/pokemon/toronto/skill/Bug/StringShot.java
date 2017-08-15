package com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/15/2017.
 */
public class StringShot extends Skill {

    /**
     * - Name: String Shot
     * - Type: Bug
     * - PP: 35
     * - Cat: Misc
     * - Accuracy: 95
     */
    public StringShot() {
        super("String Shot", 35, Pokemon.Type.BUG, SkillCategory.MISC, 95);
    }

    /**
     * Use String Shot and return the move results.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param field The field the battle is on.
     * @return String Shot's move results.
     */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, Field field, boolean isFirstAttack) {
        List<String> results = new ArrayList<String>();

        //Attempt to lower the enemy's speed by 1 stage.
        if (enemyPokemon.getSpeedStage() == -6) {
            results.add(enemyPokemon.getName() + "'s speed can't be lowered.");
        } else {
            enemyPokemon.decreaseSpeedStage(1);
            results.add(enemyPokemon.getName() + "'s speed fell!");
        }
        return results;
    }

    /**
     * Return String Shot's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return String Shot's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
