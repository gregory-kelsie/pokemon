package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-05.
 */

public class Route8 extends Route {
    public Route8() {
        super(Route.ROUTE_8, "simulator/routes/route.png",
                "Route 8", "battle/route.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 18, 20, 30));
        grassPokemon.add(new RoutePokemon(PokemonId.MEOWTH.getValue(), 18, 20, 60));
        grassPokemon.add(new RoutePokemon(PokemonId.SANDSHREW.getValue(), 17, 19, 70));
        grassPokemon.add(new RoutePokemon(PokemonId.EKANS.getValue(), 17, 19, 80));
        grassPokemon.add(new RoutePokemon(PokemonId.GROWLITHE.getValue(), 15, 18, 90));
        grassPokemon.add(new RoutePokemon(PokemonId.VULPIX.getValue(), 15, 18, 100));
    }


    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 3) {
            return true;
        } else {
            return false;
        }
    }
}
