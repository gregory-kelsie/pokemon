package com.pokemon.toronto.game.com.pokemon.toronto.item;

/**
 * Created by Gregory on 11/6/2017.
 */

public enum ItemId {
    POKEBALL(0),
    DUSK_STONE(1),
    FIRE_STONE(2),
    LEAF_STONE(3),
    SHINY_STONE(4),
    SUN_STONE(5),
    THUNDER_STONE(6),
    WATER_STONE(7),
    ANTIDOTE(8),
    AWAKENING(9),
    BURN_HEAL(10),
    ICE_HEAL(11),
    MAX_POTION(12),
    SUPER_POTION(13),
    POTION(14),
    HYPER_POTION(15),
    MOON_STONE(16),
    ICE_STONE(17),
    DAWN_STONE(18),
    HP_UP(19),
    PROTEIN(20),
    CALCIUM(21),
    CARBOS(22),
    ZINC(23),
    IRON(24),
    RARE_CANDY(25),
    NONE(-1);

    private final int value;
    private ItemId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
