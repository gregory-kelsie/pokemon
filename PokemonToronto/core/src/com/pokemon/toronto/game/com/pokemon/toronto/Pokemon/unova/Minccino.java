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
 * Created by gregorykelsie on 2018-05-06.
 */

public class Minccino extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 572;
    public static final String NAME = "Minccino";
    public static final String TYPE_OF_POKEMON = "Chinchilla";
    public static final String DESCRIPTION = "They greet one another by rubbing each other with" +
            " their tails, which are always kept well groomed and clean.";
    public static final double HEIGHT = 0.4;
    public static final int BASE_EXP = 60;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    public static final int CAPTURE_RATE = 255;
    public static final double WEIGHT = 5.8;

    public static final Ability FIRST_ABILITY = new Ability.CuteCharm();
    public static final Ability SECOND_ABILITY = new Ability.Technician();
    public static final Ability HIDDEN_ABILITY = new Ability.SkillLink();

    //Base Stats
    public static final int BASE_HEALTH = 55;
    public static final int BASE_ATTACK = 50;
    public static final int BASE_DEFENSE = 40;
    public static final int BASE_SPECIAL_ATTACK = 40;
    public static final int BASE_SPECIAL_DEFENSE = 40;
    public static final int BASE_SPEED = 75;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/minccino.png";
    public static final String BACK_PATH = "battle/backs/unova/minccino.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/minccino.png";
    public static final String CRY_PATH = "sounds/cry/572.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/minccino.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.FAST;

    /**
     * Create a minccino
     */
    public Minccino() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init minccino's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.POUND);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.BABY_DOLL_EYES)));
        //7 HELPING HAND
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.TICKLE)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_SLAP)));
        //15 ENCORE
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWIFT)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.SING)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAIL_SLAP)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARM)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.WAKE_UP_SLAP)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.ECHOED_VOICE)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLAM)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.CAPTIVATE)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_VOICE)));
        //45 LAST RESORT
        //49 AFTER YOU
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.DAZZLING_GLEAM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init minccino's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .246) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

    @Override
    public int getShinyStoneEvolutionId() {
        return PokemonId.CINCCINO.getValue();
    }
}
