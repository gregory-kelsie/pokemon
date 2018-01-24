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

public class Hitmonlee extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 106;
    private static final String NAME = "Hitmonlee";
    private static final int BASE_EXP = 139;
    private static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 49.8;

    private static final Ability FIRST_ABILITY = new Ability.Limber();
    private static final Ability SECOND_ABILITY = new Ability.Reckless();
    private static final Ability HIDDEN_ABILITY = new Ability.Unburden();

    //Base Stats
    private static final int BASE_HEALTH = 50;
    private static final int BASE_ATTACK = 120;
    private static final int BASE_DEFENSE = 53;
    private static final int BASE_SPECIAL_ATTACK = 35;
    private static final int BASE_SPECIAL_DEFENSE = 110;
    private static final int BASE_SPEED = 87;

    //Typing
    private static final Type TYPE_ONE = Type.FIGHTING;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/hitmonlee.png";
    private static final String BACK_PATH = "battle/backs/hitmonlee.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/hitmonlee.png";
    private static final String CRY_PATH = "sounds/cry/106.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/106.png";

    /**
     * Create a Hitmonlee
     */
    public Hitmonlee() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    @Override
    protected void initGender() {
        gender = 'M';
    }

    /**
     * Init Hitmonlee's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.REVERSAL);
        beginnerSkills.add(SkillFactory.CLOSE_COMBAT);
        beginnerSkills.add(SkillFactory.MEGA_KICK);
        beginnerSkills.add(SkillFactory.REVENGE);
        beginnerSkills.add(SkillFactory.MEDITATE);
        beginnerSkills.add(SkillFactory.ROLLING_KICK);
        beginnerSkills.add(SkillFactory.JUMP_KICK);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEDITATE)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROLLING_KICK)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.JUMP_KICK)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.BRICK_BREAK)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.FOCUS_ENERGY)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.HIGH_JUMP_KICK)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.MIND_READER)));
        //TODO: FORESIGHT 37
        //TODO: WIDE GUARD 41
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.BLAZE_KICK)));
        //TODO: ENDURE 49
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEGA_KICK)));
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.CLOSE_COMBAT)));
        levelUpSkills.put(61, new ArrayList<Integer>(Arrays.asList(SkillFactory.REVERSAL)));
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.DOUBLE_KICK);
    }
}
