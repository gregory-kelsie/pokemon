package com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug;

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
 * Created by Gregory on 10/12/2017.
 */

public class Infestation extends DamageSkill {
    /**
     * - Name: Infestation
     * - Type: Bug
     * - Base Damage: 20
     * - PP: 20
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Infestation() {
        super(SkillFactory.INFESTATION, "Infestation", 20, Pokemon.Type.BUG, Skill.SkillCategory.SPECIAL, 100, 20, 1);
    }

    /**
     * Damage enemy and then Infestation them.
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
     */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack, Skill targetSkill, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {

        List<String> results;
        results = super.use(skillUser, enemyPokemon, skillUserPartyPosition, enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack, targetSkill, skillUserParty, enemyPokemonParty);
        if (!enemyPokemon.isInfested()) {
            enemyPokemon.trapInInfestation();
            results.add(enemyPokemon.getName() + " became trapped\nin the vortex!");
        }

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
