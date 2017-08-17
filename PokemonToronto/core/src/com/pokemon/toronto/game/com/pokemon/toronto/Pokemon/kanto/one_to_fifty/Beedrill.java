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

public class Beedrill extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 15;
    private static final String NAME = "Beedrill";
    private static final int BASE_EXP = 159;
    private static final int[] EV_YIELD = {0, 2, 0, 0, 1, 0};
    private static final int CAPTURE_RATE = 45;

    //Base Stats
    private static final int BASE_HEALTH = 65;
    private static final int BASE_ATTACK = 90;
    private static final int BASE_DEFENSE = 40;
    private static final int BASE_SPECIAL_ATTACK = 45;
    private static final int BASE_SPECIAL_DEFENSE = 80;
    private static final int BASE_SPEED = 75;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/beedrill.png";
    private static final String BACK_PATH = "battle/backs/beedrill.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/beedrill.png";

    /**
     * Create a Beedrill with the specified level.
     * @param level The level of the Beedrill.
     */
    public Beedrill(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.BUG, Pokemon.Type.POISON, Ability.SWARM, Pokemon.ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CAPTURE_RATE);
        initLevelUpSkills();
        initWildSkills();
    }

    /**
     * Create an Beedrill from the database.
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
    public Beedrill(int level, int[] ivs, int [] evs, Skill firstSkill,
                      Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                      Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, Pokemon.Type.BUG, Pokemon.Type.POISON, Ability.SWARM, Pokemon.ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CAPTURE_RATE);
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
     * Init Beedrill's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.FOCUS_ENERGY)));
    }
}
