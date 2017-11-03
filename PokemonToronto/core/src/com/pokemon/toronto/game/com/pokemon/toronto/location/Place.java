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

public class Place {

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
    private Set<Integer> trainers;

    public Place(String name, double latitude, double longitude, List<Integer> types) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
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
        commonPokemon.add(PokemonId.PIDGEY.getValue());
        commonPokemon.add(PokemonId.SPEAROW.getValue());
        commonPokemon.add(PokemonId.MAGNEMITE.getValue());
        rarePokemon.add(PokemonId.DODUO.getValue());
    }

    private void addAmusementParkPokemon() {
        /*
        Drowzee
        Abra
        Mr Mime
        Jinx
        Tauros - Rare
        */
        commonPokemon.add(PokemonId.DROWZEE.getValue());
        commonPokemon.add(PokemonId.ABRA.getValue());

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
        commonPokemon.add(PokemonId.TENTACOOL.getValue());
        commonPokemon.add(PokemonId.SEEL.getValue());
        rarePokemon.add(PokemonId.SQUIRTLE.getValue());

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
        commonPokemon.add(PokemonId.JIGGLYPUFF.getValue());
        rarePokemon.add(PokemonId.CLEFAIRY.getValue());
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
        commonPokemon.add(PokemonId.NIDORANM.getValue());
        commonPokemon.add(PokemonId.NIDORANF.getValue());
        commonPokemon.add(PokemonId.DIGLETT.getValue());
        commonPokemon.add(PokemonId.ODDISH.getValue());
        commonPokemon.add(PokemonId.EKANS.getValue());
        commonPokemon.add(PokemonId.VENONAT.getValue());
        commonPokemon.add(PokemonId.PARAS.getValue());
        commonPokemon.add(PokemonId.PSYDUCK.getValue());
        rarePokemon.add(PokemonId.BULBASAUR.getValue());
    }

    private void addPetPokemon() {
        /*
        Pikachu
        Meowth
        Sandshrew
         */
        commonPokemon.add(PokemonId.PIKACHU.getValue());
        commonPokemon.add(PokemonId.SANDSHREW.getValue());
        commonPokemon.add(PokemonId.MEOWTH.getValue());

        superRarePokemon.add(PokemonId.RAICHU.getValue());
    }

    private void addCasinoPokemon() {
        /*
        Zubat
        Eevee
        Koffing
        Porygon
         */
        commonPokemon.add(PokemonId.ZUBAT.getValue());
        rarePokemon.add(PokemonId.EEVEE.getValue());
    }

    private void addCemetaryPokemon() {
        /*
        Gastly
        Zubat
        Ekans
        Venonat
        Abra
        Paras
         */
        commonPokemon.add(PokemonId.ZUBAT.getValue());
        commonPokemon.add(PokemonId.EKANS.getValue());
        commonPokemon.add(PokemonId.VENONAT.getValue());
        commonPokemon.add(PokemonId.PARAS.getValue());
        commonPokemon.add(PokemonId.GASTLY.getValue());
        commonPokemon.add(PokemonId.ABRA.getValue());

    }

    private void addChurchPokemon() {
        /*
        Gastly
        Abra
        Clefairy
         */
        commonPokemon.add(PokemonId.GASTLY.getValue());
        commonPokemon.add(PokemonId.ABRA.getValue());
        rarePokemon.add(PokemonId.CLEFAIRY.getValue());
    }

    private void addHospitalPokemon() {
        /*
        Chansey
        Clefairy
        Jigglypuff
        Oddish
         */
        commonPokemon.add(PokemonId.JIGGLYPUFF.getValue());
        commonPokemon.add(PokemonId.ODDISH.getValue());
        rarePokemon.add(PokemonId.CLEFAIRY.getValue());
    }

    private void addElectronicStorePokemon() {
        /*
        Voltorb
        Magnemite
        Electabuzz - Rare
        */
        commonPokemon.add(PokemonId.VOLTORB.getValue());
        commonPokemon.add(PokemonId.MAGNEMITE.getValue());
    }

    private void addFireStationPokemon() {
        /*
        Growlithe
        Charmander
        Koffing
        Magmar
         */
        commonPokemon.add(PokemonId.GROWLITHE.getValue());
        rarePokemon.add(PokemonId.CHARMANDER.getValue());
    }

    private void addFloristPokemon() {
        /*
        Oddish
        Bellsprout
         */
        commonPokemon.add(PokemonId.ODDISH.getValue());
        commonPokemon.add(PokemonId.BELLSPROUT.getValue());
    }

    private void addGymPokemon() {
        /*
        Machop
        Grimer
        Hitmonchan
        Hitmonlee
        Snorlax - Rare
        */
        commonPokemon.add(PokemonId.MACHOP.getValue());
        commonPokemon.add(PokemonId.GRIMER.getValue());

    }

    private void addMovingPokemon() {
        commonPokemon.add(PokemonId.MACHOP.getValue());
    }

    private void addMuseumPokemon() {
        /*
        Lapras - Rare
        Omanyte - Rare
        Kabuto - Rare
        Aerodactyl - Rare
        Gastly
                Cubone
        Grimer
        Dratini - Super rare
        */
        commonPokemon.add(PokemonId.GASTLY.getValue());
        commonPokemon.add(PokemonId.GRIMER.getValue());
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
        commonPokemon.add(PokemonId.TENTACOOL.getValue());
        commonPokemon.add(PokemonId.POLIWAG.getValue());
        commonPokemon.add(PokemonId.PSYDUCK.getValue());
        rarePokemon.add(PokemonId.KRABBY.getValue());
        rarePokemon.add(PokemonId.SQUIRTLE.getValue());
    }

    private void addTrainStationPokemon() {
        /*
        Zubat
        Magnemite
        Voltorb
        Koffing
        Pidgey
        Geodude
        Grimer
        Onix - Rare
         */
        commonPokemon.add(PokemonId.PIDGEY.getValue());
        commonPokemon.add(PokemonId.ZUBAT.getValue());
        commonPokemon.add(PokemonId.GEODUDE.getValue());
        commonPokemon.add(PokemonId.MAGNEMITE.getValue());
        commonPokemon.add(PokemonId.VOLTORB.getValue());
        rarePokemon.add(PokemonId.ONIX.getValue());
    }

    private void addSchoolPokemon() {
        /*
        Drowzee
        Voltorb
        Magnemite
        Abra
        Slowpoke
        Farfetch'd - Rare
        Ditto - Rare
        Porygon - Rare
         */
        commonPokemon.add(PokemonId.DROWZEE.getValue());
        commonPokemon.add(PokemonId.VOLTORB.getValue());
        commonPokemon.add(PokemonId.ABRA.getValue());
        commonPokemon.add(PokemonId.MAGNEMITE.getValue());
        commonPokemon.add(PokemonId.VOLTORB.getValue());
        rarePokemon.add(PokemonId.SLOWPOKE.getValue());
        superRarePokemon.add(PokemonId.FARFETCHD.getValue());
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
        commonPokemon.add(PokemonId.PONYTA.getValue());
        commonPokemon.add(PokemonId.VULPIX.getValue());
        commonPokemon.add(PokemonId.MANKEY.getValue());
        commonPokemon.add(PokemonId.DODUO.getValue());
        commonPokemon.add(PokemonId.TENTACOOL.getValue());
        rarePokemon.add(PokemonId.EEVEE.getValue());
        superRarePokemon.add(PokemonId.FARFETCHD.getValue());
    }

}
