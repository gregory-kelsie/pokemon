package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;

/**
 * Created by Gregory on 7/30/2017.
 */

public abstract class BattlePhase {
    protected PhaseUpdaterInterface pui;
    protected String phaseName;
    protected boolean isUser;
    protected boolean canUserActivateSchooling;
    protected boolean canUserRegainSchooling;
    protected boolean canEnemyActivateSchooling;
    protected boolean canEnemyRegainSchooling;
    public BattlePhase(PhaseUpdaterInterface pui) {
        this.pui = pui;
        phaseName = "";
        canUserActivateSchooling = false;
        canUserRegainSchooling = false;
        canEnemyActivateSchooling = false;
        canEnemyRegainSchooling = false;
    }

    public abstract void update(double dt);
    public abstract void renderText(SpriteBatch batch);
    public void render(SpriteBatch batch) { }
    public void dispose() {}

    public boolean isHidingEnemyPokemon() {
        return false;
    }
    public boolean isHidingUserPokemon() { return false; }
    public SkillAnimation getSkillAnimation() {
        return null;
    }

    public String getPhaseName() {
        return "Phase Name: " + phaseName;
    }

    /**
     *
     * @param pokemon
     * @param user True for user pokemon, false for enemy pokemon.
     */
    public void schoolingCheck(Pokemon pokemon, boolean user) {
        if (pokemon.getAbility().getId() == Ability.AbilityId.SCHOOLING) {
            Gdx.app.log("Schooling", "user: " + user + " canUserActivate: " + canUserActivateSchooling);
            if (canUserActivateSchooling && user) {
                pui.updatePlayerSprite();
            } else if (canEnemyActivateSchooling && !user) {
                pui.updateEnemySprite();
            }
        }
    }

    protected void calcSchoolingBeforeDamageOrHeal(Pokemon pokemon, boolean user) {
        if (pokemon.getCurrentHealth() <= pokemon.getHealthStat() * .25) {
            if (user) {
                canUserRegainSchooling = true;
            } else {
                canEnemyRegainSchooling = true;
            }
        } else {
            if (user) {
                canUserRegainSchooling = false; //you would lose schooling potentially.
            } else {
                canEnemyRegainSchooling = false;
            }
        }
        Gdx.app.log("schooling", "before: " + pokemon.getCurrentHealth());
    }

    protected void calcSchoolingAfterDamageOrHeal(Pokemon pokemon, boolean user) {
        if (user) {
            Gdx.app.log("schooling", "after: " + pokemon.getCurrentHealth());
            if (!canUserRegainSchooling && pokemon.getCurrentHealth() <= pokemon.getHealthStat() * .25) {
                canUserActivateSchooling = true;
            } else if (canUserRegainSchooling && pokemon.getCurrentHealth() > pokemon.getHealthStat() * .25) {
                canUserActivateSchooling = true;
            }
        } else {
            if (!canEnemyRegainSchooling && pokemon.getCurrentHealth() <= pokemon.getHealthStat() * .25) {
                canEnemyActivateSchooling = true;
            } else if (canEnemyRegainSchooling && pokemon.getCurrentHealth() > pokemon.getHealthStat() * .25) {
                canEnemyActivateSchooling = true;
            }
        }
    }

}
