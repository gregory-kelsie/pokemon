package com.pokemon.toronto.game.com.pokemon.toronto.location;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.TrainerId;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Gregory on 9/14/2017.
 */

public class PokemonPlace {

    private final int AIRPORT = 2;
    private final int AMUSEMENT_PARK = 3;
    private final int AQUARIUM = 4;
    private final int BAKERY = 7;
    private final int BEAUTY_SALON = 10;

    private final int CAMPGROUND = 16;
    private final int PARK = 69;
    private final int RV_PARK = 81;

    private final int PET_STORE = 71;
    private final int VETERINARIAN = 95;

    private final int CASINO = 21;

    private final int CEMETARY = 22;

    private final int CHURCH = 23;
    private final int HINDU_TEMPLE = 48;
    private final int PLACE_OF_WORSHIP = 74;
    private final int MOSQUE = 62;
    private final int SYNAGOGUE = 90;

    private final int DOCTOR = 30;
    private final int HOSPITAL = 50;

    private final int ELECTRONICS_STORE = 32;

    private final int FIRE_STATION = 36;

    private final int FLORIST = 37;

    private final int GYM = 44;
    private final int STADIUM = 86;

    private final int MOVING_COMPANY = 65;

    private final int MUSEUM = 66;

    private final int NATURAL_FEATURE = 1010;

    private final int SUBWAY_STATION = 89;
    private final int TRAIN_STATION = 92;

    private final int UNIVERSITY = 94;
    private final int SCHOOL = 82;

    private final int ZOO = 96;

    private final int RESTAURANT = 79;
    private final int SPA = 85;
    private final int POLICE = 76;
    private final int PHARMACY = 72;
    private final int LIQUOR_STORE = 56;
    private final int LIBRARY = 55;
    private final int JEWELRY_STORE = 52;
    private final int BANK = 8;


    private String name;
    private double latitude;
    private double longitude;
    
    private Set<Integer> ubiquitous; //45%
    private Set<Integer> common; // 20%
    private Set<Integer> uncommon; //15%
    private Set<Integer> kindaRare; // 10%
    private Set<Integer> rare; //5%
    private Set<Integer> superRare; //4%
    private Set<Integer> megaRare; //.75%
    private Set<Integer> ultraRare; //.25%;
    

    private int difficulty;

    private final int EARLY_DIFFICULTY = 0;
    private final int EARLY_MID_DIFFICULTY = 1;
    private final int MID_LATE_DIFFICULTY = 2;

    //Early
    //Early Mid
    //Mid Late
    private Set<Integer> trainers;

    public PokemonPlace(String name, double latitude, double longitude, List<Integer> types, int difficulty) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.difficulty = difficulty;
        initPokemon(types);

    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public boolean hasPokemon() {
        if (ubiquitous.size() > 0) {
            return true;
        } else if (common.size() > 0) {
            return true;
        } else if (uncommon.size() > 0) {
            return true;
        } else if (kindaRare.size() > 0) {
            return true;
        } else if (rare.size() > 0) {
            return true;
        } else if (superRare.size() > 0) {
            return true;
        } else if (megaRare.size() > 0) {
            return true;
        } else if (ultraRare.size() > 0) {
            return true;
        }
        return false;
    }

    public int getPokemon() {
        if (hasPokemon()) {
            double rand = Math.random();
            if (rand >= .55) { //Common 45%
                if (ubiquitous.size() > 0) {
                    return getPokemon(ubiquitous);
                }
            } else if (rand >= .35) { //Uncommon 1 20%
                if (common.size() > 0) {
                    return getPokemon(common);
                }
            } else if (rand >= .20) { //Uncommon 3 15%
                if (uncommon.size() > 0) {
                    return getPokemon(uncommon);
                }
            } else if (rand >= .1) { //Uncommon 4 10%
                if (kindaRare.size() > 0) {
                    return getPokemon(kindaRare);
                }
            } else if (rand >= .05) { //Kinda Rare 5%
                if (rare.size() > 0) {
                    return getPokemon(rare);
                }
            } else if (rand >= .01) {  //Kinda Rare 4%
                if (superRare.size() > 0) {
                    return getPokemon(superRare);
                }
            } else if (rand >= .0025) { // Rare 1 .75%
                if (megaRare.size() > 0) {
                    return getPokemon(megaRare);
                }
            } else { //.25%
                if (ultraRare.size() > 0) {
                    return getPokemon(ultraRare);
                }
            }
            return -1;
        }
        return -1;
    }

    /**
     * Return a Set of Trainer IDs that would be found in this place.
     */
    public Set<Integer> getTrainers() {
        return trainers;
    }

    private int getPokemon(Set<Integer> pokemonSet) {
        int size = pokemonSet.size();
        if (size > 0) {
            List<Integer> setToList = new ArrayList<Integer>(pokemonSet);
            return setToList.get((int)Math.round(Math.random() * (size - 1)));
        }
        return -1;
    }


    private void initPokemon(List<Integer> types) {
        ubiquitous = new HashSet<Integer>(); //45%
        common = new HashSet<Integer>(); // 20%
        uncommon = new HashSet<Integer>(); //15%
        kindaRare = new HashSet<Integer>(); // 10%
        rare = new HashSet<Integer>(); //5%
        superRare = new HashSet<Integer>(); //4%
        megaRare = new HashSet<Integer>(); //.75%
        ultraRare = new HashSet<Integer>(); //.25%

        trainers = new HashSet<Integer>();
        for (int i = 0; i < types.size(); i++) {
            addPokemon(types.get(i));
        }
    }

    private void addPokemon(int type) {
        if (type == AIRPORT) {
            addAirportPokemon();
            addAirportTrainers();
        } else if (type == AMUSEMENT_PARK) {
            addAmusementParkPokemon();
            addAmusementParkTrainers();
        } else if (type == AQUARIUM) {
            addAquariumPokemon();
            addAquariumTrainers();
        } else if (type == BAKERY) {
            addBakeryPokemon();
            addBakeryTrainers();
        } else if (type == BEAUTY_SALON) {
            addBeautySalonPokemon();
            addBeautySalonTrainers();
        } else if (type == CAMPGROUND || type == RV_PARK ||
                type == PARK) {
            addParkPokemon();
            addParkTrainers();
        } else if (type == PET_STORE || type == VETERINARIAN) {
            addPetPokemon();
            addPetTrainers();
        } else if (type == CASINO) {
            addCasinoPokemon();
            addCasinoTrainers();
        } else if (type == CEMETARY) {
            addCemetaryPokemon();
            addCemetaryTrainers();
        } else if (type == CHURCH || type == MOSQUE || type == SYNAGOGUE ||
                type == PLACE_OF_WORSHIP || type == HINDU_TEMPLE) {
            addChurchPokemon();
            addChurchTrainers();
        } else if (type == DOCTOR || type == HOSPITAL) {
            addHospitalPokemon();
            addHospitalTrainers();
        } else if (type == ELECTRONICS_STORE) {
            addElectronicStorePokemon();
        } else if (type == FIRE_STATION) {
            addFireStationPokemon();
        } else if (type == FLORIST) {
            addFloristPokemon();
            addFloristTrainers();
        } else if (type == GYM || type == STADIUM) {
            addGymPokemon();
            addGymTrainers();
        } else if (type == MOVING_COMPANY) {
            addMovingPokemon();
        } else if (type == MUSEUM) {
            addMuseumPokemon();
            addMuseumTrainers();
        } else if (type == NATURAL_FEATURE) {
            addNaturalFeaturePokemon();
            addNaturalFeatureTrainers();
        } else if (type == SUBWAY_STATION || type == TRAIN_STATION) {
            addTrainStationPokemon();
            addTrainStationTrainers();
        } else if (type == UNIVERSITY || type == SCHOOL) {
            addSchoolPokemon();
            addSchoolTrainers();
        } else if (type == ZOO) {
            addZooPokemon();
            addParkTrainers();
        } else if (type == RESTAURANT) {
            addRestaurantTrainers();
        } else if (type == SPA) {
            addSpaTrainers();
        } else if (type == POLICE) {
            addPoliceTrainers();
        } else if (type == PHARMACY) {
            addPharmacyTrainers();
        } else if (type == LIQUOR_STORE) {
            addLiquorStoreTrainers();
        } else if (type == LIBRARY) {
            addLibraryTrainers();
        } else if (type == JEWELRY_STORE) {
            addJeweleryStoreTrainers();
        } else if (type == BANK) {
            addBankTrainers();
        }
    }

    private void addRestaurantTrainers() {
        trainers.add(TrainerId.WAITER.getValue());
        trainers.add(TrainerId.WAITRESS.getValue());
        trainers.add(TrainerId.BAKER.getValue());
    }

    private void addSpaTrainers() {
        addBeautySalonTrainers();
    }

    private void addPoliceTrainers() {
        trainers.add(TrainerId.POLICEMAN.getValue());
        trainers.add(TrainerId.CUE_BALL.getValue());
        trainers.add(TrainerId.BURGLAR.getValue());
    }

    private void addPharmacyTrainers() {
        trainers.add(TrainerId.SCIENTIST.getValue());
    }

    private  void addLiquorStoreTrainers() {
        trainers.add(TrainerId.BIKER.getValue());
        trainers.add(TrainerId.CUE_BALL.getValue());
    }

    private void addLibraryTrainers() {
        addMuseumTrainers();
    }

    private void addJeweleryStoreTrainers() {
        trainers.add(TrainerId.BURGLAR.getValue());
        addBeautySalonTrainers();
    }

    private void addBankTrainers() {
        trainers.add(TrainerId.BURGLAR.getValue());
        trainers.add(TrainerId.POLICEMAN.getValue());
    }

    private void addAirportTrainers() {
        trainers.add(TrainerId.PILOT.getValue());
        trainers.add(TrainerId.JANITOR.getValue());
        trainers.add(TrainerId.RICH_BOY.getValue());
        trainers.add(TrainerId.SOCIALITE.getValue());
        trainers.add(TrainerId.GENTLEMAN.getValue());
        trainers.add(TrainerId.LADY.getValue());
        trainers.add(TrainerId.VETERAN_FEMALE.getValue());
        trainers.add(TrainerId.VETERAN_MALE.getValue());
    }

