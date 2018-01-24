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

public class Wigglytuff extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 40;
    private static final String NAME = "Wigglytuff";
    private static final int BASE_EXP = 109;
    private static final int[] EV_YIELD = {3, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 50;
    private static final double WEIGHT = 12;

    private static final Ability FIRST_ABILITY = new Ability.CuteCharm();
    private static final Ability SECOND_ABILITY = new Ability.Competitive();
    private static final Ability HIDDEN_ABILITY = new Ability.Frisk();

    //Base Stats
    private static final int BASE_HEALTH = 115;
    private static final int BASE_ATTACK = 45;
    private static final int BASE_DEFENSE = 20;
    private static final int BASE_SPECIAL_ATTACK = 45;
    private static final int BASE_SPECIAL_DEFENSE = 25;
    private static final int BASE_SPEED = 20;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/wigglytuff.png";
    private static final String BACK_PATH = "battle/backs/wigglytuff.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/wigglytuff.png";
    private static final String CRY_PATH = "sounds/cry/040.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/040.png";

    /**
     * Create a Wigglytuff
     */
    public Wigglytuff() {
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
     * Init Wigglytuff's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.DOUBLE_EDGE);
        beginnerSkills.add(SkillFactory.PLAY_ROUGH);
        beginnerSkills.add(SkillFactory.SING);
        beginnerSkills.add(SkillFactory.DEFENSE_CURL);
        //TODO: DISABLE
        beginnerSkills.add(SkillFactory.DOUBLE_SLAP);
        levelUpSkills.put(0, beginnerSkills);
    }
}
