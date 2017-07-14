package com.pokemon.toronto.game.com.pokemon.toronto.factory;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Caterpie;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Eevee;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.NidoranF;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.NidoranM;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pidgey;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pikachu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
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
        if (number == 16) {
            Pidgey p = new Pidgey(5);
            return new WildPokemon(p, latitude, longitude, date, dateString);
        } else if (number == 19) {
            Rattata r = new Rattata(5);
            return new WildPokemon(r, latitude, longitude, date, dateString);
        } else if (number == 10) {
            Caterpie c = new Caterpie(5);
            return new WildPokemon(c, latitude, longitude, date, dateString);
        } else if (number == 133) {
            Eevee e = new Eevee(5);
            return new WildPokemon(e, latitude, longitude, date, dateString);
        } else if (number == 13) {
            Weedle w = new Weedle(5);
            return new WildPokemon(w, latitude, longitude, date, dateString);
        } else if (number == 32) {
            NidoranM p = new NidoranM(5);
            return new WildPokemon(p, latitude, longitude, date, dateString);
        } else if (number == 29) {
            NidoranF p = new NidoranF(5);
            return new WildPokemon(p, latitude, longitude, date, dateString);
        }
        else {
            Pikachu p = new Pikachu(5);
            return new WildPokemon(p, latitude, longitude, date, dateString);
        }
    }


}
