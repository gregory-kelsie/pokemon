package com.pokemon.toronto.game.com.pokemon.toronto.factory;

/**
 * Created by Gregory on 7/25/2017.
 */

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;

import java.util.ArrayList;
import java.util.List;

public class RoutePokemonFactory {

    /**
     * A factory that creates Route Pokemon from the simulator.
     */
    public RoutePokemonFactory() {}

    /**
     * Return a list of Pokemon for a route based on the routeNumber.
     * @param routeNumber The route where the RoutePokemon are found.
     * @return A list of Route Pokemon.
     */
    public List<RoutePokemon> createRoutePokemon(int routeNumber) {
        List<RoutePokemon> routePokemonList = new ArrayList<RoutePokemon>();
        if (routeNumber == Route.ROUTE_1) {
            routePokemonList.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 2, 5, 50));
            routePokemonList.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 2, 5, 100));
        } else {
            routePokemonList.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 2, 5, 50));
            routePokemonList.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 2, 5, 100));
        }
        return routePokemonList;
    }

    /**
     * Return a list of Pokemon for a route's surf based on the routeNumber.
     * @param routeNumber The route where the surf RoutePokemon are found.
     * @return A list of Route Pokemon.
     */
    public List<RoutePokemon> createSurfPokemon(int routeNumber) {
        List<RoutePokemon> surfPokemonList = new ArrayList<RoutePokemon>();
        if (routeNumber == Route.ROUTE_1) {
            return null;
        }
        return null;
    }


    /**
     * Return a list of Pokemon for a route's fishing based on the routeNumber.
     * @param routeNumber The route where the fishing RoutePokemon are found.
     * @return A list of Route Pokemon.
     */
    public List<RoutePokemon> createFishingPokemon(int routeNumber) {
        List<RoutePokemon> fishingPokemonList = new ArrayList<RoutePokemon>();
        if (routeNumber == Route.ROUTE_1) {
            return null;
        }
        return null;
    }

}
