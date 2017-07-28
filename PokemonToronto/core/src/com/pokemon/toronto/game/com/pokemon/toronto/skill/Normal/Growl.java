package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/15/2017.
 */
public class Growl extends Skill {
    public Growl() {
        super("Growl", 40, Pokemon.Type.NORMAL, SkillCategory.MISC);
    }

    public List<List<String>> use(Pokemon skillUser, Pokemon enemyPokemon) {
        List<List<String>> fullList = new ArrayList<List<String>>();
        List<String> firstList = new ArrayList<String>();
        List<String> secondList = new ArrayList<String>();

        if (enemyPokemon.getAttackStage() == -6) {
            firstList.add(enemyPokemon.getName() + "'s attack can't be lowered.");
        } else {
            enemyPokemon.decreaseAttackStage(1);
            secondList.add(enemyPokemon.getName() + "'s attack was lowered.");
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
