package com.pokemon.toronto.game.com.pokemon.toronto.factory;

/**
 * Created by Gregory on 7/25/2017.
 */

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;

import java.util.ArrayList;
import java.util.List;

public class RoutePokemonFactory {

    public RoutePokemonFactory() {

    }

    public List<RoutePokemon> createRoutePokemon(int routeNumber) {
        List<RoutePokemon> routePokemonList = new ArrayList<RoutePokemon>();
        if (routeNumber == 1) {
            routePokemonList.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 2, 5, 50));
            routePokemonList.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 2, 5, 100));
        } else {
            routePokemonList.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 2, 5, 50));
            routePokemonList.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 2, 5, 100));
        }
        return routePokemonList;
    }

    public List<RoutePokemon> createRouteDungeonPokemon(int dungeonId) {
        List<RoutePokemon> dungeonPokemonList = new ArrayList<RoutePokemon>();
        if (dungeonId == 1) {
            dungeonPokemonList.add(new RoutePokemon(PokemonId.CATERPIE.getValue(), 3, 5, 48));
            dungeonPokemonList.add(new RoutePokemon(PokemonId.WEEDLE.getValue(), 3, 5, 95));
            dungeonPokemonList.add(new RoutePokemon(PokemonId.PIKACHU.getValue(), 3, 5, 100));
        } else {
            dungeonPokemonList.add(new RoutePokemon(PokemonId.CATERPIE.getValue(), 3, 5, 48));
            dungeonPokemonList.add(new RoutePokemon(PokemonId.WEEDLE.getValue(), 3, 5, 95));
            dungeonPokemonList.add(new RoutePokemon(PokemonId.PIKACHU.getValue(), 3, 5, 100));
        }
        return dungeonPokemonList;
    }

    public List<RoutePokemon> createSurfPokemon(int routeNumber) {
        List<RoutePokemon> surfPokemonList = new ArrayList<RoutePokemon>();
        if (routeNumber == 1) {
            return null;
        }
        return null;
    }

    public List<RoutePokemon> createFishingPokemon(int routeNumber) {
        List<RoutePokemon> fishingPokemonList = new ArrayList<RoutePokemon>();
        if (routeNumber == 1) {
            return null;
        }
        return null;
    }

}
