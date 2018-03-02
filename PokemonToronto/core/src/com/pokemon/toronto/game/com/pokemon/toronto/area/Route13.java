package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-22.
 */

public class Route13 extends Route {
    public Route13() {
        super(Route.ROUTE_13, "simulator/routes/route.png",
                "Route 13", "battle/route.png","battle/underwater.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.PIDGEY.getValue(), 25, 27, 20));
        grassPokemon.add(new RoutePokemon(PokemonId.PIDGEOTTO.getValue(), 29, 29, 25));
        grassPokemon.add(new RoutePokemon(PokemonId.ODDISH.getValue(), 22, 26, 43));
        grassPokemon.add(new RoutePokemon(PokemonId.BELLSPROUT.getValue(), 22, 26, 60));
        grassPokemon.add(new RoutePokemon(PokemonId.GLOOM.getValue(), 28, 30, 63));
        grassPokemon.add(new RoutePokemon(PokemonId.WEEPINBELL.getValue(), 28, 30, 65));
        grassPokemon.add(new RoutePokemon(PokemonId.VENONAT.getValue(), 24, 26, 95));
        grassPokemon.add(new RoutePokemon(PokemonId.DITTO.getValue(), 25, 25, 100));
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
