package com.pokemon.toronto.game.com.pokemon.toronto.area.misc;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-05-10.
 */

public class Africa extends Route {
    public Africa() {
        super(Route.AFRICA, "simulator/routes/route.png",
                "Africa Safari", "battle/wasteland.png", "battle/swamp.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        grassPokemon.add(new RoutePokemon(PokemonId.YUNGOOS.getValue(), 12, 16, 20));
        grassPokemon.add(new RoutePokemon(PokemonId.BLITZLE.getValue(), 12, 16, 40));
        grassPokemon.add(new RoutePokemon(PokemonId.POOCHYENA.getValue(), 12, 17, 55));
        grassPokemon.add(new RoutePokemon(PokemonId.GIRAFARIG.getValue(), 12, 18, 65));
        grassPokemon.add(new RoutePokemon(PokemonId.PHANPY.getValue(), 16, 16, 75));
        grassPokemon.add(new RoutePokemon(PokemonId.TAUROS.getValue(), 17, 18, 79));
        grassPokemon.add(new RoutePokemon(PokemonId.VULLABY.getValue(), 13, 16, 84));
        grassPokemon.add(new RoutePokemon(PokemonId.RHYHORN.getValue(), 13, 15, 89));
        grassPokemon.add(new RoutePokemon(PokemonId.LITLEO.getValue(), 13, 15, 94));
        grassPokemon.add(new RoutePokemon(PokemonId.HIPPOPOTAS.getValue(), 11, 11, 99));
        grassPokemon.add(new RoutePokemon(PokemonId.BOUFFALANT.getValue(), 11, 11, 100));
    }

    public boolean isAvailable(Player p) {
        if (p.getKantoBadges() >= 7) {
            return true;
        } else {
            return false;
        }
    }
}
