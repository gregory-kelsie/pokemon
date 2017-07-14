package com.pokemon.toronto.game.com.pokemon.toronto.factory;

/**
 * Created by Gregory on 6/11/2017.
 */
public class PokemonLookupPackage {
    private int pokemonId;
    private double longitude;
    private double latitude;

    public PokemonLookupPackage(int pokemonId, double latitude, double longitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.pokemonId = pokemonId;
    }

    public PokemonLookupPackage() {

    }

    public void insertData(int pokemonId, double latitude, double longitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.pokemonId = pokemonId;
    }

    public int getPokemonId() {
        return pokemonId;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
