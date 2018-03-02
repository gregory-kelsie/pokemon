package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-23.
 */

public class UnionCave1F extends Route {
    public UnionCave1F() {
            super(Route.UNION_CAVE_1F, "simulator/routes/unioncave.png",
            "Union Cave 1F", "battle/cave.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 4, 4, 10));
        grassPokemon.add(new RoutePokemon(PokemonId.SANDSHREW.getValue(), 6, 6, 40));
        grassPokemon.add(new RoutePokemon(PokemonId.ZUBAT.getValue(), 5, 7, 65));
        grassPokemon.add(new RoutePokemon(PokemonId.GEODUDE.getValue(), 6, 6, 95));
        grassPokemon.add(new RoutePokemon(PokemonId.ONIX.getValue(), 6, 6, 100));
    }

    public boolean isAvailable(Player p) {
        if (p.getJohtoBadges() >= 1) {
            return true;
        } return false;
    }

}
