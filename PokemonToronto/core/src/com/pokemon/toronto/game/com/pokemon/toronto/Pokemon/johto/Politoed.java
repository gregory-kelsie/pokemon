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

public class Politoed extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 186;
    private static final String NAME = "Politoed";
    private static final int BASE_EXP = 225;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 3, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 33.9;

    private static final Ability FIRST_ABILITY = new Ability.WaterAbsorb();
    private static final Ability SECOND_ABILITY = new Ability.Damp();
    private static final Ability HIDDEN_ABILITY = new Ability.Drizzle();

    //Base Stats
    private static final int BASE_HEALTH = 90;
    private static final int BASE_ATTACK = 75;
    private static final int BASE_DEFENSE = 75;
    private static final int BASE_SPECIAL_ATTACK = 90;
    private static final int BASE_SPECIAL_DEFENSE = 100;
    private static final int BASE_SPEED = 70;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/politoed.png";
    private static final String BACK_PATH = "battle/backs/johto/politoed.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/politoed.png";
    private static final String CRY_PATH = "sounds/cry/186.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/politoed.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.WATER;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a politoed
     */
    public Politoed() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init politoed's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.DOUBLE_SLAP);
        beginnerSkills.add(SkillFactory.BUBBLEBEAM);
        beginnerSkills.add(SkillFactory.HYPNOSIS);
        //PERISH SONG
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWAGGER)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.BOUNCE)));
        levelUpSkills.put(48, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_VOICE)));
    }

    /**
     * Init politoed's gender.
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
