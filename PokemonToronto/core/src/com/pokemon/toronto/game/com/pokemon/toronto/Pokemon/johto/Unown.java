package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-22.
 */

public class Unown extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 201;
    public static final String NAME = "Unown";
    public static final String TYPE_OF_POKEMON = "Symbol";
    public static final String DESCRIPTION = "When alone, nothing happens. However, if there " +
            "are two or more, an odd power is said to emerge.";
    public static final int BASE_EXP = 118;
    public static final int[] EV_YIELD = {0, 1, 0, 1, 0, 0};
    public static final int CAPTURE_RATE = 225;
    public static final double WEIGHT = 5;
    public static final double HEIGHT = 0.5;

    public static final Ability FIRST_ABILITY = new Ability.Levitate();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 48;
    public static final int BASE_ATTACK = 72;
    public static final int BASE_DEFENSE = 48;
    public static final int BASE_SPECIAL_ATTACK = 72;
    public static final int BASE_SPECIAL_DEFENSE = 48;
    public static final int BASE_SPEED = 48;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/johto/unown.png";
    public static final String BACK_PATH = "battle/backs/johto/unown.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/johto/unown.png";
    public static final String CRY_PATH = "sounds/cry/200.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/johto/unown.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.PSYCHIC;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a unown
     */
    public Unown() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init unown's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.HIDDEN_POWER);
        levelUpSkills.put(0, beginnerSkills);
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
    }

    @Override
    protected void initGender() {
        gender = 'X';
    }

}
