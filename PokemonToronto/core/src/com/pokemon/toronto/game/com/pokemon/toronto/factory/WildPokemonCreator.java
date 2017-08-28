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
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Clefairy;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Ekans;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Oddish;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Zubat;

import java.util.Date;

/**
 * Created by Gregory on 6/11/2017.
 */
public class WildPokemonCreator {

    /**
     * Create a Wild Pokemon from either the google map or
     * a regular Pokemon.
     */
    public WildPokemonCreator() {}

    /**
     * Return a Wild Pokemon from the map.
     * @param number The Pokemon's id
     * @param latitude The latitude coordinate for the Pokemon.
     * @param longitude The longitude coordinate for the Pokemon.
     * @param date The date object for the Pokemon
     * @param dateString A formatted expiration date string to display
     *                   "yyyy/MM/dd HH:mm";
     * @return A new Wild Pokemon based on the parameters.
     */
    public WildPokemon createPokemon(int number, double latitude, double longitude,
                                     Date date, String dateString) {
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
        } else if (number == PokemonId.ZUBAT.getValue()) {
            Zubat z = new Zubat(5);
            return new WildPokemon(z, latitude, longitude, date, dateString);
        } else if (number == PokemonId.CLEFAIRY.getValue()) {
            Clefairy z = new Clefairy(5);
            return new WildPokemon(z, latitude, longitude, date, dateString);
        } else if (number == PokemonId.ODDISH.getValue()) {
            Oddish z = new Oddish(5);
            return new WildPokemon(z, latitude, longitude, date, dateString);
        } else if (number == PokemonId.EKANS.getValue()) {
            Ekans z = new Ekans(5);
            return new WildPokemon(z, latitude, longitude, date, dateString);
        } else {
            Pikachu p = new Pikachu(5);
            return new WildPokemon(p, latitude, longitude, date, dateString);
        }
    }


    /**
     * Return a Pokemon within a level range.
     * @param pokemonNumber The Pokemon's id
     * @param lowestLevel The lowest possible level for the Pokemon.
     * @param highestLevel The highest possible level for the Pokemon.
     * @return A new Pokemon within a level range.
     */
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
