package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.unova;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-05-04.
 */

public class Patrat extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 504;
    public static final String NAME = "Patrat";
    public static final String TYPE_OF_POKEMON = "Scout";
    public static final String DESCRIPTION = "Using food stored in cheek pouches, they can keep " +
            "watch for days. They use their tails to communicate with others.";
    public static final double HEIGHT = 0.5;
    public static final int BASE_EXP = 51;
    public static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 255;
    public static final double WEIGHT = 11.6;

    public static final Ability FIRST_ABILITY = new Ability.RunAway();
    public static final Ability SECOND_ABILITY = new Ability.KeenEye();
    public static final Ability HIDDEN_ABILITY = new Ability.Analytic();

    //Base Stats
    public static final int BASE_HEALTH = 45;
    public static final int BASE_ATTACK = 55;
    public static final int BASE_DEFENSE = 39;
    public static final int BASE_SPECIAL_ATTACK = 35;
    public static final int BASE_SPECIAL_DEFENSE = 39;
    public static final int BASE_SPEED = 42;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/patrat.png";
    public static final String BACK_PATH = "battle/backs/unova/patrat.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/patrat.png";
    public static final String CRY_PATH = "sounds/cry/504.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/patrat.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a patrat
     */
    public Patrat() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init patrat's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEER)));
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        //8 BIDE
        //11 DETECT
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAND_ATTACK)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPNOSIS)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPER_FANG)));
        //23 AFTER YOU
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.FOCUS_ENERGY)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.WORK_UP)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_FANG)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.NASTY_PLOT)));
        //36 MEAN LOOK
        //38 BATON PASS
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLAM)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init patrat's gender.
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

    /**
     * Return Watchog if the patrat is above level 20.
     * @return Watchog if patrat is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 20) {
            return PokemonId.WATCHOG.getValue();
        }
        return -1;
    }
}
