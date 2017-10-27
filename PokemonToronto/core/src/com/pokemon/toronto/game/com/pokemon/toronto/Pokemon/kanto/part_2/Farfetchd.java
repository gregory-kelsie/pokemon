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

public class Farfetchd extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 83;
    private static final String NAME = "Farfetchd";
    private static final int BASE_EXP = 94;
    private static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 45;

    //Base Stats
    private static final int BASE_HEALTH = 52;
    private static final int BASE_ATTACK = 90;
    private static final int BASE_DEFENSE = 55;
    private static final int BASE_SPECIAL_ATTACK = 58;
    private static final int BASE_SPECIAL_DEFENSE = 62;
    private static final int BASE_SPEED = 60;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/farfetchd.png";
    private static final String BACK_PATH = "battle/backs/farfetchd.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/farfetchd.png";
    private static final String CRY_PATH = "sounds/cry/083.wav";

    /**
     * Create a Farfetchd with the specified level.
     * @param level The level of the Farfetchd.
     */
    public Farfetchd(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.NORMAL, Type.FLYING, Ability.KEEN_EYE, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Farfetchd from the database.
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
    public Farfetchd(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                     Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                     Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.NORMAL, Type.FLYING, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Farfetchd's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.BRAVE_BIRD);
        beginnerSkills.add(SkillFactory.POISON_JAB);
        beginnerSkills.add(SkillFactory.PECK);
        beginnerSkills.add(SkillFactory.SAND_ATTACK);
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.FURY_CUTTER);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_ATTACK)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.AERIAL_ACE)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.KNOCK_OFF)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.AIR_CUTTER)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWORDS_DANCE)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.NIGHT_SLASH)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.ACROBATICS)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.FALSE_SWIPE)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.AIR_SLASH)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.BRAVE_BIRD)));
    }
}
