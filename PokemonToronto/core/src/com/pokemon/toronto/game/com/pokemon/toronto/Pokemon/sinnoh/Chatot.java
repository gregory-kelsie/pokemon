package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-25.
 */

public class Chatot extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 441;
    public static final String NAME = "Chatot";
    public static final String TYPE_OF_POKEMON = "Music Note";
    public static final String DESCRIPTION = "Its tongue is just like a human's. As a result, it" +
            " can cleverly mimic human speech.";
    public static final double HEIGHT = 0.5;
    public static final int BASE_EXP = 144;
    public static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 30;
    public static final double WEIGHT = 1.9;

    public static final Ability FIRST_ABILITY = new Ability.KeenEye();
    public static final Ability SECOND_ABILITY = new Ability.TangledFeet();
    public static final Ability HIDDEN_ABILITY = new Ability.BigPecks();

    //Base Stats
    public static final int BASE_HEALTH = 76;
    public static final int BASE_ATTACK = 65;
    public static final int BASE_DEFENSE = 45;
    public static final int BASE_SPECIAL_ATTACK = 92;
    public static final int BASE_SPECIAL_DEFENSE = 42;
    public static final int BASE_SPEED = 91;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/chatot.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/chatot.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/chatot.png";
    public static final String CRY_PATH = "sounds/cry/441.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/chatot.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.FLYING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a chatot
     */
    public Chatot() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init chatot's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.HYPER_VOICE);
        beginnerSkills.add(SkillFactory.CHATTER);
        beginnerSkills.add(SkillFactory.CONFIDE);
        //TAUNT
        beginnerSkills.add(SkillFactory.PECK);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWL)));
        //9 MIRROR MOVE
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.SING)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_ATTACK)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHATTER)));
        //25 TAUNT
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROUND)));
        //33 MIMIC
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.ECHOED_VOICE)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROOST)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.UPROAR)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.SYNCHRONOISE)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEATHER_DANCE)));
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_VOICE)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.TOXIC.getValue());;
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.ROOST.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.STEEL_WING.getValue());
        tmSkills.add(TmId.FLY.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init chatot's gender.
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
