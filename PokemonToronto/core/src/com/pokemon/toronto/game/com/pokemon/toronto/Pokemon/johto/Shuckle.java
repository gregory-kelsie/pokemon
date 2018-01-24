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

public class Shuckle extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 213;
    private static final String NAME = "Shuckle";
    private static final int BASE_EXP = 177;
    private static final int[] EV_YIELD = {0, 0, 1, 0, 1, 0};
    private static final int CAPTURE_RATE = 190;
    private static final double WEIGHT = 20.5;

    private static final Ability FIRST_ABILITY = new Ability.Sturdy();
    private static final Ability SECOND_ABILITY = new Ability.Gluttony();
    private static final Ability HIDDEN_ABILITY = new Ability.Contrary();

    //Base Stats
    private static final int BASE_HEALTH = 20;
    private static final int BASE_ATTACK = 10;
    private static final int BASE_DEFENSE = 230;
    private static final int BASE_SPECIAL_ATTACK = 10;
    private static final int BASE_SPECIAL_DEFENSE = 230;
    private static final int BASE_SPEED = 5;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/shuckle.png";
    private static final String BACK_PATH = "battle/backs/johto/shuckle.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/shuckle.png";
    private static final String CRY_PATH = "sounds/cry/213.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/shuckle.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.BUG;
    private static final Type TYPE_TWO = Type.ROCK;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a shuckle
     */
    public Shuckle() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init shuckle's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.WITHDRAW);
        //BIDE
        beginnerSkills.add(SkillFactory.CONSTRICT);
        beginnerSkills.add(SkillFactory.ROLLOUT);
        beginnerSkills.add(SkillFactory.STICKY_WEB);
        levelUpSkills.put(0, beginnerSkills);
        //TODO ENCORE 5
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.WRAP)));
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.STRUGGLE_BUG)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAFEGUARD)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.REST)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_THROW)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.GASTRO_ACID)));
        //TODO POWER TRICK 31
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHELL_SMASH)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_SLIDE)));
        levelUpSkills.put(42, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BITE)));
        //TODO GUARD SPLIT AND POWER SPLIT 45
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.STONE_EDGE)));
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.STICKY_WEB)));
    }

    /**
     * Init shuckle's gender.
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
