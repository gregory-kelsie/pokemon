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
 * Created by Gregory on 6/14/2017.
 */
public class Venusaur extends Pokemon {

    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 3;
    private static final String NAME = "Venusaur";
    private static final int BASE_EXP = 54;
    private static final int[] EV_YIELD = {0, 0, 0, 2, 1, 0};
    private static final int CAPTURE_RATE = 45;
    private static final int WEIGHT = 100;

    private static final Ability FIRST_ABILITY = new Ability.Overgrow();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = new Ability.Chlorophyll();

    //Base Stats
    private static final int BASE_HEALTH = 80;
    private static final int BASE_ATTACK = 82;
    private static final int BASE_DEFENSE = 83;
    private static final int BASE_SPECIAL_ATTACK = 100;
    private static final int BASE_SPECIAL_DEFENSE = 100;
    private static final int BASE_SPEED = 80;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/venusaur/venusaur.png";
    private static final String BACK_PATH = "battle/backs/venusaur.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/venusaur.png";
    private static final String CRY_PATH = "sounds/cry/003.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/003.png";

    /**
     * Create a Venusaur
     */
    public Venusaur() {
        super(NUMBER, NAME, Type.GRASS, Type.POISON, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Venusaur's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> initSkills = new ArrayList<Integer>();
        initSkills.add(SkillFactory.TACKLE);
        initSkills.add(SkillFactory.GROWL);
        initSkills.add(SkillFactory.LEECH_SEED);
        initSkills.add(SkillFactory.VINE_WHIP);
        levelUpSkills.put(0, initSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWL)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEECH_SEED)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.VINE_WHIP)));
        ArrayList<Integer> thirteen = new ArrayList<Integer>();
        thirteen.add(SkillFactory.POISON_POWDER);
        thirteen.add(SkillFactory.SLEEP_POWDER);
        levelUpSkills.put(13, thirteen);
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_LEAF)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWEET_SCENT)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWTH)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
        //todo: worry seed
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.SYNTHESIS)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.PETAL_BLIZZARD)));
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.SOLAR_BEAM)));
    }

    /**
     * Init Venusaur's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .875) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

}
