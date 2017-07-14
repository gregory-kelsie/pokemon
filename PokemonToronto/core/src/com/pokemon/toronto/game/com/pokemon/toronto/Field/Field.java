package com.pokemon.toronto.game.com.pokemon.toronto.Field;

/**
 * Created by Gregory on 6/18/2017.
 */
public class Field {
    public enum WeatherType {
        NORMAL, RAIN, SUN
    }

    private WeatherType weatherType;
    public Field() {
        this.weatherType = WeatherType.NORMAL;
    }

    public WeatherType getWeatherType() {
        return weatherType;
    }
}
