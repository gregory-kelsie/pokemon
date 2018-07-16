package com.pokemon.toronto.game.com.pokemon.toronto.area.misc;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-05-09.
 */

public class Swamp extends Route {
    public Swamp() {
        super(Route.SWAMP, "simulator/routes/route.png",
                "The Swamp", "battle/fieldnight.png", "battle/swamp.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.PARAS.getValue(), 12, 16, 20));
        grassPokemon.add(new RoutePokemon(PokemonId.FOONGUS.getValue(), 12, 16, 40));
        grassPokemon.add(new RoutePokemon(PokemonId.ZUBAT.getValue(), 12, 17, 55));
        grassPokemon.add(new RoutePokemon(PokemonId.EKANS.getValue(), 12, 18, 70));
        grassPokemon.add(new RoutePokemon(PokemonId.TANGELA.getValue(), 16, 16, 80));
        grassPokemon.add(new RoutePokemon(PokemonId.VENONAT.getValue(), 14, 16, 83));
        grassPokemon.add(new RoutePokemon(PokemonId.SEVIPER.getValue(), 17, 18, 85.5));
        grassPokemon.add(new RoutePokemon(PokemonId.ZANGOOSE.getValue(), 17, 18, 88));
        grassPokemon.add(new RoutePokemon(PokemonId.GRIMER.getValue(), 13, 16, 91));
        grassPokemon.add(new RoutePokemon(PokemonId.VENIPEDE.getValue(), 13, 15, 95.5));
        grassPokemon.add(new RoutePokemon(PokemonId.PHANTUMP.getValue(), 13, 15, 98));
        grassPokemon.add(new RoutePokemon(PokemonId.TOTODILE.getValue(), 11, 11, 99));
        grassPokemon.add(new RoutePokemon(PokemonId.FROAKIE.getValue(), 11, 11, 100));
    }

    @Override
    protected void initSurfPokemon() {
        surfPokemon = new ArrayList<RoutePokemon>();
        surfPokemon.add(new RoutePokemon(PokemonId.LOTAD.getValue(), 10, 14, 45));
        surfPokemon.add(new RoutePokemon(PokemonId.TYMPOLE.getValue(), 10, 14, 85));
        surfPokemon.add(new RoutePokemon(PokemonId.BASCULIN.getValue(), 12, 16, 93));
        surfPokemon.add(new RoutePokemon(PokemonId.LOMBRE.getValue(), 16, 18, 98));
        surfPokemon.add(new RoutePokemon(PokemonId.FROAKIE.getValue(), 12, 12, 99));
        surfPokemon.add(new RoutePokemon(PokemonId.TOTODILE.getValue(), 12, 12, 100));
    }

    @Override
    protected void initRodPokemon() {
        fishingPokemon = new ArrayList<RoutePokemon>();
        fishingPokemon.add(new RoutePokemon(PokemonId.BASCULIN.getValue(), 15, 18, 100));
    }

    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 7) {
            return true;
        } else {
            return false;
        }
    }
}
