package com.pokemon.toronto.game.com.pokemon.toronto.textbox;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/5/2017.
 */
public class TextBoxFactory {

    /**
     * Return the text box where Professor Ivy asks the user for their gender.
     * @return The text box where Professor Ivy asks for the user's gender.
     */
    public static TextBoxText getGenderText() {
        BitmapFont header = new BitmapFont(Gdx.files.internal("font/textHeaderFont.fnt"));
        BitmapFont body = new BitmapFont(Gdx.files.internal("font/textBoxNarrowFont.fnt"));
        TextBoxText tbt = new TextBoxText(header, body);
        tbt.setHeader("Professor Ivy");
        tbt.addLine("Are you a boy or a girl?");
        return tbt;
    }

    /**
     * Return the text box where Professor Ivy tells the user to select a started Pokeball.
     * @return The text box where Professor Ivy tells the user to select a Pokeball.
     */
    public static TextBoxText getPokeballSelectText() {
        BitmapFont header = new BitmapFont(Gdx.files.internal("font/textHeaderFont.fnt"));
        BitmapFont body = new BitmapFont(Gdx.files.internal("font/textBoxNarrowFont.fnt"));
        TextBoxText tbt = new TextBoxText(header, body);
        tbt.setHeader("Professor Ivy");
        tbt.addLine("Select a Pokeball");
        return tbt;
    }

    /**
     * Return the text boxes talking about Bulbasaur's information.
     * @return Bulbasaur information text boxes.
     */
    public static List<TextBoxText> getStarterBulbasaurText() {
        BitmapFont header = new BitmapFont(Gdx.files.internal("font/textHeaderFont.fnt"));
        BitmapFont body = new BitmapFont(Gdx.files.internal("font/textBoxNarrowFont.fnt"));
        ArrayList<TextBoxText> tbts = new ArrayList<TextBoxText>();
        TextBoxText tbt = new TextBoxText(header, body);
        tbt.setHeader("PokeNav");
        tbt.addLine("Bulbasaur, the seed Pokemon.");
        tbt.addLine("Bulbasaur is a grass and poison type");
        tbt.addLine("Pokemon that evolves into the mighty");
        tbt.addLine("Venusaur.");

        TextBoxText tbt2 = new TextBoxText(header, body);
        tbt2.setHeader("PokeNav");
        tbt2.addLine("Do you want Bulbasaur?");

        tbts.add(tbt);
        tbts.add(tbt2);
        return tbts;
    }

    /**
     * Return the text boxes talking about Charmander's information.
     * @return Charmander information text boxes.
     */
    public static List<TextBoxText> getStarterCharmanderText() {
        BitmapFont header = new BitmapFont(Gdx.files.internal("font/textHeaderFont.fnt"));
        BitmapFont body = new BitmapFont(Gdx.files.internal("font/textBoxNarrowFont.fnt"));
        ArrayList<TextBoxText> tbts = new ArrayList<TextBoxText>();
        TextBoxText tbt = new TextBoxText(header, body);
        tbt.setHeader("PokeNav");
        tbt.addLine("Charmander, the lizard Pokemon.");
        tbt.addLine("Charmander is a fire type Pokemon");
        tbt.addLine("that evolves into the legendary");
        tbt.addLine("Charizard.");

        TextBoxText tbt2 = new TextBoxText(header, body);
        tbt2.setHeader("PokeNav");
        tbt2.addLine("Do you want Charmander?");

        tbts.add(tbt);
        tbts.add(tbt2);
        return tbts;
    }

    /**
     * Return the text boxes talking about Squirtle's information.
     * @return Squirtle's information text boxes.
     */
    public static List<TextBoxText> getStarterSquirtleText() {
        BitmapFont header = new BitmapFont(Gdx.files.internal("font/textHeaderFont.fnt"));
        BitmapFont body = new BitmapFont(Gdx.files.internal("font/textBoxNarrowFont.fnt"));
        ArrayList<TextBoxText> tbts = new ArrayList<TextBoxText>();
        TextBoxText tbt = new TextBoxText(header, body);
        tbt.setHeader("PokeNav");
        tbt.addLine("Squirtle, the tiny turtle Pokemon.");
        tbt.addLine("Squirtle is a water type Pokemon that");
        tbt.addLine("evolves into the shellfish Pokemon");
        tbt.addLine("Blastoise.");

        TextBoxText tbt2 = new TextBoxText(header, body);
        tbt2.setHeader("PokeNav");
        tbt2.addLine("Do you want Squirtle?");

        tbts.add(tbt);
        tbts.add(tbt2);

        return tbts;
    }

