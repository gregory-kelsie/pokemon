package com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/13/2017.
 */

public class SleepPowder extends Skill {

    /**
     * - Name: Sleep Powder
     * - Type: Grass
     * - PP: 15
     * - Cat: Misc
     * - Accuracy: 75
     */
    public SleepPowder() {
        super("Sleep Powder", 15, Pokemon.Type.GRASS, SkillCategory.MISC, 75);
    }

    /**
     * Use Sleep Powder and return the move results
     * The user scatters a big cloud of sleep-inducing dust around the target.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param field The field the battle is on.
     * @return The move results.
     */
    public List<List<String>> use(Pokemon skillUser, Pokemon enemyPokemon, Field field, boolean isFirstAttack) {
        List<List<String>> fullList = new ArrayList<List<String>>();
        List<String> firstList = new ArrayList<String>();
        List<String> secondList = new ArrayList<String>();

        enemyPokemon.induceSleep();
        secondList.add(enemyPokemon.getName() + " fell asleep!");
        fullList.add(firstList);
        fullList.add(secondList);
        return fullList;
    }

    /**
     * Return Sleep Powder's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Sleep Powder's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public boolean willFail(Pokemon skillUser, Pokemon enemyPokemon, Field field, boolean isFirstAttacker) {
        if (enemyPokemon.isStatused()) {
            return true;
        }
        return false;
    }
}
