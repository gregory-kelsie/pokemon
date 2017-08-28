package com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item;

import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;

/**
 * Created by Gregory on 8/18/2017.
 */

public class MartListing {
    protected int price;
    protected int rubyPrice;
    protected String storeImage;
    protected String headerImage;
    protected int quantity;

    public MartListing(int price, int rubyPrice, String storeImage, String headerImage, int quantity) {
        this.price = price;
        this.rubyPrice = rubyPrice;
        this.storeImage = storeImage;
        this.headerImage = headerImage;
        this.quantity = quantity;
    }

    public int getItemId() {
        return -1;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getRubyPrice() {
        return rubyPrice;
    }

    public String getStoreImage() {
        return storeImage;
    }

    public String getHeaderImage() {
        return headerImage;
    }
}
