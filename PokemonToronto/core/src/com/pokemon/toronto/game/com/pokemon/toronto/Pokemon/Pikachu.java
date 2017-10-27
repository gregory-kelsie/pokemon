package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 6/11/2017.
 */
public class Pikachu extends Pokemon {

    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 25;
    private static final String NAME = "Pikachu";
    private static final int BASE_EXP = 82;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 2};
    private static final int CAPTURE_RATE = 190;

    //Base Stats
    private static final int BASE_HEALTH = 35;
    private static final int BASE_ATTACK = 55;
    private static final int BASE_DEFENSE = 40;
    private static final int BASE_SPECIAL_ATTACK = 50;
    private static final int BASE_SPECIAL_DEFENSE = 50;
    private static final int BASE_SPEED = 90;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/pikachu/pikachu.png";
    private static final String BACK_PATH = "battle/backs/pikachu.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/pikachu.png";
    private static final String CRY_PATH = "sounds/cry/025.wav";

    /**
     * Create a Pikachu with the specified level.
     * @param level The level of the Pikachu.
     */
    public Pikachu(int level) {
        super(NUMBER, NAME, level, Type.ELECTRIC, Type.NONE, Ability.STATIC, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH, BACK_PATH, MINI_PATH,
                CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create a Pikachu from the database.
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
    public Pikachu(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                  Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                  Status status, Nature nature, Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.ELECTRIC, Type.NONE, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH, BACK_PATH, MINI_PATH,
                CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Pikachu's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
        beginnerSkills.add(SkillFactory.THUNDER_SHOCK);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWL)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.PLAY_NICE)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.ELECTRO_BALL)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER_WAVE)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_TEAM)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.SPARK)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.NUZZLE)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISCHARGE)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLAM)));
        levelUpSkills.put(42, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDERBOLT)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.WILD_CHARGE)));
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.LIGHT_SCREEN)));
        levelUpSkills.put(58, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER)));
    }

    /**
     * Init Pikachu's gender.
     */
    @Override
    protected void initGender() {
        int genderProbability = (int)(Math.round(Math.random() * 100));
        if (genderProbability <= 50) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

    /**
     * Return Raichu's id when a thunderstone is used on Pikachu
     * @return Raichu's id.
     */
    @Override
    public int getThunderStoneEvolutionId() {
        return PokemonId.RAICHU.getValue();
    }
}
