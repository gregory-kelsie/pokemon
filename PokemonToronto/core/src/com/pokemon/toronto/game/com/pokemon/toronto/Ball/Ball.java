package com.pokemon.toronto.game.com.pokemon.toronto.Ball;

/**
 * Created by Gregory on 6/17/2017.
 */
public abstract class Ball {
    protected String name;
    protected String description;
    protected int rate;
    protected int price;
    protected String iconPath;
    protected int id;
    protected int quantity;

    //Ball ID
    public static final int POKEBALL = 0;

    public Ball(int id, String name, String description, String iconPath, int rate, int price, int quantity) {
        this.name = name;
        this.description = description;
        this.iconPath = iconPath;
        this.rate = rate;
        this.price = price;
        this.id = id;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getIconPath() {
        return iconPath;
    }

    public int getRate() {
        return rate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void subtractQuantity(int amt) {
        quantity -= amt;
    }

    public int getId() {
        return id;
    }

    public void add(int quantity) {
        this.quantity += quantity;
    }
}
