package com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item;

import com.pokemon.toronto.game.com.pokemon.toronto.Ball.Pokeball;

/**
 * Created by Gregory on 8/18/2017.
 */

public class MartPokeball20  extends MartBall {
    public MartPokeball20() {
        super(new Pokeball(), 6500, 1, "pokemart/items/pokeball20.png", "pokemart/itemNames/pokeball.png");
        quantity = 20;
    }
}
