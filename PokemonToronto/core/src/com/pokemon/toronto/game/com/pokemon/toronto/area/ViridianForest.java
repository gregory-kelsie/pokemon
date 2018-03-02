package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-04.
 */

public class ViridianForest extends Route {
    public ViridianForest() {
        super(Route.VIRIDIAN_FOREST, "simulator/routes/viridianforest.png",
                "Viridian Forest", "battle/field.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.CATERPIE.getValue(), 3, 5, 40));
        grassPokemon.add(new RoutePokemon(PokemonId.WEEDLE.getValue(), 3, 5, 80));
        grassPokemon.add(new RoutePokemon(PokemonId.METAPOD.getValue(), 5, 5, 85));
        grassPokemon.add(new RoutePokemon(PokemonId.KAKUNA.getValue(), 4, 6, 95));
        grassPokemon.add(new RoutePokemon(PokemonId.PIKACHU.getValue(), 3, 5, 100));
    }

    public boolean isAvailable(Player p) {
        return true;
    }
}
