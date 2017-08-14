package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
                userSpeed *= ((2 + stage) / 2);
            } else if (stage < 0) {
                userSpeed *= (2 / (Math.abs(stage) + 2));
            }
            if (userPokemon.isParalyzed()) {
                userSpeed *= 0.5;
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
            Gdx.app.log("Speedcheck", "enemy: " + enemySpeed + ", user: " + userSpeed);
            if (userSpeed >= enemySpeed) {
                pui.setUserFirstAttacker(userSkill, enemySkill);
            } else {
                pui.setEnemyFirstAttacker(userSkill, enemySkill);
            }
        }
        pui.setPhase(new ConfusionCheckPhase(pui, CHECK_FIRST_ATTACKER_PARALYSIS));
    }

    @Override
    public void renderText(SpriteBatch batch) {
    }

}
