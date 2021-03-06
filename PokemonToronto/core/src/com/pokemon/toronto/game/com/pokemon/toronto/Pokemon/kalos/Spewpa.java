package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kalos;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-02-02.
 */

public class Spewpa extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 665;
    public static final String NAME = "Spewpa";
    public static final String TYPE_OF_POKEMON = "Scatterdust";
    public static final String DESCRIPTION = "The beaks of bird Pokémon can't begin to scratch " +
            "its stalwart body. To defend itself, it spews powder.";
    public static final double HEIGHT = 0.3;
    public static final int BASE_EXP = 75;
    public static final int[] EV_YIELD = {0, 0, 2, 0, 0, 0};
    public static final int CAPTURE_RATE = 120;
    public static final double WEIGHT = 8.4;

    public static final Ability FIRST_ABILITY = new Ability.ShedSkin();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.FriendGuard();

    //Base Stats
    public static final int BASE_HEALTH = 45;
    public static final int BASE_ATTACK = 22;
    public static final int BASE_DEFENSE = 60;
    public static final int BASE_SPECIAL_ATTACK = 27;
    public static final int BASE_SPECIAL_DEFENSE = 30;
    public static final int BASE_SPEED = 29;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/spewpa.png";
    public static final String BACK_PATH = "battle/backs/kalos/spewpa.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/spewpa.png";
    public static final String CRY_PATH = "sounds/cry/665.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/spewpa.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.BUG;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a spewpa
     */
    public Spewpa() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init spewpa's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.HARDEN);
        levelUpSkills.put(0, beginnerSkills);
        //TODO: INIT EVOLUTION SKILL PROTECT
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.PROTECT.getValue());
    }

    /**
     * Init spewpa's gender.
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
     * Return Vivillon if the spewpa is above level 12.
     * @return Vivillon if spewpa is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 12) {
            return PokemonId.VIVILLON.getValue();
        }
        return -1;
    }
}
