package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-04.
 */

public class MtMoonB1F extends Route {
    public MtMoonB1F() {
        super(Route.MT_MOON_B1F, "simulator/routes/mtmoon.png",
                "Mt Moon B1F", "battle/groundcave.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.PARAS.getValue(), 5, 10, 100));
    }

    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
