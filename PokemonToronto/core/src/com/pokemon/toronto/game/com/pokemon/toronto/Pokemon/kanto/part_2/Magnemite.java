package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/16/2017.
 */

public class Magnemite extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 81;
    private static final String NAME = "Magnemite";
    private static final int BASE_EXP = 89;
    private static final int[] EV_YIELD = {0, 0, 0, 1, 0, 0};
    private static final int CAPTURE_RATE = 190;

    //Base Stats
    private static final int BASE_HEALTH = 25;
    private static final int BASE_ATTACK = 30;
    private static final int BASE_DEFENSE = 70;
    private static final int BASE_SPECIAL_ATTACK = 95;
    private static final int BASE_SPECIAL_DEFENSE = 55;
    private static final int BASE_SPEED = 45;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/magnemite.png";
    private static final String BACK_PATH = "battle/backs/magnemite.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/magnemite.png";
    private static final String CRY_PATH = "sounds/cry/081.wav";

    /**
     * Create a Magnemite with the specified level.
     * @param level The level of the Magnemite.
     */
    public Magnemite(int level) {
        super(NUMBER, NAME, level, Type.ELECTRIC, Type.STEEL, Ability.STURDY, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Magnemite from the database.
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
    public Magnemite(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                    Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                    Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.ELECTRIC, Type.STEEL, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Magnemite's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.SUPERSONIC);
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
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLASH_CANNON)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCREECH)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISCHARGE)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.LOCK_ON)));
        //TODO: MAGNET RISE 43
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.GYRO_BALL)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.ZAP_CANNON)));
    }

    /**
     * Return Magneton if Magnemite is 30
     * @return Magneton if Magnemite is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 30) {
            return PokemonId.MAGNETON.getValue();
        }
        return -1;
    }
}
