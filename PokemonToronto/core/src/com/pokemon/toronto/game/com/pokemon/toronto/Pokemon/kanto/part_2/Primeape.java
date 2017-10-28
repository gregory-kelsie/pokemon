package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/15/2017.
 */

public class Primeape extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 57;
    private static final String NAME = "Primeape";
    private static final int BASE_EXP = 159;
    private static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 75;

    //Base Stats
    private static final int BASE_HEALTH = 65;
    private static final int BASE_ATTACK = 105;
    private static final int BASE_DEFENSE = 60;
    private static final int BASE_SPECIAL_ATTACK = 60;
    private static final int BASE_SPECIAL_DEFENSE = 70;
    private static final int BASE_SPEED = 95;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/primeape.png";
    private static final String BACK_PATH = "battle/backs/primeape.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/primeape.png";
    private static final String CRY_PATH = "sounds/cry/057.wav";

    /**
     * Create a Primeape with the specified level.
     * @param level The level of the Primeape.
     */
    public Primeape(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.FIGHTING, Pokemon.Type.NONE, Ability.DAMP, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Primeape from the database.
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
    public Primeape(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                  Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                  Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.FIGHTING, Type.NONE, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Primeape's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.COVET);
        beginnerSkills.add(SkillFactory.SCRATCH);
        //TODO: LOW KICK
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.FOCUS_ENERGY);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_SWIPES)));
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.KARATE_CHOP)));
        //TODO: PURSUIT: 12
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.SEISMIC_TOSS)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWAGGER)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.CROSS_CHOP)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.ASSURANCE)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.PUNISHMENT)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.THRASH)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.CLOSE_COMBAT)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCREECH)));
        //TODO: STOMPING TANTRUM 48
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.OUTRAGE)));
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.FINAL_GAMBIT)));
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.RAGE);
    }

}
