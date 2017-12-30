package com.pokemon.toronto.game.com.pokemon.toronto.item;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;

/**
 * Created by Gregory on 8/17/2017.
 */

public class Item {

    private ItemBlob info;
    private String image;

    public Item(ItemBlob info, String image) {
        this.info = info;
        this.image = image;
    }

    public Item(ItemId id, String name, String description, String image) {
        info = new ItemBlob(id, name, description);
        this.image = image;
    }

    public ItemId getId() {
        return info.getId();
    }

    public String getDescription() {
        return info.getDescription();
    }

    public String getName() {
        return info.getName();
    }

    public String getImage() {
        return image;
    }

    public String use(Pokemon p) {
        return "";
    }

    public boolean ableToUse(Pokemon p) {
        return false;
    }

    public int getEvolutionId(Pokemon p) {
        return -1;
    }

}
