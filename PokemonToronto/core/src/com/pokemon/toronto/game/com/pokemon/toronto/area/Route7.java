package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-05.
 */

public class Route7 extends Route {
    public Route7() {
        super(Route.ROUTE_7, "simulator/routes/route.png",
                "Route 7", "battle/route.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.MEOWTH.getValue(), 17, 20, 40));
        grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 19, 22, 70));
        grassPokemon.add(new RoutePokemon(PokemonId.ODDISH.getValue(), 19, 22, 80));
        grassPokemon.add(new RoutePokemon(PokemonId.BELLSPROUT.getValue(), 19, 22, 90));
        grassPokemon.add(new RoutePokemon(PokemonId.GROWLITHE.getValue(), 18, 20, 95));
        grassPokemon.add(new RoutePokemon(PokemonId.VULPIX.getValue(), 18, 20, 100));
    }


    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 3) {
            return true;
        } else {
            return false;
        }
    }
}
