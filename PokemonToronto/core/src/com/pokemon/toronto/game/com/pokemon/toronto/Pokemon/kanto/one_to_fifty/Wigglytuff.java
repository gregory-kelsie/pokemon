package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/16/2017.
 */

public class Wigglytuff extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 40;
    private static final String NAME = "Wigglytuff";
    private static final int BASE_EXP = 109;
    private static final int[] EV_YIELD = {3, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 50;
    private static final double WEIGHT = 12;

    //Base Stats
    private static final int BASE_HEALTH = 115;
    private static final int BASE_ATTACK = 45;
    private static final int BASE_DEFENSE = 20;
    private static final int BASE_SPECIAL_ATTACK = 45;
    private static final int BASE_SPECIAL_DEFENSE = 25;
    private static final int BASE_SPEED = 20;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/wigglytuff.png";
    private static final String BACK_PATH = "battle/backs/wigglytuff.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/wigglytuff.png";
    private static final String CRY_PATH = "sounds/cry/040.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/040.png";

    /**
     * Create a Wigglytuff with the specified level.
     * @param level The level of the Wigglytuff.
     */
    public Wigglytuff(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.NORMAL, Pokemon.Type.FAIRY, ExpType.FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT);
    }

    /**
     * Create an Wigglytuff from the database.
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
    public Wigglytuff(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                      Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                      Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.NORMAL, Pokemon.Type.FAIRY, ability, nature, ExpType.FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT,
                firstSkill, secondSkill, thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    //TODO: HIDDEN FRISK
    @Override
    protected void initAbility() {
        if (Math.random() <= .5) {
            //TODO: IMPLEMENT CUTE CHARM
            ability = Ability.MAGIC_GUARD;
        } else {
            //TODO: COMPETITIVE
            ability = Ability.MAGIC_GUARD;
        }
    }

    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .75) {
            gender = 'F';
        } else {
            gender = 'M';
        }
    }

    /**
     * Init Wigglytuff's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.DOUBLE_EDGE);
        beginnerSkills.add(SkillFactory.PLAY_ROUGH);
        beginnerSkills.add(SkillFactory.SING);
        beginnerSkills.add(SkillFactory.DEFENSE_CURL);
        //TODO: DISABLE
        beginnerSkills.add(SkillFactory.DOUBLE_SLAP);
        levelUpSkills.put(0, beginnerSkills);
    }
}
