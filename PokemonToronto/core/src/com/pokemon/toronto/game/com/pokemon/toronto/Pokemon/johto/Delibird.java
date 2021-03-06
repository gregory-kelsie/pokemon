package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-22.
 */

public class Delibird extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 225;
    public static final String NAME = "Delibird";
    public static final String TYPE_OF_POKEMON = "Delivery";
    public static final String DESCRIPTION = "It carries food all day long. When someone is lost" +
            " in the mountains, it shares that food.";
    public static final int BASE_EXP = 116;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 16;
    public static final double HEIGHT = 0.9;

    public static final Ability FIRST_ABILITY = new Ability.VitalSpirit();
    public static final Ability SECOND_ABILITY = new Ability.Hustle();
    public static final Ability HIDDEN_ABILITY = new Ability.Insomnia();

    //Base Stats
    public static final int BASE_HEALTH = 45;
    public static final int BASE_ATTACK = 55;
    public static final int BASE_DEFENSE = 45;
    public static final int BASE_SPECIAL_ATTACK = 65;
    public static final int BASE_SPECIAL_DEFENSE = 45;
    public static final int BASE_SPEED = 75;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/johto/delibird.png";
    public static final String BACK_PATH = "battle/backs/johto/delibird.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/johto/delibird.png";
    public static final String CRY_PATH = "sounds/cry/225.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/johto/delibird.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.ICE;
    public static final Type TYPE_TWO = Type.FLYING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.FAST;

    /**
     * Create a delibird
     */
    public Delibird() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init delibird's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.PRESENT);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRILL_PECK)));
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
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.BRUTAL_SWING.getValue());
        tmSkills.add(TmId.AURORA_VEIL.getValue());
        tmSkills.add(TmId.FLY.getValue());
        tmSkills.add(TmId.FROST_BREATH.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init delibird's gender.
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
