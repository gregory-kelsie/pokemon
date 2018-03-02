package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alola;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;

/**
 * Created by gregorykelsie on 2018-01-30.
 */

public class OricorioPau extends Oricorio {

    private static final int NUMBER = -7411;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/alola/oricorio-pau.png";
    private static final String BACK_PATH = "battle/backs/alola/oricorio-pau.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/alola/oricorio-pau.png";
    private static final String CRY_PATH = "sounds/cry/741-pau.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/alola/oricorio-pau.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.PSYCHIC;


    /**
     * Create a oricorio
     */
    public OricorioPau() {
        super();
        this.typeOne = TYPE_ONE;
        this.mapIconPath = ICON_PATH;
        this.backPath = BACK_PATH;
        this.miniPath = MINI_PATH;
        this.cryPath = CRY_PATH;
        this.profilePath = PROFILE_PATH;
    }
}
