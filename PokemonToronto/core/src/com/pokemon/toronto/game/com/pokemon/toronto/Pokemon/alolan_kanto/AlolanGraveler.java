package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto;

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
 * Created by Gregory on 10/27/2017.
 */

public class AlolanGraveler extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = -75;
    private static final String NAME = "Graveler";
    private static final int BASE_EXP = 134;
    private static final int[] EV_YIELD = {0, 0, 2, 0, 0, 0};
    private static final int CAPTURE_RATE = 120;
    private static final double WEIGHT = 110;

    private static final Ability FIRST_ABILITY = new Ability.MagnetPull();
    private static final Ability SECOND_ABILITY = new Ability.Sturdy();
    private static final Ability HIDDEN_ABILITY = new Ability.Galvanize();

    //Base Stats
    private static final int BASE_HEALTH = 55;
    private static final int BASE_ATTACK = 95;
    private static final int BASE_DEFENSE = 115;
    private static final int BASE_SPECIAL_ATTACK = 45;
    private static final int BASE_SPECIAL_DEFENSE = 45;
    private static final int BASE_SPEED = 35;

    //Typing
    private static final Type TYPE_ONE = Type.ROCK;
    private static final Type TYPE_TWO = Type.ELECTRIC;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/alolan_kanto/graveler.png";
    private static final String BACK_PATH = "battle/backs/alolan_kanto/graveler.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/alolan_kanto/graveler.png";
    private static final String CRY_PATH = "sounds/cry/075.wav";
    private static final String PROFILE_PATH = "trainercard/alolan_kanto/pokemon/alolangraveler.png";
    /**
     * Create a Graveler
     */
    public AlolanGraveler() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Graveler's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.DEFENSE_CURL);
        beginnerSkills.add(SkillFactory.CHARGE);
        beginnerSkills.add(SkillFactory.ROCK_POLISH);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARGE)));
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_POLISH)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROLLOUT)));
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.SPARK)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_THROW)));
        //TODO: SMACK DOWN 18
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER_PUNCH)));
        levelUpSkills.put(24, new ArrayList<Integer>(Arrays.asList(SkillFactory.SELF_DESTRUCT)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.STEALTH_ROCK)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_BLAST)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISCHARGE)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.EXPLOSION)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
        levelUpSkills.put(54, new ArrayList<Integer>(Arrays.asList(SkillFactory.STONE_EDGE)));
    }

    /**
     * Determine Graveler's gender.
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
     * Return Golem if Graveler is 40
     * @return Golem if Graveler is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 40) {
            return PokemonId.ALOLAN_GOLEM.getValue();
        }
        return -1;
    }
}
