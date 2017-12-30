package com.pokemon.toronto.game.com.pokemon.toronto.item.stone;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemBlob;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemId;

/**
 * Created by Gregory on 8/19/2017.
 */

public class DuskStone extends Item {
    public DuskStone() {
        super(new ItemBlob.DuskStoneBlob(), "bag/icons/duskStone.png");
    }

    public String use(Pokemon p) {
        if (p.getDuskStoneEvolutionId() != -1) {
            PokemonFactory pf = new PokemonFactory();
            p = pf.createPokemon(p.getDuskStoneEvolutionId(), p);
        }
        return "";
    }

    @Override
    public boolean ableToUse(Pokemon p) {
        if (p.getDuskStoneEvolutionId() != -1) {
            return true;
        }
        return false;
    }

    public int getEvolutionId(Pokemon p) {
        return p.getDuskStoneEvolutionId();
    }
}
