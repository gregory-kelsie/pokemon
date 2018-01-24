package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-22.
 */

public class Granbull extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 210;
    private static final String NAME = "Granbull";
    private static final int BASE_EXP = 158;
    private static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 75;
    private static final double WEIGHT = 48.7;

    private static final Ability FIRST_ABILITY = new Ability.Intimidate();
    private static final Ability SECOND_ABILITY = new Ability.QuickFeet();
    private static final Ability HIDDEN_ABILITY = new Ability.Rattled();

    //Base Stats
    private static final int BASE_HEALTH = 90;
    private static final int BASE_ATTACK = 120;
    private static final int BASE_DEFENSE = 75;
    private static final int BASE_SPECIAL_ATTACK = 60;
    private static final int BASE_SPECIAL_DEFENSE = 60;
    private static final int BASE_SPEED = 45;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/granbull.png";
    private static final String BACK_PATH = "battle/backs/johto/granbull.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/granbull.png";
    private static final String CRY_PATH = "sounds/cry/210.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/granbull.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.FAIRY;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.FAST;

    /**
     * Create a granbull
     */
    public Granbull() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init granbull's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
        beginnerSkills.add(SkillFactory.SCARY_FACE);
        beginnerSkills.add(SkillFactory.OUTRAGE);
        beginnerSkills.add(SkillFactory.CHARM);
        beginnerSkills.add(SkillFactory.THUNDER_FANG);
        beginnerSkills.add(SkillFactory.ICE_FANG);
        beginnerSkills.add(SkillFactory.FIRE_FANG);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.LICK)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEADBUTT)));
        //TODO ROAR 27
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAGE)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.PLAY_ROUGH)));
        levelUpSkills.put(51, new ArrayList<Integer>(Arrays.asList(SkillFactory.PAYBACK)));
        levelUpSkills.put(59, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(67, new ArrayList<Integer>(Arrays.asList(SkillFactory.OUTRAGE)));
    }

    /**
     * Init granbull's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .25) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

}
