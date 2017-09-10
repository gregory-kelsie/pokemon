package com.pokemon.toronto.game.com.pokemon.toronto.trainer;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;

import java.util.List;

/**
 * Created by Gregory on 9/5/2017.
 */

public class Trainer {
    private String iconPath;
    private String title;
    private String name;
    private List<Pokemon> party;
    private String victoryText;
    private double difficulty;

    public Trainer(double difficulty, String title, String name, String victoryText, String iconPath, List<Pokemon> party) {
        this.difficulty = difficulty;
        this.title = title;
        this.name = name;
        this.victoryText = victoryText;
        this.iconPath = iconPath;
        this.party = party;
    }

    public Trainer(double difficulty, String title, String name, String victoryText, String iconPath) {
        this.difficulty = difficulty;
        this.title = title;
        this.name = name;
        this.victoryText = victoryText;
        this.iconPath = iconPath;
    }

    public String toString() {
        String s = "";
        s += "Name: " + title + " " + name + "\n";
        s += "Party:\n";
        if (party != null) {
            for (int i = 0; i < party.size(); i++) {
                s += "Lv. " + party.get(i).getLevel() + " " + party.get(i).getName() + "\n";
            }
        }
        s += "Victory Text: " + victoryText;
        return s;
    }

    public String getIconPath() {
        return iconPath;
    }


    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public String getVictoryText() {
        return victoryText;
    }

    public void setParty(List<Pokemon> party) {
        this.party = party;
    }

    public List<Pokemon> getParty() {
        return party;
    }
}
