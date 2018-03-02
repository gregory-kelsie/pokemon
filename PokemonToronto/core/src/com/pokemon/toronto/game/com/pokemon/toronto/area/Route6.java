package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-04.
 */

public class Route6 extends Route {
    public Route6() {
        super(Route.ROUTE_6, "simulator/routes/route.png",
                "Route 6", "battle/route.png", "battle/underwater.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 13, 16, 40));
        grassPokemon.add(new RoutePokemon(PokemonId.MEOWTH.getValue(), 10, 16, 75));
        grassPokemon.add(new RoutePokemon(PokemonId.BELLSPROUT.getValue(), 13, 16, 87));
        grassPokemon.add(new RoutePokemon(PokemonId.ODDISH.getValue(), 13, 16, 100));
    }

    @Override
    protected void initSurfPokemon() {
        surfPokemon = new ArrayList<RoutePokemon>();
        surfPokemon.add(new RoutePokemon(PokemonId.PSYDUCK.getValue(), 13, 16, 50));
        surfPokemon.add(new RoutePokemon(PokemonId.SLOWPOKE.getValue(), 13, 16, 100));
    }

    @Override
    protected void initRodPokemon() {
        fishingPokemon = new ArrayList<RoutePokemon>();
        fishingPokemon.add(new RoutePokemon(PokemonId.POLIWAG.getValue(), 5, 15, 60));
        fishingPokemon.add(new RoutePokemon(PokemonId.GOLDEEN.getValue(), 5, 15, 80));
        fishingPokemon.add(new RoutePokemon(PokemonId.MAGIKARP.getValue(), 5, 15, 100));
    }

    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 2) {
            return true;
        } else {
            return false;
        }
    }
}
