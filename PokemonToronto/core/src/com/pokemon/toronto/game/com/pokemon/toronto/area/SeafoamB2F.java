package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-22.
 */

public class SeafoamB2F extends Route {
    public SeafoamB2F() {
        super(Route.SEAFOAM_B2F, "simulator/routes/seafoam.png",
                "Seafoam Islands B2F", "battle/ice.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.PSYDUCK.getValue(), 30, 32, 20));
        grassPokemon.add(new RoutePokemon(PokemonId.SLOWPOKE.getValue(), 30, 32, 40));
        grassPokemon.add(new RoutePokemon(PokemonId.SEEL.getValue(), 30, 32, 60));
        grassPokemon.add(new RoutePokemon(PokemonId.ZUBAT.getValue(), 22, 24, 80));
        grassPokemon.add(new RoutePokemon(PokemonId.GOLBAT.getValue(), 26, 30, 90));
        grassPokemon.add(new RoutePokemon(PokemonId.GOLDUCK.getValue(), 32, 34, 95));
        grassPokemon.add(new RoutePokemon(PokemonId.SLOWBRO.getValue(), 32, 34, 100));
    }

    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 7) {
            return true;
        } else {
            return false;
        }
    }
}
