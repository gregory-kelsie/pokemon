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

public class Cubone extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 104;
    private static final String NAME = "Cubone";
    private static final int BASE_EXP = 87;
    private static final int[] EV_YIELD = {0, 0, 1, 0, 0, 0};
    private static final int CAPTURE_RATE = 190;
    private static final double WEIGHT = 6.5;

    private static final Ability FIRST_ABILITY = new Ability.RockHead();
    private static final Ability SECOND_ABILITY = new Ability.Lightningrod();
    private static final Ability HIDDEN_ABILITY = new Ability.BattleArmor();

    //Base Stats
    private static final int BASE_HEALTH = 50;
    private static final int BASE_ATTACK = 50;
    private static final int BASE_DEFENSE = 95;
    private static final int BASE_SPECIAL_ATTACK = 40;
    private static final int BASE_SPECIAL_DEFENSE = 50;
    private static final int BASE_SPEED = 35;

    //Typing
    private static final Type TYPE_ONE = Type.GROUND;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/cubone.png";
    private static final String BACK_PATH = "battle/backs/cubone.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/cubone.png";
    private static final String CRY_PATH = "sounds/cry/104.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/104.png";

    /**
     * Create a Cubone
     */
    public Cubone() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Cubone's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.GROWL);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAIL_WHIP)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.BONE_CLUB)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEADBUTT)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEER)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.FOCUS_ENERGY)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.BONEMERANG)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAGE)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.FALSE_SWIPE)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.THRASH)));
        //TODO: FLING 33
        //TODO: STOMPING TANTRUM 37
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.ENDEAVOR)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
        //TODO: RETALIATE 47
        levelUpSkills.put(51, new ArrayList<Integer>(Arrays.asList(SkillFactory.BONE_RUSH)));
    }

    /**
     * Return Marowak if Cubone is 28
     * @return Marowak if Cubone is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 28) {
            return PokemonId.MAROWAK.getValue();
        }
        return -1;
    }
}
