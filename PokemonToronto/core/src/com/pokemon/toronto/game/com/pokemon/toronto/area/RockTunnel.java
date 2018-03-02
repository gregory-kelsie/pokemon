package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-05.
 */

public class RockTunnel extends Route {
    public RockTunnel() {
        super(Route.ROCK_TUNNEL, "simulator/routes/rocktunnel.png",
                "Rock Tunnel", "battle/cave.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.GEODUDE.getValue(), 15, 17, 35));
        grassPokemon.add(new RoutePokemon(PokemonId.ZUBAT.getValue(), 15, 16, 65));
        grassPokemon.add(new RoutePokemon(PokemonId.MANKEY.getValue(), 16, 17, 80));
        grassPokemon.add(new RoutePokemon(PokemonId.MACHOP.getValue(), 16, 17, 95));
        grassPokemon.add(new RoutePokemon(PokemonId.ONIX.getValue(), 13, 15, 100));
    }


    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 3) {
            return true;
        } else {
            return false;
        }
    }
}
