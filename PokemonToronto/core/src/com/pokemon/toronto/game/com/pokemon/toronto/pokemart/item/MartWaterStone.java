package com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item;

/**
 * Created by Gregory on 8/17/2017.
 */
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.WaterStone;
public class MartWaterStone extends MartItem {
    public MartWaterStone() {
        super(new WaterStone(),4000, 1,"pokemart/items/waterStone.png", "pokemart/itemNames/waterStone.png");
    }
}
