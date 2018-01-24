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

public class Marill extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 183;
    private static final String NAME = "Marill";
    private static final int BASE_EXP = 88;
    private static final int[] EV_YIELD = {2, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 190;
    private static final double WEIGHT = 8.5;

    private static final Ability FIRST_ABILITY = new Ability.ThickFat();
    private static final Ability SECOND_ABILITY = new Ability.HugePower();
    private static final Ability HIDDEN_ABILITY = new Ability.SapSipper();

    //Base Stats
    private static final int BASE_HEALTH = 70;
    private static final int BASE_ATTACK = 20;
    private static final int BASE_DEFENSE = 50;
    private static final int BASE_SPECIAL_ATTACK = 20;
    private static final int BASE_SPECIAL_DEFENSE = 50;
    private static final int BASE_SPEED = 40;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/marill.png";
    private static final String BACK_PATH = "battle/backs/johto/marill.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/marill.png";
    private static final String CRY_PATH = "sounds/cry/183.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/marill.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.WATER;
    private static final Type TYPE_TWO = Type.FAIRY;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.FAST;

    /**
     * Create a marill
     */
    public Marill() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init marill's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.WATER_GUN);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(2, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAIL_WHIP)));
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_SPORT)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUBBLE)));
        List<Integer> rollingMoves = new ArrayList<Integer>();
        rollingMoves.add(SkillFactory.DEFENSE_CURL);
        rollingMoves.add(SkillFactory.ROLLOUT);
        levelUpSkills.put(10, rollingMoves);
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUBBLEBEAM)));
        //HELPING HAND 16
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_TAIL)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.PLAY_ROUGH)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_RING)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAIN_DANCE)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPERPOWER)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYDRO_PUMP)));
    }

    /**
     * Init marill's gender.
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
     * Return Azumarill if the marill is above level 18.
     * @return Azumarill if marill is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 18) {
            return PokemonId.AZUMARILL.getValue();
        }
        return -1;
    }
}
