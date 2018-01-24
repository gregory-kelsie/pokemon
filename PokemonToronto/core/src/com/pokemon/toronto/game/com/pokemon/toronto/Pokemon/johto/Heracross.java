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

public class Heracross extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 214;
    private static final String NAME = "Heracross";
    private static final int BASE_EXP = 175;
    private static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 54;

    private static final Ability FIRST_ABILITY = new Ability.Swarm();
    private static final Ability SECOND_ABILITY = new Ability.Guts();
    private static final Ability HIDDEN_ABILITY = new Ability.Moxie();

    //Base Stats
    private static final int BASE_HEALTH = 80;
    private static final int BASE_ATTACK = 125;
    private static final int BASE_DEFENSE = 75;
    private static final int BASE_SPECIAL_ATTACK = 40;
    private static final int BASE_SPECIAL_DEFENSE = 95;
    private static final int BASE_SPEED = 85;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/heracross.png";
    private static final String BACK_PATH = "battle/backs/johto/heracross.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/heracross.png";
    private static final String CRY_PATH = "sounds/cry/214.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/heracross.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.BUG;
    private static final Type TYPE_TWO = Type.FIGHTING;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a heracross
     */
    public Heracross() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init heracross's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.HORN_ATTACK);
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.LEER);
        //ENDURE
        beginnerSkills.add(SkillFactory.ARM_THRUST);
        beginnerSkills.add(SkillFactory.BULLET_SEED);
        beginnerSkills.add(SkillFactory.NIGHT_SLASH);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.AERIAL_ACE)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHIP_AWAY)));
        //TODO COUNTER 19
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_ATTACK)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.BRICK_BREAK)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.PIN_MISSILE)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEGAHORN)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.CLOSE_COMBAT)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.REVERSAL)));
    }

    /**
     * Init heracross's gender.
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
