package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 9/21/2017.
 */

public class Ditto extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 132;
    private static final String NAME = "Ditto";
    private static final int BASE_EXP = 61;
    private static final int[] EV_YIELD = {1, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 35;
    private static final double WEIGHT = 4;

    private static final Ability FIRST_ABILITY = new Ability.Limber();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = new Ability.Imposter();

    //Base Stats
    private static final int BASE_HEALTH = 48;
    private static final int BASE_ATTACK = 48;
    private static final int BASE_DEFENSE = 48;
    private static final int BASE_SPECIAL_ATTACK = 48;
    private static final int BASE_SPECIAL_DEFENSE = 48;
    private static final int BASE_SPEED = 48;

    //Typing
    private static final Type TYPE_ONE = Type.NORMAL;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/ditto.png";
    private static final String BACK_PATH = "battle/backs/ditto.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/ditto.png";
    private static final String CRY_PATH = "sounds/cry/132.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/132.png";

    /**
     * Create a Ditto
     */
    public Ditto() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Ditto's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        //TODO: REPLACE WITH TRANSFORM WHEN IT'S IMPLEMENTED
        levelUpSkills.put(0, beginnerSkills);
    }
}
