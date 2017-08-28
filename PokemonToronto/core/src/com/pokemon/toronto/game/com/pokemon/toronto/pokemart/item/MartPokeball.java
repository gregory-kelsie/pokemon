package com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item;

import com.pokemon.toronto.game.com.pokemon.toronto.Ball.Pokeball;

/**
 * Created by Gregory on 8/18/2017.
 */

public class MartPokeball extends MartBall {
    public MartPokeball() {
        super(new Pokeball(), 500, 1, "pokemart/items/pokeball.png", "pokemart/itemNames/pokeball.png");
    }
}