    private void addAmusementParkTrainers() {
        trainers.add(TrainerId.FIRE_BREATHER.getValue());
        trainers.add(TrainerId.JUGGLER.getValue());
        trainers.add(TrainerId.CONDUCTOR.getValue());
        trainers.add(TrainerId.PSYCHIC.getValue());
        trainers.add(TrainerId.DRAGON_TAMER.getValue());
    }

    private void addAquariumTrainers() {
        trainers.add(TrainerId.TEACHER.getValue());
        trainers.add(TrainerId.SCHOOL_KID.getValue());
        trainers.add(TrainerId.SWIMMER.getValue());
        trainers.add(TrainerId.FISHERMAN.getValue());
    }

    private void addBakeryTrainers() {
        trainers.add(TrainerId.BAKER.getValue());
    }

    private void addBeautySalonTrainers() {
        trainers.add(TrainerId.LADY.getValue());
        trainers.add(TrainerId.BEAUTY.getValue());
        trainers.add(TrainerId.PARASOL_LADY.getValue());
        trainers.add(TrainerId.SOCIALITE.getValue());
    }

    private void addParkTrainers() {
        trainers.add(TrainerId.HIKER.getValue());
        trainers.add(TrainerId.PICNICKER_FEMALE.getValue());
        trainers.add(TrainerId.PICNICKER_MALE.getValue());
        trainers.add(TrainerId.RANGER.getValue());
        trainers.add(TrainerId.BIRD_KEEPER.getValue());
        trainers.add(TrainerId.BUG_CATCHER.getValue());
    }

    private void addPetTrainers() {
        trainers.add(TrainerId.BIRD_KEEPER.getValue());
        trainers.add(TrainerId.BUG_CATCHER.getValue());
        trainers.add(TrainerId.LASS.getValue());
        trainers.add(TrainerId.YOUNGSTER.getValue());
    }

    private void addCasinoTrainers() {
        trainers.add(TrainerId.GAMBLER.getValue());
        trainers.add(TrainerId.GENTLEMAN.getValue());
        trainers.add(TrainerId.SOCIALITE.getValue());
        trainers.add(TrainerId.BEAUTY.getValue());
        trainers.add(TrainerId.VETERAN_MALE.getValue());
        trainers.add(TrainerId.VETERAN_FEMALE.getValue());
    }

    private void addCemetaryTrainers() {
        trainers.add(TrainerId.SAGE.getValue());
        trainers.add(TrainerId.MEDIUM.getValue());
        trainers.add(TrainerId.BURGLAR.getValue());
        trainers.add(TrainerId.GENTLEMAN.getValue());
        trainers.add(TrainerId.SOCIALITE.getValue());
    }

    private void addChurchTrainers() {
        trainers.add(TrainerId.GENTLEMAN.getValue());
        trainers.add(TrainerId.SOCIALITE.getValue());
        trainers.add(TrainerId.LADY.getValue());
    }

    private void addHospitalTrainers() {
        trainers.add(TrainerId.NURSE.getValue());
        trainers.add(TrainerId.DOCTOR.getValue());
        trainers.add(TrainerId.JANITOR.getValue());
        trainers.add(TrainerId.SCIENTIST.getValue());
    }

    private void addFloristTrainers() {
        trainers.add(TrainerId.AROMA_LADY.getValue());
        trainers.add(TrainerId.BEAUTY.getValue());
        trainers.add(TrainerId.LADY.getValue());
        trainers.add(TrainerId.PARASOL_LADY.getValue());
        trainers.add(TrainerId.GENTLEMAN.getValue());
        trainers.add(TrainerId.SOCIALITE.getValue());
    }

    private void addGymTrainers() {
        trainers.add(TrainerId.BATTLE_GIRL.getValue());
        trainers.add(TrainerId.BLACKBELT.getValue());
        trainers.add(TrainerId.ACE_TRAINER_FEMALE.getValue());
        trainers.add(TrainerId.ACE_TRAINER_MALE.getValue());
    }

    private void addMuseumTrainers() {
        trainers.add(TrainerId.RUNE_MANIAC.getValue());
        trainers.add(TrainerId.SCIENTIST.getValue());
        trainers.add(TrainerId.GENTLEMAN.getValue());
        trainers.add(TrainerId.SOCIALITE.getValue());
        trainers.add(TrainerId.TEACHER.getValue());
        trainers.add(TrainerId.SCHOOL_KID.getValue());
    }

    private void addNaturalFeatureTrainers() {
        addParkTrainers();
        trainers.add(TrainerId.SWIMMER.getValue());
        trainers.add(TrainerId.FISHERMAN.getValue());
    }

    private void addTrainStationTrainers() {
        trainers.add(TrainerId.CONDUCTOR.getValue());
        trainers.add(TrainerId.JANITOR.getValue());
        trainers.add(TrainerId.SCIENTIST.getValue());
    }

    private void addSchoolTrainers() {
        trainers.add(TrainerId.TEACHER.getValue());
        trainers.add(TrainerId.SCHOOL_KID.getValue());
        trainers.add(TrainerId.LASS.getValue());
        trainers.add(TrainerId.YOUNGSTER.getValue());
    }

