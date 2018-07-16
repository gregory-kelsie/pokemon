package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-04-29.
 */

public class Route36 extends Route {
    public Route36() {
        super(Route.ROUTE_36, "simulator/routes/route.png",
                "Route 36", "battle/route.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        int time = getTime();
        if (time == MORNING) {
            grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 13,
                    15, 25));
            grassPokemon.add(new RoutePokemon(PokemonId.NIDORANF.getValue(), 12,
                    12, 55));
            grassPokemon.add(new RoutePokemon(PokemonId.NIDORANM.getValue(), 12,
                    12, 85));
            grassPokemon.add(new RoutePokemon(PokemonId.GROWLITHE.getValue(), 13,
                    13, 90));
            grassPokemon.add(new RoutePokemon(PokemonId.VULPIX.getValue(), 13,
                    13, 95));
            grassPokemon.add(new RoutePokemon(PokemonId.STANTLER.getValue(), 13,
                    13, 100));
        } else if (time == DAY) {
            grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 13,
                    15, 20));
            grassPokemon.add(new RoutePokemon(PokemonId.NIDORANF.getValue(), 12,
                    12, 50));
            grassPokemon.add(new RoutePokemon(PokemonId.NIDORANM.getValue(), 12,
                    12, 80));
            grassPokemon.add(new RoutePokemon(PokemonId.GROWLITHE.getValue(), 13,
                    13, 87.5));
            grassPokemon.add(new RoutePokemon(PokemonId.VULPIX.getValue(), 13,
                    13, 95));
            grassPokemon.add(new RoutePokemon(PokemonId.STANTLER.getValue(), 13,
                    13, 100));
        } else {
            grassPokemon.add(new RoutePokemon(PokemonId.HOOTHOOT.getValue(), 14,
                    14, 25));
            grassPokemon.add(new RoutePokemon(PokemonId.NIDORANF.getValue(), 12,
                    12, 55));
            grassPokemon.add(new RoutePokemon(PokemonId.NIDORANM.getValue(), 12,
                    12, 85));
            grassPokemon.add(new RoutePokemon(PokemonId.GROWLITHE.getValue(), 13,
                    13, 90));
            grassPokemon.add(new RoutePokemon(PokemonId.VULPIX.getValue(), 13,
                    13, 95));
            grassPokemon.add(new RoutePokemon(PokemonId.STANTLER.getValue(), 13,
                    13, 100));
        }
    }

    public boolean isAvailable(Player p) {
        if (p.getJohtoBadges() >= 3) {
            return true;
        } return false;
    }
}
