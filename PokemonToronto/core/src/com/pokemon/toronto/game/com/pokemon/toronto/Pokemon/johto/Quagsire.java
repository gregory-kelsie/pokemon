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

public class Quagsire extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 195;
    private static final String NAME = "Quagsire";
    private static final int BASE_EXP = 151;
    private static final int[] EV_YIELD = {2, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 255;
    private static final double WEIGHT = 75;

    private static final Ability FIRST_ABILITY = new Ability.Damp();
    private static final Ability SECOND_ABILITY = new Ability.WaterAbsorb();
    private static final Ability HIDDEN_ABILITY = new Ability.Unaware();

    //Base Stats
    private static final int BASE_HEALTH = 95;
    private static final int BASE_ATTACK = 85;
    private static final int BASE_DEFENSE = 85;
    private static final int BASE_SPECIAL_ATTACK = 65;
    private static final int BASE_SPECIAL_DEFENSE = 65;
    private static final int BASE_SPEED = 35;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/quagsire.png";
    private static final String BACK_PATH = "battle/backs/johto/quagsire.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/quagsire.png";
    private static final String CRY_PATH = "sounds/cry/195.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/quagsire.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.WATER;
    private static final Type TYPE_TWO = Type.GROUND;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.FAST;

    /**
     * Create a quagsire
     */
    public Quagsire() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init quagsire's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
        beginnerSkills.add(SkillFactory.WATER_GUN);
        //MUD SPORT
        levelUpSkills.put(0, beginnerSkills);
        //TODO MUD SPORT 5
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_SHOT)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLAM)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_BOMB)));
        levelUpSkills.put(24, new ArrayList<Integer>(Arrays.asList(SkillFactory.AMNESIA)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.YAWN)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.EARTHQUAKE)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAIN_DANCE)));
        List<Integer> icyMoves = new ArrayList<Integer>();
        icyMoves.add(SkillFactory.MIST);
        icyMoves.add(SkillFactory.HAZE);
        levelUpSkills.put(48, icyMoves);
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUDDY_WATER)));
    }

    /**
     * Init quagsire's gender.
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
