package com.pokemon.toronto.game.com.pokemon.toronto.item.stone;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemBlob;

/**
 * Created by Gregory on 11/6/2017.
 */

public class MoonStone extends Item {

    public MoonStone() {
        super(new ItemBlob.MoonStoneBlob(), "bag/icons/moonStone.png");
    }

    public void use(Pokemon p) {
        if (p.getMoonStoneEvolutionId() != -1) {
            PokemonFactory pf = new PokemonFactory();
            p = pf.createPokemon(p.getMoonStoneEvolutionId(), p);
        }
    }

    @Override
    public boolean ableToUse(Pokemon p) {
        if (p.getMoonStoneEvolutionId() != -1) {
            return true;
        }
        return false;
    }

    public int getEvolutionId(Pokemon p) {
        return p.getMoonStoneEvolutionId();
    }

}
