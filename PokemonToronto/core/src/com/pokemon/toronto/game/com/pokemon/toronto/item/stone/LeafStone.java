package com.pokemon.toronto.game.com.pokemon.toronto.item.stone;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;

/**
 * Created by Gregory on 8/17/2017.
 */

public class LeafStone extends Item {
    public LeafStone() {
        super(20, "Leaf Stone", "A peculiar stone that can make certain species of Pokémon evolve. It has an unmistakable leaf pattern.",
                "bag/icons/leafStone.png");
    }

    public void use(Pokemon p) {
        if (p.getLeafStoneEvolutionId() != -1) {
            PokemonFactory pf = new PokemonFactory();
            p = pf.createPokemon(p.getLeafStoneEvolutionId(), p);
        }
    }
}
