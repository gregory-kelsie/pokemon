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

public class Komala extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 775;
    public static final String NAME = "Komala";
    public static final String TYPE_OF_POKEMON = "Drowsing";
    public static final String DESCRIPTION = "The log it holds was given to it by its parents at" +
            " birth. It has also been known to cling to the arm of a friendly Trainer.";
    public static final double HEIGHT = 0.4;
    public static final int BASE_EXP = 168;
    public static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 19.9;

    public static final Ability FIRST_ABILITY = new Ability.Comatose();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 65;
    public static final int BASE_ATTACK = 115;
    public static final int BASE_DEFENSE = 65;
    public static final int BASE_SPECIAL_ATTACK = 75;
    public static final int BASE_SPECIAL_DEFENSE = 95;
    public static final int BASE_SPEED = 65;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/alola/komala.png";
    public static final String BACK_PATH = "battle/backs/alola/komala.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/alola/komala.png";
    public static final String CRY_PATH = "sounds/cry/775.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/alola/komala.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a komala
     */
    public Komala() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init komala's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.DEFENSE_CURL);
        beginnerSkills.add(SkillFactory.ROLLOUT);
        levelUpSkills.put(0, beginnerSkills);
        List<Integer> stockpile = new ArrayList<Integer>();
        stockpile.add(SkillFactory.STOCKPILE);
        stockpile.add(SkillFactory.SPIT_UP);
        stockpile.add(SkillFactory.SWALLOW);
        levelUpSkills.put(6, stockpile);
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAPID_SPIN)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.YAWN)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLAM)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAIL)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUCKER_PUNCH)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCH_UP)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.WOOD_HAMMER)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.THRASH)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.BULK_UP.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.LOW_SWEEP.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.QUASH.getValue());
        tmSkills.add(TmId.ACROBATICS.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init komala's gender.
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
