package com.pokemon.toronto.game.com.pokemon.toronto.Field;

/**
 * Created by Gregory on 6/18/2017.
 */
public class Field {

    private WeatherType weatherType;

    /**
     * The field during the battle. Keeps track of weather,
     * spikes, stealth rocks etc.
     */
    public Field() {
        this.weatherType = WeatherType.NORMAL;
    }


    /**
     * Return the weather type for the field.
     * @return The WeatherType for the field (Rain, Sunny or nothing)
     */
    public WeatherType getWeatherType() {
        return weatherType;
    }
}
