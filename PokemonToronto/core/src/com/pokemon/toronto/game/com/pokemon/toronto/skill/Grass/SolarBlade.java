package com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 9/19/2017.
 */

public class SolarBlade extends DamageSkill {
    /**
     * - Name: Solar Blade
     * - Type: Grass
     * - Base Damage: 125
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public SolarBlade() {
        super(SkillFactory.SOLAR_BLADE, "Solar Blade", SkillDescription.SOLAR_BLADE, 10,
                Pokemon.Type.GRASS, SkillCategory.PHYSICAL, 100, 125, 1);
    }

    /**
     * Damage the enemy, no charge in sun, half damage in rain, hail, fog
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty      @return The results of using the move.
     * */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {

        List<String> results = new ArrayList<String>();
        if (!skillUser.hasNextTurnSkill()) {
            if (field.getWeatherType() == WeatherType.SUN) {
                //Attack
                return super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                        enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                        targetSkill, skillUserParty, enemyPokemonParty);
            } else {
                //Charge
                skillUser.setNextTurnSkill(this);
                results.add(skillUser.getName() + " absorbed\nlight!");
                return results;
            }
        } else {
            skillUser.setNextTurnSkill(null);
            if (field.getWeatherType() == WeatherType.RAIN || field.getWeatherType()
                    == WeatherType.HAIL || field.getWeatherType() == WeatherType.SAND) {
                extraMod = 0.5; //Half damage in rain, hail or sand
            }
            results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                    enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                    targetSkill, skillUserParty, enemyPokemonParty);
            extraMod = 1; //Reset extraMod
            return results;
        }
    }

    @Override
    public boolean targetsEnemy(Pokemon skillUser, Field field) {
        if (skillUser.hasNextTurnSkill() ||
                (!skillUser.hasNextTurnSkill() &&
                        field.getWeatherType() == WeatherType.SUN)) {
            return true;
        } else {
            return false;
        }
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
