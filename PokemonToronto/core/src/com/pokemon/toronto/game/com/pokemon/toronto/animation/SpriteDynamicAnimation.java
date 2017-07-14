package com.pokemon.toronto.game.com.pokemon.toronto.animation;

/**
 * Created by Gregory on 6/18/2017.
 */

public class SpriteDynamicAnimation {
    private int startingX;
    private int leftX;
    private int rightX;
    private int shiftState;
    private int currentX;
    private boolean updatePlayer;//true if player false if enemy
    private final int LEFT = 0;
    private final int RIGHT = 1;
    private final int GOING_TO_REST = 2;
    private final int FINISHED = 3;

    private boolean play;


    public SpriteDynamicAnimation(int startingX, boolean updatePlayer) {
        this.startingX = startingX;
        this.currentX = startingX;
        leftX = startingX - 100;
        rightX = startingX + 100;
        this.updatePlayer = updatePlayer;
        if (updatePlayer) {
            this.shiftState = LEFT;
        } else {
            this.shiftState = RIGHT;
        }

    }

    public void restart() {
        shiftState = LEFT;
    }

    private void updatePlayer(double dt) {
        if (shiftState == LEFT) {
            currentX -= dt * 95;
            if (currentX <= leftX) {
                currentX = leftX;
                shiftState = RIGHT;
            }
        } else if (shiftState == RIGHT) {
            currentX += dt * 900;
            if (currentX >= rightX) {
                currentX = rightX;
                shiftState = GOING_TO_REST;
            }
        } else if (shiftState == GOING_TO_REST) {
            currentX -= dt * 900;
            if (currentX <= startingX) {
                currentX = startingX;
                shiftState = FINISHED;
                play = false;
            }
        }
    }

    private void updateEnemy(double dt) {
        if (shiftState == RIGHT) {
            currentX += dt * 75;
            if (currentX >= rightX) {
                currentX = rightX;
                shiftState = LEFT;
            }
        } else if (shiftState == LEFT) {
            currentX -= dt * 900;
            if (currentX <= leftX) {
                currentX = leftX;
                shiftState = GOING_TO_REST;
            }
        } else if (shiftState == GOING_TO_REST) {
            currentX += dt * 900;
            if (currentX >= startingX) {
                currentX = startingX;
                shiftState = FINISHED;
                play = false;
            }
        }
    }
    public void update(double dt) {
        if (updatePlayer) {
            updatePlayer(dt);
        } else {
            updateEnemy(dt);
        }

    }

    public int getX() {
        return currentX;
    }

    public boolean isFinished() {
        if (shiftState == FINISHED) {
            return true;
        }
        return false;
    }
}
