package com.pokemon.toronto.game.com.pokemon.toronto.box;

import com.badlogic.gdx.Gdx;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-23.
 */

public class PokemonBox {
    private List<List<BoxPokemon>> pc;
    private List<BoxLocation> nullLocations;
    private final int TOTAL_BOXES = 1;
    private final int TOTAL_POSITIONS = 30;

    //Custom Box Locations
    public final int PARTY = -1;
    public final int NEW_NULL = -2; //Can also be an original position for a new null.

    public PokemonBox() {
        initializeBoxes();
    }

    private void initializeBoxes() {
        pc = new ArrayList<List<BoxPokemon>>();
        for (int i = 0; i < TOTAL_BOXES; i++) {
            pc.add(createEmptyBox(i));
        }
    }

    private List<BoxPokemon> createEmptyBox(int boxNumber) {
        List<BoxPokemon> box = new ArrayList<BoxPokemon>();
        for(int i = 0; i < TOTAL_POSITIONS; i++) {
            box.add(new BoxPokemon(null, new BoxLocation(boxNumber, i)));
        }
        return box;
    }

    public List<BoxPokemon> getBox(int boxNumber) {
        if (boxNumber < pc.size()) {
            return pc.get(boxNumber);
        } else {
            return null;
        }
    }

    public void printBox(int boxNumber) {
        for (int i = 0; i < pc.get(boxNumber).size(); i++) {
            BoxLocation boxLocation = pc.get(boxNumber).get(i).getBoxLocation();
            if (pc.get(boxNumber).get(i).getPokemon() != null) {
                Gdx.app.log("PCLOG", "Box: " + boxLocation.getBoxNumber() +
                        " Box Pos: " + boxLocation.getBoxPosition() + " Poke: " +
                        pc.get(boxNumber).get(i).getPokemon().getName());
            } else {
                Gdx.app.log("PCLOG", "Box: " + boxLocation.getBoxNumber() +
                        " Box Pos: " + boxLocation.getBoxPosition() + " Poke: null");
            }
        }
    }

    /**
     * Deposit a Pokemon after catching it in the wild.
     * @param depositedPokemon The caught Pokemon being deposited to the box.
     * @return The BoxLocation of the deposited Pokemon.
     */
    public BoxLocation depositCaughtPokemon(Pokemon depositedPokemon) {
        for (int currentBox = 0; currentBox < pc.size(); currentBox++) {
            for (int boxPosition = 0; boxPosition < pc.get(currentBox).size(); boxPosition++) {
                if (pc.get(currentBox).get(boxPosition).getPokemon() == null) {
                    pc.get(currentBox).get(boxPosition).setPokemon(depositedPokemon);
                    return pc.get(currentBox).get(boxPosition).getBoxLocation();
                }
            }
        }
        return null;
    }

    public void depositPokemon(Pokemon depositedPokemon, int boxNumber, int boxPosition) {
        pc.get(boxNumber).get(boxPosition).setPokemon(depositedPokemon);
    }

    public void depositPartyPokemon(BoxPokemon depositedPokemon) {
        for (int currentBox = 0; currentBox < pc.size(); currentBox++) {
            for (int boxPosition = 0; boxPosition < pc.get(currentBox).size(); boxPosition++) {
                if (pc.get(currentBox).get(boxPosition).getPokemon() == null) {
                    pc.get(currentBox).set(boxPosition, depositedPokemon);
                }
            }
        }
    }

    public void depositPartyPokemon(BoxPokemon depositedPokemon, int boxNumber, int boxPosition) {
        pc.get(boxNumber).set(boxPosition, depositedPokemon);
    }

    public void initNullLocations() {
        nullLocations = new ArrayList<BoxLocation>();
        for (int currentBox = 0; currentBox < pc.size(); currentBox++) {
            for (int boxPosition = 0; boxPosition < pc.get(currentBox).size(); boxPosition++) {
                if (pc.get(currentBox).get(boxPosition).getPokemon() == null) {
                    nullLocations.add(pc.get(currentBox).get(boxPosition).getBoxLocation());
                }
            }
        }
    }

    public List<BoxLocation> getNullLocations() {
        return nullLocations;
    }

    public List<BoxLocation> getDeletableNulls() {
        List<BoxLocation> deletableNulls = new ArrayList<BoxLocation>();
        for (int currentBox = 0; currentBox < pc.size(); currentBox++) {
            for (int boxPosition = 0; boxPosition < pc.get(currentBox).size(); boxPosition++) {
                if (pc.get(currentBox).get(boxPosition).getPokemon() == null) {
                    //Boxes don't match. A swap / shift occurred.
                    BoxLocation bl = new BoxLocation(currentBox, boxPosition);
                    if (!hasMatchingOriginalNull(bl)) {
                        deletableNulls.add(bl);
                    }
                }

            }
        }
        return  deletableNulls;
    }

    public boolean hasMatchingOriginalNull(BoxLocation boxLocation) {
        for (int i = 0; i < nullLocations.size(); i++) {
            if (boxLocation.getBoxPosition() == nullLocations.get(i).getBoxPosition() &&
                    boxLocation.getBoxNumber() == nullLocations.get(i).getBoxNumber()) {
                return true;
            }
        }
        return false;
    }

    public void removePokemon(int boxNumber, int boxPosition) {
        BoxPokemon bp = new BoxPokemon(null, new BoxLocation(NEW_NULL, NEW_NULL));
        pc.get(boxNumber).set(boxPosition, bp);
    }


    public List<BoxLocation> logout() {
        List<BoxLocation> updatableLocations = new ArrayList<BoxLocation>();
        for (int currentBox = 0; currentBox < pc.size(); currentBox++) {
            for (int boxPosition = 0; boxPosition < pc.get(currentBox).size(); boxPosition++) {
                if (pc.get(currentBox).get(boxPosition).getPokemon() != null) {
                    if (!(pc.get(currentBox).get(boxPosition).getBoxLocation().getBoxNumber() == currentBox &&
                            pc.get(currentBox).get(boxPosition).getBoxLocation().getBoxPosition() == boxPosition)) {
                        //Boxes don't match. A swap / shift occurred.
                        updatableLocations.add(new BoxLocation(currentBox, boxPosition));
                    }
                }
                pc.get(currentBox).get(boxPosition).getBoxLocation().setBoxNumber(currentBox);
                pc.get(currentBox).get(boxPosition).getBoxLocation().setBoxPosition(boxPosition);
            }
        }
        return updatableLocations;
    }
}
