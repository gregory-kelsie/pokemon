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

public class Rhydon extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 112;
    private static final String NAME = "Rhydon";
    private static final int BASE_EXP = 204;
    private static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 60;
    private static final double WEIGHT = 120;

    private static final Ability FIRST_ABILITY = new Ability.Lightningrod();
    private static final Ability SECOND_ABILITY = new Ability.RockHead();
    private static final Ability HIDDEN_ABILITY = new Ability.Reckless();

    //Base Stats
    private static final int BASE_HEALTH = 105;
    private static final int BASE_ATTACK = 130;
    private static final int BASE_DEFENSE = 120;
    private static final int BASE_SPECIAL_ATTACK = 45;
    private static final int BASE_SPECIAL_DEFENSE = 45;
    private static final int BASE_SPEED = 40;

    //Typing
    private static final Type TYPE_ONE = Type.GROUND;
    private static final Type TYPE_TWO = Type.ROCK;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/rhydon.png";
    private static final String BACK_PATH = "battle/backs/rhydon.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/rhydon.png";
    private static final String CRY_PATH = "sounds/cry/112.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/112.png";

    /**
     * Create a Rhydon
     */
    public Rhydon() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Rhydon's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.HORN_DRILL);
        beginnerSkills.add(SkillFactory.HORN_ATTACK);
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
        beginnerSkills.add(SkillFactory.FURY_ATTACK);
        beginnerSkills.add(SkillFactory.SCARY_FACE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_ATTACK)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCARY_FACE)));
        //TODO: SMACK DOWN 13
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.STOMP)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.BULLDOZE)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHIP_AWAY)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_BLAST)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRILL_RUN)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.STONE_EDGE)));
        levelUpSkills.put(48, new ArrayList<Integer>(Arrays.asList(SkillFactory.EARTHQUAKE)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEGAHORN)));
        levelUpSkills.put(62, new ArrayList<Integer>(Arrays.asList(SkillFactory.HORN_DRILL)));
        initEvolutionSkills();
    }


    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.HAMMER_ARM);
    }

}
