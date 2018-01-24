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

public class Corsola extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 222;
    private static final String NAME = "Corsola";
    private static final int BASE_EXP = 133;
    private static final int[] EV_YIELD = {0, 0, 1, 0, 1, 0};
    private static final int CAPTURE_RATE = 60;
    private static final double WEIGHT = 5;

    private static final Ability FIRST_ABILITY = new Ability.Hustle();
    private static final Ability SECOND_ABILITY = new Ability.NaturalCure();
    private static final Ability HIDDEN_ABILITY = new Ability.Regenerator();

    //Base Stats
    private static final int BASE_HEALTH = 55;
    private static final int BASE_ATTACK = 55;
    private static final int BASE_DEFENSE = 85;
    private static final int BASE_SPECIAL_ATTACK = 65;
    private static final int BASE_SPECIAL_DEFENSE = 85;
    private static final int BASE_SPEED = 35;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/corsola.png";
    private static final String BACK_PATH = "battle/backs/johto/corsola.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/corsola.png";
    private static final String CRY_PATH = "sounds/cry/222.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/corsola.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.WATER;
    private static final Type TYPE_TWO = Type.ROCK;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.FAST;

    /**
     * Create a corsola
     */
    public Corsola() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init corsola's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.HARDEN);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUBBLE)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.RECOVER)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUBBLEBEAM)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.REFRESH)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.ANCIENT_POWER)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.SPIKE_CANNON)));
        //TODO LUCKY CHANT 23
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.BRINE)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.IRON_DEFENSE)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_BLAST)));
        //TODO ENDURE 35
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_RING)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.POWER_GEM)));
        //TODO MIRROR COAT 45
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.EARTH_POWER)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAIL)));
    }

    /**
     * Init corsola's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .25) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }
}
