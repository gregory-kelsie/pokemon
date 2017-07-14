package com.pokemon.toronto.game.com.pokemon.toronto.Ball;

/**
 * Created by Gregory on 6/17/2017.
 */
public class Pokeball extends Ball {
    public Pokeball() {
        super(Ball.POKEBALL, "Pokeball", "A device for catching wild Pokémon. " +
                "\nIt’s thrown like a ball at a Pokémon,\ncomfortably encapsulating" +
                " its target.", "bag/icons/pokeball.png", 1, 200, 1);
    }

    public Pokeball(int quantity) {
        super(Ball.POKEBALL, "Pokeball", "A device for catching wild Pokémon. " +
                "\nIt’s thrown like a ball at a Pokémon,\ncomfortably encapsulating" +
                " its target.","bag/icons/pokeball.png", 1, 200, quantity);
    }

}
