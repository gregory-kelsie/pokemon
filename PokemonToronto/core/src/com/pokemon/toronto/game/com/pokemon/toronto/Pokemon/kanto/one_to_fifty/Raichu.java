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

public class Raichu extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 26;
    private static final String NAME = "Raichu";
    private static final int BASE_EXP = 122;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 3};
    private static final int CAPTURE_RATE = 75;

    //Base Stats
    private static final int BASE_HEALTH = 60;
    private static final int BASE_ATTACK = 90;
    private static final int BASE_DEFENSE = 55;
    private static final int BASE_SPECIAL_ATTACK = 90;
    private static final int BASE_SPECIAL_DEFENSE = 80;
    private static final int BASE_SPEED = 110;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/raichu.png";
    private static final String BACK_PATH = "battle/backs/raichu.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/raichu.png";
    private static final String CRY_PATH = "sounds/cry/026.wav";

    /**
     * Create a Raichu with the specified level.
     * @param level The level of the Raichu.
     */
    public Raichu(int level) {
        super(NUMBER, NAME, level, Type.ELECTRIC, Type.NONE, Ability.STATIC, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH, BACK_PATH, MINI_PATH,
                CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create a Raichu from the database.
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
    public Raichu(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                   Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                   Status status, Nature nature, Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.ELECTRIC, Type.NONE, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH, BACK_PATH, MINI_PATH,
                CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Raichu's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.THUNDER_SHOCK);
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
        beginnerSkills.add(SkillFactory.QUICK_ATTACK);
        beginnerSkills.add(SkillFactory.THUNDERBOLT);
        levelUpSkills.put(0, beginnerSkills);
    }
}
