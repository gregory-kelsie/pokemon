package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/26/2017.
 */

public class SmellingSalts extends DamageSkill {

    /**
     * - Name: Smelling Salts
     * - Type: Normal
     * - Base Damage: 70
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public SmellingSalts() {
        super(SkillFactory.SMELLING_SALTS, "Smelling Salts", 10, Pokemon.Type.NORMAL,
                Skill.SkillCategory.PHYSICAL, 100, 70, 1);
        makesPhysicalContact = true;
    }

    /**
     * Use the effects and return the move results
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty      @return The move results.
     * */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        if (enemyPokemon.isParalyzed()) {
            damage = 140;
            List<String> results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                    enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                    targetSkill, skillUserParty, enemyPokemonParty);
            enemyPokemon.wakeUp(); //Cure paralysis.
            results.add(0, enemyPokemon.getName() + " was cured of paralysis!");
            damage = 70; //Return to normal.
            return results;
        } else {
            return super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                    enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                    targetSkill, skillUserParty, enemyPokemonParty);
        }
    }

    /**
     * Return Smelling Salts's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Smelling Salts's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
