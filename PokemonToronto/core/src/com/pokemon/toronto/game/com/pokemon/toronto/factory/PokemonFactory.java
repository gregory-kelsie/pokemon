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

    private final boolean PREEVOLUTION = true;
    private final boolean DATABASE = false;
    public PokemonFactory() {

    }


    public Pokemon createPokemon(int id, int level, char gender, Nature nature, Pokemon.Ability ability, int currentHealth, int currentExp,
                                 Pokemon.Status status, int[] ivs, int[] evs, Skill firstSkill, Skill secondSkill, Skill thirdSkill, Skill fourthSkill) {
        if (id == PokemonId.BULBASAUR.getValue()) {
            return new Bulbasaur(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.IVYSAUR.getValue()) {
            return new Ivysaur(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.VENUSAUR.getValue()) {
            return new Venusaur(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CHARMANDER.getValue()) {
            return new Charmander(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CHARMELEON.getValue()) {
            return new Charmeleon(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CHARIZARD.getValue()) {
            return new Charizard(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SQUIRTLE.getValue()) {
            return new Squirtle(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.WARTORTLE.getValue()) {
            return new Wartortle(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.BLASTOISE.getValue()) {
            return new Blastoise(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CATERPIE.getValue()) {
            return new Caterpie(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.METAPOD.getValue()) {
            return new Metapod(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.BUTTERFREE.getValue()) {
            return new Butterfree(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.WEEDLE.getValue()) {
            return new Weedle(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.KAKUNA.getValue()) {
            return new Kakuna(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.BEEDRILL.getValue()) {
            return new Beedrill(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.PIDGEY.getValue()) {
            return new Pidgey(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.PIDGEOTTO.getValue()) {
            return new Pidgeotto(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.PIDGEOT.getValue()) {
            return new Pidgeot(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.RATTATA.getValue()) {
            return new Rattata(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.RATICATE.getValue()) {
            return new Raticate(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SPEAROW.getValue()) {
            return new Spearow(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.FEAROW.getValue()) {
            return new Fearow(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.EKANS.getValue()) {
            return new Ekans(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.ARBOK.getValue()) {
            return new Arbok(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.PIKACHU.getValue()) {
            return new Pikachu(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.RAICHU.getValue()) {
            return new Raichu(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SANDSHREW.getValue()) {
            return new Sandshrew(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SANDSLASH.getValue()) {
            return new Sandslash(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.NIDORANF.getValue()) {
            return new NidoranF(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.NIDORINA.getValue()) {
            return new Nidorina(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.NIDOQUEEN.getValue()) {
            return new Nidoqueen(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.NIDORANM.getValue()) {
            return new NidoranM(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.NIDORINO.getValue()) {
            return new Nidorino(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.NIDOKING.getValue()) {
            return new Nidoking(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CLEFAIRY.getValue()) {
            return new Clefairy(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CLEFABLE.getValue()) {
            return new Clefable(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.VULPIX.getValue()) {
            return new Vulpix(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.NINETALES.getValue()) {
            return new Ninetales(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.JIGGLYPUFF.getValue()) {
            return new Jigglypuff(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.WIGGLYTUFF.getValue()) {
            return new Wigglytuff(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.ZUBAT.getValue()) {
            return new Zubat(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.GOLBAT.getValue()) {
            return new Golbat(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.ODDISH.getValue()) {
            return new Oddish(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.GLOOM.getValue()) {
            return new Gloom(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.VILEPLUME.getValue()) {
            return new Vileplume(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.PARAS.getValue()) {
            return new Paras(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.PARASECT.getValue()) {
            return new Parasect(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.VENONAT.getValue()) {
            return new Venonat(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.VENOMOTH.getValue()) {
            return new Venomoth(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
                    fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.DIGLETT.getValue()) {
            return new Diglett(DATABASE, level, gender, ivs, evs, firstSkill, secondSkill, thirdSkill,
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
            return new Ivysaur(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.VENUSAUR.getValue()) {
            return new Venusaur(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.WARTORTLE.getValue()) {
            return new Wartortle(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.BLASTOISE.getValue()) {
            return new Blastoise(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.CHARMELEON.getValue()) {
            return new Charmeleon(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.CHARIZARD.getValue()) {
            return new Charizard(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.METAPOD.getValue()) {
            return new Metapod(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.BUTTERFREE.getValue()) {
            return new Butterfree(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.KAKUNA.getValue()) {
            return new Kakuna(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.BEEDRILL.getValue()) {
            return new Beedrill(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.PIDGEOTTO.getValue()) {
            return new Pidgeotto(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.PIDGEOT.getValue()) {
            return new Pidgeot(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.RATICATE.getValue()) {
            return new Raticate(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.FEAROW.getValue()) {
            return new Fearow(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.ARBOK.getValue()) {
            return new Arbok(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.RAICHU.getValue()) {
            return new Raichu(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.SANDSLASH.getValue()) {
            return new Sandslash(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.NIDORINA.getValue()) {
            return new Nidorina(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.NIDOQUEEN.getValue()) {
            return new Nidoqueen(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.NIDORINO.getValue()) {
            return new Nidorino(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.NIDOKING.getValue()) {
            return new Nidoking(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.CLEFABLE.getValue()) {
            return new Clefable(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.NINETALES.getValue()) {
            return new Ninetales(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.WIGGLYTUFF.getValue()) {
            return new Wigglytuff(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.GOLBAT.getValue()) {
            return new Golbat(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.GLOOM.getValue()) {
            return new Gloom(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.VILEPLUME.getValue()) {
                return new Vileplume(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                        preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                        preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                        preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.PARASECT.getValue()) {
            return new Parasect(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        } else if (id == PokemonId.VENOMOTH.getValue()) {
            return new Venomoth(PREEVOLUTION, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                    preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill(),
                    preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(), preEvolution.getStatus(),
                    preEvolution.getNature(), preEvolution.getAbility());
        }
        return null;
    }

}
