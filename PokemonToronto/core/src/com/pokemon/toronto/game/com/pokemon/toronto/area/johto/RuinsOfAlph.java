package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-23.
 */

public class RuinsOfAlph extends Route {
    public RuinsOfAlph() {
        super(Route.RUINS_OF_ALPH, "simulator/routes/ruinsofalph.png",
                "Ruins of Alph", "battle/groundcave.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.UNOWN.getValue(), 5, 5, 100));

    }

    public boolean isAvailable(Player p) {
        if (p.getJohtoBadges() >= 1) {
            return true;
        } return false;
    }
}
