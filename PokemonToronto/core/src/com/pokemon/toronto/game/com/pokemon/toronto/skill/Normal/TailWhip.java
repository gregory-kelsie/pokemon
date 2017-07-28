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
public class TailWhip extends Skill {
    public TailWhip() {
        super("Tail Whip", 30, Pokemon.Type.NORMAL, SkillCategory.PHYSICAL);
    }
    public SkillAnimation getUserAnimation() {
        return new TackleAnimation(true);
    }

    public List<List<String>> use(Pokemon skillUser, Pokemon enemyPokemon) {
        List<List<String>> fullList = new ArrayList<List<String>>();
        List<String> firstList = new ArrayList<String>();
        List<String> secondList = new ArrayList<String>();

        if (enemyPokemon.getDefenseStage() == -6) {
            firstList.add(enemyPokemon.getName() + "'s defense can't be lowered.");
        } else {
            enemyPokemon.decreaseDefenseStage(1);
            secondList.add(enemyPokemon.getName() + "'s defense was lowered.");
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
