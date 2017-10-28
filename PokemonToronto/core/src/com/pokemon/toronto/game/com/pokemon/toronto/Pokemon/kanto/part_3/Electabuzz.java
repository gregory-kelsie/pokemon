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

public class Electabuzz extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 125;
    private static final String NAME = "Electabuzz";
    private static final int BASE_EXP = 156;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 2};
    private static final int CAPTURE_RATE = 45;

    //Base Stats
    private static final int BASE_HEALTH = 65;
    private static final int BASE_ATTACK = 83;
    private static final int BASE_DEFENSE = 57;
    private static final int BASE_SPECIAL_ATTACK = 95;
    private static final int BASE_SPECIAL_DEFENSE = 85;
    private static final int BASE_SPEED = 105;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/electabuzz.png";
    private static final String BACK_PATH = "battle/backs/electabuzz.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/electabuzz.png";
    private static final String CRY_PATH = "sounds/cry/125.wav";

    /**
     * Create a Electabuzz with the specified level.
     * @param level The level of the Electabuzz.
     */
    public Electabuzz(int level) {
        super(NUMBER, NAME, level, Type.ELECTRIC, Type.NONE, Ability.STATIC, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Electabuzz from the database.
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
    public Electabuzz(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.ELECTRIC, Type.NONE, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Electabuzz's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.QUICK_ATTACK);
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.THUNDER_SHOCK);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER_SHOCK)));
        //TODO: LOW KICK 8
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWIFT)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHOCK_WAVE)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER_WAVE)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.ELECTRO_BALL)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.LIGHT_SCREEN)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER_PUNCH)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISCHARGE)));
        levelUpSkills.put(42, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCREECH)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDERBOLT)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER)));
    }
}
