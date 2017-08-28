package com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item;

/**
 * Created by Gregory on 8/17/2017.
 */
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.FireStone;


public class MartFireStone extends MartItem {
    public MartFireStone() {
        super(new FireStone(),4000, 1,"pokemart/items/fireStone.png", "pokemart/itemNames/fireStone.png");
    }
}
