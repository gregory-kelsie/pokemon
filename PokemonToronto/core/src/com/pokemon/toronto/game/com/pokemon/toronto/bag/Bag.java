package com.pokemon.toronto.game.com.pokemon.toronto.bag;

import com.pokemon.toronto.game.com.pokemon.toronto.Ball.Ball;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokeballFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/17/2017.
 */
public class Bag {
    private List<Ball> pokeballs;
    public Bag() {
        pokeballs = new ArrayList<Ball>();
    }

    public List<Ball> getPokeballBag() {
        return pokeballs;
    }

    public void addPokeball(int id, int quantity) {
        boolean added = false;
        for (int i = 0; i < pokeballs.size(); i++) {
            if (pokeballs.get(i).getId() == id) {
                pokeballs.get(i).add(quantity);
                added = true;
                break;
            }
        }
        if (!added) {
            PokeballFactory pf = new PokeballFactory();
            pokeballs.add(pf.createPokeball(id, quantity));
        }

    }


}
