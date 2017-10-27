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
 * Created by Gregory on 10/25/2017.
 */

public class Present extends DamageSkill {

    /**
     * - Name: Present
     * - Type: Normal
     * - Base Damage: 1
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 90
     */
    public Present() {
        super(SkillFactory.PRESENT, "Present", 15, Pokemon.Type.NORMAL,
                Skill.SkillCategory.PHYSICAL, 90, 1, 1);
    }
    /**
     * Damage the enemy or heal them randomly.
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

        double rand = Math.random();
        if (rand <= .4) {
            damage = 40;
        } else if (rand <= .7) {
            damage = 80;
        } else if (rand <= .8) {
            damage = 120;
        }
        if (damage < 40) {
            List<String> results = new ArrayList<String>();
            if (enemyPokemon.hasFullHealth()) {
                results.add("It failed...");
            } else {
                int healAmount = (int) Math.round(enemyPokemon.getHealthStat() / 4.0);
                enemyPokemon.addHealth(healAmount);
                results.add(enemyPokemon.getName() + " regained health!");
            }
            return results;
        } else {
            List<String> results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                    enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                    targetSkill, skillUserParty,
                    enemyPokemonParty);
            damage = 1; //Reset damage.
            return results;
        }
    }
    /**
     * Return Present's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Present's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
