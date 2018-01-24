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

public class Sunkern extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 191;
    private static final String NAME = "Sunkern";
    private static final int BASE_EXP = 36;
    private static final int[] EV_YIELD = {0, 0, 0, 1, 0, 0};
    private static final int CAPTURE_RATE = 235;
    private static final double WEIGHT = 1.8;

    private static final Ability FIRST_ABILITY = new Ability.Chlorophyll();
    private static final Ability SECOND_ABILITY = new Ability.SolarPower();
    private static final Ability HIDDEN_ABILITY = new Ability.EarlyBird();

    //Base Stats
    private static final int BASE_HEALTH = 30;
    private static final int BASE_ATTACK = 30;
    private static final int BASE_DEFENSE = 30;
    private static final int BASE_SPECIAL_ATTACK = 30;
    private static final int BASE_SPECIAL_DEFENSE = 30;
    private static final int BASE_SPEED = 30;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/sunkern.png";
    private static final String BACK_PATH = "battle/backs/johto/sunkern.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/sunkern.png";
    private static final String CRY_PATH = "sounds/cry/191.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/sunkern.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.GRASS;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a sunkern
     */
    public Sunkern() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init sunkern's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.ABSORB);
        beginnerSkills.add(SkillFactory.GROWTH);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.INGRAIN)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.GRASS_WHISTLE)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEGA_DRAIN)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEECH_SEED)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_LEAF)));
        //TODO WORRY SEED 19
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.GIGA_DRAIN)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.ENDEAVOR)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.SYNTHESIS)));
        //TODO Natural Gift 31
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.SOLAR_BEAM)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUNNY_DAY)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.SEED_BOMB)));
    }

    /**
     * Init sunkern's gender.
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

    @Override
    public int getSunStoneEvolutionId() {
        return PokemonId.SUNFLORA.getValue();
    }
}
