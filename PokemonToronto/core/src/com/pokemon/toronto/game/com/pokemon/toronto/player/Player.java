package com.pokemon.toronto.game.com.pokemon.toronto.player;

/**
 * Created by Gregory on 8/29/2017.
 */

public class Player {
    private String name;
    private int uid;
    private int money;
    private char gender;
    private int kantoBadges;
    private int johtoBadges;

    public Player(int uid, String name) {
        this.uid = uid;
        this.name = name;
        this.money = 0;
        kantoBadges = 0;
        johtoBadges = 0;
    }
    public Player(int uid, String name, int money, char gender, int kantoBadges, int johtoBadges) {
        this.uid = uid;
        this.name = name;
        this.money = money;
        this.gender = gender;
        this.kantoBadges = kantoBadges;
        this.johtoBadges = johtoBadges;
    }

    public int getKantoBadges() {
        return kantoBadges;
    }

    public int getJohtoBadges() { return johtoBadges; }

    public void addJohtoBadge() {
        johtoBadges++;
        johtoBadges = Math.min(johtoBadges, 8);
    }

    public void addKantoBadge() {
        kantoBadges++;
        kantoBadges = Math.min(kantoBadges, 8);
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
