package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/16/2017.
 */

public class Ninetales extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 38;
    private static final String NAME = "Ninetales";
    private static final int BASE_EXP = 63;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 1, 1};
    private static final int CAPTURE_RATE = 178;
    private static final double WEIGHT = 19.9;

    private static final Ability FIRST_ABILITY = new Ability.FlashFire();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = new Ability.Drought();

    //Base Stats
    private static final int BASE_HEALTH = 73;
    private static final int BASE_ATTACK = 76;
    private static final int BASE_DEFENSE = 75;
    private static final int BASE_SPECIAL_ATTACK = 81;
    private static final int BASE_SPECIAL_DEFENSE = 100;
    private static final int BASE_SPEED = 100;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/ninetales.png";
    private static final String BACK_PATH = "battle/backs/ninetales.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/ninetales.png";
    private static final String CRY_PATH = "sounds/cry/038.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/038.png";

    /**
     * Create a Ninetales
     */
    public Ninetales() {
        super(NUMBER, NAME, Pokemon.Type.FIRE, Pokemon.Type.NONE, ExpType.MEDIUM_FAST,
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
     * Init Ninetales's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //TODO: IMPRISON
        beginnerSkills.add(SkillFactory.NASTY_PLOT);
        beginnerSkills.add(SkillFactory.FLAMETHROWER);
        beginnerSkills.add(SkillFactory.QUICK_ATTACK);
        beginnerSkills.add(SkillFactory.CONFUSE_RAY);
        beginnerSkills.add(SkillFactory.SAFEGUARD);
        levelUpSkills.put(0, beginnerSkills);
    }
}
