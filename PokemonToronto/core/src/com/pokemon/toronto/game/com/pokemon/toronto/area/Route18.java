package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-22.
 */

public class Route18 extends Route {
    public Route18() {
        super(Route.ROUTE_18, "simulator/routes/route.png",
                "Route 18", "battle/route.png", "battle/underwater.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 22, 22, 5));
        grassPokemon.add(new RoutePokemon(PokemonId.RATICATE.getValue(), 25, 29, 20));
        grassPokemon.add(new RoutePokemon(PokemonId.SPEAROW.getValue(), 20, 22, 50));
        grassPokemon.add(new RoutePokemon(PokemonId.FEAROW.getValue(), 25, 29, 65));
        grassPokemon.add(new RoutePokemon(PokemonId.DODUO.getValue(), 24, 28, 100));
    }

    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 4) {
            return true;
        } else {
            return false;
        }
    }
}
