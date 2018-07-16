package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-04-08.
 */

public class Route35 extends Route {
    public Route35() {
        super(Route.ROUTE_35, "simulator/routes/route.png",
                "Route 35", "battle/route.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        int time = getTime();
        if (time == MORNING || time == DAY) {
            grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 14,
                    14, 5));
            grassPokemon.add(new RoutePokemon(PokemonId.NIDORANF.getValue(), 12,
                    12, 35));
            grassPokemon.add(new RoutePokemon(PokemonId.NIDORANM.getValue(), 12,
                    12, 65));
            grassPokemon.add(new RoutePokemon(PokemonId.ABRA.getValue(), 10,
                    10, 75));
            grassPokemon.add(new RoutePokemon(PokemonId.DROWZEE.getValue(), 14,
                    14, 95));
            grassPokemon.add(new RoutePokemon(PokemonId.DITTO.getValue(), 10,
                    10, 99));
            grassPokemon.add(new RoutePokemon(PokemonId.YANMA.getValue(), 12,
                    12, 100));
        } else {
            grassPokemon.add(new RoutePokemon(PokemonId.HOOTHOOT.getValue(), 14,
                    14, 5));
            grassPokemon.add(new RoutePokemon(PokemonId.NIDORANF.getValue(), 12,
                    12, 35));
            grassPokemon.add(new RoutePokemon(PokemonId.NIDORANM.getValue(), 12,
                    12, 65));
            grassPokemon.add(new RoutePokemon(PokemonId.ABRA.getValue(), 10,
                    10, 75));
            grassPokemon.add(new RoutePokemon(PokemonId.DROWZEE.getValue(), 14,
                    14, 95));
            grassPokemon.add(new RoutePokemon(PokemonId.DITTO.getValue(), 10,
                    10, 99));
            grassPokemon.add(new RoutePokemon(PokemonId.YANMA.getValue(), 12,
                    12, 100));
        }
    }

    public boolean isAvailable(Player p) {
        if (p.getJohtoBadges() >= 2) {
            return true;
        } return false;
    }
}
