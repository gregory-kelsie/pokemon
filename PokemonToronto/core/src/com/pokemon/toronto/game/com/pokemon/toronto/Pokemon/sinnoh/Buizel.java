package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-24.
 */

public class Buizel extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 418;
    public static final String NAME = "Buizel";
    public static final String TYPE_OF_POKEMON = "Sea Weasel";
    public static final String DESCRIPTION = "It spins its two tails like a screw to propel " +
            "itself through water. The tails also slice clinging seaweed.";
    public static final double HEIGHT = 0.7;
    public static final int BASE_EXP = 66;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    public static final int CAPTURE_RATE = 190;
    public static final double WEIGHT = 29.5;

    public static final Ability FIRST_ABILITY = new Ability.SwiftSwim();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.WaterVeil();

    //Base Stats
    public static final int BASE_HEALTH = 55;
    public static final int BASE_ATTACK = 65;
    public static final int BASE_DEFENSE = 35;
    public static final int BASE_SPECIAL_ATTACK = 60;
    public static final int BASE_SPECIAL_DEFENSE = 30;
    public static final int BASE_SPEED = 85;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/buizel.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/buizel.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/buizel.png";
    public static final String CRY_PATH = "sounds/cry/418.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/buizel.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.WATER;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a buizel
     */
    public Buizel() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init buizel's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SONIC_BOOM);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWL)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_SPORT)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_GUN)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.PURSUIT)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWIFT)));
        levelUpSkills.put(24, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_JET)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_HIT)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.WHIRLPOOL)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_WIND)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_TAIL)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYDRO_PUMP)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.BULK_UP.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.BLIZZARD.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.SCALD.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.WATERFALL.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init buizel's gender.
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
     * Return Floatzel if the Buizel is above level 26.
     * @return Floatzel if Buizel is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 26) {
            return PokemonId.FLOATZEL.getValue();
        }
        return -1;
    }
}
