package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-24.
 */

public class Burmy extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 412;
    public static final String NAME = "Burmy";
    public static final String TYPE_OF_POKEMON = "Bagworm";
    public static final String DESCRIPTION = "Even if it is born where there are no cocooning " +
            "materials, it somehow always ends up with a cloak.";
    public static final double HEIGHT = 0.2;
    public static final int BASE_EXP = 45;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 1, 0};
    public static final int CAPTURE_RATE = 120;
    public static final double WEIGHT = 3.4;

    public static final Ability FIRST_ABILITY = new Ability.ShedSkin();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.Overcoat();

    //Base Stats
    public static final int BASE_HEALTH = 40;
    public static final int BASE_ATTACK = 29;
    public static final int BASE_DEFENSE = 45;
    public static final int BASE_SPECIAL_ATTACK = 29;
    public static final int BASE_SPECIAL_DEFENSE = 45;
    public static final int BASE_SPEED = 36;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/burmy.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/burmy.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/burmy.png";
    public static final String CRY_PATH = "sounds/cry/412.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/burmy.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.BUG;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a burmy
     */
    public Burmy() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init burmy's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //PROTECT
        beginnerSkills.add(SkillFactory.TACKLE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.TACKLE)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BITE)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.HIDDEN_POWER)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
    }

    /**
     * Init burmy's gender.
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
     * Return Rampardos if the burmy is above level 30.
     * @return Rampardos if burmy is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 20 && (gender == 'F' || gender =='f')) {
            return PokemonId.WORMADAM.getValue();
        } else if (level >= 20 && (gender == 'M' || gender =='m')) {
            return PokemonId.MOTHIM.getValue();
        }
        return -1;
    }
}
