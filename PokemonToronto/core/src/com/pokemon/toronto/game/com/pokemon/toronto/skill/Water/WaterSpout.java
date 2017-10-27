package com.pokemon.toronto.game.com.pokemon.toronto.skill.Water;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.List;

/**
 * Created by Gregory on 9/18/2017.
 */

public class WaterSpout extends DamageSkill {
    /**
     * - Name: Water Spout
     * - Type: Water
     * - Base Damage: 150
     * - PP: 5
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public WaterSpout() {
        super(SkillFactory.WATER_SPOUT, "Water Spout", 5, Pokemon.Type.WATER, Skill.SkillCategory.SPECIAL, 100, 150, 1);
    }

    /**
     * Use Water Spout and return the move results.
     * Deal heavy damage to enemy, but kills self.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field the battle is on.
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty    @return Thunder Shock's move results.
     * */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack, Skill targetSkill, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        damage = (int)Math.round((1.0 * damage * skillUser.getCurrentHealth()) /
                skillUser.getHealthStat());
        List<String> results;

        results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                enemyPokemonPartyPosition, field, userField, enemyField,
                isFirstAttack, targetSkill, skillUserParty, enemyPokemonParty);
        damage = 150; //Set it back to 150 base power.
        return results;
    }

    /**
     * Return Water Spout's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Water Spout's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
