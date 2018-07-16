package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.hoenn;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-07.
 */

public class Wynaut extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 360;
    public static final String NAME = "Wynaut";
    public static final String TYPE_OF_POKEMON = "Bright";
    public static final String DESCRIPTION = "It grows strong by pushing up against others en" +
            " masse. It loves eating sweet fruit.";
    public static final int BASE_EXP = 52;
    public static final int[] EV_YIELD = {1, 0, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 125;
    public static final double WEIGHT = 14;
    public static final double HEIGHT = 0.6;

    public static final Ability FIRST_ABILITY = new Ability.ShadowTag();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.Telepathy();

    //Base Stats
    public static final int BASE_HEALTH = 95;
    public static final int BASE_ATTACK = 23;
    public static final int BASE_DEFENSE = 48;
    public static final int BASE_SPECIAL_ATTACK = 23;
    public static final int BASE_SPECIAL_DEFENSE = 48;
    public static final int BASE_SPEED = 23;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/hoenn/wynaut.png";
    public static final String BACK_PATH = "battle/backs/hoenn/wynaut.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/hoenn/wynaut.png";
    public static final String CRY_PATH = "sounds/cry/360.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/hoenn/wynaut.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.PSYCHIC;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a wynaut
     */
    public Wynaut() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init wynaut's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SPLASH);
        beginnerSkills.add(SkillFactory.CHARM);
        //ENCORE
        levelUpSkills.put(0, beginnerSkills);
        //15 COUNTER
        //15 DESTINY BOND
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAFEGUARD)));
        //15 MIRROR COAT
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.SAFEGUARD.getValue());
    }

    /**
     * Init wynaut's gender.
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

    /* Return Wobbuffet if the Wynaut is above level 15.
    * @return Wobbuffet if Wynaut is the right level.
    */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 15) {
            return PokemonId.WOBBUFFET.getValue();
        }
        return -1;
    }
}
