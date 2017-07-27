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
    private String imagePath;
    private int routeNumber;

    private boolean hasSurf;
    private boolean hasFishing;
    private boolean hasTrainers;
    private boolean hasGrass;

    private List<RoutePokemon> grassPokemon;
    private List<RoutePokemon> surfPokemon;
    private List<RoutePokemon> fishingPokemon;

    public Route(int routeNumber, String imagePath) {
        this.routeNumber = routeNumber;
        this.imagePath = imagePath;
        this.hasTrainers = true;

        RoutePokemonFactory rpc = new RoutePokemonFactory();
        grassPokemon = rpc.createRoutePokemon(routeNumber);
        surfPokemon = rpc.createSurfPokemon(routeNumber);
        fishingPokemon = rpc.createFishingPokemon(routeNumber);

        if (grassPokemon != null) {
            hasGrass = true;
        }

        if (surfPokemon != null) {
            hasSurf = true;
        }

        if (fishingPokemon != null) {
            hasFishing = true;
        }
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public boolean hasSurf() {
        return hasSurf;
    }

    public boolean hasFishing() {
        return hasFishing;
    }

    public boolean hasTrainers() {
        return hasTrainers;
    }

    public boolean hasGrass() {
        return hasGrass;
    }

    public Pokemon getAGrassPokemon() {
        if (hasGrass) {
            int num = (int) (Math.random() * 100);
            for (int i = 0; i < grassPokemon.size(); i++) {
                if (num <= grassPokemon.get(i).getRate()) {
                    WildPokemonCreator wpc = new WildPokemonCreator();
                    return wpc.createPokemon(grassPokemon.get(i).getPokemonId(),
                            grassPokemon.get(i).getLowestLevel(),
                            grassPokemon.get(i).getHighestLevel());

                }
            }
        }
        return null;
    }

    public Pokemon getASurfPokemon() {
        if (hasSurf) {
            int num = (int) (Math.random() * 100);
            for (int i = 0; i < surfPokemon.size(); i++) {
                if (num <= surfPokemon.get(i).getRate()) {
                    WildPokemonCreator wpc = new WildPokemonCreator();
                    return wpc.createPokemon(surfPokemon.get(i).getPokemonId(),
                            surfPokemon.get(i).getLowestLevel(),
                            surfPokemon.get(i).getHighestLevel());

                }
            }
        }
        return null;
    }

    public Pokemon getAFishingPokemon() {
        if (hasFishing) {
            int num = (int) (Math.random() * 100);
            for (int i = 0; i < fishingPokemon.size(); i++) {
                if (num <= fishingPokemon.get(i).getRate()) {
                    WildPokemonCreator wpc = new WildPokemonCreator();
                    return wpc.createPokemon(fishingPokemon.get(i).getPokemonId(),
                            fishingPokemon.get(i).getLowestLevel(),
                            fishingPokemon.get(i).getHighestLevel());

                }
            }
        }
        return null;
    }


}
