package com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.List;

/**
 * Created by Gregory on 6/15/2017.
 */
public class ThunderShock extends DamageSkill {
    public ThunderShock() {
        super("Thunder Shock", 30, Pokemon.Type.ELECTRIC, SkillCategory.SPECIAL, 40, 1);
    }


    public List<List<String>> use(Pokemon skillUser, Pokemon enemyPokemon) {
        List<List<String>> fullList = super.use(skillUser, enemyPokemon);

        if (!enemyPokemon.isStatused() && enemyPokemon.getCurrentHealth() != 0) {
            double rand = Math.random();
            boolean paralyzed = false;
            if (rand <= 0.1) {
                paralyzed = true;
            }
            if (paralyzed) {
                enemyPokemon.setPreStatus(Pokemon.Status.PARALYSIS);
                fullList.get(1).add(enemyPokemon.getName() + " was paralyzed.");
            }
        }
        return fullList;
    }
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

}
