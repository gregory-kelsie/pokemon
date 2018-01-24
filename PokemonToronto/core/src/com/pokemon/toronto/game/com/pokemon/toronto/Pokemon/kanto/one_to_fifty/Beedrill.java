package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 8/16/2017.
 */

public class Beedrill extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 15;
    private static final String NAME = "Beedrill";
    private static final int BASE_EXP = 159;
    private static final int[] EV_YIELD = {0, 2, 0, 0, 1, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 29.5;

    private static final Ability FIRST_ABILITY = new Ability.Swarm();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = new Ability.Sniper();

    //Base Stats
    private static final int BASE_HEALTH = 65;
    private static final int BASE_ATTACK = 90;
    private static final int BASE_DEFENSE = 40;
    private static final int BASE_SPECIAL_ATTACK = 45;
    private static final int BASE_SPECIAL_DEFENSE = 80;
    private static final int BASE_SPEED = 75;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/beedrill.png";
    private static final String BACK_PATH = "battle/backs/beedrill.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/beedrill.png";
    private static final String CRY_PATH = "sounds/cry/015.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/015.png";

    /**
     * Create a Beedrill
     */
    public Beedrill() {
        super(NUMBER, NAME, Pokemon.Type.BUG, Pokemon.Type.POISON, Pokemon.ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Beedrill's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TWINEEDLE);
        beginnerSkills.add(SkillFactory.FURY_ATTACK);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_ATTACK)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAGE)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.PURSUIT)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.FOCUS_ENERGY)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.VENOSHOCK)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.ASSURANCE)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.TOXIC_SPIKES)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.PIN_MISSILE)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_JAB)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.ENDEAVOR)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.FELL_STINGER)));
    }
}
