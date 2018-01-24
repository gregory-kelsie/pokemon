package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-22.
 */

public class Sudowoodo extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 185;
    private static final String NAME = "sudowoodo";
    private static final int BASE_EXP = 144;
    private static final int[] EV_YIELD = {0, 0, 2, 0, 0, 0};
    private static final int CAPTURE_RATE = 65;
    private static final double WEIGHT = 38.0;

    private static final Ability FIRST_ABILITY = new Ability.Sturdy();
    private static final Ability SECOND_ABILITY = new Ability.RockHead();
    private static final Ability HIDDEN_ABILITY = new Ability.Rattled();

    //Base Stats
    private static final int BASE_HEALTH = 70;
    private static final int BASE_ATTACK = 100;
    private static final int BASE_DEFENSE = 115;
    private static final int BASE_SPECIAL_ATTACK = 30;
    private static final int BASE_SPECIAL_DEFENSE = 65;
    private static final int BASE_SPEED = 30;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/sudowoodo.png";
    private static final String BACK_PATH = "battle/backs/johto/sudowoodo.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/sudowoodo.png";
    private static final String CRY_PATH = "sounds/cry/185.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/sudowoodo.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.ROCK;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a sudowoodo
     */
    public Sudowoodo() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init sudowoodo's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SLAM);
        beginnerSkills.add(SkillFactory.LOW_KICK);
        beginnerSkills.add(SkillFactory.ROCK_THROW);
        beginnerSkills.add(SkillFactory.FLAIL);
        //TODO COPYCAT
        beginnerSkills.add(SkillFactory.WOOD_HAMMER);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAIL)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.LOW_KICK)));
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_THROW)));
        //TODO MIMIC 15
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT_ATTACK)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.TEARFUL_LOOK)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_TOMB)));
        //TODO BLOCK 29
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_SLIDE)));
        //TODO COUNTER 36
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUCKER_PUNCH)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.STONE_EDGE)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.HAMMER_ARM)));
        levelUpSkills.put(54, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEAD_SMASH)));
    }

    /**
     * Init sudowoodo's gender.
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
