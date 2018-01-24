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

public class Lapras extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 131;
    private static final String NAME = "Lapras";
    private static final int BASE_EXP = 219;
    private static final int[] EV_YIELD = {2, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 220;

    private static final Ability FIRST_ABILITY = new Ability.WaterAbsorb();
    private static final Ability SECOND_ABILITY = new Ability.ShellArmor();
    private static final Ability HIDDEN_ABILITY = new Ability.Hydration();

    //Base Stats
    private static final int BASE_HEALTH = 130;
    private static final int BASE_ATTACK = 85;
    private static final int BASE_DEFENSE = 80;
    private static final int BASE_SPECIAL_ATTACK = 85;
    private static final int BASE_SPECIAL_DEFENSE = 95;
    private static final int BASE_SPEED = 60;

    //Typing
    private static final Type TYPE_ONE = Type.WATER;
    private static final Type TYPE_TWO = Type.ICE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.SLOW;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/lapras.png";
    private static final String BACK_PATH = "battle/backs/lapras.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/lapras.png";
    private static final String CRY_PATH = "sounds/cry/131.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/131.png";

    /**
     * Create a Lapras
     */
    public Lapras() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Lapras's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SING);
        beginnerSkills.add(SkillFactory.GROWL);
        beginnerSkills.add(SkillFactory.WATER_GUN);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.MIST)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONFUSE_RAY)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICE_SHARD)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_PULSE)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.BODY_SLAM)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAIN_DANCE)));
        //TODO: PERISH SONG 27
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICE_BEAM)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.BRINE)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAFEGUARD)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYDRO_PUMP)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHEER_COLD)));
    }
}
