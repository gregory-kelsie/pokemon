package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alola;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-30.
 */

public class Stufful extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 759;
    public static final String NAME = "Stufful";
    public static final String TYPE_OF_POKEMON = "Flailing";
    public static final String DESCRIPTION = "Despite its adorable appearance, when it gets angry" +
            " and flails about, its arms and legs could knock a pro wrestler sprawling.";
    public static final double HEIGHT = 0.5;
    public static final int BASE_EXP = 68;
    public static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 140;
    public static final double WEIGHT = 6.8;

    public static final Ability FIRST_ABILITY = new Ability.Fluffy();
    public static final Ability SECOND_ABILITY = new Ability.Klutz();
    public static final Ability HIDDEN_ABILITY = new Ability.CuteCharm();

    //Base Stats
    public static final int BASE_HEALTH = 70;
    public static final int BASE_ATTACK = 75;
    public static final int BASE_DEFENSE = 50;
    public static final int BASE_SPECIAL_ATTACK = 45;
    public static final int BASE_SPECIAL_DEFENSE = 50;
    public static final int BASE_SPEED = 50;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/alola/stufful.png";
    public static final String BACK_PATH = "battle/backs/alola/stufful.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/alola/stufful.png";
    public static final String CRY_PATH = "sounds/cry/759.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/alola/stufful.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.FIGHTING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a stufful
     */
    public Stufful() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init stufful's level up skills.
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
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.HAMMER_ARM)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.THRASH)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.PAIN_SPLIT)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPERPOWER)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.BULK_UP.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
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
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init stufful's gender.
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
     * Return Bewear if the stufful is above level 27.
     * @return Bewear if stufful is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 27) {
            return PokemonId.BEWEAR.getValue();
        }
        return -1;
    }
}
