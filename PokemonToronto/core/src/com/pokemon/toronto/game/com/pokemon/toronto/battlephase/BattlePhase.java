package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;

/**
 * Created by Gregory on 7/30/2017.
 */

public abstract class BattlePhase {
    protected PhaseUpdaterInterface pui;
    protected String phaseName;
    public BattlePhase(PhaseUpdaterInterface pui) {
        this.pui = pui;
        phaseName = "";
    }

    public abstract void update(double dt);
    public abstract void renderText(SpriteBatch batch);

    public SkillAnimation getSkillAnimation() {
        return null;
    }

    public String getPhaseName() {
        return "Phase Name: " + phaseName;
    }

}
