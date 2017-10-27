package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/26/2017.
 */

public class SpitUp extends DamageSkill {

    /**
     * - Name: Spit Up
     * - Type: Normal
     * - Base Damage: 1
     * - PP: 10
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public SpitUp() {
        super(SkillFactory.SPIT_UP, "Spit Up", 10, Pokemon.Type.NORMAL,
                SkillCategory.SPECIAL, 100, 1, 1);
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

        if (skillUser.getStockpileStacks() == 1) {
            damage = 100;
        } else if (skillUser.getStockpileStacks() == 2) {
            damage = 200;
        } else if (skillUser.getStockpileStacks() == 3) {
            damage = 300;
        }
        List<String> results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                targetSkill, skillUserParty, enemyPokemonParty);
        damage = 1; //Reset damage.
        return results;
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                               SubField userField, SubField enemyField, boolean isFirstAttack, Skill targetsSkill) {
        if (skillUser.hasStockpileStacks()) {
            return new FailResult(false);
        }
        return new FailResult("It failed...");
    }

    /**
     * Return Spit Up's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Spit Up's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
