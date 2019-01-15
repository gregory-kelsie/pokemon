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
 * Created by gregorykelsie on 2018-04-24.
 */

public class Buneary extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 427;
    public static final String NAME = "Buneary";
    public static final String TYPE_OF_POKEMON = "Rabbit";
    public static final String DESCRIPTION = "Its ears are always rolled up. They can be " +
            "forcefully extended to shatter even a large boulder.";
    public static final double HEIGHT = 0.4;
    public static final int BASE_EXP = 70;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    public static final int CAPTURE_RATE = 190;
    public static final double WEIGHT = 5.5;

    public static final Ability FIRST_ABILITY = new Ability.RunAway();
    public static final Ability SECOND_ABILITY = new Ability.Klutz();
    public static final Ability HIDDEN_ABILITY = new Ability.Limber();

    //Base Stats
    public static final int BASE_HEALTH = 55;
    public static final int BASE_ATTACK = 66;
    public static final int BASE_DEFENSE = 44;
    public static final int BASE_SPECIAL_ATTACK = 44;
    public static final int BASE_SPECIAL_DEFENSE = 56;
    public static final int BASE_SPEED = 85;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/buneary.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/buneary.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/buneary.png";
    public static final String CRY_PATH = "sounds/cry/427.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/buneary.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a buneary
     */
    public Buneary() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init buneary's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //FRUSTRATION
        beginnerSkills.add(SkillFactory.DEFENSE_CURL);
        beginnerSkills.add(SkillFactory.SPLASH);
        beginnerSkills.add(SkillFactory.POUND);
        //FORESIGHT
        levelUpSkills.put(0, beginnerSkills);
        //6 ENDURE
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.BABY_DOLL_EYES)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.JUMP_KICK)));
        //26 BATON PASS
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.DIZZY_PUNCH)));
        //43 AFTER YOU
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARM)));
        //50 ENTERTAINMENT
        levelUpSkills.put(56, new ArrayList<Integer>(Arrays.asList(SkillFactory.BOUNCE)));
        //63 HEALING WISH
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init buneary's gender.
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

    @Override
    public int getShinyStoneEvolutionId() {
        return PokemonId.LOPUNNY.getValue();
    }
}
