package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.unova;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-05-04.
 */

public class Serperior extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 497;
    public static final String NAME = "Serperior";
    public static final String TYPE_OF_POKEMON = "Regal";
    public static final String DESCRIPTION = "It can stop its opponents' movements with just a " +
            "glare. It takes in solar energy and boosts it internally.";
    public static final double HEIGHT = 3.3;
    public static final int BASE_EXP = 238;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 3};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 63;

    public static final Ability FIRST_ABILITY = new Ability.Overgrow();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.Contrary();

    //Base Stats
    public static final int BASE_HEALTH = 75;
    public static final int BASE_ATTACK = 75;
    public static final int BASE_DEFENSE = 95;
    public static final int BASE_SPECIAL_ATTACK = 75;
    public static final int BASE_SPECIAL_DEFENSE = 95;
    public static final int BASE_SPEED = 113;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/serperior.png";
    public static final String BACK_PATH = "battle/backs/unova/serperior.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/serperior.png";
    public static final String CRY_PATH = "sounds/cry/497.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/serperior.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GRASS;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a serperior
     */
    public Serperior() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init serperior's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.VINE_WHIP);
        beginnerSkills.add(SkillFactory.WRAP);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEER)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.VINE_WHIP)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.WRAP)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWTH)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEAF_TORNADO)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEECH_SEED)));
        levelUpSkills.put(24, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEGA_DRAIN)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLAM)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEAF_BLADE)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.COIL)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.GIGA_DRAIN)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.WRING_OUT)));
        levelUpSkills.put(56, new ArrayList<Integer>(Arrays.asList(SkillFactory.GASTRO_ACID)));
        levelUpSkills.put(62, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEAF_STORM)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.BRUTAL_SWING.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.DRAGON_TAIL.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init serperior's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .881) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }
}
