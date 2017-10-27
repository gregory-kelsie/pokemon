package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 6/14/2017.
 */
public class Charmander extends Pokemon {

    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 4;
    private static final String NAME = "Charmander";
    private static final int BASE_EXP = 54;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    private static final int CAPTURE_RATE = 45;

    //Base Stats
    private static final int BASE_HEALTH = 39;
    private static final int BASE_ATTACK = 52;
    private static final int BASE_DEFENSE = 43;
    private static final int BASE_SPECIAL_ATTACK = 60;
    private static final int BASE_SPECIAL_DEFENSE = 50;
    private static final int BASE_SPEED = 65;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/charmander/charmander.png";
    private static final String BACK_PATH = "battle/backs/charmander.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/charmander.png";
    private static final String CRY_PATH = "sounds/cry/004.wav";

    /**
     * Create a Charmander with the specified level.
     * @param level The level of the Charmander.
     */
    public Charmander(int level) {
        super(NUMBER, NAME, level, Type.FIRE, Type.NONE, Ability.BLAZE, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Charmander from the database.
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
    public Charmander(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                     Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                     Status status, Nature nature, Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.FIRE, Type.NONE, ability, nature, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Charmander's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SCRATCH);
        beginnerSkills.add(SkillFactory.GROWL);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.EMBER)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.SMOKESCREEN)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_RAGE)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCARY_FACE)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.FIRE_FANG)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAME_BURST)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAMETHROWER)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.FIRE_SPIN)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.INFERNO)));
    }

    /**
     * Init Charmander's gender.
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

    /**
     * Return Charmeleon if the Charmander is above level 16.
     * @return Charmeleon if Charmander is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 16) {
            return PokemonId.CHARMELEON.getValue();
        }
        return -1;
    }
}
