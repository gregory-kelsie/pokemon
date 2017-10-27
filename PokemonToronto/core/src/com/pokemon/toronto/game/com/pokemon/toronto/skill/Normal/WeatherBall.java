package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/26/2017.
 */

public class WeatherBall extends DamageSkill {

    /**
     * - Name: Weather Ball
     * - Type: Normal
     * - Base Damage: 50
     * - PP: 10
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public WeatherBall() {
        super(SkillFactory.WEATHER_BALL, "Weather Ball", 10, Pokemon.Type.NORMAL,
                SkillCategory.SPECIAL, 100, 50, 1);
    }

    /**
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
        List<String> results;
        if (field.getWeatherType() == WeatherType.SUN) {
            damage = 100;
            type = Pokemon.Type.FIRE;
            results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                    enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                    targetSkill, skillUserParty, enemyPokemonParty);
            resetWeatherBall();
        } else if (field.getWeatherType() == WeatherType.SAND) {
            damage = 100;
            type = Pokemon.Type.ROCK;
            results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                    enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                    targetSkill, skillUserParty, enemyPokemonParty);
            resetWeatherBall();
        } else if (field.getWeatherType() == WeatherType.HAIL) {
            damage = 100;
            type = Pokemon.Type.ICE;
            results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                    enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                    targetSkill, skillUserParty, enemyPokemonParty);
            resetWeatherBall();

        } else if (field.getWeatherType() == WeatherType.RAIN) {
            damage = 100;
            type = Pokemon.Type.WATER;
            results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                    enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                    targetSkill, skillUserParty, enemyPokemonParty);
            resetWeatherBall();
        } else {
            results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                    enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                    targetSkill, skillUserParty, enemyPokemonParty);
        }
        return results;
    }

    private void resetWeatherBall() {
        damage = 50;
        type = Pokemon.Type.NORMAL;
    }

    /**
     * Return Weather Ball's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Weather Ball's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
