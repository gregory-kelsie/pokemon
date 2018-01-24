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
 * Created by Gregory on 6/14/2017.
 */
public class Ivysaur extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 2;
    private static final String NAME = "Ivysaur";
    private static final int BASE_EXP = 54;
    private static final int[] EV_YIELD = {0, 0, 0, 1, 1, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 13;

    private static final Ability FIRST_ABILITY = new Ability.Overgrow();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = new Ability.Chlorophyll();

    //Base Stats
    private static final int BASE_HEALTH = 60;
    private static final int BASE_ATTACK = 62;
    private static final int BASE_DEFENSE = 63;
    private static final int BASE_SPECIAL_ATTACK = 80;
    private static final int BASE_SPECIAL_DEFENSE = 80;
    private static final int BASE_SPEED = 60;


    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/ivysaur/ivysaur.png";
    private static final String BACK_PATH = "battle/backs/ivysaur.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/ivysaur.png";
    private static final String CRY_PATH = "sounds/cry/002.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/002.png";

    /**
     * Create a Ivysaur with the specified level from the wild.
     */
    public Ivysaur() {
        super(NUMBER, NAME, Type.GRASS, Type.POISON, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Ivysaur's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> initSkills = new ArrayList<Integer>();
        initSkills.add(SkillFactory.TACKLE);
        initSkills.add(SkillFactory.GROWL);
        initSkills.add(SkillFactory.LEECH_SEED);
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
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.SYNTHESIS)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.SOLAR_BEAM)));
    }

    /**
     * Init Ivysaur's gender.
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

    /**
     * Return Venusaur if the Ivysaur is above level 32.
     * @return Venusaur if Bulbasaur is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 32) {
            return PokemonId.VENUSAUR.getValue();
        }
        return -1;
    }
}
