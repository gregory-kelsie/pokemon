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

public class Machop extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 66;
    private static final String NAME = "Machop";
    private static final int BASE_EXP = 75;
    private static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 180;

    //Base Stats
    private static final int BASE_HEALTH = 70;
    private static final int BASE_ATTACK = 80;
    private static final int BASE_DEFENSE = 50;
    private static final int BASE_SPECIAL_ATTACK = 35;
    private static final int BASE_SPECIAL_DEFENSE = 35;
    private static final int BASE_SPEED = 35;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/machop.png";
    private static final String BACK_PATH = "battle/backs/machop.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/machop.png";
    private static final String CRY_PATH = "sounds/cry/066.wav";

    /**
     * Create a Machop with the specified level.
     * @param level The level of the Machop.
     */
    public Machop(int level) {
        super(NUMBER, NAME, level, Type.FIGHTING, Pokemon.Type.NONE, Ability.GUTS, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Machop from the database.
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
    public Machop(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                   Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                   Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.FIGHTING, Type.NONE, ability, nature, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Machop's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //TODO: LOW KICK
        beginnerSkills.add(SkillFactory.LEER);
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
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.DUAL_CHOP)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUBMISSION)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.BULK_UP)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.CROSS_CHOP)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCARY_FACE)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.DYNAMIC_PUNCH)));
    }

    /**
     * Return Machoke if Machop is 28
     * @return Machoke if Machop is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 28) {
            return PokemonId.MACHOKE.getValue();
        }
        return -1;
    }
}
