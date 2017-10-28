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

public class Goldeen extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 118;
    private static final String NAME = "Goldeen";
    private static final int BASE_EXP = 111;
    private static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 225;

    //Base Stats
    private static final int BASE_HEALTH = 45;
    private static final int BASE_ATTACK = 67;
    private static final int BASE_DEFENSE = 60;
    private static final int BASE_SPECIAL_ATTACK = 35;
    private static final int BASE_SPECIAL_DEFENSE = 50;
    private static final int BASE_SPEED = 63;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/goldeen.png";
    private static final String BACK_PATH = "battle/backs/goldeen.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/goldeen.png";
    private static final String CRY_PATH = "sounds/cry/118.wav";

    /**
     * Create a Goldeen with the specified level.
     * @param level The level of the Goldeen.
     */
    public Goldeen(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.WATER, Pokemon.Type.NONE, Pokemon.Ability.SWIFT_SWIM, Pokemon.ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Goldeen from the database.
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
    public Goldeen(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                  Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                  Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Pokemon.Type.WATER, Pokemon.Type.NONE, ability, nature, Pokemon.ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Goldeen's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.PECK);
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
        beginnerSkills.add(SkillFactory.WATER_SPORT);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPERSONIC)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.HORN_ATTACK)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAIL)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_PULSE)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_RING)));
        levelUpSkills.put(24, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_ATTACK)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATERFALL)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.HORN_DRILL)));
        //TODO: SOAK 40
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEGAHORN)));
    }

    /**
     * Return Seaking if Goldeen is 32
     * @return Seaking if Goldeen is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 33) {
            return PokemonId.SEAKING.getValue();
        }
        return -1;
    }
}
