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

public class Garbodor extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 559;
    public static final String NAME = "Garbodor";
    public static final String TYPE_OF_POKEMON = "Trash Heap";
    public static final String DESCRIPTION = "Consuming garbage makes new kinds of poison gases" +
            " and liquids inside their bodies.";
    public static final double HEIGHT = 1.9;
    public static final int BASE_EXP = 166;
    public static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 60;
    public static final double WEIGHT = 107.3;

    public static final Ability FIRST_ABILITY = new Ability.Stench();
    public static final Ability SECOND_ABILITY = new Ability.WeakArmor();
    public static final Ability HIDDEN_ABILITY = new Ability.Aftermath();

    //Base Stats
    public static final int BASE_HEALTH = 80;
    public static final int BASE_ATTACK = 95;
    public static final int BASE_DEFENSE = 82;
    public static final int BASE_SPECIAL_ATTACK = 60;
    public static final int BASE_SPECIAL_DEFENSE = 82;
    public static final int BASE_SPEED = 75;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/garbodor.png";
    public static final String BACK_PATH = "battle/backs/unova/garbodor.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/garbodor.png";
    public static final String CRY_PATH = "sounds/cry/559.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/garbodor.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.POISON;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a garbodor
     */
    public Garbodor() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init garbodor's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.POUND);
        beginnerSkills.add(SkillFactory.POISON_GAS);
        //RECYCLE
        beginnerSkills.add(SkillFactory.TOXIC_SPIKES);
        levelUpSkills.put(0, beginnerSkills);
        //3 RECYCLE
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.TOXIC_SPIKES)));
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.ACID_SPRAY)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_SLAP)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLUDGE)));
        List<Integer> stockpileSkills = new ArrayList<Integer>();
        stockpileSkills.add(SkillFactory.STOCKPILE);
        stockpileSkills.add(SkillFactory.SWALLOW);
        levelUpSkills.put(23, stockpileSkills);
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLUDGE_BOMB)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.CLEAR_SMOG)));
        //39 TOXIC
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.AMNESIA)));
        //49 BELCH
        levelUpSkills.put(54, new ArrayList<Integer>(Arrays.asList(SkillFactory.GUNK_SHOT)));
        levelUpSkills.put(59, new ArrayList<Integer>(Arrays.asList(SkillFactory.EXPLOSION)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.VENOSHOCK.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.SMACK_DOWN.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SLUDGE_WAVE.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.EXPLOSION.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.ROCK_POLISH.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init garbodor's gender.
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
