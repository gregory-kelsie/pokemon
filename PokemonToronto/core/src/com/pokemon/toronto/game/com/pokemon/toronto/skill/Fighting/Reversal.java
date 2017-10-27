package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting;

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
 * Created by Gregory on 10/2/2017.
 */

public class Reversal extends DamageSkill {
    /**
     * - Name: Reversal
     * - Type: Fighting
     * - Base Damage: 1 - Damage based on the user's health
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Reversal() {
        super(SkillFactory.REVERSAL, "Reversal", 15, Pokemon.Type.FIGHTING, Skill.SkillCategory.PHYSICAL, 100, 1, 1);
        makesPhysicalContact = true;
        setPriority(-4);
    }

    /**
     * Damage the enemy then recharge the next turn.
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

        List<String> results = new ArrayList<String>();
        double healthPercent = ((skillUser.getCurrentHealth() * 1.0) / skillUser.getHealthStat()) * 100;
        if (healthPercent >= 68.75) {
            damage = 20;
        } else if (healthPercent < 68.75 && healthPercent >= 35.42) {
            damage = 40;
        } else if (healthPercent < 35.42 && healthPercent >= 20.83) {
            damage = 80;
        } else if (healthPercent < 20.83 && healthPercent >= 10.42) {
            damage = 100;
        } else if (healthPercent < 10.42 && healthPercent >= 4.17) {
            damage = 120;
        } else {
            damage = 200;
        }
        results = super.use(skillUser, enemyPokemon, skillUserPartyPosition, enemyPokemonPartyPosition, field,
                userField, enemyField, isFirstAttack, targetSkill, skillUserParty, enemyPokemonParty);
        damage = 1; //Reset to the normal amount.
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
