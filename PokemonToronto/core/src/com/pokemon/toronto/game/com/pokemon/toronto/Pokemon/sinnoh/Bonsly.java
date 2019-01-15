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
 * Created by gregorykelsie on 2018-04-25.
 */

public class Bonsly extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 438;
    public static final String NAME = "Bonsly";
    public static final String TYPE_OF_POKEMON = "Bonsai";
    public static final String DESCRIPTION = "It prefers an arid atmosphere. It leaks water that " +
            "looks like tears when adjusting its moisture level.";
    public static final double HEIGHT = 0.5;
    public static final int BASE_EXP = 58;
    public static final int[] EV_YIELD = {0, 0, 1, 0, 0, 0};
    public static final int CAPTURE_RATE = 255;
    public static final double WEIGHT = 15;

    public static final Ability FIRST_ABILITY = new Ability.Sturdy();
    public static final Ability SECOND_ABILITY = new Ability.RockHead();
    public static final Ability HIDDEN_ABILITY = new Ability.Rattled();

    //Base Stats
    public static final int BASE_HEALTH = 50;
    public static final int BASE_ATTACK = 80;
    public static final int BASE_DEFENSE = 95;
    public static final int BASE_SPECIAL_ATTACK = 10;
    public static final int BASE_SPECIAL_DEFENSE = 45;
    public static final int BASE_SPEED = 10;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/bonsly.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/bonsly.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/bonsly.png";
    public static final String CRY_PATH = "sounds/cry/438.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/bonsly.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.ROCK;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a bonsly
     */
    public Bonsly() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init bonsly's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.FAKE_TEARS);
        //TODO COPYCAT
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAIL)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.LOW_KICK)));
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_THROW)));
        //TODO MIMIC 15
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT_ATTACK)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.TEARFUL_LOOK)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_TOMB)));
        //TODO BLOCK 29
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_SLIDE)));
        //TODO COUNTER 36
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUCKER_PUNCH)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SMACK_DOWN.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.EXPLOSION.getValue());
        tmSkills.add(TmId.ROCK_POLISH.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init bonsly's gender.
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
     * Return Sudowoodo if the Bonsly is above level 15.
     * @return Sudowoodo if Bonsly is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 15) { //TODO: Check mimic when implemented
            return PokemonId.SUDOWOODO.getValue();
        }
        return -1;
    }

}
