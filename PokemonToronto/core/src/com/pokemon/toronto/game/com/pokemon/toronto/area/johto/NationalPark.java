package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-04-08.
 */

public class NationalPark extends Route {
    public NationalPark() {
        super(Route.NATIONAL_PARK, "simulator/routes/nationalpark.png",
                "National Park", "battle/route.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        int time = getTime();
        if (time == MORNING || time == DAY) {
            grassPokemon.add(new RoutePokemon(PokemonId.CATERPIE.getValue(), 10,
                    12, 15));
            grassPokemon.add(new RoutePokemon(PokemonId.WEEDLE.getValue(), 10,
                    12, 30));
            grassPokemon.add(new RoutePokemon(PokemonId.METAPOD.getValue(), 10,
                    10, 45));
            grassPokemon.add(new RoutePokemon(PokemonId.KAKUNA.getValue(), 10,
                    10, 60));
            grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 12,
                    14, 75));
            grassPokemon.add(new RoutePokemon(PokemonId.SUNKERN.getValue(), 11,
                    13, 100));
        } else if (time == DAY) {
            grassPokemon.add(new RoutePokemon(PokemonId.CATERPIE.getValue(), 10,
                    12, 25));
            grassPokemon.add(new RoutePokemon(PokemonId.WEEDLE.getValue(), 10,
                    12, 50));
            grassPokemon.add(new RoutePokemon(PokemonId.METAPOD.getValue(), 10,
                    10, 65));
            grassPokemon.add(new RoutePokemon(PokemonId.KAKUNA.getValue(), 10,
                    10, 80));
            grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 10,
                    14, 100));
        } else {
            grassPokemon.add(new RoutePokemon(PokemonId.HOOTHOOT.getValue(), 10,
                    14, 100));
        }
    }

    public boolean isAvailable(Player p) {
        if (p.getJohtoBadges() >= 3) {
            return true;
        } return false;
    }
}
