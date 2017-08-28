package com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item;

import com.pokemon.toronto.game.com.pokemon.toronto.Ball.Pokeball;

/**
 * Created by Gregory on 8/18/2017.
 */

public class MartPokeball10 extends MartBall {
    public MartPokeball10() {
        super(new Pokeball(), 3600, 1, "pokemart/items/pokeball10.png", "pokemart/itemNames/pokeball.png");
        quantity = 10;
    }

}
