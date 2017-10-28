package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2;

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

public class Bellsprout extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 69;
    private static final String NAME = "Bellsprout";
    private static final int BASE_EXP = 84;
    private static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 255;

    //Base Stats
    private static final int BASE_HEALTH = 50;
    private static final int BASE_ATTACK = 75;
    private static final int BASE_DEFENSE = 35;
    private static final int BASE_SPECIAL_ATTACK = 70;
    private static final int BASE_SPECIAL_DEFENSE = 30;
    private static final int BASE_SPEED = 40;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/bellsprout.png";
    private static final String BACK_PATH = "battle/backs/bellsprout.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/bellsprout.png";
    private static final String CRY_PATH = "sounds/cry/069.wav";

    /**
     * Create a Bellsprout with the specified level.
     * @param level The level of the Bellsprout.
     */
    public Bellsprout(int level) {
        super(NUMBER, NAME, level, Type.GRASS, Pokemon.Type.POISON, Ability.CHLOROPHYLL, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Bellsprout from the database.
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
    public Bellsprout(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                   Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                   Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.GRASS, Type.POISON, ability, nature, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Bellsprout's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.VINE_WHIP);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWTH)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.WRAP)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLEEP_POWDER)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_POWDER)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.STUN_SPORE)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.ACID)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.KNOCK_OFF)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWEET_SCENT)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.GASTRO_ACID)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_LEAF)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_JAB)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLAM)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.WRING_OUT)));
    }

    /**
     * Return Weepinbell if Bellsprout is 21
     * @return Weepinbell if Bellsprout is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 21) {
            return PokemonId.WEEPINBELL.getValue();
        }
        return -1;
    }
}
