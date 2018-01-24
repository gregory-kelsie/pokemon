package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-22.
 */

public class Cyndaquil extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 155;
    private static final String NAME = "cyndaquil";
    private static final int BASE_EXP = 65;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 7.9;

    private static final Ability FIRST_ABILITY = new Ability.Blaze();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = new Ability.FlashFire();

    //Base Stats
    private static final int BASE_HEALTH = 39;
    private static final int BASE_ATTACK = 52;
    private static final int BASE_DEFENSE = 43;
    private static final int BASE_SPECIAL_ATTACK = 60;
    private static final int BASE_SPECIAL_DEFENSE = 50;
    private static final int BASE_SPEED = 65;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/cyndaquil.png";
    private static final String BACK_PATH = "battle/backs/johto/cyndaquil.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/cyndaquil.png";
    private static final String CRY_PATH = "sounds/cry/155.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/cyndaquil.png";

    //Typing
    private static final Type TYPE_ONE = Type.FIRE;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a Cyndaquil
     */
    public Cyndaquil() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Cyndaquil's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.LEER);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.SMOKESCREEN)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.EMBER)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAME_WHEEL)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.DEFENSE_CURL)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAME_CHARGE)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWIFT)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.LAVA_PLUME)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAMETHROWER)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.INFERNO)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROLLOUT)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
        levelUpSkills.put(58, new ArrayList<Integer>(Arrays.asList(SkillFactory.BURN_UP)));
        levelUpSkills.put(64, new ArrayList<Integer>(Arrays.asList(SkillFactory.ERUPTION)));
    }

    /**
     * Init cyndaquil's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .881) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

    /**
     * Return Quilava if the cyndaquil is above level 14.
     * @return Quilava if cyndaquil is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 14) {
            return PokemonId.QUILAVA.getValue();
        }
        return -1;
    }
}
