package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-23.
 */

public class Kricketot extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 401;
    public static final String NAME = "Kricketot";
    public static final String TYPE_OF_POKEMON = "Cricket";
    public static final String DESCRIPTION = "Its legs are short. Whenever it stumbles, its " +
            "stiff antennae clack with a xylophone-like sound.";
    public static final double HEIGHT = 0.3;
    public static final int BASE_EXP = 39;
    public static final int[] EV_YIELD = {0, 0, 1, 0, 0, 0};
    public static final int CAPTURE_RATE = 255;
    public static final double WEIGHT = 2.2;

    public static final Ability FIRST_ABILITY = new Ability.ShedSkin();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.RunAway();

    //Base Stats
    public static final int BASE_HEALTH = 37;
    public static final int BASE_ATTACK = 25;
    public static final int BASE_DEFENSE = 41;
    public static final int BASE_SPECIAL_ATTACK = 25;
    public static final int BASE_SPECIAL_DEFENSE = 41;
    public static final int BASE_SPEED = 25;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/kricketot.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/kricketot.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/kricketot.png";
    public static final String CRY_PATH = "sounds/cry/401.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/kricketot.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.BUG;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a kricketot
     */
    public Kricketot() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init kricketot's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.GROWL);
        //BIDE
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.STRUGGLE_BUG)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BITE)));
    }

    @Override
    protected void initTMSkills() {

    }

    /**
     * Init kricketot's gender.
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

    /**
     * Return Kricketune if the kricketot is above level 10.
     * @return Kricketune if kricketot is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 10) {
            return PokemonId.KRICKETUNE.getValue();
        }
        return -1;
    }
}
