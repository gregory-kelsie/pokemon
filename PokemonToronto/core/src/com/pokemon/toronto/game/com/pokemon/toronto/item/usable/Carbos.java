package com.pokemon.toronto.game.com.pokemon.toronto.item.usable;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemBlob;

/**
 * Created by Gregory on 11/7/2017.
 */

public class Carbos extends Item {
    public Carbos() {
        super(new ItemBlob.Carbos(), "bag/icons/carbos.png");
    }

    public String use(Pokemon p) {
        p.addEvs(new int[]{0, 0, 0, 0, 0, 10});
        return p.getName() + "'s Speed Stat Rose!";
    }

    @Override
    public boolean ableToUse(Pokemon p) {
        if (p.getSpeedEV() < 255 && p.getTotalEvs() < 510) {
            return true;
        }
        return false;
    }
}
