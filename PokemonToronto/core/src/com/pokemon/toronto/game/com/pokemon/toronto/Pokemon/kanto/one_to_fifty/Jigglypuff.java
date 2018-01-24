package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 8/16/2017.
 */

public class Jigglypuff extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 39;
    private static final String NAME = "Jigglypuff";
    private static final int BASE_EXP = 76;
    private static final int[] EV_YIELD = {2, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 170;
    private static final double WEIGHT = 5.5;

    private static final Ability FIRST_ABILITY = new Ability.CuteCharm();
    private static final Ability SECOND_ABILITY = new Ability.Competitive();
    private static final Ability HIDDEN_ABILITY = new Ability.FriendGuard();

    //Base Stats
    private static final int BASE_HEALTH = 115;
    private static final int BASE_ATTACK = 45;
    private static final int BASE_DEFENSE = 20;
    private static final int BASE_SPECIAL_ATTACK = 45;
    private static final int BASE_SPECIAL_DEFENSE = 25;
    private static final int BASE_SPEED = 20;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/jigglypuff.png";
    private static final String BACK_PATH = "battle/backs/jigglypuff.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/jigglypuff.png";
    private static final String CRY_PATH = "sounds/cry/039.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/039.png";

    /**
     * Create a Jigglypuff
     */
    public Jigglypuff() {
        super(NUMBER, NAME, Pokemon.Type.NORMAL, Pokemon.Type.FAIRY, ExpType.FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .75) {
            gender = 'F';
        } else {
            gender = 'M';
        }
    }

    /**
     * Init Jigglypuff's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SING);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.DEFENSE_CURL)));
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.POUND)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.PLAY_NICE)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISARMING_VOICE)));
        //TODO: DISABLE 14
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_SLAP)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROLLOUT)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROUND)));
        ArrayList<Integer> stockpileSkills = new ArrayList<Integer>();
        stockpileSkills.add(SkillFactory.STOCKPILE);
        stockpileSkills.add(SkillFactory.SWALLOW);
        stockpileSkills.add(SkillFactory.SPIT_UP);
        levelUpSkills.put(25, stockpileSkills);
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.WAKE_UP_SLAP)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.REST)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.BODY_SLAM)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.GYRO_BALL)));
        //TODO: MIMIC 38
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_VOICE)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
    }

    /**
     * Return Wigglytuff's id when a Moon Stone is used
     * on Jigglypuff.
     * @return Wigglytuff's id.
     */
    @Override
    public int getMoonStoneEvolutionId() {
        return PokemonId.WIGGLYTUFF.getValue();
    }
}
