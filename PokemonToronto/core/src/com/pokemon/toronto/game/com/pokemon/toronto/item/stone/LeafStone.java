package com.pokemon.toronto.game.com.pokemon.toronto.item.stone;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemBlob;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemId;

/**
 * Created by Gregory on 8/17/2017.
 */

public class LeafStone extends Item {
    public LeafStone() {
        super(new ItemBlob.LeafStoneBlob(), "bag/icons/leafStone.png");
    }

    public void use(Pokemon p) {
        if (p.getLeafStoneEvolutionId() != -1) {
            PokemonFactory pf = new PokemonFactory();
            p = pf.createPokemon(p.getLeafStoneEvolutionId(), p);
        }
    }

    @Override
    public boolean ableToUse(Pokemon p) {
        if (p.getLeafStoneEvolutionId() != -1) {
            return true;
        }
        return false;
    }

    public int getEvolutionId(Pokemon p) {
        return p.getLeafStoneEvolutionId();
    }
}
