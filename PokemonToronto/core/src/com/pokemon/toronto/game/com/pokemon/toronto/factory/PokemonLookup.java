package com.pokemon.toronto.game.com.pokemon.toronto.factory;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.PokemonId;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Gregory on 6/11/2017.
 */
public class PokemonLookup {
    private String city;
    private String country;
    private String state;
    private int amount;
    private double latitude;
    private double longitude;

    private final int POKEMON_RANGE = 500; //500m

    /**
     * Look up a stated amount of Pokemon from a given location.
     */
    public PokemonLookup(String city, String state, String country,
                         double latitude, double longitude, int amount) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.amount = amount;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private double[] getRandomLocation(double y0, double x0, double radius) {
        double d[] = new double[2];
        Random random = new Random();

        // Convert radius from meters to degrees
        double radiusInDegrees = radius / 111000f;

        double u = random.nextDouble();
        double v = random.nextDouble();
        double w = radiusInDegrees * Math.sqrt(u);
        double t = 2 * Math.PI * v;
        double x = w * Math.cos(t);
        double y = w * Math.sin(t);

        // Adjust the x-coordinate for the shrinking of the east-west distances
        double new_x = x / Math.cos(Math.toRadians(y0));

        double foundLongitude = new_x + x0;
        double foundLatitude = y + y0;
        d[0] = foundLatitude;
        d[1] = foundLongitude;
        return d;
        //System.out.println("Longitude: " + foundLongitude + "  Latitude: " + foundLatitude );
    }

    public boolean hasAvailableRegion() {
        if (!country.equals("")) {
            return true;
        }
        return false;
    }

    public List<PokemonLookupPackage> getPokemon() {
        if (country.equals("Canada")) {
                return getCanadaPokemon();
        } else if (country == null) {
            return null;
        }
        else {
            return null;
        }
    }

    private List<PokemonLookupPackage> getCanadaPokemon() {
        if (state.equals("Ontario")) {
            return getOntarioPokemon();
        } else {
            return getDefaultPokemon();
        }
    }

    private List<PokemonLookupPackage> getOntarioPokemon() {
        if (city.equals("Scarborough")) {
            return getScarboroughPokemon();
        } else if (city.equals("Toronto")) {
            return getTorontoPokemon();
        } else {
            return getDefaultPokemon();
        }
    }

    private List<PokemonLookupPackage> getScarboroughPokemon() {

        List<PokemonLookupPackage> plp = new ArrayList<PokemonLookupPackage>();
        for (int i = 0; i < amount; i++) {
            PokemonLookupPackage pokemon = new PokemonLookupPackage();
            double[] pokemonLocation = getRandomLocation(latitude, longitude, POKEMON_RANGE);
            int rand = (int) Math.round(Math.random() * 100);
            if (rand <= 30) {
                pokemon.insertData(PokemonId.RATTATA.getValue(), pokemonLocation[0],
                        pokemonLocation[1]);

            } else if (rand <= 60) {
                pokemon.insertData(PokemonId.PIDGEY.getValue(), pokemonLocation[0],
                        pokemonLocation[1]);
            }
            else if (rand <= 70) {
                pokemon.insertData(PokemonId.CATERPIE.getValue(), pokemonLocation[0],
                        pokemonLocation[1]);
            }
            else if (rand <= 80) {
                pokemon.insertData(PokemonId.WEEDLE.getValue(), pokemonLocation[0],
                        pokemonLocation[1]);
            }
            else if (rand <= 85) {
                pokemon.insertData(PokemonId.PIKACHU.getValue(), pokemonLocation[0],
                        pokemonLocation[1]);
            } else if (rand <= 92) {
                pokemon.insertData(PokemonId.NIDORANM.getValue(), pokemonLocation[0],
                        pokemonLocation[1]);
            }  else if (rand <= 99) {
                pokemon.insertData(PokemonId.NIDORANF.getValue(), pokemonLocation[0],
                        pokemonLocation[1]);
            }
            else {
                pokemon.insertData(PokemonId.EEVEE.getValue(), pokemonLocation[0],
                        pokemonLocation[1]);
            }
            plp.add(pokemon);
        }

        return plp;
    }

    private List<PokemonLookupPackage> getDefaultPokemon() {
        return getScarboroughPokemon();
    }

    private List<PokemonLookupPackage> getTorontoPokemon() {
        List<PokemonLookupPackage> plp = new ArrayList<PokemonLookupPackage>();
        for (int i = 0; i < amount; i++) {
            PokemonLookupPackage pokemon = new PokemonLookupPackage();
            double[] pokemonLocation = getRandomLocation(latitude, longitude, POKEMON_RANGE);
            int rand = (int) (Math.random() * 100);
            if (rand <= 50) {
                pokemon.insertData(PokemonId.RATTATA.getValue(), pokemonLocation[0],
                        pokemonLocation[1]);
            } else {
                pokemon.insertData(PokemonId.PIDGEY.getValue(), pokemonLocation[0],
                        pokemonLocation[1]);
            }
            plp.add(pokemon);
        }
        return plp;
    }
}
