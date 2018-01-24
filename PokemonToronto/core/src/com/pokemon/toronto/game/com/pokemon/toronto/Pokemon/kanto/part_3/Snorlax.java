package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/21/2017.
 */

public class Snorlax extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 143;
    private static final String NAME = "Snorlax";
    private static final int BASE_EXP = 154;
    private static final int[] EV_YIELD = {2, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 25;
    private static final double WEIGHT = 460;

    private static final Ability FIRST_ABILITY = new Ability.Immunity();
    private static final Ability SECOND_ABILITY = new Ability.ThickFat();
    private static final Ability HIDDEN_ABILITY = new Ability.Gluttony();

    //Base Stats
    private static final int BASE_HEALTH = 160;
    private static final int BASE_ATTACK = 110;
    private static final int BASE_DEFENSE = 65;
    private static final int BASE_SPECIAL_ATTACK = 65;
    private static final int BASE_SPECIAL_DEFENSE = 110;
    private static final int BASE_SPEED = 30;

    //Typing
    private static final Type TYPE_ONE = Type.NORMAL;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.SLOW;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/snorlax.png";
    private static final String BACK_PATH = "battle/backs/snorlax.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/snorlax.png";
    private static final String CRY_PATH = "sounds/cry/143.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/143.png";

    /**
     * Create a Snorlax
     */
    public Snorlax() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .875) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

    /**
     * Init Snorlax's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.DEFENSE_CURL)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.AMNESIA)));
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.LICK)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHIP_AWAY)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.YAWN)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.BODY_SLAM)));
        List<Integer> sleepMoves = new ArrayList<Integer>();
        sleepMoves.add(SkillFactory.REST);
        sleepMoves.add(SkillFactory.SNORE);
        levelUpSkills.put(28, sleepMoves);
        //TODO: SLEEP TALK 33
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.GIGA_IMPACT)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROLLOUT)));
        //TODO: BLOCK 41
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.BELLY_DRUM)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEAVY_SLAM)));
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.HIGH_HORSEPOWER)));
    }
}
