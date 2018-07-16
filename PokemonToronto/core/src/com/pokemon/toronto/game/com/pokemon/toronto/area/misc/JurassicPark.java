package com.pokemon.toronto.game.com.pokemon.toronto.area.misc;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-05-10.
 */

public class JurassicPark extends Route {
    public JurassicPark() {
        super(Route.JURASSIC_PARK, "simulator/routes/route.png",
                "Jurassic Park", "battle/fieldmorning.png", "battle/swamp.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.YANMA.getValue(), 12, 16, 25));
        grassPokemon.add(new RoutePokemon(PokemonId.TROPIUS.getValue(), 12, 16, 45));
        grassPokemon.add(new RoutePokemon(PokemonId.HELIOPTILE.getValue(), 12, 17, 65));
        grassPokemon.add(new RoutePokemon(PokemonId.CARNIVINE.getValue(), 13, 15, 75));
        grassPokemon.add(new RoutePokemon(PokemonId.CHATOT.getValue(), 12, 18, 80));
        grassPokemon.add(new RoutePokemon(PokemonId.CRANIDOS.getValue(), 16, 16, 90));
        grassPokemon.add(new RoutePokemon(PokemonId.TYRUNT.getValue(), 17, 18, 98));
        grassPokemon.add(new RoutePokemon(PokemonId.BULBASAUR.getValue(), 13, 16, 99));
        grassPokemon.add(new RoutePokemon(PokemonId.TURTWIG.getValue(), 11, 11, 100));
    }

    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 7) {
            return true;
        } else {
            return false;
        }
    }
}
