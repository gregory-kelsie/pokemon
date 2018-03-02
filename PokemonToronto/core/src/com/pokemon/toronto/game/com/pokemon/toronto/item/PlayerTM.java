package com.pokemon.toronto.game.com.pokemon.toronto.item;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.item.tm.Tm;

/**
 * Created by gregorykelsie on 2018-02-09.
 */

public class PlayerTM extends PlayerItem {

    private Tm tm;
    public PlayerTM(Tm item) {
        super(item);
        this.tm = item;
    }
    public PlayerTM(int quantity, Tm item) {
        super(quantity, item);
        this.tm = item;
    }

    public Tm getTm() {
        return tm;
    }
}
