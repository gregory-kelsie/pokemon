package com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 9/1/2017.
 */

public class Ingrain extends Skill {
    /**
     * - Name: Ingrain
     * - Type: Grass
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: 100
     */
    public Ingrain() {
        super(33, "Ingrain", 20, Pokemon.Type.GRASS, Skill.SkillCategory.MISC, 100);
    }

    /**
     * Set up Ingrain.
     * - Pokemon becomes grounded
     * - Pokemon recovers 1/16 max hp per turn.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     *@param enemyPokemonPartyPosition
     * @param field The field of the battle.
     * @param skillUserParty
     * @param enemyPokemonParty    @return Ingrain's move results.
     */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        List<String> results = new ArrayList<String>();
        skillUser.receiveIngrain();
        results.add(skillUser.getName() + " planted its roots!");
        return results;
    }

    /**
     * Return Ingrain's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Ingrain's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon,
                               Field field, SubField userField, SubField enemyField,
                               boolean isFirstAttack) {
        if (skillUser.isIngrained()) {
            return new FailResult("It failed...");
        }
        return new FailResult(false);
    }
}
