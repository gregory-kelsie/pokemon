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

public class Scyther extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 123;
    private static final String NAME = "Scyther";
    private static final int BASE_EXP = 187;
    private static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 45;

    //Base Stats
    private static final int BASE_HEALTH = 70;
    private static final int BASE_ATTACK = 110;
    private static final int BASE_DEFENSE = 80;
    private static final int BASE_SPECIAL_ATTACK = 55;
    private static final int BASE_SPECIAL_DEFENSE = 80;
    private static final int BASE_SPEED = 105;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/scyther.png";
    private static final String BACK_PATH = "battle/backs/scyther.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/scyther.png";
    private static final String CRY_PATH = "sounds/cry/123.wav";

    /**
     * Create a Scyther with the specified level.
     * @param level The level of the Scyther.
     */
    public Scyther(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.BUG, Type.FLYING, Ability.SWARM, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Scyther from the database.
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
    public Scyther(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                  Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                  Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.BUG, Type.FLYING, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Scyther's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.VACUUM_WAVE);
        beginnerSkills.add(SkillFactory.QUICK_ATTACK);
        beginnerSkills.add(SkillFactory.LEER);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.FOCUS_ENERGY)));
        //TODO: PURSUIT 9
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.FALSE_SWIPE)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.WING_ATTACK)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_CUTTER)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_WIND)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_TEAM)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.X_SCISSOR)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.NIGHT_SLASH)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_HIT)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.AIR_SLASH)));
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWORDS_DANCE)));
        levelUpSkills.put(61, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT)));
    }

}
