package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-05.
 */

public class DiglettCave extends Route {
    public DiglettCave() {
        super(Route.DIGLETT_CAVE, "simulator/routes/diglettcave.png",
                "Diglett Cave", "battle/groundcave.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.DIGLETT.getValue(), 15, 22, 95));
        grassPokemon.add(new RoutePokemon(PokemonId.DUGTRIO.getValue(), 29, 31, 100));
    }


    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() > 2) {
            return true;
        } else {
            return false;
        }
    }
}
