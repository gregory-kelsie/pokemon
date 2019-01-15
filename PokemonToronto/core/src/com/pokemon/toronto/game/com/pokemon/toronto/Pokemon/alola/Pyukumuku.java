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

public class Pyukumuku extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 771;
    public static final String NAME = "Pyukumuku";
    public static final String TYPE_OF_POKEMON = "Sea Cucumber";
    public static final String DESCRIPTION = "It lives in shallow seas, such as areas near a " +
            "beach. It can eject its internal organs, which it uses to engulf its prey or battle enemies.";
    public static final double HEIGHT = 0.3;
    public static final int BASE_EXP = 144;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 2, 0};
    public static final int CAPTURE_RATE = 60;
    public static final double WEIGHT = 1.2;

    public static final Ability FIRST_ABILITY = new Ability.InnardsOut();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.Unaware();

    //Base Stats
    public static final int BASE_HEALTH = 55;
    public static final int BASE_ATTACK = 60;
    public static final int BASE_DEFENSE = 130;
    public static final int BASE_SPECIAL_ATTACK = 30;
    public static final int BASE_SPECIAL_DEFENSE = 130;
    public static final int BASE_SPEED = 5;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/alola/pyukumuku.png";
    public static final String BACK_PATH = "battle/backs/alola/pyukumuku.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/alola/pyukumuku.png";
    public static final String CRY_PATH = "sounds/cry/771.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/alola/pyukumuku.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.WATER;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.FAST;

    /**
     * Create a pyukumuku
     */
    public Pyukumuku() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init pyukumuku's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //BATON PASS
        beginnerSkills.add(SkillFactory.WATER_SPORT);
        //MUD SPORT
        beginnerSkills.add(SkillFactory.HARDEN);
        //BIDE
        levelUpSkills.put(0, beginnerSkills);
        //5 HELPING HAND
        //9 TAUNT
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAFEGUARD)));
        //17 COUNTER
        //21 PURIFY
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.CURSE)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.GASTRO_ACID)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.PAIN_SPLIT)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.RECOVER)));
        //41 SOAK
        //45 TOXIC
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEMENTO)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.QUASH.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init pyukumuku's gender.
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
