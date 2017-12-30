package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost;

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
 * Created by Gregory on 9/4/2017.
 */

public class Nightmare extends Skill {
    /**
     * - Name: Nightmare
     * - Type: Ghost
     * - PP: 15
     * - Cat: Misc
     * - Accuracy: 100
     */
    public Nightmare() {
        super(36, "Nightmare", SkillDescription.NIGHTMARE,15, Pokemon.Type.GHOST,
                SkillCategory.MISC, 100);
    }

    /**
     * Give the enemy pokemon Nightmares.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field of the battle.
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty    @return Nightmare's move results.
     * */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        List<String> results = new ArrayList<String>();
        enemyPokemon.receiveNightmare();
        results.add(enemyPokemon.getName() + " began\nhaving nightmares!");
        return results;
    }

    /**
     * Return Nightmare's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Nightmare's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon,
                               Field field, SubField userField, SubField enemyField,
                               boolean isFirstAttack, Skill targetsSkill) {
        if (enemyPokemon.getStatus() != Pokemon.Status.SLEEP ||
                enemyPokemon.hasNightmares()) {
            return new FailResult("It failed...");
        }
        return new FailResult(false);
    }
}
