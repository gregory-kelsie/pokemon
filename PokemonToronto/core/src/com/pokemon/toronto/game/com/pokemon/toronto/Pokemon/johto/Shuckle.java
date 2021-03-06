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

public class Shuckle extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 213;
    public static final String NAME = "Shuckle";
    public static final String TYPE_OF_POKEMON = "Mold";
    public static final String DESCRIPTION = "It stores berries in its shell. The berries" +
            " eventually ferment to become delicious juices.";
    public static final int BASE_EXP = 177;
    public static final int[] EV_YIELD = {0, 0, 1, 0, 1, 0};
    public static final int CAPTURE_RATE = 190;
    public static final double WEIGHT = 20.5;
    public static final double HEIGHT = 0.6;

    public static final Ability FIRST_ABILITY = new Ability.Sturdy();
    public static final Ability SECOND_ABILITY = new Ability.Gluttony();
    public static final Ability HIDDEN_ABILITY = new Ability.Contrary();

    //Base Stats
    public static final int BASE_HEALTH = 20;
    public static final int BASE_ATTACK = 10;
    public static final int BASE_DEFENSE = 230;
    public static final int BASE_SPECIAL_ATTACK = 10;
    public static final int BASE_SPECIAL_DEFENSE = 230;
    public static final int BASE_SPEED = 5;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/johto/shuckle.png";
    public static final String BACK_PATH = "battle/backs/johto/shuckle.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/johto/shuckle.png";
    public static final String CRY_PATH = "sounds/cry/213.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/johto/shuckle.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.BUG;
    public static final Type TYPE_TWO = Type.ROCK;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a shuckle
     */
    public Shuckle() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init shuckle's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.WITHDRAW);
        //BIDE
        beginnerSkills.add(SkillFactory.CONSTRICT);
        beginnerSkills.add(SkillFactory.ROLLOUT);
        beginnerSkills.add(SkillFactory.STICKY_WEB);
        levelUpSkills.put(0, beginnerSkills);
        //TODO ENCORE 5
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.WRAP)));
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.STRUGGLE_BUG)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAFEGUARD)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.REST)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_THROW)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.GASTRO_ACID)));
        //TODO POWER TRICK 31
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHELL_SMASH)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_SLIDE)));
        levelUpSkills.put(42, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BITE)));
        //TODO GUARD SPLIT AND POWER SPLIT 45
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.STONE_EDGE)));
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.STICKY_WEB)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.VENOSHOCK.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SMACK_DOWN.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SLUDGE_WAVE.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ROCK_POLISH.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.GYRO_BALL.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init shuckle's gender.
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
