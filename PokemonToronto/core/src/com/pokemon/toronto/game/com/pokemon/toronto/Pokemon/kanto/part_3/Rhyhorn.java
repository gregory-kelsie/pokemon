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

public class Rhyhorn extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 111;
    private static final String NAME = "Rhyhorn";
    private static final int BASE_EXP = 135;
    private static final int[] EV_YIELD = {0, 0, 1, 0, 0, 0};
    private static final int CAPTURE_RATE = 120;
    private static final double WEIGHT = 115;

    private static final Ability FIRST_ABILITY = new Ability.Lightningrod();
    private static final Ability SECOND_ABILITY = new Ability.RockHead();
    private static final Ability HIDDEN_ABILITY = new Ability.Reckless();

    //Base Stats
    private static final int BASE_HEALTH = 80;
    private static final int BASE_ATTACK = 85;
    private static final int BASE_DEFENSE = 95;
    private static final int BASE_SPECIAL_ATTACK = 30;
    private static final int BASE_SPECIAL_DEFENSE = 30;
    private static final int BASE_SPEED = 25;

    //Typing
    private static final Type TYPE_ONE = Type.GROUND;
    private static final Type TYPE_TWO = Type.ROCK;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.SLOW;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/rhyhorn.png";
    private static final String BACK_PATH = "battle/backs/rhyhorn.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/rhyhorn.png";
    private static final String CRY_PATH = "sounds/cry/111.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/111.png";

    /**
     * Create a Rhyhorn
     */
    public Rhyhorn() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Rhyhorn's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.HORN_ATTACK);
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
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
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.EARTHQUAKE)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEGAHORN)));
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.HORN_DRILL)));
    }

    /**
     * Return Rhydon if Rhyhorn is 42
     * @return Rhydon if Rhyhorn is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 42) {
            return PokemonId.RHYDON.getValue();
        }
        return -1;
    }
}
