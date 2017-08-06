package com.pokemon.toronto.game.com.pokemon.toronto.Ball;

/**
 * Created by Gregory on 6/17/2017.
 */
public abstract class Ball {

    //Ball Type Constants
    public static final int POKEBALL = 0;

    //Instance Variables
    protected String name;
    protected String description;
    protected int rate;
    protected int price;
    protected String iconPath;
    protected int id;
    protected int quantity;

    /**
     * Constructor
     * @param id The Pokeball's id
     * @param name The name of the Pokeball
     * @param description The description of the Pokeball
     * @param iconPath The image path of the Pokeball icon
     * @param rate The catching rate of the Pokeball.
     * @param price The price of the Pokeball.
     * @param quantity The quantity of Pokeballs.
     */
    public Ball(int id, String name, String description, String iconPath,
                int rate, int price, int quantity) {
        this.name = name;
        this.description = description;
        this.iconPath = iconPath;
        this.rate = rate;
        this.price = price;
        this.id = id;
        this.quantity = quantity;
    }

    /**
     * Return the Pokeball's name.
     * @return The String name of the Pokeball.
     */
    public String getName() {
        return name;
    }

    /**
     * Return the Pokeball's description.
     * @return The String description of the Pokeball.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Return the price of a single Pokeball.
     * @return The int price of a single Pokeball
     */
    public int getPrice() {
        return price;
    }

    /**
     * Return the Pokeball's image icon path.
     * @return The Pokeball's icon path.
     */
    public String getIconPath() {
        return iconPath;
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
     * Return the Id of the Pokeball.
     * @return The int id of the Pokeball.
     */
    public int getId() {
        return id;
    }

    /**
     * Add quantity to the quantity of Pokeballs.
     * @param quantity The amount to be added to the total quantity.
     */
    public void add(int quantity) {
        this.quantity += quantity;
    }
}
