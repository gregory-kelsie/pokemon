package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-29.
 */

public class Carnivine extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 455;
    public static final String NAME = "Carnivine";
    public static final String TYPE_OF_POKEMON = "Bug Catcher";
    public static final String DESCRIPTION = "It binds itself to trees in marshes. It attracts " +
            "prey with its sweet- smelling drool and gulps them down.";
    public static final double HEIGHT = 1.4;
    public static final int BASE_EXP = 159;
    public static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 200;
    public static final double WEIGHT = 27;

    public static final Ability FIRST_ABILITY = new Ability.Levitate();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 74;
    public static final int BASE_ATTACK = 100;
    public static final int BASE_DEFENSE = 72;
    public static final int BASE_SPECIAL_ATTACK = 90;
    public static final int BASE_SPECIAL_DEFENSE = 72;
    public static final int BASE_SPEED = 46;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/carnivine.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/carnivine.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/carnivine.png";
    public static final String CRY_PATH = "sounds/cry/455.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/carnivine.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GRASS;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a carnivine
     */
    public Carnivine() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init carnivine's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.BIND);
        beginnerSkills.add(SkillFactory.GROWTH);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.VINE_WHIP)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWEET_SCENT)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.INGRAIN)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT_ATTACK)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEAF_TORNADO)));
        List<Integer> stockpileSkills = new ArrayList<Integer>();
        stockpileSkills.add(SkillFactory.STOCKPILE);
        stockpileSkills.add(SkillFactory.SPIT_UP);
        stockpileSkills.add(SkillFactory.SWALLOW);
        levelUpSkills.put(37, stockpileSkills);
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.WRING_OUT)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.POWER_WHIP)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init carnivine's gender.
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
