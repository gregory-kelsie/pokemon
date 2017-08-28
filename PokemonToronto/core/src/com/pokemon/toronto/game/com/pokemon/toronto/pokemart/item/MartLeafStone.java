package com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item;

/**
 * Created by Gregory on 8/17/2017.
 */
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.LeafStone;
public class MartLeafStone extends MartItem {
    public MartLeafStone() {
        super(new LeafStone(), 4000, 1,"pokemart/items/leafStone.png", "pokemart/itemNames/leafStone.png");
    }
}
