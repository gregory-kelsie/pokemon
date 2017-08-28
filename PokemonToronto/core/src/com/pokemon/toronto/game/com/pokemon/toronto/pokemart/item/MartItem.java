package com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item;

import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;

/**
 * Created by Gregory on 8/17/2017.
 */

public class MartItem extends MartListing {
    private Item item;

    public MartItem(Item item, int price, int rubyPrice, String storeImage, String headerImage) {
        super(price, rubyPrice, storeImage, headerImage, 1);
        this.item = item;
    }

    public int getItemId() {
        return item.getId();
    }

    public Item getItem() {
        return item;
    }

}
