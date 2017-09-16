package com.pokemon.toronto.game.com.pokemon.toronto.trainer;

/**
 * Created by Gregory on 9/15/2017.
 */

public enum TrainerId {
    YOUNGSTER(0),
    BUG_CATCHER(1),
    LASS(2),
    ACE_TRAINER_MALE(3),
    ACE_TRAINER_FEMALE(4),
    AROMA_LADY(5),
    BATTLE_GIRL(6),
    BEAUTY(7),
    BIKER(8),
    BIRD_KEEPER(9),
    BLACKBELT(10),
    BURGLAR(11),
    CUE_BALL(12),
    DOCTOR(13),
    DRAGON_TAMER(14),
    FIRE_BREATHER(15),
    FISHERMAN(16),
    GAMBLER(17),
    GENTLEMAN(18),
    HIKER(19),
    JANITOR(20),
    JUGGLER(21),
    KIMONO_GIRL(22),
    LADY(23),
    MEDIUM(24),
    NURSE(25),
    PARASOL_LADY(26),
    PICNICKER_MALE(27),
    PICNICKER_FEMALE(28),
    POLICEMAN(29),
    PSYCHIC_MALE(30),
    PSYCHIC_FEMALE(31),
    RANGER_MALE(32),
    RANGER_FEMALE(33),
    RICH_BOY(34),
    RUNE_MANIAC(35),
    SAGE(36),
    SAILOR(37),
    SCHOOL_BOY(38),
    SCHOOL_GIRL(39),
    SCIENTIST(40),
    SOCIALITE(41),
    SWIMMER_MALE(42),
    SWIMMER_FEMALE(43),
    TEACHER(44),
    VETERAN_MALE(45),
    VETERAN_FEMALE(46),
    WAITER(47),
    WAITRESS(48),
    BAKER(49),
    PILOT(50),
    CONDUCTOR(51),
    KARATE_MAN(52);


    private final int value;
    private TrainerId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
