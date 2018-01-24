package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/16/2017.
 */

public class Victreebel extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 71;
    private static final String NAME = "Victreebel";
    private static final int BASE_EXP = 191;
    private static final int[] EV_YIELD = {0, 3, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 15.5;

    private static final Ability FIRST_ABILITY = new Ability.Chlorophyll();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = new Ability.Gluttony();

    //Base Stats
    private static final int BASE_HEALTH = 80;
    private static final int BASE_ATTACK = 105;
    private static final int BASE_DEFENSE = 65;
    private static final int BASE_SPECIAL_ATTACK = 100;
    private static final int BASE_SPECIAL_DEFENSE = 70;
    private static final int BASE_SPEED = 70;

    //Typing
    private static final Type TYPE_ONE = Type.GRASS;
    private static final Type TYPE_TWO = Type.POISON;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/victreebel.png";
    private static final String BACK_PATH = "battle/backs/victreebel.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/victreebel.png";
    private static final String CRY_PATH = "sounds/cry/071.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/071.png";

    /**
     * Create a Victreebel
     */
    public Victreebel() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Victreebel's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.STOCKPILE);
        beginnerSkills.add(SkillFactory.SWALLOW);
        beginnerSkills.add(SkillFactory.SPIT_UP);
        beginnerSkills.add(SkillFactory.VINE_WHIP);
        beginnerSkills.add(SkillFactory.SLEEP_POWDER);
        beginnerSkills.add(SkillFactory.SWEET_SCENT);
        beginnerSkills.add(SkillFactory.RAZOR_LEAF);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEAF_STORM)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEAF_BLADE)));
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.LEAF_TORNADO);
    }
}
