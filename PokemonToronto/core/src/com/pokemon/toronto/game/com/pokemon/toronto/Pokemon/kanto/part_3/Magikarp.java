package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3;

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
 * Created by Gregory on 9/21/2017.
 */

public class Magikarp extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 129;
    private static final String NAME = "Magikarp";
    private static final int BASE_EXP = 20;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    private static final int CAPTURE_RATE = 255;
    private static final double WEIGHT = 10;

    private static final Ability FIRST_ABILITY = new Ability.SwiftSwim();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = new Ability.Rattled();

    //Base Stats
    private static final int BASE_HEALTH = 20;
    private static final int BASE_ATTACK = 10;
    private static final int BASE_DEFENSE = 55;
    private static final int BASE_SPECIAL_ATTACK = 15;
    private static final int BASE_SPECIAL_DEFENSE = 20;
    private static final int BASE_SPEED = 80;

    //Typing
    private static final Type TYPE_ONE = Type.WATER;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.SLOW;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/magikarp.png";
    private static final String BACK_PATH = "battle/backs/magikarp.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/magikarp.png";
    private static final String CRY_PATH = "sounds/cry/129.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/129.png";

    /**
     * Create a Magikarp
     */
    public Magikarp() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Magikarp's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SPLASH);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.TACKLE)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAIL)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.BOUNCE)));
    }

    /**
     * Return Gyarados if Magikarp is 20
     * @return Gyarados if Magikarp is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 20) {
            return PokemonId.GYARADOS.getValue();
        }
        return -1;
    }
}
