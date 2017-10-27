package com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying;

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
 * Created by Gregory on 9/20/2017.
 */

public class Roost extends Skill {
    /**
     * - Name: Roost
     * - Type: Flying
     * - PP: 10
     * - Cat: Misc
     * - Accuracy: 100
     */
    public Roost() {
        super(SkillFactory.ROOST, "Roost", 5, Pokemon.Type.FLYING, Skill.SkillCategory.MISC, 100);
        targetsEnemy = false;
    }

    /**
     * Use Roost and return the move results.
     * Sets the weather to Roost.
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
        skillUser.addHealth((int)Math.round(skillUser.getHealthStat() * 0.5));
        results.add(skillUser.getName() + " regained health!");
        return results;
    }

    /**
     * Return Roost's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Roost's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                               SubField userField, SubField enemyField, boolean isFirstAttack, Skill targetsSkill) {
        if (skillUser.hasFullHealth()) {
            return new FailResult(skillUser.getName() + " is full health!");
        }
        return new FailResult(false);
    }
}
