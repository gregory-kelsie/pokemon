package com.pokemon.toronto.game.com.pokemon.toronto.item.stone;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;

/**
 * Created by Gregory on 8/18/2017.
 */

public class ThunderStone extends Item {
    public ThunderStone() {
        super(23, "Thunder Stone", "A peculiar stone that can make certain species of Pokémon evolve. It has a distinct thunderbolt pattern.",
                "bag/icons/thunderStone.png");
    }

    public void use(Pokemon p) {
        if (p.getThunderStoneEvolutionId() != -1) {
            PokemonFactory pf = new PokemonFactory();
            p = pf.createPokemon(p.getThunderStoneEvolutionId(), p);
        }
    }
}
