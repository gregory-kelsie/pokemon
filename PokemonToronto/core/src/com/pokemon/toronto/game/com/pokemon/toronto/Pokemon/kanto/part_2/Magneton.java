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

public class Magneton extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 82;
    private static final String NAME = "Magneton";
    private static final int BASE_EXP = 161;
    private static final int[] EV_YIELD = {0, 0, 0, 2, 0, 0};
    private static final int CAPTURE_RATE = 60;

    //Base Stats
    private static final int BASE_HEALTH = 50;
    private static final int BASE_ATTACK = 60;
    private static final int BASE_DEFENSE = 95;
    private static final int BASE_SPECIAL_ATTACK = 120;
    private static final int BASE_SPECIAL_DEFENSE = 70;
    private static final int BASE_SPEED = 70;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/magneton.png";
    private static final String BACK_PATH = "battle/backs/magneton.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/magneton.png";
    private static final String CRY_PATH = "sounds/cry/082.wav";

    /**
     * Create a Magneton with the specified level.
     * @param level The level of the Magneton.
     */
    public Magneton(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.ELECTRIC, Type.STEEL, Ability.STURDY, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Magneton from the database.
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
    public Magneton(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                     Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                     Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.ELECTRIC, Type.STEEL, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Magneton's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.ZAP_CANNON);
        //TODO: ELECTRIC TERRAIN
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.SUPERSONIC);
        beginnerSkills.add(SkillFactory.THUNDER_SHOCK);
        beginnerSkills.add(SkillFactory.MAGNET_BOMB);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER_SHOCK)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.MAGNET_BOMB)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER_WAVE)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.LIGHT_SCREEN)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.SONIC_BOOM)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.SPARK)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.MIRROR_SHOT)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.METAL_SOUND)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.ELECTRO_BALL)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLASH_CANNON)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCREECH)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISCHARGE)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.LOCK_ON)));
        //TODO: MAGNET RISE 53
        levelUpSkills.put(59, new ArrayList<Integer>(Arrays.asList(SkillFactory.GYRO_BALL)));
        levelUpSkills.put(63, new ArrayList<Integer>(Arrays.asList(SkillFactory.ZAP_CANNON)));
    }
}
