package com.pokemon.toronto.game.com.pokemon.toronto.item.usable;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemBlob;

/**
 * Created by Gregory on 11/7/2017.
 */

public class Protein extends Item {
    public Protein() {
        super(new ItemBlob.Protein(), "bag/icons/protein.png");
    }

    public String use(Pokemon p) {
        p.addEvs(new int[]{0, 10, 0, 0, 0, 0});
        return p.getName() + "'s Attack Stat Rose!";
    }

    @Override
    public boolean ableToUse(Pokemon p) {
        if (p.getAttackEV() < 255 && p.getTotalEvs() < 510) {
            return true;
        }
        return false;
    }
}
