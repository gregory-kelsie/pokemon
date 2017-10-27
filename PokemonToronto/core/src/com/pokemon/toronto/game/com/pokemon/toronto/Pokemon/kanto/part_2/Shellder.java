package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/16/2017.
 */

public class Shellder extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 90;
    private static final String NAME = "Shellder";
    private static final int BASE_EXP = 97;
    private static final int[] EV_YIELD = {0, 0, 1, 0, 0, 0};
    private static final int CAPTURE_RATE = 190;

    //Base Stats
    private static final int BASE_HEALTH = 30;
    private static final int BASE_ATTACK = 65;
    private static final int BASE_DEFENSE = 100;
    private static final int BASE_SPECIAL_ATTACK = 45;
    private static final int BASE_SPECIAL_DEFENSE = 25;
    private static final int BASE_SPEED = 40;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/shellder.png";
    private static final String BACK_PATH = "battle/backs/shellder.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/shellder.png";
    private static final String CRY_PATH = "sounds/cry/090.wav";

    /**
     * Create a Shellder with the specified level.
     * @param level The level of the Shellder.
     */
    public Shellder(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.WATER, Type.NONE, Ability.SHELL_ARMOR, ExpType.SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Shellder from the database.
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
    public Shellder(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                  Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                  Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.WATER, Type.NONE, ability, nature, ExpType.SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Shellder's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.WATER_GUN);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.WITHDRAW)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPERSONIC)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICICLE_SPEAR)));
        //TODO: PROTECT 16
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEER)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.CLAMP)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICE_SHARD)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_SHELL)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.AURORA_BEAM)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.WHIRLPOOL)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.BRINE)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.IRON_DEFENSE)));
        levelUpSkills.put(52, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICE_BEAM)));
        levelUpSkills.put(56, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHELL_SMASH)));
        levelUpSkills.put(61, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYDRO_PUMP)));
    }

    /**
     * Return Cloyster if Shellder is has a Water Stone used
     * on it.
     * @return Cloyster if a Water Stone was used on Shellder.
     */
    @Override
    public int getWaterStoneEvolutionId() {
        return PokemonId.CLOYSTER.getValue();
    }
}
