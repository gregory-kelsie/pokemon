package com.pokemon.toronto.game.com.pokemon.toronto.factory;

import com.pokemon.toronto.game.com.pokemon.toronto.Ball.Ball;
import com.pokemon.toronto.game.com.pokemon.toronto.Ball.Pokeball;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemId;

/**
 * Created by Gregory on 6/17/2017.
 */
public class PokeballFactory {

    /**
     * Constructor
     */
    public PokeballFactory() {}

    /**
     * Return the type of Pokeball with the given id and quantity.
     * @param id The id of the Pokeball to be created.
     * @param quantity The quantity of Pokeballs
     * @return A created Pokeball with id and quantity.
     */
    public Ball createPokeball(ItemId id, int quantity) {
        if (id == ItemId.POKEBALL) {
            return new Pokeball(quantity);
        }
        return new Pokeball(quantity);
    }
}
