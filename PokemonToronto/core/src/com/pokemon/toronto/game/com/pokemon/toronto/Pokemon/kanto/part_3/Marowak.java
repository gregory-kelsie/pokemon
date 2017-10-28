package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3;

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

public class Marowak extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 105;
    private static final String NAME = "Marowak";
    private static final int BASE_EXP = 124;
    private static final int[] EV_YIELD = {0, 0, 2, 0, 0, 0};
    private static final int CAPTURE_RATE = 75;

    //Base Stats
    private static final int BASE_HEALTH = 60;
    private static final int BASE_ATTACK = 80;
    private static final int BASE_DEFENSE = 110;
    private static final int BASE_SPECIAL_ATTACK = 50;
    private static final int BASE_SPECIAL_DEFENSE = 80;
    private static final int BASE_SPEED = 45;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/marowak.png";
    private static final String BACK_PATH = "battle/backs/marowak.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/marowak.png";
    private static final String CRY_PATH = "sounds/cry/105.wav";

    /**
     * Create a Marowak with the specified level.
     * @param level The level of the Marowak.
     */
    public Marowak(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.GROUND, Type.NONE, Ability.ROCK_HEAD, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Marowak from the database.
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
    public Marowak(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                  Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                  Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.GROUND, Type.NONE, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Marowak's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.GROWL);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAIL_WHIP)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.BONE_CLUB)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEADBUTT)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEER)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.FOCUS_ENERGY)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.BONEMERANG)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAGE)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.FALSE_SWIPE)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.THRASH)));
        //TODO: FLING 37
        //TODO: STOMPING TANTRUM 43
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.ENDEAVOR)));
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
        //TODO: RETALIATE 59
        levelUpSkills.put(65, new ArrayList<Integer>(Arrays.asList(SkillFactory.BONE_RUSH)));
    }
    
}
