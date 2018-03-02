package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alola;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-30.
 */

public class Wishiwashi extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 746;
    private static final String NAME = "Wishiwashi";
    private static final int BASE_EXP = 61;
    private static final int[] EV_YIELD = {1, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 60;
    private static final double WEIGHT = 0.3;
    private final double SCHOOL_WEIGHT = 78.6;

    private static final Ability FIRST_ABILITY = new Ability.Schooling();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    private static final int BASE_HEALTH = 45;
    private static final int BASE_ATTACK = 20;
    private static final int BASE_DEFENSE = 20;
    private static final int BASE_SPECIAL_ATTACK = 25;
    private static final int BASE_SPECIAL_DEFENSE = 25;
    private static final int BASE_SPEED = 40;

    //School Form Base Stats
    private final int[] SCHOOL_BASE_STATS = {45, 140, 130, 140, 135, 30};

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/alola/wishiwashi.png";
    private static final String BACK_PATH = "battle/backs/alola/wishiwashi.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/alola/wishiwashi.png";
    private static final String CRY_PATH = "sounds/cry/746-solo.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/alola/wishiwashi.png";

    //School Paths
    private final String SCHOOL_ICON_PATH = "pokemonSprites/alola/wishiwashi-school.png";
    private final String SCHOOL_BACK_PATH = "battle/backs/alola/wishiwashi-school.png";
    private final String SCHOOL_MINI_PATH = "pokemonMenu/sprites/alola/wishiwashi-school.png";
    private final String SCHOOL_CRY_PATH = "sounds/cry/746-school.wav";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.WATER;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.FAST;

    /**
     * Create a wishiwashi
     */
    public Wishiwashi() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Return the Pokemon's base attack stat.
     * @return Base Attack
     */
    @Override
    public int getBaseStatAttack() {
        if (level >= 20 && currentHealth >= getHealthStat() * 0.25) {
            return SCHOOL_BASE_STATS[ATTACK];
        }
        return baseStats[ATTACK];
    }

    /**
     * Return the Pokemon's base special attack
     * @return Base Special Attack
     */
    @Override
    public int getBaseStatSpeicialAttack() {
        if (level >= 20 && currentHealth >= getHealthStat() * 0.25) {
            return SCHOOL_BASE_STATS[SPECIAL_ATTACK];
        }
        return baseStats[SPECIAL_ATTACK];
    }

    /**
     * Return the Pokemon's base defense.
     * @return Base Defense
     */
    @Override
    public int getBaseStatDefense() {
        if (level >= 20 && currentHealth >= getHealthStat() * 0.25) {
            return SCHOOL_BASE_STATS[DEFENSE];
        }
        return baseStats[DEFENSE];
    }

    /**
     * Return the Pokemon's base special defense.
     * @return Base Special Defense
     */
    @Override
    public int getBaseStatSpecialDefense() {
        if (level >= 20 && currentHealth >= getHealthStat() * 0.25) {
            return SCHOOL_BASE_STATS[SPECIAL_DEFENSE];
        }
        return baseStats[SPECIAL_DEFENSE];
    }

    /**
     * Return the Pokemon's base speed.
     * @return Base Speed
     */
    @Override
    public int getBaseStatSpeed() {
        if (level >= 20 && currentHealth >= getHealthStat() * 0.25) {
            return SCHOOL_BASE_STATS[SPEED];
        }
        return baseStats[SPEED];
    }


    @Override
    public double getWeight() {
        if (level >= 20 && currentHealth >= getHealthStat() * 0.25) {
            return SCHOOL_WEIGHT;
        }
        return weight;
    }

    /**
     * Return the Pokemon's Front Image path
     * @return The path for the Pokemon's front image.
     */
    @Override
    public String getMapIconPath() {
        if (level >= 20 && currentHealth >= getHealthStat() * 0.25) {
            return SCHOOL_ICON_PATH;
        }
        return mapIconPath;
    }

    /**
     * Return the Pokemon's Cry Sound path.
     * @return The path for the Pokemon's cry sound.
     */
    @Override
    public String getCryPath() {
        if (level >= 20 && currentHealth >= getHealthStat() * 0.25) {
            return SCHOOL_CRY_PATH;
        }
        return cryPath;
    }

    /**
     * Return the Pokemon's Back Image Path
     * @return The path for the Pokemon's back image.
     */
    @Override
    public String getBackPath() {
        if (level >= 20 && currentHealth >= getHealthStat() * 0.25) {
            return SCHOOL_BACK_PATH;
        }
        return backPath;
    }

    /**
     * Return the Pokemon's mini image path.
     * @return The path for the Pokemon's mini image.
     */
    @Override
    public String getMiniIconPath() {
        if (level >= 20 && currentHealth >= getHealthStat() * 0.25) {
            return SCHOOL_MINI_PATH;
        }
        return miniPath;
    }

    /**
     * Init wishiwashi's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.WATER_GUN);
        beginnerSkills.add(SkillFactory.GROWL);
        levelUpSkills.put(0, beginnerSkills);
        //6 HELPING HAND
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT_ATTACK)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.BRINE)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_RING)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.TEARFUL_LOOK)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.DIVE)));
        //33 BEAT UP
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_TAIL)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
        //46 SOAK
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.ENDEAVOR)));
        levelUpSkills.put(54, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYDRO_PUMP)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.SCALD.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.WATERFALL.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }


    /**
     * Init wishiwashi's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .5) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }
}
