package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/21/2017.
 */

public class Exeggutor extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 103;
    private static final String NAME = "Exeggutor";
    private static final int BASE_EXP = 212;
    private static final int[] EV_YIELD = {0, 0, 0, 2, 0, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 120;

    private static final Ability FIRST_ABILITY = new Ability.Chlorophyll();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = new Ability.Harvest();

    //Base Stats
    private static final int BASE_HEALTH = 95;
    private static final int BASE_ATTACK = 95;
    private static final int BASE_DEFENSE = 85;
    private static final int BASE_SPECIAL_ATTACK = 125;
    private static final int BASE_SPECIAL_DEFENSE = 75;
    private static final int BASE_SPEED = 55;

    //Typing
    private static final Type TYPE_ONE = Type.GRASS;
    private static final Type TYPE_TWO = Type.PSYCHIC;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.SLOW;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/exeggutor.png";
    private static final String BACK_PATH = "battle/backs/exeggutor.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/exeggutor.png";
    private static final String CRY_PATH = "sounds/cry/103.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/103.png";

    /**
     * Create a Exeggutor
     */
    public Exeggutor() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }


    /**
     * Init Exeggutor's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SEED_BOMB);
        beginnerSkills.add(SkillFactory.BARRAGE);
        beginnerSkills.add(SkillFactory.HYPNOSIS);
        beginnerSkills.add(SkillFactory.CONFUSION);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYSHOCK)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.EGG_BOMB)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.WOOD_HAMMER)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEAF_STORM)));
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.STOMP);
    }

}
