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

    /**
     * - Name: Poison Sting
     * - Type: Poison
     * - Base Damage: 15
     * - PP: 35
     * - Cat: Physical
     * - Crit Stage: 1
     */
    public PoisonSting() {
        super("Poison Sting", 35, Pokemon.Type.POISON, SkillCategory.PHYSICAL, 15, 1);
    }


    /**
     * Damage the enemy, but also has a 30% chance to poison the enemy.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @return The results of using the move.
     */
    public List<List<String>> use(Pokemon skillUser, Pokemon enemyPokemon) {
        //Use the damage part of the move.
        List<List<String>> fullList = super.use(skillUser, enemyPokemon);

        //Check if the user is able to receive poison.
        if (!enemyPokemon.isStatused() && enemyPokemon.getCurrentHealth() != 0) {
            double rand = Math.random(); //Roll the poison die
            boolean poisoned = false;
            if (rand <= 1) { //30% chance
                poisoned = true;
            }
            if (poisoned) { //Inflict poison.
                enemyPokemon.setPreStatus(Pokemon.Status.POISON);
                fullList.get(1).add(enemyPokemon.getName() + " was poisoned.");
            }
        }
        return fullList;
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
