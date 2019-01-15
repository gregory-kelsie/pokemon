package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alola;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;

/**
 * Created by gregorykelsie on 2018-01-30.
 */

public class OricorioSensu extends Oricorio {
    private static final int NUMBER = -7412;
    public static final String DESCRIPTION = "This Oricorio has sipped purple nectar. Its " +
            "elegant, attractive dance will send the minds and hearts of its enemies to another world.";

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/alola/oricorio-sensu.png";
    private static final String BACK_PATH = "battle/backs/alola/oricorio-sensu.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/alola/oricorio-sensu.png";
    private static final String CRY_PATH = "sounds/cry/741-sensu.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/alola/oricorio-sensu.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.GHOST;


    /**
     * Create a oricorio
     */
    public OricorioSensu() {
        super();
        this.typeOne = TYPE_ONE;
        this.mapIconPath = ICON_PATH;
        this.backPath = BACK_PATH;
        this.miniPath = MINI_PATH;
        this.cryPath = CRY_PATH;
        this.profilePath = PROFILE_PATH;
    }
}
