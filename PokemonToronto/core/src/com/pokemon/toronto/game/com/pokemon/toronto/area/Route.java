package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.badlogic.gdx.Gdx;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.RoutePokemonFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.WildPokemonCreator;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Gregory on 7/25/2017.
 */

public class Route {

    //Constants for each area.
    public static final int GRASS = 0;
    public static final int SURF = 1;
    public static final int FISHING = 2;

    public static final int ROUTE_1 = 1;
    public static final int VIRIDIAN_FOREST = 2;
    public static final int ROUTE_2 = 3;
    public static final int ROUTE_3 = 4;
    public static final int MT_MOON_1F = 5;
    public static final int MT_MOON_B1F = 6;
    public static final int MT_MOON_B2F = 7;
    public static final int ROUTE_4 = 8;
    public static final int ROUTE_24 = 9;
    public static final int ROUTE_6 = 10;
    public static final int ROUTE_11 = 11;
    public static final int DIGLETT_CAVE = 12;
    public static final int ROUTE_10 = 13;
    public static final int ROCK_TUNNEL = 14;
    public static final int POKEMON_TOWER = 15;
    public static final int ROUTE_8 = 16;
    public static final int ROUTE_7 = 17;
    public static final int ROUTE_16 = 18;
    //NEXT SET
    public static final int ROUTE_12 = 19;
    public static final int ROUTE_13 = 20;
    public static final int ROUTE_18 = 21;
    public static final int SAFARI_CENTER = 22;
    public static final int SAFARI_A1 = 23;
    public static final int SAFARI_A2 = 24;
    public static final int SAFARI_A3 = 25;
    public static final int POWER_PLANT = 26;
    public static final int ROUTE_21 = 27;
    public static final int POKEMON_MANSION_1F = 28;
    public static final int POKEMON_MANSION_B1F = 29;
    public static final int SEAFOAM_B2F = 30;
    public static final int SEAFOAM_B4F = 31;
    public static final int ROUTE_23 = 32;
    public static final int VICTORY_ROAD_1F = 33;
    public static final int VICTORY_ROAD_2F = 34;

    //JOHTO

    public static final int ROUTE_29 = 35;
    public static final int ROUTE_46 = 36;
    public static final int ROUTE_30 = 37;
    public static final int DARK_CAVE_VIOLET = 38;
    public static final int SPROUT_TOWER = 39;
    public static final int ROUTE_32 = 40;
    public static final int RUINS_OF_ALPH = 41;
    public static final int UNION_CAVE_1F = 42;
    public static final int UNION_CAVE_B2F = 43;
    public static final int ROUTE_34 = 44;
    public static final int ILEX_FOREST = 45;
    public static final int ROUTE_35 = 46;
    public static final int NATIONAL_PARK = 47;
    public static final int NATIONAL_PARK_2 = 48;
    public static final int ROUTE_36 = 49;
    public static final int ROUTE_37 = 50;
    public static final int ROUTE_38 = 51;
    public static final int ROUTE_40 = 52;
    public static final int ROUTE_41 = 53;
    public static final int CLIFF_CAVE = 54;
    public static final int ROUTE_47 = 55;
    public static final int ROUTE_48 = 56;


    public static final int TEST_ROUTE = -1;
    public static final int SWAMP = -2;
    public static final int AFRICA = -3;
    public static final int JURASSIC_PARK = -4;

    //Time
    protected final int MORNING = 0;
    protected final int DAY = 1;
    protected final int NIGHT = 2;

    //Instance Variables
    private String imagePath;
    private int routeNumber;

    //Route Options
    private boolean hasSurf;
    private boolean hasFishing;
    private boolean hasTrainers;
    private boolean hasGrass;

    //The Route's Pokemon
    protected List<RoutePokemon> grassPokemon;
    protected List<RoutePokemon> surfPokemon;
    protected List<RoutePokemon> fishingPokemon;

    protected String name;
    protected String background;
    protected String waterBackground;

    /**
     * Constructor
     * @param routeNumber The route's id
     * @param imagePath The route's image path.
     */
    public Route(int routeNumber, String imagePath, String name, String background) {
        this.routeNumber = routeNumber;
        this.imagePath = imagePath;
        this.hasTrainers = true;
        this.name = name;
        this.background = background;
        this.waterBackground = background;
        initPokemon();
        initRouteOptions();
    }

    public Route(int routeNumber, String imagePath, String name, String background, String waterBackground) {
        this.routeNumber = routeNumber;
        this.imagePath = imagePath;
        this.hasTrainers = true;
        this.name = name;
        this.background = background;
        this.waterBackground = waterBackground;
        initPokemon();
        initRouteOptions();
    }

