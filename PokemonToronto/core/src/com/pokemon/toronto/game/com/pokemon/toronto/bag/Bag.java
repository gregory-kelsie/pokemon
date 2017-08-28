package com.pokemon.toronto.game.com.pokemon.toronto.bag;

import com.pokemon.toronto.game.com.pokemon.toronto.Ball.Ball;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.ItemFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokeballFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;
import com.pokemon.toronto.game.com.pokemon.toronto.item.PlayerItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/17/2017.
 */
public class Bag {

    //Instance variables
    private List<Ball> pokeballs;
    private List<PlayerItem> stones;

    /**
     * Constructor
     * Create an empty bag.
     */
    public Bag() {
        pokeballs = new ArrayList<Ball>();
        stones = new ArrayList<PlayerItem>();
    }

    /**
     * Return the Pokeball portion of the bag.
     * @return The Pokeball bag.
     */
    public List<Ball> getPokeballBag() {
        return pokeballs;
    }

    /**
     * Return the Stone portion of the bag.
     * @return The Stones bag.
     */
    public List<PlayerItem> getStoneBag() { return stones; }

    /**
     * Return whether or not the Player has the stone with
     * an id = stoneId
     * @param stoneId The stone we are searching for.
     * @return Whether or not the Player has the stone with
     * stoneId in the bag.
     */
    public boolean hasStone(int stoneId) {
        for (int i = 0; i < stones.size(); i++) {
            if (stones.get(i).getItem().getId() == stoneId) {
                return true;
            }
        }
        return false;
    }

    public void addStone(int stoneId) {
        boolean addedStone = false;
        for (int i = 0; i < stones.size(); i++) {
            if (stones.get(i).getItem().getId() == stoneId) {
                stones.get(i).add(1);
                addedStone = true;
            }
        }
        if (!addedStone) {
            ItemFactory stoneFactory = new ItemFactory();
            stones.add(stoneFactory.createStone(stoneId, 1));
        }
    }

    /**
     * Add Pokeballs to the Pokeball bag.
     * @param id The type of Pokeball (Pokeball, Greatball etc)
     * @param quantity The quantity of the Pokeball added. (1-n)
     */
    public void addPokeball(int id, int quantity) {
        boolean added = false;

        for (int i = 0; i < pokeballs.size(); i++) {
            //Look through the Pokeball bag to see if there exists
            //the added Pokeball type.
            if (isPokeballType(i, id)) {
                pokeballs.get(i).add(quantity);
                added = true;
                break;
            }
        }
        if (!added) {
            //Create a new Pokeball in the bag for the Pokeball that
            //has id, and add the quantity to the new Pokeball.
            PokeballFactory pf = new PokeballFactory();
            pokeballs.add(pf.createPokeball(id, quantity));
        }

    }

    /**
     * Return whether or not the Pokeball at the specified index
     * in the Pokeball bag matches the addedId.
     * @param index The index of a Pokeball in the Pokeball bag.
     * @param addedId An id of a Pokeball
     * @return A boolean on whether or not the Pokeball at the
     * specified index in the Pokeball bag matches the addedId.
     */
    public boolean isPokeballType(int index, int addedId) {
        if (pokeballs.get(index).getId() == addedId) {
            return true;
        }
        return false;
    }



}
