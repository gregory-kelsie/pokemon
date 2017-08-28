package com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item;

/**
 * Created by Gregory on 8/17/2017.
 */
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.SunStone;
public class MartSunStone extends MartItem {
    public MartSunStone() {
        super(new SunStone(),4000, 1,"pokemart/items/sunStone.png", "pokemart/itemNames/sunStone.png");
    }
}
