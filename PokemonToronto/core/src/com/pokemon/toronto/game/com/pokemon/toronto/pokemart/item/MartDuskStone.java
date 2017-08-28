package com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item;

import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.DuskStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.ThunderStone;

/**
 * Created by Gregory on 8/19/2017.
 */

public class MartDuskStone extends MartItem {
    public MartDuskStone() {
        super(new DuskStone(),4000, 1,"pokemart/items/duskStone.png", "pokemart/itemNames/duskStone.png");
    }
}
