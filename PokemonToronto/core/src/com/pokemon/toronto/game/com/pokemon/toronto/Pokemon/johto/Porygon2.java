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

public class Porygon2 extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 233;
    private static final String NAME = "Porygon2";
    private static final int BASE_EXP = 180;
    private static final int[] EV_YIELD = {0, 0, 0, 2, 0, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 32.5;

    private static final Ability FIRST_ABILITY = new Ability.Trace();
    private static final Ability SECOND_ABILITY = new Ability.Download();
    private static final Ability HIDDEN_ABILITY = new Ability.Analytic();

    //Base Stats
    private static final int BASE_HEALTH = 85;
    private static final int BASE_ATTACK = 80;
    private static final int BASE_DEFENSE = 90;
    private static final int BASE_SPECIAL_ATTACK = 105;
    private static final int BASE_SPECIAL_DEFENSE = 95;
    private static final int BASE_SPEED = 60;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/porygon2.png";
    private static final String BACK_PATH = "battle/backs/johto/porygon2.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/porygon2.png";
    private static final String CRY_PATH = "sounds/cry/233.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/porygon2.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a porygon2
     */
    public Porygon2() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init porygon2's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.ZAP_CANNON);
        //MAGIC COAT
        //CONVERSION 2
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.CONVERSION);
        beginnerSkills.add(SkillFactory.DEFENSE_CURL);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYBEAM)));
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.RECOVER)));
        //TODO MAGNET RISE 23
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.SIGNAL_BEAM)));
        //TODO RECYCLE  34
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISCHARGE)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.LOCK_ON)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.TRI_ATTACK)));
        //TODO MAGIC COAT 56
        levelUpSkills.put(62, new ArrayList<Integer>(Arrays.asList(SkillFactory.ZAP_CANNON)));
        levelUpSkills.put(67, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_BEAM)));
    }

}
