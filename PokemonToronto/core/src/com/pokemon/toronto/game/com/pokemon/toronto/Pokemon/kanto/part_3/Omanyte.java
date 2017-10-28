package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/21/2017.
 */

public class Omanyte extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 138;
    private static final String NAME = "Omanyte";
    private static final int BASE_EXP = 120;
    private static final int[] EV_YIELD = {0, 0, 1, 0, 0, 0};
    private static final int CAPTURE_RATE = 45;

    //Base Stats
    private static final int BASE_HEALTH = 35;
    private static final int BASE_ATTACK = 40;
    private static final int BASE_DEFENSE = 100;
    private static final int BASE_SPECIAL_ATTACK = 90;
    private static final int BASE_SPECIAL_DEFENSE = 55;
    private static final int BASE_SPEED = 35;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/omanyte.png";
    private static final String BACK_PATH = "battle/backs/omanyte.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/omanyte.png";
    private static final String CRY_PATH = "sounds/cry/138.wav";

    /**
     * Create a Omanyte with the specified level.
     * @param level The level of the Omanyte.
     */
    public Omanyte(int level) {
        super(NUMBER, NAME, level, Type.ROCK, Type.WATER, Ability.SWIFT_SWIM, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Omanyte from the database.
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
    public Omanyte(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                    Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                    Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.ROCK, Type.WATER, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Omanyte's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.CONSTRICT);
        beginnerSkills.add(SkillFactory.WITHDRAW);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_GUN)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROLLOUT)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEER)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_SHOT)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.BRINE)));
        //TODO: PROTECT 34
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.ANCIENT_POWER)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.TICKLE)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_BLAST)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHELL_SMASH)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYDRO_PUMP)));
    }

    /**
     * Return Omastar if Omanyte is 40
     * @return Omastar if Omanyte is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 40) {
            return PokemonId.OMASTAR.getValue();
        }
        return -1;
    }
}
