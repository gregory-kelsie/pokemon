package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-04-29.
 */

public class Route37 extends Route {
    public Route37() {
        super(Route.ROUTE_37, "simulator/routes/route.png",
                "Route 37", "battle/route.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        int time = getTime();
        if (time == MORNING) {
            grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 13,
                    15, 20));
            grassPokemon.add(new RoutePokemon(PokemonId.VULPIX.getValue(), 13,
                    13, 25));
            grassPokemon.add(new RoutePokemon(PokemonId.GROWLITHE.getValue(), 13,
                    13, 30));
            grassPokemon.add(new RoutePokemon(PokemonId.LEDYBA.getValue(), 13,
                    15, 70));
            grassPokemon.add(new RoutePokemon(PokemonId.STANTLER.getValue(), 15,
                    15, 100));
        } else if (time == DAY) {
            grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 13,
                    15, 50));
            grassPokemon.add(new RoutePokemon(PokemonId.PIDGEOTTO.getValue(), 15,
                    15, 55));
            grassPokemon.add(new RoutePokemon(PokemonId.VULPIX.getValue(), 14,
                    16, 62.5));
            grassPokemon.add(new RoutePokemon(PokemonId.GROWLITHE.getValue(), 14,
                    16, 70));
            grassPokemon.add(new RoutePokemon(PokemonId.STANTLER.getValue(), 15,
                    15, 100));
        } else {
            grassPokemon.add(new RoutePokemon(PokemonId.GROWLITHE.getValue(), 14,
                    14, 5));
            grassPokemon.add(new RoutePokemon(PokemonId.VULPIX.getValue(), 14,
                    14, 10));
            grassPokemon.add(new RoutePokemon(PokemonId.HOOTHOOT.getValue(), 15,
                    15, 30));
            grassPokemon.add(new RoutePokemon(PokemonId.SPINARAK.getValue(), 13,
                    15, 70));
            grassPokemon.add(new RoutePokemon(PokemonId.STANTLER.getValue(), 15,
                    15, 100));
        }
    }

    public boolean isAvailable(Player p) {
        if (p.getJohtoBadges() >= 3) {
            return true;
        } return false;
    }
}
