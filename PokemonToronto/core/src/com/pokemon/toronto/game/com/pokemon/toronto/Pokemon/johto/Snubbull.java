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

public class Snubbull extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 209;
    private static final String NAME = "Snubbull";
    private static final int BASE_EXP = 60;
    private static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 190;
    private static final double WEIGHT = 7.8;

    private static final Ability FIRST_ABILITY = new Ability.Intimidate();
    private static final Ability SECOND_ABILITY = new Ability.RunAway();
    private static final Ability HIDDEN_ABILITY = new Ability.Rattled();

    //Base Stats
    private static final int BASE_HEALTH = 60;
    private static final int BASE_ATTACK = 80;
    private static final int BASE_DEFENSE = 50;
    private static final int BASE_SPECIAL_ATTACK = 40;
    private static final int BASE_SPECIAL_DEFENSE = 40;
    private static final int BASE_SPEED = 30;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/snubbull.png";
    private static final String BACK_PATH = "battle/backs/johto/snubbull.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/snubbull.png";
    private static final String CRY_PATH = "sounds/cry/209.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/snubbull.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.FAIRY;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.FAST;

    /**
     * Create a snubbull
     */
    public Snubbull() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init snubbull's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
        beginnerSkills.add(SkillFactory.SCARY_FACE);
        beginnerSkills.add(SkillFactory.CHARM);
        beginnerSkills.add(SkillFactory.THUNDER_FANG);
        beginnerSkills.add(SkillFactory.ICE_FANG);
        beginnerSkills.add(SkillFactory.FIRE_FANG);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.LICK)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEADBUTT)));
        //TODO ROAR 25
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAGE)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.PLAY_ROUGH)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.PAYBACK)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
    }

    /**
     * Init snubbull's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .25) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

    /**
     * Return Granbull if the Snubbull is above level 23.
     * @return Granbull if Snubbull is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 23) {
            return PokemonId.GRANBULL.getValue();
        }
        return -1;
    }
}
