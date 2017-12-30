package com.pokemon.toronto.game.com.pokemon.toronto.item.stone;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemBlob;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemId;

/**
 * Created by Gregory on 8/18/2017.
 */

public class ThunderStone extends Item {
    public ThunderStone() {
        super(new ItemBlob.ThunderStoneBlob(), "bag/icons/thunderStone.png");
    }

    public String use(Pokemon p) {
        if (p.getThunderStoneEvolutionId() != -1) {
            PokemonFactory pf = new PokemonFactory();
            p = pf.createPokemon(p.getThunderStoneEvolutionId(), p);
        }
        return "";
    }

    @Override
    public boolean ableToUse(Pokemon p) {
        if (p.getThunderStoneEvolutionId() != -1) {
            return true;
        }
        return false;
    }

    public int getEvolutionId(Pokemon p) {
        return p.getThunderStoneEvolutionId();
    }
}
