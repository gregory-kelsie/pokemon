package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Gregory on 6/11/2017.
 */
public class Pidgey extends Pokemon {

    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 16;
    private static final String NAME = "Pidgey";
    private static final int BASE_EXP = 55;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    private static final int CAPTURE_RATE = 255;

    //Base Stats
    private static final int BASE_HEALTH = 40;
    private static final int BASE_ATTACK = 45;
    private static final int BASE_DEFENSE = 40;
    private static final int BASE_SPECIAL_ATTACK = 35;
    private static final int BASE_SPECIAL_DEFENSE = 35;
    private static final int BASE_SPEED = 56;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/pidgey/pidgey.png";
    private static final String BACK_PATH = "battle/backs/pidgey.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/pidgey.png";
    private static final String CRY_PATH = "sounds/cry/016.wav";

    /**
     * Create a Pidgey with the specified level.
     * @param level The level of the Pidgey.
     */
    public Pidgey(int level) {
        super(NUMBER, NAME, level, Type.NORMAL, Type.FLYING, Ability.KEEN_EYE, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH, BACK_PATH, MINI_PATH,
                CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create a Pidgey from the database.
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
    public Pidgey(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                    Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                    Status status, Nature nature, Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.NORMAL, Type.FLYING, ability, nature, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH, BACK_PATH, MINI_PATH,
                CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Pidgey's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        levelUpSkills.put(0, new ArrayList<Integer>(Arrays.asList(SkillFactory.TACKLE)));
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAND_ATTACK)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
    }

    /**
     * Init Pidgey's gender.
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
     * Return Pidgeotto if the Pidgey is above level 18.
     * @return Pidgeotto if Pidgey is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 18) {
            return PokemonId.PIDGEOTTO.getValue();
        }
        return -1;
    }
}
