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

public class Nidoqueen extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 31;
    private static final String NAME = "Nidoqueen";
    private static final int BASE_EXP = 194;
    private static final int[] EV_YIELD = {3, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 60;

    private static final Ability FIRST_ABILITY = new Ability.PoisonPoint();
    private static final Ability SECOND_ABILITY = new Ability.Rivalry();
    private static final Ability HIDDEN_ABILITY = new Ability.SheerForce();

    //Base Stats
    private static final int BASE_HEALTH = 90;
    private static final int BASE_ATTACK = 92;
    private static final int BASE_DEFENSE = 87;
    private static final int BASE_SPECIAL_ATTACK = 75;
    private static final int BASE_SPECIAL_DEFENSE = 85;
    private static final int BASE_SPEED = 76;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/nidoqueen.png";
    private static final String BACK_PATH = "battle/backs/nidoqueen.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/nidoqueen.png";
    private static final String CRY_PATH = "sounds/cry/031.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/031.png";

    /**
     * Create a Nidoqueen
     */
    public Nidoqueen() {
        super(NUMBER, NAME, Pokemon.Type.POISON, Pokemon.Type.NONE, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    @Override
    protected void initGender() {
        gender = 'F';
    }

    /**
     * Init Nidoqueen's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SUPERPOWER);
        beginnerSkills.add(SkillFactory.SCRATCH);
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
        beginnerSkills.add(SkillFactory.DOUBLE_KICK);
        beginnerSkills.add(SkillFactory.POISON_STING);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHIP_AWAY)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.BODY_SLAM)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.EARTH_POWER)));
        levelUpSkills.put(58, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPERPOWER)));
    }
}
