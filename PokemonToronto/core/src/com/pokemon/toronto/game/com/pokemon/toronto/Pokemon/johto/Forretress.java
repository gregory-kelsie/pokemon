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

public class Forretress extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 205;
    private static final String NAME = "Forretress";
    private static final int BASE_EXP = 163;
    private static final int[] EV_YIELD = {0, 0, 2, 0, 0, 0};
    private static final int CAPTURE_RATE = 75;
    private static final double WEIGHT = 125.8;

    private static final Ability FIRST_ABILITY = new Ability.Sturdy();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = new Ability.Overcoat();

    //Base Stats
    private static final int BASE_HEALTH = 75;
    private static final int BASE_ATTACK = 90;
    private static final int BASE_DEFENSE = 140;
    private static final int BASE_SPECIAL_ATTACK = 60;
    private static final int BASE_SPECIAL_DEFENSE = 60;
    private static final int BASE_SPEED = 40;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/forretress.png";
    private static final String BACK_PATH = "battle/backs/johto/forretress.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/forretress.png";
    private static final String CRY_PATH = "sounds/cry/205.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/forretress.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.BUG;
    private static final Type TYPE_TWO = Type.STEEL;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a forretress
     */
    public Forretress() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init forretress's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.SELF_DESTRUCT);
        //PROTECT
        beginnerSkills.add(SkillFactory.ZAP_CANNON);
        beginnerSkills.add(SkillFactory.TOXIC_SPIKES);
        //MAGNET RISE
        beginnerSkills.add(SkillFactory.MIRROR_SHOT);
        beginnerSkills.add(SkillFactory.BUG_BITE);
        beginnerSkills.add(SkillFactory.AUTOTOMIZE);
        beginnerSkills.add(SkillFactory.HEAVY_SLAM);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.SELF_DESTRUCT)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BITE)));
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAPID_SPIN)));
        //TODO BIDE 20
        //TODO NATURAL GIFT 23
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.SPIKES)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.PAYBACK)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.EXPLOSION)));
        levelUpSkills.put(42, new ArrayList<Integer>(Arrays.asList(SkillFactory.IRON_DEFENSE)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.GYRO_BALL)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
        //TODO MAGNET RISE 56
        levelUpSkills.put(60, new ArrayList<Integer>(Arrays.asList(SkillFactory.ZAP_CANNON)));
        levelUpSkills.put(64, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEAVY_SLAM)));
    }

    /**
     * Init forretress's gender.
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
