package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-22.
 */

public class Smeargle extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 235;
    public static final String NAME = "Smeargle";
    public static final String TYPE_OF_POKEMON = "Painter";
    public static final String DESCRIPTION = "It marks its territory by using its tail like a" +
            " paintbrush. There are more than 5,000 different marks.";
    public static final int BASE_EXP = 88;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 58;
    public static final double HEIGHT = 1.2;

    public static final Ability FIRST_ABILITY = new Ability.OwnTempo();
    public static final Ability SECOND_ABILITY = new Ability.Technician();
    public static final Ability HIDDEN_ABILITY = new Ability.Moody();

    //Base Stats
    public static final int BASE_HEALTH = 55;
    public static final int BASE_ATTACK = 20;
    public static final int BASE_DEFENSE = 35;
    public static final int BASE_SPECIAL_ATTACK = 20;
    public static final int BASE_SPECIAL_DEFENSE = 45;
    public static final int BASE_SPEED = 75;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/johto/smeargle.png";
    public static final String BACK_PATH = "battle/backs/johto/smeargle.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/johto/smeargle.png";
    public static final String CRY_PATH = "sounds/cry/235.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/johto/smeargle.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.FAST;

    /**
     * Create a smeargle
     */
    public Smeargle() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init smeargle's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        //TODO IMPLEMENT SKETCH AND REPLACE TACKLE WITH IT
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        levelUpSkills.put(0, beginnerSkills);
    }

    /**
     * Init smeargle's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .5) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }
}
