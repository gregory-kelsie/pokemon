package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-04-07.
 */

public class UnionCaveB2F extends Route {
    public UnionCaveB2F() {
        super(Route.UNION_CAVE_B2F, "simulator/routes/unioncave.png",
                "Union Cave B1F", "battle/cave.png", "battle/cavewater.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 20, 20, 5));
        grassPokemon.add(new RoutePokemon(PokemonId.RATICATE.getValue(), 22, 22, 35));
        grassPokemon.add(new RoutePokemon(PokemonId.ZUBAT.getValue(), 22, 22, 65));
        grassPokemon.add(new RoutePokemon(PokemonId.GOLBAT.getValue(), 22, 22, 85));
        grassPokemon.add(new RoutePokemon(PokemonId.GEODUDE.getValue(), 21, 21, 95));
        grassPokemon.add(new RoutePokemon(PokemonId.ONIX.getValue(), 23, 23, 100));
    }

    @Override
    protected void initSurfPokemon() {
        surfPokemon = new ArrayList<RoutePokemon>();
        surfPokemon.add(new RoutePokemon(PokemonId.TENTACOOL.getValue(), 15, 19, 60));
        surfPokemon.add(new RoutePokemon(PokemonId.QUAGSIRE.getValue(), 20, 24, 90));
        surfPokemon.add(new RoutePokemon(PokemonId.TENTACRUEL.getValue(), 20, 24, 99));
        surfPokemon.add(new RoutePokemon(PokemonId.LAPRAS.getValue(), 20, 20, 100));
    }

    @Override
    protected void initRodPokemon() {
        int time = getTime();
        fishingPokemon = new ArrayList<RoutePokemon>();
        if (time == MORNING || time == DAY) {
            fishingPokemon.add(new RoutePokemon(PokemonId.MAGIKARP.getValue(), 20,
                    20, 35));
            fishingPokemon.add(new RoutePokemon(PokemonId.CORSOLA.getValue(), 20,
                    20, 45));
            fishingPokemon.add(new RoutePokemon(PokemonId.KRABBY.getValue(), 20,
                    20, 100));
        } else {
            fishingPokemon.add(new RoutePokemon(PokemonId.MAGIKARP.getValue(), 20,
                    20, 35));
            fishingPokemon.add(new RoutePokemon(PokemonId.STARYU.getValue(), 20,
                    20, 45));
            fishingPokemon.add(new RoutePokemon(PokemonId.KRABBY.getValue(), 20,
                    20, 100));
        }
    }

    public boolean isAvailable(Player p) {
        if (p.getJohtoBadges() >= 2) {
            return true;
        } return false;
    }
}
