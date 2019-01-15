package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kalos;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-02-02.
 */

public class Skrelp extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 690;
    public static final String NAME = "Skrelp";
    public static final String TYPE_OF_POKEMON = "Mock Kelp";
    public static final String DESCRIPTION = "It looks just like rotten kelp. It hides from " +
            "foes while storing up power for its evolution.";
    public static final double HEIGHT = 0.5;
    public static final int BASE_EXP = 64;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 1, 0};
    public static final int CAPTURE_RATE = 225;
    public static final double WEIGHT = 7.3;

    public static final Ability FIRST_ABILITY = new Ability.PoisonPoint();
    public static final Ability SECOND_ABILITY = new Ability.PoisonTouch();
    public static final Ability HIDDEN_ABILITY = new Ability.Adaptability();

    //Base Stats
    public static final int BASE_HEALTH = 50;
    public static final int BASE_ATTACK = 60;
    public static final int BASE_DEFENSE = 60;
    public static final int BASE_SPECIAL_ATTACK = 60;
    public static final int BASE_SPECIAL_DEFENSE = 60;
    public static final int BASE_SPEED = 30;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/skrelp.png";
    public static final String BACK_PATH = "battle/backs/kalos/skrelp.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/skrelp.png";
    public static final String CRY_PATH = "sounds/cry/690.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/skrelp.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.POISON;
    public static final Type TYPE_TWO = Type.WATER;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a skrelp
     */
    public Skrelp() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init skrelp's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.WATER_GUN);
        beginnerSkills.add(SkillFactory.SMOKESCREEN);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT_ATTACK)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAIL_WHIP)));
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUBBLE)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.ACID)));
        //19 CAMOUFLAGE
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_TAIL)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_PULSE)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_TEAM)));
        //32 TOXIC
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_TAIL)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLUDGE_BOMB)));
        levelUpSkills.put(42, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYDRO_PUMP)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_PULSE)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.VENOSHOCK.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SLUDGE_WAVE.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
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
     * Init skrelp's gender.
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
     * Return Dragalge if the skrelp is above level 48.
     * @return Dragalge if skrelp is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 48) {
            return PokemonId.DRAGALGE.getValue();
        }
        return -1;
    }
}
