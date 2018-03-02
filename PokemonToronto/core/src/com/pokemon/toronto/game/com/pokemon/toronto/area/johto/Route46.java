package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-23.
 */

public class Route46 extends Route {
    public Route46() {
        super(Route.ROUTE_46, "simulator/routes/route.png",
                "Route 46", "battle/route.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        int hourTime = getHourTime();
        if (hourTime >= 6 && hourTime < 12) {
            //Morning
            grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 2, 2, 20));
            grassPokemon.add(new RoutePokemon(PokemonId.SPEAROW.getValue(), 2, 3, 55));
            grassPokemon.add(new RoutePokemon(PokemonId.JIGGLYPUFF.getValue(), 3, 5, 60));
            grassPokemon.add(new RoutePokemon(PokemonId.GEODUDE.getValue(), 2, 3, 100));
        } else if (hourTime >= 12 && hourTime <= 19) {
            //Day
            grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 2, 2, 20));
            grassPokemon.add(new RoutePokemon(PokemonId.SPEAROW.getValue(), 2, 3, 55));
            grassPokemon.add(new RoutePokemon(PokemonId.JIGGLYPUFF.getValue(), 3, 5, 60));
            grassPokemon.add(new RoutePokemon(PokemonId.GEODUDE.getValue(), 2, 3, 100));
        } else {
            //Night
            grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 2, 3, 50));
            grassPokemon.add(new RoutePokemon(PokemonId.JIGGLYPUFF.getValue(), 3, 5, 55));
            grassPokemon.add(new RoutePokemon(PokemonId.GEODUDE.getValue(), 2, 4, 100));
        }
    }

    public boolean isAvailable(Player p) {
        return true;
    }
}
