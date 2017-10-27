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

public class Grimer extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 88;
    private static final String NAME = "Grimer";
    private static final int BASE_EXP = 90;
    private static final int[] EV_YIELD = {1, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 190;

    //Base Stats
    private static final int BASE_HEALTH = 80;
    private static final int BASE_ATTACK = 80;
    private static final int BASE_DEFENSE = 50;
    private static final int BASE_SPECIAL_ATTACK = 40;
    private static final int BASE_SPECIAL_DEFENSE = 50;
    private static final int BASE_SPEED = 25;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/grimer.png";
    private static final String BACK_PATH = "battle/backs/grimer.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/grimer.png";
    private static final String CRY_PATH = "sounds/cry/088.wav";

    /**
     * Create a Grimer with the specified level.
     * @param level The level of the Grimer.
     */
    public Grimer(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.POISON, Type.NONE, Ability.POISON_TOUCH, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Grimer from the database.
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
    public Grimer(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.POISON, Type.NONE, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Grimer's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.POUND);
        beginnerSkills.add(SkillFactory.POISON_GAS);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.HARDEN)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_SLAP)));
        //TODO: DISABLE 12
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLUDGE)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_BOMB)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.MINIMIZE)));
        //TODO: FLING 26
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLUDGE_BOMB)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLUDGE_WAVE)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCREECH)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.GUNK_SHOT)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.ACID_ARMOR)));
        //TODO: BELCH 46
        levelUpSkills.put(48, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEMENTO)));
    }

    /**
     * Return Muk if Grimer is 38
     * @return Muk if Grimer is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 38) {
            return PokemonId.MUK.getValue();
        }
        return -1;
    }
}
