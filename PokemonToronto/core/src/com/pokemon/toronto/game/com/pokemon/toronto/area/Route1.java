package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-02-03.
 */

public class Route1 extends Route {
    public Route1() {
        super(Route.ROUTE_1, "simulator/routes/route.png", "Route 1", "battle/route.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 2, 5, 50));
        grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 2, 5, 100));
    }

    public boolean isAvailable(Player p) {
        return true;
    }
}
