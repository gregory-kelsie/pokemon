package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/21/2017.
 */

public class Starmie extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 121;
    private static final String NAME = "Starmie";
    private static final int BASE_EXP = 207;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 2};
    private static final int CAPTURE_RATE = 60;
    private static final double WEIGHT = 80;

    private static final Ability FIRST_ABILITY = new Ability.Illuminate();
    private static final Ability SECOND_ABILITY = new Ability.NaturalCure();
    private static final Ability HIDDEN_ABILITY = new Ability.Analytic();

    //Base Stats
    private static final int BASE_HEALTH = 60;
    private static final int BASE_ATTACK = 75;
    private static final int BASE_DEFENSE = 85;
    private static final int BASE_SPECIAL_ATTACK = 100;
    private static final int BASE_SPECIAL_DEFENSE = 85;
    private static final int BASE_SPEED = 115;

    //Typing
    private static final Type TYPE_ONE = Type.WATER;
    private static final Type TYPE_TWO = Type.PSYCHIC;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.SLOW;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/starmie.png";
    private static final String BACK_PATH = "battle/backs/starmie.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/starmie.png";
    private static final String CRY_PATH = "sounds/cry/121.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/121.png";

    /**
     * Create a Starmie
     */
    public Starmie() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Starmie's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.HYDRO_PUMP);
        beginnerSkills.add(SkillFactory.WATER_GUN);
        beginnerSkills.add(SkillFactory.RAPID_SPIN);
        beginnerSkills.add(SkillFactory.RECOVER);
        beginnerSkills.add(SkillFactory.SWIFT);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONFUSE_RAY)));
    }
    
}
