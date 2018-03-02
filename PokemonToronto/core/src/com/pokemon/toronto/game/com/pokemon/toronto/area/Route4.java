package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-04.
 */

public class Route4 extends Route {
    public Route4() {
        super(Route.ROUTE_4, "simulator/routes/route.png",
                "Route 4", "battle/route.png", "battle/underwater.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 8, 12, 35));
        grassPokemon.add(new RoutePokemon(PokemonId.SPEAROW.getValue(), 8, 12, 70));
        grassPokemon.add(new RoutePokemon(PokemonId.EKANS.getValue(), 6, 12, 83));
        grassPokemon.add(new RoutePokemon(PokemonId.SANDSHREW.getValue(), 6, 12, 95));
        grassPokemon.add(new RoutePokemon(PokemonId.MANKEY.getValue(), 10, 12, 100));
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
        if (p.getKantoBadges() >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
