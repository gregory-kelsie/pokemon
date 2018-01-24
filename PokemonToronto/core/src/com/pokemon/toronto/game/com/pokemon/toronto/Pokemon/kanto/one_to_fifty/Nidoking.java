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

public class Nidoking extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 34;
    private static final String NAME = "Nidoking";
    private static final int BASE_EXP = 195;
    private static final int[] EV_YIELD = {0, 3, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 62;

    private static final Ability FIRST_ABILITY = new Ability.PoisonPoint();
    private static final Ability SECOND_ABILITY = new Ability.Rivalry();
    private static final Ability HIDDEN_ABILITY = new Ability.SheerForce();

    //Base Stats
    private static final int BASE_HEALTH = 81;
    private static final int BASE_ATTACK = 102;
    private static final int BASE_DEFENSE = 77;
    private static final int BASE_SPECIAL_ATTACK = 85;
    private static final int BASE_SPECIAL_DEFENSE = 75;
    private static final int BASE_SPEED = 85;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/nidoking.png";
    private static final String BACK_PATH = "battle/backs/nidoking.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/nidoking.png";
    private static final String CRY_PATH = "sounds/cry/034.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/034.png";

    /**
     * Create a Nidoking
     */
    public Nidoking() {
        super(NUMBER, NAME, Pokemon.Type.POISON, Pokemon.Type.NONE, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    @Override
    protected void initGender() {
        gender = 'M';
    }

    /**
     * Init Nidoking's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.MEGAHORN);
        beginnerSkills.add(SkillFactory.PECK);
        beginnerSkills.add(SkillFactory.FOCUS_ENERGY);
        beginnerSkills.add(SkillFactory.DOUBLE_KICK);
        beginnerSkills.add(SkillFactory.POISON_STING);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHIP_AWAY)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.THRASH)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.EARTH_POWER)));
        levelUpSkills.put(58, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEGAHORN)));
    }

}
