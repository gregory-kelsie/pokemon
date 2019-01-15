package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-04-29.
 */

public class Route41 extends Route {
    public Route41() {
        super(Route.ROUTE_41, "simulator/routes/route-water.png",
                "Route 41", "battle/route.png", "battle/underwater.png");
    }

    @Override
    protected void initSurfPokemon() {
        surfPokemon = new ArrayList<RoutePokemon>();
        surfPokemon.add(new RoutePokemon(PokemonId.TENTACOOL.getValue(), 15,
                24, 60));
        surfPokemon.add(new RoutePokemon(PokemonId.TENTACRUEL.getValue(), 20,
                24, 90));
        surfPokemon.add(new RoutePokemon(PokemonId.MANTINE.getValue(), 20,
                24, 100));
    }

    @Override
    protected void initRodPokemon() {
        fishingPokemon = new ArrayList<RoutePokemon>();
        int time = getTime();
        if (time == MORNING || time == DAY) {
            fishingPokemon.add(new RoutePokemon(PokemonId.KRABBY.getValue(), 15,
                    20, 55));
            fishingPokemon.add(new RoutePokemon(PokemonId.MAGIKARP.getValue(), 15,
                    20, 90));
            fishingPokemon.add(new RoutePokemon(PokemonId.CORSOLA.getValue(), 15,
                    20, 100));
        } else {
            fishingPokemon.add(new RoutePokemon(PokemonId.KRABBY.getValue(), 15,
                    20, 55));
            fishingPokemon.add(new RoutePokemon(PokemonId.MAGIKARP.getValue(), 15,
                    20, 90));
            fishingPokemon.add(new RoutePokemon(PokemonId.STARYU.getValue(), 15,
                    20, 100));
        }
    }

    public boolean isAvailable(Player p) {
        if (p.getJohtoBadges() >= 4) {
            return true;
        } return false;
    }
}
