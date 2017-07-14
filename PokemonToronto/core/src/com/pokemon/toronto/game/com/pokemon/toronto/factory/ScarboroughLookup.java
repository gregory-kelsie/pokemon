package com.pokemon.toronto.game.com.pokemon.toronto.factory;

/**
 * Created by Gregory on 6/11/2017.
 */
public class ScarboroughLookup extends SpecialLookup {

    public ScarboroughLookup(double longitude, double latitude) {
        super(longitude, latitude);
    }

    public void getInRangeLocations() {
        if (distance(latitude, 43.71876055, longitude, -79.26760197) <= 2000) {
            //add cemetary.
        }
    }
    @Override
    public int getSpecialPokemon() {
        return 0;
    }
}
