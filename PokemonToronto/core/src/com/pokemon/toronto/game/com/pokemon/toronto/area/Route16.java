package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-05.
 */

public class Route16 extends Route {
    public Route16() {
        super(Route.ROUTE_16, "simulator/routes/route.png",
                "Route 16", "battle/route.png","battle/underwater.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.DODUO.getValue(), 18, 22, 35));
        grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 18, 22, 65));
        grassPokemon.add(new RoutePokemon(PokemonId.SPEAROW.getValue(), 20, 22, 95));
        grassPokemon.add(new RoutePokemon(PokemonId.RATICATE.getValue(), 23, 25, 100));
    }


    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() > 3) {
            return true;
        } else {
            return false;
        }
    }
}
