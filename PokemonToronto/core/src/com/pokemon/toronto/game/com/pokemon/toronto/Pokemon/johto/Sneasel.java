package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-22.
 */

public class Sneasel extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 215;
    private static final String NAME = "Sneasel";
    private static final int BASE_EXP = 86;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    private static final int CAPTURE_RATE = 60;
    private static final double WEIGHT = 28;

    private static final Ability FIRST_ABILITY = new Ability.InnerFocus();
    private static final Ability SECOND_ABILITY = new Ability.KeenEye();
    private static final Ability HIDDEN_ABILITY = new Ability.Pickpocket();

    //Base Stats
    private static final int BASE_HEALTH = 55;
    private static final int BASE_ATTACK = 95;
    private static final int BASE_DEFENSE = 55;
    private static final int BASE_SPECIAL_ATTACK = 35;
    private static final int BASE_SPECIAL_DEFENSE = 75;
    private static final int BASE_SPEED = 115;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/sneasel.png";
    private static final String BACK_PATH = "battle/backs/johto/sneasel.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/sneasel.png";
    private static final String CRY_PATH = "sounds/cry/215.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/sneasel.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.DARK;
    private static final Type TYPE_TWO = Type.ICE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a sneasel
     */
    public Sneasel() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init sneasel's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SCRATCH);
        beginnerSkills.add(SkillFactory.LEER);
        //TAUNT
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT_ATTACK)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICY_WIND)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_SWIPES)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.METAL_CLAW)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.HONE_CLAWS)));
        //TODO BEAT UP 28
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCREECH)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        //TODO SNATCH 40
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.PUNISHMENT)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICE_SHARD)));
    }

    /**
     * Init sneasel's gender.
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
