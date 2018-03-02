package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-22.
 */

public class Route23 extends Route {
    public Route23() {
        super(Route.ROUTE_23, "simulator/routes/route.png",
                "Route 23", "battle/route.png", "battle/underwater.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.SPEAROW.getValue(), 32, 34, 15));
        grassPokemon.add(new RoutePokemon(PokemonId.FEAROW.getValue(), 40, 44, 40));
        grassPokemon.add(new RoutePokemon(PokemonId.EKANS.getValue(), 32, 34, 50));
        grassPokemon.add(new RoutePokemon(PokemonId.ARBOK.getValue(), 44, 44, 52));
        grassPokemon.add(new RoutePokemon(PokemonId.SANDSHREW.getValue(), 32, 34, 62));
        grassPokemon.add(new RoutePokemon(PokemonId.SANDSLASH.getValue(), 44, 44, 65));
        grassPokemon.add(new RoutePokemon(PokemonId.MANKEY.getValue(), 32, 34, 95));
        grassPokemon.add(new RoutePokemon(PokemonId.PRIMEAPE.getValue(), 42, 42, 100));
    }

    @Override
    protected void initSurfPokemon() {
        surfPokemon = new ArrayList<RoutePokemon>();
        surfPokemon.add(new RoutePokemon(PokemonId.SLOWPOKE.getValue(), 20, 40, 50));
        surfPokemon.add(new RoutePokemon(PokemonId.PSYDUCK.getValue(), 20, 40, 100));
    }

    @Override
    protected void initRodPokemon() {
        fishingPokemon = new ArrayList<RoutePokemon>();
        fishingPokemon.add(new RoutePokemon(PokemonId.PSYDUCK.getValue(), 15, 35, 3));
        fishingPokemon.add(new RoutePokemon(PokemonId.SLOWPOKE.getValue(), 15, 35, 5));
        fishingPokemon.add(new RoutePokemon(PokemonId.POLIWAG.getValue(), 15, 25, 45));
        fishingPokemon.add(new RoutePokemon(PokemonId.POLIWHIRL.getValue(), 20, 30, 85));
        fishingPokemon.add(new RoutePokemon(PokemonId.GYARADOS.getValue(), 15, 25, 100));
    }

    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 8) {
            return true;
        } else {
            return false;
        }
    }
}
