package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-23.
 */

public class Route30 extends Route {
    public Route30() {
        super(Route.ROUTE_30, "simulator/routes/route.png",
                "Route 30", "battle/route.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        int hourTime = getHourTime();
        if (hourTime >= 6 && hourTime < 12) {
            //Morning
            grassPokemon.add(new RoutePokemon(PokemonId.CATERPIE.getValue(), 3, 4, 25));
            grassPokemon.add(new RoutePokemon(PokemonId.WEEDLE.getValue(), 3, 4, 50));
            grassPokemon.add(new RoutePokemon(PokemonId.METAPOD.getValue(), 4, 4, 55));
            grassPokemon.add(new RoutePokemon(PokemonId.KAKUNA.getValue(), 4, 4, 60));
            grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 3, 4, 70));
            grassPokemon.add(new RoutePokemon(PokemonId.LEDYBA.getValue(), 3, 3, 100));
        } else if (hourTime >= 12 && hourTime <= 19) {
            //Day
            grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 2, 4, 50));
            grassPokemon.add(new RoutePokemon(PokemonId.CATERPIE.getValue(), 3, 4, 67));
            grassPokemon.add(new RoutePokemon(PokemonId.WEEDLE.getValue(), 3, 4, 85));
            grassPokemon.add(new RoutePokemon(PokemonId.METAPOD.getValue(), 4, 4, 93));
            grassPokemon.add(new RoutePokemon(PokemonId.KAKUNA.getValue(), 4, 4, 100));
        } else {
            //Night
            grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 3, 4, 40));
            grassPokemon.add(new RoutePokemon(PokemonId.HOOTHOOT.getValue(), 4, 4, 70));
            grassPokemon.add(new RoutePokemon(PokemonId.SPINARAK.getValue(), 2, 2, 100));
        }
    }

    public boolean isAvailable(Player p) {
        return true;
    }
}
