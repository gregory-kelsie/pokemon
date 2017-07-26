package com.pokemon.toronto.game.com.pokemon.toronto.factory;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Caterpie;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Eevee;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.NidoranF;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.NidoranM;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pidgey;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pikachu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Rattata;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Weedle;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.WildPokemon;

import java.util.Date;

/**
 * Created by Gregory on 6/11/2017.
 */
public class WildPokemonCreator {
    
    public WildPokemonCreator() {

    }
    
    public WildPokemon createPokemon(int number, double latitude, double longitude, Date date, String dateString) {
        if (number == PokemonId.PIDGEY.getValue()) {
            Pidgey p = new Pidgey(5);
            return new WildPokemon(p, latitude, longitude, date, dateString);
        } else if (number == PokemonId.RATTATA.getValue()) {
            Rattata r = new Rattata(5);
            return new WildPokemon(r, latitude, longitude, date, dateString);
        } else if (number == PokemonId.CATERPIE.getValue()) {
            Caterpie c = new Caterpie(5);
            return new WildPokemon(c, latitude, longitude, date, dateString);
        } else if (number == PokemonId.EEVEE.getValue()) {
            Eevee e = new Eevee(5);
            return new WildPokemon(e, latitude, longitude, date, dateString);
        } else if (number == PokemonId.WEEDLE.getValue()) {
            Weedle w = new Weedle(5);
            return new WildPokemon(w, latitude, longitude, date, dateString);
        } else if (number == PokemonId.NIDORANM.getValue()) {
            NidoranM p = new NidoranM(5);
            return new WildPokemon(p, latitude, longitude, date, dateString);
        } else if (number == PokemonId.NIDORANF.getValue()) {
            NidoranF p = new NidoranF(5);
            return new WildPokemon(p, latitude, longitude, date, dateString);
        }
        else {
            Pikachu p = new Pikachu(5);
            return new WildPokemon(p, latitude, longitude, date, dateString);
        }
    }

    public Pokemon createPokemon(int pokemonNumber, int lowestLevel, int highestLevel) {
        int level = (int)((Math.random() * (highestLevel - lowestLevel)) + lowestLevel);
        if (pokemonNumber == PokemonId.PIDGEY.getValue()) {
            return new Pidgey(level);
        } else if (pokemonNumber == PokemonId.RATTATA.getValue()) {
            return new Rattata(level);
        } else if (pokemonNumber == PokemonId.CATERPIE.getValue()) {
            return new Caterpie(level);
        } else if (pokemonNumber == PokemonId.EEVEE.getValue()) {
            return new Eevee(level);
        } else if (pokemonNumber == PokemonId.WEEDLE.getValue()) {
            return new Weedle(level);
        } else if (pokemonNumber == PokemonId.NIDORANM.getValue()) {
            return new NidoranM(level);
        } else if (pokemonNumber == PokemonId.NIDORANF.getValue()) {
            return new NidoranF(level);
        }
        else {
            return new Pikachu(level);
        }
    }
}
