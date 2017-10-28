package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/27/2017.
 */

public class AlolanSandslash extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = -28;
    private static final String NAME = "Sandslash";
    private static final int BASE_EXP = 163;
    private static final int[] EV_YIELD = {0, 0, 2, 0, 0, 0};
    private static final int CAPTURE_RATE = 90;

    //Base Stats
    private static final int BASE_HEALTH = 75;
    private static final int BASE_ATTACK = 100;
    private static final int BASE_DEFENSE = 120;
    private static final int BASE_SPECIAL_ATTACK = 25;
    private static final int BASE_SPECIAL_DEFENSE = 65;
    private static final int BASE_SPEED = 65;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/alolan_kanto/sandslash.png";
    private static final String BACK_PATH = "battle/backs/alolan_kanto/sandslash.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/alolan_kanto/sandslash.png";
    private static final String CRY_PATH = "sounds/cry/028.wav";

    /**
     * Create a Sandslash with the specified level.
     * @param level The level of the Sandslash.
     */
    public AlolanSandslash(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.ICE, Type.STEEL, Ability.SNOW_CLOAK, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Sandslash from the database.
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
    public AlolanSandslash(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                     Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                     Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.ICE, Type.STEEL, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Sandslash's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.METAL_BURST);
        beginnerSkills.add(SkillFactory.ICICLE_CRASH);
        beginnerSkills.add(SkillFactory.SLASH);
        beginnerSkills.add(SkillFactory.DEFENSE_CURL);
        beginnerSkills.add(SkillFactory.ICE_BALL);
        beginnerSkills.add(SkillFactory.METAL_CLAW);
        levelUpSkills.put(0, beginnerSkills);
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.ICICLE_SPEAR);
    }
}
