package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fire;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.List;

/**
 * Created by Gregory on 8/14/2017.
 */

public class Ember extends DamageSkill {

    /**
     * - Name: Ember
     * - Type: Fire
     * - Base Damage: 40
     * - PP: 25
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Ember() {
        super(16, "Ember", 25, Pokemon.Type.FIRE, Skill.SkillCategory.SPECIAL, 100, 40, 1);
    }

    /**
     * Damage the enemy, but also has a 10% chance to burn the enemy.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param field The field of the battle.
     * @return The results of using the move.
     */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack) {
        //Use the damage part of the move.
        List<String> results = super.use(skillUser, enemyPokemon, field, userField, enemyField, isFirstAttack);

        //Check if the user is able to receive burn.
        if (!enemyPokemon.isStatused() && enemyPokemon.getCurrentHealth() != 0  &&
                enemyPokemon.getAbility() != Pokemon.Ability.SHIELD_DUST) {
            double rand = Math.random(); //Roll the burn die
            boolean burned = false;
            if (rand <= .1) { //10% chance
                burned = true;
            }
            if (burned) { //Inflict burned.
                enemyPokemon.setPreStatus(Pokemon.Status.BURN);
                results.add(enemyPokemon.getName() + " was burned.");
            }
        }
        return results;
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
