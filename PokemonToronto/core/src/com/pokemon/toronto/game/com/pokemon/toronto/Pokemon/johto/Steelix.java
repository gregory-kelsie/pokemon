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

public class Steelix extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 208;
    private static final String NAME = "Steelix";
    private static final int BASE_EXP = 179;
    private static final int[] EV_YIELD = {0, 0, 2, 0, 0, 0};
    private static final int CAPTURE_RATE = 25;
    private static final double WEIGHT = 400;

    private static final Ability FIRST_ABILITY = new Ability.RockHead();
    private static final Ability SECOND_ABILITY = new Ability.Sturdy();
    private static final Ability HIDDEN_ABILITY = new Ability.SheerForce();

    //Base Stats
    private static final int BASE_HEALTH = 75;
    private static final int BASE_ATTACK = 85;
    private static final int BASE_DEFENSE = 200;
    private static final int BASE_SPECIAL_ATTACK = 55;
    private static final int BASE_SPECIAL_DEFENSE = 65;
    private static final int BASE_SPEED = 30;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/steelix.png";
    private static final String BACK_PATH = "battle/backs/johto/steelix.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/steelix.png";
    private static final String CRY_PATH = "sounds/cry/208.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/steelix.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.STEEL;
    private static final Type TYPE_TWO = Type.GROUND;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a steelix
     */
    public Steelix() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init steelix's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.BIND);
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.HARDEN);
        //TODO MUD SPORT
        beginnerSkills.add(SkillFactory.THUNDER_FANG);
        beginnerSkills.add(SkillFactory.ICE_FANG);
        beginnerSkills.add(SkillFactory.FIRE_FANG);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.CURSE)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_THROW)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_TOMB)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAGE)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.STEALTH_ROCK)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.AUTOTOMIZE)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.GYRO_BALL)));
        //TODO: SMACK DOWN 22
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_BREATH)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLAM)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCREECH)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_SLIDE)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.IRON_TAIL)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.DIG)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.STONE_EDGE)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
        levelUpSkills.put(52, new ArrayList<Integer>(Arrays.asList(SkillFactory.SANDSTORM)));
    }

    /**
     * Init steelix's gender.
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
