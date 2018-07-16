package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-04-29.
 */

public class Route47 extends Route {
    public Route47() {
        super(Route.ROUTE_47, "simulator/routes/route.png",
                "Route 47", "battle/route.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        int time = getTime();
        if (time == DAY || time == MORNING) {
            grassPokemon.add(new RoutePokemon(PokemonId.RATICATE.getValue(), 31,
                    33, 5));
            grassPokemon.add(new RoutePokemon(PokemonId.SPEAROW.getValue(), 31,
                    31, 10));
            grassPokemon.add(new RoutePokemon(PokemonId.FEAROW.getValue(), 34,
                    34, 14));
            grassPokemon.add(new RoutePokemon(PokemonId.GLOOM.getValue(), 32,
                    32, 19));
            grassPokemon.add(new RoutePokemon(PokemonId.FARFETCHD.getValue(), 35,
                    35, 39));
            grassPokemon.add(new RoutePokemon(PokemonId.DITTO.getValue(), 31,
                    40, 80));
            grassPokemon.add(new RoutePokemon(PokemonId.MILTANK.getValue(), 35,
                    35, 100));
        } else {
            grassPokemon.add(new RoutePokemon(PokemonId.RATICATE.getValue(), 31,
                    33, 5));
            grassPokemon.add(new RoutePokemon(PokemonId.SPEAROW.getValue(), 31,
                    31, 10));
            grassPokemon.add(new RoutePokemon(PokemonId.FEAROW.getValue(), 34,
                    34, 14));
            grassPokemon.add(new RoutePokemon(PokemonId.GLOOM.getValue(), 32,
                    32, 19));
            grassPokemon.add(new RoutePokemon(PokemonId.NOCTOWL.getValue(), 35,
                    35, 39));
            grassPokemon.add(new RoutePokemon(PokemonId.DITTO.getValue(), 31,
                    40, 80));
            grassPokemon.add(new RoutePokemon(PokemonId.MILTANK.getValue(), 35,
                    35, 100));
        }
    }

    @Override
    protected void initSurfPokemon() {
        surfPokemon = new ArrayList<RoutePokemon>();
        surfPokemon.add(new RoutePokemon(PokemonId.TENTACOOL.getValue(), 15,
                25, 60));
        surfPokemon.add(new RoutePokemon(PokemonId.SEEL.getValue(), 10,
                20, 90));
        surfPokemon.add(new RoutePokemon(PokemonId.STARYU.getValue(), 15,
                25, 100));
    }

    @Override
    protected void initRodPokemon() {
        fishingPokemon = new ArrayList<RoutePokemon>();
        fishingPokemon.add(new RoutePokemon(PokemonId.TENTACOOL.getValue(), 15,
                25, 30));
        fishingPokemon.add(new RoutePokemon(PokemonId.SHELLDER.getValue(), 15,
                25, 33));
        fishingPokemon.add(new RoutePokemon(PokemonId.MAGIKARP.getValue(), 15,
                25, 93));
        fishingPokemon.add(new RoutePokemon(PokemonId.CHINCHOU.getValue(), 15,
                25, 100));
    }

    public boolean isAvailable(Player p) {
        if (p.getJohtoBadges() >= 6) {
            return true;
        } return false;
    }
}
