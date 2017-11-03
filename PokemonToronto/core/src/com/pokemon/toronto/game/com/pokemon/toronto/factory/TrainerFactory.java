package com.pokemon.toronto.game.com.pokemon.toronto.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Pikachu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Pidgeot;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Raichu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Venomoth;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Vileplume;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Alakazam;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Arcanine;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Geodude;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Growlithe;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Kadabra;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Muk;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Onix;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Ponyta;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Rapidash;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Victreebel;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Voltorb;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Exeggutor;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Gyarados;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Koffing;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.MrMime;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Rhydon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Starmie;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Staryu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Tangela;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Weezing;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonLookup;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.WildPokemonCreator;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug.LeechLife;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Dark.Bite;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Dragon.Twister;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric.ThunderShock;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fire.FireBlast;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fire.FireSpin;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fire.Flamethrower;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fire.SunnyDay;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.Bounce;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.Gust;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.WingAttack;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.GigaDrain;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.SolarBeam;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Bind;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Harden;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.QuickAttack;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.SelfDestruct;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Tackle;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.TakeDown;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic.FutureSight;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.RockSlide;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.RockTomb;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.Sandstorm;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.HydroPump;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.RainDance;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.WaterPulse;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.TrainerId;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.WildTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Gregory on 9/5/2017.
 */

public class TrainerFactory {

    private final int MAX_POKEMON = 3;
    private final int MAX_LEVEL = 6;

    public TrainerFactory() {

    }

    private String getMaleName() {
        FileHandle file = Gdx.files.internal("text/male.txt");
        String text = file.readString();
        String[] names = text.split("\n");
        Random r = new Random();
        return names[r.nextInt(names.length)];
    }

    private String getFemaleName() {
        FileHandle file = Gdx.files.internal("text/female.txt");
        String text = file.readString();
        String[] names = text.split("\n");
        Random r = new Random();
        return names[r.nextInt(names.length)];
    }

    private String getVictoryText() {
        FileHandle file = Gdx.files.internal("text/victory.txt");
        String text = file.readString();
        String[] names = text.split("\n");
        Random r = new Random();
        return names[r.nextInt(names.length)];
    }
    
    public List<Pokemon> initParty(List<Integer> pool, double difficulty) {
        int lowLevel = getLowLevel(difficulty);
        int highLevel = getHighLevel(difficulty);
        WildPokemonCreator wpc = new WildPokemonCreator();
        List<Pokemon> party = new ArrayList<Pokemon>();
        int maxNumPokemon = getMaxNumberOfPokemon(difficulty);
        int numPokemon = (int)Math.round(Math.random() * (maxNumPokemon - 1)) + 1;
        if (numPokemon == 1) {
            int poolIndex = (int)Math.round(Math.random() * (pool.size() - 1));
            party.add(wpc.createPokemon(pool.get(poolIndex), highLevel, highLevel));
        } else {
            for (int i = 0; i < numPokemon; i++) {
                int poolIndex = (int)Math.round(Math.random() * (pool.size() - 1));
                party.add(wpc.createPokemon(pool.get(poolIndex), lowLevel, highLevel));
            }
        }
        return party;
    } 

    private int getMaxNumberOfPokemon(double difficulty) {
        if (difficulty == 0.5) {
            return 3;
        } else if (difficulty >= 1 && difficulty <= 3) {
            return 4;
        } else if (difficulty > 3 && difficulty <= 4) {
            return 5;
        } else {
            return 6;
        }
    }

    private int getHighLevel(double difficulty) {
        if (difficulty == 0.5) {
            return 5;
        } else if (difficulty == 1) {
            return 10;
        }  else if (difficulty == 1.5) {
            return 15;
        } else if (difficulty == 2) {
            return 19;
        } else if (difficulty == 2.5) {
            return 24;
        } else if (difficulty == 3) {
            return 30;
        } else if (difficulty == 3.5) {
            return 36;
        } else if (difficulty == 4) {
            return 42;
        } else if (difficulty == 4.5) {
            return 48;
        } else if (difficulty == 5) {
            return 54;
        } else if (difficulty == 5.5) {
            return 60;
        } else if (difficulty == 6) {
            return 67;
        } else if (difficulty == 6.5) {
            return 74;
        } else if (difficulty == 7) {
            return 81;
        } else if (difficulty == 7.5) {
            return 87;
        } else if (difficulty == 8) {
            return 93;
        } else if (difficulty == 8.5) {
            return 99;
        } else if (difficulty == 9) {
            return 99;
        } else if (difficulty == 9.5) {
            return 100;
        } else if (difficulty >= 10) {
            return 100;
        } else {
            return 100;
        }
    }

    private int getLowLevel(double difficulty) {
        if (difficulty == 0.5) {
            return 3;
        } else if (difficulty == 1) {
            return 6;
        }  else if (difficulty == 1.5) {
            return 11;
        } else if (difficulty == 2) {
            return 15;
        } else if (difficulty == 2.5) {
            return 19;
        } else if (difficulty == 3) {
            return 25;
        } else if (difficulty == 3.5) {
            return 31;
        } else if (difficulty == 4) {
            return 37;
        } else if (difficulty == 4.5) {
            return 43;
        } else if (difficulty == 5) {
            return 49;
        } else if (difficulty == 5.5) {
            return 55;
        } else if (difficulty == 6) {
            return 61;
        } else if (difficulty == 6.5) {
            return 68;
        } else if (difficulty == 7) {
            return 75;
        } else if (difficulty == 7.5) {
            return 81;
        } else if (difficulty == 8) {
            return 88;
        } else if (difficulty == 8.5) {
            return 94;
        } else if (difficulty == 9) {
            return 95;
        } else if (difficulty == 9.5) {
            return 95;
        } else if (difficulty >= 10) {
            return 100;
        } else {
            return 5;
        }
    }

    public WildTrainer getTrainer(double difficulty, double latitude, double longitude) {
        double rand = Math.random();
        double[] latlng = PokemonLookup.getRandomLocation(latitude, longitude, 200);
        if (rand <= .33) {
            return getBugCatcher(difficulty, latlng[0], latlng[1]);
        } else if (rand <= .66) {
            return getLass(difficulty, latlng[0], latlng[1]);
        } else {
            return getYoungster(difficulty, latlng[0], latlng[1]);
        }
    }

