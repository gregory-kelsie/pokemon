package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 10/27/2017.
 */

public class AlolanGeodude extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = -74;
    private static final String NAME = "Geodude";
    private static final int BASE_EXP = 73;
    private static final int[] EV_YIELD = {0, 0, 1, 0, 0, 0};
    private static final int CAPTURE_RATE = 255;

    //Base Stats
    private static final int BASE_HEALTH = 40;
    private static final int BASE_ATTACK = 80;
    private static final int BASE_DEFENSE = 100;
    private static final int BASE_SPECIAL_ATTACK = 30;
    private static final int BASE_SPECIAL_DEFENSE = 30;
    private static final int BASE_SPEED = 20;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/alolan_kanto/geodude.png";
    private static final String BACK_PATH = "battle/backs/alolan_kanto/geodude.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/alolan_kanto/geodude.png";
    private static final String CRY_PATH = "sounds/cry/074.wav";
    /**
     * Create a Geodude with the specified level.
     * @param level The level of the Geodude.
     */
    public AlolanGeodude(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.ROCK, Type.ELECTRIC, Pokemon.Ability.STURDY, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Geodude from the database or through evolution.
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
    public AlolanGeodude(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                   Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                   Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Pokemon.Type.ROCK, Type.ELECTRIC, ability, nature, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Geodude's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.DEFENSE_CURL);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARGE)));
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_POLISH)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROLLOUT)));
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.SPARK)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_THROW)));
        //TODO: SMACK DOWN 18
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER_PUNCH)));
        levelUpSkills.put(24, new ArrayList<Integer>(Arrays.asList(SkillFactory.SELF_DESTRUCT)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.STEALTH_ROCK)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_BLAST)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISCHARGE)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.EXPLOSION)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
        levelUpSkills.put(42, new ArrayList<Integer>(Arrays.asList(SkillFactory.STONE_EDGE)));
    }

    /**
     * Determine Geodude's gender.
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
     * Return Graveler if Geodude is 25
     * @return Graveler if Geodude is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 25) {
            return PokemonId.ALOLAN_GRAVELER.getValue();
        }
        return -1;
    }
}
