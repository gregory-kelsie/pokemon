package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-23.
 */

public class Route32 extends Route {
    public Route32() {
        super(Route.ROUTE_32, "simulator/routes/route.png",
                "Route 32", "battle/route.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        int hourTime = getHourTime();
        if (hourTime >= 6 && hourTime < 12) {
            //Morning
            grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 6, 6, 5));
            grassPokemon.add(new RoutePokemon(PokemonId.EKANS.getValue(), 4, 4, 35));
            grassPokemon.add(new RoutePokemon(PokemonId.ZUBAT.getValue(), 4, 4, 40));
            grassPokemon.add(new RoutePokemon(PokemonId.BELLSPROUT.getValue(), 6, 6, 70));
            grassPokemon.add(new RoutePokemon(PokemonId.MAREEP.getValue(), 6, 6, 90));
            grassPokemon.add(new RoutePokemon(PokemonId.HOPPIP.getValue(), 6, 6, 100));
        } else if (hourTime >= 12 && hourTime <= 19) {
            //Day
            grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 4, 6, 10));
            grassPokemon.add(new RoutePokemon(PokemonId.EKANS.getValue(), 4, 4, 40));
            grassPokemon.add(new RoutePokemon(PokemonId.BELLSPROUT.getValue(), 6, 6, 70));
            grassPokemon.add(new RoutePokemon(PokemonId.MAREEP.getValue(), 6, 6, 90));
            grassPokemon.add(new RoutePokemon(PokemonId.HOPPIP.getValue(), 6, 6, 100));
        } else {
            //Night
            grassPokemon.add(new RoutePokemon(PokemonId.EKANS.getValue(), 4, 4, 30));
            grassPokemon.add(new RoutePokemon(PokemonId.ZUBAT.getValue(), 4, 4, 35));
            grassPokemon.add(new RoutePokemon(PokemonId.BELLSPROUT.getValue(), 6, 6, 55));
            grassPokemon.add(new RoutePokemon(PokemonId.MAREEP.getValue(), 6, 6, 65));
            grassPokemon.add(new RoutePokemon(PokemonId.WOOPER.getValue(), 6, 6, 100));
        }
    }

    public boolean isAvailable(Player p) {
        if (p.getJohtoBadges() >= 1) {
            return true;
        } return false;
    }
}
