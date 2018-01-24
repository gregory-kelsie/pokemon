package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty;

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
 * Created by Gregory on 6/14/2017.
 */
public class Caterpie extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 10;
    private static final String NAME = "Caterpie";
    private static final int BASE_EXP = 54;
    private static final int[] EV_YIELD = {1, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 255;
    private static final double WEIGHT = 2.9;

    private static final Ability FIRST_ABILITY = new Ability.ShieldDust();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = new Ability.RunAway();


    //Base Stats
    private static final int BASE_HEALTH = 45;
    private static final int BASE_ATTACK = 30;
    private static final int BASE_DEFENSE = 35;
    private static final int BASE_SPECIAL_ATTACK = 20;
    private static final int BASE_SPECIAL_DEFENSE = 20;
    private static final int BASE_SPEED = 45;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/caterpie/caterpie.png";
    private static final String BACK_PATH = "battle/backs/caterpie.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/caterpie.png";
    private static final String CRY_PATH = "sounds/cry/010.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/010.png";

    /**
     * Create a Caterpie
     */
    public Caterpie() {
        super(NUMBER, NAME, Type.BUG, Type.NONE, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Caterpie's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.STRING_SHOT);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BITE)));
    }

    /**
     * Init Caterpie's gender.
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
     * Return Metapod if the Caterpie is above level 7.
     * @return Metapod if Caterpie is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 7) {
            return PokemonId.METAPOD.getValue();
        }
        return -1;
    }
}
