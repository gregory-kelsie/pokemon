package com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item;

import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.ShinyStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.ThunderStone;

/**
 * Created by Gregory on 8/19/2017.
 */

public class MartShinyStone extends MartItem {
    public MartShinyStone() {
        super(new ShinyStone(),4000, 1,"pokemart/items/shinyStone.png", "pokemart/itemNames/shinyStone.png");
    }
}
