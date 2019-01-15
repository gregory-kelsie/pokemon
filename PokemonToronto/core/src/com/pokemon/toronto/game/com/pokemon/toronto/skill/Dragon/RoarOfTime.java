package com.pokemon.toronto.game.com.pokemon.toronto.skill.Dragon;

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
 * Created by gregorykelsie on 2018-08-15.
 */

public class RoarOfTime extends DamageSkill {
    /**
     * - Name: Roar of Time
     * - Type: Dragon
     * - Base Damage: 150
     * - PP: 5
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 90
     */
    public RoarOfTime() {
        super(SkillFactory.ROAR_OF_TIME, "Roar of Time", SkillDescription.ROAR_OF_TIME, 5,
                Pokemon.Type.DRAGON, SkillCategory.SPECIAL, 90, 150, 1);
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
     * @param enemyPokemonParty
     * @return The results of using the move.
     * */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {

        skillUser.initiateRecharge();
        return super.use(skillUser, enemyPokemon, skillUserPartyPosition, enemyPokemonPartyPosition,
                field, userField, enemyField, isFirstAttack, targetSkill, skillUserParty,
                enemyPokemonParty);
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
