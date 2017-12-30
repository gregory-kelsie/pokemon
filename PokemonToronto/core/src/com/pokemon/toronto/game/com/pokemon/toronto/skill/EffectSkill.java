package com.pokemon.toronto.game.com.pokemon.toronto.skill;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/31/2017.
 */

public abstract class EffectSkill extends Skill {
    protected List<SecondaryEffect> effects;
    public EffectSkill(int skillId, String name, String description, int maxPP, Pokemon.Type type,
                       int accuracy) {
        super(skillId, name, description, maxPP, type, SkillCategory.MISC, accuracy);
        effects = new ArrayList<SecondaryEffect>();
    }

    /**
     * Use the effects and return the move results
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
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack, Skill targetSkill, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        List<String> results = new ArrayList<String>();
        for (int i = 0; i < effects.size(); i++) {
            effects.get(i).use(results, skillUser, enemyPokemon, field, userField,
                    enemyField, isFirstAttack);
        }
        return results;
    }
}
