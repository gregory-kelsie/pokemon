package com.pokemon.toronto.game.com.pokemon.toronto.factory;

import com.pokemon.toronto.game.com.pokemon.toronto.item.PlayerItem;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.DuskStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.FireStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.LeafStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.ShinyStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.SunStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.ThunderStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.WaterStone;

/**
 * Created by Gregory on 8/17/2017.
 */

public class ItemFactory {

    private final int LEAF_STONE = 20;
    private final int THUNDER_STONE = 23;
    private final int WATER_STONE = 22;
    private final int FIRE_STONE = 21;
    private final int SUN_STONE = 24;
    private final int DUSK_STONE = 25;
    private final int SHINY_STONE = 26;

    public ItemFactory() {

    }

    public PlayerItem createStone(int stoneId, int amount) {
        if (stoneId == LEAF_STONE) {
            return new PlayerItem(amount, new LeafStone());
        } else if (stoneId == FIRE_STONE) {
            return new PlayerItem(amount, new FireStone());
        } else if (stoneId == WATER_STONE) {
            return new PlayerItem(amount, new WaterStone());
        } else if (stoneId == THUNDER_STONE) {
            return new PlayerItem(amount, new ThunderStone());
        } else if (stoneId == SUN_STONE) {
            return new PlayerItem(amount, new SunStone());
        } else if (stoneId == DUSK_STONE) {
            return new PlayerItem(amount, new DuskStone());
        } else if (stoneId == SHINY_STONE) {
            return new PlayerItem(amount, new ShinyStone());
        }
        return null;
    }
}
