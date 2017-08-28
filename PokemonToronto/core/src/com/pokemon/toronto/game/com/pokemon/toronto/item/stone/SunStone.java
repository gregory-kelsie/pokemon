package com.pokemon.toronto.game.com.pokemon.toronto.item.stone;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;

/**
 * Created by Gregory on 8/18/2017.
 */

public class SunStone extends Item {
    public SunStone() {
        super(24, "Sun Stone", "A peculiar stone that can make certain species of Pokémon evolve. It burns as red as the evening sun.",
                "bag/icons/sunStone.png");
    }

    public void use(Pokemon p) {
        if (p.getSunStoneEvolutionId() != -1) {
            PokemonFactory pf = new PokemonFactory();
            p = pf.createPokemon(p.getSunStoneEvolutionId(), p);
        }
    }
}
