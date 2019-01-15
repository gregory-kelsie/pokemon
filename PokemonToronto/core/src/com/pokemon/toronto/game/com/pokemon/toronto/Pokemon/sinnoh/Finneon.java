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
 * Created by gregorykelsie on 2018-04-29.
 */

public class Finneon extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 456;
    public static final String NAME = "Finneon";
    public static final String TYPE_OF_POKEMON = "Wing Fish";
    public static final String DESCRIPTION = "The line running down its side can store sunlight." +
            " It shines vividly at night.";
    public static final double HEIGHT = 0.4;
    public static final int BASE_EXP = 66;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    public static final int CAPTURE_RATE = 190;
    public static final double WEIGHT = 7;

    public static final Ability FIRST_ABILITY = new Ability.SwiftSwim();
    public static final Ability SECOND_ABILITY = new Ability.StormDrain();
    public static final Ability HIDDEN_ABILITY = new Ability.WaterVeil();

    //Base Stats
    public static final int BASE_HEALTH = 49;
    public static final int BASE_ATTACK = 49;
    public static final int BASE_DEFENSE = 56;
    public static final int BASE_SPECIAL_ATTACK = 49;
    public static final int BASE_SPECIAL_DEFENSE = 61;
    public static final int BASE_SPEED = 66;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/finneon.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/finneon.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/finneon.png";
    public static final String CRY_PATH = "sounds/cry/456.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/finneon.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.WATER;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.ERRATIC;

    /**
     * Create a finneon
     */
    public Finneon() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init finneon's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.POUND);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_GUN)));
        //10 ATTRACT
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAIN_DANCE)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.GUST)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_PULSE)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.CAPTIVATE)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAFEGUARD)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_RING)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.WHIRLPOOL)));
        //42 U-TURN
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.BOUNCE)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.SILVER_WIND)));
        //54 SOAK
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.BLIZZARD.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.SCALD.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.WATERFALL.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init finneon's gender.
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
     * Return Lumineon if the finneon is above level 31.
     * @return Lumineon if finneon is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 31) {
            return PokemonId.LUMINEON.getValue();
        }
        return -1;
    }
}
