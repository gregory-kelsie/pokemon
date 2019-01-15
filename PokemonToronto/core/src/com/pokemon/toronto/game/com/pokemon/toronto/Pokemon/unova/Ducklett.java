package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.unova;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-05-07.
 */

public class Ducklett extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 580;
    public static final String NAME = "Ducklett";
    public static final String TYPE_OF_POKEMON = "Water Bird";
    public static final String DESCRIPTION = "When attacked, it uses its feathers to splash " +
            "water, escaping under cover of the spray.";
    public static final double HEIGHT = 0.5;
    public static final int BASE_EXP = 61;
    public static final int[] EV_YIELD = {1, 0, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 190;
    public static final double WEIGHT = 5.5;

    public static final Ability FIRST_ABILITY = new Ability.KeenEye();
    public static final Ability SECOND_ABILITY = new Ability.BigPecks();
    public static final Ability HIDDEN_ABILITY = new Ability.Hydration();

    //Base Stats
    public static final int BASE_HEALTH = 62;
    public static final int BASE_ATTACK = 44;
    public static final int BASE_DEFENSE = 50;
    public static final int BASE_SPECIAL_ATTACK = 44;
    public static final int BASE_SPECIAL_DEFENSE = 50;
    public static final int BASE_SPEED = 55;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/ducklett.png";
    public static final String BACK_PATH = "battle/backs/unova/ducklett.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/ducklett.png";
    public static final String CRY_PATH = "sounds/cry/580.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/ducklett.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.WATER;
    public static final Type TYPE_TWO = Type.FLYING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a ducklett
     */
    public Ducklett() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init ducklett's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.WATER_GUN);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_SPORT)));
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.DEFOG)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.WING_ATTACK)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_PULSE)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.AERIAL_ACE)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUBBLEBEAM)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEATHER_DANCE)));
        levelUpSkills.put(24, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_RING)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.AIR_SLASH)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROOST)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAIN_DANCE)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAILWIND)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.BRAVE_BIRD)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.HURRICANE)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.ROOST.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.STEEL_WING.getValue());
        tmSkills.add(TmId.SCALD.getValue());
        tmSkills.add(TmId.FLY.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init ducklett's gender.
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
     * Return Swanna if the ducklett is above level 35.
     * @return Swanna if ducklett is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 35) {
            return PokemonId.SWANNA.getValue();
        }
        return -1;
    }
}
