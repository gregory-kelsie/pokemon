package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 8/16/2017.
 */

public class Diglett extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 50;
    private static final String NAME = "Diglett";
    private static final int BASE_EXP = 53;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    private static final int CAPTURE_RATE = 255;

    //Base Stats
    private static final int BASE_HEALTH = 10;
    private static final int BASE_ATTACK = 55;
    private static final int BASE_DEFENSE = 25;
    private static final int BASE_SPECIAL_ATTACK = 35;
    private static final int BASE_SPECIAL_DEFENSE = 45;
    private static final int BASE_SPEED = 95;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/diglett.png";
    private static final String BACK_PATH = "battle/backs/diglett.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/diglett.png";
    private static final String CRY_PATH = "sounds/cry/050.wav";

    /**
     * Create a Diglett with the specified level.
     * @param level The level of the Diglett.
     */
    public Diglett(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.GROUND, Pokemon.Type.NONE, Ability.SAND_VEIL, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Diglett from the database.
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
    public Diglett(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                    Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                    Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.GROUND, Type.NONE, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Diglett's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SAND_ATTACK);
        beginnerSkills.add(SkillFactory.SCRATCH);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWL)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.ASTONISH)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_SLAP)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.MAGNITUDE)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.BULLDOZE)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUCKER_PUNCH)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_BOMB)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.EARTH_POWER)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.DIG)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.EARTHQUAKE)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.FISSURE)));
    }

    /**
     * Return Arbok if the Ekans is above level 22.
     * @return Arbok if Ekans is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 26) {
            return PokemonId.DUGTRIO.getValue();
        }
        return -1;
    }
}
