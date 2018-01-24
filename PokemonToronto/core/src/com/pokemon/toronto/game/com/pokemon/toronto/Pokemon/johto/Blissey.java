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

public class Blissey extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 242;
    private static final String NAME = "Blissey";
    private static final int BASE_EXP = 608;
    private static final int[] EV_YIELD = {3, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 30;
    private static final double WEIGHT = 46.8;

    private static final Ability FIRST_ABILITY = new Ability.NaturalCure();
    private static final Ability SECOND_ABILITY = new Ability.SereneGrace();
    private static final Ability HIDDEN_ABILITY = new Ability.Healer();

    //Base Stats
    private static final int BASE_HEALTH = 255;
    private static final int BASE_ATTACK = 10;
    private static final int BASE_DEFENSE = 10;
    private static final int BASE_SPECIAL_ATTACK = 75;
    private static final int BASE_SPECIAL_DEFENSE = 135;
    private static final int BASE_SPEED = 55;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/blissey.png";
    private static final String BACK_PATH = "battle/backs/johto/blissey.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/blissey.png";
    private static final String CRY_PATH = "sounds/cry/242.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/blissey.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.FAST;

    /**
     * Create a blissey
     */
    public Blissey() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init blissey's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.POUND);
        beginnerSkills.add(SkillFactory.DOUBLE_EDGE);
        beginnerSkills.add(SkillFactory.GROWL);
        beginnerSkills.add(SkillFactory.DEFENSE_CURL);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAIL_WHIP)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.REFRESH)));
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_SLAP)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.SOFT_BOILED)));
        //TODO BESTOW 20
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.MINIMIZE)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.SING)));
        //TODO FLING 34
        //TODO HEAL PULSE 38
        levelUpSkills.put(42, new ArrayList<Integer>(Arrays.asList(SkillFactory.EGG_BOMB)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.LIGHT_SCREEN)));
        //TODO HEALING WISH 50
        levelUpSkills.put(54, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
    }

    /**
     * Init blissey's gender.
     */
    @Override
    protected void initGender() {
        gender = 'F';
    }
}
