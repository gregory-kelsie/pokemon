package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-22.
 */

public class PokemonMansionB1F extends Route {
    public PokemonMansionB1F() {
        super(Route.POKEMON_MANSION_B1F, "simulator/routes/mansion.png",
                "Pokemon Mansion B1F", "battle/indoor.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 26, 26, 5));
        grassPokemon.add(new RoutePokemon(PokemonId.RATICATE.getValue(), 34, 38, 35));
        grassPokemon.add(new RoutePokemon(PokemonId.VULPIX.getValue(), 30, 32, 43));
        grassPokemon.add(new RoutePokemon(PokemonId.GROWLITHE.getValue(), 30, 32, 50));
        grassPokemon.add(new RoutePokemon(PokemonId.GRIMER.getValue(), 28, 30, 67));
        grassPokemon.add(new RoutePokemon(PokemonId.MUK.getValue(), 34, 34, 70));
        grassPokemon.add(new RoutePokemon(PokemonId.KOFFING.getValue(), 28, 30, 88));
        grassPokemon.add(new RoutePokemon(PokemonId.WEEZING.getValue(), 34, 34, 90));
        grassPokemon.add(new RoutePokemon(PokemonId.DITTO.getValue(), 30, 30, 100));
    }

    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 6) {
            return true;
        } else {
            return false;
        }
    }
}
