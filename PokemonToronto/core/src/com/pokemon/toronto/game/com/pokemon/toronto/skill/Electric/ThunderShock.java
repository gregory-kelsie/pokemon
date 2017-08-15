package com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
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
public class ThunderShock extends DamageSkill {

    /**
     * - Name: Thunder Shock
     * - Type: Electric
     * - Base Damage: 40
     * - PP: 30
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public ThunderShock() {
        super("Thunder Shock", 30, Pokemon.Type.ELECTRIC, SkillCategory.SPECIAL, 100, 40, 1);
    }


    /**
     * Use Thunder Shock and return the move results.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param field The field the battle is on.
     * @return Thunder Shock's move results.
     */
    public List<List<String>> use(Pokemon skillUser, Pokemon enemyPokemon, Field field, boolean isFirstAttack) {
        List<List<String>> fullList = new ArrayList<List<String>>();
        List<String> firstList = new ArrayList<String>();
        List<String> secondList = new ArrayList<String>();
        if (enemyPokemon.getAbility() == Pokemon.Ability.LIGHTNINGROD) {
            fullList.add(firstList);
            fullList.add(secondList);
            fullList.get(1).add(skillUser.getName() + " takes no damage\ndue to their ability Lightning Rod");
            fullList.get(1).add(skillUser.getName() + "'s Special Attack rose!");

        } else {
            //Use the damage part of Thunder Shock.
            fullList = super.use(skillUser, enemyPokemon, field, isFirstAttack);

            //Check if the enemy is able to receive paralysis after the damage
            if (!enemyPokemon.isStatused() && enemyPokemon.getCurrentHealth() != 0 &&
                    enemyPokemon.getAbility() != Pokemon.Ability.SHIELD_DUST) {
                double rand = Math.random(); //Roll the paralysis die
                boolean paralyzed = false;
                if (rand <= .15) { //15% chance to paralyze.
                    paralyzed = true;
                }
                if (paralyzed) { //Enemy was paralyzed.
                    enemyPokemon.setPreStatus(Pokemon.Status.PARALYSIS);
                    fullList.get(1).add(enemyPokemon.getName() + " was paralyzed.");
                }
            }
        }
        return fullList;
    }

    /**
     * Return Thunder Shock's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Thunder Shock's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

}
