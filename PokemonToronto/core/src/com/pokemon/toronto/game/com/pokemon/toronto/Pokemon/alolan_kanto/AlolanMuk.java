package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 10/27/2017.
 */

public class AlolanMuk extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = -89;
    private static final String NAME = "Muk";
    private static final int BASE_EXP = 157;
    private static final int[] EV_YIELD = {1, 1, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 75;
    private static final double WEIGHT = 52;

    private static final Ability FIRST_ABILITY = new Ability.PoisonTouch();
    private static final Ability SECOND_ABILITY = new Ability.Gluttony();
    private static final Ability HIDDEN_ABILITY = new Ability.PowerOfAlchemy();

    //Base Stats
    private static final int BASE_HEALTH = 105;
    private static final int BASE_ATTACK = 105;
    private static final int BASE_DEFENSE = 75;
    private static final int BASE_SPECIAL_ATTACK = 65;
    private static final int BASE_SPECIAL_DEFENSE = 100;
    private static final int BASE_SPEED = 50;

    //Typing
    private static final Type TYPE_ONE = Type.POISON;
    private static final Type TYPE_TWO = Type.DARK;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/alolan_kanto/muk.png";
    private static final String BACK_PATH = "battle/backs/alolan_kanto/muk.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/alolan_kanto/muk.png";
    private static final String CRY_PATH = "sounds/cry/089.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/alolan_kanto/alolanmuk.png";

    /**
     * Create a Muk
     */
    public AlolanMuk() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Muk's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.POUND);
        beginnerSkills.add(SkillFactory.POISON_GAS);
        beginnerSkills.add(SkillFactory.HARDEN);
        beginnerSkills.add(SkillFactory.BITE);

        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.HARDEN)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        //TODO: DISABLE 12
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.ACID_SPRAY)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_FANG)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.MINIMIZE)));
        //TODO: FLING 26
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.KNOCK_OFF)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCREECH)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.GUNK_SHOT)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.ACID_ARMOR)));
        //TODO: BELCH 52
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEMENTO)));
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.VENOM_DRENCH);
    }
}
