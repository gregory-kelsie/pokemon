package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-22.
 */

public class SafariZoneA1 extends Route {
    public SafariZoneA1() {
        super(Route.SAFARI_A1, "simulator/routes/safarizone.png",
                "Safari Zone - A1", "battle/safari.png","battle/underwater.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.NIDORANF.getValue(), 24, 24, 5));
        grassPokemon.add(new RoutePokemon(PokemonId.NIDORANM.getValue(), 24, 24, 25));
        grassPokemon.add(new RoutePokemon(PokemonId.NIDORINA.getValue(), 33, 33, 30));
        grassPokemon.add(new RoutePokemon(PokemonId.NIDORINO.getValue(), 33, 33, 35));
        grassPokemon.add(new RoutePokemon(PokemonId.PARAS.getValue(), 22, 22, 50));
        grassPokemon.add(new RoutePokemon(PokemonId.PARASECT.getValue(), 25, 25, 55));
        grassPokemon.add(new RoutePokemon(PokemonId.DODUO.getValue(), 26, 26, 75));
        grassPokemon.add(new RoutePokemon(PokemonId.EXEGGCUTE.getValue(), 23, 25, 95));
        grassPokemon.add(new RoutePokemon(PokemonId.KANGASKHAN.getValue(), 25, 25, 99));
        grassPokemon.add(new RoutePokemon(PokemonId.SCYTHER.getValue(), 28, 28, 99.5));
        grassPokemon.add(new RoutePokemon(PokemonId.PINSIR.getValue(), 28, 28, 100));
    }

    @Override
    protected void initSurfPokemon() {
        surfPokemon = new ArrayList<RoutePokemon>();
        surfPokemon.add(new RoutePokemon(PokemonId.PSYDUCK.getValue(), 20, 40, 50));
        surfPokemon.add(new RoutePokemon(PokemonId.SLOWPOKE.getValue(), 20, 40, 100));
    }

    @Override
    protected void initRodPokemon() {
        fishingPokemon = new ArrayList<RoutePokemon>();
        fishingPokemon.add(new RoutePokemon(PokemonId.PSYDUCK.getValue(), 15, 35, 2));
        fishingPokemon.add(new RoutePokemon(PokemonId.SLOWPOKE.getValue(), 15, 35, 4));
        fishingPokemon.add(new RoutePokemon(PokemonId.GOLDEEN.getValue(), 15, 25, 44));
        fishingPokemon.add(new RoutePokemon(PokemonId.SEAKING.getValue(), 20, 30, 84));
        fishingPokemon.add(new RoutePokemon(PokemonId.DRATINI.getValue(), 15, 25, 99));
        fishingPokemon.add(new RoutePokemon(PokemonId.DRAGONAIR.getValue(), 25, 35, 100));
    }


    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 5) {
            return true;
        } else {
            return false;
        }
    }
}
