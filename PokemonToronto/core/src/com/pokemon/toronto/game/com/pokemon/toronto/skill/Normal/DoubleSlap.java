package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.RegularDamageAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/13/2017.
 */

public class DoubleSlap extends DamageSkill {

    private int timesHit;

    /**
     * - Name: Double Slap
     * - Type: Normal
     * - Base Damage: 15
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 85
     * - Number of Hits: 2-5
     */
    public DoubleSlap() {
        super("Double Slap", 10, Pokemon.Type.NORMAL, SkillCategory.PHYSICAL, 85, 15, 1);
        makesPhysicalContact = true;
        isMultiStrikeMove = true;
        timesHit = 0;
    }


    /**
     * Damage the enemy 2-5 times.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param field The field of the battle.
     * @return The results of using the move.
     */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack) {
        List<String> results;
        //Use the damage part of the move.
        if (strikesLeft == -1) {

            double rand = Math.random();
            if (rand <= .375) {
                strikesLeft = 2;
            } else if (rand <= .75) {
                strikesLeft = 3;
            } else if (rand <= .875) {
                strikesLeft = 4;
            } else {
                strikesLeft = 5;
            }
        }
        timesHit++;
        strikesLeft--;
        results = super.use(skillUser, enemyPokemon, field, userField,
                enemyField, isFirstAttack);
        results.remove(0); //Remove old single damage result.
        results.add("Dealt " + damageTally + " damage!");
        results.add("Hit " + timesHit + " times!");

        if (strikesLeft == 0) {
            strikesLeft = -1;
            damageTally = 0;
            timesHit = 0;
        }

        //Prevent using additional slaps while the enemy is already dead.
        if (enemyPokemon.getCurrentHealth() == 0) {
            strikesLeft = -1;
            timesHit = 0; //Reset times hit
            damageTally = 0;
        }

        return results;
    }


    /**
     * Return Double Slap's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Quick Attack's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new RegularDamageAnimation(userAnimation);
    }
}
