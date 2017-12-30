package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.RegularDamageAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.MultiHitMove;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.List;

/**
 * Created by Gregory on 10/2/2017.
 */

public class TripleKick extends MultiHitMove {

    /**
     * - Name: Triple Kick
     * - Type: Fighting
     * - Base Damage: 10 - increases by 10 each strike
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 90
     * - Number of Hits: 1-3
     */
    public TripleKick() {
        super(SkillFactory.TRIPLE_KICK, "Triple Kick", SkillDescription.TRIPLE_KICK, 10,
                Pokemon.Type.FIGHTING, Skill.SkillCategory.PHYSICAL, 90, 10, 1, 2);
        makesPhysicalContact = true;
    }

    /**
     * Damage the enemy 1-3 times.
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
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        List<String> results;
        //Use the damage part of the move.
        if (strikesLeft == -1) {
            setStrikesLeft(skillUser, enemyPokemon, field,
                    userField, enemyField, isFirstAttack);
        }
        timesHit++;
        strikesLeft--;
        results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack, targetSkill,
                skillUserParty, enemyPokemonParty);
        damage += 10; //Increase Triple Kick's damage after each strike.
        results.remove(0); //Remove old single damage result.
        results.add("Dealt " + damageTally + " damage!");
        results.add("Hit " + timesHit + " times!");

        if (strikesLeft == 0) {
            strikesLeft = -1;
            damageTally = 0;
            timesHit = 0;
            damage = 10; // Reset Triple Kick's damage to normal
        }

        //Prevent using additional slaps while the enemy is already dead.
        if (enemyPokemon.getCurrentHealth() == 0) {
            strikesLeft = -1;
            timesHit = 0; //Reset times hit
            damageTally = 0;
            damage = 10; //Reset Triple Kick's damage to normal.
        }

        return results;
    }

    /**
     * Return Triple Kick's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Triple Kick's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new RegularDamageAnimation(userAnimation);
    }
}
