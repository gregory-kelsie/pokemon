package com.pokemon.toronto.game.com.pokemon.toronto.trainer.trivial;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonLookup;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.WildPokemonCreator;
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
