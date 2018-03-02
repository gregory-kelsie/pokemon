package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-04.
 */

public class Route2 extends Route {
    public Route2() {
        super(Route.ROUTE_2, "simulator/routes/route.png",
                "Route 2", "battle/route.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 2, 5, 45));
        grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 2, 5, 90));
        grassPokemon.add(new RoutePokemon(PokemonId.CATERPIE.getValue(), 4, 5, 95));
        grassPokemon.add(new RoutePokemon(PokemonId.WEEDLE.getValue(), 4, 5, 100));
    }

    public boolean isAvailable(Player p) {
        return true;
    }
}
