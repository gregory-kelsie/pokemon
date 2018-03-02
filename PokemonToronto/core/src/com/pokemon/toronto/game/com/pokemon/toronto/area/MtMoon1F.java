package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-04.
 */

public class MtMoon1F extends Route {
    public MtMoon1F() {
        super(Route.MT_MOON_1F, "simulator/routes/mtmoon.png",
                "Mt Moon 1F", "battle/groundcave.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.ZUBAT.getValue(), 7, 10, 69));
        grassPokemon.add(new RoutePokemon(PokemonId.GEODUDE.getValue(), 7, 9, 94));
        grassPokemon.add(new RoutePokemon(PokemonId.PARAS.getValue(), 8, 8, 99));
        grassPokemon.add(new RoutePokemon(PokemonId.CLEFAIRY.getValue(), 8, 8, 100));
    }

    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
