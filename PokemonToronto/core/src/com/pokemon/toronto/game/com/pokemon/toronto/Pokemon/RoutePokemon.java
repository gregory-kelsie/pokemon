package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

/**
 * Created by Gregory on 7/25/2017.
 */

public class RoutePokemon {
    private int pokemonId;
    private int lowestLevel;
    private int highestLevel;
    private double rate;
    public RoutePokemon(int pokemonId, int lowestLevel, int highestLevel, double rate) {
        this.pokemonId = pokemonId;
        this.lowestLevel = lowestLevel;
        this.highestLevel = highestLevel;
        this.rate = rate;
    }

    public int getPokemonId() {
        return pokemonId;
    }

    public int getLowestLevel() {
        return lowestLevel;
    }

    public int getHighestLevel() {
        return highestLevel;
    }

    public double getRate() {
        return rate;
    }


}
