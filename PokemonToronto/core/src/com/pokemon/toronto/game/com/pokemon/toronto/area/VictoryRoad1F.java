package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-22.
 */

public class VictoryRoad1F extends Route {
    public VictoryRoad1F() {
        super(Route.VICTORY_ROAD_1F, "simulator/routes/victoryroad.png",
                "Victory Road 1F", "battle/groundcave.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.ARBOK.getValue(), 44, 44, 2));
        grassPokemon.add(new RoutePokemon(PokemonId.SANDSLASH.getValue(), 44, 44, 5));
        grassPokemon.add(new RoutePokemon(PokemonId.ZUBAT.getValue(), 32, 32, 15));
        grassPokemon.add(new RoutePokemon(PokemonId.GOLBAT.getValue(), 44, 44, 20));
        grassPokemon.add(new RoutePokemon(PokemonId.MACHOP.getValue(), 32, 32, 40));
        grassPokemon.add(new RoutePokemon(PokemonId.MACHOKE.getValue(), 44, 46, 45));
        grassPokemon.add(new RoutePokemon(PokemonId.GEODUDE.getValue(), 32, 32, 65));
        grassPokemon.add(new RoutePokemon(PokemonId.ONIX.getValue(), 40, 46, 95));
        grassPokemon.add(new RoutePokemon(PokemonId.MAROWAK.getValue(), 44, 46, 100));
    }

    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 8) {
            return true;
        } else {
            return false;
        }
    }
}
