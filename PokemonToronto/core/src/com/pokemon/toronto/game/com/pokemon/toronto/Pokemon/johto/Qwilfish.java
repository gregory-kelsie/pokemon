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

public class Qwilfish extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 211;
    private static final String NAME = "Qwilfish";
    private static final int BASE_EXP = 86;
    private static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 3.9;

    private static final Ability FIRST_ABILITY = new Ability.PoisonPoint();
    private static final Ability SECOND_ABILITY = new Ability.SwiftSwim();
    private static final Ability HIDDEN_ABILITY = new Ability.Intimidate();

    //Base Stats
    private static final int BASE_HEALTH = 65;
    private static final int BASE_ATTACK = 95;
    private static final int BASE_DEFENSE = 75;
    private static final int BASE_SPECIAL_ATTACK = 55;
    private static final int BASE_SPECIAL_DEFENSE = 55;
    private static final int BASE_SPEED = 85;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/qwilfish.png";
    private static final String BACK_PATH = "battle/backs/johto/qwilfish.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/qwilfish.png";
    private static final String CRY_PATH = "sounds/cry/211.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/qwilfish.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.WATER;
    private static final Type TYPE_TWO = Type.POISON;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a qwilfish
     */
    public Qwilfish() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init qwilfish's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.POISON_STING);
        beginnerSkills.add(SkillFactory.WATER_GUN);
        beginnerSkills.add(SkillFactory.HYDRO_PUMP);
        beginnerSkills.add(SkillFactory.SPIKES);
        //DESTINY BOND
        beginnerSkills.add(SkillFactory.FELL_STINGER);
        levelUpSkills.put(0, beginnerSkills);
        List<Integer> sizeMoves = new ArrayList<Integer>();
        sizeMoves.add(SkillFactory.HARDEN);
        sizeMoves.add(SkillFactory.MINIMIZE);
        levelUpSkills.put(9, sizeMoves);
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUBBLE)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROLLOUT)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.TOXIC_SPIKES)));
        List<Integer> stockpileMoves = new ArrayList<Integer>();
        stockpileMoves.add(SkillFactory.STOCKPILE);
        stockpileMoves.add(SkillFactory.SPIT_UP);
        levelUpSkills.put(25, stockpileMoves);
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.REVENGE)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.BRINE)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.PIN_MISSILE)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_TAIL)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_JAB)));
        //TODO DESTINY BOND 53
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYDRO_PUMP)));
        levelUpSkills.put(60, new ArrayList<Integer>(Arrays.asList(SkillFactory.FELL_STINGER)));
    }

    /**
     * Init qwilfish's gender.
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
