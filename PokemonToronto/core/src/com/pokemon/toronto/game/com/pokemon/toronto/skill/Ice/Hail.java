package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/14/2017.
 */

public class Hail extends Skill {
    /**
     * - Name: Hail
     * - Type: Ice
     * - PP: 5
     * - Cat: Misc
     * - Accuracy: 100
     */
    public Hail() {
        super("Hail", 5, Pokemon.Type.ICE, Skill.SkillCategory.MISC, 100);
    }

    /**
     * Use Hail and return the move results.
     * Sets the weather to hail.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param field The field the battle is on.
     * @return The move results.
     */
    public List<List<String>> use(Pokemon skillUser, Pokemon enemyPokemon, Field field, boolean isFirstAttack) {
        List<List<String>> fullList = new ArrayList<List<String>>();
        List<String> firstList = new ArrayList<String>();
        List<String> secondList = new ArrayList<String>();

        if (field.getWeatherType() == WeatherType.SAND) {
            secondList.add("The sandstorm subsided.");
        } else if (field.getWeatherType() == WeatherType.SUN) {
            secondList.add("The sunlight faded.");
        } else if (field.getWeatherType() == WeatherType.RAIN) {
            secondList.add("The rain stopped.");
        }
        field.setWeather(WeatherType.HAIL);
        secondList.add("It started to hail!");

        fullList.add(firstList);
        fullList.add(secondList);
        return fullList;
    }

    /**
     * Return Hail's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Hail's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon, Field field, boolean isFirstAttack) {
        if (field.getWeatherType() == WeatherType.HEAVY_RAIN ||
                field.getWeatherType() == WeatherType.HARSH_SUNSHINE ||
                field.getWeatherType() == WeatherType.HAIL) {
            return new FailResult("It failed...");
        }
        return new FailResult(false);
    }
}
