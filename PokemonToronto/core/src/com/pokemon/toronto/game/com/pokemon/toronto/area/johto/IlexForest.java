package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-04-07.
 */

public class IlexForest extends Route {
    public IlexForest() {
        super(Route.ILEX_FOREST, "simulator/routes/ilexforest.png",
                "Ilex Forest", "battle/fieldnight.png", "battle/underwater.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        int time = getTime();
        if (time == MORNING) {
            grassPokemon.add(new RoutePokemon(PokemonId.CATERPIE.getValue(), 5,
                    6, 25));
            grassPokemon.add(new RoutePokemon(PokemonId.WEEDLE.getValue(), 5,
                    6, 50));
            grassPokemon.add(new RoutePokemon(PokemonId.METAPOD.getValue(), 6,
                    6, 65));
            grassPokemon.add(new RoutePokemon(PokemonId.KAKUNA.getValue(), 6,
                    6, 80));
            grassPokemon.add(new RoutePokemon(PokemonId.ZUBAT.getValue(), 5,
                    6, 85));
            grassPokemon.add(new RoutePokemon(PokemonId.PARAS.getValue(), 5,
                    6, 100));
        } else if (time == DAY) {
            grassPokemon.add(new RoutePokemon(PokemonId.CATERPIE.getValue(), 5,
                    6, 30));
            grassPokemon.add(new RoutePokemon(PokemonId.WEEDLE.getValue(), 5,
                    6, 60));
            grassPokemon.add(new RoutePokemon(PokemonId.METAPOD.getValue(), 5,
                    6, 75));
            grassPokemon.add(new RoutePokemon(PokemonId.KAKUNA.getValue(), 5,
                    6, 90));
            grassPokemon.add(new RoutePokemon(PokemonId.ZUBAT.getValue(), 5,
                    5, 95));
            grassPokemon.add(new RoutePokemon(PokemonId.PARAS.getValue(), 6,
                    6, 100));
        } else {
            grassPokemon.add(new RoutePokemon(PokemonId.ZUBAT.getValue(), 5,
                    6, 25));
            grassPokemon.add(new RoutePokemon(PokemonId.ODDISH.getValue(), 5,
                    6, 85));
            grassPokemon.add(new RoutePokemon(PokemonId.PARAS.getValue(), 5,
                    6, 100));
        }
    }

    @Override
    protected void initSurfPokemon() {
        surfPokemon = new ArrayList<RoutePokemon>();
        surfPokemon.add(new RoutePokemon(PokemonId.PSYDUCK.getValue(), 10,
                19, 90));
        surfPokemon.add(new RoutePokemon(PokemonId.GOLDUCK.getValue(), 15,
                19, 100));
    }

    @Override
    protected void initRodPokemon() {
        fishingPokemon = new ArrayList<RoutePokemon>();
        fishingPokemon.add(new RoutePokemon(PokemonId.POLIWAG.getValue(), 10,
                10, 15));
        fishingPokemon.add(new RoutePokemon(PokemonId.MAGIKARP.getValue(), 10,
                10, 100));

    }

    public boolean isAvailable(Player p) {
        if (p.getJohtoBadges() >= 2) {
            return true;
        } return false;
    }
}
