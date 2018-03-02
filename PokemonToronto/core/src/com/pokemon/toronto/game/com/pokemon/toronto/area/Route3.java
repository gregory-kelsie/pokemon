package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-04.
 */

public class Route3 extends Route {
    public Route3() {
        super(Route.ROUTE_3, "simulator/routes/route.png",
                "Route 3", "battle/route.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.NIDORANF.getValue(), 6, 7, 7.5));
        grassPokemon.add(new RoutePokemon(PokemonId.NIDORANM.getValue(), 6, 7, 15));
        grassPokemon.add(new RoutePokemon(PokemonId.JIGGLYPUFF.getValue(), 3, 7, 25));
        grassPokemon.add(new RoutePokemon(PokemonId.MANKEY.getValue(), 7, 7, 35));
        grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 6, 7, 65));
        grassPokemon.add(new RoutePokemon(PokemonId.SPEAROW.getValue(), 6, 8, 100));
    }

    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
