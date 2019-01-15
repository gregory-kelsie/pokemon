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
 * Created by gregorykelsie on 2018-05-06.
 */

public class Cottonee extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 546;
    public static final String NAME = "Cottonee";
    public static final String TYPE_OF_POKEMON = "Cotton Puff";
    public static final String DESCRIPTION = "Perhaps because they feel more at ease in a group," +
            " they stick to others they find. They end up looking like a cloud.";
    public static final double HEIGHT = 0.3;
    public static final int BASE_EXP = 56;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    public static final int CAPTURE_RATE = 190;
    public static final double WEIGHT = 0.6;

    public static final Ability FIRST_ABILITY = new Ability.Prankster();
    public static final Ability SECOND_ABILITY = new Ability.Infiltrator();
    public static final Ability HIDDEN_ABILITY = new Ability.Chlorophyll();

    //Base Stats
    public static final int BASE_HEALTH = 40;
    public static final int BASE_ATTACK = 27;
    public static final int BASE_DEFENSE = 60;
    public static final int BASE_SPECIAL_ATTACK = 37;
    public static final int BASE_SPECIAL_DEFENSE = 50;
    public static final int BASE_SPEED = 66;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/cottonee.png";
    public static final String BACK_PATH = "battle/backs/unova/cottonee.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/cottonee.png";
    public static final String CRY_PATH = "sounds/cry/546.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/cottonee.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GRASS;
    public static final Type TYPE_TWO = Type.FAIRY;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a cottonee
     */
    public Cottonee() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init cottonee's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.ABSORB);
        beginnerSkills.add(SkillFactory.FAIRY_WIND);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWTH)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEECH_SEED)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.STUN_SPORE)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEGA_DRAIN)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.COTTON_SPORE)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_LEAF)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_POWDER)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.GIGA_DRAIN)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARM)));
        //31 HELPING HAND
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.ENERGY_BALL)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.COTTON_GUARD)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUNNY_DAY)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.ENDEAVOR)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.SOLAR_BEAM)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
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
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.DAZZLING_GLEAM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init cottonee's gender.
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
    public int getSunStoneEvolutionId() {
        return PokemonId.WHIMSICOTT.getValue();
    }
}
