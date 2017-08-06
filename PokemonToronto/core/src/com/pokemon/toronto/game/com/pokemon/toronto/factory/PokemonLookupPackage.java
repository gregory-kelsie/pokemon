package com.pokemon.toronto.game.com.pokemon.toronto.factory;

/**
 * Created by Gregory on 6/11/2017.
 */
public class PokemonLookupPackage {
    //Instance Variables
    private int pokemonId;
    private double longitude;
    private double latitude;

    /**
     * Create a PokemonLookupPackage.
     * @param pokemonId The id of the Pokemon.
     * @param latitude The latitude position of the Pokemon.
     * @param longitude The longitude position of the Pokemon.
     */
    public PokemonLookupPackage(int pokemonId, double latitude, double longitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.pokemonId = pokemonId;
    }

    /**
     * Return the Pokemon's id.
     * @return The id of the Pokemon.
     */
    public int getPokemonId() {
        return pokemonId;
    }

    /**
     * Return the Pokemon's latitude position.
     * @return The latitude position of the Pokemon.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Return the Pokemon's longitude position.
     * @return The longitude position of the Pokemon.
     */
    public double getLongitude() {
        return longitude;
    }
}
