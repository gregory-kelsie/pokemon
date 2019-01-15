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

public class Oranguru extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 765;
    public static final String NAME = "Oranguru";
    public static final String TYPE_OF_POKEMON = "Sage";
    public static final String DESCRIPTION = "Known for its extreme intelligence, this Pokémon " +
            "will look down on inexperienced Trainers, so it’s best suited to veteran Trainers.";
    public static final double HEIGHT = 1.5;
    public static final int BASE_EXP = 172;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 2, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 76;

    public static final Ability FIRST_ABILITY = new Ability.InnerFocus();
    public static final Ability SECOND_ABILITY = new Ability.Telepathy();
    public static final Ability HIDDEN_ABILITY = new Ability.Symbiosis();

    //Base Stats
    public static final int BASE_HEALTH = 90;
    public static final int BASE_ATTACK = 60;
    public static final int BASE_DEFENSE = 80;
    public static final int BASE_SPECIAL_ATTACK = 90;
    public static final int BASE_SPECIAL_DEFENSE = 110;
    public static final int BASE_SPEED = 60;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/alola/oranguru.png";
    public static final String BACK_PATH = "battle/backs/alola/oranguru.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/alola/oranguru.png";
    public static final String CRY_PATH = "sounds/cry/765.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/alola/oranguru.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.PSYCHIC;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a oranguru
     */
    public Oranguru() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init oranguru's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.CONFUSION);
        levelUpSkills.put(0, beginnerSkills);
        //4 AFTER YOU
        //8 TAUNT
        //11 QUASH
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.STORED_POWER)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCH_UP)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT_ATTACK)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.NASTY_PLOT)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.ZEN_HEADBUTT)));
        //32 INSTRUCT
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.FOUL_PLAY)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.CALM_MIND)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCHIC)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.FUTURE_SIGHT)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.TRICK_ROOM)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.PSYSHOCK.getValue());
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.BRUTAL_SWING.getValue());
        tmSkills.add(TmId.QUASH.getValue());
        tmSkills.add(TmId.EMBARGO.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.TRICK_ROOM.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init oranguru's gender.
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
