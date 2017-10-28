package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 8/16/2017.
 */

public class Raticate extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 20;
    private static final String NAME = "Raticate";
    private static final int BASE_EXP = 116;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 2};
    private static final int CAPTURE_RATE = 127;

    //Base Stats
    private static final int BASE_HEALTH = 55;
    private static final int BASE_ATTACK = 81;
    private static final int BASE_DEFENSE = 60;
    private static final int BASE_SPECIAL_ATTACK = 50;
    private static final int BASE_SPECIAL_DEFENSE = 70;
    private static final int BASE_SPEED = 91;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/raticate.png";
    private static final String BACK_PATH = "battle/backs/raticate.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/raticate.png";
    private static final String CRY_PATH = "sounds/cry/020.wav";

    /**
     * Create a Raticate with the specified level.
     * @param level The level of the Pidgeotto.
     */
    public Raticate(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.NORMAL, Pokemon.Type.NONE, Ability.RUN_AWAY, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Raticate from the database.
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
    public Raticate(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                     Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                     Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Pokemon.Type.NORMAL, Type.NONE, ability, nature, Pokemon.ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }



    /**
     * Init Raticate's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
        beginnerSkills.add(SkillFactory.QUICK_ATTACK);
        beginnerSkills.add(SkillFactory.FOCUS_ENERGY);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.FOCUS_ENERGY)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        //TODO: PURSUIT 13
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_FANG)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.ASSURANCE)));
        levelUpSkills.put(24, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUCKER_PUNCH)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPER_FANG)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.ENDEAVOR)));
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.SCARY_FACE);
    }
}
