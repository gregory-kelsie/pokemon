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

    private Pokemon userPokemon;
    private Pokemon enemyPokemon;
    private Skill userSkill;
    private Skill enemySkill;

    public SpeedCheckPhase(PhaseUpdaterInterface pui, Pokemon userPokemon, Pokemon enemyPokemon,
                           Skill userSkill, Skill enemySkill) {
        super(pui);
        this.userPokemon = userPokemon;
        this.enemyPokemon = enemyPokemon;
        this.userSkill = userSkill;
        this.enemySkill = enemySkill;
        phaseName = "SpeedCheck";

    }

    @Override
    public void update(double dt) {
        boolean nullSkills = false;
        if (enemySkill == null && userSkill == null) {
            nullSkills = true;
        }

        if (userSkill == null && enemySkill != null) {
            pui.setEnemyFirstAttacker();
        } else if (enemySkill == null && userSkill != null) {
            pui.setUserFirstAttacker();
        } else if (!nullSkills && userSkill.getPriority() > enemySkill.getPriority()) {
            pui.setUserFirstAttacker();
        } else if (!nullSkills && userSkill.getPriority() < enemySkill.getPriority()) {
            pui.setEnemyFirstAttacker();
        } else {
            double userSpeed = userPokemon.getTotalSpeed(pui.getField(),
                    pui.getField().getPlayerField());
            double enemySpeed = enemyPokemon.getTotalSpeed(pui.getField(),
                    pui.getField().getOpponentField());
            Gdx.app.log("Speedcheck", "enemy: " + enemySpeed + ", user: " + userSpeed);
            if ((userSpeed >= enemySpeed) && !pui.getField().hasTrickRoom()) {
                pui.setUserFirstAttacker();
            } else {
                pui.setEnemyFirstAttacker();
            }
        }
        pui.setPhase(new SleepCheckPhase(pui, true));
    }

    @Override
    public void renderText(SpriteBatch batch) {
    }

}
