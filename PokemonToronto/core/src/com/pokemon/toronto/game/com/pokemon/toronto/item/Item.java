package com.pokemon.toronto.game.com.pokemon.toronto.item;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;

/**
 * Created by Gregory on 8/17/2017.
 */

public class Item {
    private int id;
    private String description;
    private String name;
    private String image;
    public Item(int id, String name, String description, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public void use(Pokemon p) {

    }

    public boolean ableToUse(Pokemon p) {
        return false;
    }

    public int getEvolutionId(Pokemon p) {
        return -1;
    }

}
