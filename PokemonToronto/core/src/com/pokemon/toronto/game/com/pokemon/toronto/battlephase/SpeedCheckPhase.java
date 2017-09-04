package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

/**
 * Created by Gregory on 7/30/2017.
 */

public class SpeedCheckPhase extends BattlePhase {

    private final boolean CHECK_FIRST_ATTACKER_PARALYSIS = true;
    private Pokemon userPokemon;
    private Pokemon enemyPokemon;
    private Skill userSkill;
    private Skill enemySkill;

    public SpeedCheckPhase(PhaseUpdaterInterface pui, Pokemon userPokemon, Pokemon enemyPokemon, Skill userSkill, Skill enemySkill) {
        super(pui);
        this.userPokemon = userPokemon;
        this.enemyPokemon = enemyPokemon;
        this.userSkill = userSkill;
        this.enemySkill = enemySkill;
        phaseName = "SpeedCheck";

    }
    @Override
    public void update(double dt) {
        if (userSkill.getPriority() > enemySkill.getPriority()) {
            pui.setUserFirstAttacker(userSkill, enemySkill);
        } else if (userSkill.getPriority() < enemySkill.getPriority()) {
            pui.setEnemyFirstAttacker(userSkill, enemySkill);
        } else {
            double userSpeed = userPokemon.getSpeedStat();
            int stage = userPokemon.getSpeedStage();
            if (stage > 0) {
                userSpeed = userSpeed * ((2.0 + stage) / 2.0);
            } else if (stage < 0) {
                userSpeed = userSpeed * (2.0 / (Math.abs(stage) + 2.0));
            }
            if (userPokemon.isParalyzed()) {
                userSpeed *= 0.5;
            }
            if (userPokemon.getAbility() == Pokemon.Ability.SAND_RUSH &&
                    pui.getField().getWeatherType() == WeatherType.SAND) {
                userSpeed *= 2;
            } else if (userPokemon.getAbility() == Pokemon.Ability.SWIFT_SWIM &&
                    (pui.getField().getWeatherType() == WeatherType.RAIN ||
                            pui.getField().getWeatherType() == WeatherType.HEAVY_RAIN)) {
                userSpeed *= 2;
            } else if (userPokemon.getAbility() == Pokemon.Ability.CHLOROPHYLL &&
                    (pui.getField().getWeatherType() == WeatherType.SUN ||
                            pui.getField().getWeatherType() == WeatherType.HARSH_SUNSHINE)) {
                userSpeed *= 2;
            }
            double enemySpeed = enemyPokemon.getSpeedStat();
            stage = enemyPokemon.getSpeedStage();
            if (stage > 0) {
                enemySpeed *= ((2 + stage) / 2);
            } else if (stage < 0) {
                enemySpeed *= (2.0 / (Math.abs(stage) + 2));
            }
            if (enemyPokemon.isParalyzed()) {
                enemySpeed *= 0.5;
            }
            if (enemyPokemon.getAbility() == Pokemon.Ability.SAND_RUSH &&
                    pui.getField().getWeatherType() == WeatherType.SAND) {
                enemySpeed *= 2;
            } else if (enemyPokemon.getAbility() == Pokemon.Ability.SWIFT_SWIM &&
                    (pui.getField().getWeatherType() == WeatherType.RAIN ||
                            pui.getField().getWeatherType() == WeatherType.HEAVY_RAIN)) {
                enemySpeed *= 2;
            } else if (enemyPokemon.getAbility() == Pokemon.Ability.CHLOROPHYLL &&
                    (pui.getField().getWeatherType() == WeatherType.SUN ||
                            pui.getField().getWeatherType() == WeatherType.HARSH_SUNSHINE)) {
                enemySpeed *= 2;
            }
            Gdx.app.log("Speedcheck", "enemy: " + enemySpeed + ", user: " + userSpeed);
            if (userSpeed >= enemySpeed) {
                pui.setUserFirstAttacker(userSkill, enemySkill);
            } else {
                pui.setEnemyFirstAttacker(userSkill, enemySkill);
            }
        }
        pui.setPhase(new SleepCheckPhase(pui, CHECK_FIRST_ATTACKER_PARALYSIS));
    }

    @Override
    public void renderText(SpriteBatch batch) {
    }

}
