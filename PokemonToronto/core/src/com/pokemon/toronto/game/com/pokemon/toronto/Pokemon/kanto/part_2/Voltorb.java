package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2;

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
 * Created by Gregory on 9/16/2017.
 */

public class Voltorb extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 100;
    private static final String NAME = "Voltorb";
    private static final int BASE_EXP = 103;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    private static final int CAPTURE_RATE = 190;
    private static final double WEIGHT = 10.4;

    private static final Ability FIRST_ABILITY = new Ability.Soundproof();
    private static final Ability SECOND_ABILITY = new Ability.Static();
    private static final Ability HIDDEN_ABILITY = new Ability.Aftermath();

    //Base Stats
    private static final int BASE_HEALTH = 40;
    private static final int BASE_ATTACK = 30;
    private static final int BASE_DEFENSE = 50;
    private static final int BASE_SPECIAL_ATTACK = 55;
    private static final int BASE_SPECIAL_DEFENSE = 55;
    private static final int BASE_SPEED = 100;

    //Typing
    private static final Type TYPE_ONE = Type.ELECTRIC;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/voltorb.png";
    private static final String BACK_PATH = "battle/backs/voltorb.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/voltorb.png";
    private static final String CRY_PATH = "sounds/cry/100.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/100.png";

    /**
     * Create a Voltorb
     */
    public Voltorb() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Voltorb's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.CHARGE);
        beginnerSkills.add(SkillFactory.TACKLE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.SONIC_BOOM)));
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.EERIE_IMPULSE)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.SPARK)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROLLOUT)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCREECH)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARGE_BEAM)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWIFT)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.ELECTRO_BALL)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.SELF_DESTRUCT)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.LIGHT_SCREEN)));
        //TODO: MAGNET RISE 34
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISCHARGE)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.EXPLOSION)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.GYRO_BALL)));
        //TODO: MIRROR COAT 48
    }

    /**
     * Return Electrode if Voltorb is 30
     * @return Electrode if Voltorb is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 30) {
            return PokemonId.ELECTRODE.getValue();
        }
        return -1;
    }
}
