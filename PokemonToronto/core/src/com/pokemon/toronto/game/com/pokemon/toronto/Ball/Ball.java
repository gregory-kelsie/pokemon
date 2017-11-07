package com.pokemon.toronto.game.com.pokemon.toronto.Ball;

import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemBlob;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemId;

/**
 * Created by Gregory on 6/17/2017.
 */
public abstract class Ball extends Item {

    //Instance Variables
    protected int rate;
    protected int quantity;


    /**
     * Constructor
     * @param info The id, name, description of the Pokeball
     * @param iconPath The image path of the Pokeball icon
     * @param rate The catching rate of the Pokeball.
     */
    public Ball(ItemBlob info, String iconPath,
                int rate) {
        super(info, iconPath);
        this.rate = rate;
        this.quantity = 1;
    }

    /**
     * Constructor
     * @param info The id, name, description of the Pokeball
     * @param iconPath The image path of the Pokeball icon
     * @param rate The catching rate of the Pokeball.
     */
    public Ball(ItemBlob info, String iconPath,
                int rate, int quantity) {
        super(info, iconPath);
        this.rate = rate;
        this.quantity = quantity;
    }

    /**
     * Return the catching rate of the Pokeball.
     * @return The int catching rate of the Pokeball.
     */
    public int getRate() {
        return rate;
    }

    /**
     * Return the quantity of Pokeballs.
     * @return The int quantity of Pokeballs.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Subtract amt from the quantity of Pokeballs.
     * @param amt The amount to be subtracted.
     */
    public void subtractQuantity(int amt) {
        quantity -= amt;
    }

    /**
     * Add quantity to the quantity of Pokeballs.
     * @param quantity The amount to be added to the total quantity.
     */
    public void add(int quantity) {
        this.quantity += quantity;
    }
}
