package com.pokemon.toronto.game.com.pokemon.toronto.factory;

import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;

/**
 * Created by Gregory on 7/27/2017.
 */

public class RouteFactory {
    public RouteFactory() {

    }

    public Route createRoute(int routeNumber) {
        //TODO: Create trainer class later and add them to the route.
        if (routeNumber == 1) {
            return new Route(1, "simulator/routes/route1.png");
        }
        return null;
    }
}
