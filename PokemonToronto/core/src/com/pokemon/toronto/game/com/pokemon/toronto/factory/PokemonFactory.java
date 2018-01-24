package com.pokemon.toronto.game.com.pokemon.toronto.factory;

import com.badlogic.gdx.Gdx;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Aipom;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Ampharos;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Ariados;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Azumarill;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Bayleef;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Bellossom;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Blissey;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Chikorita;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Chinchou;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Cleffa;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Corsola;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Crobat;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Croconaw;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Cyndaquil;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Delibird;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Donphan;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Dunsparce;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Elekid;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Espeon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Feraligatr;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Flaffy;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Forretress;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Furret;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Girafarig;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Gligar;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Granbull;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Heracross;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Hitmontop;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Hoothoot;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Hoppip;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Houndoom;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Houndour;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Igglybuff;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Jumpluff;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Kingdra;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Lanturn;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Larvitar;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Ledian;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Ledyba;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Magby;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Magcargo;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Mantine;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Mareep;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Marill;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Meganium;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Miltank;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Misdreavus;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Murkrow;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Natu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Noctowl;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Octillery;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Phanpy;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Pichu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Piloswine;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Pineco;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Politoed;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Porygon2;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Pupitar;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Quagsire;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Quilava;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Qwilfish;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Remoraid;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Scizor;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Sentret;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Shuckle;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Skarmory;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Skiploom;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Slowking;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Slugma;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Smeargle;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Smoochum;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Sneasel;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Snubbull;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Spinarak;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Stantler;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Steelix;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Sudowoodo;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Sunflora;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Sunkern;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Swinub;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Teddiursa;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Togepi;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Togetic;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Totodile;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Typhlosion;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Tyranitar;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Tyrogue;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Umbreon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Unown;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Ursaring;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Wobbuffet;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Wooper;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Xatu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Yanma;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Blastoise;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Bulbasaur;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Caterpie;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Charizard;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Charmander;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Charmeleon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Eevee;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Ivysaur;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.NidoranF;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.NidoranM;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Pidgey;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Pikachu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Rattata;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Squirtle;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Venusaur;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Wartortle;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Weedle;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto.AlolanDiglett;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto.AlolanDugtrio;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto.AlolanExeggutor;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto.AlolanGeodude;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto.AlolanGolem;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto.AlolanGraveler;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto.AlolanGrimer;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto.AlolanMarowak;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto.AlolanMeowth;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto.AlolanMuk;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto.AlolanNinetales;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto.AlolanPersian;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto.AlolanRaichu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto.AlolanRaticate;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto.AlolanRattata;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto.AlolanSandshrew;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto.AlolanSandslash;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto.AlolanVulpix;
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
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Abra;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Alakazam;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Arcanine;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Bellsprout;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Cloyster;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Dewgong;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Dodrio;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Doduo;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Drowzee;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Dugtrio;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Farfetchd;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Gastly;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Gengar;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Geodude;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Golduck;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Golem;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Graveler;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Grimer;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Growlithe;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Haunter;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Hypno;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Kadabra;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Kingler;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Krabby;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Machamp;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Machoke;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Machop;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Magnemite;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Magneton;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Mankey;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Meowth;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Muk;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Onix;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Persian;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Poliwag;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Poliwhirl;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Poliwrath;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Ponyta;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Primeape;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Psyduck;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Rapidash;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Seel;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Shellder;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Slowbro;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Slowpoke;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Tentacool;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Tentacruel;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Victreebel;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Voltorb;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Weepinbell;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Aerodactyl;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Chansey;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Cubone;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Ditto;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Dragonair;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Dragonite;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Dratini;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Electabuzz;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Electrode;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Exeggcute;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Exeggutor;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Flareon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Goldeen;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Gyarados;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Hitmonchan;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Hitmonlee;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Horsea;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Jolteon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Jynx;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Kabuto;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Kabutops;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Kangaskhan;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Koffing;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Lapras;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Lickitung;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Magikarp;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Magmar;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Marowak;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.MrMime;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Omanyte;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Omastar;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Pinsir;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Porygon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Rhydon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Rhyhorn;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Scyther;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Seadra;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Seaking;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Snorlax;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Starmie;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Staryu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Tangela;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Tauros;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Vaporeon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Weezing;
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
    
    private Pokemon getCompletedPokemon(Pokemon pokemon,int level, char gender, int[] ivs, 
                                        int [] evs, Skill firstSkill, Skill secondSkill, 
                                        Skill thirdSkill, Skill fourthSkill, int currentHealth, 
                                        int currentExp, Pokemon.Status status, Nature nature, 
                                        int abilityPosition) {
        Gdx.app.log("ccc", "id" + pokemon.getId());
        pokemon.insertData(level, gender, ivs, evs, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, abilityPosition);
        return pokemon;
    }

    /**
     *
     * @param id
     * @param level
     * @param gender
     * @param nature
     * @param ability The ability position, 0 = first ability, 1 = second, 2 = hidden
     * @param currentHealth
     * @param currentExp
     * @param status
     * @param ivs
     * @param evs
     * @param firstSkill
     * @param secondSkill
     * @param thirdSkill
     * @param fourthSkill
     * @return
     */
    public Pokemon createPokemon(int id, int level, char gender, Nature nature, int ability, int currentHealth, int currentExp,
                                 Pokemon.Status status, int[] ivs, int[] evs, Skill firstSkill, Skill secondSkill, Skill thirdSkill, Skill fourthSkill) {
        Gdx.app.log("ccc", "trying to create in factory: " + id);
        if (id == PokemonId.BULBASAUR.getValue()) {
            return getCompletedPokemon(new Bulbasaur(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.IVYSAUR.getValue()) {
            return getCompletedPokemon(new Ivysaur(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.VENUSAUR.getValue()) {
            return getCompletedPokemon(new Venusaur(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CHARMANDER.getValue()) {
            return getCompletedPokemon(new Charmander(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CHARMELEON.getValue()) {
            return getCompletedPokemon(new Charmeleon(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CHARIZARD.getValue()) {
            return getCompletedPokemon(new Charizard(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SQUIRTLE.getValue()) {
            return getCompletedPokemon(new Squirtle(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.WARTORTLE.getValue()) {
            return getCompletedPokemon(new Wartortle(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.BLASTOISE.getValue()) {
            return getCompletedPokemon(new Blastoise(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CATERPIE.getValue()) {
            return getCompletedPokemon(new Caterpie(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.METAPOD.getValue()) {
            return getCompletedPokemon(new Metapod(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.BUTTERFREE.getValue()) {
            return getCompletedPokemon(new Butterfree(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.WEEDLE.getValue()) {
            return getCompletedPokemon(new Weedle(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.KAKUNA.getValue()) {
            return getCompletedPokemon(new Kakuna(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.BEEDRILL.getValue()) {
            return getCompletedPokemon(new Beedrill(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.PIDGEY.getValue()) {
            return getCompletedPokemon(new Pidgey(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.PIDGEOTTO.getValue()) {
            return getCompletedPokemon(new Pidgeotto(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.PIDGEOT.getValue()) {
            return getCompletedPokemon(new Pidgeot(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.RATTATA.getValue()) {
            return getCompletedPokemon(new Rattata(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ALOLAN_RATTATA.getValue()) {
            return getCompletedPokemon(new AlolanRattata(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.RATICATE.getValue()) {
            return getCompletedPokemon(new Raticate(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ALOLAN_RATICATE.getValue()) {
            return getCompletedPokemon(new AlolanRaticate(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.SPEAROW.getValue()) {
            return getCompletedPokemon(new Spearow(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.FEAROW.getValue()) {
            return getCompletedPokemon(new Fearow(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.EKANS.getValue()) {
            return getCompletedPokemon(new Ekans(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ARBOK.getValue()) {
            return getCompletedPokemon(new Arbok(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.PIKACHU.getValue()) {
            return getCompletedPokemon(new Pikachu(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.RAICHU.getValue()) {
            return getCompletedPokemon(new Raichu(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ALOLAN_RAICHU.getValue()) {
            return getCompletedPokemon(new AlolanRaichu(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.SANDSHREW.getValue()) {
            return getCompletedPokemon(new Sandshrew(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ALOLAN_SANDSHREW.getValue()) {
            return getCompletedPokemon(new AlolanSandshrew(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.SANDSLASH.getValue()) {
            return getCompletedPokemon(new Sandslash(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ALOLAN_SANDSLASH.getValue()) {
            return getCompletedPokemon(new AlolanSandslash(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.NIDORANF.getValue()) {
            return getCompletedPokemon(new NidoranF(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.NIDORINA.getValue()) {
            return getCompletedPokemon(new Nidorina(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.NIDOQUEEN.getValue()) {
            return getCompletedPokemon(new Nidoqueen(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.NIDORANM.getValue()) {
            return getCompletedPokemon(new NidoranM(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.NIDORINO.getValue()) {
            return getCompletedPokemon(new Nidorino(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.NIDOKING.getValue()) {
            return getCompletedPokemon(new Nidoking(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.CLEFAIRY.getValue()) {
            return getCompletedPokemon(new Clefairy(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.CLEFABLE.getValue()) {
            return getCompletedPokemon(new Clefable(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.VULPIX.getValue()) {
            return getCompletedPokemon(new Vulpix(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ALOLAN_VULPIX.getValue()) {
            return getCompletedPokemon(new AlolanVulpix(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.NINETALES.getValue()) {
            return getCompletedPokemon(new Ninetales(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ALOLAN_NINETALES.getValue()) {
            return getCompletedPokemon(new AlolanNinetales(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.JIGGLYPUFF.getValue()) {
            return getCompletedPokemon(new Jigglypuff(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.WIGGLYTUFF.getValue()) {
            return getCompletedPokemon(new Wigglytuff(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ZUBAT.getValue()) {
            return getCompletedPokemon(new Zubat(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.GOLBAT.getValue()) {
            return getCompletedPokemon(new Golbat(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ODDISH.getValue()) {
            return getCompletedPokemon(new Oddish(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.GLOOM.getValue()) {
            return getCompletedPokemon(new Gloom(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.VILEPLUME.getValue()) {
            return getCompletedPokemon(new Vileplume(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.PARAS.getValue()) {
            return getCompletedPokemon(new Paras(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.PARASECT.getValue()) {
            return getCompletedPokemon(new Parasect(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.VENONAT.getValue()) {
            return getCompletedPokemon(new Venonat(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.VENOMOTH.getValue()) {
            return getCompletedPokemon(new Venomoth(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.DIGLETT.getValue()) {
            return getCompletedPokemon(new Diglett(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ALOLAN_DIGLETT.getValue()) {
            return getCompletedPokemon(new AlolanDiglett(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        }  else if (id == PokemonId.DUGTRIO.getValue()) {
            return getCompletedPokemon(new Dugtrio(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ALOLAN_DUGTRIO.getValue()) {
            return getCompletedPokemon(new AlolanDugtrio(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        }  else if (id == PokemonId.MEOWTH.getValue()) {
            return getCompletedPokemon(new Meowth(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ALOLAN_MEOWTH.getValue()) {
            return getCompletedPokemon(new AlolanMeowth(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.PERSIAN.getValue()) {
            return getCompletedPokemon(new Persian(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ALOLAN_PERSIAN.getValue()) {
            return getCompletedPokemon(new AlolanPersian(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.PSYDUCK.getValue()) {
            return getCompletedPokemon(new Psyduck(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.GOLDUCK.getValue()) {
            return getCompletedPokemon(new Golduck(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.MANKEY.getValue()) {
            return getCompletedPokemon(new Mankey(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.PRIMEAPE.getValue()) {
            return getCompletedPokemon(new Primeape(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.GROWLITHE.getValue()) {
            return getCompletedPokemon(new Growlithe(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ARCANINE.getValue()) {
            return getCompletedPokemon(new Arcanine(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.POLIWAG.getValue()) {
            return getCompletedPokemon(new Poliwag(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.POLIWHIRL.getValue()) {
            return getCompletedPokemon(new Poliwhirl(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.POLIWRATH.getValue()) {
            return getCompletedPokemon(new Poliwrath(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ABRA.getValue()) {
            return getCompletedPokemon(new Abra(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.KADABRA.getValue()) {
            return getCompletedPokemon(new Kadabra(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ALAKAZAM.getValue()) {
            return getCompletedPokemon(new Alakazam(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.MACHOP.getValue()) {
            return getCompletedPokemon(new Machop(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.MACHOKE.getValue()) {
            return getCompletedPokemon(new Machoke(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.MACHAMP.getValue()) {
            return getCompletedPokemon(new Machamp(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.BELLSPROUT.getValue()) {
            return getCompletedPokemon(new Bellsprout(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.WEEPINBELL.getValue()) {
            return getCompletedPokemon(new Weepinbell(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.VICTREEBEL.getValue()) {
            return getCompletedPokemon(new Victreebel(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.TENTACOOL.getValue()) {
            return getCompletedPokemon(new Tentacool(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.TENTACRUEL.getValue()) {
            return getCompletedPokemon(new Tentacruel(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.GEODUDE.getValue()) {
            return getCompletedPokemon(new Geodude(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ALOLAN_GEODUDE.getValue()) {
            return getCompletedPokemon(new AlolanGeodude(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        }  else if (id == PokemonId.GRAVELER.getValue()) {
            return getCompletedPokemon(new Graveler(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ALOLAN_GRAVELER.getValue()) {
            return getCompletedPokemon(new AlolanGraveler(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        }  else if (id == PokemonId.GOLEM.getValue()) {
            return getCompletedPokemon(new Golem(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ALOLAN_GOLEM.getValue()) {
            return getCompletedPokemon(new AlolanGolem(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        }  else if (id == PokemonId.PONYTA.getValue()) {
            return getCompletedPokemon(new Ponyta(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.RAPIDASH.getValue()) {
            return getCompletedPokemon(new Rapidash(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.SLOWPOKE.getValue()) {
            return getCompletedPokemon(new Slowpoke(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.SLOWBRO.getValue()) {
            return getCompletedPokemon(new Slowbro(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.MAGNEMITE.getValue()) {
            return getCompletedPokemon(new Magnemite(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.MAGNETON.getValue()) {
            return getCompletedPokemon(new Magneton(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.FARFETCHD.getValue()) {
            return getCompletedPokemon(new Farfetchd(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.DODUO.getValue()) {
            return getCompletedPokemon(new Doduo(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.DODRIO.getValue()) {
            return getCompletedPokemon(new Dodrio(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.SEEL.getValue()) {
            return getCompletedPokemon(new Seel(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.DEWGONG.getValue()) {
            return getCompletedPokemon(new Dewgong(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.GRIMER.getValue()) {
            return getCompletedPokemon(new Grimer(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ALOLAN_GRIMER.getValue()) {
            return getCompletedPokemon(new AlolanGrimer(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.MUK.getValue()) {
            return getCompletedPokemon(new Muk(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ALOLAN_MUK.getValue()) {
            return getCompletedPokemon(new AlolanMuk(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.SHELLDER.getValue()) {
            return getCompletedPokemon(new Shellder(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.CLOYSTER.getValue()) {
            return getCompletedPokemon(new Cloyster(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.GASTLY.getValue()) {
            return getCompletedPokemon(new Gastly(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.HAUNTER.getValue()) {
            return getCompletedPokemon(new Haunter(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.GENGAR.getValue()) {
            return getCompletedPokemon(new Gengar(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ONIX.getValue()) {
            return getCompletedPokemon(new Onix(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.DROWZEE.getValue()) {
            return getCompletedPokemon(new Drowzee(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.HYPNO.getValue()) {
            return getCompletedPokemon(new Hypno(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.KRABBY.getValue()) {
            return getCompletedPokemon(new Krabby(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.KINGLER.getValue()) {
            return getCompletedPokemon(new Kingler(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.VOLTORB.getValue()) {
            return getCompletedPokemon(new Voltorb(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ELECTRODE.getValue()) {
            return getCompletedPokemon(new Electrode(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.EXEGGCUTE.getValue()) {
            return getCompletedPokemon(new Exeggcute(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.EXEGGUTOR.getValue()) {
            return getCompletedPokemon(new Exeggutor(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ALOLAN_EXEGGUTOR.getValue()) {
            return getCompletedPokemon(new AlolanExeggutor(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        }  else if (id == PokemonId.CUBONE.getValue()) {
            return getCompletedPokemon(new Cubone(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.MAROWAK.getValue()) {
            return getCompletedPokemon(new Marowak(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ALOLAN_MAROWAK.getValue()) {
            return getCompletedPokemon(new AlolanMarowak(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.HITMONLEE.getValue()) {
            return getCompletedPokemon(new Hitmonlee(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.HITMONCHAN.getValue()) {
            return getCompletedPokemon(new Hitmonchan(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.LICKITUNG.getValue()) {
            return getCompletedPokemon(new Lickitung(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.KOFFING.getValue()) {
            return getCompletedPokemon(new Koffing(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.WEEZING.getValue()) {
            return getCompletedPokemon(new Weezing(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.RHYHORN.getValue()) {
            return getCompletedPokemon(new Rhyhorn(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.RHYDON.getValue()) {
            return getCompletedPokemon(new Rhydon(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.CHANSEY.getValue()) {
            return getCompletedPokemon(new Chansey(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.TANGELA.getValue()) {
            return getCompletedPokemon(new Tangela(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.KANGASKHAN.getValue()) {
            return getCompletedPokemon(new Kangaskhan(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.HORSEA.getValue()) {
            return getCompletedPokemon(new Horsea(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.SEADRA.getValue()) {
            return getCompletedPokemon(new Seadra(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.GOLDEEN.getValue()) {
            return getCompletedPokemon(new Goldeen(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.SEAKING.getValue()) {
            return getCompletedPokemon(new Seaking(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.STARYU.getValue()) {
            return getCompletedPokemon(new Staryu(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.STARMIE.getValue()) {
            return getCompletedPokemon(new Starmie(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.MR_MIME.getValue()) {
            return getCompletedPokemon(new MrMime(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.SCYTHER.getValue()) {
            return getCompletedPokemon(new Scyther(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.JYNX.getValue()) {
            return getCompletedPokemon(new Jynx(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.ELECTABUZZ.getValue()) {
            return getCompletedPokemon(new Electabuzz(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.MAGMAR.getValue()) {
            return getCompletedPokemon(new Magmar(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.PINSIR.getValue()) {
            return getCompletedPokemon(new Pinsir(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.TAUROS.getValue()) {
            return getCompletedPokemon(new Tauros(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.MAGIKARP.getValue()) {
            return getCompletedPokemon(new Magikarp(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.GYARADOS.getValue()) {
            return getCompletedPokemon(new Gyarados(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.LAPRAS.getValue()) {
            return getCompletedPokemon(new Lapras(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.DITTO.getValue()) {
            return getCompletedPokemon(new Ditto(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.EEVEE.getValue()) {
            return getCompletedPokemon(new Eevee(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.VAPOREON.getValue()) {
            return getCompletedPokemon(new Vaporeon(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.JOLTEON.getValue()) {
            return getCompletedPokemon(new Jolteon(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.FLAREON.getValue()) {
            return getCompletedPokemon(new Flareon(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.PORYGON.getValue()) {
            return getCompletedPokemon(new Porygon(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.OMANYTE.getValue()) {
            return getCompletedPokemon(new Omanyte(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.OMASTAR.getValue()) {
            return getCompletedPokemon(new Omastar(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.KABUTO.getValue()) {
            return getCompletedPokemon(new Kabuto(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.KABUTOPS.getValue()) {
            return getCompletedPokemon(new Kabutops(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.AERODACTYL.getValue()) {
            return getCompletedPokemon(new Aerodactyl(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.SNORLAX.getValue()) {
            return getCompletedPokemon(new Snorlax(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.DRATINI.getValue()) {
            return getCompletedPokemon(new Dratini(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.DRAGONAIR.getValue()) {
            return getCompletedPokemon(new Dragonair(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);

        } else if (id == PokemonId.DRAGONITE.getValue()) {
            return getCompletedPokemon(new Dragonite(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        }
        /**
         * ****************************************************************************************
         *                              JOHTO
         ******************************************************************************************
         */
        else if (id == PokemonId.CHIKORITA.getValue()) {
            return getCompletedPokemon(new Chikorita(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.BAYLEEF.getValue()) {
            return getCompletedPokemon(new Bayleef(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.MEGANIUM.getValue()) {
            return getCompletedPokemon(new Meganium(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CYNDAQUIL.getValue()) {
            return getCompletedPokemon(new Cyndaquil(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.QUILAVA.getValue()) {
            return getCompletedPokemon(new Quilava(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.TYPHLOSION.getValue()) {
            return getCompletedPokemon(new Typhlosion(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.TOTODILE.getValue()) {
            return getCompletedPokemon(new Totodile(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CROCONAW.getValue()) {
            return getCompletedPokemon(new Croconaw(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.FERALIGATR.getValue()) {
            return getCompletedPokemon(new Feraligatr(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SENTRET.getValue()) {
            return getCompletedPokemon(new Sentret(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.FURRET.getValue()) {
            return getCompletedPokemon(new Furret(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.HOOTHOOT.getValue()) {
            return getCompletedPokemon(new Hoothoot(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.NOCTOWL.getValue()) {
            return getCompletedPokemon(new Noctowl(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.LEDYBA.getValue()) {
            return getCompletedPokemon(new Ledyba(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.LEDIAN.getValue()) {
            return getCompletedPokemon(new Ledian(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SPINARAK.getValue()) {
            return getCompletedPokemon(new Spinarak(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.ARIADOS.getValue()) {
            return getCompletedPokemon(new Ariados(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CROBAT.getValue()) {
            return getCompletedPokemon(new Crobat(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CHINCHOU.getValue()) {
            return getCompletedPokemon(new Chinchou(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.LANTURN.getValue()) {
            return getCompletedPokemon(new Lanturn(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.PICHU.getValue()) {
            return getCompletedPokemon(new Pichu(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CLEFFA.getValue()) {
            return getCompletedPokemon(new Cleffa(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.IGGLYBUFF.getValue()) {
            return getCompletedPokemon(new Igglybuff(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.TOGEPI.getValue()) {
            return getCompletedPokemon(new Togepi(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.TOGETIC.getValue()) {
            return getCompletedPokemon(new Togetic(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.NATU.getValue()) {
            return getCompletedPokemon(new Natu(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.XATU.getValue()) {
            return getCompletedPokemon(new Xatu(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.MAREEP.getValue()) {
            return getCompletedPokemon(new Mareep(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.FLAFFY.getValue()) {
            return getCompletedPokemon(new Flaffy(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.AMPHAROS.getValue()) {
            return getCompletedPokemon(new Ampharos(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.BELLOSSOM.getValue()) {
            return getCompletedPokemon(new Bellossom(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.MARILL.getValue()) {
            return getCompletedPokemon(new Marill(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.AZUMARILL.getValue()) {
            return getCompletedPokemon(new Azumarill(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SUDOWOODO.getValue()) {
            return getCompletedPokemon(new Sudowoodo(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.POLITOED.getValue()) {
            return getCompletedPokemon(new Politoed(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.HOPPIP.getValue()) {
            return getCompletedPokemon(new Hoppip(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SKIPLOOM.getValue()) {
            return getCompletedPokemon(new Skiploom(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.JUMPLUFF.getValue()) {
            return getCompletedPokemon(new Jumpluff(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.AIPOM.getValue()) {
            return getCompletedPokemon(new Aipom(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SUNKERN.getValue()) {
            return getCompletedPokemon(new Sunkern(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SUNFLORA.getValue()) {
            return getCompletedPokemon(new Sunflora(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.YANMA.getValue()) {
            return getCompletedPokemon(new Yanma(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.WOOPER.getValue()) {
            return getCompletedPokemon(new Wooper(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.QUAGSIRE.getValue()) {
            return getCompletedPokemon(new Quagsire(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.ESPEON.getValue()) {
            return getCompletedPokemon(new Espeon(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.UMBREON.getValue()) {
            return getCompletedPokemon(new Umbreon(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.MURKROW.getValue()) {
            return getCompletedPokemon(new Murkrow(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SLOWKING.getValue()) {
            return getCompletedPokemon(new Slowking(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.MISDREAVUS.getValue()) {
            return getCompletedPokemon(new Misdreavus(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.UNOWN.getValue()) {
            return getCompletedPokemon(new Unown(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.WOBBUFFET.getValue()) {
            return getCompletedPokemon(new Wobbuffet(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.GIRAFARIG.getValue()) {
            return getCompletedPokemon(new Girafarig(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.PINECO.getValue()) {
            return getCompletedPokemon(new Pineco(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.FORRETRESS.getValue()) {
            return getCompletedPokemon(new Forretress(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.DUNSPARCE.getValue()) {
            return getCompletedPokemon(new Dunsparce(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.GLIGAR.getValue()) {
            return getCompletedPokemon(new Gligar(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.STEELIX.getValue()) {
            return getCompletedPokemon(new Steelix(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SNUBBULL.getValue()) {
            return getCompletedPokemon(new Snubbull(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.GRANBULL.getValue()) {
            return getCompletedPokemon(new Granbull(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.QWILFISH.getValue()) {
            return getCompletedPokemon(new Qwilfish(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SCIZOR.getValue()) {
            return getCompletedPokemon(new Scizor(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SHUCKLE.getValue()) {
            return getCompletedPokemon(new Shuckle(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.HERACROSS.getValue()) {
            return getCompletedPokemon(new Heracross(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SNEASEL.getValue()) {
            return getCompletedPokemon(new Sneasel(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.TEDDIURSA.getValue()) {
            return getCompletedPokemon(new Teddiursa(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.URSARING.getValue()) {
            return getCompletedPokemon(new Ursaring(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SLUGMA.getValue()) {
            return getCompletedPokemon(new Slugma(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.MAGCARGO.getValue()) {
            return getCompletedPokemon(new Magcargo(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SWINUB.getValue()) {
            return getCompletedPokemon(new Swinub(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.PILOSWINE.getValue()) {
            return getCompletedPokemon(new Piloswine(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.CORSOLA.getValue()) {
            return getCompletedPokemon(new Corsola(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.REMORAID.getValue()) {
            return getCompletedPokemon(new Remoraid(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.OCTILLERY.getValue()) {
            return getCompletedPokemon(new Octillery(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.DELIBIRD.getValue()) {
            return getCompletedPokemon(new Delibird(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.MANTINE.getValue()) {
            return getCompletedPokemon(new Mantine(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SKARMORY.getValue()) {
            return getCompletedPokemon(new Skarmory(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.HOUNDOUR.getValue()) {
            return getCompletedPokemon(new Houndour(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.HOUNDOOM.getValue()) {
            return getCompletedPokemon(new Houndoom(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.KINGDRA.getValue()) {
            return getCompletedPokemon(new Kingdra(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.PHANPY.getValue()) {
            return getCompletedPokemon(new Phanpy(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.DONPHAN.getValue()) {
            return getCompletedPokemon(new Donphan(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.PORYGON2.getValue()) {
            return getCompletedPokemon(new Porygon2(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.STANTLER.getValue()) {
            return getCompletedPokemon(new Stantler(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SMEARGLE.getValue()) {
            return getCompletedPokemon(new Smeargle(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.TYROGUE.getValue()) {
            return getCompletedPokemon(new Tyrogue(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.HITMONTOP.getValue()) {
            return getCompletedPokemon(new Hitmontop(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.SMOOCHUM.getValue()) {
            return getCompletedPokemon(new Smoochum(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.ELEKID.getValue()) {
            return getCompletedPokemon(new Elekid(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.MAGBY.getValue()) {
            return getCompletedPokemon(new Magby(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.MILTANK.getValue()) {
            return getCompletedPokemon(new Miltank(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.BLISSEY.getValue()) {
            return getCompletedPokemon(new Blissey(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.LARVITAR.getValue()) {
            return getCompletedPokemon(new Larvitar(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.PUPITAR.getValue()) {
            return getCompletedPokemon(new Pupitar(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
        } else if (id == PokemonId.TYRANITAR.getValue()) {
            return getCompletedPokemon(new Tyranitar(), level, gender, ivs, evs, firstSkill, secondSkill,
                    thirdSkill, fourthSkill, currentHealth, currentExp, status, nature, ability);
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
        return createPokemon(id, preEvolution.getLevel(), preEvolution.getGender(), preEvolution.getNature(),
                preEvolution.getAbilityPosition(), preEvolution.getCurrentHealth(), (int)preEvolution.getDisplayedExp(),
                preEvolution.getStatus(), preEvolution.getIVs(), preEvolution.getEVs(), preEvolution.getFirstSkill(),
                preEvolution.getSecondSkill(), preEvolution.getThirdSkill(), preEvolution.getFourthSkill());
        
    }

}
