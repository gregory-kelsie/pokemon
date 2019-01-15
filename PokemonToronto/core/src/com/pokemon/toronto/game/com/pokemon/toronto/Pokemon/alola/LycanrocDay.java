package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alola;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-30.
 */

public class LycanrocDay extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 745;
    public static final String NAME = "Lycanroc";
    public static final String TYPE_OF_POKEMON = "Wolf";
    public static final String DESCRIPTION = "The sharp rocks in its mane can cut like knives." +
            " Lycanroc wears its prey down by degrees before finishing them off.";
    public static final double HEIGHT = 0.8;
    public static final int BASE_EXP = 170;
    public static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 90;
    public static final double WEIGHT = 25;

    public static final Ability FIRST_ABILITY = new Ability.KeenEye();
    public static final Ability SECOND_ABILITY = new Ability.SandRush();
    public static final Ability HIDDEN_ABILITY = new Ability.Steadfast();

    //Base Stats
    public static final int BASE_HEALTH = 75;
    public static final int BASE_ATTACK = 115;
    public static final int BASE_DEFENSE = 65;
    public static final int BASE_SPECIAL_ATTACK = 55;
    public static final int BASE_SPECIAL_DEFENSE = 65;
    public static final int BASE_SPEED = 112;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/alola/lycanroc.png";
    public static final String BACK_PATH = "battle/backs/alola/lycanroc.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/alola/lycanroc-day.png";
    public static final String CRY_PATH = "sounds/cry/745-day.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/alola/lycanroc-day.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.ROCK;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a lycanroc
     */
    public LycanrocDay() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init lycanroc's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //QUICK GUARD
        beginnerSkills.add(SkillFactory.QUICK_ATTACK);
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.SAND_ATTACK);
        beginnerSkills.add(SkillFactory.BITE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAND_ATTACK)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.HOWL)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_THROW)));
        //18 ODOR SLEUTH
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_TOMB)));
        //26 ROAR
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.STEALTH_ROCK)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_SLIDE)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCARY_FACE)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_CLIMB)));
        levelUpSkills.put(48, new ArrayList<Integer>(Arrays.asList(SkillFactory.STONE_EDGE)));
        initEvolutionSkills();
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.BULK_UP.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.ROCK_POLISH.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SNARL.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.ACCELEROCK);
    }

    /**
     * Init lycanroc's gender.
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
