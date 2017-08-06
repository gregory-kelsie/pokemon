package com.pokemon.toronto.game.com.pokemon.toronto.factory;

/**
 * Created by Gregory on 6/11/2017.
 */
public class ScarboroughLookup extends SpecialLookup {

    /**
     * Constructor
     * @param longitude The player's longitude coordinate.
     * @param latitude The player's latitude coordinate.
     */
    public ScarboroughLookup(double longitude, double latitude) {
        super(longitude, latitude);
    }

    /**
     * Return a list of Pokemon if the player is in range of a special
     * location.
     */
    public void getInRangeLocations() {
        if (distance(latitude, 43.71876055, longitude, -79.26760197)
                <= 2000) {
            //add cemetary.
        }
    }

}
