package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ground;

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
 * Created by Gregory on 10/22/2017.
 */

public class Dig extends DamageSkill {
    /**
     * - Name: Dig
     * - Type: Ground
     * - Base Damage: 80
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Dig() {
        super(SkillFactory.DIG, "Dig", 10, Pokemon.Type.GROUND, Skill.SkillCategory.PHYSICAL, 100, 80, 1);
        makesPhysicalContact = true;
    }

    /**
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty      @return The results of using the move.
     * */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack, Skill targetSkill, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {

        //Use the damage part of the move.
        if (!skillUser.isUnderground()) {
            skillUser.dig();
            skillUser.setNextTurnSkill(this);
            List<String> results = new ArrayList<String>();
            results.add(skillUser.getName() + " went\nunderground!");
            return results;
        } else {
            skillUser.finishDig();
            return super.use(skillUser, enemyPokemon, skillUserPartyPosition, enemyPokemonPartyPosition, field,
                    userField, enemyField, isFirstAttack, targetSkill, skillUserParty, enemyPokemonParty);
        }
    }

    @Override
    public boolean targetsEnemy(Pokemon skillUser, Field field) {
        if (skillUser.isUnderground()) {
            return true;
        } else {
            return false;
        }
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
