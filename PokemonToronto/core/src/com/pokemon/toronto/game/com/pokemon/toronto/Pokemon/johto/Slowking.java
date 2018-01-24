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

public class Slowking extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 199;
    private static final String NAME = "Slowking";
    private static final int BASE_EXP = 172;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 3, 0};
    private static final int CAPTURE_RATE = 70;
    private static final double WEIGHT = 79.5;

    private static final Ability FIRST_ABILITY = new Ability.Oblivious();
    private static final Ability SECOND_ABILITY = new Ability.OwnTempo();
    private static final Ability HIDDEN_ABILITY = new Ability.Regenerator();

    //Base Stats
    private static final int BASE_HEALTH = 95;
    private static final int BASE_ATTACK = 75;
    private static final int BASE_DEFENSE = 80;
    private static final int BASE_SPECIAL_ATTACK = 100;
    private static final int BASE_SPECIAL_DEFENSE = 110;
    private static final int BASE_SPEED = 30;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/slowking.png";
    private static final String BACK_PATH = "battle/backs/johto/slowking.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/slowking.png";
    private static final String CRY_PATH = "sounds/cry/199.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/slowking.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.WATER;
    private static final Type TYPE_TWO = Type.PSYCHIC;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a slowking
     */
    public Slowking() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init slowking's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.CURSE);
        beginnerSkills.add(SkillFactory.HIDDEN_POWER);
        beginnerSkills.add(SkillFactory.YAWN);
        beginnerSkills.add(SkillFactory.POWER_GEM);
        //HEAL PULSE
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWL)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_GUN)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONFUSION)));
        //TODO DISABLE 19
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEADBUTT)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_PULSE)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.ZEN_HEADBUTT)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.NASTY_PLOT)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWAGGER)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCHIC)));
        //TODO TRUMP CARD 49
        levelUpSkills.put(54, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCH_UP)));
        //TODO HEAL PULSE 58
    }

    /**
     * Init slowking's gender.
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
