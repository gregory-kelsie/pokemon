package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-22.
 */

public class Yanma extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 193;
    private static final String NAME = "Yanma";
    private static final int BASE_EXP = 78;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    private static final int CAPTURE_RATE = 75;
    private static final double WEIGHT = 38;

    private static final Ability FIRST_ABILITY = new Ability.SpeedBoost();
    private static final Ability SECOND_ABILITY = new Ability.Compoundeyes();
    private static final Ability HIDDEN_ABILITY = new Ability.Frisk();

    //Base Stats
    private static final int BASE_HEALTH = 65;
    private static final int BASE_ATTACK = 65;
    private static final int BASE_DEFENSE = 45;
    private static final int BASE_SPECIAL_ATTACK = 75;
    private static final int BASE_SPECIAL_DEFENSE = 45;
    private static final int BASE_SPEED = 95;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/yanma.png";
    private static final String BACK_PATH = "battle/backs/johto/yanma.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/yanma.png";
    private static final String CRY_PATH = "sounds/cry/193.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/yanma.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.BUG;
    private static final Type TYPE_TWO = Type.FLYING;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a yanma
     */
    public Yanma() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init yanma's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        //FORESIGHT
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_TEAM)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.SONIC_BOOM)));
        //TODO DETECT 17
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPERSONIC)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.UPROAR)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.PURSUIT)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.ANCIENT_POWER)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPNOSIS)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.WING_ATTACK)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCREECH)));
        //TODO U-TURN 49
        levelUpSkills.put(54, new ArrayList<Integer>(Arrays.asList(SkillFactory.AIR_SLASH)));
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BUZZ)));
    }

    /**
     * Init yanma's gender.
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
