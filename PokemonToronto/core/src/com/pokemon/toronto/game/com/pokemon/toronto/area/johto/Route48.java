package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-04-29.
 */

public class Route48 extends Route {
    public Route48() {
        super(Route.ROUTE_48, "simulator/routes/route.png",
                "Route 48", "battle/route.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        int time = getTime();
        if (time == DAY || time == MORNING) {
            grassPokemon.add(new RoutePokemon(PokemonId.FEAROW.getValue(), 21,
                    21, 10));
            grassPokemon.add(new RoutePokemon(PokemonId.VULPIX.getValue(), 21,
                    22, 14.5));
            grassPokemon.add(new RoutePokemon(PokemonId.GROWLITHE.getValue(), 21,
                    22, 19));
            grassPokemon.add(new RoutePokemon(PokemonId.GLOOM.getValue(), 22,
                    24, 39));
            grassPokemon.add(new RoutePokemon(PokemonId.DIGLETT.getValue(), 20,
                    20, 43));
            grassPokemon.add(new RoutePokemon(PokemonId.FARFETCHD.getValue(), 24,
                    25, 63));
            grassPokemon.add(new RoutePokemon(PokemonId.TAUROS.getValue(), 20,
                    24, 84));
            grassPokemon.add(new RoutePokemon(PokemonId.HOPPIP.getValue(), 20,
                    22, 95));
            grassPokemon.add(new RoutePokemon(PokemonId.GIRAFARIG.getValue(), 20,
                    20, 100));
        } else {
            grassPokemon.add(new RoutePokemon(PokemonId.FEAROW.getValue(), 21,
                    21, 10));
            grassPokemon.add(new RoutePokemon(PokemonId.VULPIX.getValue(), 21,
                    22, 24.5));
            grassPokemon.add(new RoutePokemon(PokemonId.GROWLITHE.getValue(), 21,
                    22, 39));
            grassPokemon.add(new RoutePokemon(PokemonId.GLOOM.getValue(), 22,
                    24, 59));
            grassPokemon.add(new RoutePokemon(PokemonId.DIGLETT.getValue(), 20,
                    20, 63));
            grassPokemon.add(new RoutePokemon(PokemonId.TAUROS.getValue(), 20,
                    24, 84));
            grassPokemon.add(new RoutePokemon(PokemonId.HOPPIP.getValue(), 20,
                    22, 95));
            grassPokemon.add(new RoutePokemon(PokemonId.GIRAFARIG.getValue(), 20,
                    20, 100));
        }
    }

    public boolean isAvailable(Player p) {
        if (p.getJohtoBadges() >= 6) {
            return true;
        } return false;
    }
}
