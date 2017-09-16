package com.pokemon.toronto.game.com.pokemon.toronto.trainer;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;

import java.util.List;

/**
 * Created by Gregory on 9/15/2017.
 */

public class WildTrainer extends Trainer {
    private double latitude;
    private double longitude;
    public WildTrainer(double latitude, double longitude, double difficulty,
                       String title, String name, String victoryText,
                       String iconPath, List<Pokemon> party) {
        super(difficulty, title, name, victoryText, iconPath, party);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

}
