package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/27/2017.
 */

public class AlolanNinetales extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = -38;
    private static final String NAME = "Ninetales";
    private static final int BASE_EXP = 63;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 2};
    private static final int CAPTURE_RATE = 178;
    private static final double WEIGHT = 19.9;

    //Base Stats
    private static final int BASE_HEALTH = 73;
    private static final int BASE_ATTACK = 67;
    private static final int BASE_DEFENSE = 75;
    private static final int BASE_SPECIAL_ATTACK = 81;
    private static final int BASE_SPECIAL_DEFENSE = 100;
    private static final int BASE_SPEED = 109;

    //Typing
    private static final Type TYPE_ONE = Type.ICE;
    private static final Type TYPE_TWO = Type.FAIRY;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/alolan_kanto/ninetales.png";
    private static final String BACK_PATH = "battle/backs/alolan_kanto/ninetales.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/alolan_kanto/ninetales.png";
    private static final String CRY_PATH = "sounds/cry/038.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/alolan_kanto/alolanninetales.png";

    /**
     * Create a Ninetales with the specified level.
     * @param level The level of the Ninetales.
     */
    public AlolanNinetales(int level) {
        super(NUMBER, NAME, level, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT);
    }

    /**
     * Create an Ninetales from the database.
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
    public AlolanNinetales(boolean fromDatabase, int level, char  gender, int[] ivs, int [] evs, Skill firstSkill,
                     Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                     Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, TYPE_ONE, TYPE_TWO, ability, nature, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT,
                firstSkill, secondSkill, thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    //TODO: HIDDEN SNOW WARNING
    @Override
    protected void initAbility() {
        ability = Ability.SNOW_CLOAK;
    }

    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .75) {
            gender = 'F';
        } else {
            gender = 'M';
        }
    }

    /**
     * Init Ninetales's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //TODO: IMPRISON
        beginnerSkills.add(SkillFactory.NASTY_PLOT);
        beginnerSkills.add(SkillFactory.ICE_BEAM);
        beginnerSkills.add(SkillFactory.ICE_SHARD);
        beginnerSkills.add(SkillFactory.CONFUSE_RAY);
        beginnerSkills.add(SkillFactory.SAFEGUARD);
        levelUpSkills.put(0, beginnerSkills);
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.DAZZLING_GLEAM);
    }
}
