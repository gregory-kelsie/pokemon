package com.pokemon.toronto.game.com.pokemon.toronto.catching;

public class CatchResults {
    //Instance Variables
    private boolean caught;
    private int shakes;

    /**
     * Create the catch results for the Pokemon.
     * @param caught A boolean determining whether the Pokemon was caught.
     * @param shakes The number of shakes of the catch attempt.
     */
    public CatchResults(boolean caught, int shakes) {
        this.caught = caught;
        this.shakes = shakes;
    }


    /**
     * Return whether or not the Pokemon was caught.
     * @return A boolean determining whether or not the Pokemon was caught.
     */
    public boolean isCaught() {
        return caught;
    }

    /**
     * Return the number of shakes after the catch attempt.
     * @return An int of the number of shakes of the Pokeball.
     */
    public int getShakes() {
        return shakes;
    }
}