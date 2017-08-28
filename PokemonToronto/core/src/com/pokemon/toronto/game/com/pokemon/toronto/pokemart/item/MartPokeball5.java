package com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item;

import com.pokemon.toronto.game.com.pokemon.toronto.Ball.Pokeball;

/**
 * Created by Gregory on 8/18/2017.
 */

public class MartPokeball5 extends MartBall {
    public MartPokeball5() {
        super(new Pokeball(), 2100, 1, "pokemart/items/pokeball5.png", "pokemart/itemNames/pokeball.png");
        quantity = 5;
    }

}
