package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/16/2017.
 */

public class Dewgong extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 87;
    private static final String NAME = "Dewgong";
    private static final int BASE_EXP = 176;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 2, 0};
    private static final int CAPTURE_RATE = 75;

    //Base Stats
    private static final int BASE_HEALTH = 90;
    private static final int BASE_ATTACK = 70;
    private static final int BASE_DEFENSE = 80;
    private static final int BASE_SPECIAL_ATTACK = 70;
    private static final int BASE_SPECIAL_DEFENSE = 95;
    private static final int BASE_SPEED = 70;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/dewgong.png";
    private static final String BACK_PATH = "battle/backs/dewgong.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/dewgong.png";
    private static final String CRY_PATH = "sounds/cry/087.wav";

    /**
     * Create a Dewgong with the specified level.
     * @param level The level of the Dewgong.
     */
    public Dewgong(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.WATER, Type.ICE, Ability.THICK_FAT, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Dewgong from the database.
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
    public Dewgong(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.WATER, Type.ICE, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Dewgong's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.HEADBUTT);
        beginnerSkills.add(SkillFactory.GROWL);
        beginnerSkills.add(SkillFactory.SIGNAL_BEAM);
        beginnerSkills.add(SkillFactory.ICY_WIND);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWL)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.SIGNAL_BEAM)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICY_WIND)));
        //TODO: ENCORE 13
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICE_SHARD)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.REST)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_RING)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.AURORA_BEAM)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_JET)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.BRINE)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.DIVE)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_TAIL)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICE_BEAM)));
        levelUpSkills.put(61, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAFEGUARD)));
        levelUpSkills.put(65, new ArrayList<Integer>(Arrays.asList(SkillFactory.HAIL)));
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.SHEER_COLD);
    }
}
