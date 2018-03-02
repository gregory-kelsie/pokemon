package com.pokemon.toronto.game.com.pokemon.toronto.item;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;

/**
 * Created by Gregory on 8/17/2017.
 */

public class PlayerItem {
    protected int quantity;
    protected Item item;
    public PlayerItem(Item item) {
        this.quantity = 1;
        this.item = item;
    }
    public PlayerItem(int quantity, Item item) {
        this.quantity = quantity;
        this.item = item;
    }

    public void use(Pokemon p) {
        quantity--;
        item.use(p);
    }

    public int getQuantity() {
        return quantity;
    }

    public void add(int amount) {
        quantity += amount;
    }

    public void discard() {
        quantity--;
        quantity = Math.max(0, quantity);
    }

    public Item getItem() {
        return item;
    }
}
