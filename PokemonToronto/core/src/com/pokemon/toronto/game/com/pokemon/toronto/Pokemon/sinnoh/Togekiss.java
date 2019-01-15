package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-29.
 */

public class Togekiss extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 468;
    public static final String NAME = "Togekiss";
    public static final String TYPE_OF_POKEMON = "Jubilee";
    public static final String DESCRIPTION = "It shares many blessings with people who respect" +
            " one another's rights and avoid needless strife.";
    public static final double HEIGHT = 1.5;
    public static final int BASE_EXP = 245;
    public static final int[] EV_YIELD = {0, 0, 0, 2, 1, 0};
    public static final int CAPTURE_RATE = 30;
    public static final double WEIGHT = 38;

    public static final Ability FIRST_ABILITY = new Ability.Hustle();
    public static final Ability SECOND_ABILITY = new Ability.SereneGrace();
    public static final Ability HIDDEN_ABILITY = new Ability.SuperLuck();

    //Base Stats
    public static final int BASE_HEALTH = 75;
    public static final int BASE_ATTACK = 95;
    public static final int BASE_DEFENSE = 67;
    public static final int BASE_SPECIAL_ATTACK = 125;
    public static final int BASE_SPECIAL_DEFENSE = 95;
    public static final int BASE_SPEED = 83;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/togekiss.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/togekiss.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/togekiss.png";
    public static final String CRY_PATH = "sounds/cry/468.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/togekiss.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.FAIRY;
    public static final Type TYPE_TWO = Type.FLYING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.FAST;

    /**
     * Create a togekiss
     */
    public Togekiss() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init togekiss's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //AFTER YOU
        beginnerSkills.add(SkillFactory.SKY_ATTACK);
        beginnerSkills.add(SkillFactory.EXTREME_SPEED);
        beginnerSkills.add(SkillFactory.AURA_SPHERE);
        beginnerSkills.add(SkillFactory.AIR_SLASH);
        levelUpSkills.put(0, beginnerSkills);
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.PSYSHOCK.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.ROOST.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.FLAMETHROWER.getValue());
        tmSkills.add(TmId.FIRE_BLAST.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.STEEL_WING.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.FLY.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.DAZZLING_GLEAM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init togekiss's gender.
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
}
