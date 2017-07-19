package com.pokemon.toronto.game.com.pokemon.toronto.catching;

public class CatchResults {
    private boolean caught;
    private int shakes;

    public CatchResults(boolean caught, int shakes) {
        this.caught = caught;
        this.shakes = shakes;
    }

    public boolean isCaught() {
        return caught;
    }

    public int getShakes() {
        return shakes;
    }
}