package com.pokemon.toronto.game.com.pokemon.toronto.player;

/**
 * Created by Gregory on 8/29/2017.
 */

public class Player {
    private String name;
    private int uid;
    private int money;
    private char gender;

    public Player(int uid, String name) {
        this.uid = uid;
        this.name = name;
        this.money = 0;
    }
    public Player(int uid, String name, int money, char gender) {
        this.uid = uid;
        this.name = name;
        this.money = money;
        this.gender = gender;
    }

    public int getId() {
        return uid;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int amount) {
        this.money += amount;
    }

    public void subtractMoney(int amount) {
        money -= amount;
        money = Math.max(0, money);
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
