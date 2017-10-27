package com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic;

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
 * Created by Gregory on 10/23/2017.
 */

public class TrickRoom extends Skill {
    /**
     * - Name: Trick Room
     * - Type: Psychic
     * - PP: 5
     * - Cat: Misc
     * - Accuracy: -1
     */
    public TrickRoom() {
        super(SkillFactory.TRICK_ROOM, "Trick Room", 5, Pokemon.Type.PSYCHIC,
                Skill.SkillCategory.MISC, -1);
        targetsEnemy = false;
    }

    /**
     * Use Trick Room and return the move results.
     * Sets the weather to Trick Room.
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
        results.add(skillUser.getName() + " twisted the dimensions!");
        field.setupTrickRoom();
        return results;
    }

    /**
     * Return Trick Room's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Trick Room's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                               SubField userField, SubField enemyField, boolean isFirstAttack,
                               Skill targetsSkill) {
        if (field.hasTrickRoom()) {
            return new FailResult("It failed...\nTrick Room is already set up!");
        }
        return new FailResult(false);
    }
}
