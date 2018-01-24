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

public class Vileplume extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 45;
    private static final String NAME = "Vileplume";
    private static final int BASE_EXP = 184;
    private static final int[] EV_YIELD = {0, 0, 0, 3, 0, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 18.6;

    private static final Ability FIRST_ABILITY = new Ability.Chlorophyll();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = new Ability.EffectSpore();

    //Base Stats
    private static final int BASE_HEALTH = 75;
    private static final int BASE_ATTACK = 80;
    private static final int BASE_DEFENSE = 85;
    private static final int BASE_SPECIAL_ATTACK = 110;
    private static final int BASE_SPECIAL_DEFENSE = 90;
    private static final int BASE_SPEED = 50;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/vileplume.png";
    private static final String BACK_PATH = "battle/backs/vileplume.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/vileplume.png";
    private static final String CRY_PATH = "sounds/cry/045.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/045.png";

    /**
     * Create a Vileplume
     */
    public Vileplume() {
        super(NUMBER, NAME, Pokemon.Type.GRASS, Pokemon.Type.POISON, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Vileplume's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.MEGA_DRAIN);
        beginnerSkills.add(SkillFactory.AROMATHERAPY);
        beginnerSkills.add(SkillFactory.POISON_POWDER);
        beginnerSkills.add(SkillFactory.STUN_SPORE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(59, new ArrayList<Integer>(Arrays.asList(SkillFactory.PETAL_BLIZZARD)));
        levelUpSkills.put(59, new ArrayList<Integer>(Arrays.asList(SkillFactory.PETAL_DANCE)));
        levelUpSkills.put(69, new ArrayList<Integer>(Arrays.asList(SkillFactory.SOLAR_BEAM)));
    }
}
