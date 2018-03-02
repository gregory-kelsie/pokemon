package com.pokemon.toronto.game.com.pokemon.toronto.area.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.RoutePokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;

import java.util.ArrayList;

/**
 * Created by gregorykelsie on 2018-02-23.
 */

public class SproutTower extends Route {
    public SproutTower() {
        super(Route.SPROUT_TOWER, "simulator/routes/sprouttower.png",
                "Sprout Tower", "battle/indoor.png");
    }

    @Override
    protected void initGrassPokemon() {
        grassPokemon = new ArrayList<RoutePokemon>();
        int hourTime = getHourTime();
        if (hourTime >= 6 && hourTime < 12) {
            //Morning
            grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 3, 6, 100));
        } else if (hourTime >= 12 && hourTime <= 19) {
            //Day
            grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 3, 6, 100));
        } else {
            //Night
            grassPokemon.add(new RoutePokemon(PokemonId.RATTATA.getValue(), 3, 5, 15));
            grassPokemon.add(new RoutePokemon(PokemonId.GASTLY.getValue(), 3, 6, 100));
        }
    }

    public boolean isAvailable(Player p) {
        return true;
    }
}
