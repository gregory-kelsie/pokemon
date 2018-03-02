package com.pokemon.toronto.game.com.pokemon.toronto.box;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;

/**
 * Created by gregorykelsie on 2018-01-23.
 */

public class BoxPokemon {
    private Pokemon pokemon;
    private BoxLocation boxLocation;

    public BoxPokemon(Pokemon pokemon, BoxLocation boxLocation) {
        this.pokemon = pokemon;
        this.boxLocation = boxLocation;
    }

    public BoxLocation getBoxLocation() {
        return boxLocation;
    }

    public void setBoxLocation(BoxLocation boxLocation) {
        this.boxLocation = boxLocation;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }


}
