package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-04-29.
 */

public class CliffCave extends Route {
    public CliffCave() {
        super(Route.CLIFF_CAVE, "simulator/routes/route.png",
                "Cliff Cave", "battle/route.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();

        grassPokemon.add(new RoutePokemon(PokemonId.GOLBAT.getValue(), 22,
                22, 20));
        grassPokemon.add(new RoutePokemon(PokemonId.MACHOP.getValue(), 19,
                19, 30));
        grassPokemon.add(new RoutePokemon(PokemonId.MACHOKE.getValue(), 22,
                22, 34));
        grassPokemon.add(new RoutePokemon(PokemonId.GEODUDE.getValue(), 19,
                19, 54));
        grassPokemon.add(new RoutePokemon(PokemonId.GRAVELER.getValue(), 20,
                20, 58));
        grassPokemon.add(new RoutePokemon(PokemonId.ONIX.getValue(), 20,
                20, 68));
        grassPokemon.add(new RoutePokemon(PokemonId.KRABBY.getValue(), 20,
                20, 78));
        grassPokemon.add(new RoutePokemon(PokemonId.KINGLER.getValue(), 22,
                22, 88));
        grassPokemon.add(new RoutePokemon(PokemonId.WOOPER.getValue(), 18,
                18, 93));
        grassPokemon.add(new RoutePokemon(PokemonId.QUAGSIRE.getValue(), 20,
                20, 98));
        grassPokemon.add(new RoutePokemon(PokemonId.STEELIX.getValue(), 23,
                23, 100));

    }

    public boolean isAvailable(Player p) {
        if (p.getJohtoBadges() >= 6) {
            return true;
        } return false;
    }
}
