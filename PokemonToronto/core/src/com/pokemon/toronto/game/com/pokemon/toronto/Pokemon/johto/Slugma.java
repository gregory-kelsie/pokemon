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

public class Slugma extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 218;
    private static final String NAME = "Slugma";
    private static final int BASE_EXP = 50;
    private static final int[] EV_YIELD = {0, 0, 0, 1, 0, 0};
    private static final int CAPTURE_RATE = 190;
    private static final double WEIGHT = 35;

    private static final Ability FIRST_ABILITY = new Ability.MagmaArmor();
    private static final Ability SECOND_ABILITY = new Ability.FlameBody();
    private static final Ability HIDDEN_ABILITY = new Ability.WeakArmor();

    //Base Stats
    private static final int BASE_HEALTH = 40;
    private static final int BASE_ATTACK = 40;
    private static final int BASE_DEFENSE = 40;
    private static final int BASE_SPECIAL_ATTACK = 70;
    private static final int BASE_SPECIAL_DEFENSE = 40;
    private static final int BASE_SPEED = 20;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/slugma.png";
    private static final String BACK_PATH = "battle/backs/johto/slugma.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/slugma.png";
    private static final String CRY_PATH = "sounds/cry/218.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/slugma.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.FIRE;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a slugma
     */
    public Slugma() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init slugma's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SMOG);
        beginnerSkills.add(SkillFactory.YAWN);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.EMBER)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_THROW)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.HARDEN)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.INCINERATE)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.CLEAR_SMOG)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.ANCIENT_POWER)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAME_BURST)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_SLIDE)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.LAVA_PLUME)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.AMNESIA)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.BODY_SLAM)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.RECOVER)));
        levelUpSkills.put(48, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAMETHROWER)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.EARTH_POWER)));
    }

    /**
     * Init slugma's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .5) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

    /**
     * Return Magcargo if the slugma is above level 38.
     * @return Magcargo if slugma is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 38) {
            return PokemonId.MAGCARGO.getValue();
        }
        return -1;
    }
}
