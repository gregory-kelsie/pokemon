package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

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

    /**
     * Create a Caterpie with the specified level.
     * @param level The level of the Caterpie.
     */
    public Caterpie(int level) {
        super(NUMBER, NAME, level, Type.BUG, Type.NONE, Ability.SHIELD_DUST, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Caterpie from the database.
     * @param level The level of the Pokemon.
     * @param ivs  The array of set IVs
     * @param evs The array of set EVs
     * @param firstSkill The first move.
     * @param secondSkill The second move.
     * @param thirdSkill The third move.
     * @param fourthSkill The fourth move.
     * @param currentHealth The current health of the Pokemon.
     * @param currentExp The current exp of the Pokemon.
     * @param status The Pokemon's status.
     * @param nature The Pokemon's nature.
     * @param ability The Pokemon's ability.
     */
    public Caterpie(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                     Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                     Status status, Nature nature, Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.BUG, Type.NONE, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
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
