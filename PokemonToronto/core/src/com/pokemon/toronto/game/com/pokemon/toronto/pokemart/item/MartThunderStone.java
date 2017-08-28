package com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item;

/**
 * Created by Gregory on 8/17/2017.
 */
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.ThunderStone;
public class MartThunderStone extends MartItem {
    public MartThunderStone() {
        super(new ThunderStone(),4000, 1,"pokemart/items/thunderStone.png", "pokemart/itemNames/thunderStone.png");
    }
}
