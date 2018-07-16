package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-04-08.
 */

public class Route34 extends Route {
    public Route34() {
        super(Route.ROUTE_34, "simulator/routes/route.png",
                "Route 34", "battle/route.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 11, 13, 35));
        grassPokemon.add(new RoutePokemon(PokemonId.ABRA.getValue(), 10, 10, 45));
        grassPokemon.add(new RoutePokemon(PokemonId.DROWZEE.getValue(), 10, 12, 95));
        grassPokemon.add(new RoutePokemon(PokemonId.DITTO.getValue(), 10, 10, 100));

    }

    public boolean isAvailable(Player p) {
        if (p.getJohtoBadges() >= 2) {
            return true;
        } return false;
    }
}
