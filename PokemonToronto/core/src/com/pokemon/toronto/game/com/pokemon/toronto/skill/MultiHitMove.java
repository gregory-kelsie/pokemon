package com.pokemon.toronto.game.com.pokemon.toronto.skill;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;

import java.util.List;

/**
 * Created by Gregory on 9/19/2017.
 */

public abstract class MultiHitMove extends DamageSkill {
    protected int timesHit;
    private int multiHitType;
    private final int STANDARD_FIVE = 0;
    private final int TWO_TIMES = 1;
    private final int TRIPLE_KICK = 2;

    public MultiHitMove(int id, String name, String description, int maxPP, Pokemon.Type type,
                        SkillCategory category, int accuracy, int damage, int crit, int multiHitType) {
        super(id, name, description, maxPP, type, category, accuracy, damage, crit);
        this.multiHitType = multiHitType;
        isMultiStrikeMove = true;
        timesHit = 0;
    }


    /**
     * Damage the enemy 2-5 times.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field of the battle.
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty    @return The results of using the move.
     * */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack, Skill targetSkill, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        List<String> results;
        //Use the damage part of the move.
        if (strikesLeft == -1) {
            setStrikesLeft(skillUser, enemyPokemon, field,
                    userField, enemyField, isFirstAttack);
        }
        timesHit++;

        strikesLeft--;
        results = super.use(skillUser, enemyPokemon, skillUserPartyPosition, enemyPokemonPartyPosition, field, userField,
                enemyField, isFirstAttack, targetSkill, skillUserParty, enemyPokemonParty);
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

    protected void setStrikesLeft(Pokemon skillUser, Pokemon enemyPokemon,
                                Field field, SubField userField, SubField enemyField, boolean isFirstAttack) {
        if (multiHitType == STANDARD_FIVE) {
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
        } else if (multiHitType == TWO_TIMES) {
            strikesLeft = 2;
        } else if (multiHitType == TRIPLE_KICK) {
            strikesLeft = 1;
            if (willHitEnemy(skillUser, enemyPokemon, field, userField,
                    enemyField, isFirstAttack)) {
                strikesLeft++;
                if (willHitEnemy(skillUser, enemyPokemon, field, userField,
                        enemyField, isFirstAttack)) {
                    strikesLeft++;
                }
            }
        }
    }
}
