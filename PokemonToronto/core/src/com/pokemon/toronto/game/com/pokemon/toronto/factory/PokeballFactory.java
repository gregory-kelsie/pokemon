package com.pokemon.toronto.game.com.pokemon.toronto.factory;

import com.pokemon.toronto.game.com.pokemon.toronto.Ball.Ball;
import com.pokemon.toronto.game.com.pokemon.toronto.Ball.Pokeball;

/**
 * Created by Gregory on 6/17/2017.
 */
public class PokeballFactory {
    public PokeballFactory() {

    }

    public Ball createPokeball(int id, int quantity) {
        if (id == Ball.POKEBALL) {
            return new Pokeball(quantity);
        }
        return new Pokeball(quantity);
    }
}
