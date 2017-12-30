package com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 9/1/2017.
 */

public class FutureSight extends Skill {
    /**
     * - Name: Future Sight
     * - Type: Psychic
     * - Damage: 120 when it hits.
     * - PP: 10
     * - Cat: Special
     * - Accuracy: 100
     */
    public FutureSight() {
        super(29, "Future Sight", SkillDescription.FUTURE_SIGHT, 10, Pokemon.Type.PSYCHIC,
                SkillCategory.MISC, 100);
    }

    /**
     * Set up Future Sight on the opponent.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field of the battle.
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty    @return Stealth Rock's move results.
     * */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        List<String> results = new ArrayList<String>();
        enemyPokemon.receiveFutureSight(skillUser);
        results.add(skillUser.getName() + " foresaw\nan attack!");
        return results;
    }

    /**
     * Return Future Sight's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Future Sight's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon,
                               Field field, SubField userField, SubField enemyField,
                               boolean isFirstAttack, Skill targetsSkill) {
        if (enemyPokemon.witnessedFutureSight() || enemyPokemon.witnessedDoomDesire()) {
            return new FailResult("It failed...");
        }
        return new FailResult(false);
    }
}
