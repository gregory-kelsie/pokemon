package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-22.
 */

public class PowerPlant extends Route {
    public PowerPlant() {
        super(Route.POWER_PLANT, "simulator/routes/powerplant.png",
                "Power Plant", "battle/indoor.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.PIKACHU.getValue(), 22, 26, 25));
        grassPokemon.add(new RoutePokemon(PokemonId.MAGNEMITE.getValue(), 22, 25, 55));
        grassPokemon.add(new RoutePokemon(PokemonId.MAGNETON.getValue(), 31, 34, 65));
        grassPokemon.add(new RoutePokemon(PokemonId.VOLTORB.getValue(), 22, 25, 94));
        grassPokemon.add(new RoutePokemon(PokemonId.ELECTRODE.getValue(), 34, 34, 95));
        grassPokemon.add(new RoutePokemon(PokemonId.ELECTABUZZ.getValue(), 32, 35, 100));
    }

    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 6) {
            return true;
        } else {
            return false;
        }
    }
}
