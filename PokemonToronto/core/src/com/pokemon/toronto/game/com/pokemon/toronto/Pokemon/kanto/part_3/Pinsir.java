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

public class Pinsir extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 127;
    private static final String NAME = "Pinsir";
    private static final int BASE_EXP = 200;
    private static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 55;

    private static final Ability FIRST_ABILITY = new Ability.HyperCutter();
    private static final Ability SECOND_ABILITY = new Ability.MoldBreaker();
    private static final Ability HIDDEN_ABILITY = new Ability.Moxie();

    //Base Stats
    private static final int BASE_HEALTH = 65;
    private static final int BASE_ATTACK = 125;
    private static final int BASE_DEFENSE = 100;
    private static final int BASE_SPECIAL_ATTACK = 55;
    private static final int BASE_SPECIAL_DEFENSE = 70;
    private static final int BASE_SPEED = 85;

    //Typing
    private static final Type TYPE_ONE = Type.BUG;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.SLOW;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/pinsir.png";
    private static final String BACK_PATH = "battle/backs/pinsir.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/pinsir.png";
    private static final String CRY_PATH = "sounds/cry/127.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/127.png";

    /**
     * Create a Pinsir
     */
    public Pinsir() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Pinsir's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.VICEGRIP);
        beginnerSkills.add(SkillFactory.FOCUS_ENERGY);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.BIND)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.SEISMIC_TOSS)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.HARDEN)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.REVENGE)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.VITAL_THROW)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_HIT)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.BRICK_BREAK)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.X_SCISSOR)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUBMISSION)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.STORM_THROW)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWORDS_DANCE)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.THRASH)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPERPOWER)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.GUILLOTINE)));
    }
}
