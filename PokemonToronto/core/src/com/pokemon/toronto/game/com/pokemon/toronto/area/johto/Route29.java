package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-23.
 */

public class Route29 extends Route {
    public Route29() {
        super(Route.ROUTE_29, "simulator/routes/route.png",
                "Route 29", "battle/route.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        int hourTime = getHourTime();
        if (hourTime >= 6 && hourTime < 12) {
            //Morning
            grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 2, 4, 55));
            grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 4, 4, 60));
            grassPokemon.add(new RoutePokemon(PokemonId.SENTRET.getValue(), 2, 3, 100));
        } else if (hourTime >= 12 && hourTime <= 19) {
            //Day
            grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 2, 4, 55));
            grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 4, 4, 60));
            grassPokemon.add(new RoutePokemon(PokemonId.SENTRET.getValue(), 2, 3, 100));
        } else {
            //Night
            grassPokemon.add(new RoutePokemon(PokemonId.HOOTHOOT.getValue(), 2, 3, 85));
            grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 2, 4, 100));
        }
    }

    public boolean isAvailable(Player p) {
        return true;
    }
}
