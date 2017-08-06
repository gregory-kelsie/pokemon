package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.RoutePokemonFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.WildPokemonCreator;

import java.util.List;

/**
 * Created by Gregory on 7/25/2017.
 */

public class Route {

    //Constants for each area.
    public static final int GRASS = 0;
    public static final int SURF = 1;
    public static final int FISHING = 2;

    //Instance Variables
    private String imagePath;
    private int routeNumber;

    //Route Options
    private boolean hasSurf;
    private boolean hasFishing;
    private boolean hasTrainers;
    private boolean hasGrass;

    //The Route's Pokemon
    private List<RoutePokemon> grassPokemon;
    private List<RoutePokemon> surfPokemon;
    private List<RoutePokemon> fishingPokemon;

    /**
     * Constructor
     * @param routeNumber The route's id
     * @param imagePath The route's image path.
     * @param isRoute An identification on whether it is a route or a cave.
     */
    public Route(int routeNumber, String imagePath, boolean isRoute) {
        this.routeNumber = routeNumber;
        this.imagePath = imagePath;
        this.hasTrainers = true;
        initPokemon(isRoute, new RoutePokemonFactory());
        initRouteOptions();

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
     * @param isRoute A determinate for whether or not the area is a Route
     *                or a dungeon.
     * @param rpc The RoutePokemonFactory that creates the route's
     *            Pokemon.
     */
    private void initPokemon(boolean isRoute, RoutePokemonFactory rpc) {
        if (isRoute) {
            initRoute(rpc);
        } else {
            initDungeon(rpc);
        }
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
     * Init the Dungeon's Pokemon using the RoutePokemonFactory
     * @param rpc The RoutePokemonFactory that creates the dungeon's
     *            Pokemon.
     */
    private void initDungeon(RoutePokemonFactory rpc) {
        grassPokemon = rpc.createRouteDungeonPokemon(routeNumber);
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
        int num = (int) (Math.random() * 100);
        for (int i = 0; i < area.size(); i++) {
            //Check if the rolled number is within the Pokemon's rate.
            if (num <= area.get(i).getRate()) {
                //Create the Pokemon that was rolled.
                WildPokemonCreator wpc = new WildPokemonCreator();
                return wpc.createPokemon(area.get(i).getPokemonId(),
                        area.get(i).getLowestLevel(),
                        area.get(i).getHighestLevel());
            }
        }
        return null;
    }

}
