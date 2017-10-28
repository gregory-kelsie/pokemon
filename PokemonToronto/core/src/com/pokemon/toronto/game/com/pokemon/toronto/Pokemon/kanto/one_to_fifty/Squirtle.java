package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Gregory on 6/14/2017.
 */
public class Squirtle extends Pokemon {

    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 7;
    private static final String NAME = "Squirtle";
    private static final int BASE_EXP = 54;
    private static final int[] EV_YIELD = {0, 0, 1, 0, 0, 0};
    private static final int CAPTURE_RATE = 45;

    //Base Stats
    private static final int BASE_HEALTH = 44;
    private static final int BASE_ATTACK = 48;
    private static final int BASE_DEFENSE = 65;
    private static final int BASE_SPECIAL_ATTACK = 50;
    private static final int BASE_SPECIAL_DEFENSE = 64;
    private static final int BASE_SPEED = 43;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/squirtle/squirtle.png";
    private static final String BACK_PATH = "battle/backs/squirtle.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/squirtle.png";
    private static final String CRY_PATH = "sounds/cry/007.wav";

    /**
     * Create a Squirtle with the specified level.
     * @param level The level of the Squirtle.
     */
    public Squirtle(int level) {
        super(NUMBER, NAME, level, Type.WATER, Type.NONE, Ability.TORRENT, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create a Squirtle from the database.
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
    public Squirtle(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                    Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                    Status status, Nature nature, Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.WATER, Type.NONE, ability, nature, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Squirtle's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        levelUpSkills.put(0, new ArrayList<Integer>(Arrays.asList(SkillFactory.TACKLE)));
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAIL_WHIP)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_GUN)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.WITHDRAW)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUBBLE)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAPID_SPIN)));
        //todo: protect at lvl 22
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_PULSE)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_TAIL)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.SKULL_BASH)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.IRON_DEFENSE)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAIN_DANCE)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYDRO_PUMP)));
    }

    /**
     * Init Squirtle's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .875) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

    /**
     * Return Wartortle if the Squirtle is above level 16.
     * @return Wartortle
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 16) {
            return PokemonId.WARTORTLE.getValue();
        }
        return -1;
    }
}
