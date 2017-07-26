package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

/**
 * Created by Gregory on 7/25/2017.
 */

public enum PokemonId {
    BULBASAUR(1),
    IVYSAUR(2),
    VENUSAUR(3),
    CHARMANDER(4),
    CHARMELEON(5),
    CHARIZARD(6),
    SQUIRTLE(7),
    WARTORTLE(8),
    BLASTOISE(9),
    CATERPIE(10),
    WEEDLE(13),
    PIDGEY(16),
    RATTATA(19),
    PIKACHU(25),
    NIDORANF(29),
    NIDORANM(32),
    EEVEE(133);
    private final int value;
    private PokemonId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
