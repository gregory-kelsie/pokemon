package com.pokemon.toronto.game.com.pokemon.toronto.item.usable;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemBlob;

/**
 * Created by Gregory on 11/6/2017.
 */

public class MaxPotion extends Item {
    public MaxPotion() {
        super(new ItemBlob.MaxPotion(), "bag/icons/maxPotion.png");
    }

    public void use(Pokemon p) {
        p.addHealth(p.getHealthStat() - p.getCurrentHealth());
    }

    @Override
    public boolean ableToUse(Pokemon p) {
        if (p.getCurrentHealth() < p.getHealthStat()) {
            return true;
        }
        return false;
    }
}
