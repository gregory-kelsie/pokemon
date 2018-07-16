package com.pokemon.toronto.game.com.pokemon.toronto.pokedex;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.*;

/**
 * Created by gregorykelsie on 2018-06-04.
 */

public class PokedexEntry {
    private int dexStatus;
    private Pokemon pokemon;


    public PokedexEntry(Pokemon pokemon) {
        this.dexStatus = 0;
        this.pokemon = pokemon;
    }
    public PokedexEntry(int dexStatus, Pokemon pokemon) {
        this.dexStatus = dexStatus;
        this.pokemon = pokemon;
    }

    public int getDexNum() {
        return pokemon.getId();
    }

    public String getName() {
        return pokemon.getName();
    }

    public String getDescription() {
        return pokemon.getDescription();
    }

    public String getMiniIcon() {
        return pokemon.getMiniIconPath();
    }

    public String getSprite() {
        return pokemon.getMapIconPath();
    }

    public Pokemon.Type getTypeOne() {
        return pokemon.getTypeOne();
    }

    public Pokemon.Type getTypeTwo() {
        return pokemon.getTypeTwo();
    }

    public double getHeight() {
        return pokemon.getHeight();
    }

    public double getWeight() {
        return pokemon.getWeight();
    }


    public String getClassification() {
        return pokemon.getClassification();
    }


}
