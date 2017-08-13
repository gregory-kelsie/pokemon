package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/14/2017.
 */
public class Charizard extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 6;
    private static final String NAME = "Charizard";
    private static final int BASE_EXP = 54;
    private static final int[] EV_YIELD = {0, 0, 0, 3, 0, 0};
    private static final int CAPTURE_RATE = 45;

    //Base Stats
    private static final int BASE_HEALTH = 78;
    private static final int BASE_ATTACK = 84;
    private static final int BASE_DEFENSE = 78;
    private static final int BASE_SPECIAL_ATTACK = 109;
    private static final int BASE_SPECIAL_DEFENSE = 85;
    private static final int BASE_SPEED = 100;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/charizard/charizard.png";
    private static final String BACK_PATH = "battle/backs/charizard.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/charizard.png";

    /**
     * Create a Charizard with the specified level.
     * @param level The level of the Charizard.
     */
    public Charizard(int level) {
        super(NUMBER, NAME, level, Type.FIRE, Type.FLYING, Ability.BLAZE, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CAPTURE_RATE);
        initLevelUpSkills();
        initWildSkills();
    }

    /**
     * Create an Charizard from the database or evolution.
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
    public Charizard(int level, int[] ivs, int [] evs, Skill firstSkill,
                    Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                    Status status, Nature nature, Ability ability) {
        super(NUMBER, NAME, level, Type.FIRE, Type.FLYING, Ability.BLAZE, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CAPTURE_RATE);
        initLevelUpSkills();
        addSkills(firstSkill, secondSkill, thirdSkill, fourthSkill);
        setHealthAndExp(currentHealth, currentExp);
        this.evs = evs;
        this.ivs = ivs;
        this.status = status;
        this.nature = nature;
        this.ability = ability;
    }

    /**
     * Init Charizard's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SCRATCH);
        beginnerSkills.add(SkillFactory.GROWL);
        levelUpSkills.put(0, beginnerSkills);
    }

    /**
     * Init Charizard's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .875) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }
}
