package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alola;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-30.
 */

public class Bewear extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 760;
    public static final String NAME = "Bewear";
    public static final String TYPE_OF_POKEMON = "Strong Arm";
    public static final String DESCRIPTION = "This immensely dangerous Pokémon possesses " +
            "overwhelming physical strength. Its habitat is generally off-limits.";
    public static final double HEIGHT = 2.1;
    public static final int BASE_EXP = 175;
    public static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 70;
    public static final double WEIGHT = 135;

    public static final Ability FIRST_ABILITY = new Ability.Fluffy();
    public static final Ability SECOND_ABILITY = new Ability.Klutz();
    public static final Ability HIDDEN_ABILITY = new Ability.Unnerve();

    //Base Stats
    public static final int BASE_HEALTH = 120;
    public static final int BASE_ATTACK = 125;
    public static final int BASE_DEFENSE = 80;
    public static final int BASE_SPECIAL_ATTACK = 55;
    public static final int BASE_SPECIAL_DEFENSE = 60;
    public static final int BASE_SPEED = 60;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/alola/bewear.png";
    public static final String BACK_PATH = "battle/backs/alola/bewear.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/alola/bewear.png";
    public static final String CRY_PATH = "sounds/cry/760.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/alola/bewear.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.FIGHTING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a bewear
     */
    public Bewear() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init bewear's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.LEER);
        levelUpSkills.put(0, beginnerSkills);
        //5 BIDE
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.BABY_DOLL_EYES)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.BRUTAL_SWING)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAIL)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.PAYBACK)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.HAMMER_ARM)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.THRASH)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.PAIN_SPLIT)));
        levelUpSkills.put(56, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
        levelUpSkills.put(62, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPERPOWER)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.DRAGON_CLAW.getValue());
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.BULK_UP.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.LOW_SWEEP.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.BRUTAL_SWING.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init bewear's gender.
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
