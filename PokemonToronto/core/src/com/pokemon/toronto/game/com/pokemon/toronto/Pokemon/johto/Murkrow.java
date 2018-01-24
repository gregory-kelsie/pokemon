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

public class Murkrow extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 198;
    private static final String NAME = "Murkrow";
    private static final int BASE_EXP = 81;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    private static final int CAPTURE_RATE = 30;
    private static final double WEIGHT = 2.1;

    private static final Ability FIRST_ABILITY = new Ability.Insomnia();
    private static final Ability SECOND_ABILITY = new Ability.SuperLuck();
    private static final Ability HIDDEN_ABILITY = new Ability.Prankster();

    //Base Stats
    private static final int BASE_HEALTH = 60;
    private static final int BASE_ATTACK = 85;
    private static final int BASE_DEFENSE = 42;
    private static final int BASE_SPECIAL_ATTACK = 85;
    private static final int BASE_SPECIAL_DEFENSE = 42;
    private static final int BASE_SPEED = 91;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/murkrow.png";
    private static final String BACK_PATH = "battle/backs/johto/murkrow.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/murkrow.png";
    private static final String CRY_PATH = "sounds/cry/198.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/murkrow.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.DARK;
    private static final Type TYPE_TWO = Type.FLYING;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a murkrow
     */
    public Murkrow() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init murkrow's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.PECK);
        beginnerSkills.add(SkillFactory.ASTONISH);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.PURSUIT)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.HAZE)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.WING_ATTACK)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.NIGHT_SHADE)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.ASSURANCE)));
        //TODO TAUNT 31
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT)));
        //TODO MEAN LOOK 41
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.FOUL_PLAY)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAILWIND)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUCKER_PUNCH)));
        //TODO TORMENT 61
        //TODO QUASH 65
    }

    /**
     * Init murkrow's gender.
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

}
