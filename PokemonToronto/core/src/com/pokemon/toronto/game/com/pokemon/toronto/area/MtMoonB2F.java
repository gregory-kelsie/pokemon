package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-04.
 */

public class MtMoonB2F extends Route {
    public MtMoonB2F() {
        super(Route.MT_MOON_B2F, "simulator/routes/mtmoon.png",
                "Mt Moon B2F", "battle/groundcave.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.ZUBAT.getValue(), 8, 11, 49));
        grassPokemon.add(new RoutePokemon(PokemonId.GEODUDE.getValue(), 9, 10, 79));
        grassPokemon.add(new RoutePokemon(PokemonId.PARAS.getValue(), 10, 12, 94));
        grassPokemon.add(new RoutePokemon(PokemonId.CLEFAIRY.getValue(), 10, 12, 100));
    }

    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
