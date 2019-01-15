package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.unova;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-05-07.
 */

public class Tynamo extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 602;
    public static final String NAME = "Tynamo";
    public static final String TYPE_OF_POKEMON = "EleFish";
    public static final String DESCRIPTION = "While one alone doesn't have much power, a chain" +
            " of many Tynamo can be as powerful as lightning.";
    public static final double HEIGHT = 0.2;
    public static final int BASE_EXP = 55;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    public static final int CAPTURE_RATE = 190;
    public static final double WEIGHT = 0.3;

    public static final Ability FIRST_ABILITY = new Ability.Levitate();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 35;
    public static final int BASE_ATTACK = 55;
    public static final int BASE_DEFENSE = 40;
    public static final int BASE_SPECIAL_ATTACK = 45;
    public static final int BASE_SPECIAL_DEFENSE = 40;
    public static final int BASE_SPEED = 60;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/tynamo.png";
    public static final String BACK_PATH = "battle/backs/unova/tynamo.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/tynamo.png";
    public static final String CRY_PATH = "sounds/cry/602.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/tynamo.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.ELECTRIC;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a tynamo
     */
    public Tynamo() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init tynamo's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.THUNDER_WAVE);
        beginnerSkills.add(SkillFactory.SPARK);
        beginnerSkills.add(SkillFactory.CHARGE_BEAM);
        levelUpSkills.put(0, beginnerSkills);
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
    }

    /**
     * Init tynamo's gender.
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
     * Return Eelektrik if the tynamo is above level 39.
     * @return Eelektrik if tynamo is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 39) {
            return PokemonId.EELEKTRIK.getValue();
        }
        return -1;
    }
}
