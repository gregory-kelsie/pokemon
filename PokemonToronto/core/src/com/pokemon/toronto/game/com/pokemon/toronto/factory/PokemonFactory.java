package com.pokemon.toronto.game.com.pokemon.toronto.factory;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Blastoise;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Charizard;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Charmeleon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Ivysaur;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Venusaur;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Wartortle;

/**
 * Created by Gregory on 8/13/2017.
 */

public class PokemonFactory {

    /**
     * Create a Pokemon Factory where it creates Pokemon from the Database
     * or from PreEvolutions
     */
    public PokemonFactory() {

    }

    /**
     * Return the Pokemon with id, id and transfer data from the preEvolution
     * to the new one.
     * @param id The id of the Pokemon being created. Ex: 2 for Ivysaur
     * @param preEvolution The pre-evolution of the Pokemon being created.
     * @return The Evolved Pokemon from the pre-evolution.
     */
    public Pokemon createPokemon(int id, Pokemon preEvolution) {
        if (id == PokemonId.IVYSAUR.getValue()) {
            return new Ivysaur(preEvolution.getLevel(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.VENUSAUR.getValue()) {
            return new Venusaur(preEvolution.getLevel(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.WARTORTLE.getValue()) {
            return new Wartortle(preEvolution.getLevel(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.BLASTOISE.getValue()) {
            return new Blastoise(preEvolution.getLevel(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.CHARMELEON.getValue()) {
            return new Charmeleon(preEvolution.getLevel(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.CHARIZARD.getValue()) {
            return new Charizard(preEvolution.getLevel(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        }
        return null;
    }

}
