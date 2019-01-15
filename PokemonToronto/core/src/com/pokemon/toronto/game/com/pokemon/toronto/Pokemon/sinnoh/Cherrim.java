package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-24.
 */

public class Cherrim extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 421;
    public static final String NAME = "Cherrim";
    public static final String TYPE_OF_POKEMON = "Blossom";
    public static final String DESCRIPTION = "If it senses strong sunlight, it opens its folded " +
            "petals to absorb the sun's rays with its whole body.";
    public static final double HEIGHT = 0.5;
    public static final int BASE_EXP = 158;
    public static final int[] EV_YIELD = {0, 0, 0, 2, 0, 0};
    public static final int CAPTURE_RATE = 75;
    public static final double WEIGHT = 9.3;

    public static final Ability FIRST_ABILITY = new Ability.FlowerGift();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 70;
    public static final int BASE_ATTACK = 60;
    public static final int BASE_DEFENSE = 70;
    public static final int BASE_SPECIAL_ATTACK = 87;
    public static final int BASE_SPECIAL_DEFENSE = 78;
    public static final int BASE_SPEED = 85;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/cherrim.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/cherrim.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/cherrim.png";
    public static final String CRY_PATH = "sounds/cry/421.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/cherrim.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GRASS;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a cherrim
     */
    public Cherrim() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init cherrim's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.MORNING_SUN);
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.GROWTH);
        beginnerSkills.add(SkillFactory.LEECH_SEED);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWTH)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEECH_SEED)));
        //13 HELPING HAND
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.MAGICAL_LEAF)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUNNY_DAY)));
        //30 WORRY SEED
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.SOLAR_BEAM)));
        //48 LUCKY CHANT
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.PETAL_BLIZZARD)));
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.PETAL_DANCE);
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.DAZZLING_GLEAM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init cherrim's gender.
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