    protected int getHourTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date date = new Date();
        String text = dateFormat.format(date);
        return new Integer(text.substring(11, 13)); //0 - 23
    }

    protected int getTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date date = new Date();
        String text = dateFormat.format(date);
        int hourTime = new Integer(text.substring(11, 13)); //0 - 23
        if (hourTime >= 6 && hourTime < 12) {
            return MORNING;
        } else if (hourTime >= 12 && hourTime <= 19) {
            return DAY;
        } else {
            return NIGHT;
        }
    }

    public String getName() {
        return name;
    }

    public String getBackground() {
        return background;
    }

    public String getWaterBackground() { return waterBackground; }

    protected void initGrassPokemon() {
        grassPokemon = null;
    }

    protected void initSurfPokemon() {
        surfPokemon = null;
    }

    protected void initRodPokemon() {
        fishingPokemon = null;
    }

    /**
     * Initialize the which areas the Route has Pokemon.
     * (Grass, Surfing, Fishing)
     */
    private void initRouteOptions() {
        //Determine whether or not the Route has Pokemon in
        //the specified area.
        if (hasPokemon(grassPokemon)) {
            hasGrass = true;
        }

        if (hasPokemon(surfPokemon)) {
            hasSurf = true;
        }

        if (hasPokemon(fishingPokemon)) {
            hasFishing = true;
        }
    }

    public boolean isAvailable(Player p) {
        return false;
    }

    /**
     * Return whether or not the area has Pokemon.
     * @param area The List<RoutePokemon> that is checked for Pokemon
     * @return A boolean determining whether or not the area has
     * Pokemon.
     */
    private boolean hasPokemon(List<RoutePokemon> area) {
        if (area != null) {
            return true;
        }
        return false;
    }

    /**
     * Initialize the Pokemon on the Route/Dungeon.
     */
    protected void initPokemon() {
        initGrassPokemon();
        initSurfPokemon();
        initRodPokemon();

    }
    /**
     * Init the Route's Pokemon using the RoutePokemonFactory
     * @param rpc The RoutePokemonFactory that creates the route's
     *            Pokemon.
     */
    private void initRoute(RoutePokemonFactory rpc) {
        grassPokemon = rpc.createRoutePokemon(routeNumber);
        surfPokemon = rpc.createSurfPokemon(routeNumber);
        fishingPokemon = rpc.createFishingPokemon(routeNumber);
    }


    /**
     * Return a String of the Route's Image path.
     * @return A String of the Route's Image Path.
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Return the Route's identification number.
     * @return The route's id
     */
    public int getRouteNumber() {
        return routeNumber;
    }

    /**
     * Return whether or not the Route has Surf Pokemon.
     * @return Whether or not the Route has Surf Pokemon.
     */
    public boolean hasSurf() {
        return hasSurf;
    }

    /**
     * Return whether or not the Route has Fishing Pokemon.
     * @return Whether or not the Route has Fishing Pokemon.
     */
    public boolean hasFishing() {
        return hasFishing;
    }

    /**
     * Return whether or not the Route has Trainers.
     * @return Whether or not the Route has Trainers.
     */
    public boolean hasTrainers() {
        return hasTrainers;
    }

    /**
     * Return whether or not the Route has Grass Pokemon.
     * @return Whether or not the Route has Grass Pokemon.
     */
    public boolean hasGrass() {
        return hasGrass;
    }


    /**
     * Return a random Pokemon from the specified area.
     * @param area An int representation of the area to get
     *             the Pokemon from. (GRASS, SURF, FISHING)
     * @return A random Pokemon from the specified area.
     */
    public Pokemon getAPokemon(int area) {
        //Determine if the specified area even has Pokemon.
        if (area == GRASS && hasGrass) {
            return getAPokemon(grassPokemon);
        } else if (area == SURF && hasSurf){
            return getAPokemon(surfPokemon);
        } else if (area == FISHING && hasFishing) {
            return getAPokemon(fishingPokemon);
        }
        return null;
    }

    /**
     * Return a random Pokemon from the specified area.
     * @param area A List<RoutePokemon> to get a random Pokemon
     *             from.
     * @return A random Pokemon from the specified area.
     */
    private Pokemon getAPokemon(List<RoutePokemon> area) {
        //Roll a random number to determine the Pokemon that shows up.
        double num = (Math.random() * 100);
        for (int i = 0; i < area.size(); i++) {
            //Check if the rolled number is within the Pokemon's rate.
            if (num <= area.get(i).getRate()) {
                //Create the Pokemon that was rolled.
                Gdx.app.log("routewpc", "" + area.get(i).getPokemonId());

                WildPokemonCreator wpc = new WildPokemonCreator();
                return wpc.createPokemon(area.get(i).getPokemonId(),
                        area.get(i).getLowestLevel(),
                        area.get(i).getHighestLevel(), wpc.SIMULATOR_WILD_POKEMON);
            }
        }
        return null;
    }

}
