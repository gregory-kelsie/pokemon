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

public class Cloyster extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 91;
    private static final String NAME = "Cloyster";
    private static final int BASE_EXP = 203;
    private static final int[] EV_YIELD = {0, 0, 2, 0, 0, 0};
    private static final int CAPTURE_RATE = 60;
    private static final double WEIGHT = 132.5;

    private static final Ability FIRST_ABILITY = new Ability.ShellArmor();
    private static final Ability SECOND_ABILITY = new Ability.SkillLink();
    private static final Ability HIDDEN_ABILITY = new Ability.Overcoat();

    //Base Stats
    private static final int BASE_HEALTH = 50;
    private static final int BASE_ATTACK = 95;
    private static final int BASE_DEFENSE = 180;
    private static final int BASE_SPECIAL_ATTACK = 85;
    private static final int BASE_SPECIAL_DEFENSE = 45;
    private static final int BASE_SPEED = 70;

    //Typing
    private static final Type TYPE_ONE = Type.WATER;
    private static final Type TYPE_TWO = Type.ICE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.SLOW;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/cloyster.png";
    private static final String BACK_PATH = "battle/backs/cloyster.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/cloyster.png";
    private static final String CRY_PATH = "sounds/cry/091.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/091.png";

    /**
     * Create a Cloyster
     */
    public Cloyster() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Cloyster's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.HYDRO_PUMP);
        beginnerSkills.add(SkillFactory.SHELL_SMASH);
        beginnerSkills.add(SkillFactory.TOXIC_SPIKES);
        beginnerSkills.add(SkillFactory.WITHDRAW);
        beginnerSkills.add(SkillFactory.SUPERSONIC);
        //TODO: PROTECT
        beginnerSkills.add(SkillFactory.AURORA_BEAM);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.SPIKE_CANNON)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.SPIKES)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICICLE_CRASH)));
    }
}
