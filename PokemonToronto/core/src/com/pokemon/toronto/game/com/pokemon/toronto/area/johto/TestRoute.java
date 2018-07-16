package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-04-23.
 */

public class TestRoute extends Route {
    public TestRoute() {
        super(Route.TEST_ROUTE, "simulator/routes/route.png",
                "Test Route", "battle/route.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.HYDREIGON.getValue(), 5, 5, 5));
        grassPokemon.add(new RoutePokemon(PokemonId.HEATMOR.getValue(), 5, 5, 10));
        grassPokemon.add(new RoutePokemon(PokemonId.DURANT.getValue(), 5, 5, 15));
        grassPokemon.add(new RoutePokemon(PokemonId.SERPERIOR.getValue(), 5, 5, 20));
        grassPokemon.add(new RoutePokemon(PokemonId.EMBOAR.getValue(), 5, 5, 30));
        grassPokemon.add(new RoutePokemon(PokemonId.SAMUROTT.getValue(), 5, 5, 50));
        grassPokemon.add(new RoutePokemon(PokemonId.BRAVIARY.getValue(), 5, 5, 70));
        grassPokemon.add(new RoutePokemon(PokemonId.CHANDELURE.getValue(), 5, 5, 80));
        grassPokemon.add(new RoutePokemon(PokemonId.HAXORUS.getValue(), 5, 5, 90));
        grassPokemon.add(new RoutePokemon(PokemonId.VOLCARONA.getValue(), 5, 5, 95));
        grassPokemon.add(new RoutePokemon(PokemonId.GOLURK.getValue(), 5, 5, 100));
    }


    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
