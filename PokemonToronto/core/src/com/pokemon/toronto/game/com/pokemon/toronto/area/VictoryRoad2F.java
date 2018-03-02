package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-22.
 */

public class VictoryRoad2F extends Route {
    public VictoryRoad2F() {
        super(Route.VICTORY_ROAD_2F, "simulator/routes/victoryroad.png",
                "Victory Road 2F", "battle/groundcave.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.ARBOK.getValue(), 46, 46, 2));
        grassPokemon.add(new RoutePokemon(PokemonId.SANDSLASH.getValue(), 44, 44, 5));
        grassPokemon.add(new RoutePokemon(PokemonId.ZUBAT.getValue(), 34, 34, 15));
        grassPokemon.add(new RoutePokemon(PokemonId.GOLBAT.getValue(), 46, 46, 20));
        grassPokemon.add(new RoutePokemon(PokemonId.PRIMEAPE.getValue(), 42, 42, 30));
        grassPokemon.add(new RoutePokemon(PokemonId.MACHOP.getValue(), 34, 34, 50));
        grassPokemon.add(new RoutePokemon(PokemonId.MACHOKE.getValue(), 46, 48, 55));
        grassPokemon.add(new RoutePokemon(PokemonId.GEODUDE.getValue(), 34, 34, 75));
        grassPokemon.add(new RoutePokemon(PokemonId.ONIX.getValue(), 45, 48, 95));
        grassPokemon.add(new RoutePokemon(PokemonId.MAROWAK.getValue(), 46, 48, 100));
    }

    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 8) {
            return true;
        } else {
            return false;
        }
    }
}