    /**
     * Return the text box after the player chooses a starter.
     * @return The response text box to choosing a starter.
     */
    public static TextBoxText getCongratsText() {
        BitmapFont header = new BitmapFont(Gdx.files.internal("font/textHeaderFont.fnt"));
        BitmapFont body = new BitmapFont(Gdx.files.internal("font/textBoxNarrowFont.fnt"));
        TextBoxText tbt = new TextBoxText(header, body);
        tbt.setHeader("Professor Ivy");
        tbt.addLine("Congratulations on your first Pokemon!");
        tbt.addLine("Now that you have a partner, you are ");
        tbt.addLine("ready to begin your journey. I gave you");
        tbt.addLine("10 Pokeballs to start with. Be safe and");
        tbt.addLine("best of luck catching them all!");
        return tbt;
    }

    /**
     * Return the text box after you've chosen your gender.
     * @return The text box after choosing a gender.
     */
    public static TextBoxText getGenderResponseText() {
        BitmapFont header = new BitmapFont(Gdx.files.internal("font/textHeaderFont.fnt"));
        BitmapFont body = new BitmapFont(Gdx.files.internal("font/textBoxNarrowFont.fnt"));
        TextBoxText tbt = new TextBoxText(header, body);
        tbt.setHeader("Professor Ivy");
        tbt.addLine("That's great! I just didn't want to");
        tbt.addLine("assume your gender if you know what");
        tbt.addLine("I mean. Now, let's move onto selecting");
        tbt.addLine("your starter Pokemon.");
        return tbt;
    }

    /**
     * Return the double checking text box to ensure that the player
     * chose male for sure.
     * @return The text box reassuring the player that they've chosen male.
     */
    public static TextBoxText getMaleResponseText() {
        BitmapFont header = new BitmapFont(Gdx.files.internal("font/textHeaderFont.fnt"));
        BitmapFont body = new BitmapFont(Gdx.files.internal("font/textBoxNarrowFont.fnt"));
        TextBoxText tbt = new TextBoxText(header, body);
        tbt.setHeader("Professor Ivy");
        tbt.addLine("So you are a boy then?");
        return tbt;
    }

    /**
     * Return the double checking text box to ensure that the player
     * chose female for sure.
     * @return The text box reassuring the player that they've chosen female.
     */
    public static TextBoxText getFemaleResponseText() {
        BitmapFont header = new BitmapFont(Gdx.files.internal("font/textHeaderFont.fnt"));
        BitmapFont body = new BitmapFont(Gdx.files.internal("font/textBoxNarrowFont.fnt"));
        TextBoxText tbt = new TextBoxText(header, body);
        tbt.setHeader("Professor Ivy");
        tbt.addLine("So you are a girl then?");
        return tbt;
    }

    /**
     * Return the Pokemon Center text box list.
     * @param blackedOut An identifier to show whether or not the player got to
     *                   the Pokecenter by blacking out or through the menu.
     * @return The Pokemon Center text box list.
     */
    public static List<TextBoxText> getPokeCenterText(boolean blackedOut) {
        BitmapFont header = new BitmapFont(Gdx.files.internal("font/textHeaderFont.fnt"));
        BitmapFont body = new BitmapFont(Gdx.files.internal("font/textBoxNarrowFont.fnt"));
        ArrayList<TextBoxText> tbts = new ArrayList<TextBoxText>();

        TextBoxText tbt = new TextBoxText(header, body);
        tbt.setHeader("Nurse Joy");
        if (blackedOut) {
            tbt.addLine("You blacked out! Please be more");
            tbt.addLine("careful next time.");
        } else {
            tbt.addLine("Welcome to the portable PokeCenter.");
            tbt.addLine("For free, I can heal your Pokemon");
            tbt.addLine("to full health, remove any negative");
            tbt.addLine("status and recover skill PP.");
        }

        TextBoxText tbt2 = new TextBoxText(header, body);
        tbt2.setHeader("Nurse Joy");
        tbt2.addLine("Give me a moment and I will heal");
        tbt2.addLine("your Pokemon.");

        TextBoxText tbt3 = new TextBoxText(header, body);
        tbt3.setHeader("Nurse Joy");
        tbt3.addLine("..........................................");

        TextBoxText tbt4 = new TextBoxText(header, body);
        tbt4.setHeader("Nurse Joy");
        tbt4.addLine("Thank you for waiting.");
        tbt4.addLine("Your Pokemon are fully healed.");
        tbt4.addLine("I hope to see you again.");

        tbts.add(tbt);
        tbts.add(tbt2);
        tbts.add(tbt3);
        tbts.add(tbt4);

        return tbts;
    }

