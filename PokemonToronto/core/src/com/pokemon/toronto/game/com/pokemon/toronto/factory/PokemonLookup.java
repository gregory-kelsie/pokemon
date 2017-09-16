package com.pokemon.toronto.game.com.pokemon.toronto.factory;

import com.badlogic.gdx.Gdx;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.PokemonId;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Gregory on 6/11/2017.
 */
public class PokemonLookup {
    //Instance Variables
    private String city;
    private String country;
    private String state;
    private int amount;
    private double latitude;
    private double longitude;

    //The range in which Pokemon gets spawned. (in meters)
    private final int POKEMON_RANGE = 200;

    /**
     * Look up a stated amount of Pokemon from a given location.
     * @param city The city of the player's location.
     * @param state The state/province of the player's location.
     * @param country The country of the player's location.
     * @param latitude The latitude of the player's location.
     * @param longitude The longitude of the player's location.
     * @param amount The amount of Pokemon to spawn.
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

    /**
     * Return the latitude and longitude coordiantes as a double array within
     * a specified radius. (Got this formula from a website.)
     * @param y0 The player's latitude position.
     * @param x0 The player's longitude position.
     * @param radius The size of the radius
     * @return A double array that contains a random set latitude and longitude
     * coordinates within the given radius.
     */
    public static double[] getRandomLocation(double y0, double x0, double radius) {
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
    }

    /**
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference. If you are not interested in height
     * difference pass 0.0. Uses Haversine method as its base.
     *
     * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
     * el2 End altitude in meters
     * @returns Distance in Meters
     */
    private double distance(double lat1, double lat2, double lon1,
                           double lon2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        //double height = el1 - el2;

        distance = Math.pow(distance, 2);// + Math.pow(height, 2);

        return Math.sqrt(distance);
    }


    /**
     * Return a list of PokemonLookupPackages based on the player's location.
     * @return A list of PokemonLookupPackages based on the player's location.
     */
    public List<PokemonLookupPackage> getPokemon() {
        if (country.equals("Canada")) {
            return getCanadaPokemon();
        } else {
            return getDefaultPokemon();
        }
    }

    /**
     * Return a list of PokemonLookupPackages based on the province they're in.
     * @returna A list of PokemonLookupPackages based on the province they're in.
     */
    private List<PokemonLookupPackage> getCanadaPokemon() {
        if (state.equals("Ontario")) {
            return getOntarioPokemon();
        } else {
            return getDefaultPokemon();
        }
    }


    /**
     * Return a list of PokemonLookupPackages from Ontario based on the city they're in.
     * @returna A list of PokemonLookupPackages from Ontario based on the city they're in.
     * @return
     */
    private List<PokemonLookupPackage> getOntarioPokemon() {
        if (city.equals("Toronto")) {
            return getTorontoPokemon();
        } else {
            return getDefaultPokemon();
        }
    }

    /**
     * Return a list of PokemonLookupPackages from Toronto.
     * @return A list of PokemonLookupPackages from Toronto.
     */
    private List<PokemonLookupPackage> getTorontoPokemon() {
        List<PokemonLookupPackage> plp = new ArrayList<PokemonLookupPackage>();
        //Create a random Pokemon amount times.
        for (int i = 0; i < amount; i++) {
            PokemonLookupPackage pokemon;
            double[] pokemonLocation = getRandomLocation(latitude, longitude, POKEMON_RANGE);
            //Roll a random number to see what Pokemon shows up.
            int rand = (int) Math.round(Math.random() * 100);
            if (rand <= 30) {
                pokemon = new PokemonLookupPackage(PokemonId.RATTATA.getValue(), pokemonLocation[0],
                        pokemonLocation[1]);

            } else if (rand <= 60) {
                pokemon = new PokemonLookupPackage(PokemonId.PIDGEY.getValue(), pokemonLocation[0],
                        pokemonLocation[1]);
            }
            else if (rand <= 70) {
                pokemon = new PokemonLookupPackage(PokemonId.CATERPIE.getValue(), pokemonLocation[0],
                        pokemonLocation[1]);
            }
            else if (rand <= 80) {
                pokemon = new PokemonLookupPackage(PokemonId.WEEDLE.getValue(), pokemonLocation[0],
                        pokemonLocation[1]);
            }
            else if (rand <= 85) {
                pokemon = new PokemonLookupPackage(PokemonId.PIKACHU.getValue(), pokemonLocation[0],
                        pokemonLocation[1]);
            } else if (rand <= 92) {
                pokemon = new PokemonLookupPackage(PokemonId.NIDORANM.getValue(), pokemonLocation[0],
                        pokemonLocation[1]);
            }  else if (rand <= 99) {
                pokemon = new PokemonLookupPackage(PokemonId.NIDORANF.getValue(), pokemonLocation[0],
                        pokemonLocation[1]);
            }
            else {
                pokemon = new PokemonLookupPackage(PokemonId.EEVEE.getValue(), pokemonLocation[0],
                        pokemonLocation[1]);
            }
            plp.add(pokemon);
        }
        return plp;
    }

    /**
     * Return a list of default PokemonLookupPackages.
     * @return A list of default PokemonLookupPackages.
     */
    private List<PokemonLookupPackage> getDefaultPokemon() {
        return getTorontoPokemon();
    }


}
