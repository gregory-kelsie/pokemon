package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/16/2017.
 */

public class Ponyta extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 77;
    private static final String NAME = "Ponyta";
    private static final int BASE_EXP = 152;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    private static final int CAPTURE_RATE = 190;

    //Base Stats
    private static final int BASE_HEALTH = 50;
    private static final int BASE_ATTACK = 85;
    private static final int BASE_DEFENSE = 55;
    private static final int BASE_SPECIAL_ATTACK = 65;
    private static final int BASE_SPECIAL_DEFENSE = 65;
    private static final int BASE_SPEED = 90;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/ponyta.png";
    private static final String BACK_PATH = "battle/backs/ponyta.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/ponyta.png";
    private static final String CRY_PATH = "sounds/cry/077.wav";

    /**
     * Create a Ponyta with the specified level.
     * @param level The level of the Ponyta.
     */
    public Ponyta(int level) {
        super(NUMBER, NAME, level, Type.FIRE, Pokemon.Type.NONE, Ability.FLAME_BODY, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Ponyta from the database.
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
    public Ponyta(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                   Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                   Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.FIRE, Type.NONE, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Ponyta's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.GROWL);
        beginnerSkills.add(SkillFactory.TACKLE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAIL_WHIP)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.EMBER)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAME_WHEEL)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.STOMP)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAME_CHARGE)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.FIRE_SPIN)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.INFERNO)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.FIRE_BLAST)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.BOUNCE)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLARE_BLITZ)));
    }

    /**
     * Return Rapidash if Ponyta is 40
     * @return Rapidash if Ponyta is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 40) {
            return PokemonId.RAPIDASH.getValue();
        }
        return -1;
    }
}
