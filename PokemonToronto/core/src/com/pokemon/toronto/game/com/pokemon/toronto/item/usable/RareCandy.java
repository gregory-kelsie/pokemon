package com.pokemon.toronto.game.com.pokemon.toronto.item.usable;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemBlob;

/**
 * Created by Gregory on 11/7/2017.
 */

public class RareCandy extends Item {
    public RareCandy() {
        super(new ItemBlob.RareCandy(), "bag/icons/rareCandy.png");
    }

    public String use(Pokemon p) {
        p.levelUp();
        return p.getName() + " leveled up!";
    }

    @Override
    public boolean ableToUse(Pokemon p) {
        if (p.getLevel() < 100) {
            return true;
        }
        return false;
    }
}
