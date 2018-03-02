package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-22.
 */

public class PokemonMansion1F extends Route {
    public PokemonMansion1F() {
        super(Route.POKEMON_MANSION_1F, "simulator/routes/mansion.png",
                "Pokemon Mansion 1F", "battle/indoor.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 26, 28, 15));
        grassPokemon.add(new RoutePokemon(PokemonId.RATICATE.getValue(), 32, 36, 45));
        grassPokemon.add(new RoutePokemon(PokemonId.VULPIX.getValue(), 30, 32, 53));
        grassPokemon.add(new RoutePokemon(PokemonId.GROWLITHE.getValue(), 30, 32, 60));
        grassPokemon.add(new RoutePokemon(PokemonId.GRIMER.getValue(), 28, 30, 77));
        grassPokemon.add(new RoutePokemon(PokemonId.MUK.getValue(), 32, 32, 80));
        grassPokemon.add(new RoutePokemon(PokemonId.KOFFING.getValue(), 28, 30, 98));
        grassPokemon.add(new RoutePokemon(PokemonId.WEEZING.getValue(), 32, 32, 100));
    }

    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 6) {
            return true;
        } else {
            return false;
        }
    }
}
