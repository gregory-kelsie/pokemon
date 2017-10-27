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

public class Hypno extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 97;
    private static final String NAME = "Hypno";
    private static final int BASE_EXP = 165;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 2, 0};
    private static final int CAPTURE_RATE = 75;

    //Base Stats
    private static final int BASE_HEALTH = 85;
    private static final int BASE_ATTACK = 73;
    private static final int BASE_DEFENSE = 70;
    private static final int BASE_SPECIAL_ATTACK = 73;
    private static final int BASE_SPECIAL_DEFENSE = 115;
    private static final int BASE_SPEED = 67;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/hypno.png";
    private static final String BACK_PATH = "battle/backs/hypno.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/hypno.png";
    private static final String CRY_PATH = "sounds/cry/097.wav";

    /**
     * Create a Hypno with the specified level.
     * @param level The level of the Hypno.
     */
    public Hypno(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.PSYCHIC, Type.NONE, Ability.INSOMNIA, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Hypno from the database.
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
    public Hypno(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                   Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                   Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.PSYCHIC, Type.NONE, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Hypno's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.FUTURE_SIGHT);
        beginnerSkills.add(SkillFactory.NASTY_PLOT);
        beginnerSkills.add(SkillFactory.NIGHTMARE);
        //TODO: SWITCHEROO
        beginnerSkills.add(SkillFactory.POUND);
        beginnerSkills.add(SkillFactory.HYPNOSIS);
        //TODO: DISABLE
        beginnerSkills.add(SkillFactory.CONFUSION);
        levelUpSkills.put(0, beginnerSkills);
        //TODO: DISABLE 5
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONFUSION)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEADBUTT)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_GAS)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEDITATE)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYBEAM)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEADBUTT)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCH_UP)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.SYNCHRONOISE)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.ZEN_HEADBUTT)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWAGGER)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCHIC)));
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.NASTY_PLOT)));
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYSHOCK)));
        levelUpSkills.put(61, new ArrayList<Integer>(Arrays.asList(SkillFactory.FUTURE_SIGHT)));
    }

}
