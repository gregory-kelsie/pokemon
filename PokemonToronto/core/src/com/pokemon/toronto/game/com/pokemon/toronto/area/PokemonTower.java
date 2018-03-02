package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-05.
 */

public class PokemonTower extends Route {
    public PokemonTower() {
        super(Route.POKEMON_TOWER, "simulator/routes/pokemontower.png",
                "Pokemon Tower", "battle/indoor.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.GASTLY.getValue(), 14, 19, 81));
        grassPokemon.add(new RoutePokemon(PokemonId.CUBONE.getValue(), 17, 19, 90));
        grassPokemon.add(new RoutePokemon(PokemonId.HAUNTER.getValue(), 21, 23, 100));
    }


    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 3) {
            return true;
        } else {
            return false;
        }
    }
}
