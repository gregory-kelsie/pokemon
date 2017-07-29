package com.pokemon.toronto.game.com.pokemon.toronto.skill.Poison;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/15/2017.
 */
public class PoisonSting extends DamageSkill {
    public PoisonSting() {
        super("Poison Sting", 35, Pokemon.Type.POISON, SkillCategory.PHYSICAL, 15, 1);
    }

    public List<List<String>> use(Pokemon skillUser, Pokemon enemyPokemon) {
        List<List<String>> fullList = super.use(skillUser, enemyPokemon);

        if (!enemyPokemon.isStatused() && enemyPokemon.getCurrentHealth() != 0) {
            double rand = Math.random();
            boolean poisoned = false;
            if (rand <= 0.3) {
                poisoned = true;
            }
            if (poisoned) {
                enemyPokemon.setPreStatus(Pokemon.Status.POISON);
                fullList.get(1).add(enemyPokemon.getName() + " was poisoned.");
            }
        }
        return fullList;
    }
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
