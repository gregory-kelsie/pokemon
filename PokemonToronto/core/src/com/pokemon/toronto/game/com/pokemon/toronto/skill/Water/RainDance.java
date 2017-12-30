package com.pokemon.toronto.game.com.pokemon.toronto.skill.Water;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
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

public class RainDance extends Skill {
    /**
     * - Name: Rain Dance
     * - Type: Water
     * - PP: 5
     * - Cat: Misc
     * - Accuracy: 100
     */
    public RainDance() {
        super(SkillFactory.RAIN_DANCE, "Rain Dance", SkillDescription.RAIN_DANCE, 5,
                Pokemon.Type.WATER, Skill.SkillCategory.MISC, 100);
        targetsEnemy = false;
    }

    /**
     * Use Rain Dance and return the move results.
     * Sets the weather to Rain Dance.
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
        if (field.getWeatherType() == WeatherType.SAND) {
            results.add("The sandstorm subsided.");
        } else if (field.getWeatherType() == WeatherType.SUN) {
            results.add("The sunlight faded.");
        } else if (field.getWeatherType() == WeatherType.HAIL) {
            results.add("The Rain Dance stopped.");
        }
        field.setWeather(WeatherType.RAIN);
        results.add("It started to rain!");
        return results;
    }

    /**
     * Return Rain Dance's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Rain Dance's skill animation.
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
                field.getWeatherType() == WeatherType.RAIN) {
            return new FailResult("It failed...");
        } else if (enemyPokemon.getBattleAbility() == Pokemon.Ability.CLOUD_NINE) {
            return new FailResult(enemyPokemon.getName() + " prevents weather changes\n" +
                    "with ability Cloud Nine!");
        }
        return new FailResult(false);
    }
}
