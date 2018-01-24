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
 * Created by Gregory on 8/16/2017.
 */

public class Clefairy extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 35;
    private static final String NAME = "Clefairy";
    private static final int BASE_EXP = 68;
    private static final int[] EV_YIELD = {2, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 150;
    private static final double WEIGHT = 7.5;

    private static final Ability FIRST_ABILITY = new Ability.CuteCharm();
    private static final Ability SECOND_ABILITY = new Ability.MagicGuard();
    private static final Ability HIDDEN_ABILITY = new Ability.FriendGuard();

    //Base Stats
    private static final int BASE_HEALTH = 70;
    private static final int BASE_ATTACK = 45;
    private static final int BASE_DEFENSE = 48;
    private static final int BASE_SPECIAL_ATTACK = 60;
    private static final int BASE_SPECIAL_DEFENSE = 65;
    private static final int BASE_SPEED = 35;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/clefairy.png";
    private static final String BACK_PATH = "battle/backs/clefairy.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/clefairy.png";
    private static final String CRY_PATH = "sounds/cry/035.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/035.png";

    /**
     * Create a Clefairy
     */
    public Clefairy() {
        super(NUMBER, NAME, Type.FAIRY, Pokemon.Type.NONE, ExpType.FAST,
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
     * Init Clefairy's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.DISARMING_VOICE);
        beginnerSkills.add(SkillFactory.POUND);
        beginnerSkills.add(SkillFactory.GROWL);
        //TODO: ENCORE
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.SING)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_SLAP)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.DEFENSE_CURL)));
        //TODO: BESTOW 19
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.WAKE_UP_SLAP)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.MINIMIZE)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.STORED_POWER)));
        //TODO: METRONOME 31
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.COSMIC_POWER)));
        //TODO: LUCKY CHANT 37
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.BODY_SLAM)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.MOONLIGHT)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.MOONBLAST)));
        //TODO: GRAVITY 49
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.METEOR_MASH)));
        //TODO: HEALING WISH 55


    }

    /**
     * Return Clefable's id when a Moon Stone is used on Clefairy.
     * @return Clefable's id
     */
    @Override
    public int getMoonStoneEvolutionId() {
        return PokemonId.CLEFABLE.getValue();
    }
}
