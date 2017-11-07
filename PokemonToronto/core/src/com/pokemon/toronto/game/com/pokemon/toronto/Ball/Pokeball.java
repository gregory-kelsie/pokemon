package com.pokemon.toronto.game.com.pokemon.toronto.Ball;

import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemBlob;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemId;

/**
 * Created by Gregory on 6/17/2017.
 */
public class Pokeball extends Ball {

    //Init Variables
    private static final String ICON_PATH = "bag/icons/pokeball.png";
    private static final int CATCH_RATE = 1;

    /**
     * Initialize a Pokeball with the default quantity.
     */
    public Pokeball() {
        super(new ItemBlob.PokeballBlob(), ICON_PATH, CATCH_RATE);
    }

    /**
     * Initialize a Pokeball with the default quantity.
     */
    public Pokeball(int quantity) {
        super(new ItemBlob.PokeballBlob(), ICON_PATH, CATCH_RATE, quantity);
    }

}
