package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
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

public class PainSplit extends Skill {
    /**
     * - Name: Pain Split
     * - Type: Normal
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: N/A
     */
    public PainSplit() {
        super(SkillFactory.PAIN_SPLIT, "Pain Split", 20,
                Pokemon.Type.NORMAL, Skill.SkillCategory.MISC, -1);
        targetsEnemy = false;
    }

    /**
     * Use Pain Split and return the move results.
     * Sets the weather to Pain Split.
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
        int sum = skillUser.getCurrentHealth() + enemyPokemon.getCurrentHealth();
        int newHealth = (int)Math.round(sum / 2.0);
        skillUser.setCurrentHealth(Math.min(newHealth, skillUser.getHealthStat()));
        enemyPokemon.setCurrentHealth(Math.min(newHealth, enemyPokemon.getHealthStat()));
        results.add("The battlers shared their pain!");
        return results;
    }

    /**
     * Return Pain Split's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Pain Split's skill animation.
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
