package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-04-29.
 */

public class Route38 extends Route {
    public Route38() {
        super(Route.ROUTE_38, "simulator/routes/route.png",
                "Route 38", "battle/safari.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        int time = getTime();
        if (time == MORNING || time == DAY) {
            grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 16,
                    16, 15));
            grassPokemon.add(new RoutePokemon(PokemonId.MEOWTH.getValue(), 16,
                    16, 30));
            grassPokemon.add(new RoutePokemon(PokemonId.RATICATE.getValue(), 16,
                    16, 60));
            grassPokemon.add(new RoutePokemon(PokemonId.MAGNEMITE.getValue(), 16,
                    16, 80));
            grassPokemon.add(new RoutePokemon(PokemonId.FARFETCHD.getValue(), 16,
                    16, 90));
            grassPokemon.add(new RoutePokemon(PokemonId.TAUROS.getValue(), 13,
                    13, 94));
            grassPokemon.add(new RoutePokemon(PokemonId.SNUBBULL.getValue(), 13,
                    13, 95));
            grassPokemon.add(new RoutePokemon(PokemonId.MILTANK.getValue(), 13,
                    13, 100));
        } else {
            grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 16,
                    16, 20));
            grassPokemon.add(new RoutePokemon(PokemonId.MEOWTH.getValue(), 16,
                    16, 40));
            grassPokemon.add(new RoutePokemon(PokemonId.RATICATE.getValue(), 16,
                    16, 70));
            grassPokemon.add(new RoutePokemon(PokemonId.MAGNEMITE.getValue(), 16,
                    16, 90));
            grassPokemon.add(new RoutePokemon(PokemonId.TAUROS.getValue(), 13,
                    13, 94));
            grassPokemon.add(new RoutePokemon(PokemonId.SNUBBULL.getValue(), 13,
                    13, 95));
            grassPokemon.add(new RoutePokemon(PokemonId.MILTANK.getValue(), 13,
                    13, 100));
        }
    }

    public boolean isAvailable(Player p) {
        if (p.getJohtoBadges() >= 4) {
            return true;
        } return false;
    }
}
