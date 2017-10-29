package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 6/14/2017.
 */
public class Ivysaur extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 2;
    private static final String NAME = "Ivysaur";
    private static final int BASE_EXP = 54;
    private static final int[] EV_YIELD = {0, 0, 0, 1, 1, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 13;

    //Base Stats
    private static final int BASE_HEALTH = 60;
    private static final int BASE_ATTACK = 62;
    private static final int BASE_DEFENSE = 63;
    private static final int BASE_SPECIAL_ATTACK = 80;
    private static final int BASE_SPECIAL_DEFENSE = 80;
    private static final int BASE_SPEED = 60;


    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/ivysaur/ivysaur.png";
    private static final String BACK_PATH = "battle/backs/ivysaur.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/ivysaur.png";
    private static final String CRY_PATH = "sounds/cry/002.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/002.png";

    /**
     * Create a Ivysaur with the specified level from the wild.
     * @param level The level of the Ivysaur.
     */
    public Ivysaur(int level) {
        super(NUMBER, NAME, level, Type.GRASS, Type.POISON, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT);
    }

    /**
     * Create an Ivysaur from the database or through evolution.
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
    public Ivysaur(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs,
                   Skill firstSkill, Skill secondSkill, Skill thirdSkill, Skill fourthSkill,
                   int currentHealth, int currentExp, Status status, Nature nature,
                   Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.GRASS, Type.POISON, ability,
                nature, ExpType.MEDIUM_SLOW, BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK,
                        BASE_DEFENSE, BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED},
                ICON_PATH, BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT,
                firstSkill, secondSkill, thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Ivysaur's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> initSkills = new ArrayList<Integer>();
        initSkills.add(SkillFactory.TACKLE);
        initSkills.add(SkillFactory.GROWL);
        initSkills.add(SkillFactory.LEECH_SEED);
        levelUpSkills.put(0, initSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWL)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEECH_SEED)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.VINE_WHIP)));
        ArrayList<Integer> thirteen = new ArrayList<Integer>();
        thirteen.add(SkillFactory.POISON_POWDER);
        thirteen.add(SkillFactory.SLEEP_POWDER);
        levelUpSkills.put(13, thirteen);
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_LEAF)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWEET_SCENT)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWTH)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
        //todo: worry seed
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.SYNTHESIS)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.SOLAR_BEAM)));
    }

    /**
     * Init Ivysaur's gender.
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

    @Override
    protected void initAbility() {
        ability = Ability.OVERGROW;
    }

    /**
     * Return Venusaur if the Ivysaur is above level 32.
     * @return Venusaur if Bulbasaur is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 32) {
            return PokemonId.VENUSAUR.getValue();
        }
        return -1;
    }
}
