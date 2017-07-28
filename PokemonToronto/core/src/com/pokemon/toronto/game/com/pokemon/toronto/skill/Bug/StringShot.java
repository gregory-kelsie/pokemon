package com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug;

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
    public StringShot() {
        super("String Shot", 35, Pokemon.Type.BUG, SkillCategory.MISC);
    }

    public List<List<String>> use(Pokemon skillUser, Pokemon enemyPokemon) {
        List<List<String>> fullList = new ArrayList<List<String>>();
        List<String> firstList = new ArrayList<String>();
        List<String> secondList = new ArrayList<String>();

        if (enemyPokemon.getSpeedStage() == -6) {
            firstList.add(enemyPokemon.getName() + "'s speed can't be lowered.");
        } else {
            enemyPokemon.decreaseSpeedStage(1);
            secondList.add(enemyPokemon.getName() + "'s speed was lowered.");
        }
        fullList.add(firstList);
        fullList.add(secondList);
        return fullList;
    }
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