    public WildTrainer getTrainer(int id, double difficulty, double latitude, double longitude) {
        double[] latlng = PokemonLookup.getRandomLocation(latitude, longitude, 200);
        if (id == TrainerId.BUG_CATCHER.getValue()) {
            return getBugCatcher(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.LASS.getValue()) {
            return getLass(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.ACE_TRAINER_MALE.getValue()) {
            return getAceTrainerMale(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.ACE_TRAINER_FEMALE.getValue()) {
            return getAceTrainerFemale(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.AROMA_LADY.getValue()) {
            return getAromaLady(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.BATTLE_GIRL.getValue()) {
            return getBattleGirl(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.BEAUTY.getValue()) {
            return getBeauty(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.BIRD_KEEPER.getValue()) {
            return getBirdKeeper(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.BLACKBELT.getValue()) {
            return getBlackbelt(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.DOCTOR.getValue()) {
            return getDoctor(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.FIRE_BREATHER.getValue()) {
            return getFirebreather(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.FISHERMAN.getValue()) {
            return getFisherman(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.GAMBLER.getValue()) {
            return getGambler(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.GENTLEMAN.getValue()) {
            return getGentleman(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.HIKER.getValue()) {
            return getHiker(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.JUGGLER.getValue()) {
            return getJuggler(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.KIMONO_GIRL.getValue()) {
            return getKimonoGirl(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.LADY.getValue()) {
            return getLady(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.MEDIUM.getValue()) {
            return getMedium(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.NURSE.getValue()) {
            return getNurse(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.PARASOL_LADY.getValue()) {
            return getParasolLady(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.PICNICKER_MALE.getValue()) {
            return getPicnickerMale(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.PICNICKER_FEMALE.getValue()) {
            return getPicnickerFemale(difficulty, latlng[0], latlng[1]);
        }   else if (id == TrainerId.YOUNGSTER.getValue()) {
            return getYoungster(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.WAITER.getValue() ||
                id == TrainerId.WAITRESS.getValue()) {
            return getWaiter(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.DRAGON_TAMER.getValue()) {
            return getDragonTamer(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.BAKER.getValue()) {
            return getBaker(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.POLICEMAN.getValue()) {
            return getPolice(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.CUE_BALL.getValue()) {
            return getCueBall(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.BIKER.getValue()) {
            return getBiker(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.BURGLAR.getValue()) {
            return getBurglar(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.JANITOR.getValue()) {
            return getJanitor(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.CONDUCTOR.getValue()) {
            return getConductorPokemon(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.PILOT.getValue()) {
            return getPilotPokemon(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.SAGE.getValue()) {
            return getSage(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.SAILOR.getValue()) {
            return getSailor(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.VETERAN_MALE.getValue()) {
            return getVeteranMale(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.VETERAN_FEMALE.getValue()) {
            return getVeteranFemale(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.RUNE_MANIAC.getValue()) {
            return getRuneManiac(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.PSYCHIC.getValue()) {
            return getPsychic(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.RANGER.getValue()) {
            return getRanger(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.RICH_BOY.getValue()) {
            return getRichBoy(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.SCHOOL_KID.getValue()) {
            return getSchoolKid(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.SCIENTIST.getValue()) {
            return getScientist(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.SWIMMER.getValue()) {
            return getSwimmer(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.TEACHER.getValue()) {
            return getTeacher(difficulty, latlng[0], latlng[1]);
        } else {
            return getYoungster(difficulty, latlng[0], latlng[1]);
        }
    }
    public List<Integer> getYoungsterPokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        if (difficulty <= 4) {
            bugCatcherPokemon.add(PokemonId.RATTATA.getValue());
        }
        if (difficulty <= 3.5) {
            bugCatcherPokemon.add(PokemonId.PIDGEY.getValue());
        }
        if (difficulty >= 1.5 && difficulty <= 3.5) {
            bugCatcherPokemon.add(PokemonId.EKANS.getValue());
            bugCatcherPokemon.add(PokemonId.SANDSHREW.getValue());
            bugCatcherPokemon.add(PokemonId.DIGLETT.getValue());
            bugCatcherPokemon.add(PokemonId.PIKACHU.getValue());
            bugCatcherPokemon.add(PokemonId.PARAS.getValue());
            bugCatcherPokemon.add(PokemonId.SPEAROW.getValue());
        }
        if (difficulty >= 2) {
            bugCatcherPokemon.add(PokemonId.PIDGEOTTO.getValue());
        }
        if (difficulty >= 2.5) {
            bugCatcherPokemon.add(PokemonId.RATICATE.getValue());
            bugCatcherPokemon.add(PokemonId.SANDSLASH.getValue());
            bugCatcherPokemon.add(PokemonId.FEAROW.getValue());
            bugCatcherPokemon.add(PokemonId.ARBOK.getValue());
        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.PARASECT.getValue());
        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEOT.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getBugCatcherPokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        if (difficulty <= 3) {
            bugCatcherPokemon.add(PokemonId.CATERPIE.getValue());
            bugCatcherPokemon.add(PokemonId.WEEDLE.getValue());
        }
        if (difficulty >= 1.5 && difficulty <= 3) {
            bugCatcherPokemon.add(PokemonId.PARAS.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 4) {
            bugCatcherPokemon.add(PokemonId.VENONAT.getValue());
        }
        if (difficulty <= 4) {
            bugCatcherPokemon.add(PokemonId.KAKUNA.getValue());
            bugCatcherPokemon.add(PokemonId.METAPOD.getValue());
        }
        if (difficulty > 2) {
            bugCatcherPokemon.add(PokemonId.BEEDRILL.getValue());
            bugCatcherPokemon.add(PokemonId.BUTTERFREE.getValue());
        }
        if (difficulty > 2.5) {
            bugCatcherPokemon.add(PokemonId.PARASECT.getValue());
        }
        if (difficulty > 3) {
            bugCatcherPokemon.add(PokemonId.VENOMOTH.getValue());
        }

        return bugCatcherPokemon;
    }

    public List<Integer> getLassPokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        bugCatcherPokemon.add(PokemonId.PIKACHU.getValue());
        if (difficulty <= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEY.getValue());
        }
        if (difficulty >= 1.5 && difficulty <= 2.5) {
            bugCatcherPokemon.add(PokemonId.NIDORANF.getValue());
            bugCatcherPokemon.add(PokemonId.ODDISH.getValue());
        }
        if (difficulty >= 1.5 && difficulty <= 3.5) {
            bugCatcherPokemon.add(PokemonId.PARAS.getValue());
            bugCatcherPokemon.add(PokemonId.CLEFAIRY.getValue());
            bugCatcherPokemon.add(PokemonId.JIGGLYPUFF.getValue());
        }
        if (difficulty >= 2) {
            bugCatcherPokemon.add(PokemonId.PIDGEOTTO.getValue());
        }
        if (difficulty >= 2.5) {
            bugCatcherPokemon.add(PokemonId.NIDORINA.getValue());
            bugCatcherPokemon.add(PokemonId.GLOOM.getValue());
        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.PARASECT.getValue());
        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEOT.getValue());
            bugCatcherPokemon.add(PokemonId.CLEFABLE.getValue());
            bugCatcherPokemon.add(PokemonId.WIGGLYTUFF.getValue());
            bugCatcherPokemon.add(PokemonId.VILEPLUME.getValue());
        }
        if (difficulty >= 5) {
            bugCatcherPokemon.add(PokemonId.NIDOQUEEN.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getAceTrainerMalePokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        if (difficulty <= 2.5) {
            bugCatcherPokemon.add(PokemonId.CHARMANDER.getValue());
            bugCatcherPokemon.add(PokemonId.SQUIRTLE.getValue());
            bugCatcherPokemon.add(PokemonId.BULBASAUR.getValue());
            bugCatcherPokemon.add(PokemonId.NIDORANM.getValue());
        }

        if (difficulty >= 2 && difficulty <= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEOTTO.getValue());
            bugCatcherPokemon.add(PokemonId.CHARMELEON.getValue());
            bugCatcherPokemon.add(PokemonId.WARTORTLE.getValue());
            bugCatcherPokemon.add(PokemonId.IVYSAUR.getValue());
        }

        if (difficulty >= 2.5) {
            bugCatcherPokemon.add(PokemonId.SANDSLASH.getValue());
            bugCatcherPokemon.add(PokemonId.BEEDRILL.getValue());
        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.PARASECT.getValue());
            bugCatcherPokemon.add(PokemonId.SEADRA.getValue());
            bugCatcherPokemon.add(PokemonId.GYARADOS.getValue());
            bugCatcherPokemon.add(PokemonId.TAUROS.getValue());
            bugCatcherPokemon.add(PokemonId.PINSIR.getValue());
            bugCatcherPokemon.add(PokemonId.SCYTHER.getValue());
            bugCatcherPokemon.add(PokemonId.TENTACRUEL.getValue());
            bugCatcherPokemon.add(PokemonId.MAROWAK.getValue());
        }
        if (difficulty >= 3.5) {
            bugCatcherPokemon.add(PokemonId.KINGLER.getValue());
            bugCatcherPokemon.add(PokemonId.GOLDUCK.getValue());
            bugCatcherPokemon.add(PokemonId.MACHOKE.getValue());

        }

        if (difficulty >= 2.5 && difficulty <= 5) {
            bugCatcherPokemon.add(PokemonId.NIDORINO.getValue());
            bugCatcherPokemon.add(PokemonId.RHYHORN.getValue());
        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEOT.getValue());
            bugCatcherPokemon.add(PokemonId.DODRIO.getValue());
            bugCatcherPokemon.add(PokemonId.FEAROW.getValue());
            bugCatcherPokemon.add(PokemonId.KANGASKHAN.getValue());
            bugCatcherPokemon.add(PokemonId.CHARIZARD.getValue());
            bugCatcherPokemon.add(PokemonId.BLASTOISE.getValue());
            bugCatcherPokemon.add(PokemonId.VENUSAUR.getValue());
            bugCatcherPokemon.add(PokemonId.POLIWRATH.getValue());
            bugCatcherPokemon.add(PokemonId.ARCANINE.getValue());
            bugCatcherPokemon.add(PokemonId.RAPIDASH.getValue());
            bugCatcherPokemon.add(PokemonId.MACHAMP.getValue());
            bugCatcherPokemon.add(PokemonId.DRAGONAIR.getValue());
            bugCatcherPokemon.add(PokemonId.RHYDON.getValue());
            bugCatcherPokemon.add(PokemonId.JOLTEON.getValue());
            bugCatcherPokemon.add(PokemonId.FLAREON.getValue());
        }
        if (difficulty >= 5) {
            bugCatcherPokemon.add(PokemonId.NIDOKING.getValue());
            bugCatcherPokemon.add(PokemonId.SNORLAX.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getAceTrainerFemalePokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        if (difficulty <= 2.5) {
            bugCatcherPokemon.add(PokemonId.CHARMANDER.getValue());
            bugCatcherPokemon.add(PokemonId.SQUIRTLE.getValue());
            bugCatcherPokemon.add(PokemonId.BULBASAUR.getValue());
            bugCatcherPokemon.add(PokemonId.NIDORANF.getValue());
        }
        if (difficulty >= 2 && difficulty <= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEOTTO.getValue());
            bugCatcherPokemon.add(PokemonId.CHARMELEON.getValue());
            bugCatcherPokemon.add(PokemonId.WARTORTLE.getValue());
            bugCatcherPokemon.add(PokemonId.IVYSAUR.getValue());
        }

        if (difficulty >= 2.5) {
            bugCatcherPokemon.add(PokemonId.GLOOM.getValue());
            bugCatcherPokemon.add(PokemonId.BUTTERFREE.getValue());
        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.WIGGLYTUFF.getValue());
            bugCatcherPokemon.add(PokemonId.SEADRA.getValue());
            bugCatcherPokemon.add(PokemonId.CLEFABLE.getValue());
            bugCatcherPokemon.add(PokemonId.JYNX.getValue());
            bugCatcherPokemon.add(PokemonId.TENTACRUEL.getValue());
        }
        if (difficulty >= 3.5) {
            bugCatcherPokemon.add(PokemonId.STARMIE.getValue());
            bugCatcherPokemon.add(PokemonId.GOLDUCK.getValue());
            bugCatcherPokemon.add(PokemonId.WEEPINBELL.getValue());

        }

        if (difficulty >= 2.5 && difficulty <= 5) {
            bugCatcherPokemon.add(PokemonId.NIDORINA.getValue());
            bugCatcherPokemon.add(PokemonId.SEEL.getValue());
        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEOT.getValue());
            bugCatcherPokemon.add(PokemonId.DODRIO.getValue());
            bugCatcherPokemon.add(PokemonId.CHARIZARD.getValue());
            bugCatcherPokemon.add(PokemonId.BLASTOISE.getValue());
            bugCatcherPokemon.add(PokemonId.VENUSAUR.getValue());
            bugCatcherPokemon.add(PokemonId.POLIWRATH.getValue());
            bugCatcherPokemon.add(PokemonId.NINETALES.getValue());
            bugCatcherPokemon.add(PokemonId.RAPIDASH.getValue());
            bugCatcherPokemon.add(PokemonId.DEWGONG.getValue());
            bugCatcherPokemon.add(PokemonId.DRAGONAIR.getValue());
            bugCatcherPokemon.add(PokemonId.JOLTEON.getValue());
            bugCatcherPokemon.add(PokemonId.FLAREON.getValue());
            bugCatcherPokemon.add(PokemonId.VAPOREON.getValue());
        }
        if (difficulty >= 5) {
            bugCatcherPokemon.add(PokemonId.NIDOKING.getValue());
            bugCatcherPokemon.add(PokemonId.SNORLAX.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getAromaLadyPokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        if (difficulty <= 3) {
            bugCatcherPokemon.add(PokemonId.ODDISH.getValue());
            bugCatcherPokemon.add(PokemonId.BELLSPROUT.getValue());
            bugCatcherPokemon.add(PokemonId.BULBASAUR.getValue());
        }
        if (difficulty >= 2 && difficulty <= 4) {
            bugCatcherPokemon.add(PokemonId.WEEPINBELL.getValue());
            bugCatcherPokemon.add(PokemonId.GLOOM.getValue());
            bugCatcherPokemon.add(PokemonId.IVYSAUR.getValue());
        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.TANGELA.getValue());
            bugCatcherPokemon.add(PokemonId.BUTTERFREE.getValue());
        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.VENUSAUR.getValue());
            bugCatcherPokemon.add(PokemonId.VICTREEBEL.getValue());
            bugCatcherPokemon.add(PokemonId.VILEPLUME.getValue());
            bugCatcherPokemon.add(PokemonId.CHANSEY.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getBattleGirlPokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            bugCatcherPokemon.add(PokemonId.MACHOP.getValue());
            bugCatcherPokemon.add(PokemonId.MANKEY.getValue());
        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.PRIMEAPE.getValue());
            bugCatcherPokemon.add(PokemonId.MACHOKE.getValue());
        }
        if (difficulty <= 3.5) {
            bugCatcherPokemon.add(PokemonId.HITMONLEE.getValue());
            bugCatcherPokemon.add(PokemonId.HITMONCHAN.getValue());
        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.MACHAMP.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getBeautyPokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        if (difficulty <= 3) {
            bugCatcherPokemon.add(PokemonId.ODDISH.getValue());
            bugCatcherPokemon.add(PokemonId.BELLSPROUT.getValue());
            bugCatcherPokemon.add(PokemonId.BULBASAUR.getValue());
            bugCatcherPokemon.add(PokemonId.CLEFAIRY.getValue());
            bugCatcherPokemon.add(PokemonId.JIGGLYPUFF.getValue());
            bugCatcherPokemon.add(PokemonId.POLIWAG.getValue());
            bugCatcherPokemon.add(PokemonId.MEOWTH.getValue());
            bugCatcherPokemon.add(PokemonId.PSYDUCK.getValue());
            bugCatcherPokemon.add(PokemonId.EEVEE.getValue());
        }
        if (difficulty >= 2 && difficulty <= 4) {
            bugCatcherPokemon.add(PokemonId.WEEPINBELL.getValue());
            bugCatcherPokemon.add(PokemonId.GLOOM.getValue());
            bugCatcherPokemon.add(PokemonId.IVYSAUR.getValue());
            bugCatcherPokemon.add(PokemonId.HORSEA.getValue());
            bugCatcherPokemon.add(PokemonId.GOLDEEN.getValue());

        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.TANGELA.getValue());
            bugCatcherPokemon.add(PokemonId.BUTTERFREE.getValue());
            bugCatcherPokemon.add(PokemonId.PERSIAN.getValue());
        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.VENUSAUR.getValue());
            bugCatcherPokemon.add(PokemonId.VICTREEBEL.getValue());
            bugCatcherPokemon.add(PokemonId.VILEPLUME.getValue());
            bugCatcherPokemon.add(PokemonId.CHANSEY.getValue());
            bugCatcherPokemon.add(PokemonId.JOLTEON.getValue());
            bugCatcherPokemon.add(PokemonId.FLAREON.getValue());
            bugCatcherPokemon.add(PokemonId.VAPOREON.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getBikerPokemon(double difficulty) {
        List<Integer> bikerPokemon = new ArrayList<Integer>();
        if (difficulty <= 2.5) {
            bikerPokemon.add(PokemonId.EKANS.getValue());
        }
        if (difficulty <= 4.5) {
            bikerPokemon.add(PokemonId.GRIMER.getValue());
            bikerPokemon.add(PokemonId.KOFFING.getValue());
        }
        if (difficulty >= 2 && difficulty <= 4.5) {
            bikerPokemon.add(PokemonId.CHARMELEON.getValue());
        }
        if (difficulty >= 2.5) {
            bikerPokemon.add(PokemonId.ARBOK.getValue());
        }
        if (difficulty >= 3.5) {
            bikerPokemon.add(PokemonId.MUK.getValue());
            bikerPokemon.add(PokemonId.WEEZING.getValue());
        }
        if (difficulty >= 4.5) {
            bikerPokemon.add(PokemonId.TENTACRUEL.getValue());
        }
        if (difficulty >= 5) {
            bikerPokemon.add(PokemonId.FLAREON.getValue());
            bikerPokemon.add(PokemonId.MAGMAR.getValue());

        }
        return bikerPokemon;
    }

    public List<Integer> getBirdKeeperPokemon(double difficulty) {
        List<Integer> bikerPokemon = new ArrayList<Integer>();
        if (difficulty <= 3) {
            bikerPokemon.add(PokemonId.PIDGEY.getValue());
            bikerPokemon.add(PokemonId.SPEAROW.getValue());
        }
        if (difficulty >= 3) {
            bikerPokemon.add(PokemonId.FARFETCHD.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 4) {
            bikerPokemon.add(PokemonId.DODUO.getValue());
        }
        if (difficulty >= 2.5) {
            bikerPokemon.add(PokemonId.PIDGEOTTO.getValue());
            bikerPokemon.add(PokemonId.FEAROW.getValue());
        }
        if (difficulty >= 3.5) {
            bikerPokemon.add(PokemonId.PIDGEOT.getValue());
            bikerPokemon.add(PokemonId.DODRIO.getValue());
        }
        return bikerPokemon;
    }

    public List<Integer> getBlackbeltPokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            bugCatcherPokemon.add(PokemonId.MACHOP.getValue());
            bugCatcherPokemon.add(PokemonId.MANKEY.getValue());
        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.PRIMEAPE.getValue());
            bugCatcherPokemon.add(PokemonId.MACHOKE.getValue());
        }
        if (difficulty <= 3.5) {
            bugCatcherPokemon.add(PokemonId.HITMONLEE.getValue());
            bugCatcherPokemon.add(PokemonId.HITMONCHAN.getValue());
        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.MACHAMP.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getBurglarPokemon(double difficulty) {
        List<Integer> burglarPokemon = new ArrayList<Integer>();
        if (difficulty <= 2.5) {
            burglarPokemon.add(PokemonId.CHARMANDER.getValue());
        }
        if (difficulty <= 4.5) {
            burglarPokemon.add(PokemonId.GROWLITHE.getValue());
            burglarPokemon.add(PokemonId.VULPIX.getValue());
        }
        if (difficulty >= 3 && difficulty <= 4.5) {
            burglarPokemon.add(PokemonId.PONYTA.getValue());
        }
        if (difficulty >= 3.5) {
            burglarPokemon.add(PokemonId.ARCANINE.getValue());
            burglarPokemon.add(PokemonId.NINETALES.getValue());

        }
        if (difficulty >= 4) {
            burglarPokemon.add(PokemonId.RAPIDASH.getValue());
            burglarPokemon.add(PokemonId.FLAREON.getValue());
        }
        if (difficulty >= 5) {
            burglarPokemon.add(PokemonId.CHARIZARD.getValue());
        }

        return burglarPokemon;
    }

    public List<Integer> getCueBallPokemon(double difficulty) {
        List<Integer> cueBallPokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            cueBallPokemon.add(PokemonId.MACHOP.getValue());
            cueBallPokemon.add(PokemonId.MANKEY.getValue());
        }
        if (difficulty >= 3) {
            cueBallPokemon.add(PokemonId.MACHOKE.getValue());
            cueBallPokemon.add(PokemonId.PRIMEAPE.getValue());
        }
        if (difficulty <= 4.5) {
            cueBallPokemon.add(PokemonId.GRIMER.getValue());
            cueBallPokemon.add(PokemonId.KOFFING.getValue());
        }
        if (difficulty >= 3.5) {
            cueBallPokemon.add(PokemonId.MUK.getValue());
            cueBallPokemon.add(PokemonId.WEEZING.getValue());
        }
        if (difficulty >= 4.5) {
            cueBallPokemon.add(PokemonId.MACHAMP.getValue());
        }
        if (difficulty >= 5) {
            cueBallPokemon.add(PokemonId.GYARADOS.getValue());
        }
        return cueBallPokemon;
    }

    public List<Integer> getDoctorPokemon(double difficulty) {
        List<Integer> cueBallPokemon = new ArrayList<Integer>();
        cueBallPokemon.add(PokemonId.CHANSEY.getValue());
        if (difficulty <= 3.5) {
            cueBallPokemon.add(PokemonId.DROWZEE.getValue());
        }
        if (difficulty >= 3) {
            cueBallPokemon.add(PokemonId.HYPNO.getValue());
        }
        return cueBallPokemon;
    }

    public List<Integer> getDragonTamerPokemon(double difficulty) {
        List<Integer> dragonTamerPokemon = new ArrayList<Integer>();
        if (difficulty <= 2.5) {
            dragonTamerPokemon.add(PokemonId.CHARMANDER.getValue());
            dragonTamerPokemon.add(PokemonId.EKANS.getValue());
        }
        if (difficulty >= 1 && difficulty <= 5) {
            dragonTamerPokemon.add(PokemonId.DRATINI.getValue());
        }
        if (difficulty >= 2 && difficulty <= 4.5) {
            dragonTamerPokemon.add(PokemonId.CHARMELEON.getValue());
        }
        if (difficulty >= 2.5) {
            dragonTamerPokemon.add(PokemonId.ARBOK.getValue());
        }
        if (difficulty >= 3) {
            dragonTamerPokemon.add(PokemonId.SEADRA.getValue());
            dragonTamerPokemon.add(PokemonId.GYARADOS.getValue());
        }
        if (difficulty >= 3.5) {
            dragonTamerPokemon.add(PokemonId.DRAGONAIR.getValue());
        }
        if (difficulty >= 4) {
            dragonTamerPokemon.add(PokemonId.CHARIZARD.getValue());
        }
        if (difficulty >= 5) {
            dragonTamerPokemon.add(PokemonId.AERODACTYL.getValue());
            dragonTamerPokemon.add(PokemonId.DRAGONITE.getValue());
        }
        return dragonTamerPokemon;
    }

    public List<Integer> getFirebreatherPokemon(double difficulty) {
        List<Integer> burglarPokemon = new ArrayList<Integer>();
        if (difficulty >= 2) {
            burglarPokemon.add(PokemonId.MAGMAR.getValue());
        }
        if (difficulty <= 2.5) {
            burglarPokemon.add(PokemonId.CHARMANDER.getValue());
        }
        if (difficulty <= 4.5) {
            burglarPokemon.add(PokemonId.GROWLITHE.getValue());
            burglarPokemon.add(PokemonId.VULPIX.getValue());
            burglarPokemon.add(PokemonId.KOFFING.getValue());
        }
        if (difficulty >= 3 && difficulty <= 4.5) {
            burglarPokemon.add(PokemonId.PONYTA.getValue());
        }
        if (difficulty >= 3.5) {
            burglarPokemon.add(PokemonId.ARCANINE.getValue());
            burglarPokemon.add(PokemonId.NINETALES.getValue());

        }
        if (difficulty >= 4) {
            burglarPokemon.add(PokemonId.RAPIDASH.getValue());
            burglarPokemon.add(PokemonId.FLAREON.getValue());
            burglarPokemon.add(PokemonId.WEEZING.getValue());
        }
        if (difficulty >= 5) {
            burglarPokemon.add(PokemonId.CHARIZARD.getValue());
        }
        return burglarPokemon;
    }

    public List<Integer> getFishermanPokemon(double difficulty) {
        List<Integer> burglarPokemon = new ArrayList<Integer>();
        if (difficulty <= 3) {
            burglarPokemon.add(PokemonId.MAGIKARP.getValue());
            burglarPokemon.add(PokemonId.POLIWAG.getValue());
        }
        if (difficulty <= 3.5) {
            burglarPokemon.add(PokemonId.GOLDEEN.getValue());
            burglarPokemon.add(PokemonId.SHELLDER.getValue());
            burglarPokemon.add(PokemonId.HORSEA.getValue());
            burglarPokemon.add(PokemonId.STARYU.getValue());
            burglarPokemon.add(PokemonId.TENTACOOL.getValue());
        }
        if (difficulty >= 2) {
            burglarPokemon.add(PokemonId.GYARADOS.getValue());
        }
        if (difficulty >= 3) {
            burglarPokemon.add(PokemonId.SEAKING.getValue());
            burglarPokemon.add(PokemonId.POLIWHIRL.getValue());
            burglarPokemon.add(PokemonId.STARMIE.getValue());
            burglarPokemon.add(PokemonId.SEADRA.getValue());
        }
        if (difficulty >= 3.5) {
            burglarPokemon.add(PokemonId.TENTACRUEL.getValue());
            burglarPokemon.add(PokemonId.CLOYSTER.getValue());
        }
        if (difficulty >= 4) {
            burglarPokemon.add(PokemonId.POLIWRATH.getValue());
        }
        return burglarPokemon;
    }

    public List<Integer> getGamblerPokemon(double difficulty) {
        List<Integer> burglarPokemon = new ArrayList<Integer>();
        if (difficulty <= 3) {
            burglarPokemon.add(PokemonId.NIDORANM.getValue());
            burglarPokemon.add(PokemonId.NIDORANF.getValue());
            burglarPokemon.add(PokemonId.POLIWAG.getValue());
        }
        if (difficulty <= 3.5) {
            burglarPokemon.add(PokemonId.VOLTORB.getValue());
            burglarPokemon.add(PokemonId.MAGNEMITE.getValue());
            burglarPokemon.add(PokemonId.HORSEA.getValue());
            burglarPokemon.add(PokemonId.GOLDEEN.getValue());
            burglarPokemon.add(PokemonId.GEODUDE.getValue());
            burglarPokemon.add(PokemonId.KRABBY.getValue());
            burglarPokemon.add(PokemonId.DIGLETT.getValue());
        }

        if (difficulty >= 2.5) {
            burglarPokemon.add(PokemonId.DUGTRIO.getValue());
            burglarPokemon.add(PokemonId.NIDORINO.getValue());
            burglarPokemon.add(PokemonId.NIDORINA.getValue());
        }
        if (difficulty >= 3) {
            burglarPokemon.add(PokemonId.POLIWHIRL.getValue());
            burglarPokemon.add(PokemonId.SEADRA.getValue());
            burglarPokemon.add(PokemonId.SEAKING.getValue());
            burglarPokemon.add(PokemonId.MAGNETON.getValue());
            burglarPokemon.add(PokemonId.ELECTRODE.getValue());
            burglarPokemon.add(PokemonId.GRAVELER.getValue());
        }

        if (difficulty >= 2 && difficulty <= 4) {
            burglarPokemon.add(PokemonId.RHYHORN.getValue());
        }

        if (difficulty >= 4) {
            burglarPokemon.add(PokemonId.RHYDON.getValue());
        }

        if (difficulty >= 5) {
            burglarPokemon.add(PokemonId.NIDOQUEEN.getValue());
            burglarPokemon.add(PokemonId.NIDOKING.getValue());
            burglarPokemon.add(PokemonId.GOLEM.getValue());
        }
        return burglarPokemon;
    }

    public List<Integer> getGentlemanPokemon(double difficulty) {
        List<Integer> burglarPokemon = new ArrayList<Integer>();
        if (difficulty <= 3) {
            burglarPokemon.add(PokemonId.NIDORANM.getValue());
            burglarPokemon.add(PokemonId.NIDORANF.getValue());
        }
        if (difficulty <= 3.5) {
            burglarPokemon.add(PokemonId.MAGNEMITE.getValue());
            burglarPokemon.add(PokemonId.VOLTORB.getValue());
        }
        if (difficulty <= 4) {
            burglarPokemon.add(PokemonId.PIKACHU.getValue());
            burglarPokemon.add(PokemonId.GROWLITHE.getValue());
        }
        if (difficulty >= 2 && difficulty <= 4) {
            burglarPokemon.add(PokemonId.PONYTA.getValue());
        }
        if (difficulty >= 2.5) {
            burglarPokemon.add(PokemonId.NIDORINO.getValue());
            burglarPokemon.add(PokemonId.NIDORINA.getValue());
        }

        if (difficulty >= 3) {
            burglarPokemon.add(PokemonId.MAGNETON.getValue());
            burglarPokemon.add(PokemonId.ELECTRODE.getValue());
            burglarPokemon.add(PokemonId.RAICHU.getValue());
            burglarPokemon.add(PokemonId.ALOLAN_RAICHU.getValue());
        }

        if (difficulty >= 4.5) {
            burglarPokemon.add(PokemonId.ARCANINE.getValue());
            burglarPokemon.add(PokemonId.RAPIDASH.getValue());
        }

        if (difficulty >= 5) {
            burglarPokemon.add(PokemonId.NIDOQUEEN.getValue());
            burglarPokemon.add(PokemonId.NIDOKING.getValue());
        }
        return burglarPokemon;
    }

    public List<Integer> getHikerPokemon(double difficulty) {
        List<Integer> burglarPokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            burglarPokemon.add(PokemonId.GEODUDE.getValue());
            burglarPokemon.add(PokemonId.ALOLAN_GEODUDE.getValue());
            burglarPokemon.add(PokemonId.DIGLETT.getValue());
            burglarPokemon.add(PokemonId.ALOLAN_DIGLETT.getValue());
            burglarPokemon.add(PokemonId.MACHOP.getValue());
        }
        if (difficulty >= 1.5) {
            burglarPokemon.add(PokemonId.ONIX.getValue());
        }

        if (difficulty >= 3) {
            burglarPokemon.add(PokemonId.DUGTRIO.getValue());
            burglarPokemon.add(PokemonId.ALOLAN_DUGTRIO.getValue());
            burglarPokemon.add(PokemonId.GRAVELER.getValue());
            burglarPokemon.add(PokemonId.ALOLAN_GRAVELER.getValue());
            burglarPokemon.add(PokemonId.MACHOKE.getValue());
        }

        if (difficulty >= 5) {
            burglarPokemon.add(PokemonId.GOLEM.getValue());
            burglarPokemon.add(PokemonId.MACHAMP.getValue());
        }
        return burglarPokemon;
    }

    public List<Integer> getJanitorPokemon(double difficulty) {
        List<Integer> janitorPokemon = new ArrayList<Integer>();
        if (difficulty <= 4.5) {
            janitorPokemon.add(PokemonId.RATTATA.getValue());
            janitorPokemon.add(PokemonId.GRIMER.getValue());
        }
        if (difficulty >= 2.5) {
            janitorPokemon.add(PokemonId.RATICATE.getValue());
        }
        if (difficulty >= 3.5) {
            janitorPokemon.add(PokemonId.MUK.getValue());

        }
        return janitorPokemon;
    }

    public List<Integer> getJugglerPokemon(double difficulty) {
        List<Integer> janitorPokemon = new ArrayList<Integer>();
        if (difficulty <= 4) {
            janitorPokemon.add(PokemonId.DROWZEE.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 5) {
            janitorPokemon.add(PokemonId.KADABRA.getValue());
        }
        if (difficulty >= 2.5) {
            janitorPokemon.add(PokemonId.MR_MIME.getValue());
        }
        if (difficulty >= 3.5) {
            janitorPokemon.add(PokemonId.HYPNO.getValue());
        }
        if (difficulty >= 5) {
            janitorPokemon.add(PokemonId.ALAKAZAM.getValue());
        }
        return janitorPokemon;
    }

    public List<Integer> getKimonoGirlPokemon(double difficulty) {
        List<Integer> janitorPokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            janitorPokemon.add(PokemonId.EEVEE.getValue());
        }
        if (difficulty >= 2.5) {
            janitorPokemon.add(PokemonId.FLAREON.getValue());
            janitorPokemon.add(PokemonId.JOLTEON.getValue());
            janitorPokemon.add(PokemonId.VAPOREON.getValue());

        }
        return janitorPokemon;
    }

    public List<Integer> getLadyPokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        bugCatcherPokemon.add(PokemonId.PIKACHU.getValue());
        if (difficulty >= 1.5 && difficulty <= 2.5) {
            bugCatcherPokemon.add(PokemonId.ODDISH.getValue());
        }
        if (difficulty >= 1.5 && difficulty <= 3.5) {
            bugCatcherPokemon.add(PokemonId.CLEFAIRY.getValue());
            bugCatcherPokemon.add(PokemonId.JIGGLYPUFF.getValue());
        }
        if (difficulty <= 3) {
            bugCatcherPokemon.add(PokemonId.MEOWTH.getValue());
            bugCatcherPokemon.add(PokemonId.VULPIX.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_VULPIX.getValue());
            bugCatcherPokemon.add(PokemonId.EEVEE.getValue());
        }
        if (difficulty >= 2.5) {
            bugCatcherPokemon.add(PokemonId.GLOOM.getValue());
        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.PERSIAN.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_PERSIAN.getValue());
        }
        if (difficulty >= 3.5) {
            bugCatcherPokemon.add(PokemonId.FLAREON.getValue());
            bugCatcherPokemon.add(PokemonId.JOLTEON.getValue());
            bugCatcherPokemon.add(PokemonId.VAPOREON.getValue());
        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.CLEFABLE.getValue());
            bugCatcherPokemon.add(PokemonId.WIGGLYTUFF.getValue());
            bugCatcherPokemon.add(PokemonId.VILEPLUME.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_NINETALES.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getMediumPokemon(double difficulty) {
        List<Integer> janitorPokemon = new ArrayList<Integer>();
        if (difficulty <= 3) {
            janitorPokemon.add(PokemonId.GASTLY.getValue());
        }
        if (difficulty >= 2.5) {
            janitorPokemon.add(PokemonId.HAUNTER.getValue());

        }
        if (difficulty >= 3 && difficulty <= 4.5) {
            janitorPokemon.add(PokemonId.SLOWPOKE.getValue());
            janitorPokemon.add(PokemonId.DROWZEE.getValue());
        }
        if (difficulty >= 3.5) {
            janitorPokemon.add(PokemonId.SLOWBRO.getValue());
            janitorPokemon.add(PokemonId.HYPNO.getValue());
        }
        if (difficulty >= 4.5) {
            janitorPokemon.add(PokemonId.GENGAR.getValue());
        }
        return janitorPokemon;
    }

    public List<Integer> getNursePokemon(double difficulty) {
        List<Integer> janitorPokemon = new ArrayList<Integer>();
        janitorPokemon.add(PokemonId.CHANSEY.getValue());
        return janitorPokemon;
    }

    public List<Integer> getParasolLadyPokemon(double difficulty) {
        List<Integer> janitorPokemon = new ArrayList<Integer>();
        if (difficulty <= 4) {
            janitorPokemon.add(PokemonId.GOLDEEN.getValue());
            janitorPokemon.add(PokemonId.PSYDUCK.getValue());
            janitorPokemon.add(PokemonId.STARYU.getValue());
            janitorPokemon.add(PokemonId.POLIWAG.getValue());
        }
        if (difficulty >= 3) {
            janitorPokemon.add(PokemonId.SEAKING.getValue());
            janitorPokemon.add(PokemonId.POLIWHIRL.getValue());
            janitorPokemon.add(PokemonId.STARMIE.getValue());
            janitorPokemon.add(PokemonId.GOLDUCK.getValue());
        }
        if (difficulty >= 4.5) {
            janitorPokemon.add(PokemonId.JOLTEON.getValue());

        }
        return janitorPokemon;
    }

    public List<Integer> getPicnickerMalePokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        if (difficulty <= 2.5) {
            bugCatcherPokemon.add(PokemonId.CHARMANDER.getValue());
            bugCatcherPokemon.add(PokemonId.SQUIRTLE.getValue());
            bugCatcherPokemon.add(PokemonId.BULBASAUR.getValue());
            bugCatcherPokemon.add(PokemonId.NIDORANM.getValue());
            bugCatcherPokemon.add(PokemonId.WEEDLE.getValue());
            bugCatcherPokemon.add(PokemonId.CATERPIE.getValue());
            bugCatcherPokemon.add(PokemonId.PIDGEY.getValue());
        }
        if (difficulty <= 3.5) {
            bugCatcherPokemon.add(PokemonId.SPEAROW.getValue());
            bugCatcherPokemon.add(PokemonId.MANKEY.getValue());
            bugCatcherPokemon.add(PokemonId.DIGLETT.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_DIGLETT.getValue());
            bugCatcherPokemon.add(PokemonId.PIKACHU.getValue());
            bugCatcherPokemon.add(PokemonId.MEOWTH.getValue());
            bugCatcherPokemon.add(PokemonId.RATTATA.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_RATTATA.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_MEOWTH.getValue());
            bugCatcherPokemon.add(PokemonId.SANDSHREW.getValue());
            bugCatcherPokemon.add(PokemonId.ODDISH.getValue());
            bugCatcherPokemon.add(PokemonId.BELLSPROUT.getValue());
        }
        if (difficulty >= 1 && difficulty <= 2) {
            bugCatcherPokemon.add(PokemonId.METAPOD.getValue());
            bugCatcherPokemon.add(PokemonId.KAKUNA.getValue());
        }
        if (difficulty >= 2 && difficulty <= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEOTTO.getValue());
            bugCatcherPokemon.add(PokemonId.CHARMELEON.getValue());
            bugCatcherPokemon.add(PokemonId.WARTORTLE.getValue());
            bugCatcherPokemon.add(PokemonId.IVYSAUR.getValue());
            bugCatcherPokemon.add(PokemonId.VENONAT.getValue());
            bugCatcherPokemon.add(PokemonId.EXEGGCUTE.getValue());
        }
        if (difficulty >= 2.5) {
            bugCatcherPokemon.add(PokemonId.SANDSLASH.getValue());
            bugCatcherPokemon.add(PokemonId.BEEDRILL.getValue());
            bugCatcherPokemon.add(PokemonId.BUTTERFREE.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_DUGTRIO.getValue());
            bugCatcherPokemon.add(PokemonId.DUGTRIO.getValue());
            bugCatcherPokemon.add(PokemonId.RATICATE.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_RATICATE.getValue());
            bugCatcherPokemon.add(PokemonId.GLOOM.getValue());
            bugCatcherPokemon.add(PokemonId.WEEPINBELL.getValue());
            bugCatcherPokemon.add(PokemonId.FARFETCHD.getValue());
            bugCatcherPokemon.add(PokemonId.NIDORINO.getValue());
        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.PARASECT.getValue());
            bugCatcherPokemon.add(PokemonId.VENOMOTH.getValue());
            bugCatcherPokemon.add(PokemonId.PERSIAN.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_PERSIAN.getValue());
        }

        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEOT.getValue());
            bugCatcherPokemon.add(PokemonId.FEAROW.getValue());
            bugCatcherPokemon.add(PokemonId.VILEPLUME.getValue());
            bugCatcherPokemon.add(PokemonId.VICTREEBEL.getValue());
            bugCatcherPokemon.add(PokemonId.EXEGGUTOR.getValue());
            bugCatcherPokemon.add(PokemonId.PINSIR.getValue());
            bugCatcherPokemon.add(PokemonId.SCYTHER.getValue());
            bugCatcherPokemon.add(PokemonId.MAROWAK.getValue());
            bugCatcherPokemon.add(PokemonId.PRIMEAPE.getValue());
        }
        if (difficulty >= 5) {
            bugCatcherPokemon.add(PokemonId.NIDOKING.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getPicnickerFemalePokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        if (difficulty <= 2.5) {
            bugCatcherPokemon.add(PokemonId.CHARMANDER.getValue());
            bugCatcherPokemon.add(PokemonId.SQUIRTLE.getValue());
            bugCatcherPokemon.add(PokemonId.BULBASAUR.getValue());
            bugCatcherPokemon.add(PokemonId.NIDORANM.getValue());
            bugCatcherPokemon.add(PokemonId.WEEDLE.getValue());
            bugCatcherPokemon.add(PokemonId.CATERPIE.getValue());
            bugCatcherPokemon.add(PokemonId.PIDGEY.getValue());
        }
        if (difficulty <= 3.5) {
            bugCatcherPokemon.add(PokemonId.CLEFAIRY.getValue());
            bugCatcherPokemon.add(PokemonId.JIGGLYPUFF.getValue());
            bugCatcherPokemon.add(PokemonId.DIGLETT.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_DIGLETT.getValue());
            bugCatcherPokemon.add(PokemonId.PIKACHU.getValue());
            bugCatcherPokemon.add(PokemonId.MEOWTH.getValue());
            bugCatcherPokemon.add(PokemonId.RATTATA.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_RATTATA.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_MEOWTH.getValue());
            bugCatcherPokemon.add(PokemonId.SANDSHREW.getValue());
            bugCatcherPokemon.add(PokemonId.ODDISH.getValue());
            bugCatcherPokemon.add(PokemonId.BELLSPROUT.getValue());
            bugCatcherPokemon.add(PokemonId.VULPIX.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_VULPIX.getValue());
        }

        if (difficulty >= 1 && difficulty <= 2) {
            bugCatcherPokemon.add(PokemonId.METAPOD.getValue());
            bugCatcherPokemon.add(PokemonId.KAKUNA.getValue());
        }
        if (difficulty >= 2 && difficulty <= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEOTTO.getValue());
            bugCatcherPokemon.add(PokemonId.CHARMELEON.getValue());
            bugCatcherPokemon.add(PokemonId.WARTORTLE.getValue());
            bugCatcherPokemon.add(PokemonId.IVYSAUR.getValue());
            bugCatcherPokemon.add(PokemonId.VENONAT.getValue());
            bugCatcherPokemon.add(PokemonId.EXEGGCUTE.getValue());
        }
        if (difficulty >= 2.5) {
            bugCatcherPokemon.add(PokemonId.SANDSLASH.getValue());
            bugCatcherPokemon.add(PokemonId.BEEDRILL.getValue());
            bugCatcherPokemon.add(PokemonId.BUTTERFREE.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_DUGTRIO.getValue());
            bugCatcherPokemon.add(PokemonId.DUGTRIO.getValue());
            bugCatcherPokemon.add(PokemonId.RATICATE.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_RATICATE.getValue());
            bugCatcherPokemon.add(PokemonId.GLOOM.getValue());
            bugCatcherPokemon.add(PokemonId.WEEPINBELL.getValue());
            bugCatcherPokemon.add(PokemonId.FARFETCHD.getValue());
            bugCatcherPokemon.add(PokemonId.NIDORINA.getValue());
        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.PARASECT.getValue());
            bugCatcherPokemon.add(PokemonId.VENOMOTH.getValue());
            bugCatcherPokemon.add(PokemonId.PERSIAN.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_PERSIAN.getValue());
        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEOT.getValue());
            bugCatcherPokemon.add(PokemonId.VILEPLUME.getValue());
            bugCatcherPokemon.add(PokemonId.VICTREEBEL.getValue());
            bugCatcherPokemon.add(PokemonId.EXEGGUTOR.getValue());
            bugCatcherPokemon.add(PokemonId.WIGGLYTUFF.getValue());
            bugCatcherPokemon.add(PokemonId.CLEFABLE.getValue());
            bugCatcherPokemon.add(PokemonId.RAICHU.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_RAICHU.getValue());
            bugCatcherPokemon.add(PokemonId.NINETALES.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_NINETALES.getValue());
        }
        if (difficulty >= 5) {
            bugCatcherPokemon.add(PokemonId.NIDORINA.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getWaiterPokemon(double difficulty) {
        List<Integer> waiterPokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            waiterPokemon.add(PokemonId.KRABBY.getValue());
        }
        if (difficulty <= 4) {
            waiterPokemon.add(PokemonId.SHELLDER.getValue());
            waiterPokemon.add(PokemonId.EXEGGCUTE.getValue());
        }
        if (difficulty >= 3) {
            waiterPokemon.add(PokemonId.KINGLER.getValue());
        }
        if (difficulty >= 3.5) {
            waiterPokemon.add(PokemonId.CLOYSTER.getValue());
            waiterPokemon.add(PokemonId.EXEGGUTOR.getValue());
        }
        return waiterPokemon;
    }

    public List<Integer> getBakerPokemon(double difficulty) {
        List<Integer> bakerPokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            bakerPokemon.add(PokemonId.MEOWTH.getValue());
            bakerPokemon.add(PokemonId.PIKACHU.getValue());
        }
        if (difficulty >= 3) {
            bakerPokemon.add(PokemonId.PERSIAN.getValue());
            bakerPokemon.add(PokemonId.RAICHU.getValue());
        }
        if (difficulty >= 3.5) {
            bakerPokemon.add(PokemonId.LICKITUNG.getValue());
            bakerPokemon.add(PokemonId.SNORLAX.getValue());
        }
        return bakerPokemon;
    }

    public List<Integer> getPolicePokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.MACHOP.getValue());
        }
        if (difficulty <= 4.5) {
            policePokemon.add(PokemonId.GROWLITHE.getValue());
        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.MACHOKE.getValue());
        }
        if (difficulty >= 3.5) {
            policePokemon.add(PokemonId.ARCANINE.getValue());
        }
        if (difficulty >= 4.5) {
            policePokemon.add(PokemonId.MACHAMP.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getPsychicPokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 2) {
            policePokemon.add(PokemonId.ABRA.getValue());
        }
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.GASTLY.getValue());
            policePokemon.add(PokemonId.EXEGGCUTE.getValue());
        }
        if (difficulty <= 4) {
            policePokemon.add(PokemonId.DROWZEE.getValue());
            policePokemon.add(PokemonId.SLOWPOKE.getValue());
        }
        if (difficulty >= 2) {
            policePokemon.add(PokemonId.KADABRA.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.HAUNTER.getValue());
            policePokemon.add(PokemonId.MR_MIME.getValue());
        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.HYPNO.getValue());
        }
        if (difficulty >= 3.5) {
            policePokemon.add(PokemonId.SLOWBRO.getValue());
            policePokemon.add(PokemonId.STARMIE.getValue());
        }
        if (difficulty >= 4) {
            policePokemon.add(PokemonId.ALOLAN_RAICHU.getValue());
        }
        if (difficulty >= 4.5) {
            policePokemon.add(PokemonId.GENGAR.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getRangerPokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3) {
            policePokemon.add(PokemonId.PARAS.getValue());
            policePokemon.add(PokemonId.ODDISH.getValue());
            policePokemon.add(PokemonId.BELLSPROUT.getValue());
            policePokemon.add(PokemonId.EXEGGCUTE.getValue());
        }
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.BULBASAUR.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.TANGELA.getValue());
            policePokemon.add(PokemonId.PARASECT.getValue());
            policePokemon.add(PokemonId.CHANSEY.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 4.5) {
            policePokemon.add(PokemonId.IVYSAUR.getValue());
            policePokemon.add(PokemonId.WEEPINBELL.getValue());
            policePokemon.add(PokemonId.GLOOM.getValue());

        }
        if (difficulty >= 3 && difficulty <= 4.5) {
            policePokemon.add(PokemonId.RHYHORN.getValue());
        }

        if (difficulty >= 3.5) {
            policePokemon.add(PokemonId.VICTREEBEL.getValue());
            policePokemon.add(PokemonId.VILEPLUME.getValue());
            policePokemon.add(PokemonId.EXEGGUTOR.getValue());
        }
        if (difficulty >= 4.5) {
            policePokemon.add(PokemonId.RHYDON.getValue());
            policePokemon.add(PokemonId.ALOLAN_EXEGGUTOR.getValue());
            policePokemon.add(PokemonId.VENUSAUR.getValue());
        }
        return policePokemon;

    }

    public List<Integer> getRichBoyPokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3) {
            policePokemon.add(PokemonId.SANDSHREW.getValue());
            policePokemon.add(PokemonId.ALOLAN_SANDSHREW.getValue());
            policePokemon.add(PokemonId.NIDORANF.getValue());
            policePokemon.add(PokemonId.NIDORANM.getValue());
            policePokemon.add(PokemonId.CUBONE.getValue());
            policePokemon.add(PokemonId.EKANS.getValue());
        }
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.GROWLITHE.getValue());
            policePokemon.add(PokemonId.EEVEE.getValue());
            policePokemon.add(PokemonId.VULPIX.getValue());
            policePokemon.add(PokemonId.ALOLAN_VULPIX.getValue());
            policePokemon.add(PokemonId.PSYDUCK.getValue());
            policePokemon.add(PokemonId.MEOWTH.getValue());
            policePokemon.add(PokemonId.ALOLAN_MEOWTH.getValue());
            policePokemon.add(PokemonId.PIKACHU.getValue());
            policePokemon.add(PokemonId.ZUBAT.getValue());
        }
        if (difficulty <= 4) {
            policePokemon.add(PokemonId.DRATINI.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.ARBOK.getValue());
            policePokemon.add(PokemonId.SANDSLASH.getValue());
            policePokemon.add(PokemonId.ALOLAN_SANDSLASH.getValue());
            policePokemon.add(PokemonId.GOLBAT.getValue());
            policePokemon.add(PokemonId.FARFETCHD.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 5) {
            policePokemon.add(PokemonId.NIDORINA.getValue());
            policePokemon.add(PokemonId.NIDORINO.getValue());
        }

        if (difficulty >= 3) {
            policePokemon.add(PokemonId.MAROWAK.getValue());
            policePokemon.add(PokemonId.PERSIAN.getValue());
            policePokemon.add(PokemonId.ALOLAN_PERSIAN.getValue());
        }
        if (difficulty >= 3.5) {
            policePokemon.add(PokemonId.RAICHU.getValue());
            policePokemon.add(PokemonId.SCYTHER.getValue());
            policePokemon.add(PokemonId.PINSIR.getValue());
            policePokemon.add(PokemonId.GOLDUCK.getValue());
        }
        if (difficulty >= 4.5) {
            policePokemon.add(PokemonId.NINETALES.getValue());
            policePokemon.add(PokemonId.ALOLAN_NINETALES.getValue());
            policePokemon.add(PokemonId.ARCANINE.getValue());
            policePokemon.add(PokemonId.JOLTEON.getValue());
            policePokemon.add(PokemonId.VAPOREON.getValue());
            policePokemon.add(PokemonId.FLAREON.getValue());
        }
        if (difficulty >= 5) {
            policePokemon.add(PokemonId.NIDOKING.getValue());
            policePokemon.add(PokemonId.NIDOQUEEN.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getRuneManiacPokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3) {
            policePokemon.add(PokemonId.SANDSHREW.getValue());
            policePokemon.add(PokemonId.DIGLETT.getValue());
            policePokemon.add(PokemonId.ALOLAN_DIGLETT.getValue());
            policePokemon.add(PokemonId.CUBONE.getValue());
            policePokemon.add(PokemonId.GEODUDE.getValue());
            policePokemon.add(PokemonId.ALOLAN_GEODUDE.getValue());
        }
        if (difficulty >= 1.5) {
            policePokemon.add(PokemonId.ONIX.getValue());
        }
        if (difficulty >= 2 && difficulty <= 4.5) {
            policePokemon.add(PokemonId.KABUTO.getValue());
            policePokemon.add(PokemonId.OMANYTE.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.SANDSLASH.getValue());
            policePokemon.add(PokemonId.ALOLAN_SANDSLASH.getValue());
        }
        if (difficulty >= 3 && difficulty <= 5) {
            policePokemon.add(PokemonId.GRAVELER.getValue());
            policePokemon.add(PokemonId.ALOLAN_GRAVELER.getValue());
        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.MAROWAK.getValue());
            policePokemon.add(PokemonId.DUGTRIO.getValue());
            policePokemon.add(PokemonId.ALOLAN_DUGTRIO.getValue());
        }

        if (difficulty >= 4) {
            policePokemon.add(PokemonId.KABUTOPS.getValue());
            policePokemon.add(PokemonId.OMASTAR.getValue());
        }
        if (difficulty >= 4.5) {
            policePokemon.add(PokemonId.GOLEM.getValue());
            policePokemon.add(PokemonId.ALOLAN_GOLEM.getValue());
            policePokemon.add(PokemonId.AERODACTYL.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getSagePokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.BELLSPROUT.getValue());
            policePokemon.add(PokemonId.GASTLY.getValue());
            policePokemon.add(PokemonId.ZUBAT.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.GOLBAT.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 5) {
            policePokemon.add(PokemonId.WEEPINBELL.getValue());
            policePokemon.add(PokemonId.HAUNTER.getValue());
        }

        if (difficulty >= 4) {
            policePokemon.add(PokemonId.VICTREEBEL.getValue());
        }
        if (difficulty >= 4.5) {
            policePokemon.add(PokemonId.GENGAR.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getSailorPokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.MACHOP.getValue());
            policePokemon.add(PokemonId.MANKEY.getValue());
            policePokemon.add(PokemonId.KRABBY.getValue());
            policePokemon.add(PokemonId.PSYDUCK.getValue());
            policePokemon.add(PokemonId.POLIWAG.getValue());
            policePokemon.add(PokemonId.TENTACOOL.getValue());
            policePokemon.add(PokemonId.HORSEA.getValue());
            policePokemon.add(PokemonId.SHELLDER.getValue());
            policePokemon.add(PokemonId.STARYU.getValue());
            policePokemon.add(PokemonId.SQUIRTLE.getValue());
            policePokemon.add(PokemonId.SEEL.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.RATICATE.getValue());
            policePokemon.add(PokemonId.ALOLAN_RATICATE.getValue());
            policePokemon.add(PokemonId.PRIMEAPE.getValue());
        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.TENTACRUEL.getValue());
            policePokemon.add(PokemonId.KINGLER.getValue());
            policePokemon.add(PokemonId.MACHOKE.getValue());
            policePokemon.add(PokemonId.GOLDUCK.getValue());
            policePokemon.add(PokemonId.SEADRA.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 4) {
            policePokemon.add(PokemonId.WARTORTLE.getValue());
            policePokemon.add(PokemonId.POLIWHIRL.getValue());
        }

        if (difficulty >= 4) {
            policePokemon.add(PokemonId.DEWGONG.getValue());
            policePokemon.add(PokemonId.STARMIE.getValue());
        }
        if (difficulty >= 4.5) {
            policePokemon.add(PokemonId.KANGASKHAN.getValue());
            policePokemon.add(PokemonId.BLASTOISE.getValue());
            policePokemon.add(PokemonId.GYARADOS.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getSchoolKidPokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        policePokemon.add(PokemonId.TANGELA.getValue());
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.MAGNEMITE.getValue());
            policePokemon.add(PokemonId.PARAS.getValue());
            policePokemon.add(PokemonId.POLIWAG.getValue());
            policePokemon.add(PokemonId.GROWLITHE.getValue());
            policePokemon.add(PokemonId.VOLTORB.getValue());
            policePokemon.add(PokemonId.EXEGGCUTE.getValue());
            policePokemon.add(PokemonId.DITTO.getValue());
            policePokemon.add(PokemonId.BELLSPROUT.getValue());
            policePokemon.add(PokemonId.ABRA.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.POLIWHIRL.getValue());
            policePokemon.add(PokemonId.KADABRA.getValue());
            policePokemon.add(PokemonId.PARASECT.getValue());
            policePokemon.add(PokemonId.GLOOM.getValue());
        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.MAGMAR.getValue());
            policePokemon.add(PokemonId.ELECTABUZZ.getValue());
            policePokemon.add(PokemonId.JYNX.getValue());
            policePokemon.add(PokemonId.MR_MIME.getValue());
            policePokemon.add(PokemonId.ELECTRODE.getValue());
            policePokemon.add(PokemonId.MAGNETON.getValue());
        }

        if (difficulty >= 4) {
            policePokemon.add(PokemonId.EXEGGUTOR.getValue());
            policePokemon.add(PokemonId.VILEPLUME.getValue());
            policePokemon.add(PokemonId.VICTREEBEL.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getScientistPokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.MAGNEMITE.getValue());
            policePokemon.add(PokemonId.VOLTORB.getValue());
            policePokemon.add(PokemonId.GRIMER.getValue());
            policePokemon.add(PokemonId.ALOLAN_GRIMER.getValue());
            policePokemon.add(PokemonId.KOFFING.getValue());

        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.ELECTRODE.getValue());
            policePokemon.add(PokemonId.MAGNETON.getValue());
        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.WEEZING.getValue());
            policePokemon.add(PokemonId.MUK.getValue());
            policePokemon.add(PokemonId.ALOLAN_MUK.getValue());
        }

        if (difficulty >= 4) {
            policePokemon.add(PokemonId.DITTO.getValue());
            policePokemon.add(PokemonId.PORYGON.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getSocialitePokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.MEOWTH.getValue());
            policePokemon.add(PokemonId.ALOLAN_MEOWTH.getValue());
            policePokemon.add(PokemonId.EEVEE.getValue());
            policePokemon.add(PokemonId.DRATINI.getValue());
            policePokemon.add(PokemonId.VULPIX.getValue());
            policePokemon.add(PokemonId.ALOLAN_VULPIX.getValue());
            policePokemon.add(PokemonId.PONYTA.getValue());
            policePokemon.add(PokemonId.EKANS.getValue());
            policePokemon.add(PokemonId.ODDISH.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.BUTTERFREE.getValue());
            policePokemon.add(PokemonId.PERSIAN.getValue());
            policePokemon.add(PokemonId.ALOLAN_PERSIAN.getValue());
            policePokemon.add(PokemonId.ARBOK.getValue());
        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.NINETALES.getValue());
            policePokemon.add(PokemonId.ALOLAN_NINETALES.getValue());
            policePokemon.add(PokemonId.DRAGONAIR.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 4.5) {
            policePokemon.add(PokemonId.GLOOM.getValue());
        }

        if (difficulty >= 3.5) {
            policePokemon.add(PokemonId.RAPIDASH.getValue());
        }
        if (difficulty >= 4) {
            policePokemon.add(PokemonId.LAPRAS.getValue());
            policePokemon.add(PokemonId.JOLTEON.getValue());
            policePokemon.add(PokemonId.FLAREON.getValue());
            policePokemon.add(PokemonId.VAPOREON.getValue());
            policePokemon.add(PokemonId.VILEPLUME.getValue());
        }
        if (difficulty >= 5) {
            policePokemon.add(PokemonId.DRAGONITE.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getSwimmerPokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.TENTACOOL.getValue());
            policePokemon.add(PokemonId.SQUIRTLE.getValue());
            policePokemon.add(PokemonId.GOLDEEN.getValue());
            policePokemon.add(PokemonId.SHELLDER.getValue());
            policePokemon.add(PokemonId.HORSEA.getValue());
            policePokemon.add(PokemonId.POLIWAG.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.TENTACRUEL.getValue());
            policePokemon.add(PokemonId.SEAKING.getValue());
            policePokemon.add(PokemonId.ALOLAN_PERSIAN.getValue());
            policePokemon.add(PokemonId.ARBOK.getValue());
        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.SEADRA.getValue());
            policePokemon.add(PokemonId.CLOYSTER.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 4.5) {
            policePokemon.add(PokemonId.WARTORTLE.getValue());
            policePokemon.add(PokemonId.POLIWHIRL.getValue());
        }
        if (difficulty >= 4) {
            policePokemon.add(PokemonId.POLIWRATH.getValue());
            policePokemon.add(PokemonId.LAPRAS.getValue());
            policePokemon.add(PokemonId.GYARADOS.getValue());
        }
        if (difficulty >= 5) {
            policePokemon.add(PokemonId.BLASTOISE.getValue());
            policePokemon.add(PokemonId.VAPOREON.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getTeacherPokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.CLEFAIRY.getValue());
            policePokemon.add(PokemonId.JIGGLYPUFF.getValue());
            policePokemon.add(PokemonId.CUBONE.getValue());
            policePokemon.add(PokemonId.ALOLAN_MEOWTH.getValue());
            policePokemon.add(PokemonId.MEOWTH.getValue());
            policePokemon.add(PokemonId.ABRA.getValue());
            policePokemon.add(PokemonId.EEVEE.getValue());
            policePokemon.add(PokemonId.PIKACHU.getValue());
            policePokemon.add(PokemonId.HORSEA.getValue());
            policePokemon.add(PokemonId.VENONAT.getValue());
            policePokemon.add(PokemonId.ALOLAN_VULPIX.getValue());
            policePokemon.add(PokemonId.VULPIX.getValue());
            policePokemon.add(PokemonId.SANDSHREW.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.MR_MIME.getValue());
            policePokemon.add(PokemonId.ALOLAN_PERSIAN.getValue());
            policePokemon.add(PokemonId.SANDSLASH.getValue());
            policePokemon.add(PokemonId.PERSIAN.getValue());
        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.SEADRA.getValue());
            policePokemon.add(PokemonId.VENOMOTH.getValue());
            policePokemon.add(PokemonId.RAICHU.getValue());
            policePokemon.add(PokemonId.ALOLAN_RAICHU.getValue());
            policePokemon.add(PokemonId.CLEFABLE.getValue());
            policePokemon.add(PokemonId.WIGGLYTUFF.getValue());
            policePokemon.add(PokemonId.MAROWAK.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 4.5) {
            policePokemon.add(PokemonId.KADABRA.getValue());
        }
        if (difficulty >= 4) {
            policePokemon.add(PokemonId.LAPRAS.getValue());
            policePokemon.add(PokemonId.JOLTEON.getValue());
            policePokemon.add(PokemonId.FLAREON.getValue());
            policePokemon.add(PokemonId.VAPOREON.getValue());
            policePokemon.add(PokemonId.ALAKAZAM.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getVeteranMalePokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        policePokemon.add(PokemonId.ELECTABUZZ.getValue());
        policePokemon.add(PokemonId.MAGMAR.getValue());
        policePokemon.add(PokemonId.TAUROS.getValue());
        policePokemon.add(PokemonId.SCYTHER.getValue());
        policePokemon.add(PokemonId.PINSIR.getValue());
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.MACHOP.getValue());
            policePokemon.add(PokemonId.ALOLAN_SANDSHREW.getValue());
            policePokemon.add(PokemonId.ALOLAN_VULPIX.getValue());
            policePokemon.add(PokemonId.ALOLAN_GRIMER.getValue());
            policePokemon.add(PokemonId.ALOLAN_GEODUDE.getValue());
            policePokemon.add(PokemonId.DRATINI.getValue());
            policePokemon.add(PokemonId.ZUBAT.getValue());
            policePokemon.add(PokemonId.EKANS.getValue());
            policePokemon.add(PokemonId.GROWLITHE.getValue());
            policePokemon.add(PokemonId.PONYTA.getValue());
            policePokemon.add(PokemonId.VULPIX.getValue());
            policePokemon.add(PokemonId.SANDSHREW.getValue());
            policePokemon.add(PokemonId.GRIMER.getValue());
            policePokemon.add(PokemonId.ALOLAN_RATTATA.getValue());
            policePokemon.add(PokemonId.RATTATA.getValue());
            policePokemon.add(PokemonId.RHYHORN.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.RATICATE.getValue());
            policePokemon.add(PokemonId.ALOLAN_RATICATE.getValue());
            policePokemon.add(PokemonId.SANDSLASH.getValue());
            policePokemon.add(PokemonId.ALOLAN_SANDSLASH.getValue());
            policePokemon.add(PokemonId.ARBOK.getValue());
            policePokemon.add(PokemonId.PARASECT.getValue());
            policePokemon.add(PokemonId.PRIMEAPE.getValue());

        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.GOLBAT.getValue());
            policePokemon.add(PokemonId.MUK.getValue());
            policePokemon.add(PokemonId.ALOLAN_MUK.getValue());
            policePokemon.add(PokemonId.TENTACRUEL.getValue());
            policePokemon.add(PokemonId.CLOYSTER.getValue());
            policePokemon.add(PokemonId.VENOMOTH.getValue());
            policePokemon.add(PokemonId.KANGASKHAN.getValue());
            policePokemon.add(PokemonId.KINGLER.getValue());
            policePokemon.add(PokemonId.SEADRA.getValue());

        }
        if (difficulty >= 3.5) {
            policePokemon.add(PokemonId.ARCANINE.getValue());
            policePokemon.add(PokemonId.RAPIDASH.getValue());
            policePokemon.add(PokemonId.NINETALES.getValue());
            policePokemon.add(PokemonId.ALOLAN_NINETALES.getValue());
            policePokemon.add(PokemonId.RHYDON.getValue());
            policePokemon.add(PokemonId.PIDGEOT.getValue());
            policePokemon.add(PokemonId.STARMIE.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 4.5) {
            policePokemon.add(PokemonId.ALOLAN_GRAVELER.getValue());
            policePokemon.add(PokemonId.MACHOKE.getValue());
            policePokemon.add(PokemonId.WEEPINBELL.getValue());
            policePokemon.add(PokemonId.PIDGEOTTO.getValue());
            policePokemon.add(PokemonId.NIDORINO.getValue());
            policePokemon.add(PokemonId.NIDORINA.getValue());
            policePokemon.add(PokemonId.HAUNTER.getValue());
        }

        if (difficulty >= 3 && difficulty <= 5) {
            policePokemon.add(PokemonId.DRAGONAIR.getValue());
        }
        if (difficulty >= 4) {
            policePokemon.add(PokemonId.GYARADOS.getValue());
            policePokemon.add(PokemonId.MACHAMP.getValue());
            policePokemon.add(PokemonId.FLAREON.getValue());
            policePokemon.add(PokemonId.VAPOREON.getValue());
            policePokemon.add(PokemonId.ALAKAZAM.getValue());
            policePokemon.add(PokemonId.SNORLAX.getValue());
            policePokemon.add(PokemonId.DRAGONITE.getValue());
            policePokemon.add(PokemonId.NIDOKING.getValue());
            policePokemon.add(PokemonId.NIDOQUEEN.getValue());
            policePokemon.add(PokemonId.LAPRAS.getValue());
            policePokemon.add(PokemonId.GENGAR.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getVeteranFemalePokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        policePokemon.add(PokemonId.ELECTABUZZ.getValue());
        policePokemon.add(PokemonId.MAGMAR.getValue());
        policePokemon.add(PokemonId.LICKITUNG.getValue());
        policePokemon.add(PokemonId.TANGELA.getValue());
        policePokemon.add(PokemonId.CHANSEY.getValue());

        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.JIGGLYPUFF.getValue());
            policePokemon.add(PokemonId.ALOLAN_SANDSHREW.getValue());
            policePokemon.add(PokemonId.ALOLAN_VULPIX.getValue());
            policePokemon.add(PokemonId.CLEFAIRY.getValue());
            policePokemon.add(PokemonId.ALOLAN_GEODUDE.getValue());
            policePokemon.add(PokemonId.DRATINI.getValue());
            policePokemon.add(PokemonId.ZUBAT.getValue());
            policePokemon.add(PokemonId.EKANS.getValue());
            policePokemon.add(PokemonId.GROWLITHE.getValue());
            policePokemon.add(PokemonId.PONYTA.getValue());
            policePokemon.add(PokemonId.VULPIX.getValue());
            policePokemon.add(PokemonId.SANDSHREW.getValue());
            policePokemon.add(PokemonId.GRIMER.getValue());
            policePokemon.add(PokemonId.ALOLAN_RATTATA.getValue());
            policePokemon.add(PokemonId.RATTATA.getValue());
            policePokemon.add(PokemonId.RHYHORN.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.RATICATE.getValue());
            policePokemon.add(PokemonId.ALOLAN_RATICATE.getValue());
            policePokemon.add(PokemonId.SANDSLASH.getValue());
            policePokemon.add(PokemonId.ALOLAN_SANDSLASH.getValue());
            policePokemon.add(PokemonId.ARBOK.getValue());
            policePokemon.add(PokemonId.PARASECT.getValue());
            policePokemon.add(PokemonId.PRIMEAPE.getValue());

        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.GOLBAT.getValue());
            policePokemon.add(PokemonId.MUK.getValue());
            policePokemon.add(PokemonId.ALOLAN_MUK.getValue());
            policePokemon.add(PokemonId.TENTACRUEL.getValue());
            policePokemon.add(PokemonId.CLOYSTER.getValue());
            policePokemon.add(PokemonId.VENOMOTH.getValue());
            policePokemon.add(PokemonId.KANGASKHAN.getValue());
            policePokemon.add(PokemonId.SEADRA.getValue());

        }

        if (difficulty >= 3.5) {
            policePokemon.add(PokemonId.WIGGLYTUFF.getValue());
            policePokemon.add(PokemonId.RAPIDASH.getValue());
            policePokemon.add(PokemonId.NINETALES.getValue());
            policePokemon.add(PokemonId.ALOLAN_NINETALES.getValue());
            policePokemon.add(PokemonId.CLEFABLE.getValue());
            policePokemon.add(PokemonId.VICTREEBEL.getValue());
            policePokemon.add(PokemonId.VILEPLUME.getValue());
            policePokemon.add(PokemonId.PIDGEOT.getValue());
            policePokemon.add(PokemonId.STARMIE.getValue());

        }
        if (difficulty >= 2.5 && difficulty <= 4.5) {
            policePokemon.add(PokemonId.ALOLAN_GRAVELER.getValue());
            policePokemon.add(PokemonId.MACHOKE.getValue());
            policePokemon.add(PokemonId.GLOOM.getValue());
            policePokemon.add(PokemonId.WEEPINBELL.getValue());
            policePokemon.add(PokemonId.PIDGEOTTO.getValue());
            policePokemon.add(PokemonId.NIDORINO.getValue());
            policePokemon.add(PokemonId.NIDORINA.getValue());
            policePokemon.add(PokemonId.HAUNTER.getValue());
        }

        if (difficulty >= 3 && difficulty <= 5) {
            policePokemon.add(PokemonId.DRAGONAIR.getValue());
        }
        if (difficulty >= 4) {
            policePokemon.add(PokemonId.GYARADOS.getValue());
            policePokemon.add(PokemonId.MACHAMP.getValue());
            policePokemon.add(PokemonId.FLAREON.getValue());
            policePokemon.add(PokemonId.VAPOREON.getValue());
            policePokemon.add(PokemonId.ALAKAZAM.getValue());
            policePokemon.add(PokemonId.SNORLAX.getValue());
            policePokemon.add(PokemonId.DRAGONITE.getValue());
            policePokemon.add(PokemonId.NIDOKING.getValue());
            policePokemon.add(PokemonId.NIDOQUEEN.getValue());
            policePokemon.add(PokemonId.LAPRAS.getValue());
            policePokemon.add(PokemonId.GENGAR.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getPilotPokemon(double difficulty) {
        List<Integer> bikerPokemon = new ArrayList<Integer>();
        if (difficulty <= 3) {
            bikerPokemon.add(PokemonId.PIDGEY.getValue());
            bikerPokemon.add(PokemonId.SPEAROW.getValue());
            bikerPokemon.add(PokemonId.MAGNEMITE.getValue());
            bikerPokemon.add(PokemonId.VOLTORB.getValue());
            bikerPokemon.add(PokemonId.ALOLAN_GEODUDE.getValue());
            bikerPokemon.add(PokemonId.PIKACHU.getValue());
        }
        if (difficulty >= 3) {
            bikerPokemon.add(PokemonId.FARFETCHD.getValue());
            bikerPokemon.add(PokemonId.RAICHU.getValue());
            bikerPokemon.add(PokemonId.MAGNETON.getValue());
            bikerPokemon.add(PokemonId.ELECTRODE.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 4) {
            bikerPokemon.add(PokemonId.DODUO.getValue());
            bikerPokemon.add(PokemonId.ALOLAN_GRAVELER.getValue());
        }
        if (difficulty >= 2.5) {
            bikerPokemon.add(PokemonId.PIDGEOTTO.getValue());
            bikerPokemon.add(PokemonId.FEAROW.getValue());
        }
        if (difficulty >= 3.5) {
            bikerPokemon.add(PokemonId.PIDGEOT.getValue());
            bikerPokemon.add(PokemonId.DODRIO.getValue());
        }
        if (difficulty >= 4) {
            bikerPokemon.add(PokemonId.ALOLAN_GOLEM.getValue());
        }
        return bikerPokemon;
    }

    public List<Integer> getConductorPokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.MAGNEMITE.getValue());
            policePokemon.add(PokemonId.VOLTORB.getValue());
            policePokemon.add(PokemonId.GRIMER.getValue());
            policePokemon.add(PokemonId.ALOLAN_GRIMER.getValue());
            policePokemon.add(PokemonId.KOFFING.getValue());
            policePokemon.add(PokemonId.ALOLAN_GEODUDE.getValue());
            policePokemon.add(PokemonId.SANDSHREW.getValue());
            policePokemon.add(PokemonId.DIGLETT.getValue());
            policePokemon.add(PokemonId.ALOLAN_RATTATA.getValue());
            policePokemon.add(PokemonId.RATTATA.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.ELECTRODE.getValue());
            policePokemon.add(PokemonId.MAGNETON.getValue());
            policePokemon.add(PokemonId.DUGTRIO.getValue());
            policePokemon.add(PokemonId.SANDSLASH.getValue());
            policePokemon.add(PokemonId.ALOLAN_RATICATE.getValue());
            policePokemon.add(PokemonId.RATICATE.getValue());
        }

        if (difficulty >= 2.5 && difficulty <= 4.5) {
            policePokemon.add(PokemonId.ALOLAN_GRAVELER.getValue());
        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.WEEZING.getValue());
            policePokemon.add(PokemonId.MUK.getValue());
            policePokemon.add(PokemonId.ALOLAN_MUK.getValue());
        }

        if (difficulty >= 4) {
            policePokemon.add(PokemonId.ALOLAN_GOLEM.getValue());
        }
        return policePokemon;
    }



    public Trainer getGymLeaderBrock() {
        String victoryText = "I took you for granted, and so I lost. As proof of\nyour victory" +
                "I confer on you this...the official\nPokémon League BoulderBadge.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Geodude g = new Geodude(12);
        List<Skill> gSkills = new ArrayList<Skill>();
        gSkills.add(new Tackle());
        g.setSkillset(gSkills);

        Onix o = new Onix(14);
        List<Skill> oSkills = new ArrayList<Skill>();
        oSkills.add(new Tackle());
        oSkills.add(new Bind());
        oSkills.add(new RockTomb());
        o.setSkillset(oSkills);

        party.add(g);
        party.add(o);
        return new Trainer(0, "Gym Leader", "Brock", victoryText, "trainers/small/brock.png", party,
                Trainer.Badge.KANTO_BADGE);
    }

    public Trainer getGymLeaderMisty() {
        String victoryText = "Wow! You're too much, all right! You can have\n" +
                "the CascadeBadge to show that you beat me.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Staryu g = new Staryu(18);

        List<Skill> gSkills = new ArrayList<Skill>();
        gSkills.add(new Tackle());
        gSkills.add(new Harden());
        gSkills.add(new WaterPulse());
        g.setSkillset(gSkills);

        Starmie o = new Starmie(21);
        List<Skill> oSkills = new ArrayList<Skill>();
        oSkills.add(new WaterPulse());
        o.setSkillset(oSkills);

        party.add(g);
        party.add(o);
        return new Trainer(0, "Gym Leader", "Misty", victoryText, "trainers/small/misty.png", party,
                Trainer.Badge.KANTO_BADGE);
    }

    public Trainer getGymLeaderLtSurge() {
        String victoryText = "Now that's a shocker! You're the real deal, kid!\n" +
                " Fine, then, take the ThunderBadge!";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Voltorb g = new Voltorb(21);
        List<Skill> gSkills = new ArrayList<Skill>();
        gSkills.add(new ThunderShock());
        g.setSkillset(gSkills);

        Pikachu o = new Pikachu(18);
        List<Skill> oSkills = new ArrayList<Skill>();
        oSkills.add(new WaterPulse());
        o.setSkillset(oSkills);

        Raichu r = new Raichu(24);
        List<Skill> rSkills = new ArrayList<Skill>();
        rSkills.add(new ThunderShock());
        r.setSkillset(rSkills);

        party.add(g);
        party.add(o);
        party.add(r);
        return new Trainer(0, "Gym Leader", "Lt. Surge", victoryText, "trainers/small/ltsurge.png",
                party, Trainer.Badge.KANTO_BADGE);
    }

    public Trainer getGymLeaderErika() {
        String victoryText = "Oh! I concede defeat. You are remarkably strong.\n" +
                "I must confer on you the RainbowBadge.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Victreebel g = new Victreebel(29);
        List<Skill> gSkills = new ArrayList<Skill>();
        gSkills.add(new GigaDrain());
        g.setSkillset(gSkills);

        Tangela o = new Tangela(24);
        List<Skill> oSkills = new ArrayList<Skill>();
        oSkills.add(new WaterPulse());
        o.setSkillset(oSkills);

        Vileplume r = new Vileplume(29);
        List<Skill> rSkills = new ArrayList<Skill>();
        rSkills.add(new GigaDrain());
        r.setSkillset(rSkills);

        party.add(g);
        party.add(o);
        party.add(r);
        return new Trainer(0, "Gym Leader", "Erika", victoryText, "trainers/small/erika.png", party,
                Trainer.Badge.KANTO_BADGE);
    }

    public Trainer getGymLeaderSabrina() {
        String victoryText = "This loss shocks me! But a loss is a loss. I admit\n" +
                "I didn't work hard enough to win. You earned the MarshBadge.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Kadabra g = new Kadabra(38);
        List<Skill> gSkills = new ArrayList<Skill>();
        gSkills.add(new FutureSight());
        g.setSkillset(gSkills);

        MrMime o = new MrMime(37);
        List<Skill> oSkills = new ArrayList<Skill>();
        oSkills.add(new Tackle());
        o.setSkillset(oSkills);

        Venomoth r = new Venomoth(38);
        List<Skill> rSkills = new ArrayList<Skill>();
        rSkills.add(new LeechLife());
        rSkills.add(new Gust());
        r.setSkillset(rSkills);

        Alakazam alakazam = new Alakazam(43);
        List<Skill> alakazamSkills = new ArrayList<Skill>();
        alakazamSkills.add(new FutureSight());
        alakazam.setSkillset(alakazamSkills);

        party.add(g);
        party.add(o);
        party.add(r);
        party.add(alakazam);
        return new Trainer(0, "Gym Leader", "Sabrina", victoryText, "trainers/small/sabrina.png",
                party, Trainer.Badge.KANTO_BADGE);
    }

    public Trainer getGymLeaderJanine() {
        String victoryText = "...!!! So... So strong!";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Koffing g = new Koffing(37);
        List<Skill> gSkills = new ArrayList<Skill>();
        gSkills.add(new SelfDestruct());
        g.setSkillset(gSkills);

        Muk o = new Muk(39);
        List<Skill> oSkills = new ArrayList<Skill>();
        oSkills.add(new Tackle());
        o.setSkillset(oSkills);

        Koffing r = new Koffing(37);
        List<Skill> rSkills = new ArrayList<Skill>();
        rSkills.add(new SelfDestruct());
        r.setSkillset(rSkills);

        Weezing weezing = new Weezing(43);
        List<Skill> weezingSkills = new ArrayList<Skill>();
        weezingSkills.add(new Tackle());
        weezing.setSkillset(weezingSkills);

        party.add(g);
        party.add(o);
        party.add(r);
        party.add(weezing);
        return new Trainer(0, "Gym Leader", "Janine", victoryText, "trainers/small/janine.png",
                party, Trainer.Badge.KANTO_BADGE);
    }

    public Trainer getGymLeaderBlaine() {
        String victoryText = "I have burned down to nothing! Not even ashes remain!\n" +
                "You have earned the VolcanoBadge.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Growlithe g = new Growlithe(42);
        List<Skill> gSkills = new ArrayList<Skill>();
        gSkills.add(new Bite());
        gSkills.add(new TakeDown());
        gSkills.add(new FireBlast());
        g.setSkillset(gSkills);

        Ponyta o = new Ponyta(40);
        List<Skill> oSkills = new ArrayList<Skill>();
        oSkills.add(new Bounce());
        oSkills.add(new FireSpin());
        oSkills.add(new FireBlast());
        o.setSkillset(oSkills);

        Rapidash r = new Rapidash(42);
        List<Skill> rSkills = new ArrayList<Skill>();
        rSkills.add(new Bounce());
        rSkills.add(new FireSpin());
        rSkills.add(new FireBlast());
        r.setSkillset(rSkills);

        Arcanine arcanine = new Arcanine(47);
        List<Skill> arcanineSkills = new ArrayList<Skill>();
        arcanineSkills.add(new Bite());
        arcanineSkills.add(new TakeDown());
        arcanineSkills.add(new FireBlast());
        arcanine.setSkillset(arcanineSkills);

        party.add(g);
        party.add(o);
        party.add(r);
        party.add(arcanine);
        return new Trainer(0, "Gym Leader", "Blaine", victoryText, "trainers/small/blaine.png",
                party, Trainer.Badge.KANTO_BADGE);
    }

    public Trainer getGymLeaderBlue() {
        String victoryText = "What? How the heck did I lose to you? … \n" +
                "Tch, all right… Here, take this-- it's EarthBadge.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Pidgeot g = new Pidgeot(56);
        List<Skill> gSkills = new ArrayList<Skill>();
        gSkills.add(new QuickAttack());
        gSkills.add(new WingAttack());
        g.setSkillset(gSkills);

        Alakazam o = new Alakazam(54);
        List<Skill> oSkills = new ArrayList<Skill>();
        oSkills.add(new Tackle());
        o.setSkillset(oSkills);

        Rhydon r = new Rhydon(56);
        List<Skill> rSkills = new ArrayList<Skill>();
        rSkills.add(new Sandstorm());
        rSkills.add(new RockSlide());
        r.setSkillset(rSkills);

        Gyarados gyarados = new Gyarados(58);
        List<Skill> gyaradosSkills = new ArrayList<Skill>();
        gyaradosSkills.add(new Twister());
        gyaradosSkills.add(new HydroPump());
        gyaradosSkills.add(new RainDance());
        gyarados.setSkillset(gyaradosSkills);

        Exeggutor exeggutor = new Exeggutor(58);
        List<Skill> exeggutorSkills = new ArrayList<Skill>();
        exeggutorSkills.add(new SunnyDay());
        exeggutorSkills.add(new LeechLife());
        exeggutorSkills.add(new SolarBeam());
        exeggutor.setSkillset(exeggutorSkills);

        Arcanine arcanine = new Arcanine(58);
        List<Skill> arcanineSkills = new ArrayList<Skill>();
        arcanineSkills.add(new Flamethrower());
        arcanine.setSkillset(arcanineSkills);

        party.add(g);
        party.add(o);
        party.add(r);
        party.add(gyarados);
        party.add(exeggutor);
        party.add(arcanine);
        return new Trainer(0, "Gym Leader", "Blue", victoryText, "trainers/small/blue.png", party,
                Trainer.Badge.KANTO_BADGE);
    }

    public WildTrainer getBugCatcher(double difficulty, double latitude, double longitude) {
        String title = "Bug Catcher";
        String name = getMaleName();
        List<Integer> pool = getBugCatcherPokemon(difficulty);
        double rand = Math.random();
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(),"trainers/small/bugcatcher.png",
                initParty(pool, difficulty));
    }

    public WildTrainer getTeacher(double difficulty, double latitude, double longitude) {
        String title = "Teacher";
        String name = getFemaleName();
        List<Integer> pool = getTeacherPokemon(difficulty);
        double rand = Math.random();
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(),"trainers/small/teacher.png",
                initParty(pool, difficulty));
    }

    public WildTrainer getLass(double difficulty, double latitude, double longitude) {
        String title = "Lass";
        String name = getFemaleName();
        List<Integer> pool = getLassPokemon(difficulty);
        String iconPath;
        double rand = Math.random();
        if (rand <= .33) {
            iconPath = "trainers/small/lass.png";
        } else if (rand <= .66) {
            iconPath = "trainers/small/lass2.png";
        } else {
            iconPath = "trainers/small/lass3.png";
        }
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(),iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getYoungster(double difficulty, double latitude, double longitude) {
        String title = "Youngster";
        String name = getMaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            iconPath = "trainers/small/youngster.png";
        } else {
            iconPath = "trainers/small/youngster2.png";
        }
        List<Integer> pool = getYoungsterPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getScientist(double difficulty, double latitude, double longitude) {
        String title = "Scientist";
        String name = getMaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .33) {
            iconPath = "trainers/small/scientist.png";
        } else if (rand <= .66){
            iconPath = "trainers/small/scientist2.png";
        } else {
            iconPath = "trainers/small/scientist3.png";
        }
        List<Integer> pool = getScientistPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getPsychic(double difficulty, double latitude, double longitude) {
        String title = "Psychic";
        String name;
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            name = getMaleName();
            iconPath = "trainers/small/psychicm.png";
        } else {
            name = getFemaleName();
            iconPath = "trainers/small/psychicf.png";
        }
        List<Integer> pool = getPsychicPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getSwimmer(double difficulty, double latitude, double longitude) {
        String title = "Swimmer";
        String name;
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            name = getMaleName();
            if (rand <= .25) {
                iconPath = "trainers/small/swimmer.png";
            } else {
                iconPath = "trainers/small/swimmer2.png";
            }
        } else {
            name = getFemaleName();
            if (rand <= .75) {
                iconPath = "trainers/small/swimmerf.png";
            } else {
                iconPath = "trainers/small/swimmer2f.png";
            }
        }
        List<Integer> pool = getSwimmerPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getSchoolKid(double difficulty, double latitude, double longitude) {
        String title;
        String name;
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            title = "School Boy";
            name = getMaleName();
            iconPath = "trainers/small/schoolboy.png";
        } else {
            title = "School Girl";
            name = getFemaleName();
            iconPath = "trainers/small/schoolgirl.png";
        }
        List<Integer> pool = getSchoolKidPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getRanger(double difficulty, double latitude, double longitude) {
        String title = "Ranger";
        String name;
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            name = getMaleName();
            iconPath = "trainers/small/ranger.png";
        } else {
            name = getFemaleName();
            iconPath = "trainers/small/rangerf.png";
        }
        List<Integer> pool = getRangerPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getWaiter(double difficulty, double latitude, double longitude) {
        String title;
        String name;
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            title = "Waiter";
            name = getMaleName();
            iconPath = "trainers/small/waiter.png";
        } else {
            title = "Waitress";
            name = getFemaleName();
            iconPath = "trainers/small/waitress.png";
        }
        List<Integer> pool = getWaiterPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getDragonTamer(double difficulty, double latitude, double longitude) {
        String title = "Dragon Tamer";
        String name = getMaleName();
        String iconPath = "trainers/small/dragontamer.png";

        List<Integer> pool = getDragonTamerPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getPilotPokemon(double difficulty, double latitude, double longitude) {
        String title = "Pilot";
        String name = getMaleName();
        String iconPath = "trainers/small/pilot.png";

        List<Integer> pool = getPilotPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getConductorPokemon(double difficulty, double latitude, double longitude) {
        String title = "Conductor";
        String name = getMaleName();
        String iconPath = "trainers/small/conductor.png";

        List<Integer> pool = getConductorPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getVeteranMale(double difficulty, double latitude, double longitude) {
        String title = "Veteran";
        String name = getMaleName();
        String iconPath = "trainers/small/veteran.png";

        List<Integer> pool = getVeteranMalePokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getVeteranFemale(double difficulty, double latitude, double longitude) {
        String title = "Veteran";
        String name = getFemaleName();
        String iconPath = "trainers/small/veteranf.png";

        List<Integer> pool = getVeteranFemalePokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getSocialite(double difficulty, double latitude, double longitude) {
        String title = "Socialite";
        String name = getFemaleName();
        String iconPath = "trainers/small/socialite.png";

        List<Integer> pool = getSocialitePokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getRichBoy(double difficulty, double latitude, double longitude) {
        String title = "Rich Boy";
        String name = getMaleName();
        String iconPath = "trainers/small/richboy.png";

        List<Integer> pool = getRichBoyPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getRuneManiac(double difficulty, double latitude, double longitude) {
        String title = "Rune Maniac";
        String name = getMaleName();
        String iconPath = "trainers/small/runemaniac.png";

        List<Integer> pool = getRuneManiacPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getSage(double difficulty, double latitude, double longitude) {
        String title = "Sage";
        String name = getMaleName();
        String iconPath = "trainers/small/sage.png";

        List<Integer> pool = getSagePokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getSailor(double difficulty, double latitude, double longitude) {
        String title = "Sailor";
        String name = getMaleName();
        String iconPath = "trainers/small/sailor.png";

        List<Integer> pool = getSailorPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getFirebreather(double difficulty, double latitude, double longitude) {
        String title = "Firebreather";
        String name = getMaleName();
        String iconPath = "trainers/small/firebreather.png";

        List<Integer> pool = getFirebreatherPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getHiker(double difficulty, double latitude, double longitude) {
        String title = "Hiker";
        String name = getMaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            iconPath = "trainers/small/hiker.png";
        } else {
            iconPath = "trainers/small/hiker2.png";
        }
        List<Integer> pool = getHikerPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getFisherman(double difficulty, double latitude, double longitude) {
        String title = "Fisherman";
        String name = getMaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            iconPath = "trainers/small/fisherman.png";
        } else {
            iconPath = "trainers/small/fisherman2.png";
        }
        List<Integer> pool = getFishermanPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getKimonoGirl(double difficulty, double latitude, double longitude) {
        String title = "Kimono Girl";
        String name = getFemaleName();
        String iconPath = "trainers/small/kimonogirl.png";

        List<Integer> pool = getKimonoGirlPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getAromaLady(double difficulty, double latitude, double longitude) {
        String title = "Aroma Lady";
        String name = getFemaleName();
        String iconPath = "trainers/small/aromalady.png";

        List<Integer> pool = getAromaLadyPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getBlackbelt(double difficulty, double latitude, double longitude) {
        String title = "Blackbelt";
        String name = getMaleName();
        String iconPath = "trainers/small/blackbelt.png";

        List<Integer> pool = getBlackbeltPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getPicnickerMale(double difficulty, double latitude, double longitude) {
        String title = "Picnicker";
        String name = getMaleName();
        String iconPath = "trainers/small/picnickerm.png";
        List<Integer> pool = getPicnickerMalePokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getPicnickerFemale(double difficulty, double latitude, double longitude) {
        String title = "Picnicker";
        String name = getMaleName();
        String iconPath = "trainers/small/picnickerf.png";
        List<Integer> pool = getPicnickerFemalePokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getDoctor(double difficulty, double latitude, double longitude) {
        String title = "Doctor";
        String name = getMaleName();
        String iconPath = "trainers/small/doctor.png";

        List<Integer> pool = getDoctorPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getBirdKeeper(double difficulty, double latitude, double longitude) {
        String title = "Bird Keeper";
        String name = getMaleName();
        String iconPath = "trainers/small/birdkeeper.png";

        List<Integer> pool = getBirdKeeperPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getGambler(double difficulty, double latitude, double longitude) {
        String title = "Gambler";
        String name = getMaleName();
        String iconPath = "trainers/small/gambler.png";

        List<Integer> pool = getGamblerPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getGentleman(double difficulty, double latitude, double longitude) {
        String title = "Gentleman";
        String name = getMaleName();
        String iconPath = "trainers/small/gentleman.png";

        List<Integer> pool = getGentlemanPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getJuggler(double difficulty, double latitude, double longitude) {
        String title = "Juggler";
        String name = getMaleName();
        String iconPath = "trainers/small/juggler.png";

        List<Integer> pool = getJugglerPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getNurse(double difficulty, double latitude, double longitude) {
        String title = "Nurse";
        String name = getFemaleName();
        String iconPath = "trainers/small/nurse.png";

        List<Integer> pool = getNursePokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getAceTrainerMale(double difficulty, double latitude, double longitude) {
        String title = "Ace Trainer";
        String name = getMaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .33) {
            iconPath = "trainers/small/acetrainer.png";
        } else if (rand <= .66){
            iconPath = "trainers/small/acetrainer2.png";
        } else {
            iconPath = "trainers/small/acetrainer3.png";
        }

        List<Integer> pool = getAceTrainerMalePokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getAceTrainerFemale(double difficulty, double latitude, double longitude) {
        String title = "Ace Trainer";
        String name = getFemaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .33) {
            iconPath = "trainers/small/acetrainerf.png";
        } else if (rand <= .66){
            iconPath = "trainers/small/acetrainerf2.png";
        } else {
            iconPath = "trainers/small/acetrainerf3.png";
        }

        List<Integer> pool = getAceTrainerFemalePokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getBattleGirl(double difficulty, double latitude, double longitude) {
        String title = "Battle Girl";
        String name = getFemaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            iconPath = "trainers/small/battlegirl.png";
        } else {
            iconPath = "trainers/small/battlegirl2.png";
        }

        List<Integer> pool = getBattleGirlPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getBeauty(double difficulty, double latitude, double longitude) {
        String title = "Beauty";
        String name = getFemaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            iconPath = "trainers/small/beauty.png";
        } else {
            iconPath = "trainers/small/beauty2.png";
        }

        List<Integer> pool = getBeautyPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getLady(double difficulty, double latitude, double longitude) {
        String title = "Lady";
        String name = getFemaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            iconPath = "trainers/small/lady.png";
        } else {
            iconPath = "trainers/small/lady2.png";
        }

        List<Integer> pool = getLadyPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getParasolLady(double difficulty, double latitude, double longitude) {
        String title = "Parasol Lady";
        String name = getFemaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            iconPath = "trainers/small/parasollady.png";
        } else {
            iconPath = "trainers/small/parasollady2.png";
        }

        List<Integer> pool = getParasolLadyPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getBaker(double difficulty, double latitude, double longitude) {
        String title = "Baker";
        String name = getFemaleName();
        String iconPath = "trainers/small/baker.png";

        List<Integer> pool = getBakerPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getMedium(double difficulty, double latitude, double longitude) {
        String title = "Medium";
        String name = getFemaleName();
        String iconPath = "trainers/small/medium.png";

        List<Integer> pool = getMediumPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getPolice(double difficulty, double latitude, double longitude) {
        String title = "Police Officer";
        String name = getMaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .7) {
            iconPath = "trainers/small/policeman2.png";
        } else {
            iconPath = "trainers/small/policeman.png";
        }
        List<Integer> pool = getPolicePokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getCueBall(double difficulty, double latitude, double longitude) {
        String title = "Cue Ball";
        String name = getMaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            iconPath = "trainers/small/cueball.png";
        } else {
            iconPath = "trainers/small/cueball2.png";
        }

        List<Integer> pool = getCueBallPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getBiker(double difficulty, double latitude, double longitude) {
        String title = "Biker";
        String name = getMaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            iconPath = "trainers/small/biker.png";
        } else {
            iconPath = "trainers/small/biker2.png";
        }

        List<Integer> pool = getBikerPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getBurglar(double difficulty, double latitude, double longitude) {
        String title = "Burglar";
        String name = getMaleName();
        String iconPath = "trainers/small/burglar.png";

        List<Integer> pool = getBurglarPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getJanitor(double difficulty, double latitude, double longitude) {
        String title = "Janitor";
        String name = getMaleName();
        String iconPath = "trainers/small/janitor.png";

        List<Integer> pool = getJanitorPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public void getPicnickerMale() {
        String title = "Picnicker";
        String name = getMaleName();
    }

    public void getPicnickerFemale() {
        String title = "Picnicker";
        String name = getFemaleName();
    }
}
