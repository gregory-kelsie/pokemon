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

public class Clefable extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 36;
    private static final String NAME = "Clefable";
    private static final int BASE_EXP = 129;
    private static final int[] EV_YIELD = {3, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 25;
    private static final double WEIGHT = 40;

    private static final Ability FIRST_ABILITY = new Ability.CuteCharm();
    private static final Ability SECOND_ABILITY = new Ability.MagicGuard();
    private static final Ability HIDDEN_ABILITY = new Ability.Unaware();

    //Base Stats
    private static final int BASE_HEALTH = 95;
    private static final int BASE_ATTACK = 70;
    private static final int BASE_DEFENSE = 73;
    private static final int BASE_SPECIAL_ATTACK = 95;
    private static final int BASE_SPECIAL_DEFENSE = 90;
    private static final int BASE_SPEED = 60;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/clefable.png";
    private static final String BACK_PATH = "battle/backs/clefable.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/clefable.png";
    private static final String CRY_PATH = "sounds/cry/036.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/036.png";

    /**
     * Create a Clefable
     */
    public Clefable() {
        super(NUMBER, NAME, Pokemon.Type.FAIRY, Pokemon.Type.NONE, ExpType.FAST,
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
     * Init Clefable's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.DISARMING_VOICE);
        beginnerSkills.add(SkillFactory.SING);
        beginnerSkills.add(SkillFactory.DOUBLE_SLAP);
        beginnerSkills.add(SkillFactory.MINIMIZE);
        //TODO: METRONOME
        levelUpSkills.put(0, beginnerSkills);

    }
}
