package com.pokemon.toronto.game.com.pokemon.toronto.item.stone;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;

/**
 * Created by Gregory on 8/19/2017.
 */

public class ShinyStone extends Item {
    public ShinyStone() {
        super(26, "Shiny Stone", "A peculiar stone that can make certain species of Pokemon evolve. It shines with a dazzling light.",
                "bag/icons/shinyStone.png");
    }

    public void use(Pokemon p) {
        if (p.getFireStoneEvolutionId() != -1) {
            PokemonFactory pf = new PokemonFactory();
            p = pf.createPokemon(p.getShinyStoneEvolutionId(), p);
        }
    }
}
