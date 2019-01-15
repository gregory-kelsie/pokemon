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

public class Panpour extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 515;
    public static final String NAME = "Panpour";
    public static final String TYPE_OF_POKEMON = "Spray";
    public static final String DESCRIPTION = "The water stored inside the tuft on its head is " +
            "full of nutrients. Plants that receive its water grow large.";
    public static final double HEIGHT = 0.6;
    public static final int BASE_EXP = 63;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    public static final int CAPTURE_RATE = 190;
    public static final double WEIGHT = 13.5;

    public static final Ability FIRST_ABILITY = new Ability.Gluttony();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.Torrent();

    //Base Stats
    public static final int BASE_HEALTH = 50;
    public static final int BASE_ATTACK = 53;
    public static final int BASE_DEFENSE = 48;
    public static final int BASE_SPECIAL_ATTACK = 53;
    public static final int BASE_SPECIAL_DEFENSE = 48;
    public static final int BASE_SPEED = 64;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/panpour.png";
    public static final String BACK_PATH = "battle/backs/unova/panpour.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/panpour.png";
    public static final String CRY_PATH = "sounds/cry/515.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/panpour.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.WATER;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a panpour
     */
    public Panpour() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init panpour's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SCRATCH);
        beginnerSkills.add(SkillFactory.PLAY_NICE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEER)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.LICK)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_GUN)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_SWIPES)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_SPORT)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCALD)));
        //22 TAUNT
        //28 FLING
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.ACROBATICS)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.BRINE)));
        //37 RECYCLE
        //40 NATURAL GIFT
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.BLIZZARD.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.LOW_SWEEP.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.SCALD.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.ACROBATICS.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.WATERFALL.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init panpour's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .881) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

    @Override
    public int getWaterStoneEvolutionId() {
        return PokemonId.SIMIPOUR.getValue();
    }
}
