package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/27/2017.
 */

public class AlolanSandslash extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = -28;
    private static final String NAME = "Sandslash";
    private static final int BASE_EXP = 163;
    private static final int[] EV_YIELD = {0, 0, 2, 0, 0, 0};
    private static final int CAPTURE_RATE = 90;
    private static final double WEIGHT = 55;

    private static final Ability FIRST_ABILITY = new Ability.SnowCloak();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = new Ability.SlushRush();

    //Base Stats
    private static final int BASE_HEALTH = 75;
    private static final int BASE_ATTACK = 100;
    private static final int BASE_DEFENSE = 120;
    private static final int BASE_SPECIAL_ATTACK = 25;
    private static final int BASE_SPECIAL_DEFENSE = 65;
    private static final int BASE_SPEED = 65;

    //Typing
    private static final Type TYPE_ONE = Type.ICE;
    private static final Type TYPE_TWO = Type.STEEL;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/alolan_kanto/sandslash.png";
    private static final String BACK_PATH = "battle/backs/alolan_kanto/sandslash.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/alolan_kanto/sandslash.png";
    private static final String CRY_PATH = "sounds/cry/028.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/alolan_kanto/alolansandslash.png";

    /**
     * Create a Sandslash
     */
    public AlolanSandslash() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Sandslash's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.METAL_BURST);
        beginnerSkills.add(SkillFactory.ICICLE_CRASH);
        beginnerSkills.add(SkillFactory.SLASH);
        beginnerSkills.add(SkillFactory.DEFENSE_CURL);
        beginnerSkills.add(SkillFactory.ICE_BALL);
        beginnerSkills.add(SkillFactory.METAL_CLAW);
        levelUpSkills.put(0, beginnerSkills);
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.ICICLE_SPEAR);
    }
}
