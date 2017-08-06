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
    /** Constants */

    //The main states of the animation.
    private final int TOSSING;
    private final int SHAKING = 1;
    private final int FINISHED = 2;

    //Pokeball texture indices during the shake animation.
    private final int RESTING_POKEBALL = 1;
    private final int LEFT_TILT = 0;
    private final int RIGHT_TILT = 2;
    private final int FADED = 3;

    //The states of the shaking Pokeball animation.
    private final int PAUSE_STATE = 0;
    private final int SHAKE_STATE = 1;
    private final int FADED_STATE = 2;

    //Starting Coordiantes
    private final int STARTING_X = 122;
    private final int STARTING_Y = 1231;

    /** Instance Variables */

    private int x;
    private int y;
    private int currentMainState;
    private boolean finished;
    private double counter;
    private int currentFrame;
    private int state;
    private int currentShake;
    private CatchResults catchResults;
    private List<Texture> pokeballFrames;

    /**
     * Create a Pokeball animation for the CatchResults catchResults
     * @param catchResults The results of a Pokemon catch attempt that shapes
     *                     how the animation will play out. (shaking count &
     *                     catch success)
     */
    public PokeballAnimation(CatchResults catchResults) {
        this.x = STARTING_X;
        this.y = STARTING_Y;
        currentFrame = RESTING_POKEBALL;
        state = PAUSE_STATE;
        TOSSING = 0;
        currentMainState = TOSSING;
        this.catchResults = catchResults;
        finished = false;
        currentShake = 0;
        initTextures();
    }

    /**
     * Initialize all of the textures for the animation.
     */
    private void initTextures() {
        pokeballFrames = new ArrayList<Texture>();
        pokeballFrames.add(new Texture("battle/trainer/pokeball_left_tilt.png"));
        pokeballFrames.add(new Texture("battle/trainer/pokeball.png"));
        pokeballFrames.add(new Texture("battle/trainer/pokeball_right_tilt.png"));
        pokeballFrames.add(new Texture("battle/trainer/pokeball_faded.png"));
    }


    /**
     * Update the Pokeball animation.
     * @param dt The time passed.
     */
    public void update(double dt) {
        if (currentMainState == TOSSING) {
            updateTossingState(dt);

        } else if (currentMainState == SHAKING) {
            updateShakeState(dt);
        }
    }


    /**
     * Update the Pokeball animation during the ball toss towards
     * the enemy Pokemon.
     * @param dt The time passed.
     */
    private void updateTossingState(double dt) {
        if (isWithinFallingCoordaintes(x)) {
            fallTowardsEnemy();
        }
        else if (isAtShakingCoordaintes(x)) {
            currentMainState = SHAKING;
        } else {
            moveDiagonalTowardsEnemy();
        }
    }


    /**
     *Return whether or not the Pokeball is within dropping down coordinates.
     * Ex: When the Pokeball is at max height, it falls down to the Pokemon.
     * @param x The current x coordinate of the Pokeball
     * @return Whether or not the Pokeball is dropping towards the enemy.
     */
    private boolean isWithinFallingCoordaintes(int x) {
        if (x >= 680 && x <= 800) {
            return true;
        }
        return false;
    }

    /**
     * Return whether or not the Pokeball is at shaking coordiantes.
     * Ex: When the Pokeball is on the enemy's position.
     * @param x The current x coordinate of the Pokeball
     * @return Whether or not the Pokeball is in the shaking spot.
     */
    private boolean isAtShakingCoordaintes(int x) {
        if (x >= 800) {
            return true;
        }
        return false;
    }

    /**
     * Move the Pokeball's coordaintes towards the enemy in a falling velocity
     */
    private void fallTowardsEnemy() {
        x += 5;
        y -= 10;
    }

    /**
     * Move the Pokeball's coordaintes towards the enemy in an upward
     * diagonal velocity.
     */
    private void moveDiagonalTowardsEnemy() {
        x += 10;
        y += 10;
    }

    /**
     * Update the animation when it is in the shaking part.
     * @param dt The time passed.
     */
    private void updateShakeState(double dt) {
        counter += dt;
        if (state == PAUSE_STATE) {
            if (counter >= 1) { //Pause for 1 Second
                state = SHAKE_STATE;
                counter = 0;
                if (currentShake == catchResults.getShakes() &&
                        catchResults.isCaught()) {
                    //Caught the Pokemon.
                    state = FADED_STATE;
                    currentFrame = FADED;
                } else if (currentShake == catchResults.getShakes()) {
                    //Didn't catch the Pokemon.
                    counter = 0;
                    currentMainState = FINISHED;
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
                    currentShake++; //Adjust the number of shakes.
                    state = PAUSE_STATE; //Check if caught.
                }
            }
        } else if (state == FADED_STATE) {
            if (counter >= 2) { //Two second pause.
                counter = 0;
                currentMainState = FINISHED;
                finished = true;
            }
        }
    }

    /**
     * Render the animation.
     * @param batch Draw the animation to the SpriteBatch batch.
     */
    public void render(SpriteBatch batch) {
        batch.draw(pokeballFrames.get(currentFrame), x, y);
    }

    /**
     * Return whether or not the entire animation is finished.
     * @return A boolean showing whether or not the animation is finished.
     */
    public boolean isFinished() {
        if (finished) {
            return true;
        }
        return false;
    }

    /**
     * Return whether or not the animation is in the shaking part.
     * @return A boolean showing whether or not the animation is shaking.
     */
    public boolean isShaking() {
        if (currentMainState == SHAKING) {
            return true;
        }
        return false;
    }


    /**
     * Dispose the textures for the animation.
     */
    public void dispose() {
        for (Texture t: pokeballFrames) {
            t.dispose();
        }
    }
}