    private void addAirportPokemon() {
        /*
        PIDGEY
        SPEAROW
        DODUO
        Magnemite
         */
        if (difficulty == EARLY_DIFFICULTY) {
            ubiquitous.add(PokemonId.MAGNEMITE.getValue());
            ubiquitous.add(PokemonId.SPINDA.getValue());
            common.add(PokemonId.PIDGEY.getValue());
            uncommon.add(PokemonId.SPEAROW.getValue());
            kindaRare.add(PokemonId.DODUO.getValue());
            rare.add(PokemonId.VOLTORB.getValue());
            superRare.add(PokemonId.FARFETCHD.getValue());
            superRare.add(PokemonId.MINIOR.getValue());
            megaRare.add(PokemonId.SKARMORY.getValue());
            ultraRare.add(PokemonId.SKARMORY.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            ubiquitous.add(PokemonId.MAGNEMITE.getValue());
            ubiquitous.add(PokemonId.SPINDA.getValue());
            common.add(PokemonId.PIDGEY.getValue());
            uncommon.add(PokemonId.SPEAROW.getValue());
            kindaRare.add(PokemonId.DODUO.getValue());
            kindaRare.add(PokemonId.VOLTORB.getValue());
            rare.add(PokemonId.PIDGEOTTO.getValue());
            superRare.add(PokemonId.FARFETCHD.getValue());
            superRare.add(PokemonId.MINIOR.getValue());
            megaRare.add(PokemonId.SKARMORY.getValue());
            ultraRare.add(PokemonId.SKARMORY.getValue());
        } else {
            ubiquitous.add(PokemonId.PIDGEOTTO.getValue());
            ubiquitous.add(PokemonId.SPINDA.getValue());
            common.add(PokemonId.FEAROW.getValue());
            uncommon.add(PokemonId.VOLTORB.getValue());
            kindaRare.add(PokemonId.DODUO.getValue());
            kindaRare.add(PokemonId.ELECTRODE.getValue());
            rare.add(PokemonId.MAGNETON.getValue());
            superRare.add(PokemonId.FARFETCHD.getValue());
            superRare.add(PokemonId.MINIOR.getValue());
            megaRare.add(PokemonId.SKARMORY.getValue());
            ultraRare.add(PokemonId.SKARMORY.getValue());
        }
    }

    private void addAmusementParkPokemon() {
        /*
        Drowzee
        Abra
        Mr Mime
        Jinx
        Tauros - Rare
        */

        if (difficulty == EARLY_DIFFICULTY) {
            ubiquitous.add(PokemonId.DROWZEE.getValue());
            common.add(PokemonId.SPOINK.getValue());
            uncommon.add(PokemonId.ESPURR.getValue());
            uncommon.add(PokemonId.SWIRLIX.getValue());
            kindaRare.add(PokemonId.MANKEY.getValue());
            rare.add(PokemonId.LITLEO.getValue());
            superRare.add(PokemonId.AIPOM.getValue());
            megaRare.add(PokemonId.MR_MIME.getValue());
            megaRare.add(PokemonId.FENNEKIN.getValue());
            ultraRare.add(PokemonId.JYNX.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            ubiquitous.add(PokemonId.DROWZEE.getValue());
            common.add(PokemonId.SPOINK.getValue());
            uncommon.add(PokemonId.ESPURR.getValue());
            uncommon.add(PokemonId.SWIRLIX.getValue());
            kindaRare.add(PokemonId.KADABRA.getValue());
            rare.add(PokemonId.LITLEO.getValue());
            rare.add(PokemonId.KECLEON.getValue());
            superRare.add(PokemonId.AIPOM.getValue());
            superRare.add(PokemonId.HAWLUCHA.getValue());
            megaRare.add(PokemonId.MR_MIME.getValue());
            megaRare.add(PokemonId.ORANGURU.getValue());
            megaRare.add(PokemonId.BRAIXEN.getValue());
            ultraRare.add(PokemonId.TAUROS.getValue());
        } else {
            ubiquitous.add(PokemonId.DROWZEE.getValue());
            common.add(PokemonId.PRIMEAPE.getValue());
            common.add(PokemonId.SPOINK.getValue());
            uncommon.add(PokemonId.KADABRA.getValue());
            uncommon.add(PokemonId.SWIRLIX.getValue());
            kindaRare.add(PokemonId.HYPNO.getValue());
            kindaRare.add(PokemonId.MEOWSTIC.getValue());
            rare.add(PokemonId.GRUMPIG.getValue());
            rare.add(PokemonId.LITLEO.getValue());
            rare.add(PokemonId.MAGMAR.getValue());
            rare.add(PokemonId.KECLEON.getValue());
            superRare.add(PokemonId.AIPOM.getValue());
            superRare.add(PokemonId.HAWLUCHA.getValue());
            megaRare.add(PokemonId.MR_MIME.getValue());
            megaRare.add(PokemonId.ORANGURU.getValue());
            megaRare.add(PokemonId.BRAIXEN.getValue());
            ultraRare.add(PokemonId.TAUROS.getValue());
        }

    }

    private void addAquariumPokemon() {
        /*
        Squirtle
        Tentacool
        Seel
        Horsea
        Goldeen
        Staryu
        Vaporeon - Super rare
        Dratini - Super rare
         */
        if (difficulty == EARLY_DIFFICULTY) {
            ubiquitous.add(PokemonId.TENTACOOL.getValue());
            ubiquitous.add(PokemonId.CLAMPERL.getValue());
            common.add(PokemonId.MAGIKARP.getValue());
            uncommon.add(PokemonId.GOLDEEN.getValue());
            uncommon.add(PokemonId.REMORAID.getValue());
            uncommon.add(PokemonId.WISHIWASHI.getValue());
            kindaRare.add(PokemonId.SEEL.getValue());
            kindaRare.add(PokemonId.QWILFISH.getValue());
            kindaRare.add(PokemonId.CHINCHOU.getValue());
            kindaRare.add(PokemonId.INKAY.getValue());
            rare.add(PokemonId.HORSEA.getValue());
            rare.add(PokemonId.CORSOLA.getValue());
            rare.add(PokemonId.PYUKUMUKU.getValue());
            rare.add(PokemonId.CLAUNCHER.getValue());
            rare.add(PokemonId.SPHEAL.getValue());
            superRare.add(PokemonId.STARYU.getValue());
            superRare.add(PokemonId.SKRELP.getValue());
            superRare.add(PokemonId.MANTINE.getValue());
            megaRare.add(PokemonId.SQUIRTLE.getValue());
            megaRare.add(PokemonId.POPPLIO.getValue());
            ultraRare.add(PokemonId.DRATINI.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            ubiquitous.add(PokemonId.TENTACOOL.getValue());
            ubiquitous.add(PokemonId.CLAMPERL.getValue());
            common.add(PokemonId.MAGIKARP.getValue());
            uncommon.add(PokemonId.GOLDEEN.getValue());
            uncommon.add(PokemonId.REMORAID.getValue());
            kindaRare.add(PokemonId.SEEL.getValue());
            kindaRare.add(PokemonId.QWILFISH.getValue());
            kindaRare.add(PokemonId.CHINCHOU.getValue());
            kindaRare.add(PokemonId.WISHIWASHI.getValue());
            kindaRare.add(PokemonId.INKAY.getValue());
            rare.add(PokemonId.HORSEA.getValue());
            rare.add(PokemonId.SEADRA.getValue());
            rare.add(PokemonId.CORSOLA.getValue());
            rare.add(PokemonId.PYUKUMUKU.getValue());
            rare.add(PokemonId.CLAUNCHER.getValue());
            rare.add(PokemonId.SPHEAL.getValue());
            superRare.add(PokemonId.MAREANIE.getValue());
            superRare.add(PokemonId.BRUXISH.getValue());
            superRare.add(PokemonId.STARYU.getValue());
            superRare.add(PokemonId.MANTINE.getValue());
            rare.add(PokemonId.SKRELP.getValue());
            rare.add(PokemonId.SEALEO.getValue());
            megaRare.add(PokemonId.SQUIRTLE.getValue());
            megaRare.add(PokemonId.WARTORTLE.getValue());
            megaRare.add(PokemonId.POPPLIO.getValue());
            megaRare.add(PokemonId.BRIONNE.getValue());
            ultraRare.add(PokemonId.DRATINI.getValue());
            ultraRare.add(PokemonId.WIMPOD.getValue());
            ultraRare.add(PokemonId.VAPOREON.getValue());
        } else {
            ubiquitous.add(PokemonId.TENTACOOL.getValue());
            ubiquitous.add(PokemonId.CLAMPERL.getValue());
            ubiquitous.add(PokemonId.TENTACRUEL.getValue());
            common.add(PokemonId.GOLDEEN.getValue());
            common.add(PokemonId.REMORAID.getValue());
            uncommon.add(PokemonId.SEEL.getValue());
            uncommon.add(PokemonId.QWILFISH.getValue());
            uncommon.add(PokemonId.CHINCHOU.getValue());
            kindaRare.add(PokemonId.SEAKING.getValue());
            kindaRare.add(PokemonId.DEWGONG.getValue());
            kindaRare.add(PokemonId.WISHIWASHI.getValue());
            kindaRare.add(PokemonId.INKAY.getValue());
            rare.add(PokemonId.GYARADOS.getValue());
            rare.add(PokemonId.SEADRA.getValue());
            rare.add(PokemonId.CORSOLA.getValue());
            rare.add(PokemonId.LANTURN.getValue());
            rare.add(PokemonId.PYUKUMUKU.getValue());
            rare.add(PokemonId.CLAUNCHER.getValue());
            rare.add(PokemonId.SEALEO.getValue());
            superRare.add(PokemonId.STARYU.getValue());
            superRare.add(PokemonId.MAREANIE.getValue());
            superRare.add(PokemonId.BRUXISH.getValue());
            superRare.add(PokemonId.MANTINE.getValue());
            superRare.add(PokemonId.SKRELP.getValue());
            superRare.add(PokemonId.OCTILLERY.getValue());
            megaRare.add(PokemonId.SQUIRTLE.getValue());
            megaRare.add(PokemonId.WARTORTLE.getValue());
            ultraRare.add(PokemonId.DRATINI.getValue());
            ultraRare.add(PokemonId.DRAGONAIR.getValue());
            ultraRare.add(PokemonId.WIMPOD.getValue());
            ultraRare.add(PokemonId.VAPOREON.getValue());
        }

    }

    private void addBakeryPokemon() {
        /*
        Snorlax
        Lickitung
        */
    }

    private void addBeautySalonPokemon() {
        /*
        Jigglypuff
        Clefairy - Rare
        Jinx - Super Rare
        Chansey - Super Rare
         */
        if (difficulty == EARLY_DIFFICULTY) {
            ubiquitous.add(PokemonId.CUTIEFLY.getValue());
            ubiquitous.add(PokemonId.VOLBEAT.getValue());
            ubiquitous.add(PokemonId.ILLUMISE.getValue());
            common.add(PokemonId.BONUSWEET.getValue());
            common.add(PokemonId.LUVDISC.getValue());
            uncommon.add(PokemonId.JIGGLYPUFF.getValue());
            uncommon.add(PokemonId.CLEFAIRY.getValue());
            kindaRare.add(PokemonId.COMFEY.getValue());
            kindaRare.add(PokemonId.SPRITZEE.getValue());
            rare.add(PokemonId.IGGLYBUFF.getValue());
            rare.add(PokemonId.CLEFFA.getValue());
            rare.add(PokemonId.FURFROU.getValue());
            superRare.add(PokemonId.JYNX.getValue());
            superRare.add(PokemonId.SNORUNT.getValue());
            megaRare.add(PokemonId.SMOOCHUM.getValue());
            ultraRare.add(PokemonId.TOGEPI.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            ubiquitous.add(PokemonId.CUTIEFLY.getValue());
            ubiquitous.add(PokemonId.VOLBEAT.getValue());
            ubiquitous.add(PokemonId.ILLUMISE.getValue());
            common.add(PokemonId.STEENEE.getValue());
            common.add(PokemonId.LUVDISC.getValue());
            uncommon.add(PokemonId.JIGGLYPUFF.getValue());
            uncommon.add(PokemonId.CLEFAIRY.getValue());
            kindaRare.add(PokemonId.COMFEY.getValue());
            kindaRare.add(PokemonId.SPRITZEE.getValue());
            rare.add(PokemonId.IGGLYBUFF.getValue());
            rare.add(PokemonId.CLEFFA.getValue());
            rare.add(PokemonId.FURFROU.getValue());
            superRare.add(PokemonId.BEAUTIFLY.getValue());
            superRare.add(PokemonId.JYNX.getValue());
            superRare.add(PokemonId.SNORUNT.getValue());
            megaRare.add(PokemonId.SMOOCHUM.getValue());
            ultraRare.add(PokemonId.TOGEPI.getValue());
        }
        else {
            ubiquitous.add(PokemonId.RIBOMBEE.getValue());
            ubiquitous.add(PokemonId.VOLBEAT.getValue());
            ubiquitous.add(PokemonId.ILLUMISE.getValue());
            common.add(PokemonId.STEENEE.getValue());
            common.add(PokemonId.LUVDISC.getValue());
            uncommon.add(PokemonId.JIGGLYPUFF.getValue());
            uncommon.add(PokemonId.CLEFAIRY.getValue());
            kindaRare.add(PokemonId.COMFEY.getValue());
            kindaRare.add(PokemonId.SPRITZEE.getValue());
            rare.add(PokemonId.JYNX.getValue());
            rare.add(PokemonId.BEAUTIFLY.getValue());
            rare.add(PokemonId.FURFROU.getValue());
            superRare.add(PokemonId.FURFROU.getValue());
            superRare.add(PokemonId.SMOOCHUM.getValue());
            superRare.add(PokemonId.GLALIE.getValue());
            megaRare.add(PokemonId.WIGGLYTUFF.getValue());
            megaRare.add(PokemonId.CLEFABLE.getValue());
            ultraRare.add(PokemonId.TOGEPI.getValue());
        }
    }

    private void addParkPokemon() {
        /*
        Nidorans
        Diglett
        Bulbasaur
        Oddish
        Bellsprout
        Tangela - Rare
        Paras
        Ekans
        Psyduck
        Venonat
        Scyther - Super Rare
        Pinsir - Super Rare
        Farfetch'd - Rare
         */
        if (difficulty == EARLY_DIFFICULTY) {
            ubiquitous.add(PokemonId.SENTRET.getValue());
            ubiquitous.add(PokemonId.PIDGEY.getValue());
            ubiquitous.add(PokemonId.HOPPIP.getValue());
            common.add(PokemonId.NIDORANM.getValue());
            common.add(PokemonId.NIDORANF.getValue());
            common.add(PokemonId.WINGULL.getValue());
            common.add(PokemonId.YUNGOOS.getValue());
            common.add(PokemonId.LEDYBA.getValue());
            common.add(PokemonId.SUNKERN.getValue());
            uncommon.add(PokemonId.BUNNELBY.getValue());
            uncommon.add(PokemonId.TAILLOW.getValue());
            uncommon.add(PokemonId.BELLSPROUT.getValue());
            uncommon.add(PokemonId.PARAS.getValue());
            uncommon.add(PokemonId.ODDISH.getValue());
            kindaRare.add(PokemonId.SHROOMISH.getValue());
            kindaRare.add(PokemonId.SEEDOT.getValue());
            kindaRare.add(PokemonId.PSYDUCK.getValue());
            kindaRare.add(PokemonId.MORELULL.getValue());
            kindaRare.add(PokemonId.FOMANTIS.getValue());
            rare.add(PokemonId.FLETCHLING.getValue());
            rare.add(PokemonId.TRAPINCH.getValue());
            superRare.add(PokemonId.TANGELA.getValue());
            superRare.add(PokemonId.PINECO.getValue());
            superRare.add(PokemonId.STANTLER.getValue());
            megaRare.add(PokemonId.BULBASAUR.getValue());
            megaRare.add(PokemonId.TREECKO.getValue());
            megaRare.add(PokemonId.ROWLET.getValue());
            ultraRare.add(PokemonId.CHIKORITA.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            ubiquitous.add(PokemonId.SENTRET.getValue());
            ubiquitous.add(PokemonId.PIDGEY.getValue());
            ubiquitous.add(PokemonId.HOPPIP.getValue());
            ubiquitous.add(PokemonId.NIDORANM.getValue());
            ubiquitous.add(PokemonId.NIDORANF.getValue());
            ubiquitous.add(PokemonId.LEDYBA.getValue());
            ubiquitous.add(PokemonId.SUNKERN.getValue());
            ubiquitous.add(PokemonId.YUNGOOS.getValue());
            common.add(PokemonId.NIDORINO.getValue());
            common.add(PokemonId.NIDORINA.getValue());
            common.add(PokemonId.WINGULL.getValue());
            common.add(PokemonId.PIDGEOTTO.getValue());
            uncommon.add(PokemonId.BUNNELBY.getValue());
            uncommon.add(PokemonId.TAILLOW.getValue());
            uncommon.add(PokemonId.BELLSPROUT.getValue());
            uncommon.add(PokemonId.ODDISH.getValue());
            uncommon.add(PokemonId.PARAS.getValue());
            uncommon.add(PokemonId.PSYDUCK.getValue());
            uncommon.add(PokemonId.MORELULL.getValue());
            uncommon.add(PokemonId.FOMANTIS.getValue());
            kindaRare.add(PokemonId.SHROOMISH.getValue());
            kindaRare.add(PokemonId.NUZLEAF.getValue());
            kindaRare.add(PokemonId.WEEPINBELL.getValue());
            kindaRare.add(PokemonId.GLOOM.getValue());
            kindaRare.add(PokemonId.FURRET.getValue());
            rare.add(PokemonId.FLETCHLING.getValue());
            rare.add(PokemonId.FLETCHINDER.getValue());
            rare.add(PokemonId.TRAPINCH.getValue());
            superRare.add(PokemonId.TANGELA.getValue());
            superRare.add(PokemonId.PINECO.getValue());
            superRare.add(PokemonId.STANTLER.getValue());
            megaRare.add(PokemonId.BULBASAUR.getValue());
            megaRare.add(PokemonId.CHIKORITA.getValue());
            megaRare.add(PokemonId.TREECKO.getValue());
            megaRare.add(PokemonId.ROWLET.getValue());
            megaRare.add(PokemonId.SUDOWOODO.getValue());
            ultraRare.add(PokemonId.SCYTHER.getValue());
            ultraRare.add(PokemonId.PINSIR.getValue());
            ultraRare.add(PokemonId.HERACROSS.getValue());
        } else {
            ubiquitous.add(PokemonId.FURRET.getValue());
            ubiquitous.add(PokemonId.PIDGEOTTO.getValue());
            ubiquitous.add(PokemonId.SKIPLOOM.getValue());
            ubiquitous.add(PokemonId.NIDORINA.getValue());
            ubiquitous.add(PokemonId.NIDORINA.getValue());
            ubiquitous.add(PokemonId.LEDIAN.getValue());
            common.add(PokemonId.GUMSHOOS.getValue());
            common.add(PokemonId.GLOOM.getValue());
            common.add(PokemonId.PELIPPER.getValue());
            common.add(PokemonId.WEEPINBELL.getValue());
            uncommon.add(PokemonId.TAILLOW.getValue());
            uncommon.add(PokemonId.PSYDUCK.getValue());
            uncommon.add(PokemonId.MORELULL.getValue());
            uncommon.add(PokemonId.FOMANTIS.getValue());
            kindaRare.add(PokemonId.PARASECT.getValue());
            kindaRare.add(PokemonId.SHROOMISH.getValue());
            kindaRare.add(PokemonId.NUZLEAF.getValue());
            rare.add(PokemonId.FLETCHINDER.getValue());
            rare.add(PokemonId.DIGGERSBY.getValue());
            rare.add(PokemonId.VIBRAVA.getValue());
            superRare.add(PokemonId.TANGELA.getValue());
            superRare.add(PokemonId.STANTLER.getValue());
            superRare.add(PokemonId.PINECO.getValue());
            megaRare.add(PokemonId.IVYSAUR.getValue());
            megaRare.add(PokemonId.DARTRIX.getValue());
            megaRare.add(PokemonId.BAYLEEF.getValue());
            megaRare.add(PokemonId.GROVYLE.getValue());
            megaRare.add(PokemonId.SUDOWOODO.getValue());
            ultraRare.add(PokemonId.SCYTHER.getValue());
            ultraRare.add(PokemonId.PINSIR.getValue());
            ultraRare.add(PokemonId.HERACROSS.getValue());
        }
    }

    private void addPetPokemon() {
        /*
        Pikachu
        Meowth
        Sandshrew
         */
        if (difficulty == EARLY_DIFFICULTY || difficulty == EARLY_MID_DIFFICULTY) {
            ubiquitous.add(PokemonId.SENTRET.getValue());
            ubiquitous.add(PokemonId.PIDGEY.getValue());
            ubiquitous.add(PokemonId.RATTATA.getValue());
            common.add(PokemonId.MEOWTH.getValue());
            common.add(PokemonId.PIKACHU.getValue());
            common.add(PokemonId.SNUBBULL.getValue());
            uncommon.add(PokemonId.MARILL.getValue());
            uncommon.add(PokemonId.BUNNELBY.getValue());
            kindaRare.add(PokemonId.NIDORANM.getValue());
            kindaRare.add(PokemonId.NIDORANF.getValue());
            kindaRare.add(PokemonId.ELECTRIKE.getValue());
            rare.add(PokemonId.ALOLAN_RATTATA.getValue());
            rare.add(PokemonId.AZURILL.getValue());
            rare.add(PokemonId.PLUSLE.getValue());
            rare.add(PokemonId.MINUN.getValue());
            superRare.add(PokemonId.ALOLAN_MEOWTH.getValue());
            megaRare.add(PokemonId.LITTEN.getValue());
            ultraRare.add(PokemonId.EEVEE.getValue());
            ultraRare.add(PokemonId.SQUIRTLE.getValue());
        } else {
            ubiquitous.add(PokemonId.FURRET.getValue());
            ubiquitous.add(PokemonId.PIDGEY.getValue());
            ubiquitous.add(PokemonId.RATICATE.getValue());
            common.add(PokemonId.MEOWTH.getValue());
            common.add(PokemonId.PIKACHU.getValue());
            common.add(PokemonId.SNUBBULL.getValue());
            uncommon.add(PokemonId.MARILL.getValue());
            uncommon.add(PokemonId.BUNNELBY.getValue());
            kindaRare.add(PokemonId.NIDORINA.getValue());
            kindaRare.add(PokemonId.NIDORINO.getValue());
            kindaRare.add(PokemonId.ELECTRIKE.getValue());
            rare.add(PokemonId.PERSIAN.getValue());
            rare.add(PokemonId.GRANBULL.getValue());
            rare.add(PokemonId.PIDGEOTTO.getValue());
            rare.add(PokemonId.ALOLAN_RATTATA.getValue());
            superRare.add(PokemonId.ALOLAN_RATICATE.getValue());
            superRare.add(PokemonId.MANECTRIC.getValue());
            superRare.add(PokemonId.ALOLAN_PERSIAN.getValue());
            megaRare.add(PokemonId.TORRACAT.getValue());
            ultraRare.add(PokemonId.EEVEE.getValue());
            ultraRare.add(PokemonId.WARTORTLE.getValue());
        }
    }

    private void addCasinoPokemon() {
        if (difficulty == EARLY_DIFFICULTY) {
            ubiquitous.add(PokemonId.ZUBAT.getValue());
            common.add(PokemonId.KOFFING.getValue());
            uncommon.add(PokemonId.CACNEA.getValue());
            uncommon.add(PokemonId.ORICORIO_PAU.getValue());
            uncommon.add(PokemonId.ORICORIO_SENSU.getValue());
            kindaRare.add(PokemonId.ZIGZAGOON.getValue());
            rare.add(PokemonId.CARBINK.getValue());
            superRare.add(PokemonId.SHUCKLE.getValue());
            megaRare.add(PokemonId.EEVEE.getValue());
            ultraRare.add(PokemonId.TYPE_NULL.getValue());
            ultraRare.add(PokemonId.PORYGON.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            ubiquitous.add(PokemonId.ZUBAT.getValue());
            common.add(PokemonId.KOFFING.getValue());
            uncommon.add(PokemonId.CACNEA.getValue());
            uncommon.add(PokemonId.ZIGZAGOON.getValue());
            uncommon.add(PokemonId.ORICORIO_PAU.getValue());
            uncommon.add(PokemonId.ORICORIO_SENSU.getValue());
            kindaRare.add(PokemonId.GOLBAT.getValue());
            rare.add(PokemonId.CARBINK.getValue());
            superRare.add(PokemonId.SHUCKLE.getValue());
            megaRare.add(PokemonId.EEVEE.getValue());
            ultraRare.add(PokemonId.TYPE_NULL.getValue());
            ultraRare.add(PokemonId.PORYGON.getValue());
        } else {
            ubiquitous.add(PokemonId.GOLBAT.getValue());
            common.add(PokemonId.KOFFING.getValue());
            uncommon.add(PokemonId.LINOONE.getValue());
            uncommon.add(PokemonId.CACNEA.getValue());
            kindaRare.add(PokemonId.ORICORIO_PAU.getValue());
            kindaRare.add(PokemonId.ORICORIO_SENSU.getValue());
            rare.add(PokemonId.GOLBAT.getValue());
            rare.add(PokemonId.CARBINK.getValue());
            superRare.add(PokemonId.WEEZING.getValue());
            superRare.add(PokemonId.SHUCKLE.getValue());
            megaRare.add(PokemonId.EEVEE.getValue());
            megaRare.add(PokemonId.DHELMISE.getValue());
            ultraRare.add(PokemonId.TYPE_NULL.getValue());
            ultraRare.add(PokemonId.PORYGON.getValue());
        }
    }

    private void addCemetaryPokemon() {
        if (difficulty == EARLY_DIFFICULTY) {
            ubiquitous.add(PokemonId.ZUBAT.getValue());
            ubiquitous.add(PokemonId.SPINARAK.getValue());
            ubiquitous.add(PokemonId.POOCHYENA.getValue());
            ubiquitous.add(PokemonId.HOOTHOOT.getValue());
            common.add(PokemonId.SHUPPET.getValue());
            common.add(PokemonId.DUSKULL.getValue());
            uncommon.add(PokemonId.GASTLY.getValue());
            uncommon.add(PokemonId.PHANTUMP.getValue());
            kindaRare.add(PokemonId.VENONAT.getValue());
            kindaRare.add(PokemonId.PARAS.getValue());
            kindaRare.add(PokemonId.EKANS.getValue());
            kindaRare.add(PokemonId.SPEAROW.getValue());
            rare.add(PokemonId.MISDREAVUS.getValue());
            rare.add(PokemonId.HOUNDOUR.getValue());
            superRare.add(PokemonId.MURKROW.getValue());
            superRare.add(PokemonId.SEVIPER.getValue());
            superRare.add(PokemonId.SALANDIT.getValue());
            megaRare.add(PokemonId.SNEASEL.getValue());
            megaRare.add(PokemonId.MIMIKYU.getValue());
            ultraRare.add(PokemonId.WYNAUT.getValue());

        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            ubiquitous.add(PokemonId.ZUBAT.getValue());
            ubiquitous.add(PokemonId.SPINARAK.getValue());
            ubiquitous.add(PokemonId.HOOTHOOT.getValue());
            ubiquitous.add(PokemonId.POOCHYENA.getValue());
            common.add(PokemonId.GASTLY.getValue());
            common.add(PokemonId.SHUPPET.getValue());
            common.add(PokemonId.DUSKULL.getValue());
            uncommon.add(PokemonId.PHANTUMP.getValue());
            uncommon.add(PokemonId.GOLBAT.getValue());
            uncommon.add(PokemonId.HAUNTER.getValue());
            kindaRare.add(PokemonId.VENONAT.getValue());
            kindaRare.add(PokemonId.PARAS.getValue());
            kindaRare.add(PokemonId.EKANS.getValue());
            kindaRare.add(PokemonId.SPEAROW.getValue());
            kindaRare.add(PokemonId.CHIMECHO.getValue());
            rare.add(PokemonId.MISDREAVUS.getValue());
            rare.add(PokemonId.HOUNDOUR.getValue());
            superRare.add(PokemonId.MURKROW.getValue());
            superRare.add(PokemonId.SALANDIT.getValue());
            superRare.add(PokemonId.SEVIPER.getValue());
            megaRare.add(PokemonId.SNEASEL.getValue());
            megaRare.add(PokemonId.MIMIKYU.getValue());
            ultraRare.add(PokemonId.WOBBUFFET.getValue());
        } else {
            ubiquitous.add(PokemonId.GOLBAT.getValue());
            ubiquitous.add(PokemonId.NOCTOWL.getValue());
            ubiquitous.add(PokemonId.GASTLY.getValue());
            ubiquitous.add(PokemonId.DUSKULL.getValue());
            ubiquitous.add(PokemonId.SHUPPET.getValue());
            ubiquitous.add(PokemonId.PHANTUMP.getValue());
            ubiquitous.add(PokemonId.PUMPKABOO.getValue());
            common.add(PokemonId.HAUNTER.getValue());
            common.add(PokemonId.BANETTE.getValue());
            common.add(PokemonId.DUSCLOPS.getValue());
            uncommon.add(PokemonId.PARASECT.getValue());
            kindaRare.add(PokemonId.VENONAT.getValue());
            kindaRare.add(PokemonId.ARBOK.getValue());
            kindaRare.add(PokemonId.TREVENANT.getValue());
            kindaRare.add(PokemonId.GOURGEIST.getValue());
            kindaRare.add(PokemonId.CHIMECHO.getValue());
            rare.add(PokemonId.MISDREAVUS.getValue());
            rare.add(PokemonId.HOUNDOUR.getValue());
            rare.add(PokemonId.MIGHTYENA.getValue());
            superRare.add(PokemonId.MURKROW.getValue());
            superRare.add(PokemonId.SALANDIT.getValue());
            superRare.add(PokemonId.SEVIPER.getValue());
            megaRare.add(PokemonId.SNEASEL.getValue());
            megaRare.add(PokemonId.MIMIKYU.getValue());
            ultraRare.add(PokemonId.WOBBUFFET.getValue());
            ultraRare.add(PokemonId.SHIFTRY.getValue());
        }

    }

    private void addChurchPokemon() {
        if (difficulty == EARLY_DIFFICULTY) {
            ubiquitous.add(PokemonId.FLABEBE.getValue());
            common.add(PokemonId.RALTS.getValue());
            uncommon.add(PokemonId.CLEFAIRY.getValue());
            kindaRare.add(PokemonId.ABRA.getValue());
            rare.add(PokemonId.HONEDGE.getValue());
            rare.add(PokemonId.MISDREAVUS.getValue());
            rare.add(PokemonId.MAWILE.getValue());
            superRare.add(PokemonId.KLEFKI.getValue());
            megaRare.add(PokemonId.NOIBAT.getValue());
            megaRare.add(PokemonId.BAGON.getValue());
            ultraRare.add(PokemonId.TOGEPI.getValue());

        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            ubiquitous.add(PokemonId.FLABEBE.getValue());
            common.add(PokemonId.RALTS.getValue());
            uncommon.add(PokemonId.CLEFAIRY.getValue());
            kindaRare.add(PokemonId.ABRA.getValue());
            rare.add(PokemonId.HONEDGE.getValue());
            rare.add(PokemonId.MISDREAVUS.getValue());
            rare.add(PokemonId.KADABRA.getValue());
            rare.add(PokemonId.FLOETTE.getValue());
            rare.add(PokemonId.KIRLIA.getValue());
            rare.add(PokemonId.MAWILE.getValue());
            superRare.add(PokemonId.ABSOL.getValue());
            superRare.add(PokemonId.COMFEY.getValue());
            superRare.add(PokemonId.KLEFKI.getValue());
            megaRare.add(PokemonId.DRAMPA.getValue());
            megaRare.add(PokemonId.NOIBAT.getValue());
            megaRare.add(PokemonId.BAGON.getValue());
            ultraRare.add(PokemonId.TOGEPI.getValue());
        } else {
            ubiquitous.add(PokemonId.FLOETTE.getValue());
            common.add(PokemonId.KIRLIA.getValue());
            uncommon.add(PokemonId.CLEFAIRY.getValue());
            kindaRare.add(PokemonId.KADABRA.getValue());
            rare.add(PokemonId.MISDREAVUS.getValue());
            rare.add(PokemonId.DOUBLADE.getValue());
            rare.add(PokemonId.COMFEY.getValue());
            rare.add(PokemonId.MAWILE.getValue());
            superRare.add(PokemonId.KLEFKI.getValue());
            superRare.add(PokemonId.ABSOL.getValue());
            megaRare.add(PokemonId.DRAMPA.getValue());
            megaRare.add(PokemonId.NOIBAT.getValue());
            megaRare.add(PokemonId.BAGON.getValue());
            megaRare.add(PokemonId.SHELGON.getValue());
            ultraRare.add(PokemonId.TOGEPI.getValue());
        }

    }

    private void addHospitalPokemon() {
        ubiquitous.add(PokemonId.SWABLU.getValue());
        common.add(PokemonId.ORICORIO_BAILE.getValue());
        common.add(PokemonId.ORICORIO_POM.getValue());
        uncommon.add(PokemonId.STUFFUL.getValue());
        rare.add(PokemonId.LUNATONE.getValue());
        rare.add(PokemonId.SOLROCK.getValue());
        superRare.add(PokemonId.CHANSEY.getValue());
        if (difficulty == MID_LATE_DIFFICULTY) {
            uncommon.add(PokemonId.ALTARIA.getValue());
        }
    }

    private void addElectronicStorePokemon() {
        if (difficulty == EARLY_DIFFICULTY || difficulty == EARLY_MID_DIFFICULTY) {
            ubiquitous.add(PokemonId.MAGNEMITE.getValue());
            common.add(PokemonId.VOLTORB.getValue());
            common.add(PokemonId.GRUBBIN.getValue());
            uncommon.add(PokemonId.PIKACHU.getValue());
            kindaRare.add(PokemonId.VOLTORB.getValue());
            rare.add(PokemonId.DEDENNE.getValue());
            superRare.add(PokemonId.ELEKID.getValue());
            megaRare.add(PokemonId.ALOLAN_GEODUDE.getValue());
            ultraRare.add(PokemonId.BELDUM.getValue());
        } else {
            ubiquitous.add(PokemonId.MAGNETON.getValue());
            ubiquitous.add(PokemonId.VOLTORB.getValue());
            common.add(PokemonId.CHARJABUG.getValue());
            uncommon.add(PokemonId.PIKACHU.getValue());
            kindaRare.add(PokemonId.MAGNEMITE.getValue());
            kindaRare.add(PokemonId.ELECTRODE.getValue());
            rare.add(PokemonId.DEDENNE.getValue());
            superRare.add(PokemonId.ELECTABUZZ.getValue());
            megaRare.add(PokemonId.ALOLAN_GRAVELER.getValue());
            ultraRare.add(PokemonId.METANG.getValue());
        }
    }

    private void addFireStationPokemon() {

        if (difficulty == EARLY_DIFFICULTY) {
            ubiquitous.add(PokemonId.SLUGMA.getValue());
            common.add(PokemonId.KOFFING.getValue());
            uncommon.add(PokemonId.NUMEL.getValue());
            kindaRare.add(PokemonId.GROWLITHE.getValue());
            kindaRare.add(PokemonId.HOUNDOUR.getValue());
            rare.add(PokemonId.TORKOAL.getValue());
            superRare.add(PokemonId.MAGBY.getValue());
            megaRare.add(PokemonId.CHARMANDER.getValue());
            megaRare.add(PokemonId.CYNDAQUIL.getValue());
            ultraRare.add(PokemonId.CHARMANDER.getValue());
            ultraRare.add(PokemonId.CYNDAQUIL.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            ubiquitous.add(PokemonId.SLUGMA.getValue());
            common.add(PokemonId.KOFFING.getValue());
            uncommon.add(PokemonId.NUMEL.getValue());
            kindaRare.add(PokemonId.GROWLITHE.getValue());
            kindaRare.add(PokemonId.HOUNDOUR.getValue());
            kindaRare.add(PokemonId.TORKOAL.getValue());
            rare.add(PokemonId.MAGMAR.getValue());
            superRare.add(PokemonId.TURTONATOR.getValue());
            megaRare.add(PokemonId.CHARMANDER.getValue());
            megaRare.add(PokemonId.CYNDAQUIL.getValue());
            ultraRare.add(PokemonId.CHARMANDER.getValue());
            ultraRare.add(PokemonId.CYNDAQUIL.getValue());
        } else {
            ubiquitous.add(PokemonId.SLUGMA.getValue());
            common.add(PokemonId.KOFFING.getValue());
            uncommon.add(PokemonId.NUMEL.getValue());
            uncommon.add(PokemonId.GROWLITHE.getValue());
            uncommon.add(PokemonId.HOUNDOUR.getValue());
            kindaRare.add(PokemonId.MAGMAR.getValue());
            kindaRare.add(PokemonId.TORKOAL.getValue());
            rare.add(PokemonId.WEEZING.getValue());
            superRare.add(PokemonId.TURTONATOR.getValue());
            megaRare.add(PokemonId.CHARMELEON.getValue());
            megaRare.add(PokemonId.QUILAVA.getValue());
            ultraRare.add(PokemonId.ARCANINE.getValue());
            ultraRare.add(PokemonId.HOUNDOOM.getValue());
        }
    }

    private void addFloristPokemon() {
        if (difficulty == EARLY_DIFFICULTY) {
            ubiquitous.add(PokemonId.HOPPIP.getValue());
            ubiquitous.add(PokemonId.SCATTERBUG.getValue());
            common.add(PokemonId.SUNKERN.getValue());
            uncommon.add(PokemonId.ODDISH.getValue());
            kindaRare.add(PokemonId.BELLSPROUT.getValue());
            rare.add(PokemonId.SPEWPA.getValue());
            superRare.add(PokemonId.BELLSPROUT.getValue());
            megaRare.add(PokemonId.CHIKORITA.getValue());
            ultraRare.add(PokemonId.BULBASAUR.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            ubiquitous.add(PokemonId.HOPPIP.getValue());
            ubiquitous.add(PokemonId.SPEWPA.getValue());
            common.add(PokemonId.SUNKERN.getValue());
            uncommon.add(PokemonId.ODDISH.getValue());
            kindaRare.add(PokemonId.BELLSPROUT.getValue());
            rare.add(PokemonId.ROSELIA.getValue());
            rare.add(PokemonId.GLOOM.getValue());
            rare.add(PokemonId.WEEPINBELL.getValue());
            superRare.add(PokemonId.SKIPLOOM.getValue());
            megaRare.add(PokemonId.CHIKORITA.getValue());
            ultraRare.add(PokemonId.BULBASAUR.getValue());
        } else {
            ubiquitous.add(PokemonId.SKIPLOOM.getValue());
            common.add(PokemonId.GLOOM.getValue());
            uncommon.add(PokemonId.WEEPINBELL.getValue());
            kindaRare.add(PokemonId.GLOOM.getValue());
            rare.add(PokemonId.WEEPINBELL.getValue());
            rare.add(PokemonId.GLOOM.getValue());
            rare.add(PokemonId.ROSELIA.getValue());
            superRare.add(PokemonId.WEEPINBELL.getValue());
            megaRare.add(PokemonId.BAYLEEF.getValue());
            megaRare.add(PokemonId.IVYSAUR.getValue());
            ultraRare.add(PokemonId.SUNFLORA.getValue());
            ultraRare.add(PokemonId.BELLOSSOM.getValue());
        }
    }

    private void addGymPokemon() {
        if (difficulty == EARLY_DIFFICULTY) {
            ubiquitous.add(PokemonId.MACHOP.getValue());
            common.add(PokemonId.GULPIN.getValue());
            uncommon.add(PokemonId.MEDITITE.getValue());
            kindaRare.add(PokemonId.MAKUHITA.getValue());
            kindaRare.add(PokemonId.CRABRAWLER.getValue());
            rare.add(PokemonId.TYROGUE.getValue());
            superRare.add(PokemonId.ZANGOOSE.getValue());
            megaRare.add(PokemonId.JANGMOO.getValue());
            ultraRare.add(PokemonId.MACHOP.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            ubiquitous.add(PokemonId.MACHOP.getValue());
            common.add(PokemonId.GULPIN.getValue());
            uncommon.add(PokemonId.MAKUHITA.getValue());
            uncommon.add(PokemonId.MEDITITE.getValue());
            kindaRare.add(PokemonId.CRABRAWLER.getValue());
            kindaRare.add(PokemonId.POLIWHIRL.getValue());
            rare.add(PokemonId.TYROGUE.getValue());
            rare.add(PokemonId.MACHOKE.getValue());
            superRare.add(PokemonId.ZANGOOSE.getValue());
            superRare.add(PokemonId.HAWLUCHA.getValue());
            megaRare.add(PokemonId.JANGMOO.getValue());
            megaRare.add(PokemonId.COMBUSKEN.getValue());
            ultraRare.add(PokemonId.HITMONLEE.getValue());
            ultraRare.add(PokemonId.HITMONCHAN.getValue());
            ultraRare.add(PokemonId.HITMONTOP.getValue());
        } else {
            ubiquitous.add(PokemonId.MACHOKE.getValue());
            common.add(PokemonId.SWALOT.getValue());
            uncommon.add(PokemonId.HARIYAMA.getValue());
            uncommon.add(PokemonId.MEDICHAM.getValue());
            kindaRare.add(PokemonId.CRABRAWLER.getValue());
            kindaRare.add(PokemonId.POLIWHIRL.getValue());
            rare.add(PokemonId.TYROGUE.getValue());
            superRare.add(PokemonId.HAWLUCHA.getValue());
            superRare.add(PokemonId.ZANGOOSE.getValue());
            megaRare.add(PokemonId.SNORLAX.getValue());
            megaRare.add(PokemonId.JANGMOO.getValue());
            megaRare.add(PokemonId.COMBUSKEN.getValue());
            ultraRare.add(PokemonId.HITMONLEE.getValue());
            ultraRare.add(PokemonId.HITMONCHAN.getValue());
            ultraRare.add(PokemonId.HITMONTOP.getValue());
        }

    }

    private void addMovingPokemon() {
        if (difficulty == EARLY_DIFFICULTY || difficulty == EARLY_MID_DIFFICULTY) {
            ubiquitous.add(PokemonId.MACHOP.getValue());
        } else {
            ubiquitous.add(PokemonId.MACHOP.getValue());
        }
    }

    private void addMuseumPokemon() {
        if (difficulty == EARLY_DIFFICULTY) {
            ubiquitous.add(PokemonId.UNOWN.getValue());
            common.add(PokemonId.SANDSHREW.getValue());
            common.add(PokemonId.NINCADA.getValue());
            uncommon.add(PokemonId.CUBONE.getValue());
            uncommon.add(PokemonId.BALTOY.getValue());
            kindaRare.add(PokemonId.HELIOPTILE.getValue());
            kindaRare.add(PokemonId.DUNSPARCE.getValue());
            kindaRare.add(PokemonId.NATU.getValue());
            kindaRare.add(PokemonId.NOSEPASS.getValue());
            rare.add(PokemonId.SMEARGLE.getValue());
            rare.add(PokemonId.PHANPY.getValue());
            rare.add(PokemonId.SWINUB.getValue());
            rare.add(PokemonId.SABLEYE.getValue());
            rare.add(PokemonId.RELICANTH.getValue());
            superRare.add(PokemonId.BERGMITE.getValue());
            superRare.add(PokemonId.FEEBAS.getValue());
            superRare.add(PokemonId.PALOSSAND.getValue());
            megaRare.add(PokemonId.LARVITAR.getValue());
            megaRare.add(PokemonId.TYRUNT.getValue());
            megaRare.add(PokemonId.AMAURA.getValue());
            ultraRare.add(PokemonId.KABUTO.getValue());
            ultraRare.add(PokemonId.OMANYTE.getValue());
            ultraRare.add(PokemonId.LILEEP.getValue());
            ultraRare.add(PokemonId.ANORITH.getValue());

        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            ubiquitous.add(PokemonId.UNOWN.getValue());
            common.add(PokemonId.SANDSHREW.getValue());
            common.add(PokemonId.NINCADA.getValue());
            uncommon.add(PokemonId.CUBONE.getValue());
            uncommon.add(PokemonId.BALTOY.getValue());
            kindaRare.add(PokemonId.HELIOPTILE.getValue());
            kindaRare.add(PokemonId.DUNSPARCE.getValue());
            kindaRare.add(PokemonId.NATU.getValue());
            kindaRare.add(PokemonId.NOSEPASS.getValue());
            rare.add(PokemonId.SMEARGLE.getValue());
            rare.add(PokemonId.PHANPY.getValue());
            rare.add(PokemonId.SWINUB.getValue());
            rare.add(PokemonId.SABLEYE.getValue());
            rare.add(PokemonId.RELICANTH.getValue());
            superRare.add(PokemonId.BERGMITE.getValue());
            superRare.add(PokemonId.FEEBAS.getValue());
            superRare.add(PokemonId.PALOSSAND.getValue());
            megaRare.add(PokemonId.LARVITAR.getValue());
            megaRare.add(PokemonId.TYRUNT.getValue());
            megaRare.add(PokemonId.AMAURA.getValue());
            ultraRare.add(PokemonId.KABUTO.getValue());
            ultraRare.add(PokemonId.OMANYTE.getValue());
            ultraRare.add(PokemonId.AERODACTYL.getValue());
            ultraRare.add(PokemonId.LILEEP.getValue());
            ultraRare.add(PokemonId.ANORITH.getValue());
        } else {
            ubiquitous.add(PokemonId.UNOWN.getValue());
            common.add(PokemonId.SANDSLASH.getValue());
            common.add(PokemonId.NINJASK.getValue());
            uncommon.add(PokemonId.MAROWAK.getValue());
            uncommon.add(PokemonId.CLAYDOL.getValue());
            uncommon.add(PokemonId.NOSEPASS.getValue());
            kindaRare.add(PokemonId.HELIOPTILE.getValue());
            kindaRare.add(PokemonId.DUNSPARCE.getValue());
            kindaRare.add(PokemonId.NATU.getValue());
            rare.add(PokemonId.SWINUB.getValue());
            rare.add(PokemonId.SMEARGLE.getValue());
            rare.add(PokemonId.DONPHAN.getValue());
            rare.add(PokemonId.SABLEYE.getValue());
            rare.add(PokemonId.RELICANTH.getValue());
            superRare.add(PokemonId.BERGMITE.getValue());
            superRare.add(PokemonId.FEEBAS.getValue());
            superRare.add(PokemonId.PALOSSAND.getValue());
            megaRare.add(PokemonId.PUPITAR.getValue());
            megaRare.add(PokemonId.TYRUNT.getValue());
            megaRare.add(PokemonId.AMAURA.getValue());
            ultraRare.add(PokemonId.KABUTOPS.getValue());
            ultraRare.add(PokemonId.OMASTAR.getValue());
            ultraRare.add(PokemonId.CRADILY.getValue());
            ultraRare.add(PokemonId.ANORITH.getValue());
            ultraRare.add(PokemonId.AERODACTYL.getValue());
            ultraRare.add(PokemonId.LAPRAS.getValue());
        }
    }

    private void addNaturalFeaturePokemon() {
        /*
        Squirtle
        Tentacool
        Goldeen
        Krabby
        Pliwag
        Shellder
        Psyduck
        Magikarp
         */
        if (difficulty == EARLY_DIFFICULTY) {
            ubiquitous.add(PokemonId.POLIWAG.getValue());
            ubiquitous.add(PokemonId.LOTAD.getValue());
            common.add(PokemonId.WOOPER.getValue());
            common.add(PokemonId.WINGULL.getValue());
            common.add(PokemonId.SURSKIT.getValue());
            uncommon.add(PokemonId.PSYDUCK.getValue());
            uncommon.add(PokemonId.MAGIKARP.getValue());
            kindaRare.add(PokemonId.MARILL.getValue());
            kindaRare.add(PokemonId.BARBOACH.getValue());
            kindaRare.add(PokemonId.CARVANHA.getValue());
            rare.add(PokemonId.GOLDEEN.getValue());
            rare.add(PokemonId.DEWPIDER.getValue());
            rare.add(PokemonId.REMORAID.getValue());
            superRare.add(PokemonId.WAILMER.getValue());
            superRare.add(PokemonId.KRABBY.getValue());
            superRare.add(PokemonId.CORPHISH.getValue());
            superRare.add(PokemonId.SHELLDER.getValue());
            superRare.add(PokemonId.BINACLE.getValue());
            megaRare.add(PokemonId.SQUIRTLE.getValue());
            megaRare.add(PokemonId.TOTODILE.getValue());
            megaRare.add(PokemonId.FROAKIE.getValue());
            megaRare.add(PokemonId.MUDKIP.getValue());
            ultraRare.add(PokemonId.SQUIRTLE.getValue());
            ultraRare.add(PokemonId.TOTODILE.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            ubiquitous.add(PokemonId.POLIWAG.getValue());
            ubiquitous.add(PokemonId.LOTAD.getValue());
            common.add(PokemonId.WOOPER.getValue());
            common.add(PokemonId.WINGULL.getValue());
            common.add(PokemonId.SURSKIT.getValue());
            uncommon.add(PokemonId.PSYDUCK.getValue());
            uncommon.add(PokemonId.MAGIKARP.getValue());
            uncommon.add(PokemonId.MARILL.getValue());
            kindaRare.add(PokemonId.POLIWHIRL.getValue());
            kindaRare.add(PokemonId.QUAGSIRE.getValue());
            kindaRare.add(PokemonId.BARBOACH.getValue());
            kindaRare.add(PokemonId.CARVANHA.getValue());
            rare.add(PokemonId.GOLDEEN.getValue());
            rare.add(PokemonId.DEWPIDER.getValue());
            rare.add(PokemonId.REMORAID.getValue());
            superRare.add(PokemonId.WAILMER.getValue());
            superRare.add(PokemonId.KRABBY.getValue());
            superRare.add(PokemonId.CORPHISH.getValue());
            superRare.add(PokemonId.SHELLDER.getValue());
            superRare.add(PokemonId.BINACLE.getValue());
            megaRare.add(PokemonId.SQUIRTLE.getValue());
            megaRare.add(PokemonId.TOTODILE.getValue());
            megaRare.add(PokemonId.MUDKIP.getValue());
            megaRare.add(PokemonId.FROAKIE.getValue());
            ultraRare.add(PokemonId.FROGADIER.getValue());
            ultraRare.add(PokemonId.WARTORTLE.getValue());
        } else {
            ubiquitous.add(PokemonId.POLIWHIRL.getValue());
            ubiquitous.add(PokemonId.LOMBRE.getValue());
            common.add(PokemonId.QUAGSIRE.getValue());
            common.add(PokemonId.PELIPPER.getValue());
            uncommon.add(PokemonId.PSYDUCK.getValue());
            uncommon.add(PokemonId.AZUMARILL.getValue());
            kindaRare.add(PokemonId.GOLDEEN.getValue());
            kindaRare.add(PokemonId.REMORAID.getValue());
            kindaRare.add(PokemonId.CARVANHA.getValue());
            kindaRare.add(PokemonId.WHISCASH.getValue());
            kindaRare.add(PokemonId.MASQUERAIN.getValue());
            rare.add(PokemonId.GYARADOS.getValue());
            rare.add(PokemonId.DEWPIDER.getValue());
            rare.add(PokemonId.SEAKING.getValue());
            rare.add(PokemonId.OCTILLERY.getValue());
            rare.add(PokemonId.GOLDUCK.getValue());
            rare.add(PokemonId.SHARPEDO.getValue());
            superRare.add(PokemonId.WAILMER.getValue());
            superRare.add(PokemonId.KRABBY.getValue());
            superRare.add(PokemonId.CORPHISH.getValue());
            superRare.add(PokemonId.SHELLDER.getValue());
            superRare.add(PokemonId.BINACLE.getValue());
            megaRare.add(PokemonId.WARTORTLE.getValue());
            megaRare.add(PokemonId.CROCONAW.getValue());
            megaRare.add(PokemonId.FROGADIER.getValue());
            ultraRare.add(PokemonId.WAILORD.getValue());
            ultraRare.add(PokemonId.KINGLER.getValue());
            ultraRare.add(PokemonId.CRAWDAUNT.getValue());
            ultraRare.add(PokemonId.CLOYSTER.getValue());
        }
    }

    private void addTrainStationPokemon() {
        if (difficulty == EARLY_DIFFICULTY) {
            ubiquitous.add(PokemonId.DIGLETT.getValue());
            ubiquitous.add(PokemonId.WHISMUR.getValue());
            common.add(PokemonId.RATTATA.getValue());
            uncommon.add(PokemonId.GEODUDE.getValue());
            uncommon.add(PokemonId.ARON.getValue());
            kindaRare.add(PokemonId.MAGNEMITE.getValue());
            rare.add(PokemonId.GRIMER.getValue());
            rare.add(PokemonId.VOLTORB.getValue());
            superRare.add(PokemonId.ONIX.getValue());
            superRare.add(PokemonId.TOGEDEMARU.getValue());
            megaRare.add(PokemonId.ALOLAN_RATTATA.getValue());
            megaRare.add(PokemonId.ALOLAN_GEODUDE.getValue());
            megaRare.add(PokemonId.ALOLAN_GRIMER.getValue());
            megaRare.add(PokemonId.ALOLAN_DIGLETT.getValue());
            ultraRare.add(PokemonId.GOOMY.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            ubiquitous.add(PokemonId.DIGLETT.getValue());
            ubiquitous.add(PokemonId.WHISMUR.getValue());
            common.add(PokemonId.RATTATA.getValue());
            uncommon.add(PokemonId.GEODUDE.getValue());
            uncommon.add(PokemonId.ARON.getValue());
            kindaRare.add(PokemonId.MAGNEMITE.getValue());
            kindaRare.add(PokemonId.GRIMER.getValue());
            kindaRare.add(PokemonId.VOLTORB.getValue());
            rare.add(PokemonId.RATICATE.getValue());
            rare.add(PokemonId.DUGTRIO.getValue());
            superRare.add(PokemonId.ONIX.getValue());
            superRare.add(PokemonId.TOGEDEMARU.getValue());
            megaRare.add(PokemonId.ALOLAN_RATTATA.getValue());
            megaRare.add(PokemonId.ALOLAN_GEODUDE.getValue());
            megaRare.add(PokemonId.ALOLAN_GRIMER.getValue());
            megaRare.add(PokemonId.ALOLAN_RATICATE.getValue());
            megaRare.add(PokemonId.ALOLAN_DIGLETT.getValue());
            ultraRare.add(PokemonId.GOOMY.getValue());
        } else {
            ubiquitous.add(PokemonId.DIGLETT.getValue());
            ubiquitous.add(PokemonId.LOUDRED.getValue());
            common.add(PokemonId.RATICATE.getValue());
            uncommon.add(PokemonId.GRAVELER.getValue());
            uncommon.add(PokemonId.LAIRON.getValue());
            kindaRare.add(PokemonId.ONIX.getValue());
            rare.add(PokemonId.GRIMER.getValue());
            rare.add(PokemonId.VOLTORB.getValue());
            rare.add(PokemonId.GEODUDE.getValue());
            rare.add(PokemonId.MAGNETON.getValue());
            rare.add(PokemonId.ELECTRODE.getValue());
            rare.add(PokemonId.MAGNEMITE.getValue());
            superRare.add(PokemonId.MUK.getValue());
            superRare.add(PokemonId.DUGTRIO.getValue());
            superRare.add(PokemonId.TOGEDEMARU.getValue());
            megaRare.add(PokemonId.ALOLAN_RATICATE.getValue());
            megaRare.add(PokemonId.ALOLAN_DUGTRIO.getValue());
            megaRare.add(PokemonId.ALOLAN_GRAVELER.getValue());
            megaRare.add(PokemonId.ALOLAN_GRIMER.getValue());
            megaRare.add(PokemonId.ALOLAN_MUK.getValue());
            ultraRare.add(PokemonId.SLIGGOO.getValue());
        }
    }

    private void addSchoolPokemon() {
        if (difficulty == EARLY_DIFFICULTY) {
            ubiquitous.add(PokemonId.CATERPIE.getValue());
            ubiquitous.add(PokemonId.WEEDLE.getValue());
            ubiquitous.add(PokemonId.WURMPLE.getValue());
            common.add(PokemonId.PIDGEY.getValue());
            common.add(PokemonId.SENTRET.getValue());
            common.add(PokemonId.BUNNELBY.getValue());
            uncommon.add(PokemonId.LEDYBA.getValue());
            kindaRare.add(PokemonId.ODDISH.getValue());
            kindaRare.add(PokemonId.BELLSPROUT.getValue());
            kindaRare.add(PokemonId.YANMA.getValue());
            kindaRare.add(PokemonId.SKITTY.getValue());
            rare.add(PokemonId.PIKACHU.getValue());
            rare.add(PokemonId.MEOWTH.getValue());
            rare.add(PokemonId.SNUBBULL.getValue());
            rare.add(PokemonId.ROCKRUFF.getValue());
            rare.add(PokemonId.CASTFORM.getValue());
            superRare.add(PokemonId.KAKUNA.getValue());
            superRare.add(PokemonId.METAPOD.getValue());
            megaRare.add(PokemonId.ALOLAN_MEOWTH.getValue());
            megaRare.add(PokemonId.CHESPIN.getValue());
            ultraRare.add(PokemonId.SUDOWOODO.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            ubiquitous.add(PokemonId.KAKUNA.getValue());
            ubiquitous.add(PokemonId.METAPOD.getValue());
            ubiquitous.add(PokemonId.CASCOON.getValue());
            ubiquitous.add(PokemonId.SILCOON.getValue());
            common.add(PokemonId.PIDGEY.getValue());
            common.add(PokemonId.SENTRET.getValue());
            common.add(PokemonId.BUNNELBY.getValue());
            common.add(PokemonId.LEDYBA.getValue());
            uncommon.add(PokemonId.LEDIAN.getValue());
            uncommon.add(PokemonId.PIDGEOTTO.getValue());
            uncommon.add(PokemonId.FURRET.getValue());
            kindaRare.add(PokemonId.ODDISH.getValue());
            kindaRare.add(PokemonId.BELLSPROUT.getValue());
            kindaRare.add(PokemonId.PIKACHU.getValue());
            kindaRare.add(PokemonId.YANMA.getValue());
            kindaRare.add(PokemonId.SKITTY.getValue());
            rare.add(PokemonId.MEOWTH.getValue());
            rare.add(PokemonId.SNUBBULL.getValue());
            rare.add(PokemonId.ROCKRUFF.getValue());
            rare.add(PokemonId.CASTFORM.getValue());
            superRare.add(PokemonId.BUTTERFREE.getValue());
            superRare.add(PokemonId.BEEDRILL.getValue());
            megaRare.add(PokemonId.ALOLAN_MEOWTH.getValue());
            megaRare.add(PokemonId.QUILLADIN.getValue());
            ultraRare.add(PokemonId.SUDOWOODO.getValue());
        } else {
            ubiquitous.add(PokemonId.LEDIAN.getValue());
            ubiquitous.add(PokemonId.FURRET.getValue());
            common.add(PokemonId.PIDGEOTTO.getValue());
            common.add(PokemonId.DIGGERSBY.getValue());
            uncommon.add(PokemonId.BUTTERFREE.getValue());
            uncommon.add(PokemonId.BEEDRILL.getValue());
            uncommon.add(PokemonId.DUSTOX.getValue());
            kindaRare.add(PokemonId.WEEPINBELL.getValue());
            kindaRare.add(PokemonId.GLOOM.getValue());
            kindaRare.add(PokemonId.PIKACHU.getValue());
            kindaRare.add(PokemonId.YANMA.getValue());
            rare.add(PokemonId.PERSIAN.getValue());
            rare.add(PokemonId.SNUBBULL.getValue());
            rare.add(PokemonId.ROCKRUFF.getValue());
            rare.add(PokemonId.CASTFORM.getValue());
            superRare.add(PokemonId.GRANBULL.getValue());
            megaRare.add(PokemonId.ALOLAN_PERSIAN.getValue());
            megaRare.add(PokemonId.QUILLADIN.getValue());
            ultraRare.add(PokemonId.SUDOWOODO.getValue());
        }
    }

    private void addZooPokemon() {
        /*
        Ponyta
        Slowpoke
        Vulpix
        Eevee
        Mankey
        Rhyhorn
        Doduo
        Kangaskhan - Rare
        Tauros - Rare
        Tentacool
        Snorlax - Rare
        Dratini - Super Rare
        Farfetch'd - Rare
         */
        if (difficulty == EARLY_DIFFICULTY) {
            ubiquitous.add(PokemonId.MANKEY.getValue());
            ubiquitous.add(PokemonId.PANCHAM.getValue());
            ubiquitous.add(PokemonId.PIKIPEK.getValue());
            common.add(PokemonId.MAREEP.getValue());
            common.add(PokemonId.SLAKOTH.getValue());
            uncommon.add(PokemonId.VULPIX.getValue());
            kindaRare.add(PokemonId.PONYTA.getValue());
            kindaRare.add(PokemonId.RHYHORN.getValue());
            kindaRare.add(PokemonId.MUDBRAY.getValue());
            kindaRare.add(PokemonId.SKIDDO.getValue());
            rare.add(PokemonId.DODUO.getValue());
            rare.add(PokemonId.SLOWPOKE.getValue());
            rare.add(PokemonId.GIRAFARIG.getValue());
            rare.add(PokemonId.TEDDIURSA.getValue());
            rare.add(PokemonId.AIPOM.getValue());
            rare.add(PokemonId.LITLEO.getValue());
            superRare.add(PokemonId.PASSIMIAN.getValue());
            superRare.add(PokemonId.KOMALA.getValue());
            megaRare.add(PokemonId.CYNDAQUIL.getValue());
            megaRare.add(PokemonId.TOTODILE.getValue());
            ultraRare.add(PokemonId.MILTANK.getValue());

        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            ubiquitous.add(PokemonId.PIKIPEK.getValue());
            ubiquitous.add(PokemonId.PANCHAM.getValue());
            ubiquitous.add(PokemonId.MANKEY.getValue());
            common.add(PokemonId.MAREEP.getValue());
            common.add(PokemonId.SLAKOTH.getValue());
            uncommon.add(PokemonId.VULPIX.getValue());
            kindaRare.add(PokemonId.PONYTA.getValue());
            kindaRare.add(PokemonId.RHYHORN.getValue());
            kindaRare.add(PokemonId.SKIDDO.getValue());
            kindaRare.add(PokemonId.FLAFFY.getValue());
            kindaRare.add(PokemonId.TRUMBEAK.getValue());
            kindaRare.add(PokemonId.MUDBRAY.getValue());
            rare.add(PokemonId.DODUO.getValue());
            rare.add(PokemonId.VIGOROTH.getValue());
            rare.add(PokemonId.SLOWPOKE.getValue());
            rare.add(PokemonId.GIRAFARIG.getValue());
            rare.add(PokemonId.TEDDIURSA.getValue());
            rare.add(PokemonId.AIPOM.getValue());
            rare.add(PokemonId.LITLEO.getValue());
            superRare.add(PokemonId.KOMALA.getValue());
            superRare.add(PokemonId.PASSIMIAN.getValue());
            superRare.add(PokemonId.KANGASKHAN.getValue());
            superRare.add(PokemonId.TAUROS.getValue());
            megaRare.add(PokemonId.QUILAVA.getValue());
            megaRare.add(PokemonId.CROCONAW.getValue());
            ultraRare.add(PokemonId.MILTANK.getValue());
        } else {
            ubiquitous.add(PokemonId.FLAFFY.getValue());
            ubiquitous.add(PokemonId.PANCHAM.getValue());
            ubiquitous.add(PokemonId.TRUMBEAK.getValue());
            common.add(PokemonId.MANKEY.getValue());
            rare.add(PokemonId.VIGOROTH.getValue());
            uncommon.add(PokemonId.VULPIX.getValue());
            kindaRare.add(PokemonId.PONYTA.getValue());
            kindaRare.add(PokemonId.RHYHORN.getValue());
            kindaRare.add(PokemonId.MUDBRAY.getValue());
            kindaRare.add(PokemonId.SKIDDO.getValue());
            rare.add(PokemonId.DODUO.getValue());
            rare.add(PokemonId.SLOWPOKE.getValue());
            rare.add(PokemonId.GIRAFARIG.getValue());
            rare.add(PokemonId.TEDDIURSA.getValue());
            rare.add(PokemonId.AIPOM.getValue());
            rare.add(PokemonId.LITLEO.getValue());
            superRare.add(PokemonId.PASSIMIAN.getValue());
            superRare.add(PokemonId.KANGASKHAN.getValue());
            superRare.add(PokemonId.KOMALA.getValue());
            superRare.add(PokemonId.TAUROS.getValue());
            superRare.add(PokemonId.RHYDON.getValue());
            superRare.add(PokemonId.URSARING.getValue());
            megaRare.add(PokemonId.QUILAVA.getValue());
            megaRare.add(PokemonId.CROCONAW.getValue());
            ultraRare.add(PokemonId.MILTANK.getValue());
        }

    }

}
