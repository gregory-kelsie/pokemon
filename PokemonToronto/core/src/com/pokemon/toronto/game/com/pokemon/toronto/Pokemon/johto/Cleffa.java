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

public class Cleffa extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 173;
    private static final String NAME = "Cleffa";
    private static final int BASE_EXP = 44;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 1, 0};
    private static final int CAPTURE_RATE = 150;
    private static final double WEIGHT = 3;

    private static final Ability FIRST_ABILITY = new Ability.CuteCharm();
    private static final Ability SECOND_ABILITY = new Ability.MagicGuard();
    private static final Ability HIDDEN_ABILITY = new Ability.FriendGuard();

    //Base Stats
    private static final int BASE_HEALTH = 50;
    private static final int BASE_ATTACK = 25;
    private static final int BASE_DEFENSE = 28;
    private static final int BASE_SPECIAL_ATTACK = 45;
    private static final int BASE_SPECIAL_DEFENSE = 55;
    private static final int BASE_SPEED = 15;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/cleffa.png";
    private static final String BACK_PATH = "battle/backs/johto/cleffa.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/cleffa.png";
    private static final String CRY_PATH = "sounds/cry/173.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/cleffa.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.FAIRY;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.FAST;

    /**
     * Create a cleffa
     */
    public Cleffa() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init cleffa's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.POUND);
        beginnerSkills.add(SkillFactory.CHARM);
        levelUpSkills.put(0, beginnerSkills);
        //ENCORE 4
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.SING)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWEET_KISS)));
        //COPYCAT 13
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.MAGICAL_LEAF)));
    }

    /**
     * Init cleffa's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .246) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

    /**
     * Return Clefairy if the cleffa is above level 18.
     * @return Clefairy if cleffa is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 18) {
            return PokemonId.CLEFAIRY.getValue();
        }
        return -1;
    }
}
