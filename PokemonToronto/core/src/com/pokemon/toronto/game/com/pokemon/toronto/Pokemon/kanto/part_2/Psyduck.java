package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2;

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
 * Created by Gregory on 9/15/2017.
 */

public class Psyduck extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 54;
    private static final String NAME = "Psyduck";
    private static final int BASE_EXP = 64;
    private static final int[] EV_YIELD = {0, 0, 0, 1, 0, 0};
    private static final int CAPTURE_RATE = 190;
    private static final double WEIGHT = 19.6;

    private static final Ability FIRST_ABILITY = new Ability.Damp();
    private static final Ability SECOND_ABILITY = new Ability.CloudNine();
    private static final Ability HIDDEN_ABILITY = new Ability.SwiftSwim();

    //Base Stats
    private static final int BASE_HEALTH = 50;
    private static final int BASE_ATTACK = 52;
    private static final int BASE_DEFENSE = 48;
    private static final int BASE_SPECIAL_ATTACK = 65;
    private static final int BASE_SPECIAL_DEFENSE = 50;
    private static final int BASE_SPEED = 55;

    //Typing
    private static final Type TYPE_ONE = Type.WATER;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/psyduck.png";
    private static final String BACK_PATH = "battle/backs/psyduck.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/psyduck.png";
    private static final String CRY_PATH = "sounds/cry/054.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/054.png";

    /**
     * Create a Psyduck
     */
    public Psyduck() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Psyduck's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.WATER_SPORT);
        beginnerSkills.add(SkillFactory.SCRATCH);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAIL_WHIP)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_GUN)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONFUSION)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_SWIPES)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_PULSE)));
        //TODO: DISABLE 19
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCREECH)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.ZEN_HEADBUTT)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_TAIL)));
        //TODO: SOAK 31
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCH_UP)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.AMNESIA)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYDRO_PUMP)));
        //TODO: WONDER ROOM 43
    }

    /**
     * Return Golduck if Psyduck is 33
     * @return Golduck if Psyduck is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 33) {
            return PokemonId.GOLDUCK.getValue();
        }
        return -1;
    }
}
