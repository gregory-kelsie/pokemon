package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kalos;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-02-02.
 */

public class Dedenne extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 702;
    public static final String NAME = "Dedenne";
    public static final String TYPE_OF_POKEMON = "Antenna";
    public static final String DESCRIPTION = "Its whiskers serve as antennas. By sending and " +
            "receiving electrical waves, it can communicate with others over vast distances.";
    public static final double HEIGHT = 0.2;
    public static final int BASE_EXP = 151;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 2};
    public static final int CAPTURE_RATE = 180;
    public static final double WEIGHT = 2.2;

    public static final Ability FIRST_ABILITY = new Ability.CheekPouch();
    public static final Ability SECOND_ABILITY = new Ability.Pickup();
    public static final Ability HIDDEN_ABILITY = new Ability.Plus();

    //Base Stats
    public static final int BASE_HEALTH = 67;
    public static final int BASE_ATTACK = 58;
    public static final int BASE_DEFENSE = 57;
    public static final int BASE_SPECIAL_ATTACK = 81;
    public static final int BASE_SPECIAL_DEFENSE = 67;
    public static final int BASE_SPEED = 101;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/dedenne.png";
    public static final String BACK_PATH = "battle/backs/kalos/dedenne.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/dedenne.png";
    public static final String CRY_PATH = "sounds/cry/702.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/dedenne.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.ELECTRIC;
    public static final Type TYPE_TWO = Type.FAIRY;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a dedenne
     */
    public Dedenne() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init dedenne's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER_SHOCK)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARGE)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARM)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.PARABOLIC_CHARGE)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.NUZZLE)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER_WAVE)));
        //26 VOLT SWITCH
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.REST)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.SNORE)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARGE_BEAM)));
        //39 ENTERTAINMENT
        levelUpSkills.put(42, new ArrayList<Integer>(Arrays.asList(SkillFactory.PLAY_ROUGH)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISCHARGE)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.VOLT_SWITCH.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.WILD_CHARGE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init dedenne's gender.
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
