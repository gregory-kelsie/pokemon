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

public class Furret extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 162;
    private static final String NAME = "Furret";
    private static final int BASE_EXP = 145;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 2};
    private static final int CAPTURE_RATE = 90;
    private static final double WEIGHT = 32.5;

    private static final Ability FIRST_ABILITY = new Ability.RunAway();
    private static final Ability SECOND_ABILITY = new Ability.KeenEye();
    private static final Ability HIDDEN_ABILITY = new Ability.Frisk();

    //Base Stats
    private static final int BASE_HEALTH = 85;
    private static final int BASE_ATTACK = 76;
    private static final int BASE_DEFENSE = 64;
    private static final int BASE_SPECIAL_ATTACK = 45;
    private static final int BASE_SPECIAL_DEFENSE = 55;
    private static final int BASE_SPEED = 90;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/furret.png";
    private static final String BACK_PATH = "battle/backs/johto/furret.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/furret.png";
    private static final String CRY_PATH = "sounds/cry/162.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/furret.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a furret
     */
    public Furret() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init furret's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.COIL);
        beginnerSkills.add(SkillFactory.SCRATCH);
        //todo: foresight
        beginnerSkills.add(SkillFactory.DEFENSE_CURL);
        beginnerSkills.add(SkillFactory.QUICK_ATTACK);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.DEFENSE_CURL)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_SWIPES)));
        //todo helping hand 17
        //todo follow me 21
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLAM)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.REST)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUCKER_PUNCH)));
        levelUpSkills.put(42, new ArrayList<Integer>(Arrays.asList(SkillFactory.AMNESIA)));
        //TODO BATON PASS 46
        //TODO ME FIRST 50
        levelUpSkills.put(56, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_VOICE)));
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.AGILITY);
    }

    /**
     * Init furret's gender.
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
