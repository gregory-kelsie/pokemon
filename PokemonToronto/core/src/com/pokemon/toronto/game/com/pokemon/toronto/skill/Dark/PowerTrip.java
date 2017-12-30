package com.pokemon.toronto.game.com.pokemon.toronto.skill.Dark;

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
 * Created by Gregory on 10/21/2017.
 */

public class PowerTrip extends DamageSkill {
    /**
     * - Name: Power Trip
     * - Type: Dark
     * - Base Damage: 20
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public PowerTrip() {
        super(SkillFactory.POWER_TRIP, "Power Trip", SkillDescription.POWER_TRIP, 10,
                Pokemon.Type.DARK, Skill.SkillCategory.PHYSICAL, 100, 20, 1);
        makesPhysicalContact = true;
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
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {

        int powerTripBonus = 0;
        //Use Math.max so negative stat changes or 0 do not detriment Power Trip.
        powerTripBonus += Math.max(0, skillUser.getAttackStage() * damage);
        powerTripBonus += Math.max(0, skillUser.getDefenseStage() * damage);
        powerTripBonus += Math.max(0, skillUser.getSpecialAttackStage() * damage);
        powerTripBonus += Math.max(0, skillUser.getSpecialDefenseStage() * damage);
        powerTripBonus += Math.max(0, skillUser.getSpeedStage() * damage);
        powerTripBonus += Math.max(0, skillUser.getAccuracyStage() * damage);
        powerTripBonus += Math.max(0, skillUser.getEvasionStage() * damage);
        //Add the Power Trip bonus to the base damage.
        damage += powerTripBonus;
        List<String> results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack, targetSkill,
                skillUserParty, enemyPokemonParty);
        damage = 20; //Reset damage back to normal.
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
