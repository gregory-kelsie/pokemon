package com.pokemon.toronto.game.com.pokemon.toronto.item.stone;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;

/**
 * Created by Gregory on 8/18/2017.
 */

public class WaterStone extends Item {
    public WaterStone() {
        super(22, "Water Stone", "A peculiar stone that can make certain species of Pokémon evolve. It is the blue of a pool of clear water.",
                "bag/icons/waterStone.png");
    }

    public void use(Pokemon p) {
        if (p.getWaterStoneEvolutionId() != -1) {
            PokemonFactory pf = new PokemonFactory();
            p = pf.createPokemon(p.getWaterStoneEvolutionId(), p);
        }
    }
}
