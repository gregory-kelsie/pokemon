package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kalos;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-02-02.
 */

public class Dragalge extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 690;
    public static final String NAME = "Dragalge";
    public static final String TYPE_OF_POKEMON = "Mock Kelp";
    public static final String DESCRIPTION = "Their poison is strong enough to eat through the " +
            "hull of a tanker, and they spit it indiscriminately at anything that enters their " +
            "territory.";
    public static final double HEIGHT = 1.8;
    public static final int BASE_EXP = 173;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 2, 0};
    public static final int CAPTURE_RATE = 55;
    public static final double WEIGHT = 81.5;

    public static final Ability FIRST_ABILITY = new Ability.PoisonPoint();
    public static final Ability SECOND_ABILITY = new Ability.PoisonTouch();
    public static final Ability HIDDEN_ABILITY = new Ability.Adaptability();

    //Base Stats
    public static final int BASE_HEALTH = 65;
    public static final int BASE_ATTACK = 75;
    public static final int BASE_DEFENSE = 90;
    public static final int BASE_SPECIAL_ATTACK = 97;
    public static final int BASE_SPECIAL_DEFENSE = 123;
    public static final int BASE_SPEED = 44;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/dragalge.png";
    public static final String BACK_PATH = "battle/backs/kalos/dragalge.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/dragalge.png";
    public static final String CRY_PATH = "sounds/cry/690.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/dragalge.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.POISON;
    public static final Type TYPE_TWO = Type.DRAGON;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a dragalge
     */
    public Dragalge() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init dragalge's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.WATER_GUN);
        beginnerSkills.add(SkillFactory.SMOKESCREEN);
        beginnerSkills.add(SkillFactory.FEINT_ATTACK);
        //DRAGON TAIL
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
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_PULSE)));
        //59 DRAGON TAIL
        initEvolutionSkills();
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.VENOSHOCK.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SLUDGE_WAVE.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.SCALD.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.DRAGON_TAIL.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.WATERFALL.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.TWISTER);
    }

    /**
     * Init dragalge's gender.
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
