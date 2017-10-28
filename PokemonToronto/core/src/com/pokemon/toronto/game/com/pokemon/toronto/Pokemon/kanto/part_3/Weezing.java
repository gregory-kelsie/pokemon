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

public class Weezing extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 110;
    private static final String NAME = "Weezing";
    private static final int BASE_EXP = 173;
    private static final int[] EV_YIELD = {0, 0, 2, 0, 0, 0};
    private static final int CAPTURE_RATE = 60;

    //Base Stats
    private static final int BASE_HEALTH = 65;
    private static final int BASE_ATTACK = 90;
    private static final int BASE_DEFENSE = 120;
    private static final int BASE_SPECIAL_ATTACK = 85;
    private static final int BASE_SPECIAL_DEFENSE = 70;
    private static final int BASE_SPEED = 60;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/weezing.png";
    private static final String BACK_PATH = "battle/backs/weezing.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/weezing.png";
    private static final String CRY_PATH = "sounds/cry/110.wav";

    /**
     * Create a Weezing with the specified level.
     * @param level The level of the Weezing.
     */
    public Weezing(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.POISON, Type.NONE, Ability.LEVITATE, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Weezing from the database.
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
    public Weezing(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                   Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                   Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.POISON, Type.NONE, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Weezing's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.POISON_GAS);
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.SMOG);
        beginnerSkills.add(SkillFactory.SMOKESCREEN);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.SMOG)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.SMOKESCREEN)));
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.ASSURANCE)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.CLEAR_SMOG)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLUDGE)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.SELF_DESTRUCT)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.HAZE)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.GYRO_BALL)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLUDGE_BOMB)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.EXPLOSION)));
        //TODO: DESTINY BOND 46
        //TODO: BELCH 51
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEMENTO)));
        initEvolutionSkills();
    }


    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.DOUBLE_HIT);
    }
    
}
