package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-22.
 */

public class Route12 extends Route {
    public Route12() {
        super(Route.ROUTE_12, "simulator/routes/route.png",
                "Route 12", "battle/route.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.ODDISH.getValue(), 22, 26, 18));
        grassPokemon.add(new RoutePokemon(PokemonId.BELLSPROUT.getValue(), 22, 26, 35));
        grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 23, 27, 65));
        grassPokemon.add(new RoutePokemon(PokemonId.VENONAT.getValue(), 24, 26, 95));
        grassPokemon.add(new RoutePokemon(PokemonId.GLOOM.getValue(), 28, 30, 98));
        grassPokemon.add(new RoutePokemon(PokemonId.WEEPINBELL.getValue(), 28, 30, 100));
    }

    @Override
    protected void initSurfPokemon() {
        surfPokemon = new ArrayList<RoutePokemon>();
        surfPokemon.add(new RoutePokemon(PokemonId.TENTACOOL.getValue(), 5, 40, 100));
    }

    @Override
    protected void initRodPokemon() {
        fishingPokemon = new ArrayList<RoutePokemon>();
        fishingPokemon.add(new RoutePokemon(PokemonId.HORSEA.getValue(), 15, 35, 42));
        fishingPokemon.add(new RoutePokemon(PokemonId.KRABBY.getValue(), 15, 35, 84));
        fishingPokemon.add(new RoutePokemon(PokemonId.GYARADOS.getValue(), 15, 25, 98));
        fishingPokemon.add(new RoutePokemon(PokemonId.PSYDUCK.getValue(), 25, 35, 99));
        fishingPokemon.add(new RoutePokemon(PokemonId.SLOWPOKE.getValue(), 25, 35, 100));
    }


    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 4) {
            return true;
        } else {
            return false;
        }
    }
}
