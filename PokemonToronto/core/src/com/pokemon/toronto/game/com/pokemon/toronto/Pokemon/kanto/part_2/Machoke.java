package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/16/2017.
 */

public class Machoke extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 67;
    private static final String NAME = "Machoke";
    private static final int BASE_EXP = 146;
    private static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 90;

    //Base Stats
    private static final int BASE_HEALTH = 80;
    private static final int BASE_ATTACK = 100;
    private static final int BASE_DEFENSE = 70;
    private static final int BASE_SPECIAL_ATTACK = 50;
    private static final int BASE_SPECIAL_DEFENSE = 60;
    private static final int BASE_SPEED = 45;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/machoke.png";
    private static final String BACK_PATH = "battle/backs/machoke.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/machoke.png";
    private static final String CRY_PATH = "sounds/cry/067.wav";

    /**
     * Create a Machoke with the specified level.
     * @param level The level of the Machoke.
     */
    public Machoke(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.FIGHTING, Pokemon.Type.NONE, Ability.GUTS, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Machoke from the database.
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
    public Machoke(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                  Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                  Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.FIGHTING, Type.NONE, ability, nature, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Machoke's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //TODO: LOW KICK
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.FOCUS_ENERGY);
        beginnerSkills.add(SkillFactory.KARATE_CHOP);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.FOCUS_ENERGY)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.KARATE_CHOP)));
        //TODO: FORESIGHT 9
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.LOW_SWEEP)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.SEISMIC_TOSS)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.REVENGE)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.KNOCK_OFF)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.VITAL_THROW)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.WAKE_UP_SLAP)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.DUAL_CHOP)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUBMISSION)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.BULK_UP)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.CROSS_CHOP)));
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCARY_FACE)));
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.DYNAMIC_PUNCH)));
    }

    /**
     * Return Machamp if Machoke is 50
     * @return Machamp if Machoke is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 50) {
            return PokemonId.MACHAMP.getValue();
        }
        return -1;
    }
}
