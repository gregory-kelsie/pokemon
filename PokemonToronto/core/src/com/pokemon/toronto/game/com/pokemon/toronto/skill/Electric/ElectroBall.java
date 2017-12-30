package com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.List;

/**
 * Created by Gregory on 10/22/2017.
 */

public class ElectroBall extends DamageSkill {
    /**
     * - Name: Electro Ball
     * - Type: Electric
     * - Base Damage: Damage based on target's speed.
     * - PP: 10
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public ElectroBall() {
        super(SkillFactory.ELECTRO_BALL, "Electro Ball", SkillDescription.ELECTRO_BALL, 5,
                Pokemon.Type.ELECTRIC, Skill.SkillCategory.SPECIAL, 100, 1, 1);
    }

    /**
     * Increase damage based on each stat stage increase.
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
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack,
                            Skill targetSkill, List<Pokemon> skillUserParty,
                            List<Pokemon> enemyPokemonParty) {

        if (enemyPokemon.getTotalSpeed(field, enemyField) > 0.5 *
                skillUser.getTotalSpeed(field, userField)) {
            damage = 60;
        } else if (enemyPokemon.getTotalSpeed(field, enemyField) > 0.33 *
                skillUser.getTotalSpeed(field, userField)) {
            damage = 80;
        } else if (enemyPokemon.getTotalSpeed(field, enemyField) > 0.25 *
                skillUser.getTotalSpeed(field, userField)) {
            damage = 120;
        } else {
            damage = 150;
        }
        List<String> results = super.use(skillUser, enemyPokemon,
                skillUserPartyPosition, enemyPokemonPartyPosition, field,
                userField, enemyField, isFirstAttack, targetSkill, skillUserParty,
                enemyPokemonParty);
        damage = 1; //Reset damage back to normal.
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
