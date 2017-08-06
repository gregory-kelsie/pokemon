package com.pokemon.toronto.game.com.pokemon.toronto.factory;

import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;

/**
 * Created by Gregory on 7/27/2017.
 */

public class RouteFactory {
    /**
     * Constructor
     */
    public RouteFactory() {}

    /**
     * Create a Route based on a route identification number.
     * @param routeNumber The route identification number.
     * @return A new Route
     */
    public Route createRoute(int routeNumber) {
        //TODO: Create trainer class later and add them to the route.
        if (routeNumber == 1) {
            return new Route(1, "simulator/routes/route1.png", true);
        }
        return null;
    }


    /**
     * Create a Route based on a dungeon identification number.
     * @param dungeonId The dungeon identification number.
     * @return A new Route
     */
    public Route createDungeon(int dungeonId) {
        return new Route(1, "simulator/dungeons/kanto/viridian_forest.png", false);
    }
}
