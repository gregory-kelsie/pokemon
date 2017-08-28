package com.pokemon.toronto.game.com.pokemon.toronto.item.stone;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;

/**
 * Created by Gregory on 8/17/2017.
 */

public class FireStone extends Item {
    public FireStone() {
        super(21, "Fire Stone", "A peculiar stone that can make certain species of Pokémon evolve. The stone has a fiery orange heart.",
                "bag/icons/fireStone.png");
    }

    public void use(Pokemon p) {
        if (p.getFireStoneEvolutionId() != -1) {
            PokemonFactory pf = new PokemonFactory();
            p = pf.createPokemon(p.getFireStoneEvolutionId(), p);
        }
    }
}
