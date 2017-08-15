package com.pokemon.toronto.game.com.pokemon.toronto.skill;

/**
 * Created by Gregory on 8/15/2017.
 */

public class FailResult {
    private boolean failed;
    private String failText;


    public FailResult(String failText) {
        this.failed = true;
        this.failText = failText;
    }

    public FailResult(boolean failed) {
        this.failed = failed;
        this.failText = "";
    }

    public boolean hasFailed() {
        return failed;
    }

    public String getFailResult() {
        return failText;
    }
}
