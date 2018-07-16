package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-22.
 */

public class Wobbuffet extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 202;
    public static final String NAME = "Wobbuffet";
    public static final String TYPE_OF_POKEMON = "Patient";
    public static final String DESCRIPTION = "It desperately tries to keep its black tail" +
            " hidden. It is said to be proof the tail hides a secret.";
    public static final int BASE_EXP = 142;
    public static final int[] EV_YIELD = {2, 0, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 28.5;
    public static final double HEIGHT = 1.3;

    public static final Ability FIRST_ABILITY = new Ability.ShadowTag();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.Telepathy();

    //Base Stats
    public static final int BASE_HEALTH = 190;
    public static final int BASE_ATTACK = 33;
    public static final int BASE_DEFENSE = 58;
    public static final int BASE_SPECIAL_ATTACK = 33;
    public static final int BASE_SPECIAL_DEFENSE = 58;
    public static final int BASE_SPEED = 33;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/johto/wobbuffet.png";
    public static final String BACK_PATH = "battle/backs/johto/wobbuffet.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/johto/wobbuffet.png";
    public static final String CRY_PATH = "sounds/cry/202.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/johto/wobbuffet.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.PSYCHIC;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a wobbuffet
     */
    public Wobbuffet() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init wobbuffet's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //COUNTER
        //DESTINY BOND
        beginnerSkills.add(SkillFactory.SAFEGUARD);
        //MIRROR COAT
        levelUpSkills.put(0, beginnerSkills);
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.SAFEGUARD.getValue());
    }

    /**
     * Init wobbuffet's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .5) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }
}
