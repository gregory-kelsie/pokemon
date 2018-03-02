package com.pokemon.toronto.game.com.pokemon.toronto.box;

/**
 * Created by gregorykelsie on 2018-01-23.
 */

public class BoxLocation {
    private int boxNumber;
    private int boxPosition;

    public BoxLocation(int boxNumber, int boxPosition) {
        this.boxNumber = boxNumber;
        this.boxPosition = boxPosition;
    }

    public int getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(int boxNumber) {
        this.boxNumber = boxNumber;
    }

    public int getBoxPosition() {
        return boxPosition;
    }

    public void setBoxPosition(int boxPosition) {
        this.boxPosition = boxPosition;
    }
}
