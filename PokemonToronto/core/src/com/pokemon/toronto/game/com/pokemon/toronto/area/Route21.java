package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-22.
 */

public class Route21 extends Route {
    public Route21() {
        super(Route.ROUTE_21, "simulator/routes/route-water.png",
                "Route 21", "battle/field.png","battle/underwater.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.TANGELA.getValue(), 17, 28, 100));
    }

    @Override
    protected void initSurfPokemon() {
        surfPokemon = new ArrayList<RoutePokemon>();
        surfPokemon.add(new RoutePokemon(PokemonId.TENTACOOL.getValue(), 5, 40, 100));
    }

    @Override
    protected void initRodPokemon() {
        fishingPokemon = new ArrayList<RoutePokemon>();
        fishingPokemon.add(new RoutePokemon(PokemonId.HORSEA.getValue(), 15, 25, 40));
        fishingPokemon.add(new RoutePokemon(PokemonId.SEADRA.getValue(), 25, 35, 42));
        fishingPokemon.add(new RoutePokemon(PokemonId.KRABBY.getValue(), 15, 25, 82));
        fishingPokemon.add(new RoutePokemon(PokemonId.KINGLER.getValue(), 25, 35, 84));
        fishingPokemon.add(new RoutePokemon(PokemonId.GYARADOS.getValue(), 15, 25, 98));
        fishingPokemon.add(new RoutePokemon(PokemonId.PSYDUCK.getValue(), 25, 35, 99));
        fishingPokemon.add(new RoutePokemon(PokemonId.SLOWPOKE.getValue(), 25, 35, 100));
    }


    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 6) {
            return true;
        } else {
            return false;
        }
    }
}
