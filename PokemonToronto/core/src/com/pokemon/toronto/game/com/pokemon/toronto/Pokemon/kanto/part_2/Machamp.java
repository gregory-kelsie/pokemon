package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/16/2017.
 */

public class Machamp extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 68;
    private static final String NAME = "Machamp";
    private static final int BASE_EXP = 193;
    private static final int[] EV_YIELD = {0, 3, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 130;

    private static final Ability FIRST_ABILITY = new Ability.Guts();
    private static final Ability SECOND_ABILITY = new Ability.NoGuard();
    private static final Ability HIDDEN_ABILITY = new Ability.Steadfast();

    //Base Stats
    private static final int BASE_HEALTH = 90;
    private static final int BASE_ATTACK = 130;
    private static final int BASE_DEFENSE = 80;
    private static final int BASE_SPECIAL_ATTACK = 65;
    private static final int BASE_SPECIAL_DEFENSE = 85;
    private static final int BASE_SPEED = 55;

    //Typing
    private static final Type TYPE_ONE = Type.FIGHTING;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/machamp.png";
    private static final String BACK_PATH = "battle/backs/machamp.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/machamp.png";
    private static final String CRY_PATH = "sounds/cry/068.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/068.png";

    /**
     * Create a Machamp
     */
    public Machamp() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .75) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

    /**
     * Init Machamp's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //TODO: WIDE GUARD
        beginnerSkills.add(SkillFactory.LOW_KICK);
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.FOCUS_ENERGY);
        beginnerSkills.add(SkillFactory.KARATE_CHOP);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.FOCUS_ENERGY)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.KARATE_CHOP)));
        //TODO: FORESIGHT 9
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.LOW_SWEEP)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.SEISMIC_TOSS)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.REVENGE)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.KNOCK_OFF)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.VITAL_THROW)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.WAKE_UP_SLAP)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.DUAL_CHOP)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUBMISSION)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.BULK_UP)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.CROSS_CHOP)));
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCARY_FACE)));
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.DYNAMIC_PUNCH)));
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.STRENGTH);
    }
}