    /**
     * Return the first text boxes Professor Ivy says explaining the game.
     * Ends when she is about to ask for your gender.
     * @return The first set of text boxes from Professor Ivy.
     */
    public static List<TextBoxText> getFirstBox() {
        BitmapFont header = new BitmapFont(Gdx.files.internal("font/textHeaderFont.fnt"));
        BitmapFont body = new BitmapFont(Gdx.files.internal("font/textBoxNarrowFont.fnt"));
        ArrayList<TextBoxText> tbts = new ArrayList<TextBoxText>();
        TextBoxText tbt = new TextBoxText(header, body);
        tbt.setHeader("Professor Ivy");
        tbt.addLine("Welcome to the world of Pokemon.");
        tbt.addLine("My name is Professor Ivy. I am");
        tbt.addLine("originally from the Orange Islands");
        tbt.addLine("south of the Kanto Region.");

        TextBoxText tbt2 = new TextBoxText(header, body);
        tbt2.setHeader("Professor Ivy");
        tbt2.addLine("I was recently transferred to Toronto");
        tbt2.addLine("because of a sudden influx of wild");
        tbt2.addLine("Pokemon. I will help you begin your");
        tbt2.addLine("journey as a brand new Pokemon");
        tbt2.addLine("Trainer.");

        TextBoxText tbt3 = new TextBoxText(header, body);
        tbt3.setHeader("Professor Ivy");
        tbt3.addLine("I've already installed the PokeNav on");
        tbt3.addLine("your mobile device. The PokeNav will be");
        tbt3.addLine("your primary hub on your adventure. On");
        tbt3.addLine("the PokeNav, you can do basic functions");
        tbt3.addLine("such as checking your PokeDex and");
        tbt3.addLine("your Party's stats.");

        TextBoxText tbt4 = new TextBoxText(header, body);
        tbt4.setHeader("Professor Ivy");
        tbt4.addLine("The PokeNav has a variety of additional");
        tbt4.addLine("features. Some of which include:");
        tbt4.addLine("- Pokemon Storage System.");
        tbt4.addLine("- Friend Lists, Instant Messaging");
        tbt4.addLine("- Online Trading and Battling");
        tbt4.addLine("- PokeCenter and PokeMart Access");

        TextBoxText tbt5 = new TextBoxText(header, body);
        tbt5.setHeader("Professor Ivy");
        tbt5.addLine("The PokeNav can also help discover");
        tbt5.addLine("new Pokemon. It will notify you by");
        tbt5.addLine("buzzing your mobile device when a");
        tbt5.addLine("wild Pokemon is nearby.");


        TextBoxText tbt55 = new TextBoxText(header, body);
        tbt55.setHeader("Professor Ivy");
        tbt55.addLine("On the map, you will see the");
        tbt55.addLine("approximate location of the wild");
        tbt55.addLine("Pokemon. When you approach the area,");
        tbt55.addLine("can battle or even catching it!");

        TextBoxText tbt6 = new TextBoxText(header, body);
        tbt6.setHeader("Professor Ivy");
        tbt6.addLine("If you're lucky, you will see an icon next");
        tbt6.addLine("to the wild Pokemon on the map. This");
        tbt6.addLine("means that there is a high chance the");
        tbt6.addLine("Pokemon will have a hidden nature, egg");
        tbt6.addLine("moves or even be shiny!");

        TextBoxText tbt66 = new TextBoxText(header, body);
        tbt66.setHeader("Professor Ivy");
        tbt66.addLine("After some time, the wild Pokemon");
        tbt66.addLine("will leave the area. So choose which");
        tbt66.addLine("Pokemon to track down wisely.");

        TextBoxText tbt7 = new TextBoxText(header, body);
        tbt7.setHeader("Professor Ivy");
        tbt7.addLine("Lastly, because wild Pokemon are still");
        tbt7.addLine("sparce, it can get difficult to train");
        tbt7.addLine("your party. The PokeNav makes up for");
        tbt7.addLine("this because it can simulate battles!");
        tbt7.addLine("You can simulate wild battles and even");
        tbt7.addLine("trainer battles.");

        TextBoxText tbt8 = new TextBoxText(header, body);
        tbt8.setHeader("Professor Ivy");
        tbt8.addLine("That about does it for the PokeNav. Now I");
        tbt8.addLine("have to ask you a quick question before");
        tbt8.addLine("I create your trainer card and give you");
        tbt8.addLine("your first Pokemon.");

        tbts.add(tbt);
        tbts.add(tbt2);
        tbts.add(tbt3);
        tbts.add(tbt4);
        tbts.add(tbt5);
        tbts.add(tbt55);
        tbts.add(tbt6);
        tbts.add(tbt66);
        tbts.add(tbt7);
        tbts.add(tbt8);

        return tbts;
    }
}
