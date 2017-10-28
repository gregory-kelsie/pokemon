package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/21/2017.
 */

public class Jynx extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 124;
    private static final String NAME = "Jynx";
    private static final int BASE_EXP = 137;
    private static final int[] EV_YIELD = {0, 0, 0, 2, 0, 0};
    private static final int CAPTURE_RATE = 45;

    //Base Stats
    private static final int BASE_HEALTH = 65;
    private static final int BASE_ATTACK = 50;
    private static final int BASE_DEFENSE = 35;
    private static final int BASE_SPECIAL_ATTACK = 115;
    private static final int BASE_SPECIAL_DEFENSE = 95;
    private static final int BASE_SPEED = 95;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/jynx.png";
    private static final String BACK_PATH = "battle/backs/jynx.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/jynx.png";
    private static final String CRY_PATH = "sounds/cry/124.wav";

    /**
     * Create a Jynx with the specified level.
     * @param level The level of the Jynx.
     */
    public Jynx(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.ICE, Type.PSYCHIC, Ability.DRY_SKIN, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Jynx from the database.
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
    public Jynx(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                  Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                  Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Pokemon.Type.ICE, Type.PSYCHIC, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Jynx's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.DRAINING_KISS);
        //TODO: PERISH SONG
        beginnerSkills.add(SkillFactory.POUND);
        beginnerSkills.add(SkillFactory.LICK);
        beginnerSkills.add(SkillFactory.LOVELY_KISS);
        beginnerSkills.add(SkillFactory.POWDER_SNOW);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.LICK)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.LOVELY_KISS)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.POWDER_SNOW)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_SLAP)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICE_PUNCH)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEART_STAMP)));
        //TODO: MEAN LOOK 25
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.FAKE_TEARS)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.WAKE_UP_SLAP)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.AVALANCHE)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.BODY_SLAM)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.WRING_OUT)));
        //TODO: PERISH SONG 55
        levelUpSkills.put(60, new ArrayList<Integer>(Arrays.asList(SkillFactory.BLIZZARD)));
    }

}
