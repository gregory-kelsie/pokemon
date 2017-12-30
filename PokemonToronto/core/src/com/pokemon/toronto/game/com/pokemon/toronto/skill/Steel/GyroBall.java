package com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.RegularDamageAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.List;

/**
 * Created by Gregory on 9/19/2017.
 */

public class GyroBall extends DamageSkill {
    /**
     * - Name: Gyro Ball
     * - Type: Steel
     * - Base Damage: 25 * (target speed / user speed)
     * - PP: 5
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public GyroBall() {
        super(SkillFactory.GYRO_BALL, "Gyro Ball", SkillDescription.GYRO_BALL, 5,
                Pokemon.Type.STEEL, SkillCategory.PHYSICAL, 100, 1, 1);
        makesPhysicalContact = true;

    }

    /**
     * Damage the enemy based on speed.
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

        damage = (int)(25 * (enemyPokemon.getTotalSpeed(field, enemyField) /
                skillUser.getTotalSpeed(field, enemyField)));

        results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                targetSkill, skillUserParty, enemyPokemonParty);
        damage = 1; //Reset power back to normal.
        return results;
    }

    /**
     * Return Gyro Ball's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Quick Attack's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new RegularDamageAnimation(userAnimation);
    }
}
