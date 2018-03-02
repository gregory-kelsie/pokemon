package com.pokemon.toronto.game.com.pokemon.toronto.trainer;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;

import java.util.List;

import static com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer.Badge.JOHTO_BADGE;
import static com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer.Badge.JOHTO_BRUNO;
import static com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer.Badge.JOHTO_CHAMPION;
import static com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer.Badge.JOHTO_KAREN;
import static com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer.Badge.JOHTO_KOGA;
import static com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer.Badge.JOHTO_WILL;
import static com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer.Badge.KANTO_AGATHA;
import static com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer.Badge.KANTO_BADGE;
import static com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer.Badge.KANTO_BRUNO;
import static com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer.Badge.KANTO_CHAMPION;
import static com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer.Badge.KANTO_LANCE;
import static com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer.Badge.KANTO_LORELEI;
import static com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer.Badge.NO_BADGE;

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
    private Badge badgeType;

    public static enum Badge {
        NO_BADGE, KANTO_BADGE, KANTO_LORELEI, KANTO_BRUNO, KANTO_AGATHA, KANTO_LANCE, KANTO_CHAMPION,
        JOHTO_BADGE, JOHTO_WILL, JOHTO_KOGA, JOHTO_BRUNO, JOHTO_KAREN, JOHTO_CHAMPION;
    }

    public Trainer(double difficulty, String title, String name, String victoryText,
                   String iconPath, List<Pokemon> party) {
        init(difficulty, title, name, victoryText, iconPath, party);
        badgeType = NO_BADGE;
    }

    public Trainer(double difficulty, String title, String name, String victoryText,
                   String iconPath, List<Pokemon> party, Badge badgeType) {
        init(difficulty, title, name, victoryText, iconPath, party);
        this.badgeType = badgeType;
    }

    private void init(double difficulty, String title, String name, String victoryText,
                      String iconPath, List<Pokemon> party) {
        this.difficulty = difficulty;
        this.title = title;
        this.name = name;
        this.victoryText = victoryText;
        this.iconPath = iconPath;
        this.party = party;
    }

    public boolean givesKantoBadge() {
        if (badgeType == KANTO_BADGE) {
            return true;
        }
        return false;
    }

    public boolean givesJohtoBadge() {
        if (badgeType == JOHTO_BADGE) {
            return true;
        }
        return false;
    }

    public boolean isElite4Member() {
        if (badgeType == KANTO_LORELEI || badgeType == KANTO_BRUNO ||
                badgeType == KANTO_AGATHA || badgeType == KANTO_CHAMPION ||
                badgeType == KANTO_LANCE || badgeType == JOHTO_WILL || badgeType == JOHTO_KOGA ||
                badgeType == JOHTO_BRUNO || badgeType == JOHTO_KAREN || badgeType == JOHTO_CHAMPION) {
            return true;
        }
        return false;
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

    public Badge getBadgeType() {
        return badgeType;
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
