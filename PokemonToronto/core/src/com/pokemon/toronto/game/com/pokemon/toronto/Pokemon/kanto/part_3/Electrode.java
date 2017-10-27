package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3;

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

public class Electrode extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 101;
    private static final String NAME = "Electrode";
    private static final int BASE_EXP = 150;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 2};
    private static final int CAPTURE_RATE = 60;

    //Base Stats
    private static final int BASE_HEALTH = 60;
    private static final int BASE_ATTACK = 50;
    private static final int BASE_DEFENSE = 70;
    private static final int BASE_SPECIAL_ATTACK = 80;
    private static final int BASE_SPECIAL_DEFENSE = 80;
    private static final int BASE_SPEED = 150;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/electrode.png";
    private static final String BACK_PATH = "battle/backs/electrode.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/electrode.png";
    private static final String CRY_PATH = "sounds/cry/101.wav";

    /**
     * Create a Electrode with the specified level.
     * @param level The level of the Electrode.
     */
    public Electrode(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.ELECTRIC, Type.NONE, Ability.STATIC, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Electrode from the database.
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
    public Electrode(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                   Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                   Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.ELECTRIC, Type.NONE, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Electrode's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.CHARGE);
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.SONIC_BOOM);
        beginnerSkills.add(SkillFactory.EERIE_IMPULSE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.SONIC_BOOM)));
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.EERIE_IMPULSE)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.SPARK)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROLLOUT)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCREECH)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARGE_BEAM)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWIFT)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.ELECTRO_BALL)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.SELF_DESTRUCT)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.LIGHT_SCREEN)));
        //TODO: MAGNET RISE 36
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISCHARGE)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.EXPLOSION)));
        levelUpSkills.put(54, new ArrayList<Integer>(Arrays.asList(SkillFactory.GYRO_BALL)));
        //TODO: MIRROR COAT 58
    }
}
