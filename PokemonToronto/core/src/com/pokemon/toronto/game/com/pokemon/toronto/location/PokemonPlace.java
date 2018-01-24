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
    private Set<Integer> commonPokemon;
    private Set<Integer> rarePokemon;
    private Set<Integer> superRarePokemon;

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
        if (commonPokemon.size() > 0) {
            return true;
        } else if (rarePokemon.size() > 0) {
            return true;
        } else if (superRarePokemon.size() > 0) {
            return true;
        }
        return false;
    }

    public int getPokemon() {
        //Determine whether to return a common, rare or super rare Pokemon.
        if (hasPokemon()) {
            double rand = Math.random();
            if (rand >= .125) {
                //Common
                return getPokemon(commonPokemon);
            } else if (rand >= .025) {
                //Rare if there is one.
                if (rarePokemon.size() > 0) {
                    return getPokemon(rarePokemon);
                } else {
                    return getPokemon(commonPokemon);
                }
            } else {
                //Super Rare if there is one.
                if (superRarePokemon.size() > 0) {
                    return getPokemon(superRarePokemon);
                } else if (rarePokemon.size() > 0) {
                    return getPokemon(rarePokemon);
                } else {
                    return getPokemon(commonPokemon);
                }
            }
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
        commonPokemon = new HashSet<Integer>();
        rarePokemon = new HashSet<Integer>();
        superRarePokemon = new HashSet<Integer>();
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
            commonPokemon.add(PokemonId.PIDGEY.getValue());
            commonPokemon.add(PokemonId.SPEAROW.getValue());
            commonPokemon.add(PokemonId.MAGNEMITE.getValue());
            rarePokemon.add(PokemonId.DODUO.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            commonPokemon.add(PokemonId.PIDGEY.getValue());
            commonPokemon.add(PokemonId.SPEAROW.getValue());
            commonPokemon.add(PokemonId.MAGNEMITE.getValue());
            rarePokemon.add(PokemonId.DODUO.getValue());
            rarePokemon.add(PokemonId.PIDGEOTTO.getValue());
        } else {
            commonPokemon.add(PokemonId.PIDGEOTTO.getValue());
            commonPokemon.add(PokemonId.FEAROW.getValue());
            commonPokemon.add(PokemonId.MAGNEMITE.getValue());
            commonPokemon.add(PokemonId.DODUO.getValue());
            rarePokemon.add(PokemonId.MAGNETON.getValue());
            rarePokemon.add(PokemonId.PIDGEY.getValue());
            rarePokemon.add(PokemonId.SPEAROW.getValue());
            superRarePokemon.add(PokemonId.PIDGEOT.getValue());
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
            commonPokemon.add(PokemonId.DROWZEE.getValue());
            commonPokemon.add(PokemonId.MANKEY.getValue());
            commonPokemon.add(PokemonId.ABRA.getValue());
            superRarePokemon.add(PokemonId.MR_MIME.getValue());
            superRarePokemon.add(PokemonId.JYNX.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            commonPokemon.add(PokemonId.DROWZEE.getValue());
            commonPokemon.add(PokemonId.ABRA.getValue());
            commonPokemon.add(PokemonId.MANKEY.getValue());
            rarePokemon.add(PokemonId.KADABRA.getValue());
            rarePokemon.add(PokemonId.HYPNO.getValue());
            rarePokemon.add(PokemonId.TAUROS.getValue());
            superRarePokemon.add(PokemonId.MR_MIME.getValue());
            superRarePokemon.add(PokemonId.JYNX.getValue());
        } else {
            commonPokemon.add(PokemonId.MAGMAR.getValue());
            commonPokemon.add(PokemonId.MANKEY.getValue());
            commonPokemon.add(PokemonId.KADABRA.getValue());
            commonPokemon.add(PokemonId.HYPNO.getValue());
            rarePokemon.add(PokemonId.PRIMEAPE.getValue());
            rarePokemon.add(PokemonId.TAUROS.getValue());
            rarePokemon.add(PokemonId.MR_MIME.getValue());
            rarePokemon.add(PokemonId.JYNX.getValue());
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
            commonPokemon.add(PokemonId.TENTACOOL.getValue());
            commonPokemon.add(PokemonId.GOLDEEN.getValue());
            commonPokemon.add(PokemonId.MAGIKARP.getValue());
            commonPokemon.add(PokemonId.SEEL.getValue());
            rarePokemon.add(PokemonId.HORSEA.getValue());
            rarePokemon.add(PokemonId.STARYU.getValue());
            superRarePokemon.add(PokemonId.SQUIRTLE.getValue());
            superRarePokemon.add(PokemonId.DRATINI.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            commonPokemon.add(PokemonId.TENTACOOL.getValue());
            commonPokemon.add(PokemonId.GOLDEEN.getValue());
            commonPokemon.add(PokemonId.MAGIKARP.getValue());
            commonPokemon.add(PokemonId.SEEL.getValue());
            commonPokemon.add(PokemonId.HORSEA.getValue());
            rarePokemon.add(PokemonId.STARYU.getValue());
            rarePokemon.add(PokemonId.SEADRA.getValue());
            superRarePokemon.add(PokemonId.SQUIRTLE.getValue());
            superRarePokemon.add(PokemonId.WARTORTLE.getValue());
            superRarePokemon.add(PokemonId.DRATINI.getValue());
            superRarePokemon.add(PokemonId.VAPOREON.getValue());
        } else {
            commonPokemon.add(PokemonId.TENTACOOL.getValue());
            commonPokemon.add(PokemonId.TENTACRUEL.getValue());
            commonPokemon.add(PokemonId.GOLDEEN.getValue());
            commonPokemon.add(PokemonId.SEAKING.getValue());
            commonPokemon.add(PokemonId.SEEL.getValue());
            commonPokemon.add(PokemonId.DEWGONG.getValue());
            commonPokemon.add(PokemonId.HORSEA.getValue());
            commonPokemon.add(PokemonId.STARYU.getValue());
            rarePokemon.add(PokemonId.SEADRA.getValue());
            rarePokemon.add(PokemonId.GYARADOS.getValue());
            superRarePokemon.add(PokemonId.STARMIE.getValue());
            superRarePokemon.add(PokemonId.WARTORTLE.getValue());
            superRarePokemon.add(PokemonId.DRATINI.getValue());
            superRarePokemon.add(PokemonId.DRAGONAIR.getValue());
            superRarePokemon.add(PokemonId.VAPOREON.getValue());
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
        if (difficulty == EARLY_DIFFICULTY || difficulty == EARLY_MID_DIFFICULTY) {
            commonPokemon.add(PokemonId.JIGGLYPUFF.getValue());
            commonPokemon.add(PokemonId.CLEFAIRY.getValue());
            rarePokemon.add(PokemonId.JYNX.getValue());
        } else {
            commonPokemon.add(PokemonId.JIGGLYPUFF.getValue());
            commonPokemon.add(PokemonId.CLEFAIRY.getValue());
            rarePokemon.add(PokemonId.JYNX.getValue());
            superRarePokemon.add(PokemonId.WIGGLYTUFF.getValue());
            superRarePokemon.add(PokemonId.CLEFABLE.getValue());
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
            commonPokemon.add(PokemonId.NIDORANM.getValue());
            commonPokemon.add(PokemonId.NIDORANF.getValue());
            commonPokemon.add(PokemonId.DIGLETT.getValue());
            commonPokemon.add(PokemonId.ODDISH.getValue());
            commonPokemon.add(PokemonId.EKANS.getValue());
            commonPokemon.add(PokemonId.VENONAT.getValue());
            commonPokemon.add(PokemonId.PARAS.getValue());
            commonPokemon.add(PokemonId.PSYDUCK.getValue());
            commonPokemon.add(PokemonId.BELLSPROUT.getValue());
            commonPokemon.add(PokemonId.PIDGEY.getValue());
            rarePokemon.add(PokemonId.TANGELA.getValue());
            superRarePokemon.add(PokemonId.BULBASAUR.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            commonPokemon.add(PokemonId.NIDORANM.getValue());
            commonPokemon.add(PokemonId.NIDORANF.getValue());
            commonPokemon.add(PokemonId.DIGLETT.getValue());
            commonPokemon.add(PokemonId.ODDISH.getValue());
            commonPokemon.add(PokemonId.EKANS.getValue());
            commonPokemon.add(PokemonId.VENONAT.getValue());
            commonPokemon.add(PokemonId.PARAS.getValue());
            commonPokemon.add(PokemonId.PSYDUCK.getValue());
            commonPokemon.add(PokemonId.BELLSPROUT.getValue());
            commonPokemon.add(PokemonId.PIDGEY.getValue());
            commonPokemon.add(PokemonId.TANGELA.getValue());
            rarePokemon.add(PokemonId.DUGTRIO.getValue());
            rarePokemon.add(PokemonId.GLOOM.getValue());
            rarePokemon.add(PokemonId.WEEPINBELL.getValue());
            rarePokemon.add(PokemonId.PIDGEOTTO.getValue());
            rarePokemon.add(PokemonId.NIDORINA.getValue());
            rarePokemon.add(PokemonId.NIDORINO.getValue());
            superRarePokemon.add(PokemonId.BULBASAUR.getValue());
            superRarePokemon.add(PokemonId.SCYTHER.getValue());
            superRarePokemon.add(PokemonId.PINSIR.getValue());
        } else {
            commonPokemon.add(PokemonId.NIDORINO.getValue());
            commonPokemon.add(PokemonId.NIDORINA.getValue());
            commonPokemon.add(PokemonId.ARBOK.getValue());
            commonPokemon.add(PokemonId.GLOOM.getValue());
            commonPokemon.add(PokemonId.VENONAT.getValue());
            commonPokemon.add(PokemonId.PSYDUCK.getValue());
            commonPokemon.add(PokemonId.WEEPINBELL.getValue());
            commonPokemon.add(PokemonId.TANGELA.getValue());
            rarePokemon.add(PokemonId.DUGTRIO.getValue());
            rarePokemon.add(PokemonId.VENOMOTH.getValue());
            rarePokemon.add(PokemonId.WEEPINBELL.getValue());
            rarePokemon.add(PokemonId.PIDGEOTTO.getValue());
            superRarePokemon.add(PokemonId.IVYSAUR.getValue());
            superRarePokemon.add(PokemonId.SCYTHER.getValue());
            superRarePokemon.add(PokemonId.PINSIR.getValue());
        }
    }

    private void addPetPokemon() {
        /*
        Pikachu
        Meowth
        Sandshrew
         */
        if (difficulty == EARLY_DIFFICULTY) {
            commonPokemon.add(PokemonId.PIKACHU.getValue());
            commonPokemon.add(PokemonId.SANDSHREW.getValue());
            commonPokemon.add(PokemonId.MEOWTH.getValue());
            commonPokemon.add(PokemonId.PIDGEY.getValue());
            commonPokemon.add(PokemonId.RATTATA.getValue());
            commonPokemon.add(PokemonId.NIDORANF.getValue());
            commonPokemon.add(PokemonId.NIDORANM.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_MEOWTH.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_RATTATA.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_VULPIX.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_SANDSHREW.getValue());
            superRarePokemon.add(PokemonId.SQUIRTLE.getValue());
            superRarePokemon.add(PokemonId.EEVEE.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            commonPokemon.add(PokemonId.PIKACHU.getValue());
            commonPokemon.add(PokemonId.SANDSHREW.getValue());
            commonPokemon.add(PokemonId.MEOWTH.getValue());
            commonPokemon.add(PokemonId.PIDGEY.getValue());
            commonPokemon.add(PokemonId.RATTATA.getValue());
            commonPokemon.add(PokemonId.NIDORANF.getValue());
            commonPokemon.add(PokemonId.NIDORANM.getValue());
            rarePokemon.add(PokemonId.GROWLITHE.getValue());
            rarePokemon.add(PokemonId.VULPIX.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_MEOWTH.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_RATTATA.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_VULPIX.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_SANDSHREW.getValue());
            superRarePokemon.add(PokemonId.EEVEE.getValue());
            superRarePokemon.add(PokemonId.SQUIRTLE.getValue());
        } else {
            commonPokemon.add(PokemonId.PIKACHU.getValue());
            commonPokemon.add(PokemonId.SANDSHREW.getValue());
            commonPokemon.add(PokemonId.MEOWTH.getValue());
            commonPokemon.add(PokemonId.PIDGEY.getValue());
            commonPokemon.add(PokemonId.RATTATA.getValue());
            commonPokemon.add(PokemonId.NIDORANF.getValue());
            commonPokemon.add(PokemonId.NIDORANM.getValue());
            rarePokemon.add(PokemonId.GROWLITHE.getValue());
            rarePokemon.add(PokemonId.VULPIX.getValue());
            rarePokemon.add(PokemonId.PERSIAN.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_PERSIAN.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_RATICATE.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_VULPIX.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_SANDSHREW.getValue());
            superRarePokemon.add(PokemonId.EEVEE.getValue());
            superRarePokemon.add(PokemonId.WARTORTLE.getValue());
        }
    }

    private void addCasinoPokemon() {
        if (difficulty == EARLY_DIFFICULTY) {
            commonPokemon.add(PokemonId.ZUBAT.getValue());
            commonPokemon.add(PokemonId.KOFFING.getValue());
            superRarePokemon.add(PokemonId.EEVEE.getValue());
            superRarePokemon.add(PokemonId.PORYGON.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            commonPokemon.add(PokemonId.ZUBAT.getValue());
            commonPokemon.add(PokemonId.KOFFING.getValue());
            rarePokemon.add(PokemonId.GOLBAT.getValue());
            superRarePokemon.add(PokemonId.EEVEE.getValue());
            superRarePokemon.add(PokemonId.PORYGON.getValue());
        } else {
            commonPokemon.add(PokemonId.KOFFING.getValue());
            commonPokemon.add(PokemonId.GOLBAT.getValue());
            rarePokemon.add(PokemonId.WEEZING.getValue());
            rarePokemon.add(PokemonId.ZUBAT.getValue());
            superRarePokemon.add(PokemonId.EEVEE.getValue());
            superRarePokemon.add(PokemonId.PORYGON.getValue());
        }
    }

    private void addCemetaryPokemon() {
        if (difficulty == EARLY_DIFFICULTY) {
            commonPokemon.add(PokemonId.GASTLY.getValue());
            commonPokemon.add(PokemonId.ZUBAT.getValue());
            rarePokemon.add(PokemonId.EKANS.getValue());
            rarePokemon.add(PokemonId.VENONAT.getValue());
            rarePokemon.add(PokemonId.PARAS.getValue());
            rarePokemon.add(PokemonId.SPEAROW.getValue());
            rarePokemon.add(PokemonId.BELLSPROUT.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            commonPokemon.add(PokemonId.GASTLY.getValue());
            commonPokemon.add(PokemonId.ZUBAT.getValue());
            rarePokemon.add(PokemonId.EKANS.getValue());
            rarePokemon.add(PokemonId.VENONAT.getValue());
            rarePokemon.add(PokemonId.PARAS.getValue());
            rarePokemon.add(PokemonId.SPEAROW.getValue());
            rarePokemon.add(PokemonId.HAUNTER.getValue());
            rarePokemon.add(PokemonId.GOLBAT.getValue());
            rarePokemon.add(PokemonId.BELLSPROUT.getValue());
        } else {
            commonPokemon.add(PokemonId.GASTLY.getValue());
            commonPokemon.add(PokemonId.HAUNTER.getValue());
            commonPokemon.add(PokemonId.GOLBAT.getValue());
            rarePokemon.add(PokemonId.VENONAT.getValue());
            rarePokemon.add(PokemonId.FEAROW.getValue());
            rarePokemon.add(PokemonId.ARBOK.getValue());
            rarePokemon.add(PokemonId.PARASECT.getValue());
            rarePokemon.add(PokemonId.WEEPINBELL.getValue());

        }

    }

    private void addChurchPokemon() {
        if (difficulty == EARLY_DIFFICULTY) {
            commonPokemon.add(PokemonId.GASTLY.getValue());
            commonPokemon.add(PokemonId.ZUBAT.getValue());
            rarePokemon.add(PokemonId.ABRA.getValue());
            rarePokemon.add(PokemonId.CLEFAIRY.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            commonPokemon.add(PokemonId.GASTLY.getValue());
            commonPokemon.add(PokemonId.ZUBAT.getValue());
            rarePokemon.add(PokemonId.ABRA.getValue());
            rarePokemon.add(PokemonId.CLEFAIRY.getValue());
            rarePokemon.add(PokemonId.KADABRA.getValue());
            rarePokemon.add(PokemonId.HAUNTER.getValue());
            rarePokemon.add(PokemonId.GOLBAT.getValue());
        } else {
            commonPokemon.add(PokemonId.GASTLY.getValue());
            commonPokemon.add(PokemonId.HAUNTER.getValue());
            commonPokemon.add(PokemonId.GOLBAT.getValue());
            rarePokemon.add(PokemonId.CLEFAIRY.getValue());
            rarePokemon.add(PokemonId.KADABRA.getValue());
        }

    }

    private void addHospitalPokemon() {

        superRarePokemon.add(PokemonId.CHANSEY.getValue());
    }

    private void addElectronicStorePokemon() {
        if (difficulty == EARLY_DIFFICULTY || difficulty == EARLY_MID_DIFFICULTY) {
            commonPokemon.add(PokemonId.VOLTORB.getValue());
            commonPokemon.add(PokemonId.MAGNEMITE.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_GEODUDE.getValue());
        } else {
            commonPokemon.add(PokemonId.VOLTORB.getValue());
            commonPokemon.add(PokemonId.MAGNEMITE.getValue());
            rarePokemon.add(PokemonId.ELECTRODE.getValue());
            rarePokemon.add(PokemonId.MAGNETON.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_GRAVELER.getValue());
        }
    }

    private void addFireStationPokemon() {

        if (difficulty == EARLY_DIFFICULTY) {
            commonPokemon.add(PokemonId.GROWLITHE.getValue());
            commonPokemon.add(PokemonId.KOFFING.getValue());
            superRarePokemon.add(PokemonId.CHARMANDER.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            commonPokemon.add(PokemonId.GROWLITHE.getValue());
            commonPokemon.add(PokemonId.KOFFING.getValue());
            rarePokemon.add(PokemonId.MAGMAR.getValue());
            superRarePokemon.add(PokemonId.CHARMANDER.getValue());
        } else {
            commonPokemon.add(PokemonId.GROWLITHE.getValue());
            commonPokemon.add(PokemonId.KOFFING.getValue());
            rarePokemon.add(PokemonId.MAGMAR.getValue());
            rarePokemon.add(PokemonId.WEEZING.getValue());
            superRarePokemon.add(PokemonId.CHARMELEON.getValue());
            superRarePokemon.add(PokemonId.ARCANINE.getValue());
        }
    }

    private void addFloristPokemon() {
        if (difficulty == EARLY_DIFFICULTY) {
            commonPokemon.add(PokemonId.ODDISH.getValue());
            commonPokemon.add(PokemonId.BELLSPROUT.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            commonPokemon.add(PokemonId.ODDISH.getValue());
            commonPokemon.add(PokemonId.BELLSPROUT.getValue());
            rarePokemon.add(PokemonId.GLOOM.getValue());
            rarePokemon.add(PokemonId.WEEPINBELL.getValue());
        } else {
            rarePokemon.add(PokemonId.ODDISH.getValue());
            rarePokemon.add(PokemonId.BELLSPROUT.getValue());
            commonPokemon.add(PokemonId.GLOOM.getValue());
            commonPokemon.add(PokemonId.WEEPINBELL.getValue());
        }
    }

    private void addGymPokemon() {
        if (difficulty == EARLY_DIFFICULTY) {
            commonPokemon.add(PokemonId.MACHOP.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            commonPokemon.add(PokemonId.MACHOP.getValue());
            rarePokemon.add(PokemonId.POLIWHIRL.getValue());
            superRarePokemon.add(PokemonId.HITMONCHAN.getValue());
            superRarePokemon.add(PokemonId.HITMONLEE.getValue());
        } else {
            commonPokemon.add(PokemonId.MACHOKE.getValue());
            rarePokemon.add(PokemonId.POLIWHIRL.getValue());
            superRarePokemon.add(PokemonId.HITMONCHAN.getValue());
            superRarePokemon.add(PokemonId.HITMONLEE.getValue());
            superRarePokemon.add(PokemonId.SNORLAX.getValue());
        }

    }

    private void addMovingPokemon() {
        if (difficulty == EARLY_DIFFICULTY || difficulty == EARLY_MID_DIFFICULTY) {
            commonPokemon.add(PokemonId.MACHOP.getValue());
        } else {
            commonPokemon.add(PokemonId.MACHOKE.getValue());
        }
    }

    private void addMuseumPokemon() {
        if (difficulty == EARLY_DIFFICULTY) {
            commonPokemon.add(PokemonId.UNOWN.getValue());
            commonPokemon.add(PokemonId.SANDSHREW.getValue());
            commonPokemon.add(PokemonId.CUBONE.getValue());
            rarePokemon.add(PokemonId.SWINUB.getValue());
            rarePokemon.add(PokemonId.NATU.getValue());
            superRarePokemon.add(PokemonId.KABUTO.getValue());
            superRarePokemon.add(PokemonId.OMANYTE.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            commonPokemon.add(PokemonId.UNOWN.getValue());
            commonPokemon.add(PokemonId.SANDSHREW.getValue());
            commonPokemon.add(PokemonId.CUBONE.getValue());
            rarePokemon.add(PokemonId.SWINUB.getValue());
            rarePokemon.add(PokemonId.NATU.getValue());
            rarePokemon.add(PokemonId.MISDREAVUS.getValue());
            superRarePokemon.add(PokemonId.KABUTO.getValue());
            superRarePokemon.add(PokemonId.OMANYTE.getValue());
            superRarePokemon.add(PokemonId.AERODACTYL.getValue());
        } else {
            commonPokemon.add(PokemonId.UNOWN.getValue());
            commonPokemon.add(PokemonId.SANDSLASH.getValue());
            commonPokemon.add(PokemonId.MAROWAK.getValue());
            rarePokemon.add(PokemonId.SWINUB.getValue());
            rarePokemon.add(PokemonId.NATU.getValue());
            rarePokemon.add(PokemonId.MISDREAVUS.getValue());
            superRarePokemon.add(PokemonId.OMANYTE.getValue());
            superRarePokemon.add(PokemonId.KABUTO.getValue());
            superRarePokemon.add(PokemonId.KABUTOPS.getValue());
            superRarePokemon.add(PokemonId.OMASTAR.getValue());
            superRarePokemon.add(PokemonId.AERODACTYL.getValue());
            superRarePokemon.add(PokemonId.LAPRAS.getValue());
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
            commonPokemon.add(PokemonId.TENTACOOL.getValue());
            commonPokemon.add(PokemonId.POLIWAG.getValue());
            commonPokemon.add(PokemonId.PSYDUCK.getValue());
            commonPokemon.add(PokemonId.GOLDEEN.getValue());
            commonPokemon.add(PokemonId.MAGIKARP.getValue());
            rarePokemon.add(PokemonId.KRABBY.getValue());
            rarePokemon.add(PokemonId.SHELLDER.getValue());
            superRarePokemon.add(PokemonId.SQUIRTLE.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            commonPokemon.add(PokemonId.TENTACOOL.getValue());
            commonPokemon.add(PokemonId.POLIWAG.getValue());
            commonPokemon.add(PokemonId.PSYDUCK.getValue());
            commonPokemon.add(PokemonId.GOLDEEN.getValue());
            commonPokemon.add(PokemonId.MAGIKARP.getValue());
            rarePokemon.add(PokemonId.KRABBY.getValue());
            rarePokemon.add(PokemonId.SHELLDER.getValue());
            rarePokemon.add(PokemonId.POLIWHIRL.getValue());
        } else {
            commonPokemon.add(PokemonId.TENTACOOL.getValue());
            commonPokemon.add(PokemonId.TENTACRUEL.getValue());
            commonPokemon.add(PokemonId.SEAKING.getValue());
            commonPokemon.add(PokemonId.GOLDEEN.getValue());
            commonPokemon.add(PokemonId.MAGIKARP.getValue());
            commonPokemon.add(PokemonId.POLIWHIRL.getValue());
            commonPokemon.add(PokemonId.KRABBY.getValue());
            commonPokemon.add(PokemonId.SHELLDER.getValue());
            rarePokemon.add(PokemonId.GYARADOS.getValue());
            rarePokemon.add(PokemonId.KINGLER.getValue());
            rarePokemon.add(PokemonId.CLOYSTER.getValue());
        }
        superRarePokemon.add(PokemonId.SQUIRTLE.getValue());
    }

    private void addTrainStationPokemon() {
        if (difficulty == EARLY_DIFFICULTY) {
            commonPokemon.add(PokemonId.ZUBAT.getValue());
            commonPokemon.add(PokemonId.RATTATA.getValue());
            commonPokemon.add(PokemonId.GEODUDE.getValue());
            commonPokemon.add(PokemonId.MAGNEMITE.getValue());
            commonPokemon.add(PokemonId.GRIMER.getValue());
            commonPokemon.add(PokemonId.VOLTORB.getValue());
            rarePokemon.add(PokemonId.PIDGEY.getValue());
            rarePokemon.add(PokemonId.ONIX.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_RATTATA.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_GEODUDE.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_GRIMER.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            commonPokemon.add(PokemonId.ZUBAT.getValue());
            commonPokemon.add(PokemonId.RATTATA.getValue());
            commonPokemon.add(PokemonId.GEODUDE.getValue());
            commonPokemon.add(PokemonId.MAGNEMITE.getValue());
            commonPokemon.add(PokemonId.GRIMER.getValue());
            commonPokemon.add(PokemonId.VOLTORB.getValue());
            rarePokemon.add(PokemonId.RATICATE.getValue());
            rarePokemon.add(PokemonId.PIDGEY.getValue());
            rarePokemon.add(PokemonId.PIDGEOTTO.getValue());
            rarePokemon.add(PokemonId.GOLBAT.getValue());
            rarePokemon.add(PokemonId.ONIX.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_RATTATA.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_RATICATE.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_GEODUDE.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_GRIMER.getValue());
        } else {
            commonPokemon.add(PokemonId.GOLBAT.getValue());
            commonPokemon.add(PokemonId.GRAVELER.getValue());
            commonPokemon.add(PokemonId.ONIX.getValue());
            commonPokemon.add(PokemonId.RATICATE.getValue());
            commonPokemon.add(PokemonId.GRIMER.getValue());
            commonPokemon.add(PokemonId.VOLTORB.getValue());
            rarePokemon.add(PokemonId.GEODUDE.getValue());
            rarePokemon.add(PokemonId.PIDGEOTTO.getValue());
            rarePokemon.add(PokemonId.GOLBAT.getValue());
            rarePokemon.add(PokemonId.ELECTRODE.getValue());
            rarePokemon.add(PokemonId.MAGNEMITE.getValue());
            rarePokemon.add(PokemonId.MAGNETON.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_RATTATA.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_RATICATE.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_GEODUDE.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_GRAVELER.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_GRIMER.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_MUK.getValue());
        }
    }

    private void addSchoolPokemon() {
        if (difficulty == EARLY_DIFFICULTY) {
            commonPokemon.add(PokemonId.ODDISH.getValue());
            commonPokemon.add(PokemonId.CATERPIE.getValue());
            commonPokemon.add(PokemonId.WEEDLE.getValue());
            commonPokemon.add(PokemonId.PIDGEY.getValue());
            rarePokemon.add(PokemonId.PIKACHU.getValue());
            rarePokemon.add(PokemonId.MEOWTH.getValue());
            rarePokemon.add(PokemonId.KAKUNA.getValue());
            rarePokemon.add(PokemonId.METAPOD.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_MEOWTH.getValue());
        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            commonPokemon.add(PokemonId.ODDISH.getValue());
            commonPokemon.add(PokemonId.PIDGEY.getValue());
            commonPokemon.add(PokemonId.KAKUNA.getValue());
            commonPokemon.add(PokemonId.METAPOD.getValue());
            rarePokemon.add(PokemonId.PIDGEOTTO.getValue());
            rarePokemon.add(PokemonId.PIKACHU.getValue());
            rarePokemon.add(PokemonId.MEOWTH.getValue());
            rarePokemon.add(PokemonId.GLOOM.getValue());
            rarePokemon.add(PokemonId.BUTTERFREE.getValue());
            rarePokemon.add(PokemonId.BEEDRILL.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_MEOWTH.getValue());
        } else {
            commonPokemon.add(PokemonId.PIDGEOTTO.getValue());
            commonPokemon.add(PokemonId.GLOOM.getValue());
            commonPokemon.add(PokemonId.BUTTERFREE.getValue());
            commonPokemon.add(PokemonId.BEEDRILL.getValue());
            rarePokemon.add(PokemonId.PIKACHU.getValue());
            rarePokemon.add(PokemonId.MEOWTH.getValue());
            superRarePokemon.add(PokemonId.FARFETCHD.getValue());
            superRarePokemon.add(PokemonId.ALOLAN_PERSIAN.getValue());
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

            commonPokemon.add(PokemonId.VULPIX.getValue());
            commonPokemon.add(PokemonId.MANKEY.getValue());
            commonPokemon.add(PokemonId.SLOWPOKE.getValue());
            rarePokemon.add(PokemonId.DODUO.getValue());
            rarePokemon.add(PokemonId.PONYTA.getValue());

        } else if (difficulty == EARLY_MID_DIFFICULTY) {
            commonPokemon.add(PokemonId.VULPIX.getValue());
            commonPokemon.add(PokemonId.MANKEY.getValue());
            commonPokemon.add(PokemonId.SLOWPOKE.getValue());
            rarePokemon.add(PokemonId.DODUO.getValue());
            rarePokemon.add(PokemonId.PONYTA.getValue());
            rarePokemon.add(PokemonId.KANGASKHAN.getValue());
            rarePokemon.add(PokemonId.RHYHORN.getValue());
            rarePokemon.add(PokemonId.TAUROS.getValue());
        } else {
            commonPokemon.add(PokemonId.VULPIX.getValue());
            commonPokemon.add(PokemonId.MANKEY.getValue());
            commonPokemon.add(PokemonId.SLOWPOKE.getValue());
            rarePokemon.add(PokemonId.DODUO.getValue());
            rarePokemon.add(PokemonId.PONYTA.getValue());
            rarePokemon.add(PokemonId.KANGASKHAN.getValue());
            rarePokemon.add(PokemonId.RHYHORN.getValue());
            rarePokemon.add(PokemonId.TAUROS.getValue());
            rarePokemon.add(PokemonId.PRIMEAPE.getValue());
            rarePokemon.add(PokemonId.SLOWBRO.getValue());
            rarePokemon.add(PokemonId.DODRIO.getValue());
        }
        superRarePokemon.add(PokemonId.EEVEE.getValue());
        superRarePokemon.add(PokemonId.FARFETCHD.getValue());

    }

}
