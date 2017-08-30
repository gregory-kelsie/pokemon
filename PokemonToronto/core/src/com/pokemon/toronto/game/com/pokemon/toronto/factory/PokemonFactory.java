package com.pokemon.toronto.game.com.pokemon.toronto.factory;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Blastoise;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Bulbasaur;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Caterpie;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Charizard;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Charmander;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Charmeleon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Ivysaur;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Nature;
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
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

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


    public Pokemon createPokemon(int id, int level, char gender, Nature nature, Pokemon.Ability ability, int currentHealth, int currentExp,
                                 Pokemon.Status status, int[] ivs, int[] evs, Skill firstSkill, Skill secondSkill, Skill thirdSkill, Skill fourthSkill) {
        if (id == PokemonId.BULBASAUR.getValue()) {
            return new Bulbasaur(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.IVYSAUR.getValue()) {
            return new Ivysaur(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.VENUSAUR.getValue()) {
            return new Venusaur(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CHARMANDER.getValue()) {
            return new Charmander(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CHARMELEON.getValue()) {
            return new Charmeleon(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CHARIZARD.getValue()) {
            return new Charizard(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SQUIRTLE.getValue()) {
            return new Squirtle(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.WARTORTLE.getValue()) {
            return new Wartortle(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.BLASTOISE.getValue()) {
            return new Blastoise(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CATERPIE.getValue()) {
            return new Caterpie(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.METAPOD.getValue()) {
            return new Metapod(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.BUTTERFREE.getValue()) {
            return new Butterfree(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.WEEDLE.getValue()) {
            return new Weedle(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.KAKUNA.getValue()) {
            return new Kakuna(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.BEEDRILL.getValue()) {
            return new Beedrill(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.PIDGEY.getValue()) {
            return new Pidgey(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.PIDGEOTTO.getValue()) {
            return new Pidgeotto(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.PIDGEOT.getValue()) {
            return new Pidgeot(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.RATTATA.getValue()) {
            return new Rattata(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.RATICATE.getValue()) {
            return new Raticate(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SPEAROW.getValue()) {
            return new Spearow(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.FEAROW.getValue()) {
            return new Fearow(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.EKANS.getValue()) {
            return new Ekans(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.ARBOK.getValue()) {
            return new Arbok(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.PIKACHU.getValue()) {
            return new Pikachu(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.RAICHU.getValue()) {
            return new Raichu(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SANDSHREW.getValue()) {
            return new Sandshrew(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SANDSLASH.getValue()) {
            return new Sandslash(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.NIDORANF.getValue()) {
            return new NidoranF(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.NIDORINA.getValue()) {
            return new Nidorina(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.NIDOQUEEN.getValue()) {
            return new Nidoqueen(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.NIDORANM.getValue()) {
            return new NidoranM(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.NIDORINO.getValue()) {
            return new Nidorino(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.NIDOKING.getValue()) {
            return new Nidoking(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CLEFAIRY.getValue()) {
            return new Clefairy(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CLEFABLE.getValue()) {
            return new Clefable(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.VULPIX.getValue()) {
            return new Vulpix(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.NINETALES.getValue()) {
            return new Ninetales(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.JIGGLYPUFF.getValue()) {
            return new Jigglypuff(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.WIGGLYTUFF.getValue()) {
            return new Wigglytuff(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.ZUBAT.getValue()) {
            return new Zubat(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.GOLBAT.getValue()) {
            return new Golbat(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.ODDISH.getValue()) {
            return new Oddish(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.GLOOM.getValue()) {
            return new Gloom(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.VILEPLUME.getValue()) {
            return new Vileplume(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.PARAS.getValue()) {
            return new Paras(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.PARASECT.getValue()) {
            return new Parasect(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.VENONAT.getValue()) {
            return new Venonat(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.VENOMOTH.getValue()) {
            return new Venomoth(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.DIGLETT.getValue()) {
            return new Diglett(level, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        }
        return null;
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
