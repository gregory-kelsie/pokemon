package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alola;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-30.
 */

public class OricorioPomPom extends Oricorio {
    /** Init Variables */

    private static final int NUMBER = -741;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/alola/oricorio-pom.png";
    private static final String BACK_PATH = "battle/backs/alola/oricorio-pom.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/alola/oricorio-pom.png";
    private static final String CRY_PATH = "sounds/cry/741-pom.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/alola/oricorio-pom.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.ELECTRIC;


    /**
     * Create a oricorio
     */
    public OricorioPomPom() {
        super();
        this.typeOne = TYPE_ONE;
        this.mapIconPath = ICON_PATH;
        this.backPath = BACK_PATH;
        this.miniPath = MINI_PATH;
        this.cryPath = CRY_PATH;
        this.profilePath = PROFILE_PATH;
    }


}
