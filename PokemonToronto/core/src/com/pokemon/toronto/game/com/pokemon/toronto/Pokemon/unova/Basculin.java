package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.unova;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-05-06.
 */

public class Basculin extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 550;
    public static final String NAME = "Basculin";
    public static final String TYPE_OF_POKEMON = "Hostile";
    public static final String DESCRIPTION = "Red and blue Basculin get along so poorly, " +
            "they'll start fighting instantly. These Pokémon are very hostile.";
    public static final double HEIGHT = 1;
    public static final int BASE_EXP = 161;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 2};
    public static final int CAPTURE_RATE = 25;
    public static final double WEIGHT = 18;

    public static final Ability FIRST_ABILITY = new Ability.Reckless();
    public static final Ability SECOND_ABILITY = new Ability.Adaptability();
    public static final Ability HIDDEN_ABILITY = new Ability.MoldBreaker();

    //Base Stats
    public static final int BASE_HEALTH = 70;
    public static final int BASE_ATTACK = 92;
    public static final int BASE_DEFENSE = 65;
    public static final int BASE_SPECIAL_ATTACK = 80;
    public static final int BASE_SPECIAL_DEFENSE = 55;
    public static final int BASE_SPEED = 98;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/basculin.png";
    public static final String BACK_PATH = "battle/backs/unova/basculin.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/basculin.png";
    public static final String CRY_PATH = "sounds/cry/550.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/basculin.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.WATER;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a basculin
     */
    public Basculin() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init basculin's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.WATER_GUN);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.UPROAR)));
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEADBUTT)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_JET)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHIP_AWAY)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_TAIL)));
        //23 SOAK
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCARY_FACE)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAIL)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.FINAL_GAMBIT)));
        levelUpSkills.put(42, new ArrayList<Integer>(Arrays.asList(SkillFactory.THRASH)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEAD_SMASH)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.SCALD.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.WATERFALL.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init basculin's gender.
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
