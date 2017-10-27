package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/25/2017.
 */

public class PsychUp extends Skill {
    /**
     * - Name: Psych Up
     * - Type: Normal
     * - PP: 10
     * - Cat: Misc
     * - Accuracy: N/A
     */
    public PsychUp() {
        super(SkillFactory.PSYCH_UP, "Psych Up", 10,
                Pokemon.Type.NORMAL, Skill.SkillCategory.MISC, -1);
    }

    /**
     * Use Psych Up and return the move results.
     * Sets the weather to Psych Up.
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
        List<String> results = new ArrayList<String>();
        skillUser.setAttackStage(enemyPokemon.getAttackStage());
        skillUser.setDefenseStage(enemyPokemon.getDefenseStage());
        skillUser.setSpAttackStage(enemyPokemon.getSpecialAttackStage());
        skillUser.setSpDefenseStage(enemyPokemon.getSpecialDefenseStage());
        skillUser.setSpeedStage(enemyPokemon.getSpeedStage());
        skillUser.setAccuracyStage(enemyPokemon.getAccuracyStage());
        skillUser.setEvasionStage(enemyPokemon.getEvasionStage());
        results.add(skillUser.getName() + " copied\n" + enemyPokemon.getName() +
                "'s stat changes!");
        return results;
    }

    /**
     * Return Psych Up's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Psych Up's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

}
