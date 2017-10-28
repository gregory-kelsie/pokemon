package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2;

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

public class Tentacruel extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 73;
    private static final String NAME = "Tentacruel";
    private static final int BASE_EXP = 205;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 2, 0};
    private static final int CAPTURE_RATE = 60;

    //Base Stats
    private static final int BASE_HEALTH = 80;
    private static final int BASE_ATTACK = 70;
    private static final int BASE_DEFENSE = 65;
    private static final int BASE_SPECIAL_ATTACK = 80;
    private static final int BASE_SPECIAL_DEFENSE = 120;
    private static final int BASE_SPEED = 100;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/tentacruel.png";
    private static final String BACK_PATH = "battle/backs/tentacruel.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/tentacruel.png";
    private static final String CRY_PATH = "sounds/cry/073.wav";

    /**
     * Create a Tentacruel with the specified level.
     * @param level The level of the Tentacruel.
     */
    public Tentacruel(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.WATER, Pokemon.Type.POISON, Ability.RAIN_DISH, ExpType.SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Tentacruel from the database.
     * @param level The level of the Pokemon.
     * @param ivs  The array of set IVs
     * @param evs The array of set EVs
     * @param firstSkill The first move.
     * @param secondSkill The second move.
     * @param thirdSkill The third move.
     * @param fourthSkill The fourth move.
     * @param currentHealth The current health of the Pokemon.
     * @param currentExp The current exp of the Pokemon.
     * @param status The Pokemon's status.
     * @param nature The Pokemon's nature.
     * @param ability The Pokemon's ability.
     */
    public Tentacruel(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                     Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                     Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.WATER, Type.POISON, ability, nature, ExpType.SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Tentacruel's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.REFLECT_TYPE);
        beginnerSkills.add(SkillFactory.WRING_OUT);
        beginnerSkills.add(SkillFactory.POISON_STING);
        beginnerSkills.add(SkillFactory.SUPERSONIC);
        beginnerSkills.add(SkillFactory.CONSTRICT);
        beginnerSkills.add(SkillFactory.ACID);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPERSONIC)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONSTRICT)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.ACID)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.TOXIC_SPIKES)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_PULSE)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.WRAP)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.ACID_SPRAY)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUBBLEBEAM)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.BARRIER)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_JAB)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.BRINE)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCREECH)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEX)));
        levelUpSkills.put(48, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLUDGE_WAVE)));
        levelUpSkills.put(52, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYDRO_PUMP)));
        levelUpSkills.put(56, new ArrayList<Integer>(Arrays.asList(SkillFactory.WRING_OUT)));
    }
}
