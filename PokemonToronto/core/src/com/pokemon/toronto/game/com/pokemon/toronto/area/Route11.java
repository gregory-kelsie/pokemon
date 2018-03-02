package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-05.
 */

public class Route11 extends Route {
    public Route11() {
        super(Route.ROUTE_11, "simulator/routes/route.png",
                "Route 11", "battle/route.png", "battle/underwater.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.SPEAROW.getValue(), 13, 17, 35));
        grassPokemon.add(new RoutePokemon(PokemonId.EKANS.getValue(), 12, 15, 55));
        grassPokemon.add(new RoutePokemon(PokemonId.SANDSHREW.getValue(), 12, 15, 75));
        grassPokemon.add(new RoutePokemon(PokemonId.DROWZEE.getValue(), 11, 15, 100));
    }

    @Override
    protected void initSurfPokemon() {
        surfPokemon = new ArrayList<RoutePokemon>();
        surfPokemon.add(new RoutePokemon(PokemonId.TENTACOOL.getValue(), 5, 17, 100));
    }

    @Override
    protected void initRodPokemon() {
        fishingPokemon = new ArrayList<RoutePokemon>();
        fishingPokemon.add(new RoutePokemon(PokemonId.MAGIKARP.getValue(), 5, 15, 60));
        fishingPokemon.add(new RoutePokemon(PokemonId.HORSEA.getValue(), 5, 15, 80));
        fishingPokemon.add(new RoutePokemon(PokemonId.KRABBY.getValue(), 5, 15, 100));
    }


    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 2) {
            return true;
        } else {
            return false;
        }
    }
}
