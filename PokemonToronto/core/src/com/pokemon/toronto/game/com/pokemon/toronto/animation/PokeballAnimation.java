package com.pokemon.toronto.game.com.pokemon.toronto.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.catching.CatchResults;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 7/13/2017.
 */

public class PokeballAnimation {
    private final int RESTING_POKEBALL = 1;
    private final int LEFT_TILT = 0;
    private final int RIGHT_TILT = 2;
    private final int FADED = 3;
    private int x;
    private int y;
    private boolean finished;
    private Texture pokeballTexture;
    private Texture leftPokeballTexture;
    private Texture rightPokeballTexture;
    private Texture fadedPokeballTexture;
    private boolean tossing;
    private boolean shaking;
    private double counter;
    private int currentFrame;

    private int state;
    private final int PAUSE_STATE = 0;
    private final int SHAKE_STATE = 1;
    private final int FADED_STATE = 2;

    private List<Texture> pokeballFrames;
    private int currentShake;
    private CatchResults catchResults;

    public PokeballAnimation() {
        this.x = 122;
        this.y = 1231;
        finished = false;
        tossing = true;
        shaking = false;
        pokeballTexture = new Texture("battle/trainer/pokeball.png");
        leftPokeballTexture = new Texture("battle/trainer/pokeball_left_tilt.png");
        rightPokeballTexture = new Texture("battle/trainer/pokeball_right_tilt.png");
        fadedPokeballTexture = new Texture("battle/trainer/pokeball_faded.png");
        pokeballFrames = new ArrayList<Texture>();
        pokeballFrames.add(leftPokeballTexture);
        pokeballFrames.add(pokeballTexture);
        pokeballFrames.add(rightPokeballTexture);
        pokeballFrames.add(fadedPokeballTexture);
        currentFrame = RESTING_POKEBALL;
        state = PAUSE_STATE;
        currentShake = 0;

    }

    public void update(double dt) {
        if (tossing) {
            if (x >= 680 && x <= 800) {
                x += 5;
                y -= 10;
            }
            else if (x >= 800) {
                tossing = false;
                shaking = true;
                finished = true;
            } else {
                x += 10;
                y += 10;
            }

        } else if (shaking) {
            counter += dt;
            if (state == PAUSE_STATE) {
                if (counter >= 1) {
                    state = SHAKE_STATE;
                    counter = 0;
                    if (currentShake == catchResults.getShakes() && catchResults.isCaught()) {
                        state = FADED_STATE;
                        currentFrame = FADED;
                    } else if (currentShake == catchResults.getShakes()) {
                        counter = 0;
                        shaking = false;
                        finished = true;
                    }
                }
            } else if (state == SHAKE_STATE) {
                if (counter >= 0.15) {
                    counter = 0;
                    if (currentFrame == RESTING_POKEBALL) {
                        currentFrame = LEFT_TILT;
                    } else if (currentFrame == LEFT_TILT) {
                        currentFrame = RIGHT_TILT;
                    } else if (currentFrame == RIGHT_TILT) {
                        currentFrame = RESTING_POKEBALL;
                        currentShake++;
                        state = PAUSE_STATE;
                    }
                }
            } else if (state == FADED_STATE) {
                if (counter >= 2) {
                    counter = 0;
                    shaking = false;
                    finished = true;
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(pokeballFrames.get(currentFrame), x, y);
    }

    public void startShaking() {
        shaking = true;
    }
    public boolean isFinished() {
        if (finished) {
            return true;
        } else {
            return false;
        }
    }

    public void resetFinish(CatchResults catchResults) {
        this.catchResults = catchResults;
        finished = false;
    }
    public void dispose() {
        pokeballTexture.dispose();
        leftPokeballTexture.dispose();
        rightPokeballTexture.dispose();
    }
}
