package com.pokemon.toronto.game.com.pokemon.toronto.Field;

/**
 * Created by Gregory on 6/18/2017.
 */
public class Field {

    //CONSTANTS
    private final int NO_GRAVITY = 0;
    private final int DEFAULT_GRAVITY_TIME = 5;
    private final int NO_WATER_SPORT = 0;
    private final int DEFAULT_WATER_SPORT_TIME = 5;
    private final int NO_TIME_LIMIT = -1;
    private final int DEFAULT_WEATHER_LENGTH = 5; //5 turns
    private final int LAST_WEATHER_TURN = 0;
    private final int DEFAULT_TERRAIN_LENGTH = 5;
    private final int LAST_TERRAIN_TURN = -1;
    
    private WeatherType weatherType;
    private TerrainType terrainType;
    private int weatherTimeLimit;
    private int terrainTimeLimit;
    private int gravity;
    private int waterSport;

    private SubField playerField;
    private SubField opponentField;

    /**
     * The field during the battle. Keeps track of weather,
     * spikes, stealth rocks etc.
     */
    public Field() {
        weatherType = WeatherType.NORMAL;
        terrainType = TerrainType.NORMAL;
        weatherTimeLimit = NO_TIME_LIMIT;
        terrainTimeLimit = NO_TIME_LIMIT;
        playerField = new SubField();
        opponentField = new SubField();
        gravity = NO_GRAVITY;
        waterSport = NO_WATER_SPORT;
    }

    /**
     * Return the weather type for the field.
     * @return The WeatherType for the field (Rain, Sunny or nothing)
     */
    public WeatherType getWeatherType() {
        return weatherType;
    }

    /**
     * Return how long the weather type will last.
     * @return How long the weather type will last. -1 for infinite.
     */
    public int getWeatherLength() {
        return weatherTimeLimit;
    }

    /**
     * Adjust the weather type after a turn has passed.
     */
    public void adjustWeather() {
        if (weatherType != WeatherType.NORMAL &&
                weatherTimeLimit != NO_TIME_LIMIT) {
            weatherTimeLimit--;
        }
    }

    /**
     * Return whether or not the weather time limit is
     * finished.
     * @return Whether or not the weather time limit
     * expired.
     */
    public boolean onLastWeatherTurn() {
        if (weatherTimeLimit == 0) {
            return true;
        }
        return false;
    }

    /**
     * Clear all weather types and set it to normal.
     */
    public void clearWeather() {
        weatherType = WeatherType.NORMAL;
        weatherTimeLimit = NO_TIME_LIMIT;
    }

    /**
     * Return whether or not the weather deals damage
     * at the end of the turn or heals.
     * @return Whether or not the weather deals damage
     * at the end of the turn.
     */
    public boolean hasDamagingWeatherConditions() {
        if (weatherType == WeatherType.HAIL ||
                weatherType == WeatherType.SAND ||
                weatherType == WeatherType.RAIN ||
                weatherType == WeatherType.HEAVY_RAIN ||
                weatherType == WeatherType.HARSH_SUNSHINE ||
                weatherType == WeatherType.SUN) {
            return true;
        }
        return false;
    }

    /**
     * Set the WeatherType to a new WeatherType with a specified duration.
     * @param newWeatherType The new WeatherType for the Field.
     * @param duration The specified time limit for the new WeatherType.
     */
    public void setWeather(WeatherType newWeatherType, int duration) {
        weatherType = newWeatherType;
        weatherTimeLimit = duration;
    }

    /**
     * Set the WeatherType to a new WeatherType with a default duration.
     * @param newWeatherType The new WeatherType for the Field.
     */
    public void setWeather(WeatherType newWeatherType) {
        weatherType = newWeatherType;
        weatherTimeLimit = DEFAULT_WEATHER_LENGTH;
    }

    /**
     * Return the terrain type for the field.
     * @return The TerrainType for the field (Grassy, Electric, Misty)
     */
    public TerrainType getTerrainType() { return terrainType; }

    /**
     * Return how long the terrain will last.
     * @return How long the terrain will last. -1 for infinite.
     */
    public int getTerrainLength() {
        return terrainTimeLimit;
    }

    /**
     * Set the new TerrainType to a new terrain with a specified duration.
     * @param newTerrain The new TerrainType
     * @param duration The specified duration for the new TerrainType.
     */
    public void setTerrain(TerrainType newTerrain, int duration) {
        terrainType = newTerrain;
        terrainTimeLimit = duration;
    }

    /**
     * Set the new TerrainType to a new terrain.
     * @param newTerrain The new TerrainType
     */
    public void setTerrain(TerrainType newTerrain) {
        terrainType = newTerrain;
        terrainTimeLimit = DEFAULT_TERRAIN_LENGTH;
    }

    /**
     * Adjust the terrain type after a turn passed.
     */
    public void adjustTerrain() {
        if (terrainType != TerrainType.NORMAL) {
            terrainTimeLimit--;
            if (weatherTimeLimit == LAST_TERRAIN_TURN) {
                setTerrain(TerrainType.NORMAL, NO_TIME_LIMIT); //Reset weather to clear skies
            }
        }
    }

    /**
     * Apply gravity to the field.
     */
    public void applyGravity() {
        gravity = DEFAULT_GRAVITY_TIME;
    }

    /**
     * Adjust gravity after a turn has passed.
     */
    public void adjustGravity () {
        gravity--;
        gravity = Math.max(gravity, NO_GRAVITY);
    }

    /**
     * Return whether or not the Field has gravity activated.
     * @return Whether or not the Field has gravity activated.
     */
	public boolean hasGravity () {
        if (gravity == NO_GRAVITY) {
            return false;
        } else {
            return true;
        }
	}

    /**
     * Water Sport the entire field. Fire skills weaken.
     */
	public void applyWaterSport() { waterSport = DEFAULT_WATER_SPORT_TIME; }

    /**
     * Adjust the number of turns water sport is on the field.
     */
    public void adjustWaterSport() {
        waterSport--;
        waterSport = Math.max(waterSport, NO_WATER_SPORT);
    }

    /**
     * Return whether or not the field is Water sported.
     * @return Whether or not the field is water sported.
     */
    public boolean hasWaterSport() {
        if (waterSport == NO_WATER_SPORT) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Return the remaining duration for the Field's gravity
     * attribute.
     * @return The remaining duration for the Field's gravity.
     */
	public int getGravityDuration () { return gravity; }

    /**
     * Return the Player's SubField.
     * @return The Player's SubField.
     */
    public SubField getPlayerField() { return playerField; }

    /**
     * Return the Opponent's SubField.
     * @return The Opponent's SubField.
     */
	public SubField getOpponentField() { return opponentField; }

}
