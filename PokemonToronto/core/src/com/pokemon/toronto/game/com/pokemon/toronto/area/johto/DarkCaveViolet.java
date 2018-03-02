package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-23.
 */

public class DarkCaveViolet extends Route {
    public DarkCaveViolet() {
        super(Route.DARK_CAVE_VIOLET, "simulator/routes/darkcave.png",
                "Dark Cave - Violet City", "battle/cave.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.ZUBAT.getValue(), 2, 4, 39));
        grassPokemon.add(new RoutePokemon(PokemonId.GEODUDE.getValue(), 2, 4, 99));
        grassPokemon.add(new RoutePokemon(PokemonId.DUNSPARCE.getValue(), 4, 4, 100));
    }

    public boolean isAvailable(Player p) {
        return true;
    }
}
