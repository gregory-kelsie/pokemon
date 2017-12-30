package com.pokemon.toronto.game.com.pokemon.toronto.item.stone;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemBlob;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemId;

/**
 * Created by Gregory on 8/17/2017.
 */

public class FireStone extends Item {
    public FireStone() {
        super(new ItemBlob.FireStoneBlob(), "bag/icons/fireStone.png");
    }

    public String use(Pokemon p) {
        if (p.getFireStoneEvolutionId() != -1) {
            PokemonFactory pf = new PokemonFactory();
            p = pf.createPokemon(p.getFireStoneEvolutionId(), p);
        }
        return "";
    }

    @Override
    public boolean ableToUse(Pokemon p) {
        if (p.getFireStoneEvolutionId() != -1) {
            return true;
        }
        return false;
    }

    public int getEvolutionId(Pokemon p) {
        return p.getFireStoneEvolutionId();
    }
}
