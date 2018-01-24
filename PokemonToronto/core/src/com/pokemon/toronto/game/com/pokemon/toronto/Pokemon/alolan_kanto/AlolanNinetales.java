package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/27/2017.
 */

public class AlolanNinetales extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = -38;
    private static final String NAME = "Ninetales";
    private static final int BASE_EXP = 63;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 2};
    private static final int CAPTURE_RATE = 178;
    private static final double WEIGHT = 19.9;

    private static final Ability FIRST_ABILITY = new Ability.SnowCloak();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = new Ability.SnowWarning();

    //Base Stats
    private static final int BASE_HEALTH = 73;
    private static final int BASE_ATTACK = 67;
    private static final int BASE_DEFENSE = 75;
    private static final int BASE_SPECIAL_ATTACK = 81;
    private static final int BASE_SPECIAL_DEFENSE = 100;
    private static final int BASE_SPEED = 109;

    //Typing
    private static final Type TYPE_ONE = Type.ICE;
    private static final Type TYPE_TWO = Type.FAIRY;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/alolan_kanto/ninetales.png";
    private static final String BACK_PATH = "battle/backs/alolan_kanto/ninetales.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/alolan_kanto/ninetales.png";
    private static final String CRY_PATH = "sounds/cry/038.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/alolan_kanto/alolanninetales.png";

    /**
     * Create a Ninetales
     */
    public AlolanNinetales() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
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
        beginnerSkills.add(SkillFactory.ICE_BEAM);
        beginnerSkills.add(SkillFactory.ICE_SHARD);
        beginnerSkills.add(SkillFactory.CONFUSE_RAY);
        beginnerSkills.add(SkillFactory.SAFEGUARD);
        levelUpSkills.put(0, beginnerSkills);
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.DAZZLING_GLEAM);
    }
}
