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
 * Created by Gregory on 9/16/2017.
 */

public class Krabby extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 98;
    private static final String NAME = "Krabby";
    private static final int BASE_EXP = 115;
    private static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 225;
    private static final double WEIGHT = 6.5;

    private static final Ability FIRST_ABILITY = new Ability.HyperCutter();
    private static final Ability SECOND_ABILITY = new Ability.ShellArmor();
    private static final Ability HIDDEN_ABILITY = new Ability.SheerForce();

    //Base Stats
    private static final int BASE_HEALTH = 30;
    private static final int BASE_ATTACK = 105;
    private static final int BASE_DEFENSE = 90;
    private static final int BASE_SPECIAL_ATTACK = 25;
    private static final int BASE_SPECIAL_DEFENSE = 25;
    private static final int BASE_SPEED = 50;

    //Typing
    private static final Type TYPE_ONE = Type.WATER;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/krabby.png";
    private static final String BACK_PATH = "battle/backs/krabby.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/krabby.png";
    private static final String CRY_PATH = "sounds/cry/098.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/098.png";

    /**
     * Create a Krabby
     */
    public Krabby() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Krabby's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //TODO: MUD SPORT
        beginnerSkills.add(SkillFactory.BUBBLE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.VICEGRIP)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEER)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.HARDEN)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUBBLEBEAM)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_SHOT)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.METAL_CLAW)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.STOMP)));
        //TODO: PROTECT 29
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.GUILLOTINE)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLAM)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.BRINE)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRABHAMMER)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAIL)));
    }

    /**
     * Return Kingler if Krabby is 28
     * @return Kingler if Krabby is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 28) {
            return PokemonId.KINGLER.getValue();
        }
        return -1;
    }
}
