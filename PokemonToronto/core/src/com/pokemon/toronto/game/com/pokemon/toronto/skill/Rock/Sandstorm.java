package com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 9/18/2017.
 */

public class Sandstorm extends Skill {
    /**
     * - Name: Sandstorm
     * - Type: Rock
     * - PP: 10
     * - Cat: Misc
     * - Accuracy: 100
     */
    public Sandstorm() {
        super(SkillFactory.SANDSTORM, "Sandstorm", SkillDescription.SANDSTORM, 10,
                Pokemon.Type.ROCK, Skill.SkillCategory.MISC, 100);
        targetsEnemy = false;
    }

    /**
     * Use Sandstorm and return the move results.
     * Sets the weather to Sandstorm.
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
        if (field.getWeatherType() == WeatherType.RAIN) {
            results.add("It stopped raining.");
        } else if (field.getWeatherType() == WeatherType.SUN) {
            results.add("The sunlight faded.");
        } else if (field.getWeatherType() == WeatherType.HAIL) {
            results.add("The Sandstorm stopped.");
        }
        field.setWeather(WeatherType.SAND);
        results.add("A sandstorm brewed!");
        return results;
    }

    /**
     * Return Sandstorm's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Sandstorm's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                               SubField userField, SubField enemyField, boolean isFirstAttack,
                               Skill targetsSkill) {
        if (field.getWeatherType() == WeatherType.HEAVY_RAIN ||
                field.getWeatherType() == WeatherType.HARSH_SUNSHINE ||
                field.getWeatherType() == WeatherType.SAND) {
            return new FailResult("It failed...");
        } else if (enemyPokemon.getBattleAbility().getId() == Ability.AbilityId.CLOUD_NINE) {
            return new FailResult(enemyPokemon.getName() + " prevents weather changes\n" +
                    "with ability Cloud Nine!");
        }
        return new FailResult(false);
    }
}
