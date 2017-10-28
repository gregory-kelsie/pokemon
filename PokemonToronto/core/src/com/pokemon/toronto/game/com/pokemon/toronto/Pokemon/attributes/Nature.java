package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes;

/**
 * Created by Gregory on 6/21/2017.
 */

/*
* A Pokemon's Nature type.
 */
public enum Nature {
    /**
    * Hardy Nature (Neutral)
     */
    HARDY(0),

    /**
     * Lonely Nature (+ Atk, - Def)
     */
    LONELY(1),

    /**
     * Brave Nature (+ Atk, - Speed)
     */
    BRAVE(2),

    /**
     * Adamant Nature (+ Atk, - Sp. Atk)
     */
    ADAMANT(3),

    /**
     * Naughty Nature (+ Atk, - Sp. Def)
     */
    NAUGHTY(4),

    /**
     * Bold Nature (+ Def, - Atk)
     */
    BOLD(5),

    /**
     * Docile Nature (Neutral)
     */
    DOCILE(6),

    /**
     * Relaxed Nature (+ Def, - Speed)
     */
    RELAXED(7),

    /**
     * Impish Nature (+ Def, - Sp Atk)
     */
    IMPISH(8),

    /**
     * Lax Nature (+ Def, - Sp Def)
     */
    LAX(9),

    /**
     * Timid Nature (+ Speed, - Atk)
     */
    TIMID(10),

    /**
     * Hasty Nature (+ Speed, - Def)
     */
    HASTY(11),

    /**
     * Serious Nature (Neutral)
     */
    SERIOUS(12),

    /**
     * Jolly Nature (+ Speed, - Sp Atk)
     */
    JOLLY(13),

    /**
     * Naive Nature (+ Speed, - Sp Def)
     */
    NAIVE(14),

    /**
     * Modest Nature (+ Sp Atk, - Atk)
     */
    MODEST(15),

    /**
     * Mild Nature (+ Sp Atk, - Def)
     */
    MILD(16),

    /**
     * Quiet Nature (+ Sp Atk, - Speed)
     */
    QUIET(17),

    /**
     * Bashful Nature (Neutral)
     */
    BASHFUL(18),

    /**
     * Rash Nature (+ Sp Atk, - Sp Def)
     */
    RASH(19),

    /**
     * Calm Nature (+ Sp Def, - Atk)
     */
    CALM(20),

    /**
     * Gentle Nature (+ Sp Def, - Def)
     */
    GENTLE(21),

    /**
     * Sassy Nature (+ Sp Def, - Speed)
     */
    SASSY(22),

    /**
     * Careful Nature (+ Sp Def, - Sp Atk)
     */
    CAREFUL(23),

    /**
     * Quirky Nature (Neutral)
     */
    QUIRKY(24);
    private final int value;
    private Nature(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public static Nature fromInt(int i) {
        for (Nature n : Nature.values()) {
            if (n.getValue() == i) { return n; }
        }
        return null;
    }
}
