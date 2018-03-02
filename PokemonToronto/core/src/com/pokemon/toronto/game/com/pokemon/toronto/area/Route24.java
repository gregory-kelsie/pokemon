package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-04.
 */

public class Route24 extends Route {
    public Route24() {
        super(Route.ROUTE_24, "simulator/routes/route.png",
                "Route 24", "battle/route.png", "battle/underwater.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.CATERPIE.getValue(), 7, 7, 20));
        grassPokemon.add(new RoutePokemon(PokemonId.WEEDLE.getValue(), 7, 7, 40));
        grassPokemon.add(new RoutePokemon(PokemonId.METAPOD.getValue(), 8, 8, 42.5));
        grassPokemon.add(new RoutePokemon(PokemonId.KAKUNA.getValue(), 8,8, 45));
        grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 11, 13, 60));
        grassPokemon.add(new RoutePokemon(PokemonId.BELLSPROUT.getValue(), 12, 14, 72));
        grassPokemon.add(new RoutePokemon(PokemonId.ODDISH.getValue(), 12, 14, 85));
        grassPokemon.add(new RoutePokemon(PokemonId.ABRA.getValue(), 8, 12, 100));
    }

    @Override
    protected void initSurfPokemon() {
        surfPokemon = new ArrayList<RoutePokemon>();
        surfPokemon.add(new RoutePokemon(PokemonId.TENTACOOL.getValue(), 5, 12, 100));
    }

    @Override
    protected void initRodPokemon() {
        fishingPokemon = new ArrayList<RoutePokemon>();
        fishingPokemon.add(new RoutePokemon(PokemonId.MAGIKARP.getValue(), 5, 15, 80));
        fishingPokemon.add(new RoutePokemon(PokemonId.HORSEA.getValue(), 5, 15, 90));
        fishingPokemon.add(new RoutePokemon(PokemonId.KRABBY.getValue(), 5, 15, 100));
    }

    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() > 1) {
            return true;
        } else {
            return false;
        }
    }
}
