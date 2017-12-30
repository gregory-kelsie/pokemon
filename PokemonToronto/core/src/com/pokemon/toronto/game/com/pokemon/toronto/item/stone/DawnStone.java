package com.pokemon.toronto.game.com.pokemon.toronto.item.stone;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemBlob;

/**
 * Created by Gregory on 11/6/2017.
 */

public class DawnStone extends Item {
    public DawnStone() {
        super(new ItemBlob.DawnStoneBlob(), "bag/icons/dawnStone.png");
    }

    public String use(Pokemon p) {
        if (p.getDawnStoneEvolutionId() != -1) {
            PokemonFactory pf = new PokemonFactory();
            p = pf.createPokemon(p.getDawnStoneEvolutionId(), p);

        }
        return "";
    }

    @Override
    public boolean ableToUse(Pokemon p) {
        if (p.getDawnStoneEvolutionId() != -1) {
            return true;
        }
        return false;
    }

    public int getEvolutionId(Pokemon p) {
        return p.getDawnStoneEvolutionId();
    }
}
