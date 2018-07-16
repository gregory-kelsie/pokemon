package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-04-08.
 */

public class NationalPark2 extends Route {
    public NationalPark2() {
        super(Route.NATIONAL_PARK_2, "simulator/routes/nationalpark.png",
                "National Park - Bug", "battle/route.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        int time = getTime();
        grassPokemon.add(new RoutePokemon(PokemonId.CATERPIE.getValue(), 7,
                18, 20));
        grassPokemon.add(new RoutePokemon(PokemonId.WEEDLE.getValue(), 7,
                18, 40));
        grassPokemon.add(new RoutePokemon(PokemonId.METAPOD.getValue(), 9,
                18, 50));
        grassPokemon.add(new RoutePokemon(PokemonId.KAKUNA.getValue(), 9,
                18, 60));
        grassPokemon.add(new RoutePokemon(PokemonId.BUTTERFREE.getValue(), 12,
                15, 65));
        grassPokemon.add(new RoutePokemon(PokemonId.BEEDRILL.getValue(), 12,
                15, 70));
        grassPokemon.add(new RoutePokemon(PokemonId.PARAS.getValue(), 10,
                17, 80));
        grassPokemon.add(new RoutePokemon(PokemonId.VENONAT.getValue(), 10,
                16, 90));
        grassPokemon.add(new RoutePokemon(PokemonId.SCYTHER.getValue(), 13,
                14, 95));
        grassPokemon.add(new RoutePokemon(PokemonId.PINSIR.getValue(), 13,
                14, 100));

    }

    public boolean isAvailable(Player p) {
        if (p.getJohtoBadges() >= 3) {
            return true;
        } return false;
    }
}
