package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.PokeballAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.catching.CatchResults;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import static com.pokemon.toronto.game.com.pokemon.toronto.Ball.Ball.POKEBALL;

/**
 * Created by Gregory on 8/10/2017.
 */

public class CatchingPhase extends BattlePhase {
    private int ballType;
    private Skill enemySkill;

    //Text Variables
    private String catchText;
    private double counter;
    private int textPosition;

    private CatchResults catchResults;
    private PokeballAnimation pokeballAnimation;

    private int state;
    private final int THROW_BALL = 0;
    private final int SHAKING_BALL = 1;
    private final int DISPLAY_CATCH_RESULTS = 2;
    private final int FINISHED = 3;
    public CatchingPhase(PhaseUpdaterInterface pui, Skill enemySkill, int ballType) {
        super(pui);
        counter = 0;
        textPosition = 0;
        this.ballType = ballType;
        this.enemySkill = enemySkill;
        state = THROW_BALL;

        catchResults = getCatchResults();
        if (catchResults.isCaught()) {
            catchText = "You caught a " + pui.getEnemyPokemon().getName() + "!";
        } else {
            if (catchResults.getShakes() == 0) {
                catchText = "Oh, no! The Pokémon broke free!";
            } else if (catchResults.getShakes() == 1) {
                catchText = "Aww! It appeared to be caught!";
            } else if (catchResults.getShakes() == 2) {
                catchText = "Aargh! Almost had it!";
            } else {
                catchText = "Shoot! It was so close, too!";
            }
        }
        pokeballAnimation = new PokeballAnimation(catchResults);

    }

    private CatchResults getCatchResults() {
        double ballMultiplier = getBallMultiplier(ballType);
        double catchRate = pui.getEnemyPokemon().getCaptureRate();
        int maxHealth = pui.getEnemyPokemon().getHealthStat();
        int currentHealth = pui.getEnemyPokemon().getCurrentHealth();
        double bonusStatus = getBonusStatus(pui.getEnemyPokemon().getStatus());
        double a = (((3 * maxHealth - 2 * currentHealth) * catchRate * ballMultiplier)
                / (3 * maxHealth)) * bonusStatus;
        Gdx.app.log("Capture", "a: " + a);
        int shakeAmount = 0;
        if (a < 255) {
            double b = 1048560 / (Math.sqrt(Math.sqrt(16711680 / a)));
            Gdx.app.log("Capture", "b: " + b);
            boolean caught = true;
            for (int i = 0; i < 4; i++) {
                long rand = Math.round(Math.random() * 65535);
                Gdx.app.log("Capture", "rand: " + rand);
                if (rand < b) {
                    shakeAmount++;
                } else {
                    caught = false;
                    break;
                }
            }
            return new CatchResults(caught, shakeAmount);
        } else {
            return new CatchResults(true, 0);
        }

    }

    private double getBonusStatus(Pokemon.Status s) {
        if (s == Pokemon.Status.BURN || s == Pokemon.Status.PARALYSIS) {
            return 1.5;
        } else if (s == Pokemon.Status.FROZEN || s == Pokemon.Status.SLEEP) {
            return 2;
        } else {
            return 1;
        }
    }

    private double getBallMultiplier(int ballType) {
        if (ballType == POKEBALL) {
            return 1;
        } else {
            return 1;
        }
    }

    @Override
    public void update(double dt) {
        if (state == THROW_BALL) {
            pokeballAnimation.update(dt);
            if (pokeballAnimation.isShaking()) {
                state = SHAKING_BALL;
            }
        } else if (state == SHAKING_BALL) {
            pokeballAnimation.update(dt);
            if (pokeballAnimation.isFinished()) {
                state = DISPLAY_CATCH_RESULTS;
            }
        } else if (state == DISPLAY_CATCH_RESULTS) {
            updateCatchResultsText(dt);
        }
    }

    private void updateCatchResultsText(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textPosition < catchText.length()) {
                textPosition++;
                counter = 0;
            }

        }
        //1 Second delay after writing the name.
        if (counter >= 2) {
            if (catchResults.isCaught()) {
                pui.caughtTheWildPokemon();
                pui.endBattle();
            } else {
                pui.setPhase(new ParalysisCheckPhase(pui, false));
            }
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        if (state == THROW_BALL || state == SHAKING_BALL) {
            pokeballAnimation.render(batch);
        }
    }

    @Override
    public void renderText(SpriteBatch batch) {
        if (state == DISPLAY_CATCH_RESULTS) {
            pui.getFont().draw(batch, catchText.substring(0, textPosition), 54, 1143);
        }
    }

    @Override
    public boolean isHidingEnemyPokemon() {
        if (state == SHAKING_BALL) {
            return true;
        }
        else {
            if (state == DISPLAY_CATCH_RESULTS && catchResults.isCaught()) {
                return true;
            }
            return false;
        }
    }
}
