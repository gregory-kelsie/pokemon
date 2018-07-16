package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.factory.RouteFactory;

/**
 * Created by gregorykelsie on 2018-02-03.
 */

public class RouteStateModel {
    private Route route;
    private boolean windowState;
    private int region;
    private int currentRoute;
    
    public final static int KANTO = 0;
    public final static int JOHTO = 1;
    public final static int HOENN = 2;
    public final static int SINNOH = 3;
    public final static int UNOVA = 4;
    public final static int KALOS = 5;
    public final static int ALOLA = 6;

    private final int DEFAULT_ROUTE = 0;
    private final int NO_ROUTE = -1;

    private final boolean WINDOW_OPENED = true;
    private final boolean WINDOW_CLOSED = false;

    private final int[] kantoRouteIds = {Route.ROUTE_1, Route.ROUTE_2, Route.VIRIDIAN_FOREST, Route.ROUTE_3,
    Route.MT_MOON_1F, Route.MT_MOON_B1F, Route.MT_MOON_B2F, Route.ROUTE_4, Route.ROUTE_24, Route.ROUTE_6,
    Route.ROUTE_11, Route.DIGLETT_CAVE, Route.ROUTE_10, Route.ROCK_TUNNEL, Route.POKEMON_TOWER, Route.ROUTE_8,
    Route.ROUTE_7, Route.ROUTE_16, Route.ROUTE_12, Route.ROUTE_13, Route.ROUTE_18, Route.SAFARI_CENTER,
            Route.SAFARI_A1, Route.SAFARI_A2, Route.SAFARI_A3, Route.POWER_PLANT, Route.ROUTE_21,
            Route.POKEMON_MANSION_1F, Route.POKEMON_MANSION_B1F, Route.SEAFOAM_B2F, Route.SEAFOAM_B4F,
            Route.ROUTE_23, Route.VICTORY_ROAD_1F, Route.VICTORY_ROAD_2F};

    private final int[] johtoRouteIds = {Route.TEST_ROUTE, Route.SWAMP, Route.AFRICA, Route.JURASSIC_PARK, Route.ROUTE_29, Route.ROUTE_46, Route.ROUTE_30,
            Route.DARK_CAVE_VIOLET, Route.SPROUT_TOWER, Route.ROUTE_32, Route.RUINS_OF_ALPH,
            Route.UNION_CAVE_1F, Route.UNION_CAVE_B2F, Route.ROUTE_34, Route.ILEX_FOREST,
            Route.ROUTE_35, Route.NATIONAL_PARK, Route.NATIONAL_PARK_2, Route.ROUTE_36, Route.ROUTE_37,
    Route.ROUTE_38, Route.ROUTE_40, Route.ROUTE_41, Route.ROUTE_47, Route.CLIFF_CAVE, Route.ROUTE_48};

    public RouteStateModel() {
        region = KANTO;
        currentRoute = DEFAULT_ROUTE;
        windowState = WINDOW_CLOSED;
        RouteFactory rf = new RouteFactory();
        route = rf.createRoute(kantoRouteIds[currentRoute]);
    }

    public RouteStateModel(int region, int currentRoute) {
        this.region = region;
        this.currentRoute = currentRoute;
        windowState = WINDOW_CLOSED;
        RouteFactory rf = new RouteFactory();
        if (region == RouteStateModel.KANTO) {
            route = rf.createRoute(kantoRouteIds[currentRoute]);
        } else if (region == RouteStateModel.JOHTO) {
            route = rf.createRoute(johtoRouteIds[currentRoute]);
        }
    }

    public int getRouteNumber() {
        return currentRoute;
    }

    public int getNumRoutes() {
        if (region == RouteStateModel.JOHTO) {
            return johtoRouteIds.length;
        } else {
            return kantoRouteIds.length;
        }
    }

    public boolean isWindowOpened() {
        return windowState;
    }

    public void openWindow() {
        windowState = true;
    }

    public void closeWindow() {
        windowState = false;
    }

    public Route getRoute() {
        return route;
    }

    public int getRegion() {
        return region;
    }

    public int getNextRoute() {
        if (region == KANTO) {
            if (currentRoute == kantoRouteIds.length - 1) {
                return NO_ROUTE;
            } else {
                return kantoRouteIds[currentRoute + 1];
            }
        } else if (region == JOHTO) {
            if (currentRoute == johtoRouteIds.length - 1) {
                return NO_ROUTE;
            } else {
                return johtoRouteIds[currentRoute + 1];
            }
        }
        return NO_ROUTE;
    }

    public void setNextRoute() {
        int nextRoute = getNextRoute();
        if (nextRoute != NO_ROUTE) {
            currentRoute++;
            RouteFactory rf = new RouteFactory();
            route = rf.createRoute(nextRoute);
        }
    }

    public boolean hasNextRoute() {
        if (getNextRoute() != NO_ROUTE) {
            return true;
        }
        return false;
    }

    public void setPreviousRoute() {
        if (hasPreviousRoute()) {
            currentRoute--;
            RouteFactory rf = new RouteFactory();
            if (region == KANTO) {
                route = rf.createRoute(kantoRouteIds[currentRoute]);
            } else if (region == JOHTO) {
                route = rf.createRoute(johtoRouteIds[currentRoute]);
            }
        }
    }

    public boolean hasPreviousRoute() {
        if (currentRoute != DEFAULT_ROUTE) {
            return true;
        }
        return false;
    }

    public void setRegion(int newRegion) {
        region = newRegion;
        currentRoute = DEFAULT_ROUTE;
        RouteFactory rf = new RouteFactory();
        if (region == KANTO) {
            route = rf.createRoute(kantoRouteIds[currentRoute]);
        } else if (region == JOHTO) {
            route = rf.createRoute(johtoRouteIds[currentRoute]);
        }
    }

}
