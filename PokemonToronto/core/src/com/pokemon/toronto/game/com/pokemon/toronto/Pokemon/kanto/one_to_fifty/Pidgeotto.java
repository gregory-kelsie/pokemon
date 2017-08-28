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

public class Pidgeotto extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 17;
    private static final String NAME = "Pidgeotto";
    private static final int BASE_EXP = 113;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 2};
    private static final int CAPTURE_RATE = 120;

    //Base Stats
    private static final int BASE_HEALTH = 63;
    private static final int BASE_ATTACK = 60;
    private static final int BASE_DEFENSE = 55;
    private static final int BASE_SPECIAL_ATTACK = 50;
    private static final int BASE_SPECIAL_DEFENSE = 50;
    private static final int BASE_SPEED = 71;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/pidgeotto.png";
    private static final String BACK_PATH = "battle/backs/pidgeotto.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/pidgeotto.png";
    private static final String CRY_PATH = "sounds/cry/017.wav";

    /**
     * Create a Pidgeotto with the specified level.
     * @param level The level of the Pidgeotto.
     */
    public Pidgeotto(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.NORMAL, Pokemon.Type.FLYING, Ability.KEEN_EYE, Pokemon.ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
        initLevelUpSkills();
        initWildSkills();
    }

    /**
     * Create an Pidgeotto from the database.
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
    public Pidgeotto(int level, int[] ivs, int [] evs, Skill firstSkill,
                      Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                      Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, Pokemon.Type.NORMAL, Pokemon.Type.FLYING, Ability.KEEN_EYE, Pokemon.ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
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
     * Init Pidgeotto's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.SAND_ATTACK);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAND_ATTACK)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
    }
}
