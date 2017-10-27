package com.pokemon.toronto.game.com.pokemon.toronto.trainer.trivial;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pikachu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.PokemonId;
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

import java.io.BufferedReader;
import java.io.InputStream;
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
        } else if (id == TrainerId.YOUNGSTER.getValue()) {
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
        } else {
            return getYoungster(difficulty, latlng[0], latlng[1]);
        }
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
        return new Trainer(0, "Gym Leader", "Brock", victoryText, "trainers/small/brock.png", party);
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
        return new Trainer(0, "Gym Leader", "Misty", victoryText, "trainers/small/misty.png", party);
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
        return new Trainer(0, "Gym Leader", "Lt. Surge", victoryText, "trainers/small/ltsurge.png", party);
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
        return new Trainer(0, "Gym Leader", "Erika", victoryText, "trainers/small/erika.png", party);
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
        return new Trainer(0, "Gym Leader", "Sabrina", victoryText, "trainers/small/sabrina.png", party);
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
        return new Trainer(0, "Gym Leader", "Janine", victoryText, "trainers/small/janine.png", party);
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
        return new Trainer(0, "Gym Leader", "Blaine", victoryText, "trainers/small/blaine.png", party);
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
        return new Trainer(0, "Gym Leader", "Blue", victoryText, "trainers/small/blue.png", party);
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

    public WildTrainer getBaker(double difficulty, double latitude, double longitude) {
        String title = "Baker";
        String name = getFemaleName();
        String iconPath = "trainers/small/baker.png";

        List<Integer> pool = getBakerPokemon(difficulty);
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
