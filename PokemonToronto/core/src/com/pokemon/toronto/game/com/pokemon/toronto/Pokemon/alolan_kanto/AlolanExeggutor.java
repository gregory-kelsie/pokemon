package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 10/27/2017.
 */

public class AlolanExeggutor extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = -103;
    private static final String NAME = "Exeggutor";
    private static final int BASE_EXP = 212;
    private static final int[] EV_YIELD = {0, 0, 0, 2, 0, 0};
    private static final int CAPTURE_RATE = 45;

    //Base Stats
    private static final int BASE_HEALTH = 95;
    private static final int BASE_ATTACK = 105;
    private static final int BASE_DEFENSE = 85;
    private static final int BASE_SPECIAL_ATTACK = 125;
    private static final int BASE_SPECIAL_DEFENSE = 75;
    private static final int BASE_SPEED = 45;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/alolan_kanto/exeggutor.png";
    private static final String BACK_PATH = "battle/backs/alolan_kanto/exeggutor.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/alolan_kanto/exeggutor.png";
    private static final String CRY_PATH = "sounds/cry/103.wav";

    /**
     * Create a Exeggutor with the specified level.
     * @param level The level of the Exeggutor.
     */
    public AlolanExeggutor(int level) {
        super(NUMBER, NAME, level, Type.GRASS, Type.DRAGON, Ability.CHLOROPHYLL, ExpType.SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Exeggutor from the database.
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
    public AlolanExeggutor(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                     Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                     Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.GRASS, Type.DRAGON, ability, nature, ExpType.SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Exeggutor's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SEED_BOMB);
        beginnerSkills.add(SkillFactory.BARRAGE);
        beginnerSkills.add(SkillFactory.HYPNOSIS);
        beginnerSkills.add(SkillFactory.CONFUSION);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYSHOCK)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.EGG_BOMB)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.WOOD_HAMMER)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEAF_STORM)));
        initEvolutionSkills();

    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.DRAGON_HAMMER);
    }
}
