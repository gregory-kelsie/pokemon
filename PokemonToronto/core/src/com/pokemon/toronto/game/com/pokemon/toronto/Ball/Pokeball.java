package com.pokemon.toronto.game.com.pokemon.toronto.Ball;

/**
 * Created by Gregory on 6/17/2017.
 */
public class Pokeball extends Ball {

    //Init Variables
    private static final String NAME = "Pokeball";
    private static final String DESCRIPTION = "A device for catching wild Pokemon. " +
            "It’s thrown like a ball at a Pokemon, comfortably encapsulating" +
            " its target.";
    private static final String ICON_PATH = "bag/icons/pokeball.png";
    private static final int CATCH_RATE = 1;

    /**
     * Initialize a Pokeball with the default quantity.
     */
    public Pokeball() {
        super(Ball.POKEBALL, NAME, DESCRIPTION, ICON_PATH, CATCH_RATE);
    }

    /**
     * Initialize a Pokeball with the default quantity.
     */
    public Pokeball(int quantity) {
        super(Ball.POKEBALL, NAME, DESCRIPTION, ICON_PATH, CATCH_RATE, quantity);
    }

}
