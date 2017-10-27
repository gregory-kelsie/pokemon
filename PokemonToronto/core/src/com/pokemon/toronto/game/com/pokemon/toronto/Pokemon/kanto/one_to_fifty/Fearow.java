package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 8/16/2017.
 */

public class Fearow extends Pokemon {

    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 22;
    private static final String NAME = "Fearow";
    private static final int BASE_EXP = 162;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 2};
    private static final int CAPTURE_RATE = 90;

    //Base Stats
    private static final int BASE_HEALTH = 60;
    private static final int BASE_ATTACK = 90;
    private static final int BASE_DEFENSE = 65;
    private static final int BASE_SPECIAL_ATTACK = 61;
    private static final int BASE_SPECIAL_DEFENSE = 61;
    private static final int BASE_SPEED = 100;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/fearow.png";
    private static final String BACK_PATH = "battle/backs/fearow.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/fearow.png";
    private static final String CRY_PATH = "sounds/cry/022.wav";

    /**
     * Create a Fearow with the specified level.
     * @param level The level of the Fearow.
     */
    public Fearow(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.NORMAL, Pokemon.Type.FLYING, Ability.KEEN_EYE, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Fearow from the database.
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
    public Fearow(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                   Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                   Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Pokemon.Type.NORMAL, Pokemon.Type.FLYING, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Fearow's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.DRILL_RUN);
        beginnerSkills.add(SkillFactory.PLUCK);
        beginnerSkills.add(SkillFactory.PECK);
        beginnerSkills.add(SkillFactory.GROWL);
        beginnerSkills.add(SkillFactory.LEER);
        //TODO: PURSUIT BEGINNER SKILL
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEER)));
        //TODO: PURSUIT 8
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_ATTACK)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.AERIAL_ACE)));
        //TODO: MIRROR MOVE 18
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.ASSURANCE)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.FOCUS_ENERGY)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROOST)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRILL_PECK)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRILL_RUN)));
    }
}
