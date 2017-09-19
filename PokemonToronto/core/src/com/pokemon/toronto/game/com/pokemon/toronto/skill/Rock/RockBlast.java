package com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.RegularDamageAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.List;

/**
 * Created by Gregory on 9/18/2017.
 */

public class RockBlast extends DamageSkill {

    private int timesHit;

    /**
     * - Name: Rock Blast
     * - Type: Normal
     * - Base Damage: 15
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 85
     * - Number of Hits: 2-5
     */
    public RockBlast() {
        super(SkillFactory.ROCK_BLAST, "Rock Blast", 10, Pokemon.Type.ROCK, SkillCategory.PHYSICAL, 90, 25, 1);
        isMultiStrikeMove = true;
        timesHit = 0;
    }


    /**
     * Damage the enemy 2-5 times.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     *@param enemyPokemonPartyPosition
     * @param field The field of the battle.
     * @param skillUserParty
     * @param enemyPokemonParty    @return The results of using the move.
     */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
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
        results = super.use(skillUser, enemyPokemon, skillUserPartyPosition, enemyPokemonPartyPosition, field, userField,
                enemyField, isFirstAttack, skillUserParty, enemyPokemonParty);
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
     * Return Rock Blast's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Quick Attack's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new RegularDamageAnimation(userAnimation);
    }
}
