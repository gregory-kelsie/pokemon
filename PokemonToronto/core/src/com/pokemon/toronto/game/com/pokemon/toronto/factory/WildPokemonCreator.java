package com.pokemon.toronto.game.com.pokemon.toronto.factory;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Blastoise;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Bulbasaur;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Caterpie;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Charizard;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Charmander;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Charmeleon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Eevee;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Ivysaur;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.NidoranF;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.NidoranM;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pidgey;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pikachu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Rattata;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Squirtle;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Venusaur;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Wartortle;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Weedle;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.WildPokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Arbok;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Beedrill;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Butterfree;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Clefable;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Clefairy;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Diglett;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Ekans;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Fearow;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Gloom;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Golbat;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Jigglypuff;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Kakuna;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Metapod;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Nidoking;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Nidoqueen;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Nidorina;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Nidorino;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Ninetales;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Oddish;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Paras;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Parasect;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Pidgeot;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Pidgeotto;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Raichu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Raticate;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Sandshrew;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Sandslash;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Spearow;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Venomoth;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Venonat;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Vileplume;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Vulpix;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Wigglytuff;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Zubat;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_two.Geodude;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_two.Onix;

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
        if (number == PokemonId.BULBASAUR.getValue()) {
            return new WildPokemon(new Bulbasaur(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.IVYSAUR.getValue()) {
            return new WildPokemon(new Ivysaur(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.VENUSAUR.getValue()) {
            return new WildPokemon(new Venusaur(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.CHARMANDER.getValue()) {
            return new WildPokemon(new Charmander(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.CHARMELEON.getValue()) {
            return new WildPokemon(new Charmeleon(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.CHARIZARD.getValue()) {
            return new WildPokemon(new Charizard(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.SQUIRTLE.getValue()) {
            return new WildPokemon(new Squirtle(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.WARTORTLE.getValue()) {
            return new WildPokemon(new Wartortle(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.BLASTOISE.getValue()) {
            return new WildPokemon(new Blastoise(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.CATERPIE.getValue()) {
            return new WildPokemon(new Caterpie(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.METAPOD.getValue()) {
            return new WildPokemon(new Metapod(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.BUTTERFREE.getValue()) {
            return new WildPokemon(new Butterfree(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.WEEDLE.getValue()) {
            return new WildPokemon(new Weedle(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.KAKUNA.getValue()) {
            return new WildPokemon(new Kakuna(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.BEEDRILL.getValue()) {
            return new WildPokemon(new Beedrill(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.PIDGEY.getValue()) {
            return new WildPokemon(new Pidgey(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.PIDGEOTTO.getValue()) {
            return new WildPokemon(new Pidgeotto(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.PIDGEOT.getValue()) {
            return new WildPokemon(new Pidgeot(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.RATTATA.getValue()) {
            return new WildPokemon(new Rattata(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.RATICATE.getValue()) {
            return new WildPokemon(new Raticate(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.SPEAROW.getValue()) {
            return new WildPokemon(new Spearow(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.FEAROW.getValue()) {
            return new WildPokemon(new Fearow(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.EKANS.getValue()) {
            return new WildPokemon(new Ekans(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.ARBOK.getValue()) {
            return new WildPokemon(new Arbok(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.PIKACHU.getValue()) {
            return new WildPokemon(new Pikachu(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.RAICHU.getValue()) {
            return new WildPokemon(new Raichu(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.SANDSHREW.getValue()) {
            return new WildPokemon(new Sandshrew(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.SANDSLASH.getValue()) {
            return new WildPokemon(new Sandslash(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.NIDORANF.getValue()) {
            return new WildPokemon(new NidoranF(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.NIDORINA.getValue()) {
            return new WildPokemon(new Nidorina(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.NIDOQUEEN.getValue()) {
            return new WildPokemon(new Nidoqueen(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.NIDORANM.getValue()) {
            return new WildPokemon(new NidoranM(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.NIDORINO.getValue()) {
            return new WildPokemon(new Nidorino(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.NIDOKING.getValue()) {
            return new WildPokemon(new Nidoking(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.CLEFAIRY.getValue()) {
            return new WildPokemon(new Clefairy(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.CLEFABLE.getValue()) {
            return new WildPokemon(new Clefable(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.VULPIX.getValue()) {
            return new WildPokemon(new Vulpix(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.NINETALES.getValue()) {
            return new WildPokemon(new Ninetales(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.JIGGLYPUFF.getValue()) {
            return new WildPokemon(new Jigglypuff(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.WIGGLYTUFF.getValue()) {
            return new WildPokemon(new Wigglytuff(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.ZUBAT.getValue()) {
            return new WildPokemon(new Zubat(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.GOLBAT.getValue()) {
            return new WildPokemon(new Golbat(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.ODDISH.getValue()) {
            return new WildPokemon(new Oddish(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.GLOOM.getValue()) {
            return new WildPokemon(new Gloom(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.VILEPLUME.getValue()) {
            return new WildPokemon(new Vileplume(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.PARAS.getValue()) {
            return new WildPokemon(new Paras(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.PARASECT.getValue()) {
            return new WildPokemon(new Parasect(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.VENONAT.getValue()) {
            return new WildPokemon(new Venonat(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.VENOMOTH.getValue()) {
            return new WildPokemon(new Venomoth(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.DIGLETT.getValue()) {
            return new WildPokemon(new Diglett(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.GEODUDE.getValue()) {
            return new WildPokemon(new Geodude(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.ONIX.getValue()) {
            return new WildPokemon(new Onix(5), latitude, longitude, date, dateString);
        } else if (number == PokemonId.EEVEE.getValue()) {
            return new WildPokemon(new Eevee(5), latitude, longitude, date, dateString);
        }
        else {
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
        } else if (pokemonNumber == PokemonId.NIDORINA.getValue()) {
            return new Nidorina(level);
        } else if (pokemonNumber == PokemonId.NIDOQUEEN.getValue()) {
            return new Nidoqueen(level);
        } else if (pokemonNumber == PokemonId.METAPOD.getValue()) {
            return new Metapod(level);
        } else if (pokemonNumber == PokemonId.KAKUNA.getValue()) {
            return new Kakuna(level);
        } else if (pokemonNumber == PokemonId.BUTTERFREE.getValue()) {
            return new Butterfree(level);
        } else if (pokemonNumber == PokemonId.BEEDRILL.getValue()) {
            return new Beedrill(level);
        } else if (pokemonNumber == PokemonId.PARASECT.getValue()) {
            return new Parasect(level);
        } else if (pokemonNumber == PokemonId.VENOMOTH.getValue()) {
            return new Venomoth(level);
        } else if (pokemonNumber == PokemonId.VENONAT.getValue()) {
            return new Venonat(level);
        } else if (pokemonNumber == PokemonId.PARAS.getValue()) {
            return new Paras(level);
        } else if (pokemonNumber == PokemonId.PIDGEOTTO.getValue()) {
            return new Pidgeotto(level);
        } else if (pokemonNumber == PokemonId.PIDGEOT.getValue()) {
            return new Pidgeot(level);
        } else if (pokemonNumber == PokemonId.ARBOK.getValue()) {
            return new Arbok(level);
        } else if (pokemonNumber == PokemonId.EKANS.getValue()) {
            return new Ekans(level);
        } else if (pokemonNumber == PokemonId.RATICATE.getValue()) {
            return new Raticate(level);
        } else if (pokemonNumber == PokemonId.SPEAROW.getValue()) {
            return new Spearow(level);
        } else if (pokemonNumber == PokemonId.FEAROW.getValue()) {
            return new Fearow(level);
        } else if (pokemonNumber == PokemonId.SANDSHREW.getValue()) {
            return new Sandshrew(level);
        } else if (pokemonNumber == PokemonId.SANDSLASH.getValue()) {
            return new Sandslash(level);
        } else if (pokemonNumber == PokemonId.DIGLETT.getValue()) {
            return new Diglett(level);
        } else if (pokemonNumber == PokemonId.PIKACHU.getValue()) {
            return new Pikachu(level);
        } else if (pokemonNumber == PokemonId.ODDISH.getValue()) {
            return new Oddish(level);
        } else if (pokemonNumber == PokemonId.GLOOM.getValue()) {
            return new Gloom(level);
        } else if (pokemonNumber == PokemonId.VILEPLUME.getValue()) {
            return new Vileplume(level);
        } else if (pokemonNumber == PokemonId.JIGGLYPUFF.getValue()) {
            return new Jigglypuff(level);
        } else if (pokemonNumber == PokemonId.WIGGLYTUFF.getValue()) {
            return new Wigglytuff(level);
        } else if (pokemonNumber == PokemonId.CLEFAIRY.getValue()) {
            return new Clefairy(level);
        } else if (pokemonNumber == PokemonId.CLEFABLE.getValue()) {
            return new Clefable(level);
        } else if (pokemonNumber == PokemonId.GEODUDE.getValue()) {
            return new Geodude(level);
        } else if (pokemonNumber == PokemonId.ONIX.getValue()) {
            return new Onix(level);
        }
        else {
            return new Pikachu(level);
        }
    }
}
