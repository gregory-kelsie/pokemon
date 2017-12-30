package com.pokemon.toronto.game.com.pokemon.toronto.item.usable;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemBlob;

/**
 * Created by Gregory on 11/7/2017.
 */

public class Zinc extends Item {
    public Zinc() {
        super(new ItemBlob.Zinc(), "bag/icons/zinc.png");
    }

    public String use(Pokemon p) {
        p.addEvs(new int[]{0, 0, 0, 0, 10, 0});
        return p.getName() + "'s Special Defense Stat Rose!";
    }

    @Override
    public boolean ableToUse(Pokemon p) {
        if (p.getSpDefenseEV() < 255 && p.getTotalEvs() < 510) {
            return true;
        }
        return false;
    }
}
