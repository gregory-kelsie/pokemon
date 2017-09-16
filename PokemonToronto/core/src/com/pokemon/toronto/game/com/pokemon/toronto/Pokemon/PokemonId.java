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
    METAPOD(11),
    BUTTERFREE(12),
    WEEDLE(13),
    KAKUNA(14),
    BEEDRILL(15),
    PIDGEY(16),
    PIDGEOTTO(17),
    PIDGEOT(18),
    RATTATA(19),
    RATICATE(20),
    SPEAROW(21),
    FEAROW(22),
    EKANS(23),
    ARBOK(24),
    PIKACHU(25),
    RAICHU(26),
    SANDSHREW(27),
    SANDSLASH(28),
    NIDORANF(29),
    NIDORINA(30),
    NIDOQUEEN(31),
    NIDORANM(32),
    NIDORINO(33),
    NIDOKING(34),
    CLEFAIRY(35),
    CLEFABLE(36),
    VULPIX(37),
    NINETALES(38),
    JIGGLYPUFF(39),
    WIGGLYTUFF(40),
    ZUBAT(41),
    GOLBAT(42),
    ODDISH(43),
    GLOOM(44),
    VILEPLUME(45),
    PARAS(46),
    PARASECT(47),
    VENONAT(48),
    VENOMOTH(49),
    DIGLETT(50),
    GEODUDE(74),
    ONIX(95),
    EEVEE(133);
    private final int value;
    private PokemonId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
