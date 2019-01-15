package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.unova;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-05-07.
 */

public class Escavalier extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 589;
    public static final String NAME = "Escavalier";
    public static final String TYPE_OF_POKEMON = "Cavalry";
    public static final String DESCRIPTION = "They fly around at high speed, striking with their" +
            " pointed spears. Even when in trouble, they face opponents bravely.";
    public static final double HEIGHT = 1;
    public static final int BASE_EXP = 173;
    public static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 75;
    public static final double WEIGHT = 33;

    public static final Ability FIRST_ABILITY = new Ability.Swarm();
    public static final Ability SECOND_ABILITY = new Ability.ShellArmor();
    public static final Ability HIDDEN_ABILITY = new Ability.Overcoat();

    //Base Stats
    public static final int BASE_HEALTH = 70;
    public static final int BASE_ATTACK = 135;
    public static final int BASE_DEFENSE = 105;
    public static final int BASE_SPECIAL_ATTACK = 60;
    public static final int BASE_SPECIAL_DEFENSE = 105;
    public static final int BASE_SPEED = 20;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/escavalier.png";
    public static final String BACK_PATH = "battle/backs/unova/escavalier.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/escavalier.png";
    public static final String CRY_PATH = "sounds/cry/589.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/escavalier.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.BUG;
    public static final Type TYPE_TWO = Type.STEEL;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a escavalier
     */
    public Escavalier() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init escavalier's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.DOUBLE_EDGE);
        beginnerSkills.add(SkillFactory.FELL_STINGER);
        beginnerSkills.add(SkillFactory.PECK);
        beginnerSkills.add(SkillFactory.LEER);
        //QUICK GUARD
        beginnerSkills.add(SkillFactory.TWINEEDLE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEER)));
        //8 QUICK GUARD
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.TWINEEDLE)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_ATTACK)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEADBUTT)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.FALSE_SWIPE)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BUZZ)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.IRON_HEAD)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.IRON_DEFENSE)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.X_SCISSOR)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.REVERSAL)));
        levelUpSkills.put(52, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWORDS_DANCE)));
        levelUpSkills.put(56, new ArrayList<Integer>(Arrays.asList(SkillFactory.GIGA_IMPACT)));
        levelUpSkills.put(60, new ArrayList<Integer>(Arrays.asList(SkillFactory.FELL_STINGER)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.FALSE_SWIPE.getValue());
        tmSkills.add(TmId.BRUTAL_SWING.getValue());
        tmSkills.add(TmId.SMART_STRIKE.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.X_SCISSOR.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.POISON_JAB.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init escavalier's gender.
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
