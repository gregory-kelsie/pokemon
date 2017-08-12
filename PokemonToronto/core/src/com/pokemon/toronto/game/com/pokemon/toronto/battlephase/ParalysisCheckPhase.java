package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Gregory on 7/30/2017.
 */

public class ParalysisCheckPhase extends BattlePhase {
    private boolean isFirstMove;
    private boolean allowUpdate;
    private String text;
    private int textPosition;
    private double textCounter;
    private BattlePhase nextPhase;
    private final int INIT = 0;
    private final int EXECUTE = 1;
    private int currentState;

    public ParalysisCheckPhase(PhaseUpdaterInterface pui, boolean isFirstMove) {
        super(pui);
        phaseName = "ParalysisCheckPhase";
        text = "";
        textPosition = 0;
        textCounter = 0;
        this.isFirstMove = isFirstMove;
        currentState = INIT;

    }
    private void init() {
        String fastName;
        String slowName;
        if (pui.isUserPokemonFirstAttacker()) {
            fastName = pui.getUserPokemon().getName();
            slowName = pui.getEnemyPokemon().getName();
        } else {
            fastName = pui.getEnemyPokemon().getName();
            slowName = pui.getUserPokemon().getName();
        }
        if (isFirstMove && pui.isUserPokemonFirstAttacker() && pui.getUserPokemon().isParalyzed()) {
            Gdx.app.log("PARALYSIS", "user is paralyzed on their first attack");
            setText(fastName);
        } else if (isFirstMove && !pui.isUserPokemonFirstAttacker() && pui.getEnemyPokemon().isParalyzed()) {
            Gdx.app.log("PARALYSIS", "enemy is paralyzed on their first attack");
            setText(fastName);
        } else if (!isFirstMove && pui.isUserPokemonFirstAttacker() && pui.getEnemyPokemon().isParalyzed()) {
            Gdx.app.log("PARALYSIS",  "user is paralyzed on their second attack");
            setText(slowName);
        } else if (!isFirstMove && !pui.isUserPokemonFirstAttacker() && pui.getUserPokemon().isParalyzed()) {
            Gdx.app.log("PARALYSIS",  "enemy is paralyzed on their second attack");
            setText(slowName);
        } else {
            Gdx.app.log("PARALYSIS",  "attacker isn't paralyzed");
            allowAttackPhase();
        }
    }
    private boolean isParalyzed() {
        if (Math.random() <= .1) {
            return true;
        }
        return false;
    }

    private void setText(String name) {
        currentState = EXECUTE;
        if (isParalyzed()) {
            text = name + " is fully paralyzed.";
            textCounter = 0;
            if (isFirstMove) {
                nextPhase = new InitialSecondAttackPhase(pui);
            } else {
                nextPhase = new PoisonCheckPhase(pui);
            }
        } else {
            allowAttackPhase();
        }

    }

    private void allowAttackPhase() {
        if (isFirstMove) {
            pui.setPhase(new InitialFirstAttackPhase(pui));
        } else {
            pui.setPhase(new InitialSecondAttackPhase(pui));
        }
    }

    @Override
    public void update(double dt) {
        if (currentState == INIT) {
            init();
        } else {
            textCounter += dt;
            if (textCounter >= 0.05) {
                if (textPosition == text.length() - 1) {

                } else {
                    textPosition += 1;
                    textCounter = 0;
                }
            }
            //1 Second delay after writing the name.
            //No delay if there is no text.
            if (textCounter >= 1.5) {
                pui.setPhase(nextPhase);
            }
        }
    }

    @Override
    public void renderText(SpriteBatch batch) {
        if (text != null && text != "") {
            pui.getFont().draw(batch, text.substring(0, textPosition), 54, 1143);
        }
    }
}
