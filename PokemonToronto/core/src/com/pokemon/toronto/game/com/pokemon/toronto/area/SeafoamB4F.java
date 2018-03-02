package com.pokemon.toronto.game.com.pokemon.toronto.area;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-22.
 */

public class SeafoamB4F extends Route {
    public SeafoamB4F() {
        super(Route.SEAFOAM_B4F, "simulator/routes/seafoam.png",
                "Seafoam Islands B4F", "battle/ice.png", "battle/cavewater.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.SEEL.getValue(), 30, 34, 50));
        grassPokemon.add(new RoutePokemon(PokemonId.GOLBAT.getValue(), 26, 30, 65));
        grassPokemon.add(new RoutePokemon(PokemonId.GOLDUCK.getValue(), 32, 34, 73));
        grassPokemon.add(new RoutePokemon(PokemonId.SLOWBRO.getValue(), 32, 34, 80));
        grassPokemon.add(new RoutePokemon(PokemonId.PSYDUCK.getValue(), 32, 32, 85));
        grassPokemon.add(new RoutePokemon(PokemonId.SLOWPOKE.getValue(), 32, 32, 90));
        grassPokemon.add(new RoutePokemon(PokemonId.DEWGONG.getValue(), 34, 36, 100));
    }

    @Override
    protected void initSurfPokemon() {
        surfPokemon = new ArrayList<RoutePokemon>();
        surfPokemon.add(new RoutePokemon(PokemonId.SEEL.getValue(), 25, 35, 60));
        surfPokemon.add(new RoutePokemon(PokemonId.HORSEA.getValue(), 25, 30, 75));
        surfPokemon.add(new RoutePokemon(PokemonId.KRABBY.getValue(), 25, 30, 90));
        surfPokemon.add(new RoutePokemon(PokemonId.DEWGONG.getValue(), 35, 40, 95));
        surfPokemon.add(new RoutePokemon(PokemonId.SLOWPOKE.getValue(), 30, 40, 97));
        surfPokemon.add(new RoutePokemon(PokemonId.PSYDUCK.getValue(), 30, 40, 99));
        surfPokemon.add(new RoutePokemon(PokemonId.GOLDUCK.getValue(), 35, 40, 99.5));
        surfPokemon.add(new RoutePokemon(PokemonId.SLOWBRO.getValue(), 35, 40, 100));
    }

    @Override
    protected void initRodPokemon() {
        fishingPokemon = new ArrayList<RoutePokemon>();
        fishingPokemon.add(new RoutePokemon(PokemonId.HORSEA.getValue(), 15, 30, 40));
        fishingPokemon.add(new RoutePokemon(PokemonId.KRABBY.getValue(), 15, 30, 80));
        fishingPokemon.add(new RoutePokemon(PokemonId.GYARADOS.getValue(), 15, 35, 96));
        fishingPokemon.add(new RoutePokemon(PokemonId.SLOWPOKE.getValue(), 15, 25, 98));
        fishingPokemon.add(new RoutePokemon(PokemonId.PSYDUCK.getValue(), 15, 25, 100));
    }

    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 7) {
            return true;
        } else {
            return false;
        }
    }
}
