package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 8/16/2017.
 */

public class Vileplume extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 45;
    private static final String NAME = "Vileplume";
    private static final int BASE_EXP = 184;
    private static final int[] EV_YIELD = {0, 0, 0, 3, 0, 0};
    private static final int CAPTURE_RATE = 45;

    //Base Stats
    private static final int BASE_HEALTH = 75;
    private static final int BASE_ATTACK = 80;
    private static final int BASE_DEFENSE = 85;
    private static final int BASE_SPECIAL_ATTACK = 110;
    private static final int BASE_SPECIAL_DEFENSE = 90;
    private static final int BASE_SPEED = 50;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/vileplume.png";
    private static final String BACK_PATH = "battle/backs/vileplume.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/vileplume.png";
    private static final String CRY_PATH = "sounds/cry/045.wav";

    /**
     * Create a Vileplume with the specified level.
     * @param level The level of the Vileplume.
     */
    public Vileplume(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.GRASS, Pokemon.Type.POISON, Ability.CHLOROPHYLL, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Vileplume from the database.
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
    public Vileplume(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                 Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                 Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Pokemon.Type.GRASS, Type.POISON, ability, nature, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Vileplume's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE); //TODO: Implement right skills
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(59, new ArrayList<Integer>(Arrays.asList(SkillFactory.PETAL_DANCE)));
    }
}
